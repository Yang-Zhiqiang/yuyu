package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.prereport.GetQRCode;
import yuyu.common.biz.prereport.SyoruiToutyakuYoteiTouroku;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectInBean;
import yuyu.common.workflow.wfcommon.GetExecutableSubSystemsSelectOutBean;
import yuyu.common.workflow.wfcommon.WfUserSelectCommon;
import yuyu.common.workflow.workflowutility.GetScanTorikomiSyoruiMstResultBean;
import yuyu.common.workflow.workflowutility.GetTasksForHyousiResultBean;
import yuyu.common.workflow.workflowutility.TaskSummaryForHyousiBean;
import yuyu.common.workflow.workflowutility.TorikomiSyoruiMstBean;
import yuyu.common.workflow.workflowutility.WorkFlowResultConstants;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.bean.report.TorikomiHyousiDataSourceBean;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 取込用表紙作成 のビジネスロジックです。
 */
public class TorikomiHyousiSakuseiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private TorikomiHyousiSakuseiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    WorkflowDomManager workflowDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private CreateReport createReport;

    @Inject
    private OutputReport outputReport;

    @Inject
    private AS_Kinou kinou;

    void init() {
        logger.info("取込用表紙作成機能 初期処理を起動しました。");
        clear();

        BizPropertyInitializer.initialize(uiBean);
        String wkUserId = baseUserInfo.getUserId();

        logger.debug("============================================");
        logger.debug("ログインユーザ情報取得");
        logger.debug(wkUserId);
        logger.debug("============================================");


        GetExecutableSubSystemsSelectInBean inBean = SWAKInjector
            .getInstance(GetExecutableSubSystemsSelectInBean.class);

        inBean.setUserId(baseUserInfo.getUserId());
        inBean.setBlankUmu(true);

        WfUserSelectCommon wfUserSelectCommon = SWAKInjector.getInstance(WfUserSelectCommon.class);
        GetExecutableSubSystemsSelectOutBean outBean = wfUserSelectCommon.getExecutableSubSystemsSelectList(inBean);


        UserDefsList subSystemList = outBean.getUserDefsList();

        for(int i=0; i<subSystemList.size();i++){
            if(subSystemList.get(i).getValue().equals(TorikomiHyousiSakuseiConstants.E_SubSystem.SINKEIYAKU.getName())){
                subSystemList.remove(i);
                break;
            }
        }
        uiBean.setSubSystemIdOptionBeanList(subSystemList);


        final Map<String, Object> jimutetuzukiMap = new HashMap<String, Object>();

        List<String> subSystemIdList = new ArrayList<String>(Arrays.asList(outBean.getSubSystemIdNameArray()));

        for(int i=0; i<subSystemIdList.size();i++){
            if(subSystemIdList.get(i).equals(TorikomiHyousiSakuseiConstants.E_SubSystem.SINKEIYAKU.getName())){
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
                            jimutetuzukiMap.put(
                                jimutetuzuki.getSubSystemId() + "." +
                                    jimutetuzuki.getJimutetuzukicd(),
                                    jimutetuzuki.getJimutetuzukinm());
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
        uiBean.setJimutetuzukiMap(jimutetuzukiMap);
        uiBean.setUserId(wkUserId);
    }

    void clear() {
        uiBean.setSubSystemId(null);
        uiBean.setJimutetuzukicd(null);
        uiBean.setSyono(null);
        uiBean.setNksysyno(null);
        uiBean.setMosno(null);
        uiBean.setTorikomiSyoruiCd(null);
        uiBean.setUserId(null);
        uiBean.getJimutetuzukiMap().clear();
        uiBean.clearSubSystemIdOptionBeanList();
        uiBean.clearJimutetuzukicdOptionBeanList();
        uiBean.clearTorikomiSyoruiCdOptionBeanList();

        uiBean.getAnkenListDataSource().setDatas(null);
    }

    void getTorikomiyouHyousiList() {
        logger.info("取込用表紙作成機能 取込用表紙作成リスト取得を起動しました。");
        String wkSubSystemId = uiBean.getSubSystemId();
        String wkJimutetuzukicd = uiBean.getJimutetuzukicd();
        String wkSyono = uiBean.getSyono();
        String wkNksysyno = uiBean.getNksysyno();
        String wkMosno = uiBean.getMosno();

        String wkUserId = uiBean.getUserId();

        uiBean.setAnkenList(null);

        GetTasksForHyousiResultBean result = new GetTasksForHyousiResultBean();

        if (wkSubSystemId.equals(TorikomiHyousiSakuseiConstants.E_SubSystem.SINKEIYAKU.getName())) {
            if (wkMosno.equals(TorikomiHyousiSakuseiConstants.BLANK)) {
                throw new BizLogicException(MessageId.EBA0027,
                    new Item[]{TorikomiHyousiSakuseiConstants.DDID_SEARCHINFO_MOSNO},
                    TorikomiHyousiSakuseiConstants.MESSAGE_MOSNO);
            }

            result = getTorikomiyouHyousiList(wkJimutetuzukicd, wkMosno, null, null, wkUserId);
        }
        else if (wkSubSystemId.equals(TorikomiHyousiSakuseiConstants.E_SubSystem.NENKINSIHARAI.getName())) {
            if (wkNksysyno.equals(TorikomiHyousiSakuseiConstants.BLANK)) {
                throw new BizLogicException(MessageId.EBA0027,
                    new Item[]{TorikomiHyousiSakuseiConstants.DDID_SEARCHINFO_NKSYSYNO},
                    TorikomiHyousiSakuseiConstants.MESSAGE_NENKIN);
            }

            result = getTorikomiyouHyousiList(wkJimutetuzukicd, null, null, wkNksysyno, wkUserId);

        } else {
            if (wkSyono.equals(TorikomiHyousiSakuseiConstants.BLANK)) {
                throw new BizLogicException(MessageId.EBA0027,
                    new Item[]{TorikomiHyousiSakuseiConstants.DDID_SEARCHINFO_SYONO},
                    TorikomiHyousiSakuseiConstants.MESSAGE_SHOUKEN);
            }

            result = getTorikomiyouHyousiList(wkJimutetuzukicd, null, wkSyono, null, wkUserId);

        }

        List<AnkenListDataSourceBean> ankenList = new ArrayList<AnkenListDataSourceBean>();
        List<TaskSummaryForHyousiBean> taskList = result.getTaskSummaryForHyousiBeanList();

        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf17 = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        for (int i = 0; i < taskList.size(); i++) {
            TaskSummaryForHyousiBean taskData = taskList.get(i);
            AnkenListDataSourceBean ankenData = new AnkenListDataSourceBean();

            ankenData.setDispjimutetuzukinm(taskData.getJimutetuzukiNm());
            ankenData.setDispkouteikanristatus(C_Kouteikanristatus.valueOf(taskData.getKouteiStatus()));
            ankenData.setDispkouteistatus(taskData.getDispKouteiStatus());
            if (!Strings.isNullOrEmpty(taskData.getKouteiKaisiYmd())) {
                try {
                    ankenData.setDispkouteikaisiymd(BizDate.valueOf(sdf8.parse(taskData.getKouteiKaisiYmd())));
                } catch (Exception e) {
                }
            }
            if (!Strings.isNullOrEmpty(taskData.getJimuStartYmd())) {
                try {
                    ankenData.setDispjimustartymd(BizDate.valueOf(sdf17.parse(taskData.getJimuStartYmd())));
                } catch (Exception e) {
                }
            }
            if (!Strings.isNullOrEmpty(taskData.getKouteiKanryouYmd())) {
                try {
                    ankenData.setDispkouteikanymd(BizDate.valueOf(sdf8.parse(taskData.getKouteiKanryouYmd())));
                } catch (Exception e) {
                }
            }
            ankenData.setSakuseiLink(TorikomiHyousiSakuseiConstants.SAKUSEI_LINK);
            ankenData.setKouteiKnrId(taskData.getKouteiKnrId());
            ankenData.setJimutetuzukicd(taskData.getJimutetuzukiCd());

            ankenList.add(ankenData);

        }

        uiBean.setResultSubSystemId(wkSubSystemId);
        uiBean.setResultJimutetuzuki(wkJimutetuzukicd);
        uiBean.setResultSyono(wkSyono);
        uiBean.setResultNksysyno(wkNksysyno);
        uiBean.setResultMosno(wkMosno);
        uiBean.setAnkenList(ankenList);

    }

    void getTrikomiShoruiSelect(){
        logger.info("取込用表紙作成機能 取込書類セレクト作成を起動しました。");

        uiBean.clearTorikomiSyoruiCdOptionBeanList();

        String wkSubSystemId = uiBean.getResultSubSystemId();
        String wkJimutetuzukicd = uiBean.getResultJimutetuzuki();
        String wkSyono = uiBean.getResultSyono();
        String wkNksysyno = uiBean.getResultNksysyno();
        String wkMosno = uiBean.getResultMosno();

        AnkenListDataSourceBean selectData = uiBean.getAnkenListDataSource().getSelectedBean();

        List<AnkenList2DataSourceBean> ankenList2 = new ArrayList<AnkenList2DataSourceBean>();

        AnkenList2DataSourceBean ankenData = new AnkenList2DataSourceBean();

        String status;
        if (selectData.getDispkouteistatus().equals(TorikomiHyousiSakuseiConstants.SYORITYUU)) {
            status = "10";
        } else {
            status = "90";
        }
        ankenData.setDispjimutetuzukinm(selectData.getDispjimutetuzukinm());
        ankenData.setDispkouteikanristatus(C_Kouteikanristatus.valueOf(status));
        ankenData.setDispkouteikaisiymd(selectData.getDispkouteikaisiymd());
        ankenData.setDispjimustartymd(selectData.getDispjimustartymd());
        ankenData.setDispkouteikanymd(selectData.getDispkouteikanymd());
        ankenData.setSakuseiLink(TorikomiHyousiSakuseiConstants.BLANK);
        ankenList2.add(ankenData);

        uiBean.setKouteiKnrId(selectData.getKouteiKnrId());

        String selectJimtetuzukicd = selectData.getJimutetuzukicd();

        logger.debug("============================================");
        logger.debug("【ワークフロー呼出Utility.取込書類マスタ取得】を起動します。");
        logger.debug("選択事務手続："+selectJimtetuzukicd);
        logger.debug("============================================");

        GetScanTorikomiSyoruiMstResultBean result = WorkFlowUtility.getScanTorikomiSyoruiMst(selectJimtetuzukicd);

        if (!(result.getSyorikekkaStatus().equals(WorkFlowResultConstants.RESULT_OK))) {
            logger.error("ワークフロー呼出Utility#取込書類マスタ取得");
            logger.error("エラーコード"+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ"+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }

        List<TorikomiSyoruiMstBean> syoruiList = result.getTorikomiSyoruiMstBeanList();
        final Map<String, Object> torikomiMap = new HashMap<String, Object>();

        List<LabelValuePair> t = new ArrayList<LabelValuePair>();
        for (Iterator<TorikomiSyoruiMstBean> i = syoruiList.iterator(); i.hasNext();) {
            TorikomiSyoruiMstBean listData =i.next();
            t.add(new LabelValuePair(listData.getSyoruiNm(), listData.getSyoruiCd()));
            torikomiMap.put(listData.getSyoruiCd(), listData.getSyoruiNm());
        }

        Iterator<LabelValuePair> itrList = t.iterator();

        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    TorikomiHyousiSakuseiConstants.BLANK,
                    TorikomiHyousiSakuseiConstants.BLANK
                    )
                )
                .addAll(itrList)
                .build()
            );
        uiBean.setTorikomiSyoruiCdOptionBeanList(list);

        uiBean.setSubSystemId(wkSubSystemId);
        uiBean.setJimutetuzukicd(wkJimutetuzukicd);
        uiBean.setSyono(wkSyono);
        uiBean.setNksysyno(wkNksysyno);
        uiBean.setMosno(wkMosno);
        uiBean.setAnkenList2(ankenList2);
        uiBean.setTorikomiSyoruiMap(torikomiMap);

    }

    void selectMdrBtnClick() {
        uiBean.setTorikomiSyoruiCd(null);
        uiBean.clearTorikomiSyoruiCdOptionBeanList();
    }
    void setteiKakuninMsg(){
        logger.info("取込用表紙作成機能 確認メッセージ設定を起動しました。");

        messageManager.addMessageId(MessageId.QBA0001);
    }
    @Transactional
    void createTorikomiHyousi() {
        logger.info("取込用表紙作成機能 取込用表紙作成を起動しました。");

        printOut();

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void printReport() {

        String tyouhyouKey = uiBean.getReportKey();

        outputReport.outputPDFWithDel(tyouhyouKey);

    }



    private void printOut() {
        logger.info("取込用表紙作成機能 帳票出力処理を起動しました。");

        String wkSubSystemId = uiBean.getResultSubSystemId();
        String wkSubSystemNm = "";
        for(LabelValuePair subSystemIdOptionBean : uiBean.getSubSystemIdOptionBeanList()){
            if(subSystemIdOptionBean.getValue().equals(wkSubSystemId)){
                wkSubSystemNm = subSystemIdOptionBean.getLabel();
            }
        }
        String wkJimutetuzukicd = uiBean.getResultJimutetuzuki();
        String wkJimutetuzukinm = (String) uiBean.getJimutetuzukiMap().get(wkJimutetuzukicd);
        String wkSyono = uiBean.getSyono();
        String wkNksysyno = uiBean.getResultNksysyno();
        String wkTorikomiSyoruiCd = uiBean.getTorikomiSyoruiCd();
        String wkSyoruim = (String) uiBean.getTorikomiSyoruiMap().get(wkTorikomiSyoruiCd);
        String wkKouteiKnrId = uiBean.getKouteiKnrId();
        String wkMosno = uiBean.getMosno();

        String wkUserId = baseUserInfo.getUserNm();

        logger.debug("============================================");
        logger.debug("帳票作成共通前処理を実行します。");
        logger.debug(wkSubSystemId);
        logger.debug(wkJimutetuzukicd);
        logger.debug(wkSyono);
        logger.debug(wkNksysyno);
        logger.debug(wkSyoruim);
        logger.debug("============================================");

        ReportServicesBean rsBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            TorikomiHyousiSakuseiConstants.KINOU_ID,
            C_SyoruiCdKbn.WF_HYOUSI);
        String wkQrCode = GetQRCode.execGetQRCode(uiBean.getTorikomiSyoruiCd());

        SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(uiBean.getTorikomiSyoruiCd(), wkKouteiKnrId, wkQrCode);

        rsBean.setKensakuKeys(new String[]{BizDate.getSysDateTime()});
        List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();

        TorikomiHyousiDataSourceBean rServiceBean = new TorikomiHyousiDataSourceBean();
        rServiceBean.setSousasyanm(wkUserId);
        rServiceBean.setSubSystemNm(wkSubSystemNm);
        rServiceBean.setJimutetuzukinm(wkJimutetuzukinm);
        if (wkSubSystemId.equals(TorikomiHyousiSakuseiConstants.E_SubSystem.NENKINSIHARAI.getName())) {
            rServiceBean.setNksysyno(wkNksysyno);
            rServiceBean.setSyono(TorikomiHyousiSakuseiConstants.BLANK);
            rServiceBean.setMosno(TorikomiHyousiSakuseiConstants.BLANK);
        } else if (wkSubSystemId.equals(TorikomiHyousiSakuseiConstants.E_SubSystem.SINKEIYAKU.getName())) {
            rServiceBean.setMosno(wkMosno);
            rServiceBean.setSyono(TorikomiHyousiSakuseiConstants.BLANK);
            rServiceBean.setNksysyno(TorikomiHyousiSakuseiConstants.BLANK);
        } else {
            rServiceBean.setSyono(wkSyono);
            rServiceBean.setNksysyno(TorikomiHyousiSakuseiConstants.BLANK);
            rServiceBean.setMosno(TorikomiHyousiSakuseiConstants.BLANK);
        }
        rServiceBean.setSyoruinm(wkSyoruim);
        rServiceBean.setWorkflowDocumentId(wkQrCode);
        rServiceBean.setRSakuseiYmd(BizDate.getSysDateTime());
        rdsBeanList.add(rServiceBean);

        rsBean.setQrCode(wkQrCode);

        rsBean.addParamObjects(rdsBeanList);

        String tyouhyouKey = createReport.execNoCommit(rsBean);

        logger.debug("取得した帳票キー");
        logger.debug(tyouhyouKey);

        uiBean.setReportKey(tyouhyouKey);

    }


    private GetTasksForHyousiResultBean getTorikomiyouHyousiList(String pJimutetuzukicd,
        String pMosno, String pSyoNo, String pNkSysyNo, String pUserId) {

        String splitJimtetuzukicd = pJimutetuzukicd.substring(pJimutetuzukicd.lastIndexOf(TorikomiHyousiSakuseiConstants.SPLITTER) + 1);
        logger.debug("============================================");
        logger.debug("【ワークフロー呼出Utility.取込用表紙作成対象リスト取得】を起動します。");
        logger.debug(pJimutetuzukicd);
        logger.debug("事務手続コード加工：" + splitJimtetuzukicd);
        logger.debug(pMosno);
        logger.debug(pSyoNo);
        logger.debug(pNkSysyNo);
        logger.debug(pUserId);
        logger.debug("============================================");

        GetTasksForHyousiResultBean result = WorkFlowUtility.getTasksForHyousi(uiBean.getSubSystemId(), splitJimtetuzukicd, pMosno, pSyoNo, pNkSysyNo, pUserId);


        if (WorkFlowResultConstants.RESULT_NODATA.equals(result.getSyorikekkaStatus())) {
            messageManager.addMessageId(MessageId.IAC0021, TorikomiHyousiSakuseiConstants.MESSAGE_ANKEN);
            return result;

        }
        else if (!WorkFlowResultConstants.RESULT_OK.equals(result.getSyorikekkaStatus())) {
            logger.error("ワークフロー呼出Utility#取込用表紙作成対象リスト取得");
            logger.error("エラーコード"+result.getSyousaiMessageCd());
            logger.error("エラーメッセージ"+result.getSyousaiMessage());
            throw new BizAppException(MessageId.EAS0037);
        }

        return result;
    }


    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair>builder()
            .add(
                new LabelValuePair(
                    TorikomiHyousiSakuseiConstants.BLANK,
                    TorikomiHyousiSakuseiConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

}
