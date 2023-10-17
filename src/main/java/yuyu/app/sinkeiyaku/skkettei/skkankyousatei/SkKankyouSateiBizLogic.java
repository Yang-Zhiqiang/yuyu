package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import static yuyu.app.sinkeiyaku.skkettei.skkankyousatei.GenSkKankyouSateiConstants.*;
import static yuyu.app.sinkeiyaku.skkettei.skkankyousatei.SkKankyouSateiConstants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.classification.DisplayItem;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import net.arnx.jsonic.JSON;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkettei.skkankyousatei.dba.SkKankyouSateiDao;
import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKankyouSatei;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTorikesi;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SetHutuuSibouS;
import yuyu.common.sinkeiyaku.skcommon.EditGamenString;
import yuyu.common.sinkeiyaku.skcommon.EditPdfKyknaiyoutrseidoskhy;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetMsgDoujikaiyakusyono;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuui;
import yuyu.common.sinkeiyaku.skcommon.HanteiDoujiMos;
import yuyu.common.sinkeiyaku.skcommon.Henkin;
import yuyu.common.sinkeiyaku.skcommon.HenkinOutBean;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SetMossykykyoteiymd;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnkenJyoutaiKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykSyubetuKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckakKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_LincKaisyacd;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.report.OutputReport;

import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 環境査定 のビジネスロジックです。
 */
public class SkKankyouSateiBizLogic {

    private String knkSateiComment = "";

    private String knkSateiSjNaiyou = "";

    private int mosTenkenYhFlg = MOSTENKENIRAIFLG_NONE;

    private int imuSateiYhFlg = IMUSATEIFLG_NONE;

    private BizDate sysDate;

    private String sysDateTime;

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkKankyouSateiUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private GetMsgDoujikaiyakusyono getMsgDoujikaiyakusyono;

    @Inject
    private HanteiDoujiMos hanteiDoujiMos;

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private SetMossykykyoteiymd setMossykykyoteiymd;

    @Inject
    private SkKankyouSateiDao skKankyouSateiDao;

    @Inject
    private OutputReport outputReport;

