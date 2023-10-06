package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
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
import yuyu.common.workflow.workflowutility.GetProcessHistoryResultBean;
import yuyu.common.workflow.workflowutility.GetTasksForKouteiStatusResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.workflow.manager.WorkflowDomManager;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 工程状況照会 のビジネスロジックです。
 */
public class KouteiJyoukyouSyoukaiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private KouteiJyoukyouSyoukaiUiBean uiBean;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    BaseUserInfo baseUserInfo;

    public GetTasksForKouteiStatusResultBean resultBackUp;

    void init() {
        clear();
        BizPropertyInitializer.initialize(uiBean);


        GetExecutableSubSystemsSelectInBean inBean = SWAKInjector
            .getInstance(GetExecutableSubSystemsSelectInBean.class);

        inBean.setUserId(baseUserInfo.getUserId());
        inBean.setBlankUmu(true);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);

        uiBean.setSubSystemIdOptionBeanList(outBean.getUserDefsList());

        if(outBean.getSubSystemIdNameArray().length == 0) {
            return;
        }


        String[] pSubSystemId = outBean.getSubSystemIdNameArray();

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



        uiBean.setTskidOptionBeanList(
            insertBlank(
                Iterables.transform(
                    workflowDomManager.getJimutetuzukiTasksBySubSystemIds(pSubSystemId)
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

        uiBean.setSubflowincludeCheckBox(true);

    }

    void clear() {
        uiBean.setSubSystemId(null);
        uiBean.setJimutetuzukicd(null);

        uiBean.clearSubSystemIdOptionBeanList();
        uiBean.clearJimutetuzukicdOptionBeanList();

        uiBean.getResultInfoDataSource().setDatas(null);
    }


    void searchBtnOnClick() {

        checkInputDate();
        checkInputJimucode();

        String subSystemId = uiBean.getSubSystemId();
        String[] pMosno = null;
        if (!"".equals(uiBean.getMosno())) {
            pMosno = new String[]{ uiBean.getMosno() };
        }
        String[] pSyoNo = null;
        if(!"".equals(uiBean.getSyono())){
            pSyoNo = new String[]{ uiBean.getSyono() };
        }
        String[] pNkSysyNo = null;
        if(!"".equals(uiBean.getNksysyno())){
            pNkSysyNo = new String[]{ uiBean.getNksysyno() };
        }
        String[] pJimutetuzukiCd = null;
        if(!"".equals(uiBean.getJimutetuzukicd())){
            pJimutetuzukiCd = new String[]{ uiBean.getJimutetuzukicd().substring(uiBean.getJimutetuzukicd().lastIndexOf(".") + 1) };
        }
        else {
            UserDefsList jimutetuzukicdOptionBeanList = uiBean.getJimutetuzukicdOptionBeanList();
            ArrayList<String> jimutetuzukiCdList = new ArrayList<String>();
            String targetJimutetuzukiCd;
            for(int i=0;i<jimutetuzukicdOptionBeanList.size();i++){
                targetJimutetuzukiCd = jimutetuzukicdOptionBeanList.get(i).getValue();
                if(!BizUtil.isBlank(targetJimutetuzukiCd)){
                    if(subSystemId.equals(targetJimutetuzukiCd.substring(0,targetJimutetuzukiCd.lastIndexOf(".")))){
                        jimutetuzukiCdList.add(targetJimutetuzukiCd.substring(targetJimutetuzukiCd.lastIndexOf(".") + 1));
                    }
                }
            }
            pJimutetuzukiCd = jimutetuzukiCdList.toArray(new String[jimutetuzukiCdList.size()]);
        }
        String pJimuKaisiYmdFrom = "";
        if( uiBean.getSrchjimustartymdfrom() != null ){
            pJimuKaisiYmdFrom = uiBean.getSrchjimustartymdfrom().toString();
        }
        String pJimuKaisiYmdTo = "";
        if( uiBean.getSrchjimustartymdto() != null ){
            pJimuKaisiYmdTo = uiBean.getSrchjimustartymdto().toString();
        }
        String pKouteiKanryouYmdFrom = "";
        if( uiBean.getSrchKouteikanStartYmdFrom() != null ){
            pKouteiKanryouYmdFrom = uiBean.getSrchKouteikanStartYmdFrom().toString();
        }
        String pKouteiKanryouYmdTo = "";
        if( uiBean.getSrchKouteikanStartYmdTo() != null ){
            pKouteiKanryouYmdTo = uiBean.getSrchKouteikanStartYmdTo().toString();
        }
        String pLastUpdateYmdFrom = "";
        if( uiBean.getSrchLastkosStartYmdFrom() != null ){
            pLastUpdateYmdFrom = uiBean.getSrchLastkosStartYmdFrom().toString();
        }
        String pLastUpdateYmdTo = "";
        if( uiBean.getSrchLastkosStartYmdTo() != null ){
            pLastUpdateYmdTo = uiBean.getSrchLastkosStartYmdTo().toString();
        }

        String[] pSyoriStatus = null;
        if(!"0".equals(uiBean.getKouteikanristatus().getValue())){
            pSyoriStatus = new String[]{ uiBean.getKouteikanristatus().getValue() };
        }
        String pJimuyouCd = uiBean.getJimuyoucd();
        String pJimuyouCdUmu = uiBean.getCommonCheckBox() ? "0": "1";
        String pUserId = baseUserInfo.getUserId();
        String pTaskNm = uiBean.getTskid();
        boolean pSubflowincludeCheckBox = uiBean.getSubflowincludeCheckBox();

        if (!BizUtil.isBlank(pTaskNm)) {
            pTaskNm = pTaskNm.substring(pTaskNm.lastIndexOf(".") + 1);
        }

        uiBean.setTaskuserInfo(null);

        GetTasksForKouteiStatusResultBean result = WorkFlowUtility.getTasksForKouteiStatus(
            subSystemId,
            pMosno,
            pSyoNo,
            pNkSysyNo,
            pJimutetuzukiCd,
            pJimuKaisiYmdFrom,
            pJimuKaisiYmdTo,
            pKouteiKanryouYmdFrom,
            pKouteiKanryouYmdTo,
            pLastUpdateYmdFrom,
            pLastUpdateYmdTo,
            pSyoriStatus,
            pJimuyouCd,
            pJimuyouCdUmu,
            "",
            "",
            pUserId,
            pTaskNm,
            pSubflowincludeCheckBox
            );

        if( result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA) ){
            logger.debug("ワークフロー呼出Utility#工程状況照会用リスト取得 検索結果０件");
            logger.debug("エラーコード："+result.getSyousaiMessageCd());
            logger.debug("エラーメッセージ："+result.getSyousaiMessage());

            messageManager.addMessageId(MessageId.IAC0021, KouteiJyoukyouSyoukaiConstants.MESSAGE_ANKEN);
            return;
        } else if(!(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK))){
            if(result.getSyousaiMessageCd().equals(KouteiJyoukyouSyoukaiConstants.ERR_IWF2160)) {
                logger.debug("ワークフロー呼出Utility#工程状況照会用リスト取得 IWF2160");
                logger.debug("エラーコード："+result.getSyousaiMessageCd());
                logger.debug("エラーメッセージ："+result.getSyousaiMessage());

                messageManager.addMessageId(MessageId.IBF0024);
                return;
            }
            logger.error("ワークフロー呼出Utility#工程状況照会用リスト取得 件数超過以外の異常");
            logger.error("エラーコード："+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ："+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }
        resultBackUp = result;

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        List<TaskuserInfoDataSourceBean> rec = new ArrayList<TaskuserInfoDataSourceBean>();

        for(int i=0;i<result.getTaskSummaryForKouteiStatusBeanList().size();i++){

            TaskuserInfoDataSourceBean taskuserInfoDataSourceBean = new TaskuserInfoDataSourceBean();
            taskuserInfoDataSourceBean.setDispjimutetuzukinm(result.getTaskSummaryForKouteiStatusBeanList().get(i).getJimutetuzukiNm());
            if( subSystemId.equals(KouteiJyoukyouSyoukaiConstants.SINKEIYAKU) ){
                taskuserInfoDataSourceBean.setDispGyoumuKey(result.getTaskSummaryForKouteiStatusBeanList().get(i).getMosNo());
            } else if( subSystemId.equals(KouteiJyoukyouSyoukaiConstants.NENKIN) ){
                taskuserInfoDataSourceBean.setDispGyoumuKey(result.getTaskSummaryForKouteiStatusBeanList().get(i).getNkSysyNo());
            }else{
                taskuserInfoDataSourceBean.setDispGyoumuKey(result.getTaskSummaryForKouteiStatusBeanList().get(i).getSyoNo());
            }
            taskuserInfoDataSourceBean.setKouteiKnrId(result.getTaskSummaryForKouteiStatusBeanList().get(i).getKouteiKnrId());
            if (!Strings.isNullOrEmpty(result.getTaskSummaryForKouteiStatusBeanList().get(i).getKouteiKaisiYmd())) {
                try {
                    taskuserInfoDataSourceBean.setHyoujiYmdFrom(BizDate.valueOf(sdf8.parse(result.getTaskSummaryForKouteiStatusBeanList().get(i).getKouteiKaisiYmd())));
                } catch (Exception e) {
                }
            }
            if (!Strings.isNullOrEmpty(result.getTaskSummaryForKouteiStatusBeanList().get(i).getJimuStartYmd())) {
                try {
                    taskuserInfoDataSourceBean.setDispjimustartymd(BizDate.valueOf(sdf17.parse(result.getTaskSummaryForKouteiStatusBeanList().get(i).getJimuStartYmd())));
                } catch (Exception e) {
                }
            }
            if (!Strings.isNullOrEmpty(result.getTaskSummaryForKouteiStatusBeanList().get(i).getKouteiKanryouYmd())) {
                try {
                    taskuserInfoDataSourceBean.setHyoujiYmdTo(BizDate.valueOf(sdf8.parse(result.getTaskSummaryForKouteiStatusBeanList().get(i).getKouteiKanryouYmd())));
                } catch (Exception e) {
                }
            }
            taskuserInfoDataSourceBean.setDispkouteikanristatus(C_Kouteikanristatus.valueOf(result.getTaskSummaryForKouteiStatusBeanList().get(i).getKouteiStatus()));
            taskuserInfoDataSourceBean.setDisptasknm(result.getTaskSummaryForKouteiStatusBeanList().get(i).getNowTaskLocalNm());
            taskuserInfoDataSourceBean.setDispnowsyoritantounm(result.getTaskSummaryForKouteiStatusBeanList().get(i).getDispNowSyoriTantouNm());
            taskuserInfoDataSourceBean.setSyousaiLink(KouteiJyoukyouSyoukaiConstants.SYOUSAI_LINK);
            taskuserInfoDataSourceBean.setJimutetuzukiCd(result.getTaskSummaryForKouteiStatusBeanList().get(i).getJimutetuzukiCd());

            rec.add(taskuserInfoDataSourceBean);
        }
        uiBean.setTaskuserInfo(rec);

        String subSystemIdwk = uiBean.getSubSystemId();
        uiBean.setSavesubsystemid(subSystemIdwk);
        if (subSystemIdwk.equals(KouteiJyoukyouSyoukaiConstants.SINKEIYAKU)) {
            uiBean.setGyoumukeylbl(KouteiJyoukyouSyoukaiConstants.GYOUMU_KEY_SINKEIYAKU);
        }else if (subSystemIdwk.equals(KouteiJyoukyouSyoukaiConstants.NENKIN)) {
            uiBean.setGyoumukeylbl(KouteiJyoukyouSyoukaiConstants.GYOUMU_KEY_NENKIN);
        }else {
            uiBean.setGyoumukeylbl(KouteiJyoukyouSyoukaiConstants.GYOUMU_KEY_HOZEN_SIHARAI);
        }

        uiBean.setResultMosno(uiBean.getMosno());
        uiBean.setResultNksysyno(uiBean.getNksysyno());
        uiBean.setResultSyono(uiBean.getSyono());
    }


    String syousaiLinkOnClick() {

        TaskuserInfoDataSourceBean selectedBean = uiBean.getTaskuserInfoDataSource().getSelectedBean();

        String jimuNm = selectedBean.getDispjimutetuzukinm();
        String pkouteiKnrId = selectedBean.getKouteiKnrId();
        String gyoumuKey = selectedBean.getDispGyoumuKey();
        C_Kouteikanristatus kouteikanri = selectedBean.getDispkouteikanristatus();
        String task = selectedBean.getDisptasknm();
        String tantou = selectedBean.getDispnowsyoritantounm();
        String pJimutetuzukiCd = selectedBean.getJimutetuzukiCd();

        uiBean.setDispGyoumuKey(gyoumuKey);
        uiBean.setDispjimutetuzukinm(jimuNm);
        uiBean.setDispkouteikanristatus(kouteikanri);
        uiBean.setDisptasknm(task);
        uiBean.setDispnowsyoritantounm(tantou);

        GetProcessHistoryResultBean result = WorkFlowUtility.getProcessHistory(
            pkouteiKnrId,
            pJimutetuzukiCd
            );

        if (result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_NODATA)) {
            messageManager.addMessageId(MessageId.IDF1001);
            return null;
        }

        if(!(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK))){
            logger.error("ワークフロー呼出Utility#工程履歴取得");
            logger.error("エラーコード："+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ："+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037 );
        }

        List<ResultInfoDataSourceBean> rec = new ArrayList<ResultInfoDataSourceBean>();

        for(int i=0;i<result.getProcessHistoryBeanList().size();i++){
            ResultInfoDataSourceBean resultInfoDataSourceBean = new ResultInfoDataSourceBean();


            if (!Strings.isNullOrEmpty(result.getProcessHistoryBeanList().get(i).getProcessYmdTime())) {
                BizDateFormat fmt = new BizDateFormat("yyyy/MM/dd", FillStyle.Zero);

                String dateStr = result.getProcessHistoryBeanList().get(i).getProcessYmdTime();
                int yint = Integer.parseInt(dateStr.substring(0, 4));
                int mint = Integer.parseInt(dateStr.substring(4, 6));
                int dint = Integer.parseInt(dateStr.substring(6, 8));
                String datetimeString = fmt.format(BizDate.valueOf(yint,mint,dint)) + " " +
                    dateStr.substring(8, 10)+":"+dateStr.substring(10, 12)+":"+ dateStr.substring(12,14);


                resultInfoDataSourceBean.setSyoriTime(datetimeString);
            }

            resultInfoDataSourceBean.setDispTskkinousyousaiNm(result.getProcessHistoryBeanList().get(i).getDispTaskNm());
            resultInfoDataSourceBean.setSyorikekkakbn(C_SyorikekkaKbn.valueOf(result.getProcessHistoryBeanList().get(i).getProcessResult()));
            resultInfoDataSourceBean.setDisptantounm(result.getProcessHistoryBeanList().get(i).getTantouNm());
            if( uiBean.getSubSystemId().equals(KouteiJyoukyouSyoukaiConstants.SIHARAI)){
                resultInfoDataSourceBean.setDispRirekiMsg("");
            }else{
                resultInfoDataSourceBean.setDispRirekiMsg(result.getProcessHistoryBeanList().get(i).getHistoryMessage());
            }

            rec.add(resultInfoDataSourceBean);
        }
        uiBean.setResultInfo(rec);

        uiBean.setMosno(uiBean.getResultMosno());
        uiBean.setNksysyno(uiBean.getResultNksysyno());
        uiBean.setSyono(uiBean.getResultSyono());

        return KouteiJyoukyouSyoukaiConstants.FORWARDNAME_RESULT;
    }


    private void checkInputDate() {

        BizDate jimustartymdfrom = uiBean.getSrchjimustartymdfrom();
        BizDate jimustartymdto = uiBean.getSrchjimustartymdto();
        BizDate kouteikanStartYmdFrom = uiBean.getSrchKouteikanStartYmdFrom();
        BizDate kouteikanStartYmdTo = uiBean.getSrchKouteikanStartYmdTo();
        BizDate lastkosStartYmdFrom = uiBean.getSrchLastkosStartYmdFrom();
        BizDate lastkosStartYmdTo = uiBean.getSrchLastkosStartYmdTo();
        Boolean flg = true;

        if(jimustartymdfrom != null && jimustartymdto != null){
            if( jimustartymdfrom.intValue() > jimustartymdto.intValue() ){
                throw new BizLogicException(MessageId.EDF0003,
                    new Item[]{GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_SRCHJIMUSTARTYMDFROM,
                    GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_SRCHJIMUSTARTYMDTO},
                    "事務開始日" );
            }
        }

        if(flg){
            if(kouteikanStartYmdFrom != null && kouteikanStartYmdTo != null){
                if( kouteikanStartYmdFrom.intValue() > kouteikanStartYmdTo.intValue()){
                    throw new BizLogicException(MessageId.EDF0003,
                        new Item[]{GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_SRCHKOUTEIKANSTARTYMDFROM,
                        GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_SRCHKOUTEIKANSTARTYMDTO},
                        "工程完了日" );
                }
            }
        }

        if(flg){
            if(lastkosStartYmdFrom != null && lastkosStartYmdTo != null){
                if(lastkosStartYmdFrom.intValue() > lastkosStartYmdTo.intValue()){
                    throw new BizLogicException(MessageId.EDF0003,
                        new Item[]{GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_SRCHLASTKOSSTARTYMDFROM ,
                        GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_SRCHLASTKOSSTARTYMDTO},
                        "最終更新日" );
                }
            }
        }
    }

    private void checkInputJimucode() {

        String jimuyoucd = uiBean.getJimuyoucd();
        Boolean commonCheckBox = uiBean.getCommonCheckBox();

        if( (!"".equals(jimuyoucd)) &&  commonCheckBox ){
            throw new BizLogicException(MessageId.EDF0006,
                GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_JIMUYOUCD,
                GenKouteiJyoukyouSyoukaiConstants.DDID_SEARCHKEYINPUT_COMMONCHECKBOX);
        }
    }

    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    KouteiJyoukyouSyoukaiConstants.BLANK,
                    KouteiJyoukyouSyoukaiConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

}
