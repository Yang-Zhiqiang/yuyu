package yuyu.app.workflow.processkanri.wariatekaijyo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import net.arnx.jsonic.JSON;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.koutei.BzUnlockProcess;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.GetTaskTantoInfoListResultBean;
import yuyu.common.workflow.workflowutility.GetTaskTantoNmResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.common.workflow.workflowutility.WorkListUnassignTaskResultBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 担当者割当解除 のビジネスロジックです。
 */
public class WariateKaijyoBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private WariateKaijyoUiBean uiBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseUserInfo baseUserInfo;

    LockProcessInBean lockProcessInBean;

    void init() {
        logger.info("担当者割当解除機能を起動しました。");
        clear();
        BizPropertyInitializer.initialize(uiBean);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectInBean getExecutableSubSystemsSelectInBean = SWAKInjector.getInstance(GetExecutableSubSystemsSelectInBean.class);

        getExecutableSubSystemsSelectInBean.setUserId(baseUserInfo.getUserId());
        getExecutableSubSystemsSelectInBean.setBlankUmu(true);
        GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectOutBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(getExecutableSubSystemsSelectInBean);
        uiBean.setSubSystemIdOptionBeanList(getExecutableSubSystemsSelectOutBean.getUserDefsList());


        String[] pSubSystemId = getExecutableSubSystemsSelectOutBean.getSubSystemIdNameArray();

        if(pSubSystemId.length == 0){
            return;
        }

        uiBean.setJimutetuzukicdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    workflowDomManager.getJimutetuzukisBySubSystemIds(pSubSystemId)
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


        uiBean.setWorkflowTskNmOptionBeanList(
            insertBlank(
                Iterables.transform(
                    workflowDomManager.getJimutetuzukiTasksByWorklistHyoujiFlag(pSubSystemId)
                    ,
                    new Function<DM_JimutetuzukiTask, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(DM_JimutetuzukiTask task) {
                            return new LabelValuePair(
                                task.getWorkflowTskNm(),
                                task.getSubSystemId() + "." +
                                    task.getJimutetuzukicd()  + "." +
                                    task.getWorkflowTskId()
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
        uiBean.setWorkflowTskNm(null);
        uiBean.setTantid(null);

        uiBean.clearSubSystemIdOptionBeanList();
        uiBean.clearJimutetuzukicdOptionBeanList();
        uiBean.clearWorkflowTskNmOptionBeanList();
        uiBean.clearTantidOptionBeanList();

        if(uiBean.getTaskserInfoDataSource() != null) {
            uiBean.getTaskserInfoDataSource().getAllData().clear();
        }

    }

    void searchBtnOnClick() {
        logger.info("担当者割当解除機能 検索を起動しました。");

        String wkSubSystemId = uiBean.getSubSystemId();
        String wkJimitetuzukicd = uiBean.getJimutetuzukicd().substring(
            uiBean.getJimutetuzukicd().lastIndexOf(WariateKaijyoConstants.SPLITTER) + 1);
        String[] wkJimitetuzukicdList = {wkJimitetuzukicd};
        String wkTskNm = uiBean.getWorkflowTskNm().substring(
            uiBean.getWorkflowTskNm().lastIndexOf(WariateKaijyoConstants.SPLITTER) + 1);
        String wkTantId = uiBean.getTantid();


        uiBean.setTantid(wkTantId);
        uiBean.setSearchSubsystemId(wkSubSystemId);
        uiBean.setSearchJimutetuzukicd(wkJimitetuzukicd);
        uiBean.setSearchWorkflowTskNm(wkTskNm);
        uiBean.setSearchTantid(wkTantId);
        logger.debug("============================================");
        logger.debug("検索条件取得データ取得確認");
        logger.debug(wkSubSystemId);
        logger.debug(wkJimitetuzukicd);
        logger.debug(wkTskNm);
        logger.debug(wkTantId);
        logger.debug("============================================");

        uiBean.setTaskserInfo(null);


        GetTaskTantoInfoListResultBean result = WorkFlowUtility.getTaskTantoInfoList(wkSubSystemId, wkJimitetuzukicdList,wkTantId,wkTskNm);

        List<TaskserInfoDataSourceBean> wkTaskserInfo = new ArrayList<TaskserInfoDataSourceBean>();

        if(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)){

            SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            for(int i=0;i<result.getTaskTantoInfoBeanList().size();i++){
                TaskserInfoDataSourceBean wkTaskserInfoDataSourceBean = new TaskserInfoDataSourceBean();

                if (!Strings.isNullOrEmpty(result.getTaskTantoInfoBeanList().get(i).getJimuStartYmd())) {
                    try {
                        wkTaskserInfoDataSourceBean.setDispjimustartymd(BizDate.valueOf(sdf17.parse(result.getTaskTantoInfoBeanList().get(i).getJimuStartYmd())));
                    } catch (Exception e) {
                    }
                }
                wkTaskserInfoDataSourceBean.setDisptasknm(result.getTaskTantoInfoBeanList().get(i).getNowTaskNm());
                wkTaskserInfoDataSourceBean.setTaskNm(result.getTaskTantoInfoBeanList().get(i).getTaskNm());
                wkTaskserInfoDataSourceBean.setDisptantounm(result.getTaskTantoInfoBeanList().get(i).getDispNowSyoriTantouNm());
                wkTaskserInfoDataSourceBean.setJimutetuzukiCd(result.getTaskTantoInfoBeanList().get(i).getJimutetuzukiCd());
                if (uiBean.getSubSystemId().equals(WariateKaijyoConstants.E_SubSystem.SINKEIYAKU.getName())) {
                    wkTaskserInfoDataSourceBean.setDispGyoumuKey(result.getTaskTantoInfoBeanList().get(i).getMosNo());
                } else if(uiBean.getSubSystemId().equals(WariateKaijyoConstants.E_SubSystem.NENKINSIHARAI.getName())){
                    wkTaskserInfoDataSourceBean.setDispGyoumuKey(result.getTaskTantoInfoBeanList().get(i).getNkSysyNo());
                } else{
                    wkTaskserInfoDataSourceBean.setDispGyoumuKey(result.getTaskTantoInfoBeanList().get(i).getSyoNo());
                }
                wkTaskserInfoDataSourceBean.setWariateKaijyoLink(WariateKaijyoConstants.WARIATE_KAIJYO_LINK);

                wkTaskserInfoDataSourceBean.setDisptantouid(result.getTaskTantoInfoBeanList().get(i).getNowSyoriTantouId());

                wkTaskserInfoDataSourceBean.setKouteiKnrId(result.getTaskTantoInfoBeanList().get(i).getKouteiKnrId());

                wkTaskserInfo.add(wkTaskserInfoDataSourceBean);
            }
        } else if(result.getSyousaiMessageCd().equals(WariateKaijyoConstants.IWF2160)){
            messageManager.addMessageId(MessageId.IBF0024);
            return;

        }else if(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA)){
            messageManager.addMessageId(MessageId.IAC0021, WariateKaijyoConstants.MESSAGE_ANKEN);
            return;
        } else{
            logger.error("ワークフロー呼出Utility#処理残件数取得(サブシステム・ユーザーID指定)");
            logger.error("エラーコード"+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ"+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }

        uiBean.setTaskserInfo(wkTaskserInfo);

        String subSystemId = uiBean.getSearchSubsystemId();
        if (subSystemId.equals(WariateKaijyoConstants.E_SubSystem.SINKEIYAKU.getName())) {
            uiBean.setGyoumukeylbl(WariateKaijyoConstants.GYOUMU_KEY_SINKEIYAKU);
        }else if (subSystemId.equals(WariateKaijyoConstants.E_SubSystem.KEIYAKUHOZEN.getName())) {
            uiBean.setGyoumukeylbl(WariateKaijyoConstants.GYOUMU_KEY_KEIYAKUHOZEN);
        }else if (subSystemId.equals(WariateKaijyoConstants.E_SubSystem.HOKENKYUHUSIHARAI.getName())) {
            uiBean.setGyoumukeylbl(WariateKaijyoConstants.GYOUMU_KEY_HOKENKYUHUSIHARAI);
        }else {
            uiBean.setGyoumukeylbl(WariateKaijyoConstants.GYOUMU_KEY_NENKINSIHARAI);
        }


    }

    @Transactional
    void wariateKaijyoLinkOnClick() {

        logger.info("担当者割当解除機能 割当解除を起動しました。");


        BizDate dispjimustartymd = uiBean.getTaskserInfoDataSource().getSelectedBean().getDispjimustartymd();
        String wkFlowId = uiBean.getTaskserInfoDataSource().getSelectedBean().getJimutetuzukiCd();
        String taskNm = uiBean.getTaskserInfoDataSource().getSelectedBean().getTaskNm();
        String wkAccountId = uiBean.getTaskserInfoDataSource().getSelectedBean().getDisptantouid();
        String wkGyoumuKey = uiBean.getTaskserInfoDataSource().getSelectedBean().getDispGyoumuKey();
        String wkKouteiKnrId = uiBean.getTaskserInfoDataSource().getSelectedBean().getKouteiKnrId();
        String wkRirekiUserId = baseUserInfo.getUserId();

        logger.debug("============================================");
        logger.debug("押下されたデータ取得確認");
        logger.debug(String.valueOf(dispjimustartymd));
        logger.debug(wkFlowId);
        logger.debug(wkAccountId);
        logger.debug(wkGyoumuKey);
        logger.debug(wkKouteiKnrId);
        logger.debug("============================================");


        WorkListUnassignTaskResultBean result = new WorkListUnassignTaskResultBean();

        logger.info("ワークフロー呼出Utility#割当解除 を呼び出します");
        result = WorkFlowUtility.unassignTask(wkKouteiKnrId,wkFlowId,taskNm,wkAccountId,wkRirekiUserId);

        lockProcessInBean = result.getLockProcessInBean();

        if(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK)){
            uiBean.getTaskserInfoDataSource().getSelectedBean().setWariateKaijyoLink(WariateKaijyoConstants.BLANK);
        } else{

            if (WorkFlowResultConstants.RESULT_LOCK.equals(result.getSyorikekkaStatus())) {

                throw new BizLogicException(MessageId.EDA1001,new Item[]{WariateKaijyoConstants.DDID_TASKSERINFO_DISPGYOUMUKEY},wkGyoumuKey);
            }else if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
                throw new BizLogicException(MessageId.EDF1004);
            }

            logger.error("ワークフロー呼出Utility#割当解除エラー");
            logger.error("エラー発生API名"+result.getErrorApiName());
            logger.error("エラーコード"+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ"+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }

    }


    public void pushUnlockProcessBL() {

        if(lockProcessInBean != null){
            BzUnlockProcess bzUnlockProcess = SWAKInjector.getInstance(BzUnlockProcess.class);
            bzUnlockProcess.exec(lockProcessInBean.getGyoumukey(), lockProcessInBean.getFlowid(), lockProcessInBean.getLockkey());
            lockProcessInBean = null;
        }
    }

    void createTantoSelect(String pJimutetuzukicd){

        String[] pJimutetuzukicdList = {pJimutetuzukicd};

        GetTaskTantoNmResultBean result = WorkFlowUtility.getTaskTantoNm(pJimutetuzukicdList);

        UserDefsList tantoSelect = new UserDefsList();

        for(int i=0;i<result.getTaskTantoNmBeanList().size();i++){
            LabelValuePair labelValuePair = new LabelValuePair();
            labelValuePair.setValue(result.getTaskTantoNmBeanList().get(i).getTantId());
            labelValuePair.setLabel(result.getTaskTantoNmBeanList().get(i).getDispTntNm());
            tantoSelect.add(labelValuePair);
        }

        uiBean.setTantidOptionBeanList(insertBlank(tantoSelect));

        uiBean.setTantoFlg(false);

    }

    @SuppressWarnings("resource")
    void  callAjaxCreateTantoSelect() throws IOException{

        logger.info("担当者割当解除機能 担当者セレクト情報取得を起動しました。");

        HttpServletRequest req = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse res = SWAKInjector.getInstance(HttpServletResponse.class);

        String pDispJimutetuzukicd = req.getParameter(WariateKaijyoConstants.AJAX_POST_PARAM_JIMUTETUZUKICD);
        String pJimutetuzukicd = pDispJimutetuzukicd.substring(
            pDispJimutetuzukicd.lastIndexOf(WariateKaijyoConstants.SPLITTER) + 1);
        logger.debug(pJimutetuzukicd);

        createTantoSelect(pJimutetuzukicd);

        String responseJson = JSON.encode(uiBean.getTantidOptionBeanList());

        logger.debug("json形式確認");
        logger.debug(responseJson);

        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println(responseJson);
        out.close();

    }

    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    WariateKaijyoConstants.BLANK,
                    WariateKaijyoConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );



        return list;
    }

}

