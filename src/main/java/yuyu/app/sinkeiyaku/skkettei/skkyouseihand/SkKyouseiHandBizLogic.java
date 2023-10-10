package yuyu.app.sinkeiyaku.skkettei.skkyouseihand;

import static yuyu.app.sinkeiyaku.skkettei.skkyouseihand.SkKyouseiHandConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

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
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardKyouseiHand;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SetHutuuSibouS;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SonotaTkykJktk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_SyouhnTokujyou;
import yuyu.def.db.entity.HT_Tokujyou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 強制ハンド決定入力 のビジネスロジックです。
 */
public class SkKyouseiHandBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkKyouseiHandUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo;

    @Inject
    private MessageManager messageManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private MosnaiCheck mosnaiCheck;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HubiMsgEdit hubiMsgEdit;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

    @Inject
    private SetHutuuSibouS setHutuuSibouS;

    @Inject
    private ObjStorageManager objStrMan;

    @Inject
    private SkProcessForwardKyouseiHand skProcessForwardKyouseiHand;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private SkProcessUpdate skProcessUpdate;

    void init() {

        C_MostenkenRankKbn[] mosteneknRankKbn = {C_MostenkenRankKbn.ITIJI, C_MostenkenRankKbn. NIJI,C_MostenkenRankKbn.HUBI};
        List<HM_KetteiSya> mosKetteiSyaLst =
            sinkeiyakuDomManager.getKetteiSyasByKetsyacdMostenkenrankkbns(baseUserInfo.getUser().getUserId(), mosteneknRankKbn);

        UserDefsList mosUserDefsList = editTensousakiList(mosKetteiSyaLst);

        List<HM_KetteiSya> knkKetteiSyaLst =
            sinkeiyakuDomManager.getKetteiSyasByKetsyacdKnksateirankkbns(baseUserInfo.getUser().getUserId(),
                C_KnksateirankKbn.ITIJI, C_KnksateirankKbn.NIJIA, C_KnksateirankKbn.NIJIB);

        UserDefsList knkUserDefsList = editTensousakiList(knkKetteiSyaLst);

        List<HM_KetteiSya> imuKetteiSyaList =
            sinkeiyakuDomManager.getKetteiSyasByKetsyacdImusateirankkbns(baseUserInfo.getUser().getUserId(),
                C_ImusateirankKbn.KANI_UW, C_ImusateirankKbn.KANI_MD);

        UserDefsList imuUserDefsList = editTensousakiList(imuKetteiSyaList);

        uiBean.setMostenkentnsketsyacd("");
        uiBean.setMostenkentnsketsyacdOptionBeanList(mosUserDefsList);
        uiBean.setKnktnsketsyacd("");
        uiBean.setKnktnsketsyacdOptionBeanList(knkUserDefsList);
        uiBean.setImutnsketsyacd("");
        uiBean.setImutnsketsyacdOptionBeanList(imuUserDefsList);
    }

    void clear() {
    }

    void pushUpdBL() {

        BizPropertyInitializer.initialize(uiBean);

        String          mosNo               = uiBean.getMosno();

        C_SyorikekkaKbn mostenkenKekkaKbn   = uiBean.getMostenkenkekkakbn();
        String          mostenkenTnsketsya  = uiBean.getMostenkentnsketsyacd();
        String          mostenkenComment    = uiBean.getMostenkencommentgamen();

        C_SyorikekkaKbn knksateiKekkaKbn    = uiBean.getKnksateikekkakbn();
        String          knkTnsketsyacd      = uiBean.getKnktnsketsyacd();
        String          knkSateiIraiComment = uiBean.getKnksateiiraicomment();

        C_SyorikekkaKbn imuSateiKekkaKbn    = uiBean.getImusateikekkakbn();
        String          imuTnsketsyacd      = uiBean.getImutnsketsyacd();
        String          imuSateiIraiComment = uiBean.getImusateiiraicomment();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo);
        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);

        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn()) && !C_SeirituKbn.ITIPMATI.eq(syoriCTL.getSeiritukbn())) {

            throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
        }

        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {

            throw new BizLogicException(MessageId.EHA0027);
        }

        if(!C_SyorikekkaKbn.BLNK.eq(mostenkenKekkaKbn)){

            if(C_MostenkenjyouKbn.TENKENMATI_1.eq(syoriCTL.getMostenkenjoukbn())
                || C_MostenkenjyouKbn.TENKENMATI_2.eq(syoriCTL.getMostenkenjoukbn())
                || C_MostenkenjyouKbn.TENKENMATI_HUBI.eq(syoriCTL.getMostenkenjoukbn())){

                throw new BizLogicException(MessageId.EHA1019, ERRMESSAGE_MOSTENKENTYUU);
            }

            if(BizUtil.isBlank(mostenkenTnsketsya)){
                throw new BizLogicException(MessageId.EHA1032);
            }

            if (BizUtil.isBlank(mostenkenComment)) {
                throw new BizLogicException(MessageId.EBC0045, ERRMESSAGE_MOSTENKENCOMMENT);
            }

            if(!C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn)
                || !C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn)){
                throw new BizLogicException(MessageId.EHA1016);
            }

        }else{
            if (!BizUtil.isBlank(mostenkenComment)) {
                throw new BizLogicException(MessageId.EBC0007, ERRMESSAGE_MOSTENKENCOMMENT);
            }

        }

        if ((C_KnkysateijyouKbn.SATEIMATI_1.eq(syoriCTL.getKnkysateijyoukbn())
            || C_KnkysateijyouKbn.SATEIMATI_2A.eq(syoriCTL.getKnkysateijyoukbn())
            || C_KnkysateijyouKbn.SATEIMATI_2B.eq(syoriCTL.getKnkysateijyoukbn()))
            && !C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn)) {

            throw new BizLogicException(MessageId.EHA1019, ERRMESSAGE_KNKSATEITYUU);
        }

        if (!C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) && BizUtil.isBlank(knkTnsketsyacd)) {

            throw new BizLogicException(MessageId.EHA1032);
        }

        if (!C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) && BizUtil.isBlank(knkSateiIraiComment)) {

            throw new BizLogicException(MessageId.EBC0045, ERRMESSAGE_KNKSATEIIRAICOMMENT);
        }

        if (C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) && !BizUtil.isBlank(knkSateiIraiComment)) {

            throw new BizLogicException(MessageId.EBC0007, ERRMESSAGE_KNKSATEIIRAICOMMENT);
        }

        if (!C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn)
            && (C_SntkhouKbn.NONE.eq(syoriCTL.getMosKihon().getSntkhoukbn())
                || C_SntkhouKbn.SYOKUGYOU.eq(syoriCTL.getMosKihon().getSntkhoukbn()))) {

            throw new BizLogicException(MessageId.EHA1063);
        }

        if ((C_ImusateijyouKbn.SATEIMATI_KANI_UW.eq(syoriCTL.getImusateijyoukbn())
            || C_ImusateijyouKbn.SATEIMATI_KANI_MD.eq(syoriCTL.getImusateijyoukbn()))
            && !C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn)) {

            throw new BizLogicException(MessageId.EHA1019, ERRMESSAGE_IMUSATEITYUU);
        }

        if (!C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn) && BizUtil.isBlank(imuTnsketsyacd)) {

            throw new BizLogicException(MessageId.EHA1032);
        }

        if (!C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn) && BizUtil.isBlank(imuSateiIraiComment)) {

            throw new BizLogicException(MessageId.EBC0045, ERRMESSAGE_IMUSATEIIRAICOMMENT);
        }

        if (C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn) && !BizUtil.isBlank(imuSateiIraiComment)) {

            throw new BizLogicException(MessageId.EBC0007, ERRMESSAGE_IMUSATEIIRAICOMMENT);
        }


        if (!BizUtil.isBlank(mostenkenTnsketsya)
            && !ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(mostenkenTnsketsya)) {
            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

            if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(mostenkenKekkaKbn)) {

                boolean kinouMOdeChkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(mostenkenTnsketsya, KINOUID_SKMOUSIKOMITENKEN, C_SkkinouModeIdKbn.MOSTENKEN_1JI.getValue());
                if (!kinouMOdeChkKekka) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_MOSTENKEN1);
                }
                boolean taskChkKekka = checkTaskKengen.exec(mostenkenTnsketsya,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_1JI);

                if(!taskChkKekka){
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_MOSTENKEN1);
                }

            }else if (C_SyorikekkaKbn.IRAI_TENKEN_2.eq(mostenkenKekkaKbn)){

                boolean kinouMOdeChkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(mostenkenTnsketsya, KINOUID_SKMOUSIKOMITENKEN, C_SkkinouModeIdKbn.MOSTENKEN_2JI.getValue());

                if (!kinouMOdeChkKekka) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_MOSTENKEN2);
                }
                boolean taskChkKekka = checkTaskKengen.exec(mostenkenTnsketsya,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_2JI);

                if(!taskChkKekka){
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_MOSTENKEN2);
                }

            }else if (C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(mostenkenKekkaKbn)){

                boolean kinouMOdeChkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(mostenkenTnsketsya, KINOUID_SKMOUSIKOMITENKEN, C_SkkinouModeIdKbn.MOSTENKEN_HUBI.getValue());

                if (!kinouMOdeChkKekka) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_MOSTENKENHUBI);
                }
                boolean taskChkKekka = checkTaskKengen.exec(mostenkenTnsketsya,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKTENKEN, ISkCommonKoumoku.NODEID_MOUSIKOMITENKEN_HUBI);

                if(!taskChkKekka){
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_MOSTENKENHUBI);
                }
            }
        }


        if (!BizUtil.isBlank(knkTnsketsyacd)
            && !ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(knkTnsketsyacd)) {

            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

            if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knksateiKekkaKbn)) {
                boolean chkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsketsyacd, KINOUID_KNKSATEI, C_SkkinouModeIdKbn.KANKYOUSATEI_1JI.getValue());

                if (!chkKekka) {

                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI1);
                }

                boolean chkKekka1 = checkTaskKengen.exec(knkTnsketsyacd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, ISkCommonKoumoku.NODEID_KANKYOUSATEI_1JI);

                if (!chkKekka1) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI1);
                }
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knksateiKekkaKbn)) {
                boolean chkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsketsyacd, KINOUID_KNKSATEI, C_SkkinouModeIdKbn.KANKYOUSATEI_2JIA.getValue());

                if (!chkKekka) {

                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI2A);
                }

                boolean chkKekka1 = checkTaskKengen.exec(knkTnsketsyacd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIA);

                if (!chkKekka1) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI2A);
                }
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knksateiKekkaKbn)) {
                boolean chkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    knkTnsketsyacd, KINOUID_KNKSATEI, C_SkkinouModeIdKbn.KANKYOUSATEI_2JIB.getValue());

                if (!chkKekka) {

                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI2B);
                }

                boolean chkKekka1 = checkTaskKengen.exec(knkTnsketsyacd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKKANKYOU, ISkCommonKoumoku.NODEID_KANKYOUSATEI_2JIB);

                if (!chkKekka1) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI2B);
                }
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(knkTnsketsyacd);

            if (ketteiSya == null) {

                throw new CommonBizAppException(ERRMESSAGE_MOSNO + syoriCTL.getMosno());
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knksateiKekkaKbn) &&
                C_KnksateirankKbn.BLNK.eq(ketteiSya.getKnksateirankkbn())) {

                throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI1);
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knksateiKekkaKbn) &&
                (C_KnksateirankKbn.BLNK.eq(ketteiSya.getKnksateirankkbn()) ||
                    C_KnksateirankKbn.ITIJI.eq(ketteiSya.getKnksateirankkbn()))) {

                throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI2A);
            }

            if (C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knksateiKekkaKbn) &&
                (C_KnksateirankKbn.BLNK.eq(ketteiSya.getKnksateirankkbn())
                    || C_KnksateirankKbn.ITIJI.eq(ketteiSya.getKnksateirankkbn())
                    || C_KnksateirankKbn.NIJIA.eq(ketteiSya.getKnksateirankkbn()))) {

                throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_KNKSATEI2B);
            }

            BizCurrency hutuuSibouS = getHutuuSibouS(syoriCTL);

            if (ketteiSya.getKnksateijygns().compareTo(hutuuSibouS) < 0) {

                throw new BizLogicException(MessageId.EHA1034, hutuuSibouS.toString());
            }
        }

        if (!BizUtil.isBlank(imuTnsketsyacd)
            && !ISkCommonKoumoku.KETTEISYACD_KYOUYOU.equals(imuTnsketsyacd)) {

            CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
            CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);

            if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(imuSateiKekkaKbn)) {
                boolean chkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    imuTnsketsyacd, KINOUID_IMUSATEI, C_SkkinouModeIdKbn.IMUSATEI_KANI_UW.getValue());

                if (!chkKekka) {

                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_IMUSATEIKANIUW);
                }

                boolean chkKekka1 = checkTaskKengen.exec(imuTnsketsyacd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, ISkCommonKoumoku.NODEID_IMUSATEI_KANI_UW);

                if (!chkKekka1) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_IMUSATEIKANIUW);
                }
            }

            if (C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(imuSateiKekkaKbn)) {
                boolean chkKekka = checkKinouModeKengen.checkKengenByKinouModeIdByUserId(
                    imuTnsketsyacd, KINOUID_IMUSATEI, C_SkkinouModeIdKbn.IMUSATEI_KANI_MD.getValue());

                if (!chkKekka) {

                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_IMUSATEIKANIMD);
                }

                boolean chkKekka1 = checkTaskKengen.exec(imuTnsketsyacd,
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKIMU, ISkCommonKoumoku.NODEID_IMUSATEI_KANI_MD);

                if (!chkKekka1) {
                    throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_IMUSATEIKANIMD);
                }
            }

            HM_KetteiSya ketteiSya = sinkeiyakuDomManager.getKetteiSya(imuTnsketsyacd);

            if (ketteiSya == null) {

                throw new CommonBizAppException(ERRMESSAGE_MOSNO + syoriCTL.getMosno());
            }

            if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(imuSateiKekkaKbn)
                && C_ImusateirankKbn.BLNK.eq(ketteiSya.getImusateirankkbn())) {

                throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_IMUSATEIKANIUW);
            }

            if (C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(imuSateiKekkaKbn) &&
                (C_ImusateirankKbn.BLNK.eq(ketteiSya.getImusateirankkbn()) ||
                    C_ImusateirankKbn.KANI_UW.eq(ketteiSya.getImusateirankkbn()))) {

                throw new BizLogicException(MessageId.EHA1033, ERRMESSAGE_IMUSATEIKANIMD);
            }

            BizCurrency hutuuSibouS = getHutuuSibouS(syoriCTL);

            if (ketteiSya.getImusateijygns().compareTo(hutuuSibouS) < 0) {

                throw new BizLogicException(MessageId.EHA1034, hutuuSibouS.toString());
            }
        }

        C_UmuKbn mosnrkumu = syoriCTL.getMosnrkumu();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        if (mosKihon != null) {
            uiBean.setHhknnmkj(mosKihon.getHhknnmkj());

            int kekkakbn = getMsgAitemosno.exec(mosnrkumu, mosKihon.getAitemosno());
            if (GetMsgAitemosno.KEKKAKBN_ARI == kekkakbn) {
                String messageId = BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid());
                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING, messageId, getMsgAitemosno.getS_gmmsg());
            }
        }

        uiBean.setSyoriCTL(syoriCTL);

        if (C_SyorikekkaKbn.BLNK.eq(mostenkenKekkaKbn) &&
            C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) &&
            C_SyorikekkaKbn.BLNK.eq(imuSateiKekkaKbn)) {

            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QHA1001);
        }
        else {
            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QAC0008);
        }

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId(bzGetProcessSummaryOutBeanList.get(0).getKouteiKanriId());

        bzCommonLockProcess.lockProcess(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

    }

    @Transactional
    void pushKakuteiBL() {

        doUpdateTables();
    }

    void continueLockProcessBL() {

        bzCommonLockProcess.continueLockProcess();
    }

    void pushUnlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

    void removeObj() {
        objStrMan.remove(uiBean.getUniqueId());
    }

    void removeWarningMessage() {
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
    }

    private void doUpdateTables() {

        String mosNo                     = uiBean.getMosno();
        C_SyorikekkaKbn mostenkenKekkaKbn   = uiBean.getMostenkenkekkakbn();
        String          mostenkenTnsketsya  = uiBean.getMostenkentnsketsyacd();
        String          mostenkenComment    = uiBean.getMostenkencommentgamen();
        C_SyorikekkaKbn knksateiKekkaKbn = uiBean.getKnksateikekkakbn();
        String knkTnsketsyaCd            = uiBean.getKnktnsketsyacd();
        String knksateiIraiComment       = uiBean.getKnksateiiraicomment();
        C_SyorikekkaKbn imusateiKekkaKbn = uiBean.getImusateikekkakbn();
        String imuTnsketsyaCd            = uiBean.getImutnsketsyacd();
        String imusateiIraiComment       = uiBean.getImusateiiraicomment();

        String userID = baseUserInfo.getUserId();
        String sysTime = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();
        String lastMsg = "";

        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        HT_SyoriCTL syoriCtrl = uiBean.getSyoriCTL();

        if (syoriCtrl != null) {

            HT_Tokujyou tokujyou = syoriCtrl.getTokujyou();
            if (tokujyou != null) {
                syoriCtrl.setTokujyou(null);
            }

            List<HT_SyouhnTokujyou> syouhnTokujyouLst = syoriCtrl.getSyouhnTokujyous();
            if (!syouhnTokujyouLst.isEmpty()) {
                syouhnTokujyouLst.clear();

                if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCtrl.getKetteikbn())) {
                    lastMsg = MessageUtil.getMessage(MessageId.IHC0004);
                }
            }

            List<HT_SonotaTkykJktk>  sonotaTkykJktkLst = syoriCtrl.getSonotaTkykJktks();
            if (!sonotaTkykJktkLst.isEmpty()) {
                sonotaTkykJktkLst.clear();

                if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCtrl.getKetteikbn())) {
                    lastMsg = MessageUtil.getMessage(MessageId.IHC0004);
                }
            }

            if (!C_SyorikekkaKbn.BLNK.eq(mostenkenKekkaKbn)) {
                int renNo;
                HT_MostenkenRireki mosteneknRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno(mosNo);
                if(mosteneknRireki!=null){
                    renNo = mosteneknRireki.getRenno()+1;
                }else{
                    renNo = 1;
                }

                HT_MostenkenRireki newMosteneknRireki = syoriCtrl.createMostenkenRireki();

                String commentEncode = EditSecurityKm.getEncodeData(mosNo, mostenkenComment);

                newMosteneknRireki.setRenno(renNo);
                newMosteneknRireki.setSyoriYmd(sysDate);
                newMosteneknRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.KYOSEIHANDKET);
                newMosteneknRireki.setMostenkenkekkakbn(mostenkenKekkaKbn);
                newMosteneknRireki.setTnsketsyacd(mostenkenTnsketsya);
                newMosteneknRireki.setKetsyacd(baseUserInfo.getUser().getUserId());
                newMosteneknRireki.setMostenkencomment(commentEncode);
                newMosteneknRireki.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
                newMosteneknRireki.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(newMosteneknRireki);

                C_MostenkenjyouKbn mostenkenjyouKbn = C_MostenkenjyouKbn.NONE;

                if (C_SyorikekkaKbn.IRAI_TENKEN_1.eq(uiBean.getMostenkenkekkakbn())) {
                    mostenkenjyouKbn = C_MostenkenjyouKbn.TENKENMATI_1;
                }
                else if (C_SyorikekkaKbn.IRAI_TENKEN_2.eq(uiBean.getMostenkenkekkakbn())) {
                    mostenkenjyouKbn = C_MostenkenjyouKbn.TENKENMATI_2;
                }
                else if (C_SyorikekkaKbn.IRAI_TENKEN_HUBI.eq(uiBean.getMostenkenkekkakbn())) {
                    mostenkenjyouKbn= C_MostenkenjyouKbn.TENKENMATI_HUBI;
                }

                syoriCtrl.setMostenkenrrkumu(C_UmuKbn.ARI);
                syoriCtrl.setMostenkenjoukbn(mostenkenjyouKbn);

            }

            if (!C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn)) {
                int renNo;

                HT_KnksateiRireki knksateiRirekiMaxRenno = sinkeiyakuDomManager.getKnksateiRirekiByMosnoMaxRenno(mosNo);

                if (knksateiRirekiMaxRenno == null) {
                    renNo = 0;
                }
                else {
                    renNo = knksateiRirekiMaxRenno.getRenno();
                }

                HT_KnksateiRireki knksateiRireki = syoriCtrl.createKnksateiRireki();

                knksateiRireki.setRenno(renNo + 1);
                knksateiRireki.setSyoriYmd(sysDate);
                knksateiRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.KYOSEIHANDKET);
                knksateiRireki.setKnksateikekkakbn(knksateiKekkaKbn);
                knksateiRireki.setKetsyacd(baseUserInfo.getUser().getUserId());
                knksateiRireki.setTnsketsyacd(knkTnsketsyaCd);

                String commentEncode = EditSecurityKm.getEncodeData(mosNo, knksateiIraiComment);

                knksateiRireki.setKnksateicomment(commentEncode);
                knksateiRireki.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
                knksateiRireki.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(knksateiRireki);

                C_KnkysateijyouKbn knkysateijyouKbn = C_KnkysateijyouKbn.NONE;

                if (C_SyorikekkaKbn.IRAI_KANKYOU_1.eq(knksateiKekkaKbn)) {

                    knkysateijyouKbn = C_KnkysateijyouKbn.SATEIMATI_1;
                }
                else if (C_SyorikekkaKbn.IRAI_KANKYOU_2A.eq(knksateiKekkaKbn)) {

                    knkysateijyouKbn = C_KnkysateijyouKbn.SATEIMATI_2A;
                }
                else if (C_SyorikekkaKbn.IRAI_KANKYOU_2B.eq(knksateiKekkaKbn)) {

                    knkysateijyouKbn = C_KnkysateijyouKbn.SATEIMATI_2B;
                }

                syoriCtrl.setKnkysateirrkumu(C_UmuKbn.ARI);
                syoriCtrl.setKnkysateijyoukbn(knkysateijyouKbn);
            }

            if (!C_SyorikekkaKbn.BLNK.eq(imusateiKekkaKbn)) {
                int renNo;

                HT_ImusateiRireki imusateiRirekiMaxRenno = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno(mosNo);

                if (imusateiRirekiMaxRenno == null) {
                    renNo = 0;
                }
                else {
                    renNo = imusateiRirekiMaxRenno.getRenno();
                }

                HT_ImusateiRireki imusateiRireki = syoriCtrl.createImusateiRireki();

                imusateiRireki.setRenno(renNo + 1);
                imusateiRireki.setSyoriYmd(sysDate);
                imusateiRireki.setSateiketsyorinmkbn(C_SateiketsyorinmKbn.KYOSEIHANDKET);
                imusateiRireki.setImusateikekkakbn(imusateiKekkaKbn);
                imusateiRireki.setKetsyacd(baseUserInfo.getUser().getUserId());
                imusateiRireki.setTnsketsyacd(imuTnsketsyaCd);

                String commentEncode = EditSecurityKm.getEncodeData(mosNo, imusateiIraiComment);

                imusateiRireki.setImusateicomment(commentEncode);
                imusateiRireki.setGyoumuKousinsyaId(baseUserInfo.getUser().getUserId());
                imusateiRireki.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(imusateiRireki);

                C_ImusateijyouKbn imusateijyouKbn = C_ImusateijyouKbn.NONE;

                if (C_SyorikekkaKbn.IRAI_IMU_KANIUW.eq(imusateiKekkaKbn)) {

                    imusateijyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_UW;
                }
                else if (C_SyorikekkaKbn.IRAI_IMU_KANIMD.eq(imusateiKekkaKbn)) {

                    imusateijyouKbn = C_ImusateijyouKbn.SATEIMATI_KANI_MD;
                }

                syoriCtrl.setImusateirrkumu(C_UmuKbn.ARI);
                syoriCtrl.setImusateijyoukbn(imusateijyouKbn);
            }

            syoriCtrl.setKetteikbn(C_KetteiKbn.NONE);
            syoriCtrl.setSeiritukbn(C_SeirituKbn.NONE);
            syoriCtrl.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCtrl.setSateizumiymd(null);

        }
        else {
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        BT_GyoumuKouteiInfo gyoumuKouteiInfo =
            bizDomManager.getGyoumuKouteiInfo(uiBean.getBzWorkflowInfo().getOyaKouteiKanriId());

        if (gyoumuKouteiInfo == null) {

            throw new CommonBizAppException(ERRMESSAGE_MOSNO + mosNo);
        }

        C_KetteiyouhiKbn ketteiYouhiKbn = null;
        if (C_SyorikekkaKbn.BLNK.eq(knksateiKekkaKbn) && C_SyorikekkaKbn.BLNK.eq(imusateiKekkaKbn)) {

            ketteiYouhiKbn = C_KetteiyouhiKbn.HUYOU;
        }
        else {

            ketteiYouhiKbn = C_KetteiyouhiKbn.YOU;
        }

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setKinouID(kinou.getKinouId());
        mosnaiCheckParam.setKetteiYouhiKbn(ketteiYouhiKbn);
        mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.KYOUSEIKET);
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userID);
        mosnaiCheckParam.setKosTime(sysTime);
        mosnaiCheckParam.setDataSyoriControl(syoriCtrl);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.debug("<<<<申込内容チェック実行前>>>>");
        mosnaiCheck.exec(mosnaiCheckParam);

        if (mosnaiCheckParam.getListSkDenpyoData().size() > 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        sinkeiyakuDomManager.update(syoriCtrl);
        sinkeiyakuDomManager.update(gyoumuKouteiInfo);

        ArrayList<String> hubiMsgList = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(mosNo);

        skHubiMsgRenkeiInfo.setMosno(mosNo);
        skHubiMsgRenkeiInfo.setHhknnmkj(uiBean.getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiMsgList);

        String uniqueId = objStrMan.save(skHubiMsgRenkeiInfo);

        uiBean.setUniqueId(uniqueId);
        uiBean.setHubimsgData(hubiMsgList.toArray(new String[0]));

        StringBuffer msgOut = new StringBuffer();
        msgOut.append(MessageUtil.getMessage(MessageId.IAC0009));
        List<String> msgList = mosnaiCheckParam.getListKekkaGmnMsg();
        for (String msg : msgList) {
            msgOut.append(MessageUtil.getMessage(MessageId.IAW0006)).append(msg);
        }

        if (!BizUtil.isBlank(lastMsg)) {
            msgOut.append(MessageUtil.getMessage(MessageId.IAW0006)).append(lastMsg);
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), msgOut.toString());

        removeWarningMessage();

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        skProcessForwardInBean.setMosNo(mosNo);
        skProcessForwardInBean.setTskNm(KOUTEIRIREKI_KINOUMEI);
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");
        skProcessForwardInBean.setMostenkenkekkaKbn(mostenkenKekkaKbn);
        skProcessForwardInBean.setMostenkentnsketsyaCd(mostenkenTnsketsya);
        skProcessForwardInBean.setKnksateikekkaKbn(knksateiKekkaKbn);
        skProcessForwardInBean.setKnktnsketsyaCd(knkTnsketsyaCd);
        skProcessForwardInBean.setImusateikekkaKbn(imusateiKekkaKbn);
        skProcessForwardInBean.setImutnsketsyaCd(imuTnsketsyaCd);

        skProcessForwardKyouseiHand.exec(skProcessForwardInBean);

        skProcessUpdate.exec(syoriCtrl, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(mosnaiCheckParam.getDataSyoriControl(),
            uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.
                skIdounaiyouMQEdit(mosnaiCheckParam.getDataSyoriControl());

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsg);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }
    }

    private UserDefsList editTensousakiList(List<HM_KetteiSya> pKetteiSyaList) {
        UserDefsList userDefsList = new UserDefsList();

        userDefsList.add(new LabelValuePair("", ""));
        for (HM_KetteiSya ketteiSya : pKetteiSyaList) {
            userDefsList.add(new LabelValuePair(ketteiSya.getKetsyanm(), ketteiSya.getKetsyacd()));
        }

        return userDefsList;
    }

    private BizCurrency getHutuuSibouS(HT_SyoriCTL pSyoriCTL) {

        BizCurrency hutuuSibouS = BizCurrency.valueOf(0);

        MosnaiCheckParam mosCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosCheckParam.setDataSyoriControl(pSyoriCTL);
        mosCheckParam.setKinouID(kinou.getKinouId());
        mosCheckParam.setSysDate(BizDate.getSysDate());
        mosCheckParam.setKosID(baseUserInfo.getUser().getUserId());
        mosCheckParam.setKosTime(BizDate.getSysDateTimeMilli());

        hutuuSibouS = setHutuuSibouS.exec(mosCheckParam);

        GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

        BizCurrency hutuuSibouSKansan = getKiteiCheckYenkansangk.exec(pSyoriCTL.getMosKihon().getMosymd(), hutuuSibouS,
            pSyoriCTL.getMosKihon().getKyktuukasyu());

        return hutuuSibouSKansan;
    }
}
