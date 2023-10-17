package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import static yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.GenSkHubiTourokuConstants.*;
import static yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.SkHubiTourokuConstants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import net.arnx.jsonic.JSON;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.dba.SkHubiTourokuDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardHubiTouroku;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHubiTyouhyou;
import yuyu.common.sinkeiyaku.skcommon.EditSkHubiItiranNit;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuui;
import yuyu.common.sinkeiyaku.skcommon.HanteiDoujiMos;
import yuyu.common.sinkeiyaku.skcommon.HubiNaiyouOutBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.report.BzDairitenAtesakiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_HbtyhyoutKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.bean.report.SkHubituutiBean;
import yuyu.def.sinkeiyaku.bean.report.SkHubituutityoubunDataSourceBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHubiKoumoku;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHubiNaiyou;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkHubiDetail;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 新契約不備登録 のビジネスロジックです。
 */
public class SkHubiTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkHubiTourokuUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HanteiDoujiMos hanteiDoujiMos;

    @Inject
    private MessageManager messageManager;

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private EditPdfHubiTyouhyou editPdfHubiTyouhyou;

    @Inject
    private OutputReport outputReport;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private SkHubiTourokuDao skHubiTourokuDao;

    @Inject
    private ObjStorageManager objStrMan;

    @Inject
    private SkHubiRenkeiInfo newSkHubiRenkeiInfo;

    void init() {

        BizPropertyInitializer.initialize(uiBean);
        clear();
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setKeizokuEditKahi(true);
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();

        String kouteiKanriId  = uiBean.getBzWorkflowInfo().getKouteiKanriId();

        String jimuTetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriId);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(jimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        String mosno = bzGetProcessSummaryOutBeanList.get(0).getMosNo();

        uiBean.setMosno(mosno);

        List<HT_SkHubi> skHubiList = chkKihonTbl();
        chkWarning();

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosno);

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        taskStartBL();
        setKouteiInfo();
        setSyoruiInfo();
        setSkeittdktyuuiInfo();
        setHubiInfo(skHubiList.get(0));
        createList();
    }

    @Transactional
    String pushTourokuBL() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setKeizokuEditKahi(true);

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.HUBITOUROKU.getValue());
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(uiBean.getKinouMode().getKinouMode());

        if (!kengenFlag) {
            throw new BizLogicException(MessageId.EHA1073,
                C_SkkinouModeIdKbn.getContentByValue(uiBean.getKinouMode().getKinouMode()));
        }

        List<HT_SkHubi> skHubiList = chkKihonTbl();

        if (skHubiList.isEmpty()) {

            setHubiTourokuInfo(null);

            uiBean.setHubisikibetukey(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            return FORWARDNAME_INPUTCONTENTS;
        }
        else if (skHubiList.size() == 1) {

            setHubiTourokuInfo(skHubiList.get(0));

            uiBean.setHubisikibetukey(skHubiList.get(0).getHubisikibetukey());
            return FORWARDNAME_INPUTCONTENTS;
        }
        else {

            List<SelectDataListDataSourceBean> selectDataListDataSourceBeanList = Lists.newArrayList();

            String inputLink =  MessageUtil.getMessage(DDID_SELECTDATALIST_NYUURYOKULINK.getErrorResourceKey());

            for (HT_SkHubi skHubi:skHubiList) {

                SelectDataListDataSourceBean selectDataListDataSourceBean =
                    SWAKInjector.getInstance(SelectDataListDataSourceBean.class);

                BizDate jimustartymd = null;

                BzGetProcessSummaryInBean summaryStartInBean = new BzGetProcessSummaryInBean();
                summaryStartInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                summaryStartInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                summaryStartInBean.setMosNo(uiBean.getMosno());
                summaryStartInBean.setKouteiKanriId(skHubi.getHubisikibetukey());
                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                List<BzGetProcessSummaryOutBean> outBeanStartList = bzGetProcessSummary.exec(summaryStartInBean);

                if (!outBeanStartList.isEmpty()) {

                    jimustartymd = outBeanStartList.get(0).getJimuStartYmd();
                }

                selectDataListDataSourceBean.setDispjimutetuzukinm(skHubi.getJimutetuzukinm());
                selectDataListDataSourceBean.setDispjimustartymd(jimustartymd);
                selectDataListDataSourceBean.setNyuuryokuLink(inputLink);
                selectDataListDataSourceBean.setHubisikibetukey(skHubi.getHubisikibetukey());
                selectDataListDataSourceBeanList.add(selectDataListDataSourceBean);
            }

            uiBean.setSelectDataList(selectDataListDataSourceBeanList);

            return FORWARDNAME_SELECTDATA;
        }
    }

    String functionNameOnClickBL() {
        String forwardName = "";

        if (uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM) {
            unlockProcessBL();
        }

        if ((uiBean.getPageNo() == PAGENO_INPUTCONTENTS || uiBean.getPageNo() == PAGENO_CONFIRM ||
            uiBean.getPageNo() == PAGENO_RESULT) && C_UmuKbn.ARI.eq(uiBean.getItiranKeiyuUmuKbn())) {
            forwardName = FORWARDNAME_NESTEDEND;

            return forwardName;
        }

        forwardName = pushNestedEndBL();

        return forwardName;
    }

    String pushNestedEndBL() {

        String forward = null;

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forward = FORWARDNAME_INIT;
        }
        else {
            forward = FORWARDNAME_BACKTOWORKLIST;
        }

        return forward;
    }

    @Transactional
    void pushInputBL() {

        SelectDataListDataSourceBean selectDataListDataSourceBean = uiBean.getSelectDataListDataSource().getSelectedBean();

        setHubiTourokuInfo(uiBean.getSyoriCTL().getSkHubiByHubisikibetukey(selectDataListDataSourceBean.getHubisikibetukey()));

        uiBean.setItiranKeiyuUmuKbn(C_UmuKbn.ARI);

        uiBean.setHubisikibetukey(selectDataListDataSourceBean.getHubisikibetukey());
    }

    String pushKakuninBL() {
        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        Iterables.removeIf(hubiList2DSBeanLst, new HubiList2DataSourceBeanPredicate());
        continueLockProcessBL();

        List<HubiList2DataSourceBean> hubiInputLst = hubiList2DSBeanLst;

        List<HubiList2DataSourceBean> hubiInputSeibiLst = Lists.newArrayList();

        for (HubiList2DataSourceBean hubiInputBean : hubiInputLst) {

            if (!C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && (BizUtil.isBlank(hubiInputBean.getDispinputskhubikoumoku())
                    || BizUtil.isBlank(hubiInputBean.getDispinputhubinaiyoucd()))) {
                throw new BizLogicException(MessageId.EHC1033,
                    MessageUtil.getMessage(DDID_HUBILIST2_DISPINPUTSKHUBIKOUMOKU.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_HUBILIST2_DISPINPUTHUBINAIYOUCD.getErrorResourceKey()));
            }

            if (!C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && BizUtil.isBlank(hubiInputBean.getDispinputskseibisijinaiyou())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_HUBILIST2_DISPINPUTSKSEIBISIJINAIYOU.getErrorResourceKey()));
            }

            if (C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && !BizUtil.isBlank(hubiInputBean.getDispinputskseibisijinaiyou())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_HUBILIST1_HUBISYORUICD.getErrorResourceKey()));
            }

            if (hubiInputBean.getDispinputtyoubunflg()) {
                boolean chkMaxRowFlg = chkMaxRow(hubiInputBean.getTyoubundisprenrakujikou(), 15, 50);
                if (chkMaxRowFlg) {
                    throw new BizLogicException(MessageId.EHA1057,
                        MessageUtil.getMessage(DDID_HUBILIST2_TYOUBUNDISPRENRAKUJIKOU.getErrorResourceKey()), "15", "50");
                }
            }
            else {
                boolean chkMaxRowFlg = chkMaxRow(hubiInputBean.getTyoubundisprenrakujikou(), 5, 50);
                if (chkMaxRowFlg) {
                    throw new BizLogicException(MessageId.EHA1057,
                        MessageUtil.getMessage(DDID_HUBILIST2_TYOUBUNDISPRENRAKUJIKOU.getErrorResourceKey()), "5", "50");
                }
            }

            if (!C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && (!BizUtil.isBlank(hubiInputBean.getDispinputskhubikoumoku())
                    && !BizUtil.isBlank(hubiInputBean.getDispinputhubinaiyoucd()))) {
                createHubiKbnPulldownList(hubiInputBean);
                createHubiReasonPulldownList(hubiInputBean);
                hubiInputBean.setTyoubunflg(hubiInputBean.getDispinputtyoubunflg());
                hubiInputSeibiLst.add(hubiInputBean);
            }
        }

        if (!hubiInputSeibiLst.isEmpty()) {

            int dairitenKyokaCount = 0;
            boolean kyokaFlg = false;

            for (HubiList2DataSourceBean hubiInputSeibi : hubiInputSeibiLst) {


                if (C_HasinkyokaKbn.KY.eq(hubiInputSeibi.getDispinputhasinkyokakbn())) {

                    if (C_HassinsakiKbn.DRTEN.eq(hubiInputSeibi.getDispinputhassinsakikbn())) {

                        dairitenKyokaCount++;
                    }
                }
                else {
                    kyokaFlg = true;
                }
            }

            if (dairitenKyokaCount > 3) {
                throw new BizLogicException(MessageId.EHA0479, "代理店", "3");
            }
            uiBean.setKyokaFlg(kyokaFlg);
        }

        uiBean.setHubiInputSeibiLst(hubiInputSeibiLst);

        EditSkHubiItiranNit editSkHubiItiranNit = SWAKInjector.getInstance(EditSkHubiItiranNit.class);
        int pIdx = 0;
        String skhubikoumoku = "";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";
        boolean keizokuEditKahi = true;

        for (HubiList1DataSourceBean dataSourceBean : uiBean.getHubiList1DataSource().getAllData()) {
            if (dataSourceBean.getDispkaisyouymd() == null) {
                String dispskhubikoumoku = dataSourceBean.getDispskhubikoumoku();
                String[] newSkhubikoumoku = dispskhubikoumoku.split("：");

                String dispskhubinaiyou = dataSourceBean.getDispskhubinaiyou();
                String[] newSkhubinaiyou = dispskhubinaiyou.split("：");
                HM_SkHubiNaiyou skHubiNaiyou = sinkeiyakuDomManager.getSkHubiNaiyou(
                    newSkhubikoumoku[0], newSkhubinaiyou[0]);
                skhubinaiyou = skHubiNaiyou.getSkhubinaiyou();

                skseibisijinaiyou = dataSourceBean.getDispskseibisijinaiyou();
                skrenrakujikou = dataSourceBean.getTyoubundisprenrakujikou();

                keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(pIdx, newSkhubikoumoku[1], skhubinaiyou,
                    skseibisijinaiyou, skrenrakujikou);

                if (!keizokuEditKahi) {
                    break;
                }
                pIdx = pIdx + 1;
            }
        }

        if (keizokuEditKahi) {
            for (HubiList2DataSourceBean  dataSourceBean : hubiInputSeibiLst) {
                if (C_HasinkyokaKbn.KY.eq(dataSourceBean.getDispinputhasinkyokakbn())) {
                    HM_SkHubiKoumoku skHubiKoumoku = sinkeiyakuDomManager.getSkHubiKoumoku(
                        dataSourceBean.getHubisyoruicd(), dataSourceBean.getDispinputskhubikoumoku());
                    skhubikoumoku = skHubiKoumoku.getSkhubikoumoku();
                    HM_SkHubiNaiyou skHubiNaiyou = sinkeiyakuDomManager.getSkHubiNaiyou(
                        dataSourceBean.getDispinputskhubikoumoku(), dataSourceBean.getDispinputhubinaiyoucd());
                    skhubinaiyou = skHubiNaiyou.getSkhubinaiyou();
                    HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = sinkeiyakuDomManager.getSkSeibiSijiNaiyou(dataSourceBean.getDispinputskseibisijinaiyou());
                    skseibisijinaiyou = skSeibiSijiNaiyou.getSkseibisijinaiyou();
                    skrenrakujikou = dataSourceBean.getTyoubundisprenrakujikou();

                    keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(pIdx, skhubikoumoku, skhubinaiyou,
                        skseibisijinaiyou, skrenrakujikou);

                    if (!keizokuEditKahi) {
                        break;
                    }
                    pIdx = pIdx + 1;
                }
            }
        }
        uiBean.setKeizokuEditKahi(keizokuEditKahi);

        if (C_MosUketukeKbn.PAPERLESSNIT.eq(uiBean.getMosuketukekbn()) &&
            C_DrtenRnrkhouKbn.NIT.eq(uiBean.getDrtenRnrkhouKbn())) {
            if (!keizokuEditKahi) {
                return FORWARDNAME_INPUTCONTENTS;
            }
        }

        pushDialogOkOnClickBL();

        return FORWARDNAME_CONFIRM;

    }

    void pushDialogOkOnClickBL () {
        listClean();

        if (uiBean.isKyokaFlg()) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.WHA1002);
        }
        if (C_UmuKbn.NONE.eq(uiBean.getFsttourokuflg())) {

            if (uiBean.getHubiInputSeibiLst().isEmpty() && uiBean.getHubiList1DataSource().getAllData().isEmpty()) {
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.WBF0013);
            }
        }

        uiBean.setHubiList2(uiBean.getHubiInputSeibiLst());
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.QBA0001);
    }

    String pushModoruBtnByInputContentsBL() {

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        unlockProcessBL();

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            if (C_UmuKbn.ARI.eq(uiBean.getItiranKeiyuUmuKbn())) {
                return FORWARDNAME_SELECTDATA;
            }
            return FORWARDNAME_INIT;
        }

        return FORWARDNAME_BACKTOWORKLIST;
    }

    @Transactional
    void pushKakuteiBL() {

        BizDate sysDate      = BizDate.getSysDate();
        String  kosTime      = BizDate.getSysDateTimeMilli();
        String  userId       = baseUserInfo.getUserId();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        continueLockProcessBL();

        List<HubiList1DataSourceBean> hubiLst = uiBean.getHubiList1DataSource().getAllData();
        List<HubiList2DataSourceBean> hubiInputLst = uiBean.getHubiList2DataSource().getAllData();

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();

        editSecurityKm.init(uiBean.getMosno());

        String commentMsg = editSecurityKm.encode(uiBean.getCommentareagamen());

        HT_SkHubi skHubi = syoriCTL.getSkHubiByHubisikibetukey(uiBean.getHubisikibetukey());

        if (C_UmuKbn.ARI.eq(uiBean.getFsttourokuflg())) {

            if (!hubiInputLst.isEmpty()) {

                skHubi = syoriCTL.createSkHubi();

                skHubi.setHubisikibetukey(uiBean.getHubisikibetukey());
                skHubi.setJimutetuzukinm(uiBean.getVktifdispjimutetuzukinm());
                skHubi.setUtdskknnm1kj(uiBean.getUtdskknnm1kj());
                skHubi.setUtdskknnm2kj(uiBean.getUtdskknnm2kj());
                skHubi.setTuutisakitantounmkj(uiBean.getTuutisakitantounmkj());
                skHubi.setTuutikyokasyanmkj(baseUserInfo.getUserNm());
                skHubi.setCommentarea(commentMsg);
                skHubi.setGyoumuKousinsyaId(userId);

                BizPropertyInitializer.initialize(skHubi);
            }
        }
        else {

            if (hubiInputLst.isEmpty()) {
                if (hubiLst.isEmpty()) {

                    List<HT_SkHubi> skHubiList = syoriCTL.getSkHubis();
                    skHubiList.remove(skHubi);

                    List<HT_SkHubiDetail> skHubiDetailList = skHubi.getSkHubiDetails();
                    skHubiDetailList.clear();
                }
                else {
                    List<HT_SkHubiDetail> skHubiList = skHubi.getSkHubiDetails();
                    List<HT_SkHubiDetail> mihassinSkHubiList = skHubi.getSkHubiDetailsByHasinymdNull();

                    skHubiList.removeAll(mihassinSkHubiList);

                    skHubi.setUtdskknnm1kj(uiBean.getUtdskknnm1kj());
                    skHubi.setUtdskknnm2kj(uiBean.getUtdskknnm2kj());
                    skHubi.setTuutisakitantounmkj(uiBean.getTuutisakitantounmkj());
                    skHubi.setTuutikyokasyanmkj(baseUserInfo.getUserNm());
                    skHubi.setCommentarea(commentMsg);
                    skHubi.setGyoumuKousinsyaId(userId);
                }
            }
            else {
                skHubi.setUtdskknnm1kj(uiBean.getUtdskknnm1kj());
                skHubi.setUtdskknnm2kj(uiBean.getUtdskknnm2kj());
                skHubi.setTuutisakitantounmkj(uiBean.getTuutisakitantounmkj());
                skHubi.setTuutikyokasyanmkj(baseUserInfo.getUserNm());
                skHubi.setCommentarea(commentMsg);
                skHubi.setGyoumuKousinsyaId(userId);
            }
        }

        if (!hubiInputLst.isEmpty()) {

            Integer maxRenno = sinkeiyakuDomManager
                .getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(uiBean.getMosno(), uiBean.getHubisikibetukey());

            if (maxRenno != null) {

                maxRenno = maxRenno + 1;
            }
            else {

                maxRenno = 1;
            }

            skHubi.getSkHubiDetails().removeAll(skHubi.getSkHubiDetailsByHasinymdNull());
            sinkeiyakuDomManager.flush();
            for (HubiList2DataSourceBean hubiInputBean : hubiInputLst) {
                String renrakuJikou = editSecurityKm.encode(hubiInputBean.getTyoubundisprenrakujikou());

                HT_SkHubiDetail skHubiDetail = skHubi.createSkHubiDetail();
                skHubiDetail.setRenno3keta(maxRenno);
                skHubiDetail.setSyoruiCd(hubiInputBean.getHubisyoruicd());
                skHubiDetail.setSkhubikoumokucd(hubiInputBean.getDispinputskhubikoumoku());
                skHubiDetail.setSkhubinaiyoucd(hubiInputBean.getDispinputhubinaiyoucd());
                skHubiDetail.setSkseibisijinaiyoucd(hubiInputBean.getDispinputskseibisijinaiyou());
                skHubiDetail.setTyoubunflg(hubiInputBean.getTyoubunflg());
                skHubiDetail.setSkrenrakujikou(renrakuJikou);
                skHubiDetail.setTrkymd(hubiInputBean.getDispinputtrkymd());
                skHubiDetail.setHassinsakikbn(hubiInputBean.getDispinputhassinsakikbn());
                skHubiDetail.setHasinkyokakbn(hubiInputBean.getDispinputhasinkyokakbn());
                skHubiDetail.setGyoumuKousinsyaId(userId);
                skHubiDetail.setGyoumuKousinTime(kosTime);

                BizPropertyInitializer.initialize(skHubiDetail);
                maxRenno ++;
            }
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo =
            bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        if (gyoumuKouteiInfo == null) {
            unlockProcessBL();
            throw new CommonBizAppException(
                MessageUtil.getMessage(DDID_BASEINFO_MOSNO.getErrorResourceKey()) + " = " + uiBean.getMosno());
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userId);
        mosnaiCheckParam.setKosTime(kosTime);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        if (!C_SeirituKbn.SEIRITU.eq(syoriCTL.getSeiritukbn()) &&
            !C_SeirituKbn.HUSEIRITU.eq(syoriCTL.getSeiritukbn())){

            mosnaiCheck.exec(mosnaiCheckParam);
        }

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        String tyouhyouKey = null;
        if (C_HbtyhyoutKbn.ONLINE.eq(uiBean.getHbtyhyoutkbn())) {

            tyouhyouKey = editPdfHubiTyouhyou.exec(uiBean.getHubisikibetukey(), mosnaiCheckParam, sysDate);

            uiBean.setTyouhyouKey(tyouhyouKey);
        }

        long skDetailCount = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn(
            uiBean.getMosno(), uiBean.getHubisikibetukey());
        if (skDetailCount > 0) {
            uiBean.setMihassinhubiumu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setMihassinhubiumu(C_UmuKbn.NONE);
        }

        if (!BizUtil.isBlank(tyouhyouKey)) {
            if (!C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI.eq(syoriCTL.getHubikaisyoujoutaikbn())) {
                uiBean.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI);
            }
            else {
                uiBean.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI);
            }
        }
        else {
            uiBean.setHubikaisyoujoutaikbn(syoriCTL.getHubikaisyoujoutaikbn());
        }

        syoriCTL.setMihassinhubiumu(uiBean.getMihassinhubiumu());
        syoriCTL.setHubikaisyoujoutaikbn(uiBean.getHubikaisyoujoutaikbn());
        syoriCTL.setGyoumuKousinsyaId(userId);
        syoriCTL.setGyoumuKousinTime(kosTime);

        sinkeiyakuDomManager.update(syoriCTL);

        bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());

        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
        skProcessForwardInBean.setKouteiLockkey(getKouteiLockKey());
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.BLNK);
        skProcessForwardInBean.setSyoriComment(uiBean.getCommentareagamen());

        SkProcessForwardHubiTouroku skProcessForwardHubiTouroku =
            SWAKInjector.getInstance(SkProcessForwardHubiTouroku.class);
        skProcessForwardHubiTouroku.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);
        skProcessUpdate.exec(mosnaiCheckParam.getDataSyoriControl(), getKouteiLockKey(), null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL, uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsg);
                }
                errorMessageCollector.throwBizLogicException();
            }
        }

        unlockProcessBL();


        StringBuffer msgOut = new StringBuffer();

        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> kekkaGmnMsgList = mosnaiCheckParam.getListKekkaGmnMsg();

        for(String msg : kekkaGmnMsgList) {
            msgOut.append(KAIGYOU).append(msg);
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
    }

    void pushModoruBtnByConfirmBL() {

        createList();

        chkWarning();

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);

        continueLockProcessBL();

        uiBean.setKeizokuEditKahi(true);
    }

    void printHyoujiOut() {
        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void printOut() {
        outputReport.outputPDFByJoinKey(uiBean.getTyouhyouKey());
    }

    void unlockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    @SuppressWarnings("resource")
    void callAjaxHubiKbn() throws IOException {

        HttpServletRequest req = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse res = SWAKInjector.getInstance(HttpServletResponse.class);

        String paramSyoruiCd = req.getParameter(AJAX_POST_PARAM_SYORUICD);

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.valueOf(paramSyoruiCd);

        List<String> hubiKbnList = Lists.newArrayList();

        if (!C_SyoruiCdKbn.BLNK.eq(syoruiCd)) {

            List<HM_SkHubiKoumoku> skHubiKoumokuList = sinkeiyakuDomManager.getSkHubiKoumokusBySyoruiCd(syoruiCd);

            skHubiKoumokuList = new SortHM_SkHubiKoumoku().OrderHM_SkHubiKoumokuByHyoujijyunAsc(skHubiKoumokuList);

            for (HM_SkHubiKoumoku skHubiKoumoku : skHubiKoumokuList) {
                hubiKbnList.add(skHubiKoumoku.getSkhubikoumokucd() + "@@" +
                    skHubiKoumoku.getSkhubikoumokucd() + "：" + skHubiKoumoku.getSkhubikoumoku());
            }
        }

        String responseJson = JSON.encode(hubiKbnList);

        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println(responseJson);
        out.close();
    }

    @SuppressWarnings("resource")
    void callAjaxHubiReason() throws IOException {

        HttpServletRequest req = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse res = SWAKInjector.getInstance(HttpServletResponse.class);

        String paramSkHubiKoumokuCd = req.getParameter(AJAX_POST_PARAM_SKHUBIKOUMOKUCD);

        List<String> hubiReasonList = Lists.newArrayList();

        if (!BizUtil.isBlank(paramSkHubiKoumokuCd)) {
            List<HM_SkHubiNaiyou> skHubiNaiyouList =
                sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd(paramSkHubiKoumokuCd);

            skHubiNaiyouList = new SortHM_SkHubiNaiyou().OrderHM_SkHubiNaiyouByHyoujijyunAsc(skHubiNaiyouList);

            hubiReasonList.add(String.valueOf(skHubiNaiyouList.size()));

            for (HM_SkHubiNaiyou skHubiNaiyou : skHubiNaiyouList) {
                hubiReasonList.add(skHubiNaiyou.getSkhubinaiyoucd() + "@@" +
                    skHubiNaiyou.getSkhubinaiyoucd()  + "：" + skHubiNaiyou.getSkhubinaiyousentakumongon());
            }
        }

        List<HubiNaiyouOutBean> hubiNaiyouOutBeanList = skHubiNaiyouSet(paramSkHubiKoumokuCd);

        for (HubiNaiyouOutBean hubiNaiyouOutBean : hubiNaiyouOutBeanList) {
            hubiReasonList.add(hubiNaiyouOutBean.getHubiKoumokuCd() + "&&" +
                hubiNaiyouOutBean.getHubiNaiyouCd() + "&&" +
                hubiNaiyouOutBean.getTyoubunFlg() + "&&" +
                hubiNaiyouOutBean.getRenrakuJikou());
        }

        String responseJson = JSON.encode(hubiReasonList);

        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println(responseJson);
        out.close();
    }

    void pushTenkenInputContentsBL() {

        BizPropertyInitializer.initialize(uiBean);
        uiBean.setKeizokuEditKahi(true);

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.HUBITOUROKU.getValue());

        if (!baseUserInfo.hasAuthenticatedFunctionMode(uiBean.getKinouMode().getKinouMode())) {
            throw new BizLogicException(MessageId.EHA1073,
                C_SkkinouModeIdKbn.getContentByValue(uiBean.getKinouMode().getKinouMode()));
        }

        uiBean.setSyoriYmd(BizDate.getSysDate());
        uiBean.setNyuuryokutantounm(baseUserInfo.getUserNm());

        if (!C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) {
            uiBean.setHbtyhyoutkbn(C_HbtyhyoutKbn.ONLINE);
        }

        setModalhyoujiInfo();
    }

    void pushTenkenConfirmBL () {

        if (!baseUserInfo.hasAuthenticatedFunctionMode(C_SkkinouModeIdKbn.HUBITOUROKU.getValue())) {
            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.HUBITOUROKU.getContent());
        }

        String uniqueId = uiBean.getUniqueid2();
        SkHubiRenkeiInfo skHubiRenkeiInfo = objStrMan.retrieve(uniqueId);

        if (skHubiRenkeiInfo.isHubiTourokuHenkouFlg()) {
            setModalConfirmInfo1(skHubiRenkeiInfo);
        }
        else {
            setModalConfirmInfo2();
        }
    }

    void pushTourokuBtnByInputTenkenBL() {
        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        Iterables.removeIf(hubiList2DSBeanLst, new HubiList2DataSourceBeanPredicate());

        List<HubiList2DataSourceBean> hubiInputLst = hubiList2DSBeanLst;

        List<HubiList2DataSourceBean> hubiInputSeibiLst = Lists.newArrayList();

        checkHibiInput(hubiInputLst,hubiInputSeibiLst);

        if (!C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) {

            int dairitenKyokaCount = 0;
            if (hubiInputSeibiLst.size() > 0) {
                for (HubiList2DataSourceBean hubiInputSeibi : hubiInputSeibiLst) {
                    if (C_HasinkyokaKbn.KY.eq(hubiInputSeibi.getDispinputhasinkyokakbn()) &&
                        C_HassinsakiKbn.DRTEN.eq(hubiInputSeibi.getDispinputhassinsakikbn())) {
                        dairitenKyokaCount++;
                    }
                }

                if (dairitenKyokaCount > 3) {
                    throw new BizLogicException(MessageId.EHA0479, "代理店", "3");
                }
            }
        }

        uiBean.setHubiInputSeibiLst(hubiInputSeibiLst);

        EditSkHubiItiranNit editSkHubiItiranNit = SWAKInjector.getInstance(EditSkHubiItiranNit.class);
        int pIdx = 0;
        String skhubikoumoku = "";
        String skhubinaiyou = "";
        String skseibisijinaiyou = "";
        String skrenrakujikou = "";
        boolean keizokuEditKahi = true;

        for (HubiList1DataSourceBean dataSourceBean : uiBean.getHubiList1DataSource().getAllData()) {
            if (dataSourceBean.getDispkaisyouymd() == null) {
                String dispskhubikoumoku = dataSourceBean.getDispskhubikoumoku();
                String[] newSkhubikoumoku = dispskhubikoumoku.split("：");

                String dispskhubinaiyou = dataSourceBean.getDispskhubinaiyou();
                String[] newSkhubinaiyou = dispskhubinaiyou.split("：");
                HM_SkHubiNaiyou skHubiNaiyou = sinkeiyakuDomManager.getSkHubiNaiyou(
                    newSkhubikoumoku[0], newSkhubinaiyou[0]);
                skhubinaiyou = skHubiNaiyou.getSkhubinaiyou();

                skseibisijinaiyou = dataSourceBean.getDispskseibisijinaiyou();
                skrenrakujikou = dataSourceBean.getTyoubundisprenrakujikou();

                keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(pIdx, newSkhubikoumoku[1], skhubinaiyou,
                    skseibisijinaiyou, skrenrakujikou);

                if (!keizokuEditKahi) {
                    break;
                }

                pIdx = pIdx + 1;
            }
        }

        if (keizokuEditKahi) {
            for (HubiList2DataSourceBean dataSourceBean : hubiInputSeibiLst) {
                if (C_HasinkyokaKbn.KY.eq(dataSourceBean.getDispinputhasinkyokakbn())) {
                    HM_SkHubiKoumoku skHubiKoumoku = sinkeiyakuDomManager.getSkHubiKoumoku(
                        dataSourceBean.getHubisyoruicd(), dataSourceBean.getDispinputskhubikoumoku());
                    skhubikoumoku = skHubiKoumoku.getSkhubikoumoku();
                    HM_SkHubiNaiyou skHubiNaiyou = sinkeiyakuDomManager.getSkHubiNaiyou(
                        dataSourceBean.getDispinputskhubikoumoku(), dataSourceBean.getDispinputhubinaiyoucd());
                    skhubinaiyou = skHubiNaiyou.getSkhubinaiyou();
                    HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = sinkeiyakuDomManager.getSkSeibiSijiNaiyou(dataSourceBean.getDispinputskseibisijinaiyou());
                    skseibisijinaiyou = skSeibiSijiNaiyou.getSkseibisijinaiyou();
                    skrenrakujikou = dataSourceBean.getTyoubundisprenrakujikou();

                    keizokuEditKahi = editSkHubiItiranNit.editSkHubiItiran(pIdx, skhubikoumoku, skhubinaiyou,
                        skseibisijinaiyou, skrenrakujikou);

                    if (!keizokuEditKahi) {
                        break;
                    }

                    pIdx = pIdx + 1;
                }
            }
        }

        uiBean.setKeizokuEditKahi(keizokuEditKahi);

        if (C_MosUketukeKbn.PAPERLESSNIT.eq(uiBean.getMosuketukekbn()) &&
            C_DrtenRnrkhouKbn.NIT.eq(uiBean.getDrtenRnrkhouKbn())) {
            if (keizokuEditKahi) {
                pushDialogOkByTenkenOnClick();
            }
        }
        else {
            pushDialogOkByTenkenOnClick();
        }
    }

    void pushDialogOkByTenkenOnClick () {

        newSkHubiRenkeiInfo.setHubiList2(uiBean.getHubiInputSeibiLst());
        newSkHubiRenkeiInfo.setHubiList1(uiBean.getHubiList1DataSource().getAllData());
        newSkHubiRenkeiInfo.setTuutisakitantounmkj(uiBean.getTuutisakitantounmkj());
        newSkHubiRenkeiInfo.setUtdskknnm1kj(uiBean.getUtdskknnm1kj());
        newSkHubiRenkeiInfo.setUtdskknnm2kj(uiBean.getUtdskknnm2kj());
        newSkHubiRenkeiInfo.setHubiTourokuHenkouFlg(true);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryOutBean summaryOutBean = bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0);
        newSkHubiRenkeiInfo.setHubiTourokuKouteikanriId(summaryOutBean.getKouteiKanriId());

        if (!C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) {
            newSkHubiRenkeiInfo.setHbtyhyoutkbn(uiBean.getHbtyhyoutkbn());
        }

        objStrMan.save(uiBean.getUniqueid2(), newSkHubiRenkeiInfo);

        uiBean.setTourokuBtnFlg(true);
        uiBean.setKeizokuEditKahi(true);
    }

    @Transactional
    void pushKarisakuseiBL() {
        continueLockProcessBL();

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        Iterables.removeIf(hubiList2DSBeanLst, new HubiList2DataSourceBeanPredicate());

        List<HubiList2DataSourceBean> hubiInputLst = uiBean.getHubiList2DataSource().getAllData();

        List<HubiList2DataSourceBean> hubiInputSeibiLst = Lists.newArrayList();

        checkHibiInput(hubiInputLst, hubiInputSeibiLst);

        List<HubiList2DataSourceBean> newHubiInputSeibiLst = Lists.newArrayList();
        listAndHoryuuClean(hubiInputSeibiLst, newHubiInputSeibiLst);

        if (newHubiInputSeibiLst.size() > 3) {
            throw new BizLogicException(MessageId.EHA0479, "代理店", "3");
        }

        if (newHubiInputSeibiLst.size() == 0) {
            throw new BizLogicException(MessageId.EHA1104);
        }

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);
        String drtenCd = mosDairiten.getTratkiagcd();


        String drtenJimCd = "";
        String drtenNm = "";
        String oyadrtenCd = "";
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(drtenCd);

        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
            if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                oyadrtenCd = bzGetAgInfoBean.getOyadrtenCd();
                drtenJimCd = bzGetAgInfoBean.getDrtenJimCd();
                drtenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                break;
            }
        }

        GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);
        getSkChannelInfo.exec(null, oyadrtenCd);
        C_SkeijimuKbn skeiJimuKbn = getSkChannelInfo.getSkeiJimuKbn();

        String sapodeTelNo = getSkChannelInfo.getSapodetelno();
        String sapodeFaxNo = "";
        String faxTitle = "";

        if (!C_SkeijimuKbn.SHOP.eq(skeiJimuKbn)) {
            sapodeFaxNo = getSkChannelInfo.getSapodefaxno();
            faxTitle = "FAX：";
        }

        String[] skHubiKoumokus = new String[3];
        String[] skHubiNaiyous = new String[3];
        String[] skSeibishijiNaiyous = new String[3];
        String[] skHubiKoumoku_Tyoubuns = new String[3];
        String[] skHubiNaiyou_Tyoubuns = new String[3];
        String[] skSeibishijiNaiyou_Tyoubuns = new String[3];
        String[] skRenrakuJikou_Tyoubuns = new String[3];
        C_UmuKbn tyoubunFlg = C_UmuKbn.NONE;
        String[] skRenrakuJikous = new String[3];
        String skHubiKoumoku = null;
        String skHubiNaiyou = null;
        String skSeibishijiNaiyou = null;
        String skRenrakuJikou = null;
        int tuujyouCount = 0;
        int tyoubunCount = 0;

        for (HubiList2DataSourceBean dataSourceBean : newHubiInputSeibiLst) {

            HM_SkHubiNaiyou skHubiNaiyouMasuta =
                sinkeiyakuDomManager.getSkHubiNaiyou(dataSourceBean.getDispinputskhubikoumoku(), dataSourceBean.getDispinputhubinaiyoucd());
            if (skHubiNaiyouMasuta != null) {
                skHubiNaiyou = skHubiNaiyouMasuta.getSkhubinaiyou();
            }
            else {
                skHubiNaiyou = "";
            }

            HM_SkHubiKoumoku skHubiKoumokuMasuta =
                sinkeiyakuDomManager.getSkHubiKoumoku(dataSourceBean.getHubisyoruicd(), dataSourceBean.getDispinputskhubikoumoku());

            if (skHubiKoumokuMasuta != null) {
                skHubiKoumoku = skHubiKoumokuMasuta.getSkhubikoumoku();
            }
            else {
                skHubiKoumoku = "";
            }

            HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou =
                sinkeiyakuDomManager.getSkSeibiSijiNaiyou(dataSourceBean.getDispinputskseibisijinaiyou());
            if (skSeibiSijiNaiyou != null) {
                skSeibishijiNaiyou = skSeibiSijiNaiyou.getSkseibisijinaiyou();
            }
            else {
                skSeibishijiNaiyou = "";
            }

            tyoubunFlg = dataSourceBean.getTyoubunflg();

            skRenrakuJikou = dataSourceBean.getTyoubundisprenrakujikou();

            if (C_UmuKbn.ARI.eq(tyoubunFlg)) {
                skHubiNaiyou_Tyoubuns[tyoubunCount] = skHubiNaiyou;
                skHubiKoumoku_Tyoubuns[tyoubunCount] = skHubiKoumoku;
                skSeibishijiNaiyou_Tyoubuns[tyoubunCount] = skSeibishijiNaiyou;
                skRenrakuJikou_Tyoubuns[tyoubunCount] = skRenrakuJikou;
                tyoubunCount++;
            }
            else {
                skHubiNaiyous[tuujyouCount] = skHubiNaiyou;
                skHubiKoumokus[tuujyouCount] = skHubiKoumoku;
                skSeibishijiNaiyous[tuujyouCount] = skSeibishijiNaiyou;
                skRenrakuJikous[tuujyouCount] = skRenrakuJikou;
                tuujyouCount++;
            }
        }

        String tyouhyouMosNo= editMosnoHyphen_3_3_3(uiBean.getMosno());

        String tyouhyouSetMosNo= editMosnoHyphen_3_3_3(mosKihon.getAitemosno());

        SkHubituutiBean skHubituutiBean = SWAKInjector.getInstance(SkHubituutiBean.class);
        ArrayList<IReportDataSouceBean> skHubituutityoubunDataSourceBeanLst = new ArrayList<>();
        BzDairitenAtesakiBean bzDairitenAtesakiBean = SWAKInjector.getInstance(BzDairitenAtesakiBean.class);
        skHubituutiBean.setIrKykkbn(mosKihon.getKykkbn());
        skHubituutiBean.setIrMosno(tyouhyouMosNo);
        skHubituutiBean.setIrAitemosno(tyouhyouSetMosNo);
        skHubituutiBean.setIrDrtenjimcd(drtenJimCd);
        skHubituutiBean.setIrKyknmkj(mosKihon.getKyknmkj());
        skHubituutiBean.setIrHhknnmkj(mosKihon.getHhknnmkj());
        skHubituutiBean.setIrSkhubikoumoku1(skHubiKoumokus[0]);
        skHubituutiBean.setIrSkhubinaiyou1(skHubiNaiyous[0]);
        skHubituutiBean.setIrSkseibisijinaiyou1(skSeibishijiNaiyous[0]);
        skHubituutiBean.setIrSkrenrakujikou1(skRenrakuJikous[0]);
        skHubituutiBean.setIrSkhubikoumoku2(skHubiKoumokus[1]);
        skHubituutiBean.setIrSkhubinaiyou2(skHubiNaiyous[1]);
        skHubituutiBean.setIrSkseibisijinaiyou2(skSeibishijiNaiyous[1]);
        skHubituutiBean.setIrSkrenrakujikou2(skRenrakuJikous[1]);
        skHubituutiBean.setIrSkhubikoumoku3(skHubiKoumokus[2]);
        skHubituutiBean.setIrSkhubinaiyou3(skHubiNaiyous[2]);
        skHubituutiBean.setIrSkseibisijinaiyou3(skSeibishijiNaiyous[2]);
        skHubituutiBean.setIrSkrenrakujikou3(skRenrakuJikous[2]);
        skHubituutiBean.setIrTyoubunouthubikensuu(tyoubunCount);
        skHubituutiBean.setIrTuujyououthubikensuu(tuujyouCount);
        skHubituutiBean.setIrOyadrtencd(oyadrtenCd);
        skHubituutiBean.setIrAisyoumei(mosKihon.getAisyoumeikbn().getContent());
        skHubituutiBean.setIrKarisakuseiumu(C_UmuKbn.ARI);

        String utdskKnNm2 = uiBean.getUtdskknnm2kj();

        if (!BizUtil.isBlank(utdskKnNm2)) {
            utdskKnNm2 = "（" + utdskKnNm2 + "）";
        }

        bzDairitenAtesakiBean.setIrDrtennmkj(drtenNm);
        bzDairitenAtesakiBean.setIrTratkitantounmkj(uiBean.getTuutisakitantounmkj());
        bzDairitenAtesakiBean.setIrDrtenutdskknnm1(uiBean.getUtdskknnm1kj());
        bzDairitenAtesakiBean.setIrDrtenutdskknnm2(utdskKnNm2);
        bzDairitenAtesakiBean.setIrDrtenhassouymd("");
        bzDairitenAtesakiBean.setIrToiawasefaxmidasi(faxTitle);
        bzDairitenAtesakiBean.setIrToiawasetantounm(baseUserInfo.getUserNm());
        bzDairitenAtesakiBean.setIrToiawasetelno(sapodeTelNo);
        bzDairitenAtesakiBean.setIrToiawasefaxno(sapodeFaxNo);
        bzDairitenAtesakiBean.setIrSkeijimukbn(skeiJimuKbn);

        if (tyoubunCount > 0) {
            for (int i = 0; i < tyoubunCount; i++) {

                SkHubituutityoubunDataSourceBean skHubituutityoubunDataSourceBean =
                    SWAKInjector.getInstance(SkHubituutityoubunDataSourceBean.class);
                skHubituutityoubunDataSourceBean.setIrSkhubikoumoku(skHubiKoumoku_Tyoubuns[i]);
                skHubituutityoubunDataSourceBean.setIrSkhubinaiyou(skHubiNaiyou_Tyoubuns[i]);
                skHubituutityoubunDataSourceBean.setIrSkseibisijinaiyou(skSeibishijiNaiyou_Tyoubuns[i]);
                skHubituutityoubunDataSourceBean.setIrSkrenrakujikou(skRenrakuJikou_Tyoubuns[i]);
                skHubituutityoubunDataSourceBeanLst.add(skHubituutityoubunDataSourceBean);
            }
        }

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.SK_HUBITUUTI_KARISAKUSEI;
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            kinou.getCategoryId(),
            kinou.getKinouId(),
            syoruiCdKbn);

        reportServicesBean.setKensakuKeys(new String[] {skeiJimuKbn.getValue(), oyadrtenCd, uiBean.getMosno()});
        reportServicesBean.setSyoriYmd(BizDate.getSysDate());

        reportServicesBean.addParamObjects(syoruiCdKbn, skHubituutityoubunDataSourceBeanLst, skHubituutiBean,
            bzDairitenAtesakiBean);

        String tyouhyouKey = createReport.execNoCommit(reportServicesBean);

        uiBean.setKarisakuseiTyouhyouKey(tyouhyouKey);
    }

    void karisakuseiPrintOut() {
        String wkKarisakuseiTyouhyouJoinKey = uiBean.getKarisakuseiTyouhyouKey();
        uiBean.setKarisakuseiTyouhyouKey(null);
        OutputReport wkOutputReport = SWAKInjector.getInstance(OutputReport.class);
        wkOutputReport.outputPDFWithDelByJoinKey(wkKarisakuseiTyouhyouJoinKey);
    }


    private void continueLockProcessBL() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    private void taskStartBL() {
        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        if (C_SkkinouModeIdKbn.HUBIHASSIN.getValue().equals(uiBean.getBzWorkflowInfo().getTaskId()) ) {

            C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                getKouteiLockKey(),
                baseUserInfo.getUserId());

            if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0111);
            }
            else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0112);
            }
        }
    }

    private List<HT_SkHubi> chkKihonTbl() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_BASEINFO_MOSNO.getErrorResourceKey()));
        }

        uiBean.setMosuketukekbn(syoriCTL.getMosuketukekbn());

        C_SeirituKbn seirituKbn = syoriCTL.getSeiritukbn();
        if (!C_SeirituKbn.NONE.eq(seirituKbn)) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        if (!C_UmuKbn.ARI.eq(syoriCTL.getMosnrkumu())) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        HT_MosDairiten mosDairiten  = syoriCTL.getMosDairitenByRenno(1);
        if (mosDairiten != null) {
            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            List<BzGetAgInfoBean> bzGetAgInfoList = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

            if (bzGetAgInfoList == null) {
                throw new BizLogicException(MessageId.EHA0434);
            }

            boolean shiteiOyaFlg = false;
            for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoList) {

                if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                    shiteiOyaFlg = true;
                    break;
                }
            }

            if (!shiteiOyaFlg) {
                throw new BizLogicException(MessageId.EHA0434);
            }
        }
        else {
            throw new BizLogicException(MessageId.EHA0434);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        if (mosKihon == null) {
            throw new CommonBizAppException(
                MessageUtil.getMessage(MessageId.EBS0004, "申込基本テーブル", "申込番号", uiBean.getMosno()));
        }

        uiBean.setSyoriCTL(syoriCTL);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        List<HT_SkHubi> skHubiList = Lists.newArrayList();

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            HT_SkHubi skHubi = syoriCTL.getSkHubiByHubisikibetukey(uiBean.getBzWorkflowInfo().getKouteiKanriId());

            if (skHubi == null) {
                uiBean.setFsttourokuflg(C_UmuKbn.ARI);
                uiBean.setHubisikibetukey(uiBean.getBzWorkflowInfo().getKouteiKanriId());
            }
            else {
                uiBean.setFsttourokuflg(C_UmuKbn.NONE);
                uiBean.setHubisikibetukey(skHubi.getHubisikibetukey());
            }

            skHubiList.add(skHubi);
        }
        else {
            skHubiList = syoriCTL.getSkHubis();

            if (skHubiList.isEmpty()) {
                uiBean.setFsttourokuflg(C_UmuKbn.ARI);
            }
            else {
                uiBean.setFsttourokuflg(C_UmuKbn.NONE);
            }
        }

        return skHubiList;
    }

    private void setHubiTourokuInfo(HT_SkHubi pSkHubi) {

        BzGetProcessSummaryInBean summaryInfoInBean = new BzGetProcessSummaryInBean();
        summaryInfoInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
        summaryInfoInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInfoInBean.setMosNo(uiBean.getMosno());
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> outBeanInfoList = bzGetProcessSummary.exec(summaryInfoInBean);

        uiBean.getBzWorkflowInfo().setKouteiKanriId(outBeanInfoList.get(0).getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(outBeanInfoList.get(0).getJimuTetuzukiCd());
        uiBean.getBzWorkflowInfo().setTaskId(outBeanInfoList.get(0).getNowNodoId());

        chkWarning();

        BzGetProcessSummaryInBean summaryStartInBean = new BzGetProcessSummaryInBean();
        summaryStartInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        summaryStartInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryStartInBean.setMosNo(uiBean.getMosno());

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> outBeanStartList = bzGetProcessSummary.exec(summaryStartInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(outBeanStartList.get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(outBeanStartList.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        taskStartBL();

        setKouteiInfo();
        setSyoruiInfo();
        setSkeittdktyuuiInfo();
        setHubiInfo(pSkHubi);
        createList();
    }

    private void setKouteiInfo() {

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        if (ISkCommonKoumoku.NODEID_KOUTEIKAISI.equals(uiBean.getBzWorkflowInfo().getTaskId())
            || ISkCommonKoumoku.NODEID_KOUTEIKANRYOU.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            DM_Jimutetuzuki jimutetuzuki =
                workflowDomManager.getJimutetuzuki(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU);
            DM_JimutetuzukiTask jimutetuzukiTask =
                jimutetuzuki.getJimutetuzukiTaskByWorkflowTskId(ISkCommonKoumoku.NODEID_HUBITOUROKU);
            uiBean.setVktifdisptasknm(jimutetuzukiTask.getWorkflowTskNm());
        }
    }

    private void setSyoruiInfo() {

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);
    }

    private void setSkeittdktyuuiInfo() {

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst =
            getSkTtdkTyuui.getTtdkTyuui(uiBean.getSyoriCTL().getMosno(), C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        if (skTtdkTyuuiLst == null) {
            return;
        }

        List<ToriatukaiTyuuiInfoDataSourceBean> toriatukaiTyuuiInfoLst = Lists.newArrayList();

        for (HT_SkTtdkTyuui skTtdkTyuui : skTtdkTyuuiLst) {

            String commentEncode = EditSecurityKm.getDecodeData(uiBean.getMosno(), skTtdkTyuui.getSkeittdktyuuinaiyou());

            ToriatukaiTyuuiInfoDataSourceBean toriatukaiTyuuiInfoBean = new ToriatukaiTyuuiInfoDataSourceBean();

            toriatukaiTyuuiInfoBean.setDispskeittdktyuitrttrkymd(skTtdkTyuui.getTrkymd());
            toriatukaiTyuuiInfoBean.setDispskeittdktyuitrtnaiyo(commentEncode);
            AM_User user = skTtdkTyuui.getUser();
            if (user != null) {
                toriatukaiTyuuiInfoBean.setDispskeittdktyuitrttantou(user.getUserNm());
            }

            toriatukaiTyuuiInfoLst.add(toriatukaiTyuuiInfoBean);
        }

        uiBean.setToriatukaiTyuuiInfo(toriatukaiTyuuiInfoLst);
    }

    private void setHubiInfo(HT_SkHubi pSkHubi) {

        HT_MosDairiten mosDairiten = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno()).getMosDairitenByRenno(1);
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = null;

        if (mosDairiten != null) {
            skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(mosDairiten.getOyadrtencd());

            if (skDairitenKobetuJyouhou != null) {
                uiBean.setDrtenRnrkhouKbn(skDairitenKobetuJyouhou.getDrtenRnrkhouKbn());
            }
        }

        if (pSkHubi == null) {
            if (mosDairiten != null) {
                BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());

                if (skDairitenKobetuJyouhou != null) {
                    uiBean.setUtdskknnm1kj(skDairitenKobetuJyouhou.getUtdskknnm1kj());
                    uiBean.setUtdskknnm2kj(skDairitenKobetuJyouhou.getUtdskknnm2kj());
                    uiBean.setDrtenRnrkhouKbn(skDairitenKobetuJyouhou.getDrtenRnrkhouKbn());
                }
                if (bzGetBsInfoBean != null) {
                    uiBean.setTuutisakitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm());
                }
            }
        }
        else {

            EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
            editSecurityKm.init(uiBean.getMosno());

            uiBean.setUtdskknnm1kj(pSkHubi.getUtdskknnm1kj());
            uiBean.setUtdskknnm2kj(pSkHubi.getUtdskknnm2kj());
            uiBean.setTuutisakitantounmkj(pSkHubi.getTuutisakitantounmkj());
            uiBean.setCommentareagamen(editSecurityKm.decode(pSkHubi.getCommentarea()));

            SortHT_SkHubiDetail sortHTSkHubiDetail = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);
            List<HT_SkHubiDetail> hassinSkHubiDetailList =
                sortHTSkHubiDetail.OrderHT_SkHubiDetailByHasinymdRenno3ketaAsc(sinkeiyakuDomManager
                    .getSyoriCTL(pSkHubi.getMosno()).
                    getSkHubiByHubisikibetukey(pSkHubi.getHubisikibetukey()).getSkHubiDetailsByHasinymd());

            List<HubiList1DataSourceBean> dispHubiList = Lists.newArrayList();

            for (HT_SkHubiDetail hassinSkHubiDetail : hassinSkHubiDetailList) {

                HubiList1DataSourceBean hubiBean = SWAKInjector.getInstance(HubiList1DataSourceBean.class);

                hubiBean.setDisptrkymd(hassinSkHubiDetail.getTrkymd());
                hubiBean.setHubisyoruicd(hassinSkHubiDetail.getSyoruiCd());

                HM_SkHubiKoumoku skHubiKoumoku = hassinSkHubiDetail.getSkHubiKoumoku();
                if (skHubiKoumoku != null) {
                    hubiBean.setDispskhubikoumoku(
                        skHubiKoumoku.getSkhubikoumokucd() + "：" + skHubiKoumoku.getSkhubikoumoku());
                }

                HM_SkHubiNaiyou skHubiNaiyou = hassinSkHubiDetail.getSkHubiNaiyou();
                if (skHubiNaiyou != null) {
                    hubiBean.setDispskhubinaiyou(
                        skHubiNaiyou.getSkhubinaiyoucd() + "：" + skHubiNaiyou.getSkhubinaiyousentakumongon());
                }

                HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = hassinSkHubiDetail.getSkSeibiSijiNaiyou();
                if (skSeibiSijiNaiyou != null) {
                    hubiBean.setDispskseibisijinaiyou(skSeibiSijiNaiyou.getSkseibisijinaiyou());
                }

                hubiBean.setTyoubundisprenrakujikou(editSecurityKm.decode(hassinSkHubiDetail.getSkrenrakujikou()));
                hubiBean.setDisphassinymd(hassinSkHubiDetail.getHasinymd());
                hubiBean.setDispkaisyouymd(hassinSkHubiDetail.getKaisyouymd());
                hubiBean.setDisphasinkyokakbn(hassinSkHubiDetail.getHasinkyokakbn());
                hubiBean.setDisphassinsakikbn(hassinSkHubiDetail.getHassinsakikbn());
                AM_User user = hassinSkHubiDetail.getUser();
                if (user != null) {
                    hubiBean.setDispnyuryokutantounm(user.getUserNm());
                }

                dispHubiList.add(hubiBean);
            }

            uiBean.setHubiList1(dispHubiList);

            List<HT_SkHubiDetail> miHassinSkHubiDetailList = sinkeiyakuDomManager
                .getSyoriCTL(pSkHubi.getMosno()).
                getSkHubiByHubisikibetukey(pSkHubi.getHubisikibetukey()).getSkHubiDetailsByHasinymdNull();

            List<HubiList2DataSourceBean> inputHubiList = Lists.newArrayList();

            String sakujyoLink = MessageUtil.getMessage(DDID_HUBILIST2_SAKUJYOLINK.getErrorResourceKey());

            for (HT_SkHubiDetail miHassinSkHubiDetail : miHassinSkHubiDetailList) {

                HubiList2DataSourceBean hubiBean = SWAKInjector.getInstance(HubiList2DataSourceBean.class);

                hubiBean.setDispinputtrkymd(miHassinSkHubiDetail.getTrkymd());
                hubiBean.setHubisyoruicd(miHassinSkHubiDetail.getSyoruiCd());
                HM_SkHubiKoumoku skHubiKoumoku = miHassinSkHubiDetail.getSkHubiKoumoku();
                if (skHubiKoumoku != null) {
                    hubiBean.setDispinputskhubikoumoku(skHubiKoumoku.getSkhubikoumokucd());
                    createHubiKbnPulldownList(hubiBean);
                }

                HM_SkHubiNaiyou skHubiNaiyou = miHassinSkHubiDetail.getSkHubiNaiyou();
                if (skHubiNaiyou != null) {
                    hubiBean.setDispinputhubinaiyoucd(skHubiNaiyou.getSkhubinaiyoucd());
                    createHubiReasonPulldownList(hubiBean);
                }

                hubiBean.setDispinputskseibisijinaiyou(miHassinSkHubiDetail.getSkseibisijinaiyoucd());
                createSkseibisijinaiyouPulldownList(hubiBean);
                hubiBean.setTyoubundisprenrakujikou(editSecurityKm.decode(miHassinSkHubiDetail.getSkrenrakujikou()));
                hubiBean.setDispinputtyoubunflg(miHassinSkHubiDetail.getTyoubunflg());
                hubiBean.setDispinputhasinkyokakbn(miHassinSkHubiDetail.getHasinkyokakbn());
                hubiBean.setDispinputhassinsakikbn(miHassinSkHubiDetail.getHassinsakikbn());
                hubiBean.setSakujyoLink(sakujyoLink);

                AM_User user = miHassinSkHubiDetail.getUser();
                if (user != null) {
                    hubiBean.setDispinputnyuryokutantounm(user.getUserNm());
                }

                hubiBean.setSakujyoflg(C_Delflag.BLNK);

                inputHubiList.add(hubiBean);
            }

            uiBean.setHubiList2(inputHubiList);
        }

        uiBean.setHbtyhyoutkbn(C_HbtyhyoutKbn.ONLINE);
    }

    private void createHubiKbnPulldownList(HubiList2DataSourceBean pHubiList2DataSourceBean) {

        pHubiList2DataSourceBean.clearDispinputskhubikoumokuOptionBeanList();

        UserDefsList hubiKbnList = new UserDefsList();
        C_SyoruiCdKbn syoruiCd = pHubiList2DataSourceBean.getHubisyoruicd();

        hubiKbnList.add(new LabelValuePair("", ""));

        if (!C_SyoruiCdKbn.BLNK.eq(syoruiCd)) {
            List<HM_SkHubiKoumoku> skHubiKoumokuList = sinkeiyakuDomManager.getSkHubiKoumokusBySyoruiCd(syoruiCd);

            skHubiKoumokuList = new SortHM_SkHubiKoumoku().OrderHM_SkHubiKoumokuByHyoujijyunAsc(skHubiKoumokuList);

            for (HM_SkHubiKoumoku skHubiKoumoku : skHubiKoumokuList) {

                hubiKbnList.add(new LabelValuePair(
                    skHubiKoumoku.getSkhubikoumokucd() + "：" + skHubiKoumoku.getSkhubikoumoku(),
                    skHubiKoumoku.getSkhubikoumokucd()));
            }
        }

        pHubiList2DataSourceBean.setDispinputskhubikoumokuOptionBeanList(hubiKbnList);
    }

    private void createHubiReasonPulldownList(HubiList2DataSourceBean pHubiList2DataSourceBean) {

        pHubiList2DataSourceBean.clearDispinputhubinaiyoucdOptionBeanList();
        UserDefsList hubiReasonList = new UserDefsList();
        String skHubiKoumokuCd = pHubiList2DataSourceBean.getDispinputskhubikoumoku();

        hubiReasonList.add(new LabelValuePair("", ""));

        if (!BizUtil.isBlank(skHubiKoumokuCd)) {
            List<HM_SkHubiNaiyou> skHubiNaiyouList =
                sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd(skHubiKoumokuCd);

            skHubiNaiyouList = new SortHM_SkHubiNaiyou().OrderHM_SkHubiNaiyouByHyoujijyunAsc(skHubiNaiyouList);

            for (HM_SkHubiNaiyou skHubiNaiyou : skHubiNaiyouList) {

                hubiReasonList.add(new LabelValuePair(
                    skHubiNaiyou.getSkhubinaiyoucd() + "：" + skHubiNaiyou.getSkhubinaiyousentakumongon(),
                    skHubiNaiyou.getSkhubinaiyoucd()));
            }
        }

        pHubiList2DataSourceBean.setDispinputhubinaiyoucdOptionBeanList(hubiReasonList);
    }

    private void createSkseibisijinaiyouPulldownList(HubiList2DataSourceBean pHubiList2DataSourceBean) {

        pHubiList2DataSourceBean.clearDispinputskseibisijinaiyouOptionBeanList();

        List<HM_SkSeibiSijiNaiyou> skSeibiSijiNaiyouList = skHubiTourokuDao.getSkSeibiSijiNaiyou();

        UserDefsList seibiSijiNaiyouList = new UserDefsList();

        seibiSijiNaiyouList.add(new LabelValuePair("", ""));

        for (HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou : skSeibiSijiNaiyouList) {

            seibiSijiNaiyouList.add(new LabelValuePair(
                skSeibiSijiNaiyou.getSkseibisijinaiyoucd() + "：" + skSeibiSijiNaiyou.getSkseibisijinaiyou(),
                skSeibiSijiNaiyou.getSkseibisijinaiyoucd()));
        }

        pHubiList2DataSourceBean.setDispinputskseibisijinaiyouOptionBeanList(seibiSijiNaiyouList);
    }

    private String getKouteiLockKey() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        return kouteiLockKey;
    }

    private void chkWarning() {

        hanteiDoujiMos.hanteiDoujiMos(uiBean.getMosno());

        if (C_UmuKbn.ARI.eq(hanteiDoujiMos.getDoujiMosUmu())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                MessageId.WHC0102, hanteiDoujiMos.getMsgMosnoList());
        }

        GetMsgAitemosno getMsgAitemosno = SWAKInjector.getInstance(GetMsgAitemosno.class);

        int kekkaKbn =
            getMsgAitemosno.exec(uiBean.getSyoriCTL().getMosnrkumu(), uiBean.getSyoriCTL().getMosKihon().getAitemosno());

        if (kekkaKbn == GetMsgAitemosno.KEKKAKBN_ARI) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                getMsgAitemosno.getS_gmmsgid(), uiBean.getSyoriCTL().getMosKihon().getAitemosno());
        }
    }

    private boolean chkMaxRow(String pValue, int pLineCount, int pLineMaxSize) {
        if (BizUtil.isBlank(pValue)) {
            return false;
        }

        String lineSeparator = null;
        int lineCount = 0;

        if (pValue.indexOf("\r\n") != -1) {
            lineSeparator = "\r\n";
        }
        else if (pValue.indexOf("\r") != -1) {
            lineSeparator = "\r";
        }
        else if (pValue.indexOf("\n") != -1) {
            lineSeparator = "\n";
        }

        String[] splictCheckLst = null;

        if (lineSeparator != null) {
            splictCheckLst = pValue.split(lineSeparator);
        }
        else {
            splictCheckLst = new String []{ pValue };
        }

        for (String row : splictCheckLst) {
            if (row.length() > pLineMaxSize) {
                lineCount = lineCount +
                    Integer.valueOf(BizNumber.valueOf(row.length() - 1).divide(pLineMaxSize, 0, RoundingMode.DOWN).toString());
            }
        }

        if (splictCheckLst.length + lineCount > pLineCount) {
            return true;
        }

        return false;
    }

    private void createList() {

        uiBean.setSyoriYmd(BizDate.getSysDate());
        uiBean.setNyuuryokutantounm(baseUserInfo.getUserNm());

        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        int sizeList2 = hubiList2DSBeanLst.size();
        int sizeList1 = uiBean.getHubiList1DataSource().getAllData().size();

        String sakujyoLink = MessageUtil.getMessage(DDID_HUBILIST2_SAKUJYOLINK.getErrorResourceKey());

        for (int i = sizeList2; i < MAX_ROW_COUNT - sizeList1; i++) {
            HubiList2DataSourceBean hubiList2DSBean = new HubiList2DataSourceBean();

            hubiList2DSBean.setHubisyoruicd(C_SyoruiCdKbn.BLNK);
            hubiList2DSBean.setDispinputskhubikoumoku(null);
            hubiList2DSBean.setDispinputhubinaiyoucd(null);
            hubiList2DSBean.setDispinputskseibisijinaiyou(null);
            hubiList2DSBean.setTyoubundisprenrakujikou(null);
            hubiList2DSBean.setDispinputtrkymd(BizDate.getSysDate());
            hubiList2DSBean.setDispinputhassinsakikbn(C_HassinsakiKbn.DRTEN);
            hubiList2DSBean.setDispinputhasinkyokakbn(C_HasinkyokaKbn.HORYUU);
            hubiList2DSBean.setDispinputnyuryokutantounm(baseUserInfo.getUserNm());
            hubiList2DSBean.setSakujyoLink(sakujyoLink);

            if(i == 0){
                hubiList2DSBean.setSakujyoflg(C_Delflag.BLNK);
            }
            else{
                hubiList2DSBean.setSakujyoflg(C_Delflag.SAKUJYO);
            }

            createSkseibisijinaiyouPulldownList(hubiList2DSBean);

            hubiList2DSBeanLst.add(hubiList2DSBean);
        }

        uiBean.setHubiList2(hubiList2DSBeanLst);
    }

    private void listClean() {
        List<HubiList2DataSourceBean> hubiList2DSBeanLst = uiBean.getHubiList2DataSource().getAllData();
        Iterables.removeIf(hubiList2DSBeanLst, new HubiList2DataSourceBeanPredicate());
        uiBean.setHubiList2(hubiList2DSBeanLst);
    }

    private class HubiList2DataSourceBeanPredicate implements Predicate<HubiList2DataSourceBean>{

        public HubiList2DataSourceBeanPredicate() {
        }

        @Override
        public boolean apply(HubiList2DataSourceBean bean) {
            return C_Delflag.SAKUJYO.eq(bean.getSakujyoflg());
        }
    }

    private List<HubiNaiyouOutBean> skHubiNaiyouSet(String pSkHubiKoumokuCd) {

        List<HubiNaiyouOutBean> hubiNaiyouOutBeanList = Lists.newArrayList();

        List<HM_SkHubiNaiyou> skHubiNaiyouList = sinkeiyakuDomManager.getSkHubiNaiyousBySkhubikoumokucd(pSkHubiKoumokuCd);

        for (HM_SkHubiNaiyou skHubiNaiyou : skHubiNaiyouList) {
            HubiNaiyouOutBean hubiNaiyouOutBean = new HubiNaiyouOutBean();
            hubiNaiyouOutBean.setHubiKoumokuCd(skHubiNaiyou.getSkhubikoumokucd());
            hubiNaiyouOutBean.setHubiNaiyouCd(skHubiNaiyou.getSkhubinaiyoucd());

            HM_SkHubiRenrakuNaiyou skHubiRenrakuNaiyou =
                sinkeiyakuDomManager.getSkHubiRenrakuNaiyou(skHubiNaiyou.getSkhubirenrakunaiyoucd());
            if (skHubiRenrakuNaiyou != null) {
                hubiNaiyouOutBean.setTyoubunFlg(skHubiRenrakuNaiyou.getTyoubunflg().getValue());
                hubiNaiyouOutBean.setRenrakuJikou(skHubiRenrakuNaiyou.getSkhubirenrakunaiyou());
            }
            else {
                hubiNaiyouOutBean.setTyoubunFlg(C_UmuKbn.NONE.getValue());
                hubiNaiyouOutBean.setRenrakuJikou("");
            }

            hubiNaiyouOutBeanList.add(hubiNaiyouOutBean);
        }

        return hubiNaiyouOutBeanList;
    }

    private void setModalhyoujiInfo() {

        String uniqueId = uiBean.getUniqueid2();
        SkHubiRenkeiInfo skHubiRenkeiInfo = objStrMan.retrieve(uniqueId);

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        uiBean.setMosuketukekbn(syoriCTL.getMosuketukekbn());

        List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubis();

        hanteiDoujiMos.hanteiDoujiMos(uiBean.getMosno());

        if (C_UmuKbn.ARI.eq(hanteiDoujiMos.getDoujiMosUmu())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                MessageId.WHC0102, hanteiDoujiMos.getMsgMosnoList());
        }

        GetMsgAitemosno getMsgAitemosno = SWAKInjector.getInstance(GetMsgAitemosno.class);

        int kekkaKbn =
            getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), syoriCTL.getMosKihon().getAitemosno());

        if (kekkaKbn == GetMsgAitemosno.KEKKAKBN_ARI) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                getMsgAitemosno.getS_gmmsgid(), syoriCTL.getMosKihon().getAitemosno());
        }

        List<HubiList1DataSourceBean> dispHubiList = Lists.newArrayList();

        if (skHubiLst.size() > 0) {
            SortHT_SkHubiDetail sortHTSkHubiDetail = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);

            List<HT_SkHubiDetail> hassinSkHubiDetailList = skHubiLst.get(0).getSkHubiDetailsByHasinymd();
            List<HT_SkHubiDetail>  sortHassinSkHubiDetailList =
                sortHTSkHubiDetail.OrderHT_SkHubiDetailByHasinymdRenno3ketaAsc(hassinSkHubiDetailList);

            for (HT_SkHubiDetail hassinSkHubiDetail : sortHassinSkHubiDetailList) {

                HubiList1DataSourceBean hubiBean = SWAKInjector.getInstance(HubiList1DataSourceBean.class);

                hubiBean.setDisptrkymd(hassinSkHubiDetail.getTrkymd());
                hubiBean.setHubisyoruicd(hassinSkHubiDetail.getSyoruiCd());

                HM_SkHubiKoumoku skHubiKoumoku = hassinSkHubiDetail.getSkHubiKoumoku();
                if (skHubiKoumoku != null) {
                    hubiBean.setDispskhubikoumoku(
                        skHubiKoumoku.getSkhubikoumokucd() + "：" + skHubiKoumoku.getSkhubikoumoku());
                }

                HM_SkHubiNaiyou skHubiNaiyou = hassinSkHubiDetail.getSkHubiNaiyou();
                if (skHubiNaiyou != null) {
                    hubiBean.setDispskhubinaiyou(
                        skHubiNaiyou.getSkhubinaiyoucd() + "：" + skHubiNaiyou.getSkhubinaiyousentakumongon());
                }

                HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = hassinSkHubiDetail.getSkSeibiSijiNaiyou();
                if (skSeibiSijiNaiyou != null) {
                    hubiBean.setDispskseibisijinaiyou(skSeibiSijiNaiyou.getSkseibisijinaiyou());
                }

                hubiBean.setTyoubundisprenrakujikou(editSecurityKm.decode(hassinSkHubiDetail.getSkrenrakujikou()));
                hubiBean.setDisphassinymd(hassinSkHubiDetail.getHasinymd());
                hubiBean.setDispkaisyouymd(hassinSkHubiDetail.getKaisyouymd());
                hubiBean.setDisphasinkyokakbn(hassinSkHubiDetail.getHasinkyokakbn());
                hubiBean.setDisphassinsakikbn(hassinSkHubiDetail.getHassinsakikbn());
                AM_User user = hassinSkHubiDetail.getUser();
                if (user != null) {
                    hubiBean.setDispnyuryokutantounm(user.getUserNm());
                }

                dispHubiList.add(hubiBean);
            }

            uiBean.setHubiList1(dispHubiList);
        }

        List<HubiList2DataSourceBean> inputHubiList = Lists.newArrayList();
        String sakujyoLink = MessageUtil.getMessage(DDID_HUBILIST2_SAKUJYOLINK.getErrorResourceKey());
        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);
        if (skHubiRenkeiInfo.getHubiList2().size() == 0) {
            if (skHubiLst.size() == 0) {
                if (mosDairiten != null) {
                    BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

                    BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten.getBosyuucd());

                    HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou =
                        sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(mosDairiten.getOyadrtencd());

                    if (skDairitenKobetuJyouhou != null) {
                        uiBean.setUtdskknnm1kj(skDairitenKobetuJyouhou.getUtdskknnm1kj());
                        uiBean.setUtdskknnm2kj(skDairitenKobetuJyouhou.getUtdskknnm2kj());
                    }
                    if (bzGetBsInfoBean != null) {
                        uiBean.setTuutisakitantounmkj(bzGetBsInfoBean.getKanjiBosyuuninNm());
                    }
                }
            }
            else {
                uiBean.setTuutisakitantounmkj(skHubiLst.get(0).getTuutisakitantounmkj());
                uiBean.setUtdskknnm1kj(skHubiLst.get(0).getUtdskknnm1kj());
                uiBean.setUtdskknnm2kj(skHubiLst.get(0).getUtdskknnm2kj());

                List<HT_SkHubiDetail> miHassinSkHubiDetailList = skHubiLst.get(0).getSkHubiDetailsByHasinymdNull();
                for (HT_SkHubiDetail miHassinSkHubiDetail : miHassinSkHubiDetailList) {

                    HubiList2DataSourceBean hubiBean = SWAKInjector.getInstance(HubiList2DataSourceBean.class);

                    hubiBean.setDispinputtrkymd(miHassinSkHubiDetail.getTrkymd());
                    hubiBean.setHubisyoruicd(miHassinSkHubiDetail.getSyoruiCd());
                    HM_SkHubiKoumoku skHubiKoumoku = miHassinSkHubiDetail.getSkHubiKoumoku();
                    if (skHubiKoumoku != null) {
                        hubiBean.setDispinputskhubikoumoku(skHubiKoumoku.getSkhubikoumokucd());
                        createHubiKbnPulldownList(hubiBean);
                    }

                    HM_SkHubiNaiyou skHubiNaiyou = miHassinSkHubiDetail.getSkHubiNaiyou();
                    if (skHubiNaiyou != null) {
                        hubiBean.setDispinputhubinaiyoucd(skHubiNaiyou.getSkhubinaiyoucd());
                        createHubiReasonPulldownList(hubiBean);
                    }

                    hubiBean.setDispinputskseibisijinaiyou(miHassinSkHubiDetail.getSkseibisijinaiyoucd());
                    createSkseibisijinaiyouPulldownList(hubiBean);
                    hubiBean.setTyoubundisprenrakujikou(editSecurityKm.decode(miHassinSkHubiDetail.getSkrenrakujikou()));
                    hubiBean.setDispinputtyoubunflg(miHassinSkHubiDetail.getTyoubunflg());
                    hubiBean.setDispinputhasinkyokakbn(miHassinSkHubiDetail.getHasinkyokakbn());
                    hubiBean.setDispinputhassinsakikbn(miHassinSkHubiDetail.getHassinsakikbn());
                    hubiBean.setSakujyoLink(sakujyoLink);

                    AM_User user = miHassinSkHubiDetail.getUser();
                    if (user != null) {
                        hubiBean.setDispinputnyuryokutantounm(user.getUserNm());
                    }

                    hubiBean.setSakujyoflg(C_Delflag.BLNK);

                    inputHubiList.add(hubiBean);
                }
            }
        }
        else {
            inputHubiList =  skHubiRenkeiInfo.getHubiList2();
            uiBean.setTuutisakitantounmkj(skHubiRenkeiInfo.getTuutisakitantounmkj());
            uiBean.setUtdskknnm1kj(skHubiRenkeiInfo.getUtdskknnm1kj());
            uiBean.setUtdskknnm2kj(skHubiRenkeiInfo.getUtdskknnm2kj());
        }

        uiBean.setHubiList2(inputHubiList);

        createList();

        if (mosDairiten != null) {
            HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou =
                sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(mosDairiten.getOyadrtencd());

            if (skDairitenKobetuJyouhou != null) {
                uiBean.setDrtenRnrkhouKbn(skDairitenKobetuJyouhou.getDrtenRnrkhouKbn());
            }
        }
    }

    private void setModalConfirmInfo1(SkHubiRenkeiInfo pSkHubiRenkeiInfo) {

        List<HubiList2DataSourceBean> hubiList2Data = pSkHubiRenkeiInfo.getHubiList2();

        List<HubiList1DataSourceBean> hubiList1Data = pSkHubiRenkeiInfo.getHubiList1();

        if (hubiList2Data.size() == 0 && hubiList1Data.size() == 0) {
            throw new BizLogicException(MessageId.EHA0373);
        }

        uiBean.setUtdskknnm1kj(pSkHubiRenkeiInfo.getUtdskknnm1kj());
        uiBean.setUtdskknnm2kj(pSkHubiRenkeiInfo.getUtdskknnm2kj());
        uiBean.setTuutisakitantounmkj(pSkHubiRenkeiInfo.getTuutisakitantounmkj());

        if (!C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) {
            uiBean.setHbtyhyoutkbn(pSkHubiRenkeiInfo.getHbtyhyoutkbn());
        }

        uiBean.setHubiList1(hubiList1Data);
        uiBean.setHubiList2(hubiList2Data);
    }

    private void setModalConfirmInfo2() {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        List<HT_SkHubi> skHubiLst = syoriCTL.getSkHubis();

        boolean hubiInfoUmu = false;

        List<HubiList1DataSourceBean> dispHubiList = Lists.newArrayList();

        if (skHubiLst.size() > 0) {
            SortHT_SkHubiDetail sortHTSkHubiDetail = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);

            List<HT_SkHubiDetail> hassinSkHubiDetailList = skHubiLst.get(0).getSkHubiDetailsByHasinymd();
            List<HT_SkHubiDetail>  sortHassinSkHubiDetailList =
                sortHTSkHubiDetail.OrderHT_SkHubiDetailByHasinymdRenno3ketaAsc(hassinSkHubiDetailList);

            if (sortHassinSkHubiDetailList.size() > 0) {
                hubiInfoUmu = true;
            }

            for (HT_SkHubiDetail hassinSkHubiDetail : sortHassinSkHubiDetailList) {

                HubiList1DataSourceBean hubiBean = SWAKInjector.getInstance(HubiList1DataSourceBean.class);

                hubiBean.setDisptrkymd(hassinSkHubiDetail.getTrkymd());
                hubiBean.setHubisyoruicd(hassinSkHubiDetail.getSyoruiCd());

                HM_SkHubiKoumoku skHubiKoumoku = hassinSkHubiDetail.getSkHubiKoumoku();
                if (skHubiKoumoku != null) {
                    hubiBean.setDispskhubikoumoku(
                        skHubiKoumoku.getSkhubikoumokucd() + "：" + skHubiKoumoku.getSkhubikoumoku());
                }

                HM_SkHubiNaiyou skHubiNaiyou = hassinSkHubiDetail.getSkHubiNaiyou();
                if (skHubiNaiyou != null) {
                    hubiBean.setDispskhubinaiyou(
                        skHubiNaiyou.getSkhubinaiyoucd() + "：" + skHubiNaiyou.getSkhubinaiyousentakumongon());
                }

                HM_SkSeibiSijiNaiyou skSeibiSijiNaiyou = hassinSkHubiDetail.getSkSeibiSijiNaiyou();
                if (skSeibiSijiNaiyou != null) {
                    hubiBean.setDispskseibisijinaiyou(skSeibiSijiNaiyou.getSkseibisijinaiyou());
                }

                hubiBean.setTyoubundisprenrakujikou(editSecurityKm.decode(hassinSkHubiDetail.getSkrenrakujikou()));
                hubiBean.setDisphassinymd(hassinSkHubiDetail.getHasinymd());
                hubiBean.setDispkaisyouymd(hassinSkHubiDetail.getKaisyouymd());
                hubiBean.setDisphasinkyokakbn(hassinSkHubiDetail.getHasinkyokakbn());
                hubiBean.setDisphassinsakikbn(hassinSkHubiDetail.getHassinsakikbn());
                AM_User user = hassinSkHubiDetail.getUser();
                if (user != null) {
                    hubiBean.setDispnyuryokutantounm(user.getUserNm());
                }

                dispHubiList.add(hubiBean);
            }

            uiBean.setHubiList1(dispHubiList);
        }

        List<HubiList2DataSourceBean> inputHubiList = Lists.newArrayList();

        if (skHubiLst.size() > 0) {
            uiBean.setTuutisakitantounmkj(skHubiLst.get(0).getTuutisakitantounmkj());
            uiBean.setUtdskknnm1kj(skHubiLst.get(0).getUtdskknnm1kj());
            uiBean.setUtdskknnm2kj(skHubiLst.get(0).getUtdskknnm2kj());

            if (!C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(uiBean.getHubitourokumode())) {
                uiBean.setHbtyhyoutkbn(C_HbtyhyoutKbn.ONLINE);
            }

            List<HT_SkHubiDetail> miHassinSkHubiDetailList = skHubiLst.get(0).getSkHubiDetailsByHasinymdNull();

            if (miHassinSkHubiDetailList.size() > 0) {
                hubiInfoUmu = true;
            }

            for (HT_SkHubiDetail miHassinSkHubiDetail : miHassinSkHubiDetailList) {

                HubiList2DataSourceBean hubiBean = SWAKInjector.getInstance(HubiList2DataSourceBean.class);

                hubiBean.setDispinputtrkymd(miHassinSkHubiDetail.getTrkymd());
                hubiBean.setHubisyoruicd(miHassinSkHubiDetail.getSyoruiCd());
                HM_SkHubiKoumoku skHubiKoumoku = miHassinSkHubiDetail.getSkHubiKoumoku();
                if (skHubiKoumoku != null) {
                    hubiBean.setDispinputskhubikoumoku(skHubiKoumoku.getSkhubikoumokucd());
                    createHubiKbnPulldownList(hubiBean);
                }

                HM_SkHubiNaiyou skHubiNaiyou = miHassinSkHubiDetail.getSkHubiNaiyou();
                if (skHubiNaiyou != null) {
                    hubiBean.setDispinputhubinaiyoucd(skHubiNaiyou.getSkhubinaiyoucd());
                    createHubiReasonPulldownList(hubiBean);
                }

                hubiBean.setDispinputskseibisijinaiyou(miHassinSkHubiDetail.getSkseibisijinaiyoucd());
                createSkseibisijinaiyouPulldownList(hubiBean);
                hubiBean.setTyoubundisprenrakujikou(editSecurityKm.decode(miHassinSkHubiDetail.getSkrenrakujikou()));
                hubiBean.setDispinputtyoubunflg(miHassinSkHubiDetail.getTyoubunflg());
                hubiBean.setDispinputhasinkyokakbn(miHassinSkHubiDetail.getHasinkyokakbn());
                hubiBean.setDispinputhassinsakikbn(miHassinSkHubiDetail.getHassinsakikbn());

                AM_User user = miHassinSkHubiDetail.getUser();
                if (user != null) {
                    hubiBean.setDispinputnyuryokutantounm(user.getUserNm());
                }

                hubiBean.setSakujyoflg(C_Delflag.BLNK);

                inputHubiList.add(hubiBean);
            }

            uiBean.setHubiList2(inputHubiList);
        }

        if(!hubiInfoUmu) {
            throw new BizLogicException(MessageId.EHA0373);
        }
    }

    private void checkHibiInput(List<HubiList2DataSourceBean> pHubiInputLst,List<HubiList2DataSourceBean> pHubiInputSeibiLst) {
        for (HubiList2DataSourceBean hubiInputBean : pHubiInputLst) {
            if (!C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && (BizUtil.isBlank(hubiInputBean.getDispinputskhubikoumoku())
                    || BizUtil.isBlank(hubiInputBean.getDispinputhubinaiyoucd()))) {
                throw new BizLogicException(MessageId.EHC1033,
                    MessageUtil.getMessage(DDID_HUBILIST2_DISPINPUTSKHUBIKOUMOKU.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_HUBILIST2_DISPINPUTHUBINAIYOUCD.getErrorResourceKey()));
            }

            if (!C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && BizUtil.isBlank(hubiInputBean.getDispinputskseibisijinaiyou())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_HUBILIST2_DISPINPUTSKSEIBISIJINAIYOU.getErrorResourceKey()));
            }

            if (C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && !BizUtil.isBlank(hubiInputBean.getDispinputskseibisijinaiyou())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_HUBILIST1_HUBISYORUICD.getErrorResourceKey()));
            }

            if (hubiInputBean.getDispinputtyoubunflg()) {
                boolean chkMaxRowFlg = chkMaxRow(hubiInputBean.getTyoubundisprenrakujikou(), 15, 50);
                if (chkMaxRowFlg) {
                    throw new BizLogicException(MessageId.EHA1057,
                        MessageUtil.getMessage(DDID_HUBILIST2_TYOUBUNDISPRENRAKUJIKOU.getErrorResourceKey()), "15", "50");
                }
            }
            else {
                boolean chkMaxRowFlg = chkMaxRow(hubiInputBean.getTyoubundisprenrakujikou(), 5, 50);
                if (chkMaxRowFlg) {
                    throw new BizLogicException(MessageId.EHA1057,
                        MessageUtil.getMessage(DDID_HUBILIST2_TYOUBUNDISPRENRAKUJIKOU.getErrorResourceKey()), "5", "50");
                }
            }

            if (!C_SyoruiCdKbn.BLNK.eq(hubiInputBean.getHubisyoruicd())
                && (!BizUtil.isBlank(hubiInputBean.getDispinputskhubikoumoku())
                    && !BizUtil.isBlank(hubiInputBean.getDispinputhubinaiyoucd()))) {
                createHubiKbnPulldownList(hubiInputBean);
                createHubiReasonPulldownList(hubiInputBean);
                hubiInputBean.setTyoubunflg(hubiInputBean.getDispinputtyoubunflg());
                pHubiInputSeibiLst.add(hubiInputBean);
            }
        }
    }

    private void listAndHoryuuClean(List<HubiList2DataSourceBean> pHubiList2DSBeanLst,List<HubiList2DataSourceBean> pNewHubiInputSeibiLst) {
        Iterables.removeIf(pHubiList2DSBeanLst, new HubiList2AndHoryuuDataSourceBeanPredicate());
        pNewHubiInputSeibiLst.addAll(pHubiList2DSBeanLst);
    }

    private class HubiList2AndHoryuuDataSourceBeanPredicate implements Predicate<HubiList2DataSourceBean>{

        public HubiList2AndHoryuuDataSourceBeanPredicate() {
        }

        @Override
        public boolean apply(HubiList2DataSourceBean bean) {
            return C_HasinkyokaKbn.HORYUU.eq(bean.getDispinputhasinkyokakbn());
        }
    }

    private String editMosnoHyphen_3_3_3(String pMosNo) {

        if (BizUtil.isBlank(pMosNo) || pMosNo.length() != 9) {
            return pMosNo;
        }
        String mosNo = pMosNo.substring(0, 3) + "-" + pMosNo.substring(3, 6) + "-" + pMosNo.substring(6);

        return mosNo;
    }
}
