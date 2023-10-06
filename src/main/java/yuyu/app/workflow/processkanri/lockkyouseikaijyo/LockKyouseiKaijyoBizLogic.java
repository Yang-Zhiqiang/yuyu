package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.GetLockedTaskListResultBean;
import yuyu.common.workflow.workflowutility.UnlockProcessForceResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 工程ロック強制解除 のビジネスロジックです。
 */
public class LockKyouseiKaijyoBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private LockKyouseiKaijyoUiBean uiBean;

    void init() {
        logger.info("工程ロック強制解除機能を起動しました。");
        clear();
        BizPropertyInitializer.initialize(uiBean);

        setSubSystemInfoList();

        setJimuTetuzukiInfoList();
    }

    void clear() {
        uiBean.setSyono(null);
        uiBean.setNksysyno(null);
        uiBean.setJimutetuzukicd(null);
        uiBean.setSubSystemId(null);

        uiBean.clearJimutetuzukicdOptionBeanList();
        uiBean.clearSubSystemIdOptionBeanList();

        uiBean.getLockedTaskInfoListDataSource().setDatas(null);
    }

    void processSearch() {
        logger.info("工程ロック強制解除機能 検索を起動しました。");

        String wkSubSystemId = uiBean.getSubSystemId();
        String wkFlowId = uiBean.getJimutetuzukicd().substring(
            uiBean.getJimutetuzukicd().lastIndexOf(LockKyouseiKaijyoConstants.SPLITTER) + 1);
        String wkMosno = LockKyouseiKaijyoConstants.BLANK;
        String wkSyoNo = LockKyouseiKaijyoConstants.BLANK;
        String wkNkSysyNo = LockKyouseiKaijyoConstants.BLANK;

        if (wkSubSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.SINKEIYAKU.getName())) {
            if (!BizUtil.isBlank(uiBean.getMosno())) {
                wkMosno = uiBean.getMosno();
            }
        } else if (wkSubSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.NENKINSIHARAI.getName())) {
            if (!BizUtil.isBlank(uiBean.getNksysyno())) {
                wkNkSysyNo = uiBean.getNksysyno();
            }
        } else {
            if (!BizUtil.isBlank(uiBean.getSyono())) {
                wkSyoNo = uiBean.getSyono();
            }
        }
        logger.debug("============================================");
        logger.debug("検索条件取得データ取得確認");
        logger.debug("サブシステムID：" + wkSubSystemId);
        logger.debug("事務手続：" + wkFlowId);
        logger.debug("申込番号：" + wkMosno);
        logger.debug("証券番号：" + wkSyoNo);
        logger.debug("年金証書番号：" + wkNkSysyNo);
        logger.debug("============================================");

        uiBean.setLockedTaskInfoList(null);

        GetLockedTaskListResultBean resultBean = WorkFlowUtility.getLockedTasksInfoList(
            new String[] {wkMosno},
            new String[] {wkSyoNo},
            new String[] {wkNkSysyNo},
            new String[] {wkFlowId},
            baseUserInfo.getUserId(),
            null);

        if (!resultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            if (resultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA)) {
                messageManager.addMessageId(MessageId.IAC0021, LockKyouseiKaijyoConstants.MESSAGE_ANKEN);
                return;
            } else if (resultBean.getSyousaiMessageCd().equals(LockKyouseiKaijyoConstants.MAX_OVER)) {
                messageManager.addMessageId(MessageId.IBF0024);
                return;
            } else {
                throw new BizAppException(MessageId.EAS0037);
            }
        }

        int count = resultBean.getLockedTaskSummaryBeanList().size();

        List<LockedTaskInfoListDataSourceBean> wkLockedTaskInfoList = new ArrayList<LockedTaskInfoListDataSourceBean>();
        LockedTaskInfoListDataSourceBean WK;

        for(int i=0;i<count;i++){
            WK = new LockedTaskInfoListDataSourceBean();
            if (wkSubSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.SINKEIYAKU.getName())) {
                WK.setDispGyoumuKey(resultBean.getLockedTaskSummaryBeanList().get(i).getMosNo());
            } else if (wkSubSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.NENKINSIHARAI.getName())) {
                WK.setDispGyoumuKey(resultBean.getLockedTaskSummaryBeanList().get(i).getNkSysyNo());
            } else {
                WK.setDispGyoumuKey(resultBean.getLockedTaskSummaryBeanList().get(i).getSyoNo());
            }
            WK.setDispjimustartymd(resultBean.getLockedTaskSummaryBeanList().get(i).getJimuStartYmd());
            WK.setDisptantounm(resultBean.getLockedTaskSummaryBeanList().get(i).getDispNowSyoriTantouNm());
            WK.setDisptasknm(resultBean.getLockedTaskSummaryBeanList().get(i).getNowTaskLocalNm());
            WK.setLockKaijyoLink(LockKyouseiKaijyoConstants.LOCK_KAIJO_LINK);

            WK.setKouteiKnrId(resultBean.getLockedTaskSummaryBeanList().get(i).getKouteiKnrId());
            WK.setFlowId(resultBean.getLockedTaskSummaryBeanList().get(i).getJimutetuzukiCd());
            wkLockedTaskInfoList.add(WK);
        }

        uiBean.setLockedTaskInfoList(wkLockedTaskInfoList);

        String subSystemId = uiBean.getSubSystemId();
        uiBean.setSaveSubSystemId(subSystemId);
        if (subSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.SINKEIYAKU.getName())) {
            uiBean.setGyoumukeylbl(LockKyouseiKaijyoConstants.LBL_GYOUMUKEY_SINKEIYAKU);
        }else if (subSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.KEIYAKUHOZEN.getName())) {
            uiBean.setGyoumukeylbl(LockKyouseiKaijyoConstants.LBL_GYOUMUKEY_KEIYAKUHOZEN);
        }else if (subSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
            uiBean.setGyoumukeylbl(LockKyouseiKaijyoConstants.LBL_GYOUMUKEY_HOKENKYUHUSIHARAI);
        }else {
            uiBean.setGyoumukeylbl(LockKyouseiKaijyoConstants.LBL_GYOUMUKEY_NENKINSIHARAI);
        }
        logger.info("工程ロック強制解除機能 検索を終了しました。");
    }

    @Transactional
    void forceUnlock() {
        logger.info("工程ロック強制解除機能 ロック解除を起動しました。");
        LockedTaskInfoListDataSourceBean selectedBean = uiBean.getLockedTaskInfoListDataSource().getSelectedBean();

        String wkSubSystemId = uiBean.getSaveSubSystemId();
        String wkSyoNo = LockKyouseiKaijyoConstants.BLANK;
        String wkNkSysyNo = LockKyouseiKaijyoConstants.BLANK;
        String wkKouteiKnrId = LockKyouseiKaijyoConstants.BLANK;
        String wkFlowId = selectedBean.getFlowId();
        if (wkSubSystemId.equals(LockKyouseiKaijyoConstants.E_SubSystem.NENKINSIHARAI.getName())) {
            wkNkSysyNo = selectedBean.getDispGyoumuKey();
        } else {
            wkSyoNo = selectedBean.getDispGyoumuKey();
        }
        wkKouteiKnrId = selectedBean.getKouteiKnrId();
        logger.debug("============================================");
        logger.debug("押下されたデータ取得確認");
        logger.debug("証券番号：" + wkSyoNo);
        logger.debug("年金証書番号：" + wkNkSysyNo);
        logger.debug("工程管理ID：" + wkKouteiKnrId);
        logger.debug("事務手続：" + wkFlowId);
        logger.debug("============================================");

        UnlockProcessForceResultBean resultBean = WorkFlowUtility.unlockProcessForce(wkKouteiKnrId, wkFlowId);

        if (!resultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            if ("IWF2201".equals(resultBean.getSyousaiMessageCd())) {
                throw new BizLogicException(MessageId.EDF1009);
            }
            else if ("IWF2202".equals(resultBean.getSyousaiMessageCd())) {
                throw new BizLogicException(MessageId.EDF1010);
            }
            else {
                throw new BizAppException(MessageId.EAS0037);
            }
        }

        selectedBean.setLockKaijyoLink(LockKyouseiKaijyoConstants.BLANK);
        logger.info("工程ロック強制解除機能 ロック解除を終了しました。");
    }


    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    LockKyouseiKaijyoConstants.BLANK,
                    LockKyouseiKaijyoConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

    private void setSubSystemInfoList() {

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectInBean getExecutableSubSystemsSelectInBean = SWAKInjector.getInstance(GetExecutableSubSystemsSelectInBean.class);
        getExecutableSubSystemsSelectInBean.setUserId(baseUserInfo.getUserId());
        getExecutableSubSystemsSelectInBean.setBlankUmu(true);
        GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectOutBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(getExecutableSubSystemsSelectInBean);
        uiBean.setSubSystemIdOptionBeanList(getExecutableSubSystemsSelectOutBean.getUserDefsList());

    }

    private void setJimuTetuzukiInfoList() {

        if (uiBean.getSubSystemIdOptionBeanList().size() <= 1) {
            uiBean.clearJimutetuzukicdOptionBeanList();
        } else {
            List<String> wkList = new ArrayList<String>();
            for (int i = 0; i < uiBean.getSubSystemIdOptionBeanList().size(); i++) {
                if (!uiBean.getSubSystemIdOptionBeanList().get(i).getValue().equals(LockKyouseiKaijyoConstants.BLANK)){
                    wkList.add(uiBean.getSubSystemIdOptionBeanList().get(i).getValue());
                }
            }
            String[] wkSubsystemId = wkList.toArray(new String[0]);

            uiBean.setJimutetuzukicdOptionBeanList(
                insertBlank(
                    Iterables.transform(
                        workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(wkSubsystemId)
                        ,
                        new Function<DM_Jimutetuzuki, LabelValuePair>() {
                            @Override
                            public LabelValuePair apply(DM_Jimutetuzuki jimutetuzuki) {
                                return new LabelValuePair(
                                    jimutetuzuki.getJimutetuzukinm(),
                                    jimutetuzuki.getSubSystemId() + LockKyouseiKaijyoConstants.SPLITTER +
                                    jimutetuzuki.getJimutetuzukicd()
                                    );
                            }
                        }
                        )
                    )
                );
        }
    }
}
