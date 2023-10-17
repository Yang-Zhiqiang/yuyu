package yuyu.app.workflow.processkanri.kouteitorikesi;

import static yuyu.app.workflow.processkanri.kouteitorikesi.GenKouteiTorikesiConstants.*;
import static yuyu.app.workflow.processkanri.kouteitorikesi.KouteiTorikesiConstants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.workflow.processkanri.kouteitorikesi.KouteiTorikesiConstants.E_SubSystem;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.CancelProcessResultBean;
import yuyu.common.workflow.workflowutility.GetLockInfoResultBean;
import yuyu.common.workflow.workflowutility.GetTasksForCancelResultBean;
import yuyu.common.workflow.workflowutility.TaskForCancelBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 工程取消 のビジネスロジックです。
 */
public class KouteiTorikesiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private KouteiTorikesiUiBean uiBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseUserInfo baseUserInfo;


    void init() {
        logger.info("工程取消機能を起動しました。");
        clear();
        BizPropertyInitializer.initialize(uiBean);

        String wkUserId = baseUserInfo.getUserId();

        logger.debug("============================================");
        logger.debug("ログインユーザ情報取得");
        logger.debug(wkUserId);
        logger.debug("============================================");


        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectInBean getExecutableSubSystemsSelectInBean = SWAKInjector.getInstance(GetExecutableSubSystemsSelectInBean.class);

        getExecutableSubSystemsSelectInBean.setUserId(wkUserId);
        getExecutableSubSystemsSelectInBean.setBlankUmu(true);
        GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectOutBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(getExecutableSubSystemsSelectInBean);
        UserDefsList subSystemList = getExecutableSubSystemsSelectOutBean.getUserDefsList();

        for(int i=0; i<subSystemList.size();i++){
            if(subSystemList.get(i).getValue().equals(KouteiTorikesiConstants.E_SubSystem.SINKEIYAKU.getName())){
                subSystemList.remove(i);
                break;
            }
        }

        uiBean.setSubSystemIdOptionBeanList(subSystemList);


        List<String> subSystemIdList = new ArrayList<String>(Arrays.asList(getExecutableSubSystemsSelectOutBean.getSubSystemIdNameArray()));

        for(int i=0; i<subSystemIdList.size();i++){
            if(subSystemIdList.get(i).equals(KouteiTorikesiConstants.E_SubSystem.SINKEIYAKU.getName())){
                subSystemIdList.remove(i);
                break;
            }
        }

        String[] pSubSystemId = subSystemIdList.toArray(new String[subSystemIdList.size()]);

        if(pSubSystemId.length == 0) {
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
        uiBean.setSyono(null);
        uiBean.setNksysyno(null);
        uiBean.setDispkouteikaisiymd(null);
        uiBean.setDisptantounm(null);
        uiBean.setWorkflowTorikesiComment(null);

        uiBean.clearSubSystemIdOptionBeanList();
        uiBean.clearJimutetuzukicdOptionBeanList();

        uiBean.getKouteiListDataSource().setDatas(null);
    }

    void searchBtnOnClick() {

        logger.info("工程取消機能 検索を起動しました。");
        String wkSubSystemId = uiBean.getSubSystemId();
        String wkFlowId = uiBean.getJimutetuzukicd();
        String splitFlowId = wkFlowId.substring(
            wkFlowId.lastIndexOf(KouteiTorikesiConstants.SPLITTER) + 1);
        String wkSyono = uiBean.getSyono();
        String wkNksysyno = uiBean.getNksysyno();

        if (wkSubSystemId.equals(E_SubSystem.NENKINSIHARAI.getName()) && wkNksysyno.isEmpty()) {
            throw new BizLogicException(MessageId.EBA0027,
                new Item[]{KouteiTorikesiConstants.DDID_SEARCHINFO_NKSYSYNO},KouteiTorikesiConstants.MESSAGE_NENKIN);
        } else if ((!wkSubSystemId.equals(E_SubSystem.NENKINSIHARAI.getName())) && wkSyono.isEmpty()) {
            throw new BizLogicException(MessageId.EBA0027,
                new Item[]{KouteiTorikesiConstants.DDID_SEARCHINFO_SYONO},KouteiTorikesiConstants.MESSAGE_SHOUKEN);
        }

        logger.debug("============================================");
        logger.debug("検索条件データ取得確認");
        logger.debug(wkSubSystemId);
        logger.debug(wkFlowId);
        logger.debug(splitFlowId);
        logger.debug(wkSyono);
        logger.debug(wkNksysyno);
        logger.debug("============================================");

        uiBean.setKouteiList(null);

        GetTasksForCancelResultBean result = new GetTasksForCancelResultBean();
        if (wkSubSystemId.equals(E_SubSystem.NENKINSIHARAI.getName())) {
            result = WorkFlowUtility.getTasksForCancel(wkSubSystemId,null,null,wkNksysyno,splitFlowId);
        } else {
            result = WorkFlowUtility.getTasksForCancel(wkSubSystemId,null,wkSyono,null,splitFlowId);
        }


        if (WorkFlowResultConstants.RESULT_NG.equals(result.getSyorikekkaStatus())) {
            logger.error("ワークフロー呼出Utility#取消対象工程リスト取得エラー");
            logger.error("エラーコード"+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ"+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);

        }

        List<TaskForCancelBean> cancelList = result.getTaskForCancelBeanList();
        if (cancelList.size() == 0) {
            messageManager.addMessageId(MessageId.IDF0002);
            return;
        }

        List<KouteiListDataSourceBean> wkkouteiList = new ArrayList<KouteiListDataSourceBean>();

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");

        for(int i =0;i < cancelList.size();i++){
            KouteiListDataSourceBean wkKouteiListData = new KouteiListDataSourceBean();
            TaskForCancelBean calcelData = cancelList.get(i);
            if (!Strings.isNullOrEmpty(calcelData.getKouteiKaisiYmd())) {
                try {
                    wkKouteiListData.setDispkouteikaisiymd(BizDate.valueOf(sdf8.parse(calcelData.getKouteiKaisiYmd())));
                } catch (Exception e) {
                }
            }
            wkKouteiListData.setDisptantounm(calcelData.getDispTantouNm());
            wkKouteiListData.setNyuuryokuLink(KouteiTorikesiConstants.KOUTEI_TORIKESI_LINK);
            wkKouteiListData.setKouteiKnrId(calcelData.getKouteiKnrId());
            wkKouteiListData.setDispjimutetuzukinm(calcelData.getJimutetuzukiNm());
            if (wkSubSystemId.equals(E_SubSystem.KEIYAKUHOZEN.getName())
                || wkSubSystemId.equals(E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
                wkKouteiListData.setDispGyoumuKey(calcelData.getSyoNo());
            }
            if (wkSubSystemId.equals(E_SubSystem.NENKINSIHARAI.getName())) {
                wkKouteiListData.setDispGyoumuKey(calcelData.getNkSysyNo());
            }

            wkkouteiList.add(wkKouteiListData);
        }

        uiBean.setResultSubSystemId(wkSubSystemId);
        uiBean.setResultJimutetuduki(wkFlowId);
        uiBean.setResultSyono(wkSyono);
        uiBean.setResultNksysyno(wkNksysyno);
        uiBean.setKouteiList(wkkouteiList);

        if (wkSubSystemId.equals(E_SubSystem.KEIYAKUHOZEN.getName())) {
            uiBean.setGyoumukeylbl(GYOUMU_KEY_HOZEN);
        }
        if (wkSubSystemId.equals(E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
            uiBean.setGyoumukeylbl(GYOUMU_KEY_SIHARAI);
        }
        if (wkSubSystemId.equals(E_SubSystem.NENKINSIHARAI.getName())) {
            uiBean.setGyoumukeylbl(GYOUMU_KEY_NENKIN);
        }
    }

    void nyuuryokuLinkOnClick() {

        logger.info("工程取消機能 入力リンクを起動しました。");
        String wkSubSystemId = uiBean.getResultSubSystemId();
        String wkFlowId = uiBean.getResultJimutetuduki();
        String wkSyono = uiBean.getResultSyono();
        String wkNksysyno = uiBean.getResultNksysyno();

        KouteiListDataSourceBean selectBean = uiBean.getKouteiListDataSource().getSelectedBean();

        GetLockInfoResultBean resultBean = WorkFlowUtility.getLockInfo(selectBean.getKouteiKnrId());

        String syoriKekkaStatus = resultBean.getSyorikekkaStatus();
        String syousaiMessageCd = resultBean.getSyousaiMessageCd();
        String syousaiMessage = resultBean.getSyousaiMessage();

        if (WorkFlowResultConstants.RESULT_LOCK.equals(syoriKekkaStatus)) {
            throw new BizLogicException(MessageId.EDA1001,
                new Item[]{DDID_KOUTEILIST_DISPGYOUMUKEY}, selectBean.getDispGyoumuKey());
        }
        else if (!WorkFlowResultConstants.RESULT_OK.equals(syoriKekkaStatus)) {
            logger.error("ワークフロー呼出Utility#工程ロック情報取得エラー");
            logger.error("エラーコード" + syousaiMessageCd);
            logger.error("エラーメッセージ" + syousaiMessage);
            throw new BizAppException(MessageId.EAS0037);
        }

        BizDate wkSelectKaisiDay = selectBean.getDispkouteikaisiymd();
        String wkSelectTantNm = selectBean.getDisptantounm();
        String wkKouteiKnrId = selectBean.getKouteiKnrId();

        uiBean.setSubSystemId(wkSubSystemId);
        uiBean.setJimutetuzukicd(wkFlowId);
        uiBean.setSyono(wkSyono);
        uiBean.setNksysyno(wkNksysyno);
        uiBean.setKouteiKnrId(wkKouteiKnrId);
        uiBean.setDispkouteikaisiymd(wkSelectKaisiDay);
        uiBean.setDisptantounm(wkSelectTantNm);

    }

    void modoruBtnOnClick() {
        logger.info("工程取消機能 対象選択画面へ戻る を起動しました。");

        uiBean.setWorkflowTorikesiComment(null);
        String wkSubSystemId = uiBean.getResultSubSystemId();
        String wkFlowId = uiBean.getResultJimutetuduki();

        uiBean.setSubSystemId(wkSubSystemId);
        uiBean.setJimutetuzukicd(wkFlowId);
    }

    void kakuninBtnOnClick() {

        logger.info("工程取消機能 確認を起動しました。");
        messageManager.addMessageId(MessageId.QBA0001);

    }

    @Transactional
    void kakuteiBtnOnClick() {

        logger.info("工程取消機能 工程取消を起動しました。");
        String wkSyono = uiBean.getSyono();
        String wkNksysyno = uiBean.getNksysyno();
        String wkFlowId = uiBean.getJimutetuzukicd();
        String wkAccountId = baseUserInfo.getUserId();
        String wkComment = uiBean.getWorkflowTorikesiComment();
        String wkKouteiKnrId = uiBean.getKouteiKnrId();
        String splitFlowId = wkFlowId.substring(
            wkFlowId.lastIndexOf(KouteiTorikesiConstants.SPLITTER) + 1);


        logger.debug("============================================");
        logger.debug("工程取消処理");
        logger.debug(wkSyono);
        logger.debug(wkNksysyno);
        logger.debug(wkFlowId);
        logger.debug(splitFlowId);
        logger.debug(wkAccountId);
        logger.debug(wkComment);
        logger.debug("============================================");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(wkKouteiKnrId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(splitFlowId);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanList.get(0);

        if (C_Kouteikanristatus.TORIKESI.eq(bzGetProcessSummaryOutBean.getKouteiKanriStatus())) {

            if (uiBean.getSubSystemId().equals(E_SubSystem.KEIYAKUHOZEN.getName())
                || uiBean.getSubSystemId().equals(E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
                throw new BizLogicException(MessageId.EDF1011, new Item[]{DDID_SEARCHINFO_SYONO}, uiBean.getSyono());
            }
            else if (uiBean.getSubSystemId().equals(E_SubSystem.NENKINSIHARAI.getName())){
                throw new BizLogicException(MessageId.EDF1011, new Item[]{DDID_SEARCHINFO_NKSYSYNO}, uiBean.getNksysyno());
            }
        }
        else if (!BizUtil.isBlank(bzGetProcessSummaryOutBean.getJimuStartYmdTime())) {
            if (uiBean.getSubSystemId().equals(E_SubSystem.KEIYAKUHOZEN.getName())
                || uiBean.getSubSystemId().equals(E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
                throw new BizLogicException(MessageId.EDF1012, new Item[]{DDID_SEARCHINFO_SYONO}, uiBean.getSyono());
            }
            else if (uiBean.getSubSystemId().equals(E_SubSystem.NENKINSIHARAI.getName())){
                throw new BizLogicException(MessageId.EDF1012, new Item[]{DDID_SEARCHINFO_NKSYSYNO}, uiBean.getNksysyno());
            }
        }
        else {
        }

        CancelProcessResultBean result = WorkFlowUtility.cancelProcess(wkKouteiKnrId,
            splitFlowId, wkAccountId, wkComment);

        String syoriKekkaStatus = result.getSyorikekkaStatus();
        String errorApiName = result.getErrorApiName();
        String syousaiMessageCd = result.getSyousaiMessageCd();
        String syousaiMessage = result.getSyousaiMessage();

        if ((uiBean.getSubSystemId().equals(E_SubSystem.KEIYAKUHOZEN.getName())
            || uiBean.getSubSystemId().equals(E_SubSystem.HOKENKYUHUSIHARAI.getName()))
            && WorkFlowResultConstants.RESULT_LOCK.equals(syoriKekkaStatus)) {
            throw new BizLogicException(MessageId.EDA1001, new Item[]{DDID_SEARCHINFO_SYONO}, uiBean.getSyono());
        }
        else if (uiBean.getSubSystemId().equals(E_SubSystem.NENKINSIHARAI.getName())
            && WorkFlowResultConstants.RESULT_LOCK.equals(syoriKekkaStatus)) {
            throw new BizLogicException(MessageId.EDA1001, new Item[]{DDID_SEARCHINFO_NKSYSYNO}, uiBean.getNksysyno());
        }
        else if (!WorkFlowResultConstants.RESULT_OK.equals(syoriKekkaStatus)) {
            logger.error("ワークフロー呼出Utility#工程取消エラー");
            logger.error("エラー発生API名" + errorApiName);
            logger.error("エラーコード" + syousaiMessageCd);
            logger.error("エラーメッセージ" + syousaiMessage);
            throw new BizAppException(MessageId.EAS0037);
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }



    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    KouteiTorikesiConstants.BLANK,
                    KouteiTorikesiConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

}
