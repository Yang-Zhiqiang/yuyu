package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.GetTasksForJimuyouCdResultBean;
import yuyu.common.workflow.workflowutility.PutJimuyouCdBean;
import yuyu.common.workflow.workflowutility.PutJimuyouCdResultBean;
import yuyu.common.workflow.workflowutility.TaskSummaryForJimuyouCdBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 事務用コード入力 のビジネスロジックです。
 */
public class JimuyouCodeNyuuryokuBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private JimuyouCodeNyuuryokuUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    List<LockProcessInBean> lockProcessInBeanList;
    void init() {
        logger.info("事務用コード入力機能を起動しました。");
        clear();
        BizPropertyInitializer.initialize(uiBean);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectInBean getExecutableSubSystemsSelectInBean = SWAKInjector.getInstance(GetExecutableSubSystemsSelectInBean.class);

        getExecutableSubSystemsSelectInBean.setUserId(baseUserInfo.getUserId());
        getExecutableSubSystemsSelectInBean.setBlankUmu(true);
        GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectOutBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(getExecutableSubSystemsSelectInBean);
        uiBean.setSubSystemIdOptionBeanList(getExecutableSubSystemsSelectOutBean.getUserDefsList());


        String[] pSubSystemId = getExecutableSubSystemsSelectOutBean.getSubSystemIdNameArray();
        if(pSubSystemId.length ==0) {
            return;
        }

        uiBean.setJimutetuzukicdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    workflowDomManager.getJimutetuzukisBySubSystemIdsSyukouteijimutetuzukicd(pSubSystemId)
                    ,
                    new Function<DM_Jimutetuzuki, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(DM_Jimutetuzuki jimutetuzuki) {
                            return new LabelValuePair(
                                jimutetuzuki.getJimutetuzukinm(),
                                jimutetuzuki.getSubSystemId() + "." +
                                jimutetuzuki.getJimutetuzukicd()
                                );
                        }
                    }
                    )
                )
            );

    }

    void clear() {
        uiBean.setSubSystemId(null);
        uiBean.setJimutetuzukicd(null);
        uiBean.setResultSubSystemId(null);
        uiBean.setResultJimutetuduki(null);
        uiBean.setKetteiBtnFlg(null);

        uiBean.clearSubSystemIdOptionBeanList();
        uiBean.clearJimutetuzukicdOptionBeanList();

        uiBean.getJimuyouCodeListDataSource().setDatas(null);
        uiBean.getJimuyouCodeList2DataSource().setDatas(null);
    }

    void jimuyoucdNyuuryokuListCreate() {
        logger.info("事務用コード入力機能 入力リスト作成を起動しました。");

        String wkSubSystemId = uiBean.getSubSystemId();
        String wkJimutetuzukicd = uiBean.getJimutetuzukicd();

        List<JimuyouCodeListDataSourceBean> hyoujiList = new ArrayList<JimuyouCodeListDataSourceBean>();

        requiredColumnCheck(wkSubSystemId,JimuyouCodeNyuuryokuConstants.DDID_SEARCHINFO_SUBSYSTEMID);
        requiredColumnCheck(wkJimutetuzukicd,JimuyouCodeNyuuryokuConstants.DDID_SEARCHINFO_JIMUTETUZUKICD);

        for (int i = 0; i < 20; i++) {
            JimuyouCodeListDataSourceBean hyoujiData = new JimuyouCodeListDataSourceBean();
            hyoujiData.setSyono(JimuyouCodeNyuuryokuConstants.BLANK);
            hyoujiData.setNksysyno(JimuyouCodeNyuuryokuConstants.BLANK);
            hyoujiData.setJimuyoucd(JimuyouCodeNyuuryokuConstants.BLANK);
            hyoujiData.setLineNum(i);
            hyoujiList.add(hyoujiData);
        }

        uiBean.setJimuyouCodeList(hyoujiList);
        uiBean.setResultSubSystemId(wkSubSystemId);
        uiBean.setResultJimutetuduki(wkJimutetuzukicd);
        uiBean.setKetteiBtnFlg("true");
    }

    void getJimuyoucdNyuuryokuList() {
        logger.info("事務用コード入力機能 事務用コードリスト作成を起動しました。");

        uiBean.setKetteiBtnFlg("false");

        String wkSubSystemId = uiBean.getResultSubSystemId();
        String wkJimutetuzuki = uiBean.getResultJimutetuduki();
        String splitFlowId = wkJimutetuzuki.substring(
            wkJimutetuzuki.lastIndexOf(JimuyouCodeNyuuryokuConstants.SPLITTER) + 1);

        DataSource<JimuyouCodeListDataSourceBean> jimuyouList = uiBean.getJimuyouCodeListDataSource();
        List<JimuyouCodeListDataSourceBean> nyuuryokuListData =
            ImmutableList.copyOf(Iterables.filter(jimuyouList.getDatas(), new GyoumuBlankFilter()));

        if (nyuuryokuListData.size() == 0
            && wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName())) {
            throw new BizLogicException(MessageId.EBA0027, 0,
                new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_MOSNO},
                JimuyouCodeNyuuryokuConstants.MESSAGE_MOSNO);
        } else if (nyuuryokuListData.size() == 0
            && wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName())) {
            throw new BizLogicException(MessageId.EBA0027, 0,
                new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_NKSYSYNO},
                JimuyouCodeNyuuryokuConstants.MESSAGE_NENKIN);
        } else if (nyuuryokuListData.size() == 0) {
            throw new BizLogicException(MessageId.EBA0027, 0,
                new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_SYONO},
                JimuyouCodeNyuuryokuConstants.MESSAGE_SHOUKEN);
        }
        List<JimuyouCodeList2DataSourceBean> jimuyoucdList = new ArrayList<JimuyouCodeList2DataSourceBean>();
        for (int i = 0; i < nyuuryokuListData.size(); i++) {
            JimuyouCodeListDataSourceBean wkListData = nyuuryokuListData.get(i);

            logger.debug(Integer.toString(wkListData.getLineNum()));
            if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName())) {
                if (wkListData.getMosno().isEmpty() && (!"".equals(wkListData.getJimuyoucd())) ) {
                    throw new BizLogicException(MessageId.EBA0027, wkListData.getLineNum(),
                        new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_MOSNO},
                        JimuyouCodeNyuuryokuConstants.MESSAGE_MOSNO);
                }
            } else if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName())) {
                if (wkListData.getNksysyno().isEmpty() && (!"".equals(wkListData.getJimuyoucd())) ) {
                    throw new BizLogicException(MessageId.EBA0027, wkListData.getLineNum(),
                        new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_NKSYSYNO},
                        JimuyouCodeNyuuryokuConstants.MESSAGE_NENKIN);
                }
            } else {
                if (wkListData.getSyono().isEmpty() && (!"".equals(wkListData.getJimuyoucd())) ) {
                    throw new BizLogicException(MessageId.EBA0027, wkListData.getLineNum(),
                        new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_SYONO},
                        JimuyouCodeNyuuryokuConstants.MESSAGE_SHOUKEN);
                }
            }

            String[] wkJimitetuzukicdList = {splitFlowId};
            String[] wkMosnoList = null;
            String[] wkSyonoList = null;
            String[] wkNksysynoList = null;
            if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName())) {
                wkMosnoList = new String[] { wkListData.getMosno() };
            }
            if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.KEIYAKUHOZEN.getName()) ||
                wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
                wkSyonoList = new String[] { wkListData.getSyono() };
            }
            if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName())) {
                wkNksysynoList = new String[] { wkListData.getNksysyno() };
            }

            logger.debug("============================================");
            logger.debug("事務用手続きコードリスト作成");
            logger.debug(wkSubSystemId);
            logger.debug(splitFlowId);
            logger.debug("============================================");

            JimuyouCodeList2DataSourceBean wkJimuyoucdData = new JimuyouCodeList2DataSourceBean();

            TaskSummaryForJimuyouCdBean resultData = new TaskSummaryForJimuyouCdBean();
            GetTasksForJimuyouCdResultBean result = WorkFlowUtility.getTasksForJimuyouCd(
                wkMosnoList,
                wkSyonoList,
                wkNksysynoList,
                wkJimitetuzukicdList);

            if (!result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)) {

                if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName()) &&
                    result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA)) {
                    throw new BizLogicException(
                        MessageId.EDF0004,
                        wkListData.getLineNum(),
                        new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_MOSNO });
                }
                else if ((wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.KEIYAKUHOZEN.getName()) ||
                    wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) &&
                    result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA)) {
                    throw new BizLogicException(
                        MessageId.EDF0004,
                        wkListData.getLineNum(),
                        new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_SYONO });
                }
                else if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName()) &&
                    result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA)) {
                    throw new BizLogicException(
                        MessageId.EDF0004,
                        wkListData.getLineNum(),
                        new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_NKSYSYNO });
                }
                else if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName()) &&
                    result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_LOCK)) {
                    throw new BizLogicException(
                        MessageId.EDA1001,
                        wkListData.getLineNum(),
                        new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_MOSNO },
                        result.getLockGyoumuKeyBean().getMosNo());
                }
                else if ((wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.KEIYAKUHOZEN.getName()) ||
                    wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) &&
                    result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_LOCK)) {
                    throw new BizLogicException(
                        MessageId.EDA1001,
                        wkListData.getLineNum(),
                        new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_SYONO },
                        result.getLockGyoumuKeyBean().getSyoNo());
                }
                else if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName()) &&
                    result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_LOCK)) {
                    throw new BizLogicException(
                        MessageId.EDA1001,
                        wkListData.getLineNum(),
                        new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_NKSYSYNO },
                        result.getLockGyoumuKeyBean().getNkSysyNo());
                }
                else {
                    logger.error("ワークフロー呼出Utility#事務用コード入力工程リスト取得");
                    logger.error("エラーコード：" + result.getSyousaiMessageCd());
                    logger.error("エラーメッセージ：" + result.getSyousaiMessage());
                    throw new BizAppException(MessageId.EAS0037);
                }
            }
            resultData = result.getTaskSummaryForJimuyouCdBeanList().get(0);

            if (BizUtil.isBlank(wkListData.getJimuyoucd()) && BizUtil.isBlank(resultData.getJimuyouCd())) {
                throw new BizLogicException(MessageId.EBA0027, wkListData.getLineNum(),
                    new Item[]{JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_JIMUYOUCD},
                    JimuyouCodeNyuuryokuConstants.MESSAGE_JIMUYOUCD);
            }

            if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName())) {
                wkJimuyoucdData.setDispGyoumuKey(wkListData.getMosno());
            } else if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName())) {
                wkJimuyoucdData.setDispGyoumuKey(wkListData.getNksysyno());
            } else {
                wkJimuyoucdData.setDispGyoumuKey(wkListData.getSyono());
            }
            wkJimuyoucdData.setDispjimuyoucd(wkListData.getJimuyoucd());
            wkJimuyoucdData.setDisphnkmaejimuyoucd(resultData.getJimuyouCd());
            wkJimuyoucdData.setKouteiKnrId(resultData.getKouteiKnrId());
            jimuyoucdList.add(wkJimuyoucdData);
        }

        uiBean.setSubSystemId(wkSubSystemId);
        uiBean.setJimutetuzukicd(wkJimutetuzuki);
        uiBean.setJimuyouCodeList2(jimuyoucdList);
        messageManager.addMessageId(MessageId.QAC0008);
    }

    @Transactional
    void jinuyoucdTouroku() {
        logger.info("事務用コード入力機能 事務用コードリスト登録を起動しました。");

        String wkSubSystemId = uiBean.getResultSubSystemId();

        DataSource<JimuyouCodeList2DataSourceBean> nyuuryokuList = uiBean.getJimuyouCodeList2DataSource();
        List<JimuyouCodeList2DataSourceBean> nyuuryokuListData = nyuuryokuList.getDatas();

        String wkFlowId = uiBean.getResultJimutetuduki();
        String splitFlowId = wkFlowId.substring(
            wkFlowId.lastIndexOf(JimuyouCodeNyuuryokuConstants.SPLITTER) + 1);

        String wkUserId = baseUserInfo.getUserId();

        List<PutJimuyouCdBean> putJimuyouCdBeanLst = Lists.newArrayList();
        for (JimuyouCodeList2DataSourceBean nyuuryoku : nyuuryokuListData) {
            PutJimuyouCdBean putJimuyouCdBean = SWAKInjector.getInstance(PutJimuyouCdBean.class);
            putJimuyouCdBean.setKouteiKnrId(nyuuryoku.getKouteiKnrId());
            putJimuyouCdBean.setJimuyouCd(nyuuryoku.getDispjimuyoucd());
            putJimuyouCdBeanLst.add(putJimuyouCdBean);
        }

        PutJimuyouCdResultBean putJimuyouCdResultBean = WorkFlowUtility.putJimuyouCd(splitFlowId, wkUserId,
            putJimuyouCdBeanLst);

        lockProcessInBeanList = putJimuyouCdResultBean.getLockProcessInBeanList();

        if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.SINKEIYAKU.getName()) &&
            putJimuyouCdResultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_LOCK)) {
            throw new BizLogicException(
                MessageId.EDA1001,
                new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_MOSNO },
                putJimuyouCdResultBean.getLockGyoumuKeyBean().getMosNo());
        }
        else if ((wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.KEIYAKUHOZEN.getName()) ||
            wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) &&
            putJimuyouCdResultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_LOCK)) {
            throw new BizLogicException(
                MessageId.EDA1001,
                new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_SYONO },
                putJimuyouCdResultBean.getLockGyoumuKeyBean().getSyoNo());
        }
        else if (wkSubSystemId.equals(JimuyouCodeNyuuryokuConstants.E_SubSystem.NENKINSIHARAI.getName()) &&
            putJimuyouCdResultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_LOCK)) {
            throw new BizLogicException(
                MessageId.EDA1001,
                new Item[] { JimuyouCodeNyuuryokuConstants.DDID_JIMUYOUCODELIST_NKSYSYNO },
                putJimuyouCdResultBean.getLockGyoumuKeyBean().getNkSysyNo());
        }
        else if (!putJimuyouCdResultBean.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)) {
            logger.error("ワークフロー呼出Utility#事務用コード登録");
            logger.error("エラー発生API名：" + putJimuyouCdResultBean.getErrorApiName());
            logger.error("エラーコード：" + putJimuyouCdResultBean.getSyousaiMessageCd());
            logger.error("エラーメッセージ：" + putJimuyouCdResultBean.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }
        messageManager.addMessageId(MessageId.IAC0009);

    }


    public void pushUnlockProcessBL() {

        if(lockProcessInBeanList != null){
            BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
            for(LockProcessInBean lockProcessInBean :lockProcessInBeanList){
                bzUnlockProcess.exec(lockProcessInBean.getGyoumukey(), lockProcessInBean.getFlowid(), lockProcessInBean.getLockkey());
            }
            lockProcessInBeanList = null;
        }
    }


    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    JimuyouCodeNyuuryokuConstants.BLANK,
                    JimuyouCodeNyuuryokuConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

    private static void requiredColumnCheck(String column, Item item) {

        if (column.isEmpty()) {
            throw new BizLogicException(MessageId.EAC0042,item);
        }
    }



}

