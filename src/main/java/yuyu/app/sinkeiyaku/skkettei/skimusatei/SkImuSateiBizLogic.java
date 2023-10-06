package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import static yuyu.app.sinkeiyaku.skkettei.skimusatei.SkImuSateiConstants.*;

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
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.classification.DisplayItem;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import net.arnx.jsonic.JSON;

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzcommon.SetNenrei;
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
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardImuSatei;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SetHutuuSibouS;
import yuyu.common.sinkeiyaku.skcommon.EditGamenString;
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
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_KkthjyKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TkjysydksyhyKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_TskStartKekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_WariateHukaInfo;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_SentakuJyouhou;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * 医務査定 のビジネスロジックです。
 */
public class SkImuSateiBizLogic {

    @Inject
    private static Logger logger;

    @Inject
    private SkImuSateiUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private GetMsgDoujikaiyakusyono getMsgDoujikaiyakusyono;

    @Inject
    private MessageManager messageManager;

    @Inject
    private HanteiDoujiMos hanteiDoujiMos;

    @Inject
    private SetNenrei setNenrei;

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private ObjStorageManager objStorageManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    @Transactional
    void iwfOpenBL() {
        BizPropertyInitializer.initialize(uiBean);

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(),
                kinou.getKinouId(),
                C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString());