    void init() {

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.DEFAULT.getValue());
    }

    void initMousikomitorikesi() {

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.MOSTORIKESI.getValue());
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {
        BizPropertyInitializer.initialize(uiBean);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(), kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue());

            if (!kengenUmuFlg) {
                throw new BizLogicException(MessageId.EHA1073, ERRMSG_KNKYSATEI_1TI);
            }
        }

        else if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(), kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue());

            if (!kengenUmuFlg) {
                throw new BizLogicException(MessageId.EHA1073, ERRMSG_KNKYSATEI_2A);
            }
        }

        else if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(), kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue());

            if (!kengenUmuFlg) {
                throw new BizLogicException(MessageId.EHA1073, ERRMSG_KNKYSATEI_2B);
            }
        }
        if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue());
        }
        else if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue());
        }
        else if (ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue());
        }

        startInputContents();
    }

    @Transactional
    void iwfOpenMosTorikesiBL() {
        BizPropertyInitializer.initialize(uiBean);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.MOSTORIKESI.getValue());

        startInputContents();
    }

    @Transactional
    void pushSateiBL() {
        BizPropertyInitializer.initialize(uiBean);

        String mosno = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno);

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        if (C_SkkinouModeIdKbn.DEFAULT.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            if (C_KnkysateijyouKbn.SATEIMATI_1.eq(syoriCTL.getKnkysateijyoukbn())) {
                uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue());
            }
            else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(syoriCTL.getKnkysateijyoukbn())) {
                uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue());
            }
            else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(syoriCTL.getKnkysateijyoukbn())) {
                uiBean.getKinouMode().setKinouMode(C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue());
            }
        }

        uiBean.setSyoriCTL(syoriCTL);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        String jimuTetuzukiCd = "";

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            jimuTetuzukiCd = ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI;
        }
        else {

            jimuTetuzukiCd = ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU;
        }

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(jimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosno);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            if (bzGetProcessSummaryOutBeanList == null || bzGetProcessSummaryOutBeanList.isEmpty()) {
                throw new BizLogicException(MessageId.EBA0112);
            }

            if (!ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId()) &&
                !ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId()) &&
                !ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId())) {
                throw new BizLogicException(MessageId.EBA0112);
            }

            uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());
            uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBeanList.get(0).getJimuTetuzukiCd());
            uiBean.getBzWorkflowInfo().setTaskId(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId());
        }
        else {

            if (bzGetProcessSummaryOutBeanList == null || bzGetProcessSummaryOutBeanList.isEmpty()) {
                uiBean.getBzWorkflowInfo().setKouteiKanriId("");
                uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
                uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOUSIKOMITORIKESI);
            }
            else {

                if (ISkCommonKoumoku.NODEID_MOUSIKOMITORIKESI.equals(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId())) {
                    uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());
                    uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBeanList.get(0).getJimuTetuzukiCd());
                    uiBean.getBzWorkflowInfo().setTaskId(bzGetProcessSummaryOutBeanList.get(0).getNowNodoId());
                }
                else {
                    uiBean.getBzWorkflowInfo().setKouteiKanriId("");
                    uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI);
                    uiBean.getBzWorkflowInfo().setTaskId(ISkCommonKoumoku.NODEID_MOUSIKOMITORIKESI);
                }
            }
        }

        chkSyoriKh(syoriCTL);

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosno);

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(
            bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekis();

        if ((knksateiRirekiLst.size() == 0) && C_UmuKbn.ARI.eq(syoriCTL.getKnkysateirrkumu())){
            throw new CommonBizAppException(MOSBANGOU + mosno);
        }
        if (knksateiRirekiLst.size() > 0) {
            knkSateiComment = knksateiRirekiLst.get(knksateiRirekiLst.size() - 1).getKnksateicomment();
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<String> gmwarningIdLst = Lists.newArrayList();
        List<String> gmwarningLst = Lists.newArrayList();

        if (mosKihon == null){
            throw new CommonBizAppException(MOSBANGOU + mosno);
        }

        int kekkaKbn = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon.getAitemosno());
        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn){
            gmwarningIdLst.add(getMsgAitemosno.getS_gmmsgid());
            gmwarningLst.add(getMsgAitemosno.getS_gmmsg());
        }

        kekkaKbn = getMsgDoujikaiyakusyono.exec(syoriCTL.getMosnrkumu(), mosKihon.getDoujikaiyakusyono());
        if (GetMsgDoujikaiyakusyono.KEKKAKBN_ARI == kekkaKbn){
            gmwarningIdLst.add(getMsgDoujikaiyakusyono.getS_gmmsgid());
            gmwarningLst.add(getMsgDoujikaiyakusyono.getS_gmmsg());
        }

        hanteiDoujiMos.hanteiDoujiMos(mosno);

        if (C_UmuKbn.ARI.eq(hanteiDoujiMos.getDoujiMosUmu())) {

            gmwarningIdLst.add(MessageId.WHC0102);
            gmwarningLst.add(MessageUtil.getMessage(MessageId.WHC0102, hanteiDoujiMos.getMsgMosnoList()));
        }

        if (C_LincjkKbn.KAITOARI_TASYAARI.eq(syoriCTL.getLincjkkbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.IHF1038);
        }

        uiBean.setGmwarningIdLst(gmwarningIdLst);
        uiBean.setGmwarningLst(gmwarningLst);

        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL.getImusateiRirekis();

        List<HT_MostenkenRireki> mostenkenRirekiList = syoriCTL.getMostenkenRirekis();

        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.KNKSATEI);

        List<HM_KetteiSya> ketteiSyaLst = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns(
            baseUserInfo.getUserId(), C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA, C_KnksateirankKbn.NIJIB);

        List<HT_SkTtdkTyuui> skTtdkTyuuiList = getSkTtdkTyuui.getTtdkTyuui(mosno, C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        List<HT_NayoseKekka> nayoseKekkaList = syoriCTL.getNayoseKekkas();

        if (ruleHanteiMsgLst.size() > 0) {

            knkSateiSjNaiyou = EditGamenString.editMessegeStringRule(ruleHanteiMsgLst);
        }

        if (C_ImusateijyouKbn.NONE.eq(syoriCTL.getImusateijyoukbn())  &&
            (!C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn()) &&
                !C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn())) &&
                !C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            imuSateiYhFlg = IMUSATEIFLG_YOU;
        }

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            mosTenkenYhFlg = MOSTENKENIRAIFLG_YOU;
        }

        addConversationMessage();

        setUiBean(mosKihon, syoriCTL, knksateiRirekiLst, ketteiSyaLst,
            imusateiRirekiLst, mostenkenRirekiList, skTtdkTyuuiList, nayoseKekkaList);


        if (!StringUtil.isNullOrBlank(uiBean.getBzWorkflowInfo().getKouteiKanriId())) {
            String kouteiLockKey = getKouteiLockKey();

            BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

            C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                kouteiLockKey,
                baseUserInfo.getUserId());

            if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
                throw new BizLogicException(MessageId.EBA0111);
            }
            else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {

                throw new BizLogicException(MessageId.EBA0112);
            }
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            uiBean.setPatternKetkekkacd(C_Ketkekkacd.PATTERN_MOSTORIKESI);
        }
        else {
            uiBean.setPatternKetkekkacd(C_Ketkekkacd.PATTERN_KNKSATEI);
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            uiBean.setPatternKnksateisateikekka(C_SyorikekkaKbn.PATTERN_SKMOSTORIKESITENSOU);
        }
        else {
            uiBean.setPatternKnksateisateikekka(C_SyorikekkaKbn.PATTERN_SKKNKSATEI);
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);
        uiBean.setTasyaKanyuuJoukyouPath(PAGENO_INPUTCONTENTS);
    }

    void pushKakuninBL()  {

        continueLockProcess();

        String knkTnsCd = uiBean.getKnktnsketsyacd();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        String ketRiyuuCd1 = uiBean.getKetriyuucd1gamen();
        String ketRiyuuCd2 = uiBean.getKetriyuucd2gamen();
        String ketRiyuuCd3 = uiBean.getKetriyuucd3gamen();
        String ketRiyuuCd4 = uiBean.getKetriyuucd4gamen();
        C_SyorikekkaKbn mosTenkenKekkaKbn = uiBean.getMostenkenkekkakbn();
        C_SyorikekkaKbn imuSateiKekkaKbn = uiBean.getImusateikekkakbn();
        C_Ketkekkacd ketKekkaCd = uiBean.getKetkekkacd();
        C_SyorikekkaKbn knkSateiKekka = uiBean.getKnksateisateikekka();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(knkTnsCd);

        if (C_SyorikekkaKbn.KANRYOU.eq(knkSateiKekka) && !BizUtil.isBlank(knkTnsCd)) {
            throw new BizLogicException(MessageId.EBC0007, ERRMSG_KNKTNSKETSYACD);
        }
        if (C_SyorikekkaKbn.HORYUU.eq(knkSateiKekka) && !BizUtil.isBlank(knkTnsCd)){
            throw new BizLogicException(MessageId.EBC0007, ERRMSG_KNKTNSKETSYACD);
        }

        if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka)  ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka) ||
            C_SyorikekkaKbn.TENSOU_MOSTORIKESI.eq(knkSateiKekka)) {
            if (BizUtil.isBlank(knkTnsCd)) {
                throw new BizLogicException(MessageId.EHA0309);
            }
        }

        if ((C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka) ||
            C_SyorikekkaKbn.TENSOU_MOSTORIKESI.eq(knkSateiKekka)) &&
            !ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(knkTnsCd)) {
            if (ketteiSya == null) {
                if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka)) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_1TI);
                }
                else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka)) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2A);
                }
                else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka)) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2B);
                }
                else {
                    throw new BizLogicException(MessageId.EHA1022);
                }
            }

            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka)) {

                CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsCd, kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue());
                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_1TI);
                }

                CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

                boolean kengenUmuFlg1 = checkTaskKengen.exec(knkTnsCd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI);

                if (!kengenUmuFlg1) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_1TI);
                }

                if (!C_KnksateirankKbn.ITIJI.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_1TI);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka))  {

                CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsCd, kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue());

                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2A);
                }

                CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

                boolean kengenUmuFlg1 = checkTaskKengen.exec(knkTnsCd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA);

                if (!kengenUmuFlg1) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2A);
                }

                if (!C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())){
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2A);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka)) {

                CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsCd, kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue());

                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2B);
                }

                CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

                boolean kengenUmuFlg1 = checkTaskKengen.exec(knkTnsCd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB);

                if (!kengenUmuFlg1) {
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2B);
                }

                if (!C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())){
                    throw new BizLogicException(MessageId.EHA0314, ERRMSG_KNKYSATEI_2B);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_MOSTORIKESI.eq(knkSateiKekka)) {

                CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsCd, kinou.getKinouId(), C_SkkinouModeIdKbn.MOSTORIKESI.getValue());

                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA1022);
                }

                CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

                boolean kengenUmuFlg1 = checkTaskKengen.exec(knkTnsCd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, ISkCommonKoumoku.NODEID_MOUSIKOMITORIKESI);

                if (!kengenUmuFlg1) {
                    throw new BizLogicException(MessageId.EHA1022);
                }
            }

            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka)  ||
                C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka) ||
                C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka)) {

                BizCurrency hutuuSibouS = getHutuuSbs(syoriCTL);

                if (ketteiSya.getKnksateijygns().compareTo(hutuuSibouS) < 0) {
                    throw new BizLogicException(MessageId.EHA1015, hutuuSibouS.toFormatString());
                }
            }

            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka)) {

                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI, knkTnsCd);

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka)) {

                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA, knkTnsCd);

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka)) {

                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB, knkTnsCd);

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
        }

        if (IMUSATEIFLG_YOU == uiBean.getImusateiIraiyhFlg()) {
            if ((C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn())||
                C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) &&
                BizUtil.isBlank(uiBean.getImusateiiraicomment())) {
                throw new BizLogicException(MessageId.EBC0045, ERRMSG_IMUSATEIIRAICOMMENT);
            }
        }

        if (C_SyorikekkaKbn.BLNK.eq(uiBean.getImusateikekkakbn()) &&
            !BizUtil.isBlank(uiBean.getImusateiiraicomment())) {
            throw new BizLogicException(MessageId.EBC0007, ERRMSG_IMUSATEIIRAICOMMENT);
        }

        if (MOSTENKENIRAIFLG_YOU == uiBean.getMosTenkenIraiyhFlg()) {
            if ((C_SyorikekkaKbn.IRAI_TENKEN_1.eq(uiBean.getMostenkenkekkakbn()) ||
                C_SyorikekkaKbn.IRAI_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())  ||
                C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) &&
                BizUtil.isBlank(uiBean.getMostenkeniraicomment())) {

                throw new BizLogicException(MessageId.EBC0045, ERRMSG_MOSTENKENIRAICOMMENT);
            }
        }

        if (C_SyorikekkaKbn.BLNK.eq(uiBean.getMostenkenkekkakbn()) &&
            !BizUtil.isBlank(uiBean.getMostenkeniraicomment())) {
            throw new BizLogicException(MessageId.EBC0007, ERRMSG_MOSTENKENIRAICOMMENT);
        }

        if (MOSTENKENIRAIFLG_YOU == uiBean.getMosTenkenIraiyhFlg()) {
            if ((C_SyorikekkaKbn.IRAI_TENKEN_1.eq(mosTenkenKekkaKbn) ||
                C_SyorikekkaKbn.IRAI_TENKEN_2.eq(mosTenkenKekkaKbn)  ||
                C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(mosTenkenKekkaKbn)) &&
                ((C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(imuSateiKekkaKbn) ||
                    C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(imuSateiKekkaKbn)) ||
                    (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(knkSateiKekka) ||
                        C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(knkSateiKekka) ||
                        C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(knkSateiKekka)))) {
                throw new BizLogicException(MessageId.EHA1016);
            }
        }

        if (!C_SyorikekkaKbn.KANRYOU.eq(uiBean.getKnksateisateikekka()) &&
            C_HubihassintnsKbn.ARI.eq(uiBean.getHubihassintnskbn())) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_KANKYOUSATEI_HUBIHASSINTNSKBN.getErrorResourceKey()));
        }

        if (BizUtil.isBlank(ketRiyuuCd3) && !BizUtil.isBlank(ketRiyuuCd4)) {
            throw new BizLogicException(MessageId.EHA0075,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        if (BizUtil.isBlank(ketRiyuuCd2) && !BizUtil.isBlank(ketRiyuuCd3)) {
            throw new BizLogicException(MessageId.EHA0075,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }

        if (BizUtil.isBlank(ketRiyuuCd1) && !BizUtil.isBlank(ketRiyuuCd2)) {
            throw new BizLogicException(MessageId.EHA0075,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }

        if ((!BizUtil.isBlank(ketRiyuuCd1) && !BizUtil.isBlank(ketRiyuuCd2) && ketRiyuuCd1.equals(ketRiyuuCd2)) ||
            (!BizUtil.isBlank(ketRiyuuCd1) && !BizUtil.isBlank(ketRiyuuCd3) && ketRiyuuCd1.equals(ketRiyuuCd3)) ||
            (!BizUtil.isBlank(ketRiyuuCd1) && !BizUtil.isBlank(ketRiyuuCd4) && ketRiyuuCd1.equals(ketRiyuuCd4))) {
            throw new BizLogicException(MessageId.EHA0432);
        }

        if ((!BizUtil.isBlank(ketRiyuuCd2) && !BizUtil.isBlank(ketRiyuuCd3) && ketRiyuuCd2.equals(ketRiyuuCd3)) ||
            (!BizUtil.isBlank(ketRiyuuCd2) && !BizUtil.isBlank(ketRiyuuCd4) && ketRiyuuCd2.equals(ketRiyuuCd4))) {
            throw new BizLogicException(MessageId.EHA0432);
        }

        if (!BizUtil.isBlank(ketRiyuuCd3) && !BizUtil.isBlank(ketRiyuuCd4) && ketRiyuuCd3.equals(ketRiyuuCd4)) {
            throw new BizLogicException(MessageId.EHA0432);
        }

        if (!C_Ketkekkacd.MIAWASE.eq(ketKekkaCd) &&
            !C_Ketkekkacd.HUBI_MATI.eq(ketKekkaCd) &&
            !BizUtil.isBlank(ketRiyuuCd1)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }

        if ((C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
            C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) &&
            C_Ketkekkacd.MIAWASE.eq(ketKekkaCd) && BizUtil.isBlank(ketRiyuuCd1)) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }

        if (!BizUtil.isBlank(ketRiyuuCd1) && !chkKbnValue(ketRiyuuCd1)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if (!BizUtil.isBlank(ketRiyuuCd2) && !chkKbnValue(ketRiyuuCd2)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }
        else if (!BizUtil.isBlank(ketRiyuuCd3) && !chkKbnValue(ketRiyuuCd3)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }
        else if (!BizUtil.isBlank(ketRiyuuCd4) && !chkKbnValue(ketRiyuuCd4)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuNrKahiFlg1 = hanteiKetRiyuuNrKahi(ketKekkaCd, ketRiyuuCd1);

        if (!ketRiyuuNrKahiFlg1) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuNrKahiFlg2 = hanteiKetRiyuuNrKahi(ketKekkaCd, ketRiyuuCd2);

        if (!ketRiyuuNrKahiFlg2) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuNrKahiFlg3 = hanteiKetRiyuuNrKahi(ketKekkaCd, ketRiyuuCd3);

        if (!ketRiyuuNrKahiFlg3) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuNrKahiFlg4 = hanteiKetRiyuuNrKahi(ketKekkaCd, ketRiyuuCd4);

        if (!ketRiyuuNrKahiFlg4) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        if ((C_Ketriyuucd.HHKN_NINSIN.getValue().equals(ketRiyuuCd1) ||
            C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.getValue().equals(ketRiyuuCd1)) &&
            !C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {
            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.HHKN_NINSIN.getValue().equals(ketRiyuuCd2)
            || C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.getValue().equals(ketRiyuuCd2))
            && !C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {
            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.HHKN_NINSIN.getValue().equals(ketRiyuuCd3)
            || C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.getValue().equals(ketRiyuuCd3))
            && !C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {
            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.HHKN_NINSIN.getValue().equals(ketRiyuuCd4)
            || C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.getValue().equals(ketRiyuuCd4))
            && !C_Hhknsei.FEMALE.eq(mosKihon.getHhknsei())) {
            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        if ((C_Ketriyuucd.KYK_DOUTOKUHUAN.getValue().equals(ketRiyuuCd1) ||
            C_Ketriyuucd.HHKN_DOUTOKUHUAN.getValue().equals(ketRiyuuCd1)) &&
            (C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd2)    ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd3) ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd4))) {
            throw new BizLogicException(MessageId.EHA1018,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.KYK_DOUTOKUHUAN.getValue().equals(ketRiyuuCd2) ||
            C_Ketriyuucd.HHKN_DOUTOKUHUAN.getValue().equals(ketRiyuuCd2)) &&
            (C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd1)    ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd3) ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd4))) {
            throw new BizLogicException(MessageId.EHA1018,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.KYK_DOUTOKUHUAN.getValue().equals(ketRiyuuCd3) ||
            C_Ketriyuucd.HHKN_DOUTOKUHUAN.getValue().equals(ketRiyuuCd3)) &&
            (C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd1)    ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd2) ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd4))) {
            throw new BizLogicException(MessageId.EHA1018,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.KYK_DOUTOKUHUAN.getValue().equals(ketRiyuuCd4) ||
            C_Ketriyuucd.HHKN_DOUTOKUHUAN.getValue().equals(ketRiyuuCd4)) &&
            (C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd1)    ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd2) ||
                C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue().equals(ketRiyuuCd3))) {
            throw new BizLogicException(MessageId.EHA1018,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        if (C_Ketriyuucd.KYKKAKUNINKETTEI.getValue().equals(ketRiyuuCd1) &&
            !C_KykkakjkKbn.KAKUNIN_SUMI.eq(syoriCTL.getKykkakjkkbn())) {
            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }

        else if (C_Ketriyuucd.KYKKAKUNINKETTEI.getValue().equals(ketRiyuuCd2) &&
            !C_KykkakjkKbn.KAKUNIN_SUMI.eq(syoriCTL.getKykkakjkkbn())) {
            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }

        else if (C_Ketriyuucd.KYKKAKUNINKETTEI.getValue().equals(ketRiyuuCd3) &&
            !C_KykkakjkKbn.KAKUNIN_SUMI.eq(syoriCTL.getKykkakjkkbn())) {
            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }

        else if (C_Ketriyuucd.KYKKAKUNINKETTEI.getValue().equals(ketRiyuuCd4) &&
            !C_KykkakjkKbn.KAKUNIN_SUMI.eq(syoriCTL.getKykkakjkkbn())) {
            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuNrHituyouFlg = hanteiKetRiyuuHissnr(
            ketKekkaCd, ketRiyuuCd1, ketRiyuuCd2, ketRiyuuCd3, ketRiyuuCd4);

        if (!ketRiyuuNrHituyouFlg) {
            throw new BizLogicException(MessageId.EHA1043, ketKekkaCd.getContent(uiBean.getPatternKetkekkacd()));
        }

        ArrayList<String> ketteiRiyuuCdList = new ArrayList<String>();

        ketteiRiyuuCdList.add(C_Ketriyuucd.HHKN_DOUTOKUHUAN.getValue());
        ketteiRiyuuCdList.add(C_Ketriyuucd.KYK_DOUTOKUHUAN.getValue());
        ketteiRiyuuCdList.add(C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue());

        if (ketteiRiyuuCdList.contains(ketRiyuuCd1) ||
            ketteiRiyuuCdList.contains(ketRiyuuCd2) ||
            ketteiRiyuuCdList.contains(ketRiyuuCd3) ||
            ketteiRiyuuCdList.contains(ketRiyuuCd4)) {
            if (C_MrRiyuucdKbn.BLNK.eq(uiBean.getMrriyuucdkbn())) {
                throw new BizLogicException(MessageId.EBC0043,
                    MessageUtil.getMessage(DDID_KETTEIJOUHOU_MRRIYUUCDKBN.getErrorResourceKey()));
            }
        }
        else {
            if (!C_MrRiyuucdKbn.BLNK.eq(uiBean.getMrriyuucdkbn())) {
                throw new BizLogicException(MessageId.EBC0007,
                    MessageUtil.getMessage(DDID_KETTEIJOUHOU_MRRIYUUCDKBN.getErrorResourceKey()));
            }
        }

        if ((C_Ketkekkacd.COOLINGOFF.eq(ketKekkaCd) ||
            C_Ketkekkacd.MOS_TORIKESI.eq(ketKekkaCd) ||
            C_Ketkekkacd.YUUKOUKKNKKA.eq(ketKekkaCd)) &&
            C_TorikesisyousairiyuuCd.BLNK.eq(uiBean.getTorikesisyousairiyuucd())) {

            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEIJOUHOU_TORIKESISYOUSAIRIYUUCD.getErrorResourceKey()));
        }

        if (ketteiSya != null) {
            uiBean.setKnktnsketsyacd(ketteiSya.getKetsyacd());
        }

        if (!BizUtil.isBlank(ketRiyuuCd1)) {
            uiBean.setKetteiriyuunaiyou1(C_Ketriyuucd.valueOf(ketRiyuuCd1));
        } else {
            uiBean.setKetteiriyuunaiyou1(C_Ketriyuucd.BLNK);
        }

        if (!BizUtil.isBlank(ketRiyuuCd2)) {
            uiBean.setKetteiriyuunaiyou2(C_Ketriyuucd.valueOf(ketRiyuuCd2));
        } else {
            uiBean.setKetteiriyuunaiyou2(C_Ketriyuucd.BLNK);
        }

        if (!BizUtil.isBlank(ketRiyuuCd3)) {
            uiBean.setKetteiriyuunaiyou3(C_Ketriyuucd.valueOf(ketRiyuuCd3));
        } else {
            uiBean.setKetteiriyuunaiyou3(C_Ketriyuucd.BLNK);
        }

        if (!BizUtil.isBlank(ketRiyuuCd4)) {
            uiBean.setKetteiriyuunaiyou4(C_Ketriyuucd.valueOf(ketRiyuuCd4));
        } else {
            uiBean.setKetteiriyuunaiyou4(C_Ketriyuucd.BLNK);
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QAC0008, MessageUtil.getMessage(MessageId.QAC0008));

        uiBean.setTasyaKanyuuJoukyouPath(PAGENO_CONFIRM);
    }

    void pushmodoruBtnByConfirmBL() {

        continueLockProcess();
        addConversationMessage();
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        if (C_LincjkKbn.KAITOARI_TASYAARI.eq(syoriCTL.getLincjkkbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.IHF1038);
        }

        uiBean.setTasyaKanyuuJoukyouPath(PAGENO_INPUTCONTENTS);
    }

    @Transactional
    void pushKakuteiBL() {

        continueLockProcess();

        sysDate = BizDate.getSysDate();
        sysDateTime = BizDate.getSysDateTimeMilli();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        C_Ketkekkacd ketKekkaCd = uiBean.getKetkekkacd();
        HT_MosnoKanri mosnoKanri = null;

        addSTKnksateirrk();


        if ((C_SyorikekkaKbn.KANRYOU.eq(uiBean.getKnksateisateikekka()) && C_Ketkekkacd.MUJYOUKEN.eq(ketKekkaCd)) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_MOSTORIKESI.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.HORYUU.eq(uiBean.getKnksateisateikekka())) {

            if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn()) ||
                C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) {
                addSTImusateirrk();
            }

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(uiBean.getMostenkenkekkakbn()) ||
                C_SyorikekkaKbn.IRAI_TENKEN_2.eq(uiBean.getMostenkenkekkakbn()) ||
                C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {
                addMosTenkenrrk();
            }

            C_UmuKbn mosTenkenRrkumu = syoriCTL.getMostenkenrrkumu();

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(uiBean.getMostenkenkekkakbn()) ||
                C_SyorikekkaKbn.IRAI_TENKEN_2.eq(uiBean.getMostenkenkekkakbn()) ||
                C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {
                mosTenkenRrkumu = C_UmuKbn.ARI;
            }

            C_MostenkenjyouKbn mosTenkenJoukbn = syoriCTL.getMostenkenjoukbn();

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {
                mosTenkenJoukbn = C_MostenkenjyouKbn.TENKENMATI_1;
            }
            else if (C_SyorikekkaKbn.IRAI_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {
                mosTenkenJoukbn = C_MostenkenjyouKbn.TENKENMATI_2;
            }
            else if (C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {
                mosTenkenJoukbn = C_MostenkenjyouKbn.TENKENMATI_HUBI;
            }

            C_KnkysateijyouKbn knkySateiJyoukbn = syoriCTL.getKnkysateijyoukbn();

            if (C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka())) {
                knkySateiJyoukbn = C_KnkysateijyouKbn.SATEIMATI_1;
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka())) {
                knkySateiJyoukbn = C_KnkysateijyouKbn.SATEIMATI_2A;
            }
            else if (C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka())) {
                knkySateiJyoukbn = C_KnkysateijyouKbn.SATEIMATI_2B;
            }

            C_ImusateijyouKbn imuSateiJyouKbn = syoriCTL.getImusateijyoukbn();

            if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn())) {
                imuSateiJyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_UW;
            }
            else if (C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) {
                imuSateiJyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_MD;
            }

            C_LinckknnjkKbn lincKknnJkKbn = syoriCTL.getLinckknnjkkbn();

            if (!C_LinckakKbn.BLNK.eq(uiBean.getLinckakkbn()) && C_LinckknnjkKbn.KAKUNINMATI.eq(lincKknnJkKbn)) {
                lincKknnJkKbn = C_LinckknnjkKbn.KAKUNINKANRYOU;
            }

            C_UmuKbn imuSateiRrkUmu = syoriCTL.getImusateirrkumu();

            if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn()) ||
                C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) {
                imuSateiRrkUmu = C_UmuKbn.ARI;
            }

            syoriCTL.setMostenkenrrkumu(mosTenkenRrkumu);
            syoriCTL.setMostenkenjoukbn(mosTenkenJoukbn);
            syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);
            syoriCTL.setKnkysateijyoukbn(knkySateiJyoukbn);
            syoriCTL.setImusateirrkumu(imuSateiRrkUmu);
            syoriCTL.setImusateijyoukbn(imuSateiJyouKbn);
            syoriCTL.setLinckknnjkkbn(lincKknnJkKbn);
            syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTL.setGyoumuKousinTime(sysDateTime);

            HT_MosKihon mosKihon = syoriCTL.getMosKihon();

            if (mosKihon == null) {

                throw new CommonBizAppException(MOSBANGOU + syoriCTL.getMosno());
            }

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

            if (gyoumuKouteiInfo == null) {

                throw new CommonBizAppException(MOSBANGOU + syoriCTL.getMosno());

            }

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
            mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
            mosnaiCheckParam.setSysDate(sysDate);
            mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
            mosnaiCheckParam.setKosTime(sysDateTime);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

            mosnaiCheckParam.debug(KNKSATEI_LOGMSG);

            if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getKnksateisateikekka())) {
                mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.KNK);
            }
            else {
                mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.BLNK);
            }

            mosnaiCheck.exec(mosnaiCheckParam);

            mosnoKanri = mosnaiCheckParam.getMosnoKanri();

            bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());

            if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
                sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
            }
        }
        else {

            C_KnkysateijyouKbn knkySateiJyouKbn = syoriCTL.getKnkysateijyoukbn();

            if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                knkySateiJyouKbn = C_KnkysateijyouKbn.SATEIZUMI;
            }

            C_LinckknnjkKbn lincKknnJkKbn = syoriCTL.getLinckknnjkkbn();

            if (!C_LinckakKbn.BLNK.eq(uiBean.getLinckakkbn()) && C_LinckknnjkKbn.KAKUNINMATI.eq(lincKknnJkKbn)) {
                lincKknnJkKbn = C_LinckknnjkKbn.KAKUNINKANRYOU;
            }

            if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())) {

                syoriCTL.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SYOUMETU);
            }

            syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);
            syoriCTL.setKnkysateijyoukbn(knkySateiJyouKbn);
            syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
            syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
            syoriCTL.setSateizumiymd(sysDate);
            syoriCTL.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
            syoriCTL.setSrsyoriymd(sysDate);
            syoriCTL.setLinckknnjkkbn(lincKknnJkKbn);
            syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTL.setGyoumuKousinTime(sysDateTime);

            addDakuhiKettei();

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(BizDate.getSysDate());
            mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
            mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);

            mosnaiCheckParam.debug(KNKSATEI_LOGMSG);

            C_HenkinriyuuKbn henkinriyuuKbn = C_HenkinriyuuKbn.BLNK;
            if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                henkinriyuuKbn = C_HenkinriyuuKbn.MOS_TORIKESI;
            }
            else {
                henkinriyuuKbn = C_HenkinriyuuKbn.MIAWASEENKI;
            }

            Henkin henkin = SWAKInjector.getInstance(Henkin.class);

            HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(0),
                C_Tuukasyu.BLNK, henkinriyuuKbn);

            List<HT_SkDenpyoData> skDenpyoDataList = henkinOutBean.getSkDenpyoDataList();
            if (skDenpyoDataList.size() > 0) {
                sinkeiyakuDomManager.insert(skDenpyoDataList);
            }

            mosnoKanri = setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL, BizDate.getSysDate(), baseUserInfo.getUserId());

            if (mosnoKanri == null){
                throw new CommonBizAppException(MOSBANGOU  + syoriCTL.getMosno());
            }
        }

        setUiBean(syoriCTL);

        HT_MosKihon  mosKihon = syoriCTL.getMosKihon();
        mosKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        mosKihon.setGyoumuKousinTime(sysDateTime);

        syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        syoriCTL.setGyoumuKousinTime(sysDateTime);

        sinkeiyakuDomManager.update(syoriCTL);

        if(mosnoKanri != null){
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        List<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(uiBean.getMosno());

        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        String uniqueId = objStorageManager.save(skHubiMsgRenkeiInfo);

        uiBean.setUniqueId(uniqueId);

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        for (String msg : msgList) {
            msgOut.append(KAIGYOU).append(msg);
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());

        doJikouteikanri();

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        String kouteiLockKey = getKouteiLockKey();

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(
            mosnaiCheckParam.getDataSyoriControl(), uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean =
                skToujituIdounaiyouEdit.skIdounaiyouMQEdit(mosnaiCheckParam.getDataSyoriControl());

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsg);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        unlockProcess();
    }

    void removeObj() {

        objStorageManager.remove(uiBean.getUniqueId());
    }

    String modoruBtnByInputcontentsBL() {

        unlockProcess();

        String forwardName = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                forwardName = FORWARDNAME_INIT_MOSTORIKESI;
            }
            else {
                forwardName = FORWARDNAME_INIT;
            }
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forwardName = FORWARDNAME_BACKTOWORKLIST;
        }

        return forwardName;
    }

    String functionNameOnClickBL() {

        unlockProcess();

        String forwardName = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                forwardName = FORWARDNAME_INIT_MOSTORIKESI;
            }
            else {
                forwardName = FORWARDNAME_INIT;
            }

        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forwardName = FORWARDNAME_BACKTOWORKLIST;
        }

        return forwardName;
    }

    String syokiGamenhebtnOnClickBL() {
        String forwardName = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                forwardName = FORWARDNAME_INIT_MOSTORIKESI;
            }
            else {
                forwardName = FORWARDNAME_INIT;
            }
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            forwardName = FORWARDNAME_BACKTOWORKLIST;
        }

        return forwardName;
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    void unlockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();
    }

    @SuppressWarnings("resource")
    void  callAjaxKetteiRiyuuNaiyou() throws IOException{

        HttpServletRequest req = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse res = SWAKInjector.getInstance(HttpServletResponse.class);

        String paramKetRiyuuCd = req.getParameter(AJAX_POST_PARAM_KETRIYUUCD);

        List<String> ketRiyuuNaiyouLst = new ArrayList<String>();

        if (!BizUtil.isBlank(paramKetRiyuuCd)) {

            String ketteiRiyuuNaiyou = C_Ketriyuucd.getContentByValue(C_Ketriyuucd.PATTERN_ITIRAN, paramKetRiyuuCd);

            if (!BizUtil.isBlank(ketteiRiyuuNaiyou)) {

                ketRiyuuNaiyouLst.add(ketteiRiyuuNaiyou);
            }
            else {

                ketRiyuuNaiyouLst.add("");
            }
        }
        else {

            ketRiyuuNaiyouLst.add("");
        }

        String responseJson = JSON.encode(ketRiyuuNaiyouLst);

        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println(responseJson);
        out.close();
    }

    void pushTojirubtnbytsyknyjkBL() {
        continueLockProcess();

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);

        if (PAGENO_INPUTCONTENTS == uiBean.getTasyaKanyuuJoukyouPath()) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.IHF1038);
        }
        else {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
                MessageId.QAC0008, MessageUtil.getMessage(MessageId.QAC0008));
        }
    }

    void pushLincjkbtnBL() {
        if (PAGENO_INPUTCONTENTS == uiBean.getTasyaKanyuuJoukyouPath()) {
            messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
        }
        else {
            messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
        }

        editTasyaKanyuuJoukyou();
    }

    @Transactional
    void pushHaneibtnBL() {

        sysDateTime = BizDate.getSysDateTimeMilli();
        String userId = baseUserInfo.getUserId();

        continueLockProcess();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        List<Integer> rennoLst = Lists.newArrayList();

        List<TasyaKanyuuJoukyouDataSourceBean> tasyaKanyuuJoukyouDataLst = uiBean.getTasyaKanyuuJoukyouDataSource().getAllData();

        for (TasyaKanyuuJoukyouDataSourceBean tasyaKanyuuJoukyouData : tasyaKanyuuJoukyouDataLst) {
            if (tasyaKanyuuJoukyouData.getTasyaout()) {
                rennoLst.add(tasyaKanyuuJoukyouData.getDbRenno());
            }
        }

        if (rennoLst.size() > 0) {
            EditPdfKyknaiyoutrseidoskhy editPdfKyknaiyoutrseidoskhy = SWAKInjector.getInstance(EditPdfKyknaiyoutrseidoskhy.class);

            List<String> tyouhyoukeyLst = editPdfKyknaiyoutrseidoskhy.exec(syoriCTL, uiBean.getLincjyusintrrenno(), rennoLst);

            uiBean.setTyouhyoukeyLst(tyouhyoukeyLst);
        }

        List<HT_SkLincSyoukaikekka> skLincSyoukaikekkaLst = syoriCTL.getSkLincSyoukaikekkas();

        skLincSyoukaikekkaLst = new ArrayList<HT_SkLincSyoukaikekka>(
            Collections2.filter(skLincSyoukaikekkaLst, new FilterSkLincSyoukaikekka(uiBean.getLincjyusintrrenno())));

        for (TasyaKanyuuJoukyouDataSourceBean tasyaKanyuuJoukyouData : tasyaKanyuuJoukyouDataLst) {
            for (HT_SkLincSyoukaikekka skLincSyoukaikekka : skLincSyoukaikekkaLst) {
                if (tasyaKanyuuJoukyouData.getDbRenno().equals(skLincSyoukaikekka.getRenno())) {
                    skLincSyoukaikekka.setAnkenjyoutai(tasyaKanyuuJoukyouData.getTasyaankenjyoutai());
                    skLincSyoukaikekka.setKyksyubetu(tasyaKanyuuJoukyouData.getTasyakyksyubetu());
                    skLincSyoukaikekka.setGyoumuKousinsyaId(userId);
                    skLincSyoukaikekka.setGyoumuKousinTime(sysDateTime);
                }
            }
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);

        uiBean.setHaneibtnOnClickFlg(true);
    }

    void pushTojiruBtnByPopupBL() {
        continueLockProcess();

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008, MessageUtil.getMessage(MessageId.QAC0008));
    }

    void printOut(){

        String[] tyouhyoukeyds = uiBean.getTyouhyoukeyLst().toArray(new String[0]);

        outputReport.outputPDFByKeys(tyouhyoukeyds);
    }


    private String getKouteiLockKey() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        return kouteiLockKey;
    }

    private void continueLockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();
    }

    private void startInputContents() {

        String kouteiKanriID  = uiBean.getBzWorkflowInfo().getKouteiKanriId();
        String jimuTetuzukiCd = uiBean.getBzWorkflowInfo().getJimuTetuzukiCd();

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setKouteiKanriId(kouteiKanriID);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(jimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        String mosno = bzGetProcessSummaryOutBeanList.get(0).getMosNo();

        uiBean.setMosno(mosno);

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosno);

        bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno);

        uiBean.setSyoriCTL(syoriCTL);

        if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())
            || C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

            if (ketteiSya == null) {
                if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_1TI);
                }
                else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2A);
                }
                else {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2B);
                }
            }

            if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

                if (!C_KnksateirankKbn.ITIJI.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_1TI);
                }
            }
            else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

                if (!C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2A);
                }
            }
            else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

                if (!C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2B);
                }
            }

            BizCurrency hutuuSibouS = getHutuuSbs(syoriCTL);

            if (ketteiSya.getKnksateijygns().compareTo(hutuuSibouS) < 0) {
                throw new BizLogicException(MessageId.EHA1014, hutuuSibouS.toFormatString());
            }
        }


        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekis();

        if (knksateiRirekiLst.size() == 0 && C_UmuKbn.ARI.eq(syoriCTL.getKnkysateirrkumu())) {
            throw new CommonBizAppException(MOSBANGOU + mosno);
        }

        if (knksateiRirekiLst.size() > 0) {
            knkSateiComment = knksateiRirekiLst.get(knksateiRirekiLst.size() - 1).getKnksateicomment();
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        List<String> gmwarningIdLst = Lists.newArrayList();
        List<String> gmwarningLst = Lists.newArrayList();

        if (mosKihon == null) {
            throw new CommonBizAppException(MOSBANGOU + mosno);
        }

        int kekkaKbnAite = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon.getAitemosno());

        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbnAite){
            gmwarningIdLst.add(getMsgAitemosno.getS_gmmsgid());
            gmwarningLst.add(getMsgAitemosno.getS_gmmsg());
        }

        int kekkaKbnDouji = getMsgDoujikaiyakusyono.exec(syoriCTL.getMosnrkumu(), mosKihon.getDoujikaiyakusyono());

        if (GetMsgDoujikaiyakusyono.KEKKAKBN_ARI == kekkaKbnDouji){
            gmwarningIdLst.add(getMsgDoujikaiyakusyono.getS_gmmsgid());
            gmwarningLst.add(getMsgDoujikaiyakusyono.getS_gmmsg());
        }

        hanteiDoujiMos.hanteiDoujiMos(mosno);

        if (C_UmuKbn.ARI.eq(hanteiDoujiMos.getDoujiMosUmu())) {

            gmwarningIdLst.add(MessageId.WHC0102);
            gmwarningLst.add(MessageUtil.getMessage(MessageId.WHC0102, hanteiDoujiMos.getMsgMosnoList()));
        }

        if (C_LincjkKbn.KAITOARI_TASYAARI.eq(syoriCTL.getLincjkkbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.IHF1038);
        }

        uiBean.setGmwarningIdLst(gmwarningIdLst);
        uiBean.setGmwarningLst(gmwarningLst);

        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL.getImusateiRirekis();

        List<HT_MostenkenRireki> mostenkenRirekiLst = syoriCTL.getMostenkenRirekis();

        List<HT_RuleHanteiMsg> ruleHanteiMsgList = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.KNKSATEI);

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns(
            baseUserInfo.getUserId(), C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA, C_KnksateirankKbn.NIJIB);

        List<HT_SkTtdkTyuui> skTtdkTyuuiList = getSkTtdkTyuui.getTtdkTyuui(mosno, C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        List<HT_NayoseKekka> nayoseKekkaList = syoriCTL.getNayoseKekkas();

        if (ruleHanteiMsgList.size() > 0) {
            knkSateiSjNaiyou = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);
        }

        if (C_ImusateijyouKbn.NONE.eq(syoriCTL.getImusateijyoukbn()) &&
            (!C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn())
                && !C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn())) &&
                !C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            imuSateiYhFlg = IMUSATEIFLG_YOU;
        }

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            mosTenkenYhFlg = MOSTENKENIRAIFLG_YOU;
        }

        addConversationMessage();

        setUiBean(mosKihon, syoriCTL, knksateiRirekiLst, ketteiSyaList,
            imusateiRirekiLst, mostenkenRirekiLst, skTtdkTyuuiList, nayoseKekkaList);

        String kouteiLockKey = getKouteiLockKey();

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        C_TskStartKekkaKbn tskStartKekkaKbn = bzTaskStart.exec(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            kouteiLockKey,
            baseUserInfo.getUserId());

        if (C_TskStartKekkaKbn.HUKA_TATANTOUWARIATEZUMI.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0111);
        }
        else if (C_TskStartKekkaKbn.HUKA_STARTTSKNONE.eq(tskStartKekkaKbn)) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            uiBean.setPatternKetkekkacd(C_Ketkekkacd.PATTERN_MOSTORIKESI);
        }
        else {
            uiBean.setPatternKetkekkacd(C_Ketkekkacd.PATTERN_KNKSATEI);
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            uiBean.setPatternKnksateisateikekka(C_SyorikekkaKbn.PATTERN_SKMOSTORIKESITENSOU);
        }
        else {
            uiBean.setPatternKnksateisateikekka(C_SyorikekkaKbn.PATTERN_SKKNKSATEI);
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        uiBean.setTasyaKanyuuJoukyouPath(PAGENO_INPUTCONTENTS);
    }

    private void chkSyoriKh(HT_SyoriCTL pSyoriCTL) {

        C_SeirituKbn seirituKbn = pSyoriCTL.getSeiritukbn();
        C_KetteiKbn ketteiKbn = pSyoriCTL.getKetteikbn();
        C_UmuKbn mosNrkUmu = pSyoriCTL.getMosnrkumu();
        C_KnkysateijyouKbn knkysateijyouKbn = pSyoriCTL.getKnkysateijyoukbn();
        C_UmuKbn kthhbKbn = pSyoriCTL.getKthhbkbn();

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            if (!C_SeirituKbn.NONE.eq(seirituKbn)){
                throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
            }

            if (C_UmuKbn.NONE.eq(mosNrkUmu)) {
                throw new BizLogicException(MessageId.EHA0027);
            }

            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            checkKinouModeKengen.checkKengenByKinouModeId(uiBean.getKinouMode().getKinouMode());
        }
        else {
            BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                uiBean.getBzWorkflowInfo().getTaskId(),
                baseUserInfo.getUserId());

            if (wariateHukaInfo != null) {
                throw new BizLogicException(MessageId.EHA0304);
            }

            if (!C_SeirituKbn.NONE.eq(seirituKbn)){
                throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
            }

            if (!C_KetteiKbn.NONE.eq(ketteiKbn) && !C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)){
                throw new BizLogicException(MessageId.EBA0031, ketteiKbn.getContent());
            }

            if (C_UmuKbn.NONE.eq(mosNrkUmu)){
                throw new BizLogicException(MessageId.EHA0027);
            }

            if ((C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())
                || C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode()))
                && C_UmuKbn.ARI.eq(kthhbKbn)) {

                throw new BizLogicException(MessageId.EHA1035);
            }

            if (!C_KnkysateijyouKbn.SATEIMATI_1.eq(knkysateijyouKbn) &&
                !C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkysateijyouKbn) &&
                !C_KnkysateijyouKbn.SATEIMATI_2B.eq(knkysateijyouKbn)){
                throw new BizLogicException(MessageId.EHA0302);
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

            if (ketteiSya == null) {
                if (C_KnkysateijyouKbn.SATEIMATI_1.eq(knkysateijyouKbn)) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_1TI);
                }
                else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkysateijyouKbn)) {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2A);
                }
                else {
                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2B);
                }
            }

            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

            if (C_KnkysateijyouKbn.SATEIMATI_1.eq(knkysateijyouKbn)) {
                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    baseUserInfo.getUserId(), kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue());

                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA1073, ERRMSG_KNKYSATEI_1TI);
                }
            }

            else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkysateijyouKbn)) {
                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    baseUserInfo.getUserId(), kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue());

                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA1073, ERRMSG_KNKYSATEI_2A);
                }
            }

            else if (C_KnkysateijyouKbn.SATEIMATI_2B.eq(knkysateijyouKbn)) {
                boolean kengenUmuFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    baseUserInfo.getUserId(), kinou.getKinouId(), C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue());

                if (!kengenUmuFlg) {
                    throw new BizLogicException(MessageId.EHA1073, ERRMSG_KNKYSATEI_2B);
                }
            }

            if (C_KnkysateijyouKbn.SATEIMATI_1.eq(knkysateijyouKbn)) {
                if (!C_KnksateirankKbn.ITIJI.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())){

                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_1TI);
                }
            }
            else if (C_KnkysateijyouKbn.SATEIMATI_2A.eq(knkysateijyouKbn)) {
                if (!C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()) &&
                    !C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())){

                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2A);
                }
            }
            else {
                if (!C_KnksateirankKbn.NIJIB.eq(ketteiSya.getKnksateirankkbn())) {

                    throw new BizLogicException(MessageId.EHA0303, ERRMSG_KNKYSATEI_2B);
                }
            }

            BizCurrency hutuuSbs = getHutuuSbs(pSyoriCTL);

            if (ketteiSya.getKnksateijygns().compareTo(hutuuSbs) < 0) {
                throw new BizLogicException(MessageId.EHA1014, hutuuSbs.toFormatString());
            }
        }
    }

    private void setUiBean(
        HT_MosKihon               pMosKihon,
        HT_SyoriCTL               pSyoriCTL,
        List<HT_KnksateiRireki>   pKnksateiRirekiLst,
        List<HM_KetteiSya>        pKetteiSya,
        List<HT_ImusateiRireki>   pImusateiRirekiLst,
        List<HT_MostenkenRireki>  pMostenkenRirekiLst,
        List<HT_SkTtdkTyuui>      pSkTtdkTyuuiLst,
        List<HT_NayoseKekka>      pNayoseKekka){

        String mosno = uiBean.getMosno();

        uiBean.setMosno(mosno);
        uiBean.setHhknnmkj(pMosKihon.getHhknnmkj());

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        setSintyokukJk(pSyoriCTL);

        uiBean.setZenkaiknksateicomnt(EditSecurityKm.getDecodeData(mosno, knkSateiComment));

        setKnkSateiRrk(pKnksateiRirekiLst);

        setSentakuJouhou(pNayoseKekka);

        setTtdkTyuui(pSkTtdkTyuuiLst);

        setKnkImuSatei(pKetteiSya, pKnksateiRirekiLst, pSyoriCTL);

        setImuSateiRrk(pImusateiRirekiLst);

        setMosTenkenRrk(pMostenkenRirekiLst);

        uiBean.setKhnchkcmnt(pMosKihon.getKhnchkcmnt());
        uiBean.setLinckakkbn(C_LinckakKbn.BLNK);
    }

    private void setSintyokukJk(HT_SyoriCTL pSyoriCTL){

        uiBean.setMosnrkumu(pSyoriCTL.getMosnrkumu());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkumu())) {

            uiBean.setKkthjykbn(C_KkthjyKbn.HJYNRK_ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {

            uiBean.setKkthjykbn(C_KkthjyKbn.KKTNRK_ARI);
        }
        else {
            uiBean.setKkthjykbn(C_KkthjyKbn.NONE);
        }

        uiBean.setNyknnrkumu(pSyoriCTL.getNyknnrkumu());
        uiBean.setMostenkenjoukbn(pSyoriCTL.getMostenkenjoukbn());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())) {

            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())) {

            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {

            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setHubiumu(C_UmuKbn.NONE);
        }

        uiBean.setKykkakjkkbn(pSyoriCTL.getKykkakjkkbn());
        uiBean.setLincjkkbn(pSyoriCTL.getLincjkkbn());
        uiBean.setLinckknnjkkbn(pSyoriCTL.getLinckknnjkkbn());
        uiBean.setKnkysateijyoukbn(pSyoriCTL.getKnkysateijyoukbn());
        uiBean.setImusateijyoukbn(pSyoriCTL.getImusateijyoukbn());
        uiBean.setKetteikbn(pSyoriCTL.getKetteikbn());
        uiBean.setJimusrhkbn(pSyoriCTL.getJimusrhkbn());
        uiBean.setSeiritukbn(pSyoriCTL.getSeiritukbn());
        uiBean.setMostenken1jiyhkbn(pSyoriCTL.getMostenken1jiyhkbn());
        uiBean.setMostenken2jiyhkbn(pSyoriCTL.getMostenken2jiyhkbn());
        uiBean.setLincgthtkekkbn(pSyoriCTL.getLincgthtkekkbn());
        uiBean.setKnkysatei1jiyhkbn(pSyoriCTL.getKnkysatei1jiyhkbn());
        uiBean.setKnkysatei2jiyhkbn(pSyoriCTL.getKnkysatei2jiyhkbn());
        uiBean.setImusateikaniyhkbn(pSyoriCTL.getImusateikaniyhkbn());
        uiBean.setKnksateisjnaiyou(knkSateiSjNaiyou);
    }

    private void setKnkSateiRrk(List<HT_KnksateiRireki> pKnksateiRirekiLst) {

        List<KankyouSateiRirekiDataSourceBean> kankyouSateiRrkDsBeanLst = Lists.newArrayList();

        if (pKnksateiRirekiLst.size() > 0) {
            for (HT_KnksateiRireki knksateiRireki : pKnksateiRirekiLst) {
                KankyouSateiRirekiDataSourceBean kankyouSateiRrkDsBean =
                    SWAKInjector.getInstance(KankyouSateiRirekiDataSourceBean.class);

                String knksateiComment = EditSecurityKm.getDecodeData(uiBean.getMosno(), knksateiRireki.getKnksateicomment());

                kankyouSateiRrkDsBean.setDispknksyoriymd(knksateiRireki.getSyoriYmd());
                kankyouSateiRrkDsBean.setDispknkstktsyorinmkbn(knksateiRireki.getSateiketsyorinmkbn());
                kankyouSateiRrkDsBean.setDispknkkekkakbn(knksateiRireki.getKnksateikekkakbn());
                kankyouSateiRrkDsBean.setDispknkcomment(EditGamenString.editStringSbstr(knksateiComment, COMMENT_MAX));

                if (knksateiRireki.getKetteiSya() != null) {
                    kankyouSateiRrkDsBean.setDispknkktnm(knksateiRireki.getKetteiSya().getKetsyanm());
                } else {
                    kankyouSateiRrkDsBean.setDispknkktnm("");
                }

                kankyouSateiRrkDsBeanLst.add(kankyouSateiRrkDsBean);
            }
        }
        else {
            kankyouSateiRrkDsBeanLst.add(SWAKInjector.getInstance(KankyouSateiRirekiDataSourceBean.class));
        }

        uiBean.setKankyouSateiRireki(kankyouSateiRrkDsBeanLst);
    }

    private void setSentakuJouhou(List<HT_NayoseKekka> pNayoseKekkaLst) {

        List<SentakuJouhouDataSourceBean> sentakuJouhouDsBeanLst = Lists.newArrayList();

        if (pNayoseKekkaLst.size() > 0) {
            for (HT_NayoseKekka nayoseKekka : pNayoseKekkaLst) {

                if (C_BlnktkumuKbn.ARI.eq(nayoseKekka.getSignalsetteiumukbn())||
                    C_BlnktkumuKbn.ARI.eq(nayoseKekka.getGaikokupepsumukbn())) {

                    SentakuJouhouDataSourceBean sentakuJouhouDataSourceBean =
                        SWAKInjector.getInstance(SentakuJouhouDataSourceBean.class);

                    sentakuJouhouDataSourceBean.setDispsntkinfotsysy(nayoseKekka.getSntkinfotaisyousyakbn());
                    sentakuJouhouDataSourceBean.setDispsntkinfono("");
                    sentakuJouhouDataSourceBean.setDispsntkinfosyubetu(editSntkinfoSyubetuByNayoseKekka(nayoseKekka));
                    sentakuJouhouDataSourceBean.setDispsntkinfosyskbn(C_SysCdKbn.BLNK);

                    sentakuJouhouDsBeanLst.add(sentakuJouhouDataSourceBean);
                }

                List<HT_SentakuJyouhou> sentakuJyouhouLst =
                    uiBean.getSyoriCTL().getSentakuJyouhousBySntkinfotaisyousyakbnEdano(
                        nayoseKekka.getSntkinfotaisyousyakbn(), nayoseKekka.getEdano());

                if (sentakuJyouhouLst.size() > 0) {
                    for (HT_SentakuJyouhou sentakuJyouhou : sentakuJyouhouLst) {

                        String sentakuJouhouSyubetu = editSntkinfoSyubetu(sentakuJyouhou);

                        if (sentakuJouhouSyubetu == null || sentakuJouhouSyubetu.length() == 0) {

                            continue;
                        }

                        SentakuJouhouDataSourceBean sentakuJouhouDataSourceBean =
                            SWAKInjector.getInstance(SentakuJouhouDataSourceBean.class);

                        sentakuJouhouDataSourceBean.setDispsntkinfotsysy(sentakuJyouhou.getSntkinfotaisyousyakbn());
                        sentakuJouhouDataSourceBean.setDispsntkinfono(sentakuJyouhou.getSntkinfono());
                        sentakuJouhouDataSourceBean.setDispsntkinfosyskbn(sentakuJyouhou.getSyscdkbn());
                        sentakuJouhouDataSourceBean.setDispsntkinfosyubetu(sentakuJouhouSyubetu);

                        sentakuJouhouDsBeanLst.add(sentakuJouhouDataSourceBean);
                    }
                }
            }
        }

        uiBean.setSentakuJouhou(sentakuJouhouDsBeanLst);
    }

    private String editSntkinfoSyubetuByNayoseKekka(HT_NayoseKekka pNayoseKekka) {

        String sentakuJouhouSyubetu = "";

        if (C_BlnktkumuKbn.ARI.eq(pNayoseKekka.getSignalsetteiumukbn())) {

            sentakuJouhouSyubetu = SENTAKUSHUBETSU_SHIGUNARU;
        }

        if (C_BlnktkumuKbn.ARI.eq(pNayoseKekka.getGaikokupepsumukbn()) ) {

            if (BizUtil.isBlank(sentakuJouhouSyubetu)) {
                sentakuJouhouSyubetu = SENTAKUSHUBETSU_PEPSJHYUU;
            }
            else {
                sentakuJouhouSyubetu = sentakuJouhouSyubetu + RENKETSU_BUNJI + SENTAKUSHUBETSU_PEPSJHYUU;
            }
        }

        return sentakuJouhouSyubetu;
    }

    private String editSntkinfoSyubetu(HT_SentakuJyouhou pSentakuJyouhou) {

        String sentakuJouhouSyubetu = "";

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getMrumukbn()) ||
            C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getHuho2mrumukbn())) {

            sentakuJouhouSyubetu = SENTAKUSHUBETSU_MRJHYUU;
        }

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getDecumukbn()) ||
            C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getHuho2decumukbn())) {

            if (BizUtil.isBlank(sentakuJouhouSyubetu)) {
                sentakuJouhouSyubetu = SENTAKUSHUBETSU_DECJHYUU;
            }
            else {
                sentakuJouhouSyubetu = sentakuJouhouSyubetu + RENKETSU_BUNJI + SENTAKUSHUBETSU_DECJHYUU;
            }
        }

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getTorikaijoumukbn()) ||
            C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getHuho2torikaijoumukbn())) {

            if (BizUtil.isBlank(sentakuJouhouSyubetu)) {
                sentakuJouhouSyubetu = SENTAKUSHUBETSU_TRKKAIJYOJHYUU;
            }
            else {
                sentakuJouhouSyubetu = sentakuJouhouSyubetu + RENKETSU_BUNJI + SENTAKUSHUBETSU_TRKKAIJYOJHYUU;
            }
        }

        return sentakuJouhouSyubetu;
    }

    private void setTtdkTyuui(List<HT_SkTtdkTyuui> pSkTtdkTyuuiLst) {
        List<ToriatukaiTyuuiJouhouDataSourceBean> toriatukaiTyuuiJhDsBeanLst = Lists.newArrayList();

        if (pSkTtdkTyuuiLst != null) {
            for (HT_SkTtdkTyuui skTtdkTyuui: pSkTtdkTyuuiLst) {
                ToriatukaiTyuuiJouhouDataSourceBean toriatukaiTyuuiJhDsBean =
                    SWAKInjector.getInstance(ToriatukaiTyuuiJouhouDataSourceBean.class);

                String skeittdktyuuinaiyou = EditSecurityKm.getDecodeData(
                    uiBean.getMosno(), skTtdkTyuui.getSkeittdktyuuinaiyou());

                toriatukaiTyuuiJhDsBean.setDispskeittdktyuitrttrkymd(skTtdkTyuui.getTrkymd());
                toriatukaiTyuuiJhDsBean.setDispskeittdktyuitrtnaiyo(skeittdktyuuinaiyou);

                AM_User user =  baseDomManager.getUser(skTtdkTyuui.getGyoumuKousinsyaId());
                if(user != null) {
                    toriatukaiTyuuiJhDsBean.setDispskeittdktyuitrttantou(user.getUserNm());

                }else {
                    toriatukaiTyuuiJhDsBean.setDispskeittdktyuitrttantou("");
                }

                toriatukaiTyuuiJhDsBeanLst.add(toriatukaiTyuuiJhDsBean);
            }

            uiBean.setToriatukaiTyuuiJouhou(toriatukaiTyuuiJhDsBeanLst);
        }
    }

    private void setKnkImuSatei(List<HM_KetteiSya> pKetteiSyaLst,
        List<HT_KnksateiRireki> pKnksateiRirekiLst, HT_SyoriCTL pSyoriCTL) {

        UserDefsList userList = new UserDefsList();
        userList.add(new LabelValuePair("", ""));
        for (HM_KetteiSya ketteiSya : pKetteiSyaLst) {
            userList.add(new LabelValuePair(ketteiSya.getKetsyanm(), ketteiSya.getKetsyacd()));
        }

        uiBean.setKnksateisateikekka(C_SyorikekkaKbn.BLNK);
        uiBean.setKnktnsketsyacd("");
        uiBean.setKnktnsketsyacdOptionBeanList(userList);
        uiBean.setKnksateicommentgamen("");
        uiBean.setHubihassintnskbn(C_HubihassintnsKbn.BLNK);

        uiBean.setImusateiIraiyhFlg(imuSateiYhFlg);
        uiBean.setImusateikekkakbn(C_SyorikekkaKbn.BLNK);
        uiBean.setImusateiiraicomment("");

        uiBean.setMosTenkenIraiyhFlg(mosTenkenYhFlg);
        uiBean.setMostenkenkekkakbn(C_SyorikekkaKbn.BLNK);
        uiBean.setMostenkeniraicomment("");


        if (pKnksateiRirekiLst.size() > 0) {
            HT_KnksateiRireki knksateiRireki = pKnksateiRirekiLst.get(pKnksateiRirekiLst.size() - 1);


            if ((C_KnkysateijyouKbn.SATEIMATI_1.eq(pSyoriCTL.getKnkysateijyoukbn()) ||
                C_KnkysateijyouKbn.SATEIMATI_2A.eq(pSyoriCTL.getKnkysateijyoukbn()) ||
                C_KnkysateijyouKbn.SATEIMATI_2B.eq(pSyoriCTL.getKnkysateijyoukbn())) &&
                (C_SateiketsyorinmKbn.KNKSATEI_1.eq(knksateiRireki.getSateiketsyorinmkbn()) ||
                    C_SateiketsyorinmKbn.KNKSATEI_2A.eq(knksateiRireki.getSateiketsyorinmkbn()) ||
                    C_SateiketsyorinmKbn.KNKSATEI_2B.eq(knksateiRireki.getSateiketsyorinmkbn()))) {

                if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

                    uiBean.setKetkekkacd(knksateiRireki.getKetkekkacd());
                    uiBean.setKetriyuucd1gamen("");
                    uiBean.setKetriyuucd2gamen("");
                    uiBean.setKetriyuucd3gamen("");
                    uiBean.setKetriyuucd4gamen("");
                    uiBean.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);
                    uiBean.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
                }
                else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
                    C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

                    uiBean.setKetkekkacd(knksateiRireki.getKetkekkacd());
                    if (!C_Ketriyuucd.BLNK.eq(knksateiRireki.getKetriyuucd1())) {
                        uiBean.setKetriyuucd1gamen(knksateiRireki.getKetriyuucd1().getValue());
                    }

                    if (!C_Ketriyuucd.BLNK.eq(knksateiRireki.getKetriyuucd2())) {
                        uiBean.setKetriyuucd2gamen(knksateiRireki.getKetriyuucd2().getValue());
                    }

                    if (!C_Ketriyuucd.BLNK.eq(knksateiRireki.getKetriyuucd3())) {
                        uiBean.setKetriyuucd3gamen(knksateiRireki.getKetriyuucd3().getValue());
                    }

                    if (!C_Ketriyuucd.BLNK.eq(knksateiRireki.getKetriyuucd4())) {
                        uiBean.setKetriyuucd4gamen(knksateiRireki.getKetriyuucd4().getValue());
                    }

                    uiBean.setMrriyuucdkbn(knksateiRireki.getMrriyuucdkbn());
                    uiBean.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
                }
            }
            else if (C_SateiketsyorinmKbn.TORIKESI.eq(knksateiRireki.getSateiketsyorinmkbn())) {

                if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
                    uiBean.setKetkekkacd(knksateiRireki.getKetkekkacd());
                    uiBean.setKetriyuucd1gamen("");
                    uiBean.setKetriyuucd2gamen("");
                    uiBean.setKetriyuucd3gamen("");
                    uiBean.setKetriyuucd4gamen("");
                    uiBean.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);
                    uiBean.setTorikesisyousairiyuucd(knksateiRireki.getTorikesisyousairiyuucd());
                }
            }
            else {
                uiBean.setKetkekkacd(C_Ketkekkacd.BLNK);
                uiBean.setKetriyuucd1gamen("");
                uiBean.setKetriyuucd2gamen("");
                uiBean.setKetriyuucd3gamen("");
                uiBean.setKetriyuucd4gamen("");
                uiBean.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);
                uiBean.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
            }
        }
        else {
            uiBean.setKetkekkacd(C_Ketkekkacd.BLNK);
            uiBean.setKetriyuucd1gamen("");
            uiBean.setKetriyuucd2gamen("");
            uiBean.setKetriyuucd3gamen("");
            uiBean.setKetriyuucd4gamen("");
            uiBean.setMrriyuucdkbn(C_MrRiyuucdKbn.BLNK);
            uiBean.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
        }
    }

    private void setImuSateiRrk(List<HT_ImusateiRireki> pImusateiRirekiLst) {

        List<ImuSateiRirekiDataSourceBean> imuSateiRrkDsBeanLst = Lists.newArrayList();

        if (pImusateiRirekiLst.size() > 0) {
            for (HT_ImusateiRireki imusateiRireki: pImusateiRirekiLst) {
                ImuSateiRirekiDataSourceBean imuSateiRrkDsBean =
                    SWAKInjector.getInstance(ImuSateiRirekiDataSourceBean.class);

                String imusateiComment =
                    EditSecurityKm.getDecodeData(uiBean.getMosno(),imusateiRireki.getImusateicomment());

                imuSateiRrkDsBean.setDispimusyoriymd(imusateiRireki.getSyoriYmd());
                imuSateiRrkDsBean.setDispimustktsyorinmkbn(imusateiRireki.getSateiketsyorinmkbn());
                imuSateiRrkDsBean.setDispimukekkakbn(imusateiRireki.getImusateikekkakbn());
                imuSateiRrkDsBean.setDispimucomment(EditGamenString.editStringSbstr(imusateiComment, COMMENT_MAX));

                if (imusateiRireki.getKetteiSya() != null) {
                    imuSateiRrkDsBean.setDispimuktnm(imusateiRireki.getKetteiSya().getKetsyanm());
                } else {
                    imuSateiRrkDsBean.setDispimuktnm("");
                }

                imuSateiRrkDsBeanLst.add(imuSateiRrkDsBean);
            }
        }
        else {
            imuSateiRrkDsBeanLst.add(SWAKInjector.getInstance(ImuSateiRirekiDataSourceBean.class));
        }

        uiBean.setImuSateiRireki(imuSateiRrkDsBeanLst);
    }

    private void setMosTenkenRrk(List<HT_MostenkenRireki> pMostenkenRirekiLst) {

        List<MosTenkenRirekiDataSourceBean> mosTenkenRrkDsBeanLst = Lists.newArrayList();

        if (pMostenkenRirekiLst.size() > 0) {
            for (HT_MostenkenRireki mostenkenRireki : pMostenkenRirekiLst) {
                MosTenkenRirekiDataSourceBean mosTenkenRirekiDataSourceBean =
                    SWAKInjector.getInstance(MosTenkenRirekiDataSourceBean.class);

                String mosTenkenComment =
                    EditSecurityKm.getDecodeData(uiBean.getMosno(), mostenkenRireki.getMostenkencomment());

                mosTenkenRirekiDataSourceBean.setDispmostenkensyoriymd(mostenkenRireki.getSyoriYmd());
                mosTenkenRirekiDataSourceBean.setDispmostnknstktsyorinmkbn(mostenkenRireki.getSateiketsyorinmkbn());
                mosTenkenRirekiDataSourceBean.setDispmostenkenkekkakbn(mostenkenRireki.getMostenkenkekkakbn());
                mosTenkenRirekiDataSourceBean.setDispmostenkencomment(
                    EditGamenString.editStringSbstr(mosTenkenComment, COMMENT_MAX));

                if (mostenkenRireki.getKetteiSya() != null) {
                    mosTenkenRirekiDataSourceBean.setDispmostenkenktnm(mostenkenRireki.getKetteiSya().getKetsyanm());
                } else {
                    mosTenkenRirekiDataSourceBean.setDispmostenkenktnm("");
                }

                mosTenkenRrkDsBeanLst.add(mosTenkenRirekiDataSourceBean);
            }
        }
        else {
            mosTenkenRrkDsBeanLst.add(SWAKInjector.getInstance(MosTenkenRirekiDataSourceBean.class));
        }

        uiBean.setMosTenkenRireki(mosTenkenRrkDsBeanLst);
    }

    private void addSTKnksateirrk() {

        int renNo  = 1;

        HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(uiBean.getMosno());

        if (knksateiRireki != null) {
            renNo = knksateiRireki.getRenno() + 1;
        }

        C_SateiketsyorinmKbn sateiKetSyorinmKbn = null;

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.TORIKESI;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_1;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_2A;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_2B;
        }

        String tnsKetsyaCd = null;

        if (C_SyorikekkaKbn.TENSOU_MOSTORIKESI.eq(uiBean.getKnksateisateikekka()) ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_1.eq(uiBean.getKnksateisateikekka())   ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2A.eq(uiBean.getKnksateisateikekka())  ||
            C_SyorikekkaKbn.TENSOU_KANKYOU_2B.eq(uiBean.getKnksateisateikekka())) {

            tnsKetsyaCd = uiBean.getKnktnsketsyacd();
        }
        else if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getKnksateisateikekka())) {

            tnsKetsyaCd = baseUserInfo.getUserId();
        }

        String palKetteisyaCd = "";
        C_Ketriyuucd ketRiyuuCd1 = null;
        C_Ketriyuucd ketRiyuuCd2 = null;
        C_Ketriyuucd ketRiyuuCd3 = null;
        C_Ketriyuucd ketRiyuuCd4 = null;
        C_MrRiyuucdKbn mrRiyuucdKbn = null;
        C_TorikesisyousairiyuuCd trksSyousaiRiyuuCd = null;

        if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            palKetteisyaCd = ISkCommonKoumoku.PALKETSYACD_SISYAKETSYA;
        }
        else {
            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

            if (ketteiSya != null) {
                palKetteisyaCd = ketteiSya.getPalketsyacd();
            }
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            ketRiyuuCd1 = C_Ketriyuucd.ZENINDOUTOKUHUAN;
        }
        else {
            if (!BizUtil.isBlank(uiBean.getKetriyuucd1gamen())) {
                ketRiyuuCd1 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd1gamen());
            }
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            ketRiyuuCd2 = C_Ketriyuucd.SISYAKETTEIKEKKA;
        }
        else {
            if (!BizUtil.isBlank(uiBean.getKetriyuucd2gamen())) {
                ketRiyuuCd2 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd2gamen());
            }
        }

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            if (!BizUtil.isBlank(uiBean.getKetriyuucd3gamen())) {
                ketRiyuuCd3 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd3gamen());
            }

        }

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            if (!BizUtil.isBlank(uiBean.getKetriyuucd4gamen())) {
                ketRiyuuCd4 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd4gamen());
            }

        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            mrRiyuucdKbn = C_MrRiyuucdKbn.HANSYA;
        }
        else {

            mrRiyuucdKbn = uiBean.getMrriyuucdkbn();
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            trksSyousaiRiyuuCd = uiBean.getTorikesisyousairiyuucd();
        }

        HT_KnksateiRireki KnksateiRireki = uiBean.getSyoriCTL().createKnksateiRireki();

        KnksateiRireki.setRenno(renNo);
        KnksateiRireki.setSyoriYmd(sysDate);
        KnksateiRireki.setSateiketsyorinmkbn(sateiKetSyorinmKbn);
        KnksateiRireki.setKnksateikekkakbn(uiBean.getKnksateisateikekka());
        KnksateiRireki.setTnsketsyacd(tnsKetsyaCd);
        KnksateiRireki.setKetsyacd(baseUserInfo.getUserId());
        KnksateiRireki.setPalketsyacd(palKetteisyaCd);
        KnksateiRireki.setKetriyuucd1(ketRiyuuCd1);
        KnksateiRireki.setKetriyuucd2(ketRiyuuCd2);
        KnksateiRireki.setKetriyuucd3(ketRiyuuCd3);
        KnksateiRireki.setKetriyuucd4(ketRiyuuCd4);
        KnksateiRireki.setMrriyuucdkbn(mrRiyuucdKbn);
        KnksateiRireki.setTorikesisyousairiyuucd(trksSyousaiRiyuuCd);
        KnksateiRireki.setKnksateicomment(
            EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getKnksateicommentgamen()));
        KnksateiRireki.setKetkekkacd(uiBean.getKetkekkacd());
        KnksateiRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        KnksateiRireki.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(KnksateiRireki);
    }

    private void addSTImusateirrk() {

        int renNo  = 1;

        HT_ImusateiRireki imusateiRrkMaxRenno = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno(uiBean.getMosno());

        if (imusateiRrkMaxRenno != null) {
            renNo = imusateiRrkMaxRenno.getRenno() + 1;
        }

        C_SateiketsyorinmKbn sateiKetSyorinmKbn = null;

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.TORIKESI;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_1;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_2A;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiKetSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_2B;
        }

        String palKetteisyaCd = "";

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        if (ketteiSya != null) {
            palKetteisyaCd = ketteiSya.getPalketsyacd();
        }

        HT_ImusateiRireki imusateiRireki = uiBean.getSyoriCTL().createImusateiRireki();

        imusateiRireki.setRenno(renNo);
        imusateiRireki.setSyoriYmd(sysDate);
        imusateiRireki.setSateiketsyorinmkbn(sateiKetSyorinmKbn);
        imusateiRireki.setImusateikekkakbn(uiBean.getImusateikekkakbn());
        imusateiRireki.setKetsyacd(baseUserInfo.getUserId());
        imusateiRireki.setPalketsyacd(palKetteisyaCd);
        imusateiRireki.setKetkekkacd(C_Ketkekkacd.BLNK);
        imusateiRireki.setKetriyuucd1(C_Ketriyuucd.BLNK);
        imusateiRireki.setKetriyuucd2(C_Ketriyuucd.BLNK);
        imusateiRireki.setKetriyuucd3(C_Ketriyuucd.BLNK);
        imusateiRireki.setKetriyuucd4(C_Ketriyuucd.BLNK);
        imusateiRireki.setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn.BLNK);
        imusateiRireki.setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn.BLNK);
        imusateiRireki.setSntkinfosakuseiyhkbn(C_SntkinfosakuseiyhKbn.SAKUSEIYOU);
        imusateiRireki.setImusateicomment(
            EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getImusateiiraicomment()));
        imusateiRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        imusateiRireki.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(imusateiRireki);
    }

    private void addMosTenkenrrk() {

        int renNo  = 1;

        HT_MostenkenRireki mostenkenRirekiMaxRenno = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(uiBean.getMosno());

        if (mostenkenRirekiMaxRenno != null) {
            renNo = mostenkenRirekiMaxRenno.getRenno() + 1;
        }

        C_SateiketsyorinmKbn sateiketSyorinmKbn = null;

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiketSyorinmKbn = C_SateiketsyorinmKbn.TORIKESI;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiketSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_1;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiketSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_2A;
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
            sateiketSyorinmKbn = C_SateiketsyorinmKbn.KNKSATEI_2B;
        }

        String palKetteisyaCd = "";

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        if (ketteiSya != null) {
            palKetteisyaCd = ketteiSya.getPalketsyacd();
        }

        HT_MostenkenRireki mostenkenRireki = uiBean.getSyoriCTL().createMostenkenRireki();

        mostenkenRireki.setRenno(renNo);
        mostenkenRireki.setSyoriYmd(sysDate);
        mostenkenRireki.setSateiketsyorinmkbn(sateiketSyorinmKbn);
        mostenkenRireki.setMostenkenkekkakbn(uiBean.getMostenkenkekkakbn());
        mostenkenRireki.setKetsyacd(baseUserInfo.getUserId());
        mostenkenRireki.setPalketsyacd(palKetteisyaCd);
        mostenkenRireki.setMostenkencomment(
            EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getMostenkeniraicomment()));
        mostenkenRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        mostenkenRireki.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(mostenkenRireki);
    }

    private void addDakuhiKettei() {

        int renno = 1;
        C_DakuhiktbunruiKbn dakuhiKtBunruiKbn = null;
        C_Ketriyuucd ketRiyuuCd1 = null;
        C_Ketriyuucd ketRiyuuCd2 = null;
        C_Ketriyuucd ketRiyuuCd3 = null;
        C_Ketriyuucd ketRiyuuCd4 = null;
        String palKetteisyaCd    = "";
        C_MrRiyuucdKbn mrRiyuucdKbn = null;
        C_TorikesisyousairiyuuCd trksSyousaiRiyuuCd = null;

        Integer rennoMax = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno(uiBean.getMosno());

        if (rennoMax != null) {
            renno = rennoMax + 1;
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            dakuhiKtBunruiKbn = C_DakuhiktbunruiKbn.SYOUMETU;
        }
        else {

            dakuhiKtBunruiKbn = C_DakuhiktbunruiKbn.DAKUHIKETTEI;
        }


        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            ketRiyuuCd1 = C_Ketriyuucd.ZENINDOUTOKUHUAN;
        }
        else {
            if (!BizUtil.isBlank(uiBean.getKetriyuucd1gamen())) {
                ketRiyuuCd1 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd1gamen());
            }
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {
        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            ketRiyuuCd2 = C_Ketriyuucd.SISYAKETTEIKEKKA;
        }
        else {
            if (!BizUtil.isBlank(uiBean.getKetriyuucd2gamen())) {
                ketRiyuuCd2 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd2gamen());
            }
        }

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            if (!BizUtil.isBlank(uiBean.getKetriyuucd3gamen())) {
                ketRiyuuCd3 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd3gamen());
            }

        }

        if (!C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            if (!BizUtil.isBlank(uiBean.getKetriyuucd4gamen())) {
                ketRiyuuCd4 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd4gamen());
            }

        }

        if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            palKetteisyaCd = ISkCommonKoumoku.PALKETSYACD_SISYAKETSYA;
        }
        else {
            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

            if (ketteiSya != null) {
                palKetteisyaCd = ketteiSya.getPalketsyacd();
            }
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

        }
        else if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(uiBean.getKetkekkacd())) {

            mrRiyuucdKbn = C_MrRiyuucdKbn.HANSYA;
        }
        else {

            mrRiyuucdKbn = uiBean.getMrriyuucdkbn();
        }

        if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            trksSyousaiRiyuuCd = uiBean.getTorikesisyousairiyuucd();
        }

        HT_DakuhiKettei dakuhiKettei = uiBean.getSyoriCTL().createDakuhiKettei();

        dakuhiKettei.setDakuhiktrenno(renno);
        dakuhiKettei.setKetymd(sysDate);
        dakuhiKettei.setDakuhiktbunruikbn(dakuhiKtBunruiKbn);
        dakuhiKettei.setKetkekkacd(uiBean.getKetkekkacd());
        dakuhiKettei.setKetriyuucd1(ketRiyuuCd1);
        dakuhiKettei.setKetriyuucd2(ketRiyuuCd2);
        dakuhiKettei.setKetriyuucd3(ketRiyuuCd3);
        dakuhiKettei.setKetriyuucd4(ketRiyuuCd4);
        dakuhiKettei.setKetsyacd(baseUserInfo.getUserId());
        dakuhiKettei.setPalketsyacd(palKetteisyaCd);
        dakuhiKettei.setMrriyuucdkbn(mrRiyuucdKbn);
        dakuhiKettei.setTorikesisyousairiyuucd(trksSyousaiRiyuuCd);
        dakuhiKettei.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        dakuhiKettei.setGyoumuKousinTime(sysDateTime);

        BizPropertyInitializer.initialize(dakuhiKettei);
    }

    private void setUiBean(HT_SyoriCTL pSyoriCTL) {

        uiBean.setMosnrkumu(pSyoriCTL.getMosnrkumu());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkumu())) {

            uiBean.setKkthjykbn(C_KkthjyKbn.HJYNRK_ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {

            uiBean.setKkthjykbn(C_KkthjyKbn.KKTNRK_ARI);
        }
        else {
            uiBean.setKkthjykbn(C_KkthjyKbn.NONE);
        }

        uiBean.setNyknnrkumu(pSyoriCTL.getNyknnrkumu());
        uiBean.setMostenkenjoukbn(pSyoriCTL.getMostenkenjoukbn());

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())) {
            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())) {
            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {
            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else {
            uiBean.setHubiumu(C_UmuKbn.NONE);
        }

        uiBean.setKykkakjkkbn(pSyoriCTL.getKykkakjkkbn());
        uiBean.setLincjkkbn(pSyoriCTL.getLincjkkbn());
        uiBean.setLinckknnjkkbn(pSyoriCTL.getLinckknnjkkbn());
        uiBean.setKnkysateijyoukbn(pSyoriCTL.getKnkysateijyoukbn());
        uiBean.setImusateijyoukbn(pSyoriCTL.getImusateijyoukbn());
        uiBean.setKetteikbn(pSyoriCTL.getKetteikbn());
        uiBean.setJimusrhkbn(pSyoriCTL.getJimusrhkbn());
        uiBean.setSeiritukbn(pSyoriCTL.getSeiritukbn());
        uiBean.setMostenken1jiyhkbn(pSyoriCTL.getMostenken1jiyhkbn());
        uiBean.setMostenken2jiyhkbn(pSyoriCTL.getMostenken2jiyhkbn());
        uiBean.setLincgthtkekkbn(pSyoriCTL.getLincgthtkekkbn());
        uiBean.setKnkysatei1jiyhkbn(pSyoriCTL.getKnkysatei1jiyhkbn());
        uiBean.setKnkysatei2jiyhkbn(pSyoriCTL.getKnkysatei2jiyhkbn());
        uiBean.setImusateikaniyhkbn(pSyoriCTL.getImusateikaniyhkbn());
        uiBean.setKnksateisjnaiyou(EditGamenString.editMessegeStringRule(
            pSyoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.KNKSATEI)));
    }

    private void addConversationMessage() {
        List<String> gmwarningIdLst = uiBean.getGmwarningIdLst();
        List<String> gmwarningLst = uiBean.getGmwarningLst();

        for (int index = 0; index < gmwarningIdLst.size(); index++) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(gmwarningIdLst.get(index)),
                gmwarningLst.get(index));
        }
    }

    private void doJikouteikanri() {

        String kouteiLockKey = getKouteiLockKey();

        String tnsKetsyaCd = "";

        if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getKnksateisateikekka())) {

            tnsKetsyaCd = baseUserInfo.getUserId();
        } else {

            tnsKetsyaCd = uiBean.getKnktnsketsyacd();
        }

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(uiBean.getKnksateisateikekka());
        skProcessForwardInBean.setSyoriComment(uiBean.getKnksateicommentgamen());
        skProcessForwardInBean.setMostenkenkekkaKbn(uiBean.getMostenkenkekkakbn());
        skProcessForwardInBean.setKnksateikekkaKbn(uiBean.getKnksateisateikekka());
        skProcessForwardInBean.setKnktnsketsyaCd(tnsKetsyaCd);
        skProcessForwardInBean.setImusateikekkaKbn(uiBean.getImusateikekkakbn());
        skProcessForwardInBean.setHubihassintnsKbn(uiBean.getHubihassintnskbn());

        if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode())  ||
            C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue().equals(uiBean.getKinouMode().getKinouMode()) ||
            C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            SkProcessForwardKankyouSatei skProcessForwardKankyouSatei =
                SWAKInjector.getInstance(SkProcessForwardKankyouSatei.class);

            skProcessForwardKankyouSatei.exec(skProcessForwardInBean);

        }
        else if (C_SkkinouModeIdKbn.MOSTORIKESI.getValue().equals(uiBean.getKinouMode().getKinouMode())) {

            SkProcessForwardMousikomiTorikesi skProcessForwardMousikomiTorikesi =
                SWAKInjector.getInstance(SkProcessForwardMousikomiTorikesi.class);

            skProcessForwardMousikomiTorikesi.exec(skProcessForwardInBean);
        }
    }

    private BizCurrency getHutuuSbs(HT_SyoriCTL pSyoriCTL) {

        mosnaiCheckParam.setDataSyoriControl(pSyoriCTL);
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());

        SetHutuuSibouS setHutuuSibouS = SWAKInjector.getInstance(SetHutuuSibouS.class);
        BizCurrency hutuuSibouS = setHutuuSibouS.exec(mosnaiCheckParam);

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
        BizCurrency hutuuSibouSKansan = getKiteiCheckYenkansangk.exec(pSyoriCTL.getMosKihon().getMosymd(),
            hutuuSibouS, pSyoriCTL.getMosKihon().getKyktuukasyu());

        return hutuuSibouSKansan;
    }

    private boolean chkKbnValue(String pKetRiyuuCd) {

        DisplayItem<C_Ketriyuucd>[] ketteiriyuuLst =
            Classification.getDisplayItems(C_Ketriyuucd.class, C_Ketriyuucd.PATTERN_ITIRAN);

        boolean sonzaiFlg = false;

        for (int index = 0; index < ketteiriyuuLst.length; index++) {
            if (ketteiriyuuLst[index].getClassification().getValue().equals(pKetRiyuuCd)) {
                sonzaiFlg = true;
                break;
            }
        }

        return sonzaiFlg;
    }

    private boolean hanteiKetRiyuuNrKahi(C_Ketkekkacd pKetkekkacd, String pKetriyuucd) {

        if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(pKetkekkacd)) {

            return true;
        }

        if (C_Ketkekkacd.MUJYOUKEN.eq(pKetkekkacd)) {
            if (!BizUtil.isBlank(pKetriyuucd)) {
                return false;
            }

            return true;
        }
        else if (C_Ketkekkacd.COOLINGOFF.eq(pKetkekkacd) ||
            C_Ketkekkacd.MOS_TORIKESI.eq(pKetkekkacd) ||
            C_Ketkekkacd.YUUKOUKKNKKA.eq(pKetkekkacd)) {

            return true;
        }
        else {
            if (C_Ketriyuucd.DOUGAKUTOKUNIN.getValue().equals(pKetriyuucd) ||
                C_Ketriyuucd.SISYAHOUKOKU.getValue().equals(pKetriyuucd)) {
                return false;
            }

            return true;
        }
    }

    private boolean hanteiKetRiyuuHissnr(C_Ketkekkacd pKetkekkacd, String pKetriyuucd1,
        String pKetriyuucd2, String pKetriyuucd3, String pKetriyuucd4) {

        if (C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue().equals(uiBean.getKinouMode().getKinouMode()) &&
            C_Ketkekkacd.MIAWASE.eq(pKetkekkacd)) {

            return true;
        }

        ArrayList<String> ketteiRiyuuCdList = new ArrayList<String>();

        ketteiRiyuuCdList.add(C_Ketriyuucd.HHKN_DOUTOKUHUAN.getValue());
        ketteiRiyuuCdList.add(C_Ketriyuucd.KYK_DOUTOKUHUAN.getValue());
        ketteiRiyuuCdList.add(C_Ketriyuucd.ZENINDOUTOKUHUAN.getValue());

        if (C_Ketkekkacd.MIAWASE.eq(pKetkekkacd)) {
            if (ketteiRiyuuCdList.contains(pKetriyuucd1) ||
                ketteiRiyuuCdList.contains(pKetriyuucd2) ||
                ketteiRiyuuCdList.contains(pKetriyuucd3) ||
                ketteiRiyuuCdList.contains(pKetriyuucd4)) {

                return true;
            }
            return false;
        }
        return true;
    }

    private void editTasyaKanyuuJoukyou () {
        continueLockProcess();

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        String lincjyusintrrenno = skKankyouSateiDao.getHT_SkLincSyoukaikekkaMaxLincJyusinTrRenno(uiBean.getMosno());

        uiBean.setLincjyusintrrenno(lincjyusintrrenno);

        List<HT_SkLincSyoukaikekka> skLincSyoukaikekkaLst = syoriCTL.getSkLincSyoukaikekkas();

        skLincSyoukaikekkaLst = new ArrayList<HT_SkLincSyoukaikekka>(
            Collections2.filter(skLincSyoukaikekkaLst, new FilterSkLincSyoukaikekka(lincjyusintrrenno)));

        SkLincSyoukaikekkaSortComparator skLincSyoukaikekkaSortComparator = SWAKInjector.getInstance(SkLincSyoukaikekkaSortComparator.class);

        Ordering<HT_SkLincSyoukaikekka> ikktnyknInfoOrdering = Ordering.from(skLincSyoukaikekkaSortComparator);

        skLincSyoukaikekkaLst = ikktnyknInfoOrdering.sortedCopy(skLincSyoukaikekkaLst);

        HT_SkLincTourokuInfo skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();
        BizDate tousyaTrkymd = skLincTourokuInfo.getTrkmousideymd();

        BizCurrency seitoukihonsyen = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
        BizCurrency tasyatsn = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
        BizCurrency tousyatsn = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
        BizCurrency tousyatsnfundnotinc = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);
        BizCurrency toutasyatsnkessaitgk = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);
        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(uiBean.getMosno());
        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);
        bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);
        bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN);
        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno(uiBean.getMosno());
        bzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.getSysDate());
        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.BLNK);
        bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);
        bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno(uiBean.getMosno());
        bzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(mosKihon.getMosymd());
        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
        bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSykKekkaBean = bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        HT_MosSyouhn mosSyouhn = mosSyouhnLst.get(0);

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

        seitoukihonsyen = getKiteiCheckYenkansangk.exec(mosKihon.getMosymd(), mosSyouhn.getSeitoukihons(), mosKihon.getKyktuukasyu());

        if (!C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSykKekkaBean.getMqsyorikekkakbn())) {
            tousyatsn = bzSakuinTsnSykKekkaBean.getTsnsibous().add(seitoukihonsyen);
            tousyatsnfundnotinc = bzSakuinTsnSykKekkaBean.getTsnketsibous().add(seitoukihonsyen);
        } else {
            tousyatsn = seitoukihonsyen;
            tousyatsnfundnotinc = seitoukihonsyen;
        }

        int gamenRenno = 0;
        List<TasyaKanyuuJoukyouDataSourceBean> tasyaKanyuuJoukyouDataLst = Lists.newArrayList();

        for (HT_SkLincSyoukaikekka skLincSyoukaikekka : skLincSyoukaikekkaLst) {
            TasyaKanyuuJoukyouDataSourceBean tasyaKanyuuJoukyouData =
                SWAKInjector.getInstance(TasyaKanyuuJoukyouDataSourceBean.class);

            tasyaKanyuuJoukyouData.setTasyaout(false);
            tasyaKanyuuJoukyouData.setTasyano(BizNumber.valueOf(gamenRenno + 1));
            tasyaKanyuuJoukyouData.setDbRenno(skLincSyoukaikekka.getRenno());
            tasyaKanyuuJoukyouData.setTasyaankenjyoutai(skLincSyoukaikekka.getAnkenjyoutai());
            tasyaKanyuuJoukyouData.setTasyakyksyubetu(skLincSyoukaikekka.getKyksyubetu());
            tasyaKanyuuJoukyouData.setTasyakaisyacd(skLincSyoukaikekka.getLincsousinmotokaisya());
            tasyaKanyuuJoukyouData.setTasyakykkbn(skLincSyoukaikekka.getKykkbn());
            tasyaKanyuuJoukyouData.setTasyakyknmkn(ConvertUtil.toHanAll(skLincSyoukaikekka.getKyknmlinckn(), 0, 0));
            tasyaKanyuuJoukyouData.setTasyakyknmkj(skLincSyoukaikekka.getKyknmlinckj());
            tasyaKanyuuJoukyouData.setTasyahhknnmkn(ConvertUtil.toHanAll(skLincSyoukaikekka.getHhknnmlinckn(), 0, 0));
            tasyaKanyuuJoukyouData.setTasyahhknnmkj(skLincSyoukaikekka.getHhknnmlinckj());
            tasyaKanyuuJoukyouData.setTasyakykymd(skLincSyoukaikekka.getKeiyakuymd());
            tasyaKanyuuJoukyouData.setTasyatrkymd(skLincSyoukaikekka.getTrkmousideymd());
            tasyaKanyuuJoukyouData.setTasyasibusmantyen(editHokenkngk(skLincSyoukaikekka.getHutuusb(),10000));
            tasyaKanyuuJoukyouData.setTasyasaigaismanyen(editHokenkngk(skLincSyoukaikekka.getSgsbksns(),10000));
            tasyaKanyuuJoukyouData.setTasyasaigaisenyen(editHokenkngk(skLincSyoukaikekka.getSgnyung(),1000));
            tasyaKanyuuJoukyouData.setTasyasippeisenyen(editHokenkngk(skLincSyoukaikekka.getSipnyung(),1000));
            tasyaKanyuuJoukyouData.setTasyaseijinbyousenyen(editHokenkngk(skLincSyoukaikekka.getSjnyung(),1000));
            tasyaKanyuuJoukyouData.setTasyasonotasenyen(editHokenkngk(skLincSyoukaikekka.getSonotanyuinng(),1000));
            tasyaKanyuuJoukyouData.setTasyakanyuusyano(
                Strings.padStart(String.valueOf(skLincSyoukaikekka.getKanyuusyano()), 12, '0'));
            tasyaKanyuuJoukyouData.setTasyahknkykkanrino(skLincSyoukaikekka.getLinckykkanrino());

            BM_LincKaisyacd lincKaisyacd = bizDomManager.getLincKaisyacd(skLincSyoukaikekka.getLincsousinmotokaisya());
            if (lincKaisyacd != null) {
                tasyaKanyuuJoukyouData.setTasyakaisyanm(lincKaisyacd.getLinckaisyanm());
            }

            BizDate kijyunymd = null;
            if (skLincSyoukaikekka.getKeiyakuymd() != null &&
                BizDateUtil.compareYmd(skLincSyoukaikekka.getKeiyakuymd(),
                    skLincSyoukaikekka.getTrkmousideymd()) != BizDateUtil.COMPARE_LESSER) {
                kijyunymd = skLincSyoukaikekka.getKeiyakuymd();
            }
            else {
                kijyunymd = skLincSyoukaikekka.getTrkmousideymd();
            }

            BizDate tousyaTrkymdAndm = tousyaTrkymd.addMonths(-6);
            BizDate tousyaTrkymdAndy = tousyaTrkymd.addYears(-1);

            if (!tousyaTrkymdAndm.isRekijyou()) {
                tousyaTrkymdAndm = tousyaTrkymdAndm.getBizDateYM().getLastDay();
            }
            if (!tousyaTrkymdAndy.isRekijyou()) {
                tousyaTrkymdAndy = tousyaTrkymdAndy.getBizDateYM().getLastDay();
            }

            if (BizDateUtil.compareYmd(kijyunymd, tousyaTrkymdAndm) != BizDateUtil.COMPARE_LESSER &&
                BizDateUtil.compareYmd(kijyunymd, tousyaTrkymd) != BizDateUtil.COMPARE_GREATER) {
                tasyaKanyuuJoukyouData.setTasyasyuutyuu("●");
            }
            else if (BizDateUtil.compareYmd(kijyunymd, tousyaTrkymd) == BizDateUtil.COMPARE_GREATER) {
                tasyaKanyuuJoukyouData.setTasyasyuutyuu("○");
            }
            else if (BizDateUtil.compareYmd(kijyunymd, tousyaTrkymdAndm) == BizDateUtil.COMPARE_LESSER &&
                BizDateUtil.compareYmd(kijyunymd, tousyaTrkymdAndy) != BizDateUtil.COMPARE_LESSER) {
                tasyaKanyuuJoukyouData.setTasyasyuutyuu("△");
            }
            else {
                tasyaKanyuuJoukyouData.setTasyasyuutyuu("");
            }

            tasyaKanyuuJoukyouDataLst.add(tasyaKanyuuJoukyouData);

            tasyatsn = tasyatsn.add(skLincSyoukaikekka.getHutuusb());

            if (C_KykSyubetuKbn.HOUJIN.eq(tasyaKanyuuJoukyouData.getTasyakyksyubetu()) ||
                C_KykSyubetuKbn.BETUHOUJIN.eq(tasyaKanyuuJoukyouData.getTasyakyksyubetu()) ||
                C_KykSyubetuKbn.TAISYOUGAI.eq(tasyaKanyuuJoukyouData.getTasyakyksyubetu()) ||
                C_AnkenJyoutaiKbn.SYOUMETU.eq(tasyaKanyuuJoukyouData.getTasyaankenjyoutai()) ||
                C_AnkenJyoutaiKbn.BETUJIN.eq(tasyaKanyuuJoukyouData.getTasyaankenjyoutai())) {

                toutasyatsnkessaitgk = toutasyatsnkessaitgk.add(BizCurrency.valueOf(
                    new BigDecimal(tasyaKanyuuJoukyouData.getTasyasibusmantyen().toString()), BizCurrencyTypes.YEN));
            }

            gamenRenno = gamenRenno + 1 ;
        }

        uiBean.setTasyaKanyuuJoukyou(tasyaKanyuuJoukyouDataLst);

        uiBean.setTasyatsn(editHokenkngk(tasyatsn,10000));
        uiBean.setTousyatsn(editHokenkngk(tousyatsn,10000));
        uiBean.setTousyatsnfundnotinc(editHokenkngk(tousyatsnfundnotinc,10000));
        uiBean.setToutasyatsn(editHokenkngk(tasyatsn.add(tousyatsn),10000));
        uiBean.setToutasyatsnfundnotinc(editHokenkngk(tasyatsn.add(tousyatsnfundnotinc),10000));
        uiBean.setToutasyatsnkessaitgk(uiBean.getTasyatsn().add(uiBean.getTousyatsn()).subtract(BizNumber.valueOf(toutasyatsnkessaitgk)));

        uiBean.setNensyuukbn(mosKihon.getHhknnensyuukbn());

        if (C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSykKekkaBean.getMqsyorikekkakbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.WIA1004);
        }
        if (C_PalSyoukaiJissiumuKbn.NONE.eq(bzSakuinTsnSykKekkaBean.getPalsyoukaijissiumukbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.WIA1005);
        }
        if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSykKekkaBean.getSakuininfosyoukaierrkbn())) {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.WIA1006);
        }

        uiBean.setHaneibtnOnClickFlg(false);
        uiBean.setTyouhyoukeyLst(null);
    }

    private BizNumber editHokenkngk (BizCurrency pMotoKingaku,int pNumber) {

        BizCurrency kansanKingaku = pMotoKingaku.divide(pNumber,0, RoundingMode.DOWN);

        return BizNumber.valueOf(kansanKingaku);
    }
}
