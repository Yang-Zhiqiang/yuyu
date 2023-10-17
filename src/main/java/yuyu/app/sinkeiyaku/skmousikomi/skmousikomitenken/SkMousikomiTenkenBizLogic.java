package yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken;

import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken.GenSkMousikomiTenkenConstants.*;
import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken.SkMousikomiTenkenConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.HubiList1DataSourceBean;
import yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.HubiList2DataSourceBean;
import yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku.SkHubiRenkeiInfo;
import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.koutei.BzTaskStart;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.biz.koutei.GetSyoruittykymd;
import yuyu.common.biz.koutei.SetKouteiInfo;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMousikomiTenken;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.EditGamenString;
import yuyu.common.sinkeiyaku.skcommon.EditPdfHubiTyouhyou;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.GetMsgDoujikaiyakusyono;
import yuyu.common.sinkeiyaku.skcommon.GetSkTtdkTyuui;
import yuyu.common.sinkeiyaku.skcommon.HanteiDoujiMos;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcakakkekkaKbn;
import yuyu.def.classification.C_HbtyhyoutKbn;
import yuyu.def.classification.C_HubiSyoriKbn;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkhjnKbn;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_UktkakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.infr.report.OutputReport;

import com.google.common.collect.Lists;

/**
 * 申込点検 のビジネスロジックです
 */