            if (!kengenFlag) {
                throw new BizLogicException(MessageId.EHA1073, IMUSATEI_KANI_UW);
            }
        }
        else if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD.equals(uiBean.getBzWorkflowInfo().getTaskId())) {

            boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(),
                kinou.getKinouId(),
                C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.toString());

            if (!kengenFlag) {
                throw new BizLogicException(MessageId.EHA1073, IMUSATEI_KANI_MD);
            }
        }

        if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString());
        }
        else if (ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.toString());
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setKouteiKanriId(uiBean.getBzWorkflowInfo().getKouteiKanriId());
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(uiBean.getBzWorkflowInfo().getJimuTetuzukiCd());
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        uiBean.setMosno(bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getMosNo());

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(uiBean.getMosno());
        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId());

        String mosNo = uiBean.getMosno();
        List<String> gmwarningIdLst = Lists.newArrayList();
        List<String> gmwarningLst = Lists.newArrayList();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        uiBean.setSyoriCTL(syoriCTL);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        HM_KetteiSya ketteiSya = null;

        ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUser().getUserId());

        if (ketteiSya == null) {
            if (C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString().equals(kinouMode.getKinouMode())) {
                throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_UW);
            }
            else if (C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.toString().equals(kinouMode.getKinouMode())){
                throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_MD);
            }
        }
        else {
            if (C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString().equals(kinouMode.getKinouMode())) {
                if (!C_ImusateirankKbn.KANI_UW.eq(ketteiSya.getImusateirankkbn())
                    && !C_ImusateirankKbn.KANI_MD.eq(ketteiSya.getImusateirankkbn())) {
                    throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_UW);
                }
            }
            else if (C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.toString().equals(kinouMode.getKinouMode())) {
                if (!C_ImusateirankKbn.KANI_MD.eq(ketteiSya.getImusateirankkbn())) {
                    throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_MD);
                }
            }

            BizCurrency hutuuSbs = getHutuuSbs(syoriCTL);
            if (ketteiSya.getImusateijygns().compareTo(hutuuSbs) < 0) {
                throw new BizLogicException(MessageId.EHA1014, hutuuSbs.toFormatString());
            }
        }

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException(MOSNO_EQ + mosNo);
        }

        int kekkaKbnAite = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon.getAitemosno());
        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbnAite) {
            gmwarningIdLst.add(getMsgAitemosno.getS_gmmsgid());
            gmwarningLst.add(getMsgAitemosno.getS_gmmsg());
        }

        int kekkaKbnDouji = getMsgDoujikaiyakusyono.exec(syoriCTL.getMosnrkumu(), mosKihon.getDoujikaiyakusyono());
        if (GetMsgDoujikaiyakusyono.KEKKAKBN_ARI == kekkaKbnDouji) {
            gmwarningIdLst.add(getMsgDoujikaiyakusyono.getS_gmmsgid());
            gmwarningLst.add(getMsgDoujikaiyakusyono.getS_gmmsg());
        }

        List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL.getImusateiRirekis();
        List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekis();
        List<HT_MostenkenRireki> mostenkenRirekiLst = syoriCTL.getMostenkenRirekis();
        List<HT_RuleHanteiMsg> ruleHanteiMsgLst = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.IMUSATEI);

        C_ImusateirankKbn[] imusateirankKbns = {C_ImusateirankKbn.KANI_UW, C_ImusateirankKbn.KANI_MD};
        List<HM_KetteiSya> ketteiSyaLst = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns(
            baseUserInfo.getUserId(), imusateirankKbns);

        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos(mosNo);
        if (C_ErrorKbn.OK.eq(errorKbn)) {
            if (C_UmuKbn.ARI.eq(hanteiDoujiMos.getDoujiMosUmu())) {
                gmwarningIdLst.add(MessageId.WHC0102);
                gmwarningLst.add(MessageUtil.getMessage(MessageId.WHC0102, hanteiDoujiMos.getMsgMosnoList()));
            }
        }

        uiBean.setGmwarningIdLst(gmwarningIdLst);
        uiBean.setGmwarningLst(gmwarningLst);

        HT_Houjyou houjyou = null;
        HT_Kokutisyo kokutisyo = null;
        if (C_UmuKbn.ARI.eq(syoriCTL.getHjynrkumu()) || C_UmuKbn.ARI.eq(syoriCTL.getHjynrkhbumu())) {
            houjyou = syoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);
            if (houjyou == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }
        }
        else if (C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) || C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu())) {
            kokutisyo = syoriCTL.getKokutisyo();
            if (kokutisyo == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }
        }

        String imuSateisijiNaiyou = "";
        if (ruleHanteiMsgLst.size() != 0) {
            imuSateisijiNaiyou = EditGamenString.editMessegeStringRule(ruleHanteiMsgLst);
        }

        addConversationMessage();

        setUiBean(mosKihon,
            syoriCTL,
            imuSateisijiNaiyou,
            imusateiRirekiLst,
            ketteiSyaLst,
            knksateiRirekiLst,
            mostenkenRirekiLst,
            houjyou,
            kokutisyo);

        if (imusateiRirekiLst.size() != 0) {
            setUiBean_ZenSatei(imusateiRirekiLst, mosKihon);
        }

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

    @Transactional
    void pushSateiBL() {
        String mosNo = null;
        BizPropertyInitializer.initialize(uiBean);
        mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCTL = null;

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(syoriCTL.getImusateijyoukbn())) {
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString());
        }
        else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(syoriCTL.getImusateijyoukbn())) {
            kinouMode.setKinouMode(C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.toString());
        }

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.isEmpty()) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        uiBean.getBzWorkflowInfo().setKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());
        uiBean.getBzWorkflowInfo().setJimuTetuzukiCd(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd());
        uiBean.getBzWorkflowInfo().setTaskId(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId());

        hanteiSyoriKahi(syoriCTL);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        if (bzGetProcessSummaryOutBeanLst.isEmpty()) {

            throw new BizLogicException(MessageId.EBA0112);
        }

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        HT_MosKihon mosKihon = null;
        mosKihon = syoriCTL.getMosKihon();

        List<String> gmwarningIdLst = Lists.newArrayList();
        List<String> gmwarningLst = Lists.newArrayList();

        if (mosKihon == null) {
            throw new CommonBizAppException(MOSNO_EQ + mosNo);
        }

        int iKekkakbnAite = getMsgAitemosno.exec(syoriCTL.getMosnrkumu(), mosKihon.getAitemosno());
        if (GetMsgAitemosno.KEKKAKBN_ARI == iKekkakbnAite) {

            gmwarningIdLst.add(getMsgAitemosno.getS_gmmsgid());
            gmwarningLst.add(getMsgAitemosno.getS_gmmsg());
        }

        int kekkakbnDouji = getMsgDoujikaiyakusyono.exec(syoriCTL.getMosnrkumu(), mosKihon.getDoujikaiyakusyono());
        if (GetMsgDoujikaiyakusyono.KEKKAKBN_ARI == kekkakbnDouji) {

            gmwarningIdLst.add(getMsgDoujikaiyakusyono.getS_gmmsgid());
            gmwarningLst.add(getMsgDoujikaiyakusyono.getS_gmmsg());
        }

        List<HT_ImusateiRireki> imusateiRirekiList = null;

        imusateiRirekiList = syoriCTL.getImusateiRirekis();

        List<HT_KnksateiRireki> knksateiRirekiList = null;

        knksateiRirekiList = syoriCTL.getKnksateiRirekis();

        List<HT_MostenkenRireki> mostenkenRirekiLst = syoriCTL.getMostenkenRirekis();

        List<HT_RuleHanteiMsg> ruleHanteiMsgList = null;

        ruleHanteiMsgList = syoriCTL.getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg.IMUSATEI);

        List<HM_KetteiSya> ketteiSyaList = null;
        C_ImusateirankKbn[] imusateirankKbns = { C_ImusateirankKbn.KANI_UW, C_ImusateirankKbn.KANI_MD };
        ketteiSyaList = sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns(
            baseUserInfo.getUserId(), imusateirankKbns);

        C_ErrorKbn errorKbn = hanteiDoujiMos.hanteiDoujiMos(mosNo);

        if (C_ErrorKbn.OK.eq(errorKbn)) {

            if (C_UmuKbn.ARI.eq(hanteiDoujiMos.getDoujiMosUmu())) {

                gmwarningIdLst.add(MessageId.WHC0102);
                gmwarningLst.add(MessageUtil.getMessage(MessageId.WHC0102, hanteiDoujiMos.getMsgMosnoList()));
            }

        }
        uiBean.setGmwarningIdLst(gmwarningIdLst);
        uiBean.setGmwarningLst(gmwarningLst);

        HT_Houjyou houjyou = null;
        HT_Kokutisyo kokutisyo = null;

        if (C_UmuKbn.ARI.eq(syoriCTL.getHjynrkumu()) || C_UmuKbn.ARI.eq(syoriCTL.getHjynrkhbumu())) {
            houjyou = syoriCTL.getHoujyouBySyosaikbn(C_SyosaiKbn.SOYSIN);

            if (houjyou == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }
        }

        else if (C_UmuKbn.ARI.eq(syoriCTL.getKktnrkumu()) || C_UmuKbn.ARI.eq(syoriCTL.getKktnrkhbumu())) {
            kokutisyo = syoriCTL.getKokutisyo();

            if (kokutisyo == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }
        }

        String imusateiSijiNaiyou = "";

        if (ruleHanteiMsgList.size() != 0) {
            imusateiSijiNaiyou = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);
        }

        addConversationMessage();

        setUiBean(mosKihon, syoriCTL, imusateiSijiNaiyou, imusateiRirekiList, ketteiSyaList,
            knksateiRirekiList, mostenkenRirekiLst, houjyou, kokutisyo);

        if (imusateiRirekiList.size() != 0) {
            setUiBean_ZenSatei(imusateiRirekiList, mosKihon);
        }

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

    void pushKakuNinBL() {
        continueLockProcess();

        String syoubyouNm1 = "";
        String syoubyouNm2 = "";

        String mosNo = uiBean.getMosno();
        C_SyorikekkaKbn imuSyorikekkaKbn = uiBean.getImusateikekkakbn();
        C_Ketkekkacd ketkekkacd = uiBean.getKetkekkacd();
        String syoubyoucd1 = uiBean.getSyoubyoucd1();
        String syoubyoucd2 = uiBean.getSyoubyoucd2();
        String tnsketsyacdSelected = uiBean.getImutnsketsyacd();
        C_HubihassintnsKbn hubihassintnsKbn = uiBean.getHubihassintnskbn();
        String ketRiyuuCd1 = uiBean.getKetriyuucd1gamen();
        String ketRiyuuCd2 = uiBean.getKetriyuucd2gamen();
        String ketRiyuuCd3 = uiBean.getKetriyuucd3gamen();
        String ketRiyuuCd4 = uiBean.getKetriyuucd4gamen();
        C_SyoubyoujyoutaiKbn syoubyouJyoutaiKbn1 = uiBean.getSyoubyoujyoutaikbn1();
        BizDateYM kantiYm1 = uiBean.getKantiym1();
        C_SyoubyoujyoutaiKbn syoubyouJyoutaiKbn2 = uiBean.getSyoubyoujyoutaikbn2();
        BizDateYM kantiYm2 = uiBean.getKantiym2();
        C_SyorikekkaKbn knksateiKekkaKbn = uiBean.getKnksateikekkakbn();
        String knksateiIraiComment = uiBean.getKnksateiiraicomment();
        C_SyorikekkaKbn mostenkenKekkaKbn = uiBean.getMostenkenkekkakbn();
        String mostenkenIraiComment = uiBean.getMostenkeniraicomment();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        if (C_SyorikekkaKbn.KANRYOU.eq(imuSyorikekkaKbn) && !BizUtil.isBlank(tnsketsyacdSelected)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_IMUSATEI_IMUTNSKETSYACD.getErrorResourceKey()));
        }

        if (C_SyorikekkaKbn.HORYUU.eq(imuSyorikekkaKbn) && !BizUtil.isBlank(tnsketsyacdSelected)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_IMUSATEI_IMUTNSKETSYACD.getErrorResourceKey()));
        }

        if ((C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn)
            || C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn))
            && BizUtil.isBlank(tnsketsyacdSelected)) {
            throw new BizLogicException(MessageId.EHA0309);
        }

        if ((C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn)
            || C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn))
            && !ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(tnsketsyacdSelected)) {

            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

            if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn)) {
                boolean kinouModeKengenFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    tnsketsyacdSelected, kinou.getKinouId(), C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.getValue());

                boolean taskKengenFlg = checkTaskKengen.exec(tnsketsyacdSelected,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW);

                if (!kinouModeKengenFlg || !taskKengenFlg) {
                    throw new BizLogicException(MessageId.EHA0314, IMUSATEI_KANI_UW);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn)) {
                boolean kinouModeKengenFlg = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    tnsketsyacdSelected, kinou.getKinouId(), C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.getValue());

                boolean taskKengenFlg = checkTaskKengen.exec(tnsketsyacdSelected,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD);

                if (!kinouModeKengenFlg || !taskKengenFlg) {
                    throw new BizLogicException(MessageId.EHA0314, IMUSATEI_KANI_MD);
                }
            }

            HM_KetteiSya ketteiSya = null;

            ketteiSya = sinkeiyakuDomManager.getKetteiSya(tnsketsyacdSelected);

            if (ketteiSya == null) {
                if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn)) {
                    throw new BizLogicException(MessageId.EHA0314, IMUSATEI_KANI_UW);
                }
                else if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn)) {
                    throw new BizLogicException(MessageId.EHA0314, IMUSATEI_KANI_MD);
                }
            }
            else {
                if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn)) {
                    if (!C_ImusateirankKbn.KANI_UW.eq(ketteiSya.getImusateirankkbn())
                        && !C_ImusateirankKbn.KANI_MD.eq(ketteiSya.getImusateirankkbn())) {
                        throw new BizLogicException(MessageId.EHA0314, IMUSATEI_KANI_UW);
                    }
                }
                else if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn)) {
                    if (!C_ImusateirankKbn.KANI_MD.eq(ketteiSya.getImusateirankkbn())) {
                        throw new BizLogicException(MessageId.EHA0314, IMUSATEI_KANI_MD);
                    }
                }
            }

            BizCurrency hutuuSbs = getHutuuSbs(syoriCTL);
            if (ketteiSya.getImusateijygns().compareTo(hutuuSbs) < 0) {
                throw new BizLogicException(MessageId.EHA1015, hutuuSbs.toFormatString());
            }

            if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn)) {
                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW, tnsketsyacdSelected);

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
            else if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn)) {
                BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(uiBean.getBzWorkflowInfo().getKouteiKanriId(),
                    ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
                    ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD, tnsketsyacdSelected);

                if (wariateHukaInfo != null) {
                    throw new BizLogicException(MessageId.EHA1064);
                }
            }
        }

        if (BizUtil.isBlank(ketRiyuuCd3) && !BizUtil.isBlank(ketRiyuuCd4)) {
            throw new BizLogicException(MessageId.EHA0075, MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD4GAMEN
                .getErrorResourceKey()));
        }
        if (BizUtil.isBlank(ketRiyuuCd2) && !BizUtil.isBlank(ketRiyuuCd3)) {
            throw new BizLogicException(MessageId.EHA0075, MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD3GAMEN
                .getErrorResourceKey()));
        }
        if (BizUtil.isBlank(ketRiyuuCd1) && !BizUtil.isBlank(ketRiyuuCd2)) {
            throw new BizLogicException(MessageId.EHA0075, MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD2GAMEN
                .getErrorResourceKey()));
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
        if ((!BizUtil.isBlank(ketRiyuuCd3) && !BizUtil.isBlank(ketRiyuuCd4) && ketRiyuuCd3.equals(ketRiyuuCd4))) {

            throw new BizLogicException(MessageId.EHA0432);
        }

        if (C_Ketkekkacd.MUJYOUKEN.eq(ketkekkacd) && !BizUtil.isBlank(ketRiyuuCd1)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(ketkekkacd) ||
            C_Ketkekkacd.ENKI_SIJINASI.eq(ketkekkacd) ||
            C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(ketkekkacd))
            && BizUtil.isBlank(ketRiyuuCd1)) {

            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }

        if (!BizUtil.isBlank(ketRiyuuCd1) && !chkKbnValue(ketRiyuuCd1)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if (!BizUtil.isBlank(ketRiyuuCd2) && !chkKbnValue(ketRiyuuCd2)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }
        else if (!BizUtil.isBlank(ketRiyuuCd3) && !chkKbnValue(ketRiyuuCd3)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }
        else if (!BizUtil.isBlank(ketRiyuuCd4) && !chkKbnValue(ketRiyuuCd4)) {
            throw new BizLogicException(MessageId.EBA0030,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuCd1Flg = hanteiKetRiyuuNrKahi(ketkekkacd, ketRiyuuCd1);
        if (!ketRiyuuCd1Flg) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuCd2Flg = hanteiKetRiyuuNrKahi(ketkekkacd, ketRiyuuCd2);
        if (!ketRiyuuCd2Flg) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuCd3Flg = hanteiKetRiyuuNrKahi(ketkekkacd, ketRiyuuCd3);
        if (!ketRiyuuCd3Flg) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }

        boolean ketRiyuuCd4Flg = hanteiKetRiyuuNrKahi(ketkekkacd, ketRiyuuCd4);
        if (!ketRiyuuCd4Flg) {
            throw new BizLogicException(MessageId.EHA1024,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        if ((C_Ketriyuucd.HHKN_NINSIN.toString().equals(ketRiyuuCd1) ||
            C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.toString().equals(ketRiyuuCd1)) &&
            !C_Hhknsei.FEMALE.eq(uiBean.getHhknsei())) {

            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.HHKN_NINSIN.toString().equals(ketRiyuuCd2) ||
            C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.toString().equals(ketRiyuuCd2))
            && !C_Hhknsei.FEMALE.eq(uiBean.getHhknsei())) {

            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.HHKN_NINSIN.toString().equals(ketRiyuuCd3) ||
            C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.toString().equals(ketRiyuuCd3)) &&
            !C_Hhknsei.FEMALE.eq(uiBean.getHhknsei())) {

            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }
        else if ((C_Ketriyuucd.HHKN_NINSIN.toString().equals(ketRiyuuCd4) ||
            C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.toString().equals(ketRiyuuCd4)) &&
            !C_Hhknsei.FEMALE.eq(uiBean.getHhknsei())) {

            throw new BizLogicException(MessageId.EHA1017,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        if (C_Ketriyuucd.KYKKAKUNINKETTEI.toString().equals(ketRiyuuCd1) &&
            !C_KykkakjkKbn.KAKUNIN_SUMI.eq(uiBean.getKykkakjkkbn())) {

            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD1GAMEN.getErrorResourceKey()));
        }
        else if (C_Ketriyuucd.KYKKAKUNINKETTEI.toString().equals(ketRiyuuCd2) &&
            !C_KykkakjkKbn.KAKUNIN_SUMI.eq(uiBean.getKykkakjkkbn())) {

            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD2GAMEN.getErrorResourceKey()));
        }
        else if (C_Ketriyuucd.KYKKAKUNINKETTEI.toString().equals(ketRiyuuCd3)
            && !C_KykkakjkKbn.KAKUNIN_SUMI.eq(uiBean.getKykkakjkkbn())) {
            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD3GAMEN.getErrorResourceKey()));
        }
        else if (C_Ketriyuucd.KYKKAKUNINKETTEI.toString().equals(ketRiyuuCd4)
            && !C_KykkakjkKbn.KAKUNIN_SUMI.eq(uiBean.getKykkakjkkbn())) {
            throw new BizLogicException(MessageId.EHA1026,
                MessageUtil.getMessage(DDID_KETTEI_KETRIYUUCD4GAMEN.getErrorResourceKey()));
        }

        boolean ketriyuucdHisuFlg = hanteiKetRiyuuNr(ketkekkacd, ketRiyuuCd1, ketRiyuuCd2, ketRiyuuCd3, ketRiyuuCd4);
        if (!ketriyuucdHisuFlg) {
            throw new BizLogicException(MessageId.EHA1042, ketkekkacd.getContent(C_Ketkekkacd.PATTERN_IMUSATEI));
        }

        if (BizUtil.isBlank(syoubyoucd1) && !BizUtil.isBlank(syoubyoucd2)) {

            throw new BizLogicException(MessageId.EHA0075,
                MessageUtil.getMessage(DDID_KETTEI_SYOUBYOUCD2.getErrorResourceKey()));
        }

        if (!C_SyoubyoujyoutaiKbn.BLNK.eq(syoubyouJyoutaiKbn1) && BizUtil.isBlank(syoubyoucd1)) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_SYOUBYOUCD1.getErrorResourceKey()));
        }
        if (C_SyoubyoujyoutaiKbn.BLNK.eq(syoubyouJyoutaiKbn1) && !BizUtil.isBlank(syoubyoucd1)) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_KANTIYM1.getErrorResourceKey()) + "の傷病状態");
        }
        if (C_SyoubyoujyoutaiKbn.KANTI.eq(syoubyouJyoutaiKbn1) && kantiYm1 == null) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_KANTIYM1.getErrorResourceKey()));
        }
        if (!C_SyoubyoujyoutaiKbn.BLNK.eq(syoubyouJyoutaiKbn2) && BizUtil.isBlank(syoubyoucd2)) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_SYOUBYOUCD2.getErrorResourceKey()));
        }
        if (C_SyoubyoujyoutaiKbn.BLNK.eq(syoubyouJyoutaiKbn2) && !BizUtil.isBlank(syoubyoucd2)) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_KANTIYM2.getErrorResourceKey()) + "の傷病状態");
        }
        if (C_SyoubyoujyoutaiKbn.KANTI.eq(syoubyouJyoutaiKbn2) && kantiYm2 == null) {
            throw new BizLogicException(MessageId.EBC0043,
                MessageUtil.getMessage(DDID_KETTEI_KANTIYM2.getErrorResourceKey()));
        }

        BM_Syoubyou syoubyou = null;
        if (!BizUtil.isBlank(syoubyoucd1)) {
            syoubyou = bizDomManager.getSyoubyou(syoubyoucd1);
            if (syoubyou == null) {
                throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_KETTEI_SYOUBYOUCD1.getErrorResourceKey()));
            }
            syoubyouNm1 = syoubyou.getSyoubyounm();
        }
        if (!BizUtil.isBlank(syoubyoucd2)) {
            syoubyou = bizDomManager.getSyoubyou(syoubyoucd2);
            if (syoubyou == null) {
                throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_KETTEI_SYOUBYOUCD2.getErrorResourceKey()));
            }
            syoubyouNm2 = syoubyou.getSyoubyounm();
        }

        if (kantiYm1 != null && BizDateUtil.compareYm(BizDateYM.getSysDate(), kantiYm1) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EBA0026,
                MessageUtil.getMessage(DDID_KETTEI_KANTIYM1.getErrorResourceKey()));
        }
        if (kantiYm2 != null && BizDateUtil.compareYm(BizDateYM.getSysDate(), kantiYm2) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EBA0026,
                MessageUtil.getMessage(DDID_KETTEI_KANTIYM2.getErrorResourceKey()));
        }

        if (!C_SyorikekkaKbn.KANRYOU.eq(imuSyorikekkaKbn) && C_HubihassintnsKbn.ARI.eq(hubihassintnsKbn)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_IMUSATEI_HUBIHASSINTNS.getErrorResourceKey()));
        }

        if (!C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) && BizUtil.isBlank(knksateiIraiComment)) {
            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_KANKYOUSATEIIRAI_KNKSATEIIRAICOMMENT.getErrorResourceKey()));
        }
        else if (C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) && !BizUtil.isBlank(knksateiIraiComment)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_KANKYOUSATEIIRAI_KNKSATEIIRAICOMMENT.getErrorResourceKey()));
        }

        if (!C_SyorikekkaKbn.BLNK.eq(mostenkenKekkaKbn) && BizUtil.isBlank(mostenkenIraiComment)) {
            throw new BizLogicException(MessageId.EBC0045,
                MessageUtil.getMessage(DDID_MOUSHITENKENIRAI_MOSTENKENIRAICOMMENT.getErrorResourceKey()));
        }
        else if (C_SyorikekkaKbn.BLNK.eq(mostenkenKekkaKbn) && !BizUtil.isBlank(mostenkenIraiComment)) {
            throw new BizLogicException(MessageId.EBC0007,
                MessageUtil.getMessage(DDID_MOUSHITENKENIRAI_MOSTENKENIRAICOMMENT.getErrorResourceKey()));
        }
        else if ((C_SyorikekkaKbn.IRAI_TENKEN_1.eq(mostenkenKekkaKbn) ||
            C_SyorikekkaKbn.IRAI_TENKEN_2.eq(mostenkenKekkaKbn) ||
            C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(mostenkenKekkaKbn))
            && ((C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSyorikekkaKbn) ||
                C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSyorikekkaKbn))
                || (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knksateiKekkaKbn) ||
                    C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knksateiKekkaKbn) ||
                    C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knksateiKekkaKbn)))) {
            throw new BizLogicException(MessageId.EHA1016);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon == null) {
            throw new CommonBizAppException(MOSNO_EQ + mosNo);
        }

        if (!BizUtil.isBlank(ketRiyuuCd1)) {
            uiBean.setKetteiriyuunaiyou1(C_Ketriyuucd.valueOf(ketRiyuuCd1));
        }
        else {
            uiBean.setKetteiriyuunaiyou1(C_Ketriyuucd.BLNK);
        }

        if (!BizUtil.isBlank(ketRiyuuCd2)) {
            uiBean.setKetteiriyuunaiyou2(C_Ketriyuucd.valueOf(ketRiyuuCd2));
        }
        else {
            uiBean.setKetteiriyuunaiyou2(C_Ketriyuucd.BLNK);
        }

        if (!BizUtil.isBlank(ketRiyuuCd3)) {
            uiBean.setKetteiriyuunaiyou3(C_Ketriyuucd.valueOf(ketRiyuuCd3));
        }
        else {
            uiBean.setKetteiriyuunaiyou3(C_Ketriyuucd.BLNK);
        }

        if (!BizUtil.isBlank(ketRiyuuCd4)) {
            uiBean.setKetteiriyuunaiyou4(C_Ketriyuucd.valueOf(ketRiyuuCd4));
        }
        else {
            uiBean.setKetteiriyuunaiyou4(C_Ketriyuucd.BLNK);
        }

        messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QAC0008, MessageUtil.getMessage(MessageId.QAC0008));

        uiBean.setSyoubyounm1(syoubyouNm1);
        uiBean.setSyoubyounm2(syoubyouNm2);

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
    }

    void pushmodoruBtnByConfirmBL() {
        continueLockProcess();
        addConversationMessage();

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
    }

    @Transactional
    void pushOKBL() {
        String mosNo = uiBean.getMosno();
        C_Ketkekkacd ketKekkaCd = uiBean.getKetkekkacd();
        C_SyorikekkaKbn imuSateiKekkaKbn = uiBean.getImusateikekkakbn();
        C_SyorikekkaKbn knkSateiKekkaKbn = uiBean.getKnksateikekkakbn();
        C_SyorikekkaKbn mostenkenKekkaKbn = uiBean.getMostenkenkekkakbn();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();

        continueLockProcess();

        int renNo;

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno(mosNo);
        if (imusateiRireki == null) {
            renNo = 1;
        }
        else {
            renNo = imusateiRireki.getRenno() + 1;
        }

        insSTImusateiRrk(syoriCTL, renNo);

        if (C_SyorikekkaKbn.KANRYOU.eq(imuSateiKekkaKbn) &&
            (C_Ketkekkacd.ENKI_SIJINASI.eq(ketKekkaCd) ||
                C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(ketKekkaCd))) {

            if (C_UmuKbn.ARI.eq(syoriCTL.getNyknnrkumu())) {
                syoriCTL.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SYOUMETU);
            }

            syoriCTL.setImusateirrkumu(C_UmuKbn.ARI);
            syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIZUMI);
            syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);
            syoriCTL.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
            syoriCTL.setSateizumiymd(BizDate.getSysDate());
            syoriCTL.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
            syoriCTL.setSrsyoriymd(BizDate.getSysDate());
            syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTL.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            int dakuhiKteiRenno;
            Integer maxDaguhiKteiRenno = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno(mosNo);
            if (maxDaguhiKteiRenno == null) {
                dakuhiKteiRenno = 1;
            }
            else {
                dakuhiKteiRenno = maxDaguhiKteiRenno + 1;
            }
            insDakuhiKetteitk(syoriCTL, dakuhiKteiRenno);

            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(BizDate.getSysDate());
            mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
            mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.debug(SKIMUSATEI);

            Henkin henkin = SWAKInjector.getInstance(Henkin.class);
            HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(0),
                C_Tuukasyu.BLNK, C_HenkinriyuuKbn.MIAWASEENKI);

            List<HT_SkDenpyoData> skDenpyoDataLst = henkinOutBean.getSkDenpyoDataList();

            SetMossykykyoteiymd setMossykykyoteiymd = SWAKInjector.getInstance(SetMossykykyoteiymd.class);
            HT_MosnoKanri mosnoKanri = setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(
                syoriCTL, BizDate.getSysDate(), baseUserInfo.getUserId());

            if (mosnoKanri == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }
            sinkeiyakuDomManager.update(syoriCTL);
            sinkeiyakuDomManager.update(mosnoKanri);
            if (skDenpyoDataLst.size() > 0) {
                sinkeiyakuDomManager.insert(skDenpyoDataLst);
            }
        }
        else {
            if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knkSateiKekkaKbn)
                || C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knkSateiKekkaKbn)
                || C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knkSateiKekkaKbn)) {

                int knksateiRirekiRenno;
                HT_KnksateiRireki knksateiRireki = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(mosNo);
                if (knksateiRireki != null) {
                    knksateiRirekiRenno = knksateiRireki.getRenno() + 1;
                }
                else {
                    knksateiRirekiRenno = 1;
                }

                insKnkSateiRirekitk(syoriCTL, knksateiRirekiRenno);
            }

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(mostenkenKekkaKbn)
                || C_SyorikekkaKbn.IRAI_TENKEN_2.eq(mostenkenKekkaKbn)
                || C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(mostenkenKekkaKbn)
                ) {

                int mostenkenRirekiRenNo;
                HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(mosNo);
                if (mostenkenRireki != null) {
                    mostenkenRirekiRenNo = mostenkenRireki.getRenno() + 1;
                }
                else {
                    mostenkenRirekiRenNo = 1;
                }

                insMosTenkenRirekitk(syoriCTL, mostenkenRirekiRenNo);
            }

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(mostenkenKekkaKbn)
                || C_SyorikekkaKbn.IRAI_TENKEN_2.eq(mostenkenKekkaKbn)
                || C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(mostenkenKekkaKbn)
                ) {
                syoriCTL.setMostenkenrrkumu(C_UmuKbn.ARI);
            }

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(mostenkenKekkaKbn)) {
                syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_1);
            }
            if (C_SyorikekkaKbn.IRAI_TENKEN_2.eq(mostenkenKekkaKbn)) {
                syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_2);
            }
            if (C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(mostenkenKekkaKbn)) {
                syoriCTL.setMostenkenjoukbn(C_MostenkenjyouKbn.TENKENMATI_HUBI);
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knkSateiKekkaKbn)
                || C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knkSateiKekkaKbn)
                || C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knkSateiKekkaKbn)) {
                syoriCTL.setKnkysateirrkumu(C_UmuKbn.ARI);
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knkSateiKekkaKbn)) {
                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_1);
            }
            if (C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knkSateiKekkaKbn)) {
                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2A);
            }
            if (C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knkSateiKekkaKbn)) {
                syoriCTL.setKnkysateijyoukbn(C_KnkysateijyouKbn.SATEIMATI_2B    );
            }

            if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imuSateiKekkaKbn)) {
                syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_UW);
            }
            if (C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imuSateiKekkaKbn)) {
                syoriCTL.setImusateijyoukbn(C_ImusateijyouKbn.SATEIMATI_KANI_MD);
            }
            syoriCTL.setImusateirrkumu(C_UmuKbn.ARI);
            syoriCTL.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            syoriCTL.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            HT_MosKihon mosKihon = null;
            mosKihon = syoriCTL.getMosKihon();

            if (mosKihon == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(
                uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
            if (gyoumuKouteiInfo == null) {
                throw new CommonBizAppException(MOSNO_EQ + mosNo);
            }

            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);

            if (C_SyorikekkaKbn.KANRYOU.eq(imuSateiKekkaKbn)) {
                mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
            }
            mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
            mosnaiCheckParam.setKinouID(kinou.getKinouId());
            mosnaiCheckParam.setSysDate(BizDate.getSysDate());
            mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
            mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
            mosnaiCheckParam.debug(SKIMUSATEI);

            mosnaiCheck.exec(mosnaiCheckParam);

            if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
                sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
            }

            String imusateiSijiNaiyou = "";
            List<HT_RuleHanteiMsg> ruleHanteiMsgList = null;

            ruleHanteiMsgList = mosnaiCheckParam.getDataSyoriControl().getRuleHanteiMsgsByRulehanteimsg(
                C_Rulehanteimsg.IMUSATEI);
            if (ruleHanteiMsgList.size() > 0) {
                imusateiSijiNaiyou = EditGamenString.editMessegeStringRule(ruleHanteiMsgList);
            }

            setUiBeanKekka(mosnaiCheckParam.getDataSyoriControl(), imusateiSijiNaiyou);

            sinkeiyakuDomManager.update(mosnaiCheckParam.getDataSyoriControl());

            if (mosnaiCheckParam.getMosnoKanri() != null) {
                sinkeiyakuDomManager.update(mosnaiCheckParam.getMosnoKanri());
            }

            bizDomManager.update(mosnaiCheckParam.getGyoumuKouteiInfo());
        }

        ArrayList<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);
        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo = SWAKInjector.getInstance(SkHubiMsgRenkeiInfo.class);
        skHubiMsgRenkeiInfo.setMosno(mosNo);
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);
        uiBean.setUniqueId(objStorageManager.save(skHubiMsgRenkeiInfo));

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));
        List<String> kekkaGmnMsgList = mosnaiCheckParam.getListKekkaGmnMsg();
        for (String msg : kekkaGmnMsgList) {
            msgOut.append(KAIGYOU).append(msg);
        }
        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());

        String kouteiLockKey = getKouteiLockKey();

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(uiBean.getVktifdisptasknm());
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(imuSateiKekkaKbn);
        skProcessForwardInBean.setSyoriComment(uiBean.getImusateicommentgamen());
        skProcessForwardInBean.setMostenkenkekkaKbn(uiBean.getMostenkenkekkakbn());
        skProcessForwardInBean.setKnksateikekkaKbn(uiBean.getKnksateikekkakbn());
        skProcessForwardInBean.setImusateikekkaKbn(uiBean.getImusateikekkakbn());
        skProcessForwardInBean.setImutnsketsyaCd(uiBean.getImutnsketsyacd());
        skProcessForwardInBean.setHubihassintnsKbn(uiBean.getHubihassintnskbn());

        SkProcessForwardImuSatei skProcessForwardImuSatei = SWAKInjector.getInstance(SkProcessForwardImuSatei.class);
        skProcessForwardImuSatei.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, getKouteiLockKey(), null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(
            mosnaiCheckParam.getDataSyoriControl(), uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(
                mosnaiCheckParam.getDataSyoriControl());

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

    String modoruBtnByInputcontentsBL() {
        unlockProcess();
        String seniSaki = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            seniSaki = FORWARDNAME_INIT;
        }
        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            seniSaki = FORWARDNAME_BACKTOWORKLIST;
        }
        return seniSaki;
    }

    String functionNameOnClickBL() {
        unlockProcess();
        String seniSaki = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            seniSaki = FORWARDNAME_INIT;
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            seniSaki = FORWARDNAME_BACKTOWORKLIST;
        }
        return seniSaki;
    }

    String syokiGamenhebtnOnClickBL() {
        String seniSaki = "";

        if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            seniSaki = FORWARDNAME_INIT;
        }
        else if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            seniSaki = FORWARDNAME_BACKTOWORKLIST;
        }
        return seniSaki;
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
    void callAjaxSyoubyouMei() throws IOException {
        HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        String pSyoubyouCd = request.getParameter(AJAXPARAM_SYOUBYOUCD);

        List<String> syoubyounmList = new ArrayList<>();

        if (!BizUtil.isBlank(pSyoubyouCd)) {
            BM_Syoubyou syoubyou = bizDomManager.getSyoubyou(pSyoubyouCd);

            if (syoubyou != null) {

                syoubyounmList.add(syoubyou.getSyoubyounm());
            }
            else {

                syoubyounmList.add("");
            }
        }
        else {

            syoubyounmList.add("");
        }
        String responseJson = JSON.encode(syoubyounmList);

        logger.debug("json形式確認");
        logger.debug(responseJson);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.close();
    }

    @SuppressWarnings("resource")
    void callAjaxKetteiRiyuuNaiyou() throws IOException {
        HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        String ketRiyuuCd = request.getParameter(POSTPARAM_KETTEIRIYUUCD);

        List<String> ketRiyuuNaiyouList = new ArrayList<>();

        if (!BizUtil.isBlank(ketRiyuuCd)) {

            String ketteiriyuunaiyou = C_Ketriyuucd.getContentByValue(C_Ketriyuucd.PATTERN_ITIRAN, ketRiyuuCd);

            if (!BizUtil.isBlank(ketteiriyuunaiyou)) {

                ketRiyuuNaiyouList.add(ketteiriyuunaiyou);
            }
            else {

                ketRiyuuNaiyouList.add("");
            }
        }
        else {

            ketRiyuuNaiyouList.add("");
        }

        String responseJson = JSON.encode(ketRiyuuNaiyouList);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.close();
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

    private void hanteiSyoriKahi(HT_SyoriCTL pSyoriCTL) {

        C_SeirituKbn seirituKbn;
        C_KetteiKbn ketteiJtKbn;
        C_UmuKbn mosNrkUmu;
        C_UmuKbn kthhbKbn;
        C_ImusateijyouKbn imusateiJyouKbn;

        seirituKbn = pSyoriCTL.getSeiritukbn();
        ketteiJtKbn = pSyoriCTL.getKetteikbn();
        mosNrkUmu = pSyoriCTL.getMosnrkumu();
        kthhbKbn = pSyoriCTL.getKthhbkbn();
        imusateiJyouKbn = pSyoriCTL.getImusateijyoukbn();

        uiBean.setSyoriCTL(pSyoriCTL);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(pSyoriCTL);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        BT_WariateHukaInfo wariateHukaInfo = bizDomManager.getWariateHukaInfo(
            uiBean.getBzWorkflowInfo().getKouteiKanriId(),
            ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU,
            uiBean.getBzWorkflowInfo().getJimuTetuzukiCd(),
            uiBean.getBzWorkflowInfo().getTaskId(),
            baseUserInfo.getUserId());

        if (wariateHukaInfo != null) {
            throw new BizLogicException(MessageId.EHA0304);
        }

        if (!C_SeirituKbn.NONE.eq(seirituKbn)) {
            throw new BizLogicException(MessageId.EBA0031, seirituKbn.getContent());
        }

        if (!C_KetteiKbn.NONE.eq(ketteiJtKbn) && !C_KetteiKbn.KETTEI_MATI.eq(ketteiJtKbn)) {
            throw new BizLogicException(MessageId.EBA0031, ketteiJtKbn.getContent());
        }

        if (C_UmuKbn.NONE.eq(mosNrkUmu)) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        if (C_UmuKbn.ARI.eq(kthhbKbn)) {
            throw new BizLogicException(MessageId.EHA1035);
        }

        if (!C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(imusateiJyouKbn)
            && !C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(imusateiJyouKbn)) {

            throw new BizLogicException(MessageId.EHA0302);
        }

        if (!ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW.equals(uiBean.getBzWorkflowInfo().getTaskId())
            && !ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD.equals(uiBean.getBzWorkflowInfo().getTaskId())) {
            throw new BizLogicException(MessageId.EBA0112);
        }

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);

        if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(imusateiJyouKbn)) {

            boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(),
                kinou.getKinouId(),
                C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString());

            if (!kengenFlag) {
                throw new BizLogicException(MessageId.EHA1073, IMUSATEI_KANI_UW);
            }

        }
        else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(imusateiJyouKbn)) {

            boolean kengenFlag = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                baseUserInfo.getUserId(),
                kinou.getKinouId(),
                C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.toString());

            if (!kengenFlag) {
                throw new BizLogicException(MessageId.EHA1073, IMUSATEI_KANI_MD);
            }
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());
        if (ketteiSya == null) {
            if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(imusateiJyouKbn)) {
                throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_UW);
            }
            else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(imusateiJyouKbn)) {
                throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_MD);
            }
        }
        else {
            if (C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(imusateiJyouKbn)) {

                if (!C_ImusateirankKbn.KANI_UW.eq(ketteiSya.getImusateirankkbn())
                    && !C_ImusateirankKbn.KANI_MD.eq(ketteiSya.getImusateirankkbn())) {

                    throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_UW);
                }
            }
            else if (C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(imusateiJyouKbn)) {

                if (!ketteiSya.getImusateirankkbn().eq(C_ImusateirankKbn.KANI_MD)) {

                    throw new BizLogicException(MessageId.EHA0303, IMUSATEI_KANI_MD);
                }
            }

        }

        BizCurrency hutuuSbs = getHutuuSbs(pSyoriCTL);

        if (ketteiSya.getImusateijygns().compareTo(hutuuSbs) < 0) {
            throw new BizLogicException(MessageId.EHA1014, hutuuSbs.toFormatString());
        }
    }

    private void setUiBean(
        HT_MosKihon pMosKihon,
        HT_SyoriCTL pSyoriCTL,
        String pImusateiSijiNaiyou,
        List<HT_ImusateiRireki> pImusateiRirekiList,
        List<HM_KetteiSya> pKetteiSyaList,
        List<HT_KnksateiRireki> pKnksateiRirekiList,
        List<HT_MostenkenRireki> pMostenkenRirekiList,
        HT_Houjyou pHoujyou,
        HT_Kokutisyo pKokutisyo) {

        C_KkthjyKbn kkthjyKbn;
        C_UmuKbn hubiUmuKbn;
        String senSijiNaiyou = "";

        ArrayList<ImuSateiRirekiDataSourceBean> imuSateiRrkDsBeanList = new ArrayList<>();
        ArrayList<KankyouSateiRirekiDataSourceBean> kankyouSateiRrkDsBeanList = new ArrayList<>();
        ArrayList<ToriatukaiTyuuiJouhouDataSourceBean> tratkityuiJouhouDsBeanList = new ArrayList<>();
        ArrayList<MoushiTenkenRirekiDataSourceBean> moushiTenkenRrkDsBeanLst = new ArrayList<>();
        ArrayList<SentakuJouhouDataSourceBean> sentakuJouhouDsBeanLst = new ArrayList<>();

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(uiBean.getMosno());
        SetKouteiInfo setKouteiInfo = SWAKInjector.getInstance(SetKouteiInfo.class);
        setKouteiInfo.exec(uiBean);
        SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
        setSyoruiInfoItiran.exec(uiBean, C_SyoruiInfoItiranHyoujiHouhouKbn.KINOU);

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkumu())) {
            kkthjyKbn = C_KkthjyKbn.HJYNRK_ARI;
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {
            kkthjyKbn = C_KkthjyKbn.KKTNRK_ARI;
        }
        else {
            kkthjyKbn = C_KkthjyKbn.NONE;
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())
            || C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())
            || C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {
            hubiUmuKbn = C_UmuKbn.ARI;
        }
        else {
            hubiUmuKbn = C_UmuKbn.NONE;
        }

        if (pImusateiRirekiList.size() != 0) {
            senSijiNaiyou = editSecurityKm.decode(
                pImusateiRirekiList.get(pImusateiRirekiList.size() - 1).getImusateicomment());
        }

        BizDate kykYmd;
        BizNumber height;
        BizNumber weight;

        if (pHoujyou != null) {
            kykYmd = pMosKihon.getKykymd();
            height = BizNumber.valueOf(pHoujyou.getSintyou());
            weight = BizNumber.valueOf(pHoujyou.getTaijyuu());
        }
        else if (pKokutisyo != null) {
            kykYmd = pMosKihon.getKykymd();
            height = BizNumber.valueOf(pKokutisyo.getSintyou());
            weight = BizNumber.valueOf(pKokutisyo.getTaijyuu());
        }

        else {
            kykYmd = null;
            height = BizNumber.ZERO;
            weight = BizNumber.ZERO;
        }

        BizNumber bmi;

        if (height.equals(BizNumber.ZERO) || weight.equals(BizNumber.ZERO)) {
            bmi = BizNumber.valueOf(0.0);
        }
        else {
            BizNumber height2 = null;
            BizNumber heihtKeisuu = BizNumber.valueOf(100);

            height = height.divide(heihtKeisuu, 2, RoundingMode.DOWN);

            height2 = height.multiply(height);

            bmi = weight.divide(height2, 1, RoundingMode.DOWN);

        }

        Integer hhknNen;
        if (kykYmd != null) {
            hhknNen = setNenrei.exec(kykYmd, pMosKihon.getHhknseiymd());
        }
        else {
            hhknNen = 0;
        }

        if (pImusateiRirekiList.size() != 0) {
            for (HT_ImusateiRireki imusateiRireki : pImusateiRirekiList) {
                ImuSateiRirekiDataSourceBean imuSateiRirekiDataSourceBean = new ImuSateiRirekiDataSourceBean();

                imuSateiRirekiDataSourceBean.setDispimusyoriymd(imusateiRireki.getSyoriYmd());
                imuSateiRirekiDataSourceBean.setDispimustktsyorinmkbn(imusateiRireki.getSateiketsyorinmkbn());
                imuSateiRirekiDataSourceBean.setDispimukekkakbn(imusateiRireki.getImusateikekkakbn());

                if (imusateiRireki.getKetteiSya() != null) {
                    imuSateiRirekiDataSourceBean.setDispimuktnm(imusateiRireki.getKetteiSya().getKetsyanm());
                } else {
                    imuSateiRirekiDataSourceBean.setDispimuktnm("");
                }
                String imusateiComment = editSecurityKm.decode(imusateiRireki.getImusateicomment());
                imuSateiRirekiDataSourceBean.setDispimucomment(
                    EditGamenString.editStringSbstr(imusateiComment, IMUCOMMENT_MAXKETA));

                imuSateiRrkDsBeanList.add(imuSateiRirekiDataSourceBean);
            }
        }
        else {
            ImuSateiRirekiDataSourceBean imuSateiRirekiDataSourceBean = new ImuSateiRirekiDataSourceBean();

            imuSateiRirekiDataSourceBean.setDispimusyoriymd(null);
            imuSateiRirekiDataSourceBean.setDispimustktsyorinmkbn(null);
            imuSateiRirekiDataSourceBean.setDispimukekkakbn(null);
            imuSateiRirekiDataSourceBean.setDispimuktnm("");
            imuSateiRirekiDataSourceBean.setDispimucomment("");

            imuSateiRrkDsBeanList.add(imuSateiRirekiDataSourceBean);
        }

        UserDefsList userDefsList = new UserDefsList();
        LabelValuePair labelValuePair;
        labelValuePair = new LabelValuePair();
        labelValuePair.setValue("");
        labelValuePair.setLabel("");
        userDefsList.add(labelValuePair);

        for (HM_KetteiSya ketteiSya : pKetteiSyaList) {
            labelValuePair = new LabelValuePair();

            labelValuePair.setValue(ketteiSya.getKetsyacd());
            labelValuePair.setLabel(ketteiSya.getKetsyanm());
            userDefsList.add(labelValuePair);
        }

        if (pKnksateiRirekiList.size() > 0) {
            for (HT_KnksateiRireki knksateiRireki : pKnksateiRirekiList) {
                KankyouSateiRirekiDataSourceBean kankyouSateiRirekiDataSourceBean = new KankyouSateiRirekiDataSourceBean();

                kankyouSateiRirekiDataSourceBean.setDispknksyoriymd(knksateiRireki.getSyoriYmd());
                kankyouSateiRirekiDataSourceBean.setDispknkstktsyorinmkbn(knksateiRireki.getSateiketsyorinmkbn());
                kankyouSateiRirekiDataSourceBean.setDispknkkekkakbn(knksateiRireki.getKnksateikekkakbn());

                if (knksateiRireki.getKetteiSya() != null) {
                    kankyouSateiRirekiDataSourceBean.setDispknkktnm(knksateiRireki.getKetteiSya().getKetsyanm());
                } else {
                    kankyouSateiRirekiDataSourceBean.setDispknkktnm("");
                }
                String knksateiComment = editSecurityKm.decode(knksateiRireki.getKnksateicomment());
                kankyouSateiRirekiDataSourceBean.setDispknkcomment(
                    EditGamenString.editStringSbstr(knksateiComment, IMUCOMMENT_MAXKETA));

                kankyouSateiRrkDsBeanList.add(kankyouSateiRirekiDataSourceBean);
            }
        }
        else {
            KankyouSateiRirekiDataSourceBean kankyouSateiRirekiDataSourceBean = new KankyouSateiRirekiDataSourceBean();

            kankyouSateiRirekiDataSourceBean.setDispknksyoriymd(null);
            kankyouSateiRirekiDataSourceBean.setDispknkstktsyorinmkbn(null);
            kankyouSateiRirekiDataSourceBean.setDispknkkekkakbn(null);
            kankyouSateiRirekiDataSourceBean.setDispknkktnm("");
            kankyouSateiRirekiDataSourceBean.setDispknkcomment("");

            kankyouSateiRrkDsBeanList.add(kankyouSateiRirekiDataSourceBean);

        }

        if (pMostenkenRirekiList.size() > 0) {
            for (HT_MostenkenRireki mostenkenRireki : pMostenkenRirekiList) {

                MoushiTenkenRirekiDataSourceBean moushiTenkenRirekiDataSourceBean =
                    SWAKInjector.getInstance(MoushiTenkenRirekiDataSourceBean.class);

                moushiTenkenRirekiDataSourceBean.setDispmostenkensyoriymd(mostenkenRireki.getSyoriYmd());
                moushiTenkenRirekiDataSourceBean.setDispmostnknstktsyorinmkbn(mostenkenRireki.getSateiketsyorinmkbn());
                moushiTenkenRirekiDataSourceBean.setDispmostenkenkekkakbn(mostenkenRireki.getMostenkenkekkakbn());

                if (mostenkenRireki.getKetteiSya() != null) {
                    moushiTenkenRirekiDataSourceBean.setDispmostenkenktnm(mostenkenRireki.getKetteiSya().getKetsyanm());
                }
                else {
                    moushiTenkenRirekiDataSourceBean.setDispmostenkenktnm("");
                }
                String decode = editSecurityKm.decode(mostenkenRireki.getMostenkencomment());
                moushiTenkenRirekiDataSourceBean.setDispmostenkencomment(
                    EditGamenString.editStringSbstr(decode, IMUCOMMENT_MAXKETA));

                moushiTenkenRrkDsBeanLst.add(moushiTenkenRirekiDataSourceBean);
            }
        }
        else {
            MoushiTenkenRirekiDataSourceBean moushiTenkenRirekiDataSourceBean =
                SWAKInjector.getInstance(MoushiTenkenRirekiDataSourceBean.class);

            moushiTenkenRirekiDataSourceBean.setDispmostenkensyoriymd(null);
            moushiTenkenRirekiDataSourceBean.setDispmostnknstktsyorinmkbn(null);
            moushiTenkenRirekiDataSourceBean.setDispmostenkenkekkakbn(null);
            moushiTenkenRirekiDataSourceBean.setDispmostenkenktnm("");
            moushiTenkenRirekiDataSourceBean.setDispmostenkencomment("");

            moushiTenkenRrkDsBeanLst.add(moushiTenkenRirekiDataSourceBean);
        }

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst = getSkTtdkTyuui.getTtdkTyuui(
            uiBean.getMosno(), C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        if (skTtdkTyuuiLst != null) {
            for (HT_SkTtdkTyuui skTtdkTyuui : skTtdkTyuuiLst) {
                ToriatukaiTyuuiJouhouDataSourceBean toriatukaiTyuuiJouhouDataSourceBean =
                    SWAKInjector.getInstance(ToriatukaiTyuuiJouhouDataSourceBean.class);

                String skeiTtdktyuuiNaiyou = editSecurityKm.decode(skTtdkTyuui.getSkeittdktyuuinaiyou());

                toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrtnaiyo(skeiTtdktyuuiNaiyou);
                toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttrkymd(skTtdkTyuui.getTrkymd());

                AM_User user =  baseDomManager.getUser(skTtdkTyuui.getGyoumuKousinsyaId());
                if(user != null) {
                    toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttantou(user.getUserNm());

                }else {
                    toriatukaiTyuuiJouhouDataSourceBean.setDispskeittdktyuitrttantou("");
                }

                tratkityuiJouhouDsBeanList.add(toriatukaiTyuuiJouhouDataSourceBean);
            }
        }

        List<HT_SentakuJyouhou> sentakuJyouhouLst = pSyoriCTL.getSentakuJyouhous();
        SortHT_SentakuJyouhou sortHT_SentakuJyouhou = SWAKInjector.getInstance(SortHT_SentakuJyouhou.class);
        sentakuJyouhouLst = sortHT_SentakuJyouhou.OrderHT_SentakuJyouhouBySntkinfotaisyousyakbnSntkinfonoSyscdkbnAsc(
            sentakuJyouhouLst);

        if (sentakuJyouhouLst.size() > 0) {
            for (HT_SentakuJyouhou sentakuJyouhou : sentakuJyouhouLst) {
                String sntkinfoSyubetu = editSntkinfoSyubetu(sentakuJyouhou);

                if (!C_SntkInfoTaisyousyaKbn.HIHOKENSYA.eq(sentakuJyouhou.getSntkinfotaisyousyakbn())
                    || sntkinfoSyubetu == null || sntkinfoSyubetu.length() == 0) {
                    continue;
                }

                SentakuJouhouDataSourceBean sentakuJouhouDataSourceBean =
                    SWAKInjector.getInstance(SentakuJouhouDataSourceBean.class);

                sentakuJouhouDataSourceBean.setDispsntkinfotsysy(sentakuJyouhou.getSntkinfotaisyousyakbn());
                sentakuJouhouDataSourceBean.setDispsntkinfono(sentakuJyouhou.getSntkinfono());
                sentakuJouhouDataSourceBean.setDispsntkinfosyskbn(sentakuJyouhou.getSyscdkbn());
                sentakuJouhouDataSourceBean.setDispsntkinfosyubetu(sntkinfoSyubetu);

                sentakuJouhouDsBeanLst.add(sentakuJouhouDataSourceBean);
            }
        }

        uiBean.setHhknnmkj(pMosKihon.getHhknnmkj());
        uiBean.setBmi(bmi);
        uiBean.setHhknnen(hhknNen);
        uiBean.setHhknsei(pMosKihon.getHhknsei());
        uiBean.setMosnrkumu(pSyoriCTL.getMosnrkumu());
        uiBean.setKkthjykbn(kkthjyKbn);
        uiBean.setNyknnrkumu(pSyoriCTL.getNyknnrkumu());
        uiBean.setMostenkenjoukbn(pSyoriCTL.getMostenkenjoukbn());
        uiBean.setHubiumu(hubiUmuKbn);
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
        uiBean.setImusateisijinaiyou(pImusateiSijiNaiyou);
        uiBean.setZenimusateicomment(senSijiNaiyou);
        uiBean.setImuSateiRireki(imuSateiRrkDsBeanList);
        uiBean.setSentakuJouhou(sentakuJouhouDsBeanLst);
        uiBean.setToriatukaiTyuuiJouhou(tratkityuiJouhouDsBeanList);
        uiBean.setImutnsketsyacdOptionBeanList(userDefsList);
        uiBean.setKankyouSateiRireki(kankyouSateiRrkDsBeanList);
        uiBean.setMoushiTenkenRireki(moushiTenkenRrkDsBeanLst);
    }

    private void setUiBean_ZenSatei(List<HT_ImusateiRireki> pImusateiRirekiList, HT_MosKihon pMosKihon) {

        HT_ImusateiRireki imusateiRireki = null;

        imusateiRireki = pImusateiRirekiList.get(pImusateiRirekiList.size() - 1);

        if ((C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(imusateiRireki.getImusateikekkakbn())
            || C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(imusateiRireki.getImusateikekkakbn())
            || C_SyorikekkaKbn.HORYUU.eq(imusateiRireki.getImusateikekkakbn()))
            && (C_SateiketsyorinmKbn.IMUSATEI_KANI_UW.eq(imusateiRireki.getSateiketsyorinmkbn())
                || C_SateiketsyorinmKbn.IMUSATEI_KANI_MD.eq(imusateiRireki.getSateiketsyorinmkbn()))) {

            uiBean.setKetkekkacd(imusateiRireki.getKetkekkacd());
            if (!C_Ketriyuucd.BLNK.eq(imusateiRireki.getKetriyuucd1())) {
                uiBean.setKetriyuucd1gamen(imusateiRireki.getKetriyuucd1().getValue());
            }

            if (!C_Ketriyuucd.BLNK.eq(imusateiRireki.getKetriyuucd2())) {
                uiBean.setKetriyuucd2gamen(imusateiRireki.getKetriyuucd2().getValue());
            }

            if (!C_Ketriyuucd.BLNK.eq(imusateiRireki.getKetriyuucd3())) {
                uiBean.setKetriyuucd3gamen(imusateiRireki.getKetriyuucd3().getValue());
            }

            if (!C_Ketriyuucd.BLNK.eq(imusateiRireki.getKetriyuucd4())) {
                uiBean.setKetriyuucd4gamen(imusateiRireki.getKetriyuucd4().getValue());
            }
            uiBean.setSyoubyoucd1(imusateiRireki.getSyoubyoucd1());
            uiBean.setSyoubyoujyoutaikbn1(imusateiRireki.getSyoubyoujyoutaikbn1());
            uiBean.setKantiym1(imusateiRireki.getKantiym1());
            uiBean.setSyoubyoucd2(imusateiRireki.getSyoubyoucd2());
            uiBean.setSyoubyoujyoutaikbn2(imusateiRireki.getSyoubyoujyoutaikbn2());
            uiBean.setKantiym2(imusateiRireki.getKantiym2());
            uiBean.setSntkinfosakuseiyhkbn(imusateiRireki.getSntkinfosakuseiyhkbn());
        }
    }

    private void insSTImusateiRrk(HT_SyoriCTL pSyoriCTL, int pRenNo) {

        String mosNo = uiBean.getMosno();

        C_SateiketsyorinmKbn sateiketSyorinmKbn = null;
        if (C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString().equals(kinouMode.getKinouMode())) {
            sateiketSyorinmKbn = C_SateiketsyorinmKbn. IMUSATEI_KANI_UW;
        }
        else {
            sateiketSyorinmKbn = C_SateiketsyorinmKbn. IMUSATEI_KANI_MD;
        }

        String tnsketsyacd;
        if (C_SyorikekkaKbn.TENSOU_IMU_KANIUW.eq(uiBean.getImusateikekkakbn())
            || C_SyorikekkaKbn.TENSOU_IMU_KANIMD.eq(uiBean.getImusateikekkakbn())) {
            tnsketsyacd = uiBean.getImutnsketsyacd();
        }
        else if (C_SyorikekkaKbn.HORYUU.eq(uiBean.getImusateikekkakbn())) {
            tnsketsyacd = baseUserInfo.getUserId();
        }
        else {
            tnsketsyacd = "";
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        String imusateiComment = EditSecurityKm.getEncodeData(mosNo, uiBean.getImusateicommentgamen());

        C_Ketriyuucd ketriyuuCd1 = C_Ketriyuucd.BLNK;
        C_Ketriyuucd ketriyuuCd2 = C_Ketriyuucd.BLNK;
        C_Ketriyuucd ketriyuuCd3 = C_Ketriyuucd.BLNK;
        C_Ketriyuucd ketriyuuCd4 = C_Ketriyuucd.BLNK;

        if (!BizUtil.isBlank(uiBean.getKetriyuucd1gamen())) {
            ketriyuuCd1 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd1gamen());
        }
        if (!BizUtil.isBlank(uiBean.getKetriyuucd2gamen())) {
            ketriyuuCd2 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd2gamen());
        }
        if (!BizUtil.isBlank(uiBean.getKetriyuucd3gamen())) {
            ketriyuuCd3 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd3gamen());
        }
        if (!BizUtil.isBlank(uiBean.getKetriyuucd4gamen())) {
            ketriyuuCd4 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd4gamen());
        }

        HT_ImusateiRireki imusateiRireki = pSyoriCTL.createImusateiRireki();

        imusateiRireki.setRenno(pRenNo);
        imusateiRireki.setSyoriYmd(BizDate.getSysDate());
        imusateiRireki.setSateiketsyorinmkbn(sateiketSyorinmKbn);
        imusateiRireki.setImusateikekkakbn(uiBean.getImusateikekkakbn());
        imusateiRireki.setTnsketsyacd(tnsketsyacd);
        imusateiRireki.setKetsyacd(baseUserInfo.getUserId());
        imusateiRireki.setPalketsyacd(ketteiSya.getPalketsyacd());
        imusateiRireki.setImusateicomment(imusateiComment);
        imusateiRireki.setKetkekkacd(uiBean.getKetkekkacd());
        imusateiRireki.setKetriyuucd1(ketriyuuCd1);
        imusateiRireki.setKetriyuucd2(ketriyuuCd2);
        imusateiRireki.setKetriyuucd3(ketriyuuCd3);
        imusateiRireki.setKetriyuucd4(ketriyuuCd4);
        imusateiRireki.setSyoubyoucd1(uiBean.getSyoubyoucd1());
        imusateiRireki.setSyoubyoujyoutaikbn1(uiBean.getSyoubyoujyoutaikbn1());
        imusateiRireki.setKantiym1(uiBean.getKantiym1());
        imusateiRireki.setSyoubyoucd2(uiBean.getSyoubyoucd2());
        imusateiRireki.setSyoubyoujyoutaikbn2(uiBean.getSyoubyoujyoutaikbn2());
        imusateiRireki.setKantiym2(uiBean.getKantiym2());
        imusateiRireki.setSntkinfosakuseiyhkbn(uiBean.getSntkinfosakuseiyhkbn());
        imusateiRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        imusateiRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli())       ;

        BizPropertyInitializer.initialize(imusateiRireki);
    }

    private void insDakuhiKetteitk(HT_SyoriCTL pSyoriCTL, int pRenNo) {

        C_Ketriyuucd ketriyuuCd1 = C_Ketriyuucd.BLNK;
        C_Ketriyuucd ketriyuuCd2 = C_Ketriyuucd.BLNK;
        C_Ketriyuucd ketriyuuCd3 = C_Ketriyuucd.BLNK;
        C_Ketriyuucd ketriyuuCd4 = C_Ketriyuucd.BLNK;

        if (!BizUtil.isBlank(uiBean.getKetriyuucd1gamen())) {
            ketriyuuCd1 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd1gamen());
        }
        if (!BizUtil.isBlank(uiBean.getKetriyuucd2gamen())) {
            ketriyuuCd2 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd2gamen());
        }
        if (!BizUtil.isBlank(uiBean.getKetriyuucd3gamen())) {
            ketriyuuCd3 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd3gamen());
        }
        if (!BizUtil.isBlank(uiBean.getKetriyuucd4gamen())) {
            ketriyuuCd4 = C_Ketriyuucd.valueOf(uiBean.getKetriyuucd4gamen());
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        HT_DakuhiKettei dakuhiKettei = pSyoriCTL.createDakuhiKettei();

        dakuhiKettei.setDakuhiktrenno(pRenNo);
        dakuhiKettei.setKetymd(BizDate.getSysDate());
        dakuhiKettei.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.DAKUHIKETTEI);
        dakuhiKettei.setKetkekkacd(uiBean.getKetkekkacd());
        dakuhiKettei.setKetriyuucd1(ketriyuuCd1);
        dakuhiKettei.setKetriyuucd2(ketriyuuCd2);
        dakuhiKettei.setKetriyuucd3(ketriyuuCd3);
        dakuhiKettei.setKetriyuucd4(ketriyuuCd4);
        dakuhiKettei.setSyoubyoucd1(uiBean.getSyoubyoucd1());
        dakuhiKettei.setSyoubyoujyoutaikbn1(uiBean.getSyoubyoujyoutaikbn1());
        dakuhiKettei.setKantiym1(uiBean.getKantiym1());
        dakuhiKettei.setSyoubyoucd2(uiBean.getSyoubyoucd2());
        dakuhiKettei.setSyoubyoujyoutaikbn2(uiBean.getSyoubyoujyoutaikbn2());
        dakuhiKettei.setKantiym2(uiBean.getKantiym2());
        dakuhiKettei.setKetsyacd(baseUserInfo.getUserId());
        dakuhiKettei.setPalketsyacd(ketteiSya.getPalketsyacd());
        dakuhiKettei.setTkjysydksyhykbn(C_TkjysydksyhyKbn.BLNK);
        dakuhiKettei.setSntkinfosakuseiyhkbn(uiBean.getSntkinfosakuseiyhkbn());
        dakuhiKettei.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
        dakuhiKettei.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        dakuhiKettei.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(dakuhiKettei);
    }

    private void insKnkSateiRirekitk(HT_SyoriCTL pSyoriCTL, int pRenNo) {

        C_SateiketsyorinmKbn sateiketsyorinmKbn = null;
        if (C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString().equals(kinouMode.getKinouMode())) {
            sateiketsyorinmKbn = C_SateiketsyorinmKbn.IMUSATEI_KANI_UW;
        }
        else {
            sateiketsyorinmKbn = C_SateiketsyorinmKbn.IMUSATEI_KANI_MD;
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        String knkSateiComment = EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getKnksateiiraicomment());

        HT_KnksateiRireki knksateiRireki = pSyoriCTL.createKnksateiRireki();
        knksateiRireki.setRenno(pRenNo);
        knksateiRireki.setSyoriYmd(BizDate.getSysDate());
        knksateiRireki.setSateiketsyorinmkbn(sateiketsyorinmKbn);
        knksateiRireki.setKnksateikekkakbn(uiBean.getKnksateikekkakbn());
        knksateiRireki.setKetsyacd(baseUserInfo.getUserId());
        knksateiRireki.setPalketsyacd(ketteiSya.getPalketsyacd());
        knksateiRireki.setKnksateicomment(knkSateiComment);
        knksateiRireki.setKetkekkacd(C_Ketkekkacd.BLNK);
        knksateiRireki.setKetriyuucd1(C_Ketriyuucd.BLNK);
        knksateiRireki.setKetriyuucd2(C_Ketriyuucd.BLNK);
        knksateiRireki.setKetriyuucd3(C_Ketriyuucd.BLNK);
        knksateiRireki.setKetriyuucd4(C_Ketriyuucd.BLNK);
        knksateiRireki.setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd.BLNK);
        knksateiRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        knksateiRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(knksateiRireki);
    }

    private void insMosTenkenRirekitk(HT_SyoriCTL pSyoriCTL, int pRenNo) {

        C_SateiketsyorinmKbn sateiketsyorinmKbn = null;
        if (C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.toString().equals(kinouMode.getKinouMode())) {
            sateiketsyorinmKbn = C_SateiketsyorinmKbn.IMUSATEI_KANI_UW;
        }
        else {
            sateiketsyorinmKbn = C_SateiketsyorinmKbn.IMUSATEI_KANI_MD;
        }

        HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(baseUserInfo.getUserId());

        String mostenkeniraiComment = EditSecurityKm.getEncodeData(uiBean.getMosno(), uiBean.getMostenkeniraicomment());

        HT_MostenkenRireki mostenkenRireki = pSyoriCTL.createMostenkenRireki();
        mostenkenRireki.setRenno(pRenNo);
        mostenkenRireki.setSyoriYmd(BizDate.getSysDate());
        mostenkenRireki.setSateiketsyorinmkbn(sateiketsyorinmKbn);
        mostenkenRireki.setMostenkenkekkakbn(uiBean.getMostenkenkekkakbn());
        mostenkenRireki.setKetsyacd(baseUserInfo.getUserId());
        mostenkenRireki.setPalketsyacd(ketteiSya.getPalketsyacd());
        mostenkenRireki.setMostenkencomment(mostenkeniraiComment);
        mostenkenRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        mostenkenRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(mostenkenRireki);
    }

    private void setUiBeanKekka(HT_SyoriCTL pSyoriCTL, String pImusateiSijiNaiyou) {

        C_KkthjyKbn kkthjyKbn = null;
        C_UmuKbn hubiUmu = null;

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getHjynrkhbumu())) {
            kkthjyKbn = C_KkthjyKbn.HJYNRK_ARI;
        }
        else if (C_UmuKbn.ARI.eq(pSyoriCTL.getKktnrkumu())) {
            kkthjyKbn = C_KkthjyKbn.KKTNRK_ARI;
        }
        else {
            kkthjyKbn = C_KkthjyKbn.NONE;
        }

        if (C_UmuKbn.ARI.eq(pSyoriCTL.getKthhbkbn())
            || C_UmuKbn.ARI.eq(pSyoriCTL.getSrhhbkbn())
            || C_UmuKbn.ARI.eq(pSyoriCTL.getKhnhbkbn())) {
            hubiUmu = C_UmuKbn.ARI;
        }
        else {
            hubiUmu = C_UmuKbn.NONE;
        }

        uiBean.setMosnrkumu(pSyoriCTL.getMosnrkumu());
        uiBean.setKkthjykbn(kkthjyKbn);
        uiBean.setNyknnrkumu(pSyoriCTL.getNyknnrkumu());
        uiBean.setMostenkenjoukbn(pSyoriCTL.getMostenkenjoukbn());
        uiBean.setHubiumu(hubiUmu);
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
        uiBean.setImusateisijinaiyou(pImusateiSijiNaiyou);
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

    private String editSntkinfoSyubetu(HT_SentakuJyouhou pSentakuJyouhou) {

        String sntkinfoSyubetu = "";

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getDecumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getHuho2decumukbn())) {
            if (BizUtil.isBlank(sntkinfoSyubetu)) {
                sntkinfoSyubetu = SNTKINFOSYUBETU_DECARI;
            }
            else {
                sntkinfoSyubetu = sntkinfoSyubetu + SNTKINFOSYUBETU_RENKTMJRT + SNTKINFOSYUBETU_DECARI;
            }
        }

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getNyuuinkyhkshrumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getSyujyutukyhkshrumukbn())) {
            if (BizUtil.isBlank(sntkinfoSyubetu)) {
                sntkinfoSyubetu = SNTKINFOSYUBETU_NISJARI;
            }
            else {
                sntkinfoSyubetu = sntkinfoSyubetu + SNTKINFOSYUBETU_RENKTMJRT + SNTKINFOSYUBETU_NISJARI;
            }
        }

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getPmenumukbn())) {
            if (BizUtil.isBlank(sntkinfoSyubetu)) {
                sntkinfoSyubetu = SNTKINFOSYUBETU_PMENARI;
            }
            else {
                sntkinfoSyubetu = sntkinfoSyubetu + SNTKINFOSYUBETU_RENKTMJRT + SNTKINFOSYUBETU_PMENARI;
            }
        }

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getTorikaijoumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getHuho2torikaijoumukbn())) {
            if (BizUtil.isBlank(sntkinfoSyubetu)) {
                sntkinfoSyubetu = SNTKINFOSYUBETU_TORIKJARI;
            }
            else {
                sntkinfoSyubetu = sntkinfoSyubetu + SNTKINFOSYUBETU_RENKTMJRT + SNTKINFOSYUBETU_TORIKJARI;
            }
        }

        if (C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getSyougaikyhkshrumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getSoukikeakyhkshrumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getSonotakyhkshrumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getKghsjjtkyhkshrumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getKoudosyougaiumukbn())
            || C_BlnktkumuKbn.ARI.eq(pSentakuJyouhou.getHuho2kdumukbn())) {
            if (BizUtil.isBlank(sntkinfoSyubetu)) {
                sntkinfoSyubetu = SNTKINFOSYUBETU_SZNKYFARI;
            }
            else {
                sntkinfoSyubetu = sntkinfoSyubetu + SNTKINFOSYUBETU_RENKTMJRT + SNTKINFOSYUBETU_SZNKYFARI;
            }
        }

        return sntkinfoSyubetu;
    }

    private BizCurrency getHutuuSbs(HT_SyoriCTL pSyoriCTL) {
        mosnaiCheckParam.setDataSyoriControl(pSyoriCTL);
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setSysDate(BizDate.getSysDate());
        mosnaiCheckParam.setKosID(baseUserInfo.getUserId());
        mosnaiCheckParam.setKosTime(BizDate.getSysDateTimeMilli());
        SetHutuuSibouS setHutuuSibouS = SWAKInjector.getInstance(SetHutuuSibouS.class);
        BizCurrency hutuuSbs = setHutuuSibouS.exec(mosnaiCheckParam);

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);
        BizCurrency hutuuSibouSKansan = getKiteiCheckYenkansangk.exec(pSyoriCTL.getMosKihon().getMosymd(),
            hutuuSbs, pSyoriCTL.getMosKihon().getKyktuukasyu());

        return hutuuSibouSKansan;
    }

    private boolean hanteiKetRiyuuNrKahi(C_Ketkekkacd pKetkekkacd, String pKetriyuucd) {
        if (C_Ketkekkacd.MUJYOUKEN.eq(pKetkekkacd)) {
            if (!BizUtil.isBlank(pKetriyuucd)) {
                return false;
            }
            return true;
        }
        else if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(pKetkekkacd)) {
            if (C_Ketriyuucd.HHKN_DOUTOKUHUAN.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.HHKN_SYOKUGYOU.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.KYK_DOUTOKUHUAN.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.KYK_SYOKUGYOU.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.ZENINDOUTOKUHUAN.toString().equals(pKetriyuucd)) {
                return false;
            }
            return true;
        }
        else {
            if (C_Ketriyuucd.HHKN_DOUTOKUHUAN.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.HHKN_SYOKUGYOU.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.KYK_DOUTOKUHUAN.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.KYK_SYOKUGYOU.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.DOUGAKUTOKUNIN.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.SISYAHOUKOKU.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.ZENINDOUTOKUHUAN.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.KYKKANKEI.toString().equals(pKetriyuucd)
                || C_Ketriyuucd.NAIKI.toString().equals(pKetriyuucd)) {
                return false;
            }
            return true;
        }
    }

    private boolean hanteiKetRiyuuNr(C_Ketkekkacd pKetkekkacd,
        String pKetriyuucd1,
        String pKetriyuucd2,
        String pKetriyuucd3,
        String pKetriyuucd4) {

        List<String> ketkekkaCdLst = new ArrayList<>();
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_TAIKAKU.getValue());
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_GENSYOU.getValue());
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_KIOUSYOU.getValue());
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_NINSIN.getValue());
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_TOUSYAKIOUSYOU.getValue());
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_BOSITETYOUSYOKEN.getValue());
        ketkekkaCdLst.add(C_Ketriyuucd.HHKN_TOUSYAKYUUHUREKI.getValue());

        if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(pKetkekkacd)
            || C_Ketkekkacd.ENKI_SIJINASI.eq(pKetkekkacd)
            || C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(pKetkekkacd)) {
            if (ketkekkaCdLst.contains(pKetriyuucd1)
                || ketkekkaCdLst.contains(pKetriyuucd2)
                || ketkekkaCdLst.contains(pKetriyuucd3)
                || ketkekkaCdLst.contains(pKetriyuucd4)) {
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean chkKbnValue(String pKetriyuucd) {

        DisplayItem<C_Ketriyuucd>[] displayItems =
            Classification.getDisplayItems(C_Ketriyuucd.class, C_Ketriyuucd.PATTERN_ITIRAN);

        boolean sonzaiFlg = false;
        for (int index = 0; index < displayItems.length; index++) {
            if (displayItems[index].getClassification().getValue().equals(pKetriyuucd)) {
                sonzaiFlg = true;
                break;
            }
        }

        return sonzaiFlg;
    }
}