public class SkMousikomiTenkenBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkMousikomiTenkenUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private SkHubiRenkeiInfo skHubiRenkeiInfo;

    @Inject
    private EditPdfHubiTyouhyou editPdfHubiTyouhyou;

    @Inject
    private OutputReport outputReport;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void tenkenBtnBL() {
        BizPropertyInitializer.initialize(uiBean);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        uiBean.setBzWorkflowInfo(bzWorkflowInfo);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCTL == null) {

            throw new BizLogicException(MessageId.EBA0090);

        }

        uiBean.setSyoriCTL(syoriCTL);

        if (C_MostenkenjyouKbn.TENKENMATI_1.eq(syoriCTL.getMostenkenjoukbn())) {

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString());

        }
        else if (C_MostenkenjyouKbn.TENKENMATI_2.eq(syoriCTL.getMostenkenjoukbn())) {

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOSTENKEN_2JI.toString());

        }
        else if (C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(syoriCTL.getMostenkenjoukbn())) {

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOSTENKEN_HUBI.toString());
        }

        C_Kouteikanristatus[] kouteikanristatuss = new C_Kouteikanristatus[1];
        kouteikanristatuss[0] = C_Kouteikanristatus.SYORITYUU;

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = getProcessSummary(
            ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
            kouteikanristatuss,
            "",
            uiBean.getMosno());

        if (!ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI.equals(bzGetProcessSummaryOutBean.getNowNodoId())
            && !ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI.equals(bzGetProcessSummaryOutBean.getNowNodoId())
            && !ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI.equals(bzGetProcessSummaryOutBean.getNowNodoId())) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

        uiBean.getBzWorkflowInfo().setTaskId(bzGetProcessSummaryOutBean.getNowNodoId());

        String kinouModeId = kinouMode.getKinouMode();

        BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            baseUserInfo.getUserId());

        if (wariateHukaInfo != null) {

            throw new BizLogicException(MessageId.EHA0304);

        }

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        boolean kengenWithBoolean = checkKinouModeKengen.checkKengenByKinouModeIdWithBoolean(kinouModeId);

        if(!kengenWithBoolean){

            throw new BizLogicException(MessageId.EHA1073, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        if (ketteiSya == null
            || (C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(kinouModeId)
                && !C_MostenkenRankKbn.ITIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.NIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn()))
                || (C_SkkinouModeIdKbn.MOSTENKEN_2JI.toString().equals(kinouModeId)
                    && !C_MostenkenRankKbn.NIJI.eq(ketteiSya.getMostenkenrankkbn())
                    && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn()))
                    || (C_SkkinouModeIdKbn.MOSTENKEN_HUBI.toString().equals(kinouModeId)
                        && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn()))) {

            throw new BizLogicException(MessageId.EHA1013, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));

        }

        if (!C_SeirituKbn.NONE.eq(uiBean.getSyoriCTL().getSeiritukbn())) {

            throw new BizLogicException(MessageId.EBA0031, uiBean.getSyoriCTL().getSeiritukbn().getContent());
        }

        if (!C_KetteiKbn.NONE.eq(uiBean.getSyoriCTL().getKetteikbn())
            && !C_KetteiKbn.KETTEI_MATI.eq(uiBean.getSyoriCTL().getKetteikbn())) {

            throw new BizLogicException(MessageId.EBA0031, uiBean.getSyoriCTL().getKetteikbn().getContent());
        }

        if (C_UmuKbn.NONE.eq(uiBean.getSyoriCTL().getMosnrkumu())) {

            throw new BizLogicException(MessageId.EHA0027);
        }

        if (!C_MostenkenjyouKbn.TENKENMATI_1.eq(uiBean.getSyoriCTL().getMostenkenjoukbn())
            && !C_MostenkenjyouKbn.TENKENMATI_2.eq(uiBean.getSyoriCTL().getMostenkenjoukbn())
            && !C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(uiBean.getSyoriCTL().getMostenkenjoukbn())) {

            throw new BizLogicException(MessageId.EHA1012);
        }

        bzGetProcessSummaryOutBean = getProcessSummary(
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
            kouteikanristatuss,
            "",
            uiBean.getMosno());

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

        lockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        waninguSyori();

        setGamenSyuturyoku();

        setGamenNyuuryoku();

        setHubiTourokuInfo();

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        String kouteiLockKey = getKouteiLockKey();

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

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));
    }

    @Transactional
    void iwfOpenBL() {
        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        checkKinouModeKengen.checkWorklistKinouModeKengen();

        BizPropertyInitializer.initialize(uiBean);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        uiBean.setBzWorkflowInfo(bzWorkflowInfo);

        C_Kouteikanristatus[] kouteikanristatuss = new C_Kouteikanristatus[1];
        kouteikanristatuss[0] = C_Kouteikanristatus.SYORITYUU;

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = getProcessSummary(
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            kouteikanristatuss,
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            "");

        uiBean.setMosno(bzGetProcessSummaryOutBean.getMosNo());

        if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString());

        }
        else if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOSTENKEN_2JI.toString());

        }
        else if (ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            kinouMode.setKinouMode(C_SkkinouModeIdKbn.MOSTENKEN_HUBI.toString());
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        String kinouModeId = kinouMode.getKinouMode();

        if (ketteiSya == null
            || (C_SkkinouModeIdKbn.MOSTENKEN_1JI.toString().equals(kinouModeId)
                && !C_MostenkenRankKbn.ITIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.NIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn()))
                || (C_SkkinouModeIdKbn.MOSTENKEN_2JI.toString().equals(kinouModeId)
                    && !C_MostenkenRankKbn.NIJI.eq(ketteiSya.getMostenkenrankkbn())
                    && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn()))
                    || (C_SkkinouModeIdKbn.MOSTENKEN_HUBI.toString().equals(kinouModeId)
                        && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn()))) {

            throw new BizLogicException(MessageId.EHA1013, C_SkkinouModeIdKbn.getContentByValue(kinouModeId));

        }

        bzGetProcessSummaryOutBean = getProcessSummary(
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
            kouteikanristatuss,
            "",
            uiBean.getMosno());

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBean.getKouteiKanriId());

        lockProcess(bzGetProcessSummaryOutBean.getKouteiKanriId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        uiBean.setSyoriCTL(syoriCTL);

        waninguSyori();

        setGamenSyuturyoku();

        setGamenNyuuryoku();

        setHubiTourokuInfo();

        BzTaskStart bzTaskStart = SWAKInjector.getInstance(BzTaskStart.class);

        String kouteiLockKey = getKouteiLockKey();

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

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL));
    }

    void closeBtnBL() {

        unlockProcess();

        objStorageManager.remove(uiBean.getUniqueId());
    }

    void printHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {

        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    String modoruBtnBysyoukaiBL() {
        String rtnUrl = null;

        unlockProcess();

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            rtnUrl = FORWARDNAME_BACKTOWORKLIST;
        }
        else {

            rtnUrl = FORWARDNAME_INIT;
        }

        return rtnUrl;
    }

    void pushKakuninBL() {

        continueLockProcess();

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())
            && C_TkhjnKbn.BLNK.eq(uiBean.getTkhjnkbn())) {
            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_KAKUNINJIKOU_TKHJNKBN.getErrorResourceKey()));
        }

        if (uiBean.getSyoriCTL().getMosKihon().getSbuktnin() <= 4
            && C_UktkakKbn.SUMI.eq(uiBean.getUktkakkbn())) {
            throw new BizLogicException(MessageId.EHF1016);
        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())
            && uiBean.getSyoriCTL().getMosKihon().getSbuktnin() >= 5
            && C_UktkakKbn.BLNK.eq(uiBean.getUktkakkbn())) {
            throw new BizLogicException(MessageId.EHF1017);
        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())
            && C_KouseiinkykKbn.BLNK.eq(uiBean.getKouseiinkykkbn())) {
            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_KOUSEIINKYKINPUT_KOUSEIINKYKKBN.getErrorResourceKey()));
        }

        if (!C_KouseiinkykKbn.BLNK.eq(uiBean.getKouseiinkykkbn())
            && !C_KouseiinkykKbn.GAITOUNASI.eq(uiBean.getKouseiinkykkbn())
            && (C_BlnktkumuKbn.BLNK.eq(uiBean.getKouseiinkyktkjkumukbn())
                || uiBean.getKouseiinkyktkjkumukbn() == null)) {

            throw new BizLogicException(MessageId.EHA1021,
                MessageUtil.getMessage(DDID_KOUSEIINKYKINPUT_KOUSEIINKYKKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KOUSEIINKYKINPUT_KOUSEIINKYKTKJKUMUKBN.getErrorResourceKey()));

        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())
            && C_KoukankykKbn.BLNK.eq(uiBean.getKoukankykkbn())) {
            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKKBN.getErrorResourceKey()));
        }

        if (!C_KoukankykKbn.BLNK.eq(uiBean.getKoukankykkbn())
            && !C_KoukankykKbn.GAITOUNASI.eq(uiBean.getKoukankykkbn())
            && (C_BlnktkumuKbn.BLNK.eq(uiBean.getKoukankyktkjkumukbn())
                || uiBean.getKoukankyktkjkumukbn() == null)) {

            throw new BizLogicException(MessageId.EHA1021,
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKTKJKUMUKBN.getErrorResourceKey()));

        }

        if (!C_KoukankykKbn.BLNK.eq(uiBean.getKoukankykkbn())
            && !C_KoukankykKbn.GAITOUNASI.eq(uiBean.getKoukankykkbn())
            && BizUtil.isBlank(uiBean.getKoukankykkinmusakinm())) {

            throw new BizLogicException(MessageId.EHA1021,
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKKINMUSAKINM.getErrorResourceKey()));

        }

        if (!C_KoukankykKbn.BLNK.eq(uiBean.getKoukankykkbn())
            && !C_KoukankykKbn.GAITOUNASI.eq(uiBean.getKoukankykkbn())
            && BizUtil.isBlank(uiBean.getKoukankyksyokumunaiyou())) {

            throw new BizLogicException(MessageId.EHA1021,
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKKBN.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_KOUKANKYKINPUT_KOUKANKYKSYOKUMUNAIYOU.getErrorResourceKey()));

        }

        if (C_SkkinouModeIdKbn.MOSTENKEN_2JI.getValue().equals(kinouMode.getKinouMode())
            && C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())
            && C_FatcakakkekkaKbn.BLNK.eq(uiBean.getFatcakakkekkakbn())) {

            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_KAKUNINJIKOU_FATCAKAKKEKKAKBN.getErrorResourceKey()));

        }

        if (C_SkkinouModeIdKbn.MOSTENKEN_2JI.getValue().equals(kinouMode.getKinouMode()) &&
            C_UmuKbn.ARI.eq(uiBean.getAeoiTaisyouUmu()) &&
            C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn()) &&
            C_AeoiKekkaKbn.BLNK.eq(uiBean.getAeoikekkakbn())) {

            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_KAKUNINJIKOU_AEOIKEKKAKBN.getErrorResourceKey()));

        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())) {

            int nenrei = 0;
            if (C_KykKbn.KEIHI_DOUITU.eq(uiBean.getSyoriCTL().getMosKihon().getKykkbn())) {

                nenrei = uiBean.getSyoriCTL().getMosKihon().getHhknnen();
            }
            else {

                nenrei = uiBean.getSyoriCTL().getMosKihon().getKyknen();
            }

            if (C_SkeijimuKbn.NIHONYUUBIN.eq(uiBean.getSyoriCTL().getSkeijimukbn()) &&
                nenrei >= KOUREISEIGENNENREI &&
                C_KoureisyaTaiouKbn.BLNK.eq(uiBean.getKoureitaioukbn())) {

                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KAKUNINJIKOU_KOUREITAIOUKBN.getErrorResourceKey()));
            }

            else if ((!C_SkeijimuKbn.NIHONYUUBIN.eq(uiBean.getSyoriCTL().getSkeijimukbn()) ||
                nenrei < KOUREISEIGENNENREI) &&
                !C_KoureisyaTaiouKbn.BLNK.eq(uiBean.getKoureitaioukbn())) {

                throw new BizLogicException(MessageId.EBC0012,
                    MessageUtil.getMessage(DDID_KAKUNINJIKOU_KOUREITAIOUKBN.getErrorResourceKey()));
            }
        }

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())
            && !BizUtil.isBlank(uiBean.getMostenkentnsketsyacd())) {

            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_MOUSIKOMITENKEN_MOSTENKENTNSKETSYACD.getErrorResourceKey()));

        }

        if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getMostenkenkekkakbn())
            && !BizUtil.isBlank(uiBean.getMostenkentnsketsyacd())) {

            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_MOUSIKOMITENKEN_MOSTENKENTNSKETSYACD.getErrorResourceKey()));

        }

        if ((C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())
            || C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())
            || C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn()))
            && BizUtil.isBlank(uiBean.getMostenkentnsketsyacd())) {

            throw new BizLogicException(MessageId.EHA0309);
        }

        if ((C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())
            || C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())
            || C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn()))
            && !ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(uiBean.getMostenkentnsketsyacd())) {

            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

            CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

            boolean isRtn = false;

            if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {

                isRtn = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    uiBean.getMostenkentnsketsyacd(),
                    kinou.getKinouId(),
                    C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue());

                if (!isRtn) {
                    throw new BizLogicException(MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_1JI.getContent());
                }

                isRtn = checkTaskKengen.exec(
                    uiBean.getMostenkentnsketsyacd(),
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                    ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI);

                if (!isRtn) {
                    throw new BizLogicException(MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_1JI.getContent());
                }

            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {
                isRtn = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    uiBean.getMostenkentnsketsyacd(),
                    kinou.getKinouId(),
                    C_SkkinouModeIdKbn.MOSTENKEN_2JI.getValue());

                if (!isRtn) {
                    throw new BizLogicException(MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_2JI.getContent());
                }

                isRtn = checkTaskKengen.exec(
                    uiBean.getMostenkentnsketsyacd(),
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                    ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI);

                if (!isRtn) {
                    throw new BizLogicException(MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_2JI.getContent());
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {
                isRtn = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    uiBean.getMostenkentnsketsyacd(),
                    kinou.getKinouId(),
                    C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getValue());

                if (!isRtn) {
                    throw new BizLogicException(MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getContent());
                }

                isRtn = checkTaskKengen.exec(
                    uiBean.getMostenkentnsketsyacd(),
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN,
                    ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI);

                if (!isRtn) {
                    throw new BizLogicException(MessageId.EHA0314,
                        C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getContent());
                }
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(uiBean.getMostenkentnsketsyacd());

            if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())
                && !C_MostenkenRankKbn.ITIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.NIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn())) {

                throw new BizLogicException(MessageId.EHA0314,
                    C_SkkinouModeIdKbn.MOSTENKEN_1JI.getContent());

            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())
                && !C_MostenkenRankKbn.NIJI.eq(ketteiSya.getMostenkenrankkbn())
                && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn())) {

                throw new BizLogicException(MessageId.EHA0314,
                    C_SkkinouModeIdKbn.MOSTENKEN_2JI.getContent());

            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())
                && !C_MostenkenRankKbn.HUBI.eq(ketteiSya.getMostenkenrankkbn())) {
                throw new BizLogicException(MessageId.EHA0314,
                    C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getContent());
            }

            if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {

                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                    uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI,
                    uiBean.getMostenkentnsketsyacd());

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {

                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                    uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI,
                    uiBean.getMostenkentnsketsyacd());

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {

                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
                    uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
                    uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI,
                    uiBean.getMostenkentnsketsyacd());

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
        }

        if (!C_SyorikekkaKbn.BLNK.eq(uiBean.getKnksateikekkakbn())
            && BizUtil.isBlank(uiBean.getKnksateiiraicomment())) {

            throw new BizLogicException(MessageId.EBC0045,
                KNKSATEIIRAICOMMENT);
        }

        if (C_SyorikekkaKbn.BLNK.eq(uiBean.getKnksateikekkakbn())
            && !BizUtil.isBlank(uiBean.getKnksateiiraicomment())) {

            throw new BizLogicException(MessageId.EBC0007,
                KNKSATEIIRAICOMMENT);

        }

        if (!C_SyorikekkaKbn.BLNK.eq(uiBean.getImusateikekkakbn())
            && BizUtil.isBlank(uiBean.getImusateiiraicomment())) {

            throw new BizLogicException(MessageId.EBC0045,
                IMUSATEIIRAICOMMENT);
        }

        if (C_SyorikekkaKbn.BLNK.eq(uiBean.getImusateikekkakbn())
            && !BizUtil.isBlank(uiBean.getImusateiiraicomment())) {

            throw new BizLogicException(MessageId.EBC0007,
                IMUSATEIIRAICOMMENT);

        }

        messageManager.removeConversationMessage(WORKLIST_GROUP_MESSAGE);
        messageManager.removeConversationMessage(GROUP_MESSAGE);

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1,
            MessageId.QAC0008,
            MessageUtil.getMessage(MessageId.QAC0008));
    }

    void modoruBtnBL() {

        continueLockProcess();

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            addConversationMessageId(uiBean.getWarningMessageIdList(),
                uiBean.getWarningMessageList(), WORKLIST_GROUP_MESSAGE);
        } else {
            addConversationMessageId(uiBean.getWarningMessageIdList(), uiBean.getWarningMessageList(), GROUP_MESSAGE);
        }

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

    }

    @Transactional
    void pushKakuteiBL() {

        continueLockProcess();

        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        String userId = baseUserInfo.getUserId();

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        syoriCTL.setMostenkenrrkumu(C_UmuKbn.ARI);

        syoriCTL.setUktkakkbn(uiBean.getUktkakkbn());

        syoriCTL.setTkhjnkbn(uiBean.getTkhjnkbn());

        syoriCTL.setKouseiinkykkbn(uiBean.getKouseiinkykkbn());

        syoriCTL.setKoukankykkbn(uiBean.getKoukankykkbn());

        syoriCTL.setFatcakakkekkakbn(uiBean.getFatcakakkekkakbn());

        syoriCTL.setAeoikekkakbn(uiBean.getAeoikekkakbn());

        syoriCTL.setTkhsyouryakuumukbn(uiBean.getTkhsyouryakuumukbn());

        syoriCTL.setGyoumuKousinsyaId(userId);

        syoriCTL.setGyoumuKousinTime(sysDateTimeMilli);

        if (uiBean.getTkhsyouryakuumukbn() == null) {

            syoriCTL.setTkhsyouryakuumukbn(C_UmuKbn.NONE);
        }

        if (C_SyorikekkaKbn.TENSOU_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {

            syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
        }
        else if (C_SyorikekkaKbn.TENSOU_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {

            syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_2);
        }
        else if (C_SyorikekkaKbn.TENSOU_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {

            syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_HUBI);
        }

        if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(uiBean.getKnksateikekkakbn())
            || C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(uiBean.getKnksateikekkakbn())
            || C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(uiBean.getKnksateikekkakbn())) {

            syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);

            if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(uiBean.getKnksateikekkakbn())) {

                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
            }
            else if (C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(uiBean.getKnksateikekkakbn())) {

                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2A);
            }
            else {

                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2B);
            }
        }

        if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn())
            || C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) {

            syoriCTL.setImusateirrkumu(C_UmuKbn.ARI);

            if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn())) {

                syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_UW);
            }
            else {

                syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_MD);
            }
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        mosKihon.setTsryhshrkykumukbn(uiBean.getTsryhshrkykumukbn());

        mosKihon.setSyosisyatodokeumukbn(uiBean.getSyosisyatodokeumukbn());

        mosKihon.setKakukisyouryakukbumukbn(uiBean.getKakukisyouryakukbumukbn());

        mosKihon.setSeiymdmosseitouumukbn(uiBean.getSeiymdmosseitouumukbn());

        mosKihon.setKouseiinkyktkjkumukbn(uiBean.getKouseiinkyktkjkumukbn());

        mosKihon.setKoukankykkinmusakinm(uiBean.getKoukankykkinmusakinm());

        mosKihon.setKoukankyksyokumunaiyou(uiBean.getKoukankyksyokumunaiyou());

        mosKihon.setKoukankyktkjkumukbn(uiBean.getKoukankyktkjkumukbn());

        mosKihon.setKoureitaioukbn(uiBean.getKoureitaioukbn());

        mosKihon.setGyoumuKousinsyaId(userId);

        mosKihon.setGyoumuKousinTime(sysDateTimeMilli);

        if (uiBean.getKouseiinkyktkjkumukbn() == null) {

            mosKihon.setKouseiinkyktkjkumukbn(C_BlnktkumuKbn.BLNK);
        }

        if (uiBean.getKoukankyktkjkumukbn() == null) {

            mosKihon.setKoukankyktkjkumukbn(C_BlnktkumuKbn.BLNK);
        }

        int renNo = 1;

        C_SateiketsyorinmKbn sateiketsyorinmKbn = null;

        HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(uiBean.getMosno());

        if (mostenkenRireki != null) {
            renNo = mostenkenRireki.getRenno() + 1;
        }

        mostenkenRireki = syoriCTL.createMostenkenRireki();

        if (C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue().equals(kinouMode.getKinouMode())) {

            sateiketsyorinmKbn = C_SateiketsyorinmKbn.MOSTENKEN_1;
        }
        else if (C_SkkinouModeIdKbn.MOSTENKEN_2JI.getValue().equals(kinouMode.getKinouMode())) {
            sateiketsyorinmKbn = C_SateiketsyorinmKbn.MOSTENKEN_2;
        }
        else if (C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getValue().equals(kinouMode.getKinouMode())) {
            sateiketsyorinmKbn = C_SateiketsyorinmKbn.MOSTENKEN_HUBI;

        }

        String tnsketsyacd = "";

        if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getMostenkenkekkakbn())) {

            tnsketsyacd = userId;
        }
        else {
            tnsketsyacd = uiBean.getMostenkentnsketsyacd();

        }

        String encode = EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getMostenkencommentgamen());

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(userId);

        mostenkenRireki.setRenno(renNo);

        mostenkenRireki.setSyoriYmd(sysDate);

        mostenkenRireki.setSateiketsyorinmkbn(sateiketsyorinmKbn);

        mostenkenRireki.setMostenkenkekkakbn(uiBean.getMostenkenkekkakbn());

        mostenkenRireki.setTnsketsyacd(tnsketsyacd);

        mostenkenRireki.setKetsyacd(userId);

        mostenkenRireki.setPalketsyacd(ketteiSya.getPalketsyacd());

        mostenkenRireki.setMostenkencomment(encode);

        mostenkenRireki.setGyoumuKousinsyaId(userId);

        mostenkenRireki.setGyoumuKousinTime(sysDateTimeMilli);

        BizPropertyInitializer.initialize(mostenkenRireki);

        if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(uiBean.getKnksateikekkakbn())
            || C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(uiBean.getKnksateikekkakbn())
            || C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(uiBean.getKnksateikekkakbn())) {

            renNo = 1;

            HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(uiBean.getMosno());

            if (knksateiRireki != null) {
                renNo = knksateiRireki.getRenno() + 1;
            }

            knksateiRireki = syoriCTL.createKnksateiRireki();

            encode = EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getKnksateiiraicomment());

            knksateiRireki.setRenno(renNo);

            knksateiRireki.setSyoriYmd(sysDate);

            knksateiRireki.setSateiketsyorinmkbn(sateiketsyorinmKbn);

            knksateiRireki.setKnksateikekkakbn(uiBean.getKnksateikekkakbn());

            knksateiRireki.setKetsyacd(userId);

            knksateiRireki.setPalketsyacd(ketteiSya.getPalketsyacd());

            knksateiRireki.setKnksateicomment(encode);

            knksateiRireki.setGyoumuKousinsyaId(userId);

            knksateiRireki.setGyoumuKousinTime(sysDateTimeMilli);

            BizPropertyInitializer.initialize(knksateiRireki);
        }

        if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(uiBean.getImusateikekkakbn())
            || C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) {

            renNo = 1;

            HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno(uiBean.getMosno());

            if (imusateiRireki != null) {
                renNo = imusateiRireki.getRenno() + 1;
            }

            imusateiRireki = syoriCTL.createImusateiRireki();

            encode = EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getImusateiiraicomment());

            imusateiRireki.setRenno(renNo);

            imusateiRireki.setSyoriYmd(sysDate);

            imusateiRireki.setSateiketsyorinmkbn(sateiketsyorinmKbn);

            imusateiRireki.setImusateikekkakbn(uiBean.getImusateikekkakbn());

            imusateiRireki.setKetsyacd(userId);

            imusateiRireki.setPalketsyacd(ketteiSya.getPalketsyacd());

            imusateiRireki.setImusateicomment(encode);

            imusateiRireki.setGyoumuKousinsyaId(userId);

            imusateiRireki.setGyoumuKousinTime(sysDateTimeMilli);

            BizPropertyInitializer.initialize(imusateiRireki);
        }

        String hubiSikibetuKey = updateSkHubi(syoriCTL, userId, sysDateTimeMilli, sysDate);

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

        C_SateikanKbn sateikanKbn;

        if (C_SyorikekkaKbn.KANRYOU.eq(uiBean.getMostenkenkekkakbn())) {

            sateikanKbn = C_SateikanKbn.TNK;
        }
        else {
            sateikanKbn = C_SateikanKbn.BLNK;
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
            uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        if (gyoumuKouteiInfo == null) {

            unlockProcess();

            throw new CommonBizAppException(MOSNO + uiBean.getMosno());
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());

        mosnaiCheckParam.setKinouID(kinou.getKinouId());

        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

        mosnaiCheckParam.setSateiKanryouKbn(sateikanKbn);

        mosnaiCheckParam.setSysDate(sysDate);

        mosnaiCheckParam.setKosID(userId);

        mosnaiCheckParam.setKosTime(sysDateTimeMilli);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        mosnaiCheck.exec(mosnaiCheckParam);

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        outputHubiTyouhyou(mosnaiCheckParam, hubiSikibetuKey, sysDate);

        updSyoriCtlForHubiInfo(syoriCTL, hubiSikibetuKey);

        setSintyokukJk(syoriCTL);

        sinkeiyakuDomManager.update(syoriCTL);

        bizDomManager.update(gyoumuKouteiInfo);

        HT_MosnoKanri mosnoKanri = mosnaiCheckParam.getMosnoKanri();
        if (mosnoKanri != null) {
            sinkeiyakuDomManager.update(mosnoKanri);
        }

        SkProcessUpdate newProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);
        newProcessUpdate.exec(mosnaiCheckParam.getDataSyoriControl(), getKouteiLockKey(), null);

        String uniqueId2 = uiBean.getUniqueid2();
        SkHubiRenkeiInfo newSkHubiRenkeiInfo = objStorageManager.retrieve(uniqueId2);

        if (newSkHubiRenkeiInfo.isHubiTourokuHenkouFlg()){
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            List<BzGetProcessSummaryOutBean> summaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if(summaryOutBeanList.size() > 0){
                BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
                BzGetProcessSummaryOutBean summaryOutBean = summaryOutBeanList.get(0);

                bzOutputProcessRecord.exec(summaryOutBean.getKouteiKanriId(), summaryOutBean.getJimuTetuzukiCd(), uiBean.getVktifdisptasknm() + "で不備情報が更新されました。",
                    "不備登録", C_SyorikekkaKbn.KANRYOU);
            }
        }

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        SkProcessForwardMousikomiTenken skProcessForwardMousikomiTenken = SWAKInjector
            .getInstance(SkProcessForwardMousikomiTenken.class);

        String kouteiLockKey = getKouteiLockKey();

        skProcessForwardInBean.setMosNo(uiBean.getMosno());

        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());

        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);

        skProcessForwardInBean.setSyorikekkaKbn(uiBean.getMostenkenkekkakbn());

        skProcessForwardInBean.setSyoriComment(uiBean.getMostenkencommentgamen());

        skProcessForwardInBean.setMostenkenkekkaKbn(uiBean.getMostenkenkekkakbn());

        skProcessForwardInBean.setMostenkentnsketsyaCd(tnsketsyacd);

        skProcessForwardInBean.setKnksateikekkaKbn(uiBean.getKnksateikekkakbn());

        skProcessForwardInBean.setImusateikekkaKbn(uiBean.getImusateikekkakbn());

        skProcessForwardMousikomiTenken.exec(skProcessForwardInBean,newSkHubiRenkeiInfo.isHubiTourokuHenkouFlg());

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean result = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(mosnaiCheckParam.getDataSyoriControl(),
            uiBean.getSkIdounaiyouBeforeBean());

        if (result) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(
                mosnaiCheckParam.getDataSyoriControl());

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (int i = 0; i < skIdounaiyouKekkaBean.getErrorMsgLst().size(); i++) {
                    errorMessageCollector.addMessage(skIdounaiyouKekkaBean.getErrorMsgLst().get(i));
                }
                if (errorMessageCollector.exists()) {
                    throw new BizLogicException(errorMessageCollector);
                }
            }
        }

        HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

        List<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(uiBean.getMosno());

        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        String uniqueId = objStorageManager.save(skHubiMsgRenkeiInfo);

        uiBean.setUniqueId(uniqueId);

        StringBuffer messageBuffer = new StringBuffer();

        messageBuffer.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> messList = mosnaiCheckParam.getListKekkaGmnMsg();

        for (int i = 0; i < messList.size(); i++) {

            messageBuffer.append(BR);

            messageBuffer.append(messList.get(i));
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), messageBuffer.toString());

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);

        unlockProcess();
    }

    String syokigamenBtnBL() {

        String rtnUrl = null;

        unlockProcess();

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            rtnUrl = FORWARDNAME_BACKTOWORKLIST;
        }
        else {

            rtnUrl = FORWARDNAME_INIT;
        }

        return rtnUrl;

    }

    String functionNameOnClickBL() {

        String rtnUrl = null;

        unlockProcess();

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            rtnUrl = FORWARDNAME_BACKTOWORKLIST;
        }
        else {

            rtnUrl = FORWARDNAME_INIT;
        }

        return rtnUrl;
    }

    void printOut() {
        outputReport.outputPDFByJoinKey(uiBean.getTyouhyouKey());
    }

    private void lockProcess(String pKouteiKanriId, String pJimuTetuzukiCd) {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.lockProcess(pKouteiKanriId, pJimuTetuzukiCd);
    }

    private void continueLockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.continueLockProcess();

    }

    void unlockProcess() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        bzCommonLockProcess.unlockProcess();

    }

    private String getKouteiLockKey() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);

        return bzCommonLockProcess.getKouteiLockKey();

    }

    private BzGetProcessSummaryOutBean getProcessSummary(
        String pJimutetuzukicd,
        C_Kouteikanristatus[] pKouteikanristatuss,
        String pKouteiKanriId,
        String pMosNo) {

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(pJimutetuzukicd);

        bzGetProcessSummaryInBean.setKouteiKanriStatuss(pKouteikanristatuss);

        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);

        bzGetProcessSummaryInBean.setMosNo(pMosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanlst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanlst.size() == 0) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanlst.get(0);

        return bzGetProcessSummaryOutBean;
    }

    private void waninguSyori() {

        HT_MosKihon mosKihon = uiBean.getSyoriCTL().getMosKihon();

        int grpNo;

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            grpNo = WORKLIST_GROUP_MESSAGE;
        }
        else {

            grpNo = GROUP_MESSAGE;
        }

        List<String> warningMessageIdList = new ArrayList<>();

        List<String> warningMessageList = new ArrayList<>();

        GetMsgAitemosno msgAitemosno = SWAKInjector.getInstance(GetMsgAitemosno.class);

        int kekkaKbn = msgAitemosno.exec(uiBean.getSyoriCTL().getMosnrkumu(), mosKihon.getAitemosno());

        if (kekkaKbn == GetMsgAitemosno.KEKKAKBN_ARI) {

            String messageId = BizUtil.getGeneralMessageId(msgAitemosno.getS_gmmsgid());

            messageManager.addConversationMessageId(grpNo, messageId, msgAitemosno.getS_gmmsg());

            warningMessageIdList.add(messageId);

            warningMessageList.add(msgAitemosno.getS_gmmsg());
        }

        GetMsgDoujikaiyakusyono msgDoujikaiyakusyono = SWAKInjector.getInstance(GetMsgDoujikaiyakusyono.class);

        kekkaKbn = msgDoujikaiyakusyono.exec(uiBean.getSyoriCTL().getMosnrkumu(), mosKihon.getDoujikaiyakusyono());

        if (kekkaKbn == GetMsgDoujikaiyakusyono.KEKKAKBN_ARI) {

            String messageId = BizUtil.getGeneralMessageId(msgDoujikaiyakusyono.getS_gmmsgid());

            messageManager.addConversationMessageId(grpNo, messageId, msgDoujikaiyakusyono.getS_gmmsg());

            warningMessageIdList.add(messageId);

            warningMessageList.add(msgDoujikaiyakusyono.getS_gmmsg());
        }

        HanteiDoujiMos hanteiDoujiMos = SWAKInjector.getInstance(HanteiDoujiMos.class);

        hanteiDoujiMos.hanteiDoujiMos(uiBean.getMosno());

        C_UmuKbn doujimosumu = hanteiDoujiMos.getDoujiMosUmu();

        if (C_UmuKbn.ARI.eq(doujimosumu)) {

            String messageMosNo = hanteiDoujiMos.getMsgMosnoList();

            messageManager.addConversationMessageId(grpNo, MessageId.WHC0102, messageMosNo);

            warningMessageIdList.add(MessageId.WHC0102);

            warningMessageList.add(MessageUtil.getMessage(MessageId.WHC0102, messageMosNo));
        }

        List<HT_SkHubi> skHubiList = uiBean.getSyoriCTL().getSkHubis();

        List<HT_SkHubiDetail> skHubiDetailList = new ArrayList<>();

        for (int n = 0; n < skHubiList.size(); n++) {

            skHubiDetailList = skHubiList.get(n).getSkHubiDetailsByHasinymdKaisyouymd();

            if (skHubiDetailList.size() > 0) {

                break;
            }
        }

        if (!skHubiDetailList.isEmpty()) {

            messageManager.addConversationMessageId(grpNo, MessageId.WHC1001);

            warningMessageIdList.add(MessageId.WHC1001);

            warningMessageList.add("");
        }

        GetSyoruittykymd getSyoruittykymd = SWAKInjector.getInstance(GetSyoruittykymd.class);

        BizDate syoruittykymd = getSyoruittykymd.exec(
            uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);

        if (syoruittykymd != null) {

            syoruittykymd = getSyoruittykymd.exec(
                uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
                C_SyoruiCdKbn.SK_MOSSYO);

            if (syoruittykymd != null) {

                String message = "<strong><font color=#FF0000>" + MessageUtil.getMessage(MessageId.WHA1005) + "</font></strong>";

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, MessageId.WBC0001, message);

                warningMessageIdList.add(MessageId.WHA1005);

                warningMessageList.add("");
            }
        }

        uiBean.setWarningMessageIdList(warningMessageIdList);
        uiBean.setWarningMessageList(warningMessageList);
    }

    private void setGamenSyuturyoku() {

        HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);

        List<String> hubimsgDataLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(
            uiBean.getMosno(),
            C_HubiSyoriKbn.SYOUKAI);

        String[] hubiList = hubimsgDataLst.toArray(new String[hubimsgDataLst.size()]);

        List<KetteiHoryuuHubiDataSourceBean> ketteiHoryuuHubiDataSourceBeanList = Lists.newArrayList();

        List<SeirituHoryuuHubiDataSourceBean> seirituHoryuuHubiDataSourceBeanList = Lists.newArrayList();

        List<WarningDataSourceBean> warningDataSourceBeanList = Lists.newArrayList();

        List<KihonHubiDataSourceBean> kihonHubiDataSourceBeanList = Lists.newArrayList();

        for (int i = 0; i < hubiList.length; i++) {

            String[] tmpDatas = hubimsgDataLst.get(i).trim().split(" ", 3);

            if (C_HubisyubetuKbn.KETHORYU_HUBI.getValue().equals(tmpDatas[0]) ) {

                KetteiHoryuuHubiDataSourceBean ketteiHoryuuHubiDataSourceBean = SWAKInjector
                    .getInstance(KetteiHoryuuHubiDataSourceBean.class);

                ketteiHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1].substring(0, 1));

                ketteiHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);

                ketteiHoryuuHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                ketteiHoryuuHubiDataSourceBeanList.add(ketteiHoryuuHubiDataSourceBean);
            }
            else if (C_HubisyubetuKbn.SRHORYU_HUBI.getValue().equals(tmpDatas[0]) ) {

                SeirituHoryuuHubiDataSourceBean seirituHoryuuHubiDataSourceBean = SWAKInjector
                    .getInstance(SeirituHoryuuHubiDataSourceBean.class);

                seirituHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1].substring(0, 1));

                seirituHoryuuHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);

                seirituHoryuuHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                seirituHoryuuHubiDataSourceBeanList.add(seirituHoryuuHubiDataSourceBean);
            }
            else if (C_HubisyubetuKbn.WARNING.getValue().equals(tmpDatas[0]) ) {

                WarningDataSourceBean warningDataSourceBean = SWAKInjector.getInstance(WarningDataSourceBean.class);

                warningDataSourceBean.setDisphubimsgid(tmpDatas[1].substring(0, 1));

                warningDataSourceBean.setDisphubimsgid(tmpDatas[1]);

                warningDataSourceBean.setDisphubimsg(tmpDatas[2]);

                warningDataSourceBeanList.add(warningDataSourceBean);
            }
            else if (C_HubisyubetuKbn.KIHON_HUBI.getValue().equals(tmpDatas[0]) ) {

                KihonHubiDataSourceBean kihonHubiDataSourceBean = SWAKInjector
                    .getInstance(KihonHubiDataSourceBean.class);

                kihonHubiDataSourceBean.setDisphubimsgid(tmpDatas[1].substring(0, 1));

                kihonHubiDataSourceBean.setDisphubimsgid(tmpDatas[1]);

                kihonHubiDataSourceBean.setDisphubimsg(tmpDatas[2]);

                kihonHubiDataSourceBeanList.add(kihonHubiDataSourceBean);
            }
        }

        uiBean.setKetteiHoryuuHubi(ketteiHoryuuHubiDataSourceBeanList);

        uiBean.setSeirituHoryuuHubi(seirituHoryuuHubiDataSourceBeanList);

        uiBean.setWarning(warningDataSourceBeanList);

        uiBean.setKihonHubi(kihonHubiDataSourceBeanList);

        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);

        setKouteiInfo.exec(uiBean);

        HT_MosKihon mosKihon = uiBean.getSyoriCTL().getMosKihon();

        uiBean.setMosno(mosKihon.getMosno());

        uiBean.setHhknnmkj(mosKihon.getHhknnmkj());

        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);

        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        setSintyokukJk(uiBean.getSyoriCTL());

        HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(uiBean.getMosno());

        if (mostenkenRireki != null) {

            uiBean.setZenkaiknksateicomnt(EditSecurityKm.getDecodeData(
                uiBean.getSyoriCTL().getMosno(),
                mostenkenRireki.getMostenkencomment()));
        }

        List<MousikomiTenkenRirekiDataSourceBean> mousikomiTenkenRirekiDataSourceBeanList = Lists.newArrayList();

        List<HT_MostenkenRireki> mostenkenRirekiList = uiBean.getSyoriCTL().getMostenkenRirekis();

        if (mostenkenRirekiList.size() == 0) {
            MousikomiTenkenRirekiDataSourceBean mousikomiTenkenRirekiDataSourceBean = SWAKInjector
                .getInstance(MousikomiTenkenRirekiDataSourceBean.class);

            mousikomiTenkenRirekiDataSourceBean.setDispmostenkensyoriymd(null);

            mousikomiTenkenRirekiDataSourceBean.setDispmostnknstktsyorinmkbn(null);

            mousikomiTenkenRirekiDataSourceBean.setDispmostenkenkekkakbn(C_SyorikekkaKbn.BLNK);

            mousikomiTenkenRirekiDataSourceBean.setDispmostenkenktnm("");

            mousikomiTenkenRirekiDataSourceBean.setDispmostenkencomment("");

            mousikomiTenkenRirekiDataSourceBeanList.add(mousikomiTenkenRirekiDataSourceBean);
        }
        else {

            for (int m = 0; m < mostenkenRirekiList.size(); m++) {

                MousikomiTenkenRirekiDataSourceBean mousikomiTenkenRirekiDataSourceBean = SWAKInjector
                    .getInstance(MousikomiTenkenRirekiDataSourceBean.class);

                String tntNm = "";

                if (mostenkenRirekiList.get(m).getKetteiSya() != null) {

                    tntNm = mostenkenRirekiList.get(m).getKetteiSya().getKetsyanm();
                }

                mousikomiTenkenRirekiDataSourceBean.setDispmostenkensyoriymd(
                    mostenkenRirekiList.get(m).getSyoriYmd());

                mousikomiTenkenRirekiDataSourceBean.setDispmostnknstktsyorinmkbn(
                    mostenkenRirekiList.get(m).getSateiketsyorinmkbn());

                mousikomiTenkenRirekiDataSourceBean.setDispmostenkenkekkakbn(
                    mostenkenRirekiList.get(m).getMostenkenkekkakbn());

                mousikomiTenkenRirekiDataSourceBean.setDispmostenkenktnm(tntNm);

                mousikomiTenkenRirekiDataSourceBean.setDispmostenkencomment(EditGamenString.editStringSbstr(
                    EditSecurityKm.getDecodeData(
                        uiBean.getSyoriCTL().getMosno(),
                        mostenkenRirekiList.get(m).getMostenkencomment()),
                        28));

                mousikomiTenkenRirekiDataSourceBeanList.add(mousikomiTenkenRirekiDataSourceBean);
            }
        }

        uiBean.setMousikomiTenkenRireki(mousikomiTenkenRirekiDataSourceBeanList);

        List<SkToriatukaiTyuuiJouhouDataSourceBean> skToriatukaiTyuuiJouhouDataSourceBeanList = Lists.newArrayList();

        GetSkTtdkTyuui getSkTtdkTyuui = SWAKInjector.getInstance(GetSkTtdkTyuui.class);

        List<HT_SkTtdkTyuui> ttdkTyuuiList = getSkTtdkTyuui.getTtdkTyuui(uiBean.getSyoriCTL().getMosno(),
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        if (ttdkTyuuiList != null && ttdkTyuuiList.size() > 0) {

            for (int i = 0; i < ttdkTyuuiList.size(); i++) {

                SkToriatukaiTyuuiJouhouDataSourceBean skToriatukaiTyuuiJouhouDataSourceBean = SWAKInjector
                    .getInstance(SkToriatukaiTyuuiJouhouDataSourceBean.class);

                HT_SkTtdkTyuui skTtdkTyuuiBean = ttdkTyuuiList.get(i);

                AM_User user = baseDomManager.getUser(skTtdkTyuuiBean.getGyoumuKousinsyaId());

                skToriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttrkymd(skTtdkTyuuiBean.getTrkymd());

                skToriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrtnaiyo(
                    EditSecurityKm.getDecodeData(
                        uiBean.getSyoriCTL().getMosno(),
                        skTtdkTyuuiBean.getSkeittdktyuuinaiyou()));

                if(user != null){
                    skToriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttantou(user.getUserNm());
                }else{
                    skToriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttantou("");
                }

                skToriatukaiTyuuiJouhouDataSourceBeanList.add(skToriatukaiTyuuiJouhouDataSourceBean);
            }
        }

        uiBean.setSkToriatukaiTyuuiJouhou(skToriatukaiTyuuiJouhouDataSourceBeanList);

        List<KankyouSateiRirekiDataSourceBean> kankyouSateiRirekiDataSourceBeanList = Lists.newArrayList();

        List<HT_KnksateiRireki> knksateiRirekiList = uiBean.getSyoriCTL().getKnksateiRirekis();

        if (knksateiRirekiList.size() == 0) {

            KankyouSateiRirekiDataSourceBean kankyouSateiRirekiDataSourceBean = SWAKInjector
                .getInstance(KankyouSateiRirekiDataSourceBean.class);

            kankyouSateiRirekiDataSourceBean.setDispknksyoriymd(null);

            kankyouSateiRirekiDataSourceBean.setDispknkstktsyorinmkbn(null);

            kankyouSateiRirekiDataSourceBean.setDispknkkekkakbn(C_SyorikekkaKbn.BLNK);

            kankyouSateiRirekiDataSourceBean.setDispknkktnm("");

            kankyouSateiRirekiDataSourceBean.setDispknkcomment("");

            kankyouSateiRirekiDataSourceBeanList.add(kankyouSateiRirekiDataSourceBean);

        }
        else {
            for (int j = 0; j < knksateiRirekiList.size(); j++) {
                KankyouSateiRirekiDataSourceBean kankyouSateiRirekiDataSourceBean = SWAKInjector
                    .getInstance(KankyouSateiRirekiDataSourceBean.class);

                String tntNm = "";

                if (knksateiRirekiList.get(j).getKetteiSya() != null) {

                    tntNm = knksateiRirekiList.get(j).getKetteiSya().getKetsyanm();
                }

                kankyouSateiRirekiDataSourceBean.setDispknksyoriymd(knksateiRirekiList.get(j).getSyoriYmd());

                kankyouSateiRirekiDataSourceBean.setDispknkstktsyorinmkbn(knksateiRirekiList.get(j)
                    .getSateiketsyorinmkbn());

                kankyouSateiRirekiDataSourceBean.setDispknkkekkakbn(knksateiRirekiList.get(j).getKnksateikekkakbn());

                kankyouSateiRirekiDataSourceBean.setDispknkktnm(tntNm);

                kankyouSateiRirekiDataSourceBean.setDispknkcomment(
                    EditGamenString.editStringSbstr(
                        EditSecurityKm.getDecodeData(
                            uiBean.getSyoriCTL().getMosno(),
                            knksateiRirekiList.get(j).getKnksateicomment()),
                            28));

                kankyouSateiRirekiDataSourceBeanList.add(kankyouSateiRirekiDataSourceBean);
            }
        }

        uiBean.setKankyouSateiRireki(kankyouSateiRirekiDataSourceBeanList);

        List<ImuSateiRirekiDataSourceBean> imuSateiRirekiDataSourceBeanList = Lists.newArrayList();

        List<HT_ImusateiRireki> imusateiRirekiList = uiBean.getSyoriCTL().getImusateiRirekis();

        if (imusateiRirekiList.size() == 0) {

            ImuSateiRirekiDataSourceBean imuSateiRirekiDataSourceBean = SWAKInjector
                .getInstance(ImuSateiRirekiDataSourceBean.class);

            imuSateiRirekiDataSourceBean.setDispimusyoriymd(null);

            imuSateiRirekiDataSourceBean.setDispimustktsyorinmkbn(null);

            imuSateiRirekiDataSourceBean.setDispimukekkakbn(C_SyorikekkaKbn.BLNK);

            imuSateiRirekiDataSourceBean.setDispimuktnm("");

            imuSateiRirekiDataSourceBean.setDispimucomment("");

            imuSateiRirekiDataSourceBeanList.add(imuSateiRirekiDataSourceBean);

        }
        else {
            for (int w = 0; w < imusateiRirekiList.size(); w++) {

                ImuSateiRirekiDataSourceBean imuSateiRirekiDataSourceBean = SWAKInjector
                    .getInstance(ImuSateiRirekiDataSourceBean.class);

                String tntNm = "";

                if (imusateiRirekiList.get(w).getKetteiSya() != null) {

                    tntNm = imusateiRirekiList.get(w).getKetteiSya().getKetsyanm();
                }

                imuSateiRirekiDataSourceBean.setDispimusyoriymd(imusateiRirekiList.get(w).getSyoriYmd());

                imuSateiRirekiDataSourceBean.setDispimustktsyorinmkbn(imusateiRirekiList.get(w)
                    .getSateiketsyorinmkbn());

                imuSateiRirekiDataSourceBean.setDispimukekkakbn(imusateiRirekiList.get(w).getImusateikekkakbn());

                imuSateiRirekiDataSourceBean.setDispimuktnm(tntNm);

                imuSateiRirekiDataSourceBean.setDispimucomment(
                    EditGamenString.editStringSbstr(
                        EditSecurityKm.getDecodeData(
                            uiBean.getSyoriCTL().getMosno(),
                            imusateiRirekiList.get(w).getImusateicomment()),
                            28));

                imuSateiRirekiDataSourceBeanList.add(imuSateiRirekiDataSourceBean);
            }
        }

        uiBean.setImuSateiRireki(imuSateiRirekiDataSourceBeanList);

        uiBean.setKhnchkcmnt(mosKihon.getKhnchkcmnt());

        HT_Kokutisyo kokutisyo = uiBean.getSyoriCTL().getKokutisyo();

        if (kokutisyo == null) {

            uiBean.setHbcmntkkt("");
        }
        else {

            uiBean.setHbcmntkkt(EditSecurityKm.getDecodeData(uiBean.getSyoriCTL().getMosno(), kokutisyo.getHbcmnt()));
        }

        List<HT_MosSyouhn> mosSyouhnList = uiBean.getSyoriCTL().getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhnList.get(0).getSyouhncd(),
            mosSyouhnList.get(0).getSyouhnsdno());

        uiBean.setKykdrtentsnsTumu(syouhnZokusei.getKykdrtentuusanumu());
        uiBean.setAeoiTaisyouUmu(syouhnZokusei.getAeoitaisyouumu());

        if (C_SntkhouKbn.NONE.eq(mosKihon.getSntkhoukbn()) ||
            C_SntkhouKbn.SYOKUGYOU.eq(mosKihon.getSntkhoukbn())) {

            uiBean.setImusateiiraiFlg(IMUSATEIIRAIFLG_NONE);
        }
        else {

            uiBean.setImusateiiraiFlg(IMUSATEIIRAIFLG_ARI);
        }

        if (C_SkeijimuKbn.NIHONYUUBIN.eq(uiBean.getSyoriCTL().getSkeijimukbn())) {

            uiBean.setKoureisyaTaiouFlg(GAMENHOUJIFLG_ARI);
        }
        else {

            uiBean.setKoureisyaTaiouFlg(GAMENHOUJIFLG_NONE);
        }
    }

    private void setSintyokukJk(HT_SyoriCTL pSyoriCTL) {
        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkumu())) {

            uiBean.setKkthjykbn(C_KkthjyKbn.HJYNRK_ARI);
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {

            uiBean.setKkthjykbn(C_KkthjyKbn.KKTNRK_ARI);
        }
        else {

            uiBean.setKkthjykbn(C_KkthjyKbn.NONE);
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())
            || C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())
            || C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {

            uiBean.setHubiumu(C_UmuKbn.ARI);
        }
        else {

            uiBean.setHubiumu(C_UmuKbn.NONE);
        }

        List<HT_RuleHanteiMsg> ruleHanteiMsgList = uiBean.getSyoriCTL().getRuleHanteiMsgsByRulehanteimsg(
            C_Rulehanteimsg.MOSTENKEN);

        uiBean.setMostenkensjnaiyou(EditGamenString.editMessegeStringRule(ruleHanteiMsgList));

        uiBean.setMosnrkumu(pSyoriCTL.getMosnrkumu());

        uiBean.setNyknnrkumu(pSyoriCTL.getNyknnrkumu());

        uiBean.setMostenkenjoukbn(pSyoriCTL.getMostenkenjoukbn());

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

        uiBean.setKnkysatei1jiyhkbn(pSyoriCTL.getKnkysatei1jiyhkbn());

        uiBean.setKnkysatei2jiyhkbn(pSyoriCTL.getKnkysatei2jiyhkbn());

        uiBean.setImusateikaniyhkbn(pSyoriCTL.getImusateikaniyhkbn());

        uiBean.setLincgthtkekkbn(pSyoriCTL.getLincgthtkekkbn());
    }


    private void setGamenNyuuryoku() {
        HT_MosKihon mosKihon = uiBean.getSyoriCTL().getMosKihon();

        uiBean.setTsryhshrkykumukbn(mosKihon.getTsryhshrkykumukbn());

        uiBean.setSyosisyatodokeumukbn(mosKihon.getSyosisyatodokeumukbn());

        uiBean.setKakukisyouryakukbumukbn(mosKihon.getKakukisyouryakukbumukbn());

        uiBean.setSeiymdmosseitouumukbn(mosKihon.getSeiymdmosseitouumukbn());

        uiBean.setUktkakkbn(uiBean.getSyoriCTL().getUktkakkbn());

        uiBean.setTkhjnkbn(uiBean.getSyoriCTL().getTkhjnkbn());

        uiBean.setKouseiinkykkbn(uiBean.getSyoriCTL().getKouseiinkykkbn());

        uiBean.setKouseiinkyktkjkumukbn(mosKihon.getKouseiinkyktkjkumukbn());

        uiBean.setKoukankykkbn(uiBean.getSyoriCTL().getKoukankykkbn());

        uiBean.setKoukankykkinmusakinm(mosKihon.getKoukankykkinmusakinm());

        uiBean.setKoukankyksyokumunaiyou(mosKihon.getKoukankyksyokumunaiyou());

        uiBean.setKoukankyktkjkumukbn(mosKihon.getKoukankyktkjkumukbn());

        uiBean.setFatcakakkekkakbn(uiBean.getSyoriCTL().getFatcakakkekkakbn());

        uiBean.setAeoikekkakbn(uiBean.getSyoriCTL().getAeoikekkakbn());

        uiBean.setTkhsyouryakuumukbn(uiBean.getSyoriCTL().getTkhsyouryakuumukbn());

        uiBean.setKoureitaioukbn(mosKihon.getKoureitaioukbn());

        UserDefsList userDefsList = new UserDefsList();

        List<HM_KetteiSya> ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns(
            baseUserInfo.getUserId(), C_MostenkenRankKbn.ITIJI, C_MostenkenRankKbn.NIJI, C_MostenkenRankKbn.HUBI);

        LabelValuePair labelValuePair = new LabelValuePair();
        userDefsList.add(labelValuePair);

        for (int n = 0; n < ketteiSyaList.size(); n++) {

            labelValuePair = new LabelValuePair();

            labelValuePair.setLabel(ketteiSyaList.get(n).getKetsyanm());

            labelValuePair.setValue(ketteiSyaList.get(n).getKetsyacd());

            userDefsList.add(labelValuePair);
        }

        uiBean.setMostenkentnsketsyacdOptionBeanList(userDefsList);
    }

    private void addConversationMessageId(
        List<String> pWwarningMessageIdList,
        List<String> pWarningMessageList,
        int pGroupId) {

        if (pWwarningMessageIdList.size() != 0) {

            for (int n = 0; n < pWwarningMessageIdList.size(); n++) {

                if (BizUtil.isBlank(pWarningMessageList.get(n))) {
                    messageManager.addConversationMessageId(
                        pGroupId,
                        pWwarningMessageIdList.get(n));
                }
                else {

                    String messageID = BizUtil.getGeneralMessageId(pWwarningMessageIdList.get(n));

                    messageManager.addConversationMessageId(
                        pGroupId,
                        messageID,
                        pWarningMessageList.get(n));
                }
            }
        }
    }

    private void setHubiTourokuInfo() {

        List<HubiList1DataSourceBean> hubiList1 = new ArrayList<>();
        List<HubiList2DataSourceBean> hubiList2 = new ArrayList<>();
        skHubiRenkeiInfo.setHubiList1(hubiList1);
        skHubiRenkeiInfo.setHubiList2(hubiList2);
        skHubiRenkeiInfo.setHubiTourokuHenkouFlg(false);

        String uniqueId = objStorageManager.save(skHubiRenkeiInfo);

        uiBean.setUniqueid2(uniqueId);
        uiBean.setHubitourokumode(kinouMode.getKinouMode());
    }

    private String updateSkHubi(HT_SyoriCTL pSyoriCTL, String pUserId, String pSysDateTimeMilli, BizDate pSysDate) {

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());

        HT_SkHubi skHubi = null;
        List<HT_SkHubi> skHubiList = pSyoriCTL.getSkHubis();

        if (skHubiList.size() > 0) {
            skHubi = skHubiList.get(0);
        }

        String uniqueId = uiBean.getUniqueid2();
        SkHubiRenkeiInfo newSkHubiRenkeiInfo = objStorageManager.retrieve(uniqueId);

        if (newSkHubiRenkeiInfo.isHubiTourokuHenkouFlg()) {
            if (skHubi == null) {
                if (newSkHubiRenkeiInfo.getHubiList2().size() > 0) {
                    skHubi = pSyoriCTL.createSkHubi();

                    skHubi.setHubisikibetukey(newSkHubiRenkeiInfo.getHubiTourokuKouteikanriId());
                    skHubi.setJimutetuzukinm("新契約不備登録");
                    skHubi.setUtdskknnm1kj(newSkHubiRenkeiInfo.getUtdskknnm1kj());
                    skHubi.setUtdskknnm2kj(newSkHubiRenkeiInfo.getUtdskknnm2kj());
                    skHubi.setTuutisakitantounmkj(newSkHubiRenkeiInfo.getTuutisakitantounmkj());
                    skHubi.setTuutikyokasyanmkj(baseUserInfo.getUserNm());
                    skHubi.setGyoumuKousinsyaId(pUserId);
                    BizPropertyInitializer.initialize(skHubi);
                }
            }
            else {
                if (newSkHubiRenkeiInfo.getHubiList2().size() == 0) {
                    if (newSkHubiRenkeiInfo.getHubiList1().size() == 0) {
                        List<HT_SkHubi> newSkHubiList = pSyoriCTL.getSkHubis();
                        newSkHubiList.remove(skHubi);

                        List<HT_SkHubiDetail> skHubiDetailList = skHubi.getSkHubiDetails();
                        skHubiDetailList.clear();
                    }
                    else {
                        List<HT_SkHubiDetail> newSkHubiList = skHubi.getSkHubiDetails();
                        List<HT_SkHubiDetail> mihassinSkHubiList = skHubi.getSkHubiDetailsByHasinymdNull();

                        newSkHubiList.removeAll(mihassinSkHubiList);

                        skHubi.setUtdskknnm1kj(newSkHubiRenkeiInfo.getUtdskknnm1kj());
                        skHubi.setUtdskknnm2kj(newSkHubiRenkeiInfo.getUtdskknnm2kj());
                        skHubi.setTuutisakitantounmkj(newSkHubiRenkeiInfo.getTuutisakitantounmkj());
                        skHubi.setTuutikyokasyanmkj(baseUserInfo.getUserNm());
                        skHubi.setGyoumuKousinsyaId(pUserId);
                    }
                }
                else {
                    skHubi.setUtdskknnm1kj(newSkHubiRenkeiInfo.getUtdskknnm1kj());
                    skHubi.setUtdskknnm2kj(newSkHubiRenkeiInfo.getUtdskknnm2kj());
                    skHubi.setTuutisakitantounmkj(newSkHubiRenkeiInfo.getTuutisakitantounmkj());
                    skHubi.setTuutikyokasyanmkj(baseUserInfo.getUserNm());
                    skHubi.setGyoumuKousinsyaId(pUserId);
                }
            }

            if (newSkHubiRenkeiInfo.getHubiList2().size() > 0) {
                Integer maxRenno = sinkeiyakuDomManager.getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(
                    uiBean.getMosno(), skHubi.getHubisikibetukey());

                if (maxRenno != null) {

                    maxRenno = maxRenno + 1;
                }
                else {

                    maxRenno = 1;
                }

                skHubi.getSkHubiDetails().removeAll(skHubi.getSkHubiDetailsByHasinymdNull());
                sinkeiyakuDomManager.flush();

                for (HubiList2DataSourceBean hubiInputBean : newSkHubiRenkeiInfo.getHubiList2()) {
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
                    skHubiDetail.setGyoumuKousinsyaId(pUserId);
                    skHubiDetail.setGyoumuKousinTime(pSysDateTimeMilli);

                    BizPropertyInitializer.initialize(skHubiDetail);
                    maxRenno ++;
                }
            }
        }

        if (skHubi != null) {
            return skHubi.getHubisikibetukey();
        }

        return null;
    }

    private void outputHubiTyouhyou(MosnaiCheckParam pMcp, String pHubisikibetuKey, BizDate pSysDate) {

        String uniqueId = uiBean.getUniqueid2();
        SkHubiRenkeiInfo skHubiRenkeiInfo1 = objStorageManager.retrieve(uniqueId);

        if (skHubiRenkeiInfo1.isHubiTourokuHenkouFlg()) {
            String tyouhyouKey = null;
            if (C_HbtyhyoutKbn.ONLINE.eq(skHubiRenkeiInfo1.getHbtyhyoutkbn())) {

                tyouhyouKey = editPdfHubiTyouhyou.exec(pHubisikibetuKey, pMcp, pSysDate);

                uiBean.setTyouhyouKey(tyouhyouKey);
            }
        }
    }

    private void updSyoriCtlForHubiInfo(HT_SyoriCTL pSyoriCTL, String pHubisikibetuKey) {

        String uniqueId = uiBean.getUniqueid2();
        SkHubiRenkeiInfo skHubiRenkeiInfo1 = objStorageManager.retrieve(uniqueId);

        if (skHubiRenkeiInfo1.isHubiTourokuHenkouFlg()) {

            long skDetailCount = sinkeiyakuDomManager.getSkHubiDetailCountByPkHasinkyokakbn(uiBean.getMosno(), pHubisikibetuKey);

            if (skDetailCount > 0) {
                pSyoriCTL.setMihassinhubiumu(C_UmuKbn.ARI);
            }
            else {
                pSyoriCTL.setMihassinhubiumu(C_UmuKbn.NONE);
            }

            if (!BizUtil.isBlank(uiBean.getTyouhyouKey())) {
                if (!C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI.eq(pSyoriCTL.getHubikaisyoujoutaikbn())) {
                    pSyoriCTL.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAITOUMATI);
                }
                else {
                    pSyoriCTL.setHubikaisyoujoutaikbn(C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI);
                }
            }
            else {
                pSyoriCTL.setHubikaisyoujoutaikbn(pSyoriCTL.getHubikaisyoujoutaikbn());
            }
        }
    }
}
