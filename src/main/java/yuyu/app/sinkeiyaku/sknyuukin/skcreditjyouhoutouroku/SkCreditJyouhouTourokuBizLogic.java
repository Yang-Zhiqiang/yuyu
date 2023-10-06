package yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku;

import static yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku.GenSkCreditJyouhouTourokuConstants.*;
import static yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku.SkCreditJyouhouTourokuConstants.*;

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

import org.slf4j.Logger;

import yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.SkHubiMsgRenkeiInfo;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNo;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardMoschkExec;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.skcommon.HubiMsgEdit;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.def.classification.C_CreditInfoTourokuGamenSyoriKbn;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.classification.C_CreditTrkjkKbn;
import yuyu.def.classification.C_CreditYuukoukakKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * クレジットカード情報登録 のビジネスロジックです。
 */
public class SkCreditJyouhouTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkCreditJyouhouTourokuUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private ObjStorageManager objStorageManager;

    void init() {
    }

    void clear() {
    }

    String pushTourokuBL() {

        BizPropertyInitializer.initialize(uiBean);


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(uiBean.getMosno());

        if (syoriCTL == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        if (!C_SeirituKbn.NONE.eq(syoriCTL.getSeiritukbn())) {
            throw new BizLogicException(MessageId.EBA0031, syoriCTL.getSeiritukbn().getContent());
        }

        if (C_UmuKbn.NONE.eq(syoriCTL.getMosnrkumu())) {
            throw new BizLogicException(MessageId.EHA0027);
        }

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        if (!C_Hrkkeiro.CREDIT.eq(mosKihon.getHrkkeiro())) {
            throw new BizLogicException(MessageId.EHA1084, DISP_HRKKEIRO, DISP_NOTCREDITCARD);
        }

        if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn()) &&
            !C_FstphrkkeiroKbn.CREDIT.eq(mosKihon.getFstphrkkeirokbn())) {
            throw new BizLogicException(MessageId.EHA1085);
        }

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        summaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setMosNo(uiBean.getMosno());

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(summaryInBean);

        bzCommonLockProcess.lockProcess(
            bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCTL);
        uiBean.setSkIdounaiyouBeforeBean(skIdounaiyouBeforeBean);

        uiBean.setSyoriCTL(syoriCTL);

        String forwardName = null;
        if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            uiBean.setAuthorikakymd(syoriCTL.getAuthorikakymd());
            uiBean.setCardbrandkbn(syoriCTL.getCreditCardJyouhou().getCardbrandkbn());

            forwardName = FORWARDNAME_INPUTCONTENTS;
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITKESSAIYOUNOSYUTOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QHA1005);

            forwardName = FORWARDNAME_CONFIRM;
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUKANBI.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE1, MessageId.QHA1006);

            forwardName = FORWARDNAME_CONFIRM;
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUHANEISYORIQR.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            uiBean.setCreditkessaiyouno1(STR_32);
            uiBean.setCreditkessaiyouno2(STR_00);

            forwardName = FORWARDNAME_INPUTCONTENTS;
        }

        return forwardName;
    }

    void pushKakuninBL() {

        if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            if (uiBean.getAuthorikakymd() == null && !C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KIHONINFO_AUTHORIKAKYMD.getErrorResourceKey()));
            }

            if (uiBean.getAuthorikakymd() != null && C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn())) {
                throw new BizLogicException(MessageId.EBC0045,
                    MessageUtil.getMessage(DDID_KIHONINFO_CARDBRANDKBN.getErrorResourceKey()));
            }

            BizDate sysDate = BizDate.getSysDate();

            if (uiBean.getAuthorikakymd() != null &&
                (BizDateUtil.compareYmd(YuyuSinkeiyakuConfig.getInstance().getCreditTratkiKaisiYmd(),
                    uiBean.getAuthorikakymd()) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(sysDate.addMonths(-3).getRekijyou(),
                        uiBean.getAuthorikakymd()) == BizDateUtil.COMPARE_GREATER
                        || BizDateUtil.compareYmd(uiBean.getAuthorikakymd(),sysDate) == BizDateUtil.COMPARE_GREATER)) {
                throw new BizLogicException(MessageId.EHA1086);
            }

            if (uiBean.getAuthorikakymd() != null && !C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn()) &&
                BizDateUtil.compareYmd(uiBean.getAuthorikakymd(),
                    uiBean.getSyoriCTL().getAuthorikakymd()) == BizDateUtil.COMPARE_EQUAL &&
                    uiBean.getCardbrandkbn().eq(uiBean.getSyoriCTL().getCreditCardJyouhou().getCardbrandkbn())) {
                throw new BizLogicException(MessageId.EHA1087);
            }

            if (uiBean.getAuthorikakymd() == null && C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn())
                && BizDateUtil.compareYmd(uiBean.getAuthorikakymd(),
                    uiBean.getSyoriCTL().getAuthorikakymd()) == BizDateUtil.COMPARE_EQUAL
                    && uiBean.getCardbrandkbn().eq(uiBean.getSyoriCTL().getCreditCardJyouhou().getCardbrandkbn())) {
                throw new BizLogicException(MessageId.EHA1088);
            }

            if (uiBean.getSyoriCTL().getAuthorikakymd() == null && uiBean.getAuthorikakymd() != null) {

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.QHA1002,
                    MessageUtil.getMessage(DDID_KIHONINFO_AUTHORIKAKYMD.getErrorResourceKey()));
            }

            if (uiBean.getSyoriCTL().getAuthorikakymd() != null && uiBean.getAuthorikakymd() != null &&
                BizDateUtil.compareYmd(uiBean.getSyoriCTL().getAuthorikakymd(),
                    uiBean.getAuthorikakymd()) != BizDateUtil.COMPARE_EQUAL) {

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.QHA1003,
                    MessageUtil.getMessage(DDID_KIHONINFO_AUTHORIKAKYMD.getErrorResourceKey()));
            }

            if (uiBean.getSyoriCTL().getAuthorikakymd() != null && uiBean.getAuthorikakymd() == null) {

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.QHA1004,
                    MessageUtil.getMessage(DDID_KIHONINFO_AUTHORIKAKYMD.getErrorResourceKey()));
            }

            if (C_CardBrandKbn.BLNK.eq(uiBean.getSyoriCTL().getCreditCardJyouhou().getCardbrandkbn()) &&
                !C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn())) {

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE3, MessageId.QHA1002,
                    MessageUtil.getMessage(DDID_KIHONINFO_CARDBRANDKBN.getErrorResourceKey()));
            }

            if (!C_CardBrandKbn.BLNK.eq(uiBean.getSyoriCTL().getCreditCardJyouhou().getCardbrandkbn()) &&
                !C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn()) &&
                !uiBean.getSyoriCTL().getCreditCardJyouhou().getCardbrandkbn().eq(uiBean.getCardbrandkbn())) {

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE3, MessageId.QHA1003,
                    MessageUtil.getMessage(DDID_KIHONINFO_CARDBRANDKBN.getErrorResourceKey()));
            }

            if (!C_CardBrandKbn.BLNK.eq(uiBean.getSyoriCTL().getCreditCardJyouhou().getCardbrandkbn()) &&
                C_CardBrandKbn.BLNK.eq(uiBean.getCardbrandkbn())) {

                messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE3, MessageId.QHA1004,
                    MessageUtil.getMessage(DDID_KIHONINFO_CARDBRANDKBN.getErrorResourceKey()));
            }
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUHANEISYORIQR.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            if (BizUtil.isBlank(uiBean.getCreditkessaiyouno1())) {
                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO1.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getCreditkessaiyouno2())) {
                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO2.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getCreditkessaiyouno3())) {
                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO3.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getCreditkessaiyouno4())) {
                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO4.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getCreditkessaiyouno5())) {
                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO5.getErrorResourceKey()));
            }

            if (BizUtil.isBlank(uiBean.getCreditkessaiyouno6())) {
                throw new BizLogicException(MessageId.EBA0027,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO6.getErrorResourceKey()));
            }

            if (!STR_32.equals(uiBean.getCreditkessaiyouno1())) {
                throw new BizLogicException(MessageId.EHA1089,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO1.getErrorResourceKey()), STR_32);
            }

            if (!STR_00.equals(uiBean.getCreditkessaiyouno2())) {
                throw new BizLogicException(MessageId.EHA1089,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO2.getErrorResourceKey()), STR_00);
            }

            if (!uiBean.getCreditkessaiyouno3().equals(uiBean.getMosno())) {
                throw new BizLogicException(MessageId.EHA1092,
                    MessageUtil.getMessage(DDID_KIHONINFO_CREDITKESSAIYOUNO3.getErrorResourceKey()), DISP_MOSNO,
                    DISP_CREDITKESSAIYOUNO);
            }

            String modulusCreditkessaiyouno = uiBean.getCreditkessaiyouno1() + uiBean.getCreditkessaiyouno2() +
                uiBean.getCreditkessaiyouno3() + uiBean.getCreditkessaiyouno4() + uiBean.getCreditkessaiyouno5();

            if (!checkDigitKessaiyouno(modulusCreditkessaiyouno).equals(uiBean.getCreditkessaiyouno6())) {
                throw new BizLogicException(MessageId.EHA1090, DISP_CREDITKESSAIYOUNO,
                    DISP_CREDITKESSAIYOUNO);
            }

            String creditkessaiyouNo = modulusCreditkessaiyouno + uiBean.getCreditkessaiyouno6();

            HT_CreditCardJyouhou creditCardJyouhou = uiBean.getSyoriCTL().getCreditCardJyouhou();

            if (!BizUtil.isBlank(creditCardJyouhou.getCreditkessaiyouno())) {
                if (creditCardJyouhou.getCreditkessaiyouno().equals(creditkessaiyouNo)) {

                    throw new BizLogicException(MessageId.EHA1091, DISP_CREDITKESSAIYOUNO);
                }
                if (C_CreditTrkjkKbn.TOUROKUTYUU.eq(uiBean.getSyoriCTL().getCredittrkjkkbn())) {

                    throw new BizLogicException(MessageId.EHA1097, DISP_CREDITKESSAIYOUNO);
                }
            }

            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_MESSAGE2, MessageId.QAC0008);
        }
    }

    @Transactional
    void pushKakuteiBL() {

        String userId = baseUserInfo.getUserId();
        String kinouId = kinou.getKinouId();
        String kinouNm = kinou.getKinouNm();
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        HT_SyoriCTL syoriCTL = uiBean.getSyoriCTL();
        HT_CreditCardJyouhou creditCardJyouhou = syoriCTL.getCreditCardJyouhou();

        if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            Integer renno = 0;
            BizDate authorikakYmd = syoriCTL.getAuthorikakymd();
            C_CardBrandKbn cardBrandKbn = creditCardJyouhou.getCardbrandkbn();

            syoriCTL.setAuthorikakymd(uiBean.getAuthorikakymd());
            syoriCTL.setGyoumuKousinsyaId(userId);
            syoriCTL.setGyoumuKousinTime(sysDateTime);

            creditCardJyouhou.setCardbrandkbn(uiBean.getCardbrandkbn());
            creditCardJyouhou.setGyoumuKousinsyaId(userId);
            creditCardJyouhou.setGyoumuKousinTime(sysDateTime);

            if (authorikakYmd != null
                && BizDateUtil.compareYmd(authorikakYmd, uiBean.getAuthorikakymd()) != BizDateUtil.COMPARE_EQUAL) {

                renno++;
                HT_KmTsRireki kmTsRireki = syoriCTL.createKmTsRireki();

                kmTsRireki.setSyoriTime(sysDateTime);
                kmTsRireki.setRenno3keta(renno);
                kmTsRireki.setKinouId(kinouId);
                kmTsRireki.setKinouModeId(C_SkkinouModeIdKbn.DEFAULT.getValue());
                kmTsRireki.setTskmnm(MessageUtil.getMessage(DDID_KIHONINFO_AUTHORIKAKYMD.getErrorResourceKey()));
                kmTsRireki.setTsmaenaiyou(DateFormatUtil.dateDOTNoEx(authorikakYmd.toString()));
                if (uiBean.getAuthorikakymd() != null) {
                    kmTsRireki.setTsgonaiyou(DateFormatUtil.dateDOTNoEx(uiBean.getAuthorikakymd().toString()));
                }
                kmTsRireki.setTantid(userId);
                kmTsRireki.setGyoumuKousinsyaId(userId);
                kmTsRireki.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(kmTsRireki);
            }

            if (!C_CardBrandKbn.BLNK.eq(cardBrandKbn) && !cardBrandKbn.eq(uiBean.getCardbrandkbn())) {

                renno++;
                HT_KmTsRireki kmTsRireki = syoriCTL.createKmTsRireki();

                kmTsRireki.setSyoriTime(sysDateTime);
                kmTsRireki.setRenno3keta(renno);
                kmTsRireki.setKinouId(kinouId);
                kmTsRireki.setKinouModeId(C_SkkinouModeIdKbn.DEFAULT.getValue());
                kmTsRireki.setTskmnm(MessageUtil.getMessage(DDID_KIHONINFO_CARDBRANDKBN.getErrorResourceKey()));
                kmTsRireki.setTsmaenaiyou(cardBrandKbn.getContent(C_CardBrandKbn.PATTERN_SELECT));
                kmTsRireki.setTsgonaiyou(uiBean.getCardbrandkbn().getContent(C_CardBrandKbn.PATTERN_SELECT));
                kmTsRireki.setTantid(userId);
                kmTsRireki.setGyoumuKousinsyaId(userId);
                kmTsRireki.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(kmTsRireki);
            }
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITKESSAIYOUNOSYUTOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            SaibanCreditKessaiyouNo saibanCreditKessaiyouNo = SWAKInjector.getInstance(SaibanCreditKessaiyouNo.class);
            CreditKessaiyouNoHensyuu creditKessaiyouNoHensyuu = SWAKInjector.getInstance(CreditKessaiyouNoHensyuu.class);

            String creditkessaiyouNo = saibanCreditKessaiyouNo.exec(C_CreditCardKeySyuruiKbn.MOSNO, uiBean.getMosno());

            String dispCreditkessaiyouNo = creditKessaiyouNoHensyuu.exec(creditkessaiyouNo);

            syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.TOUROKUTYUU);
            syoriCTL.setGyoumuKousinsyaId(userId);
            syoriCTL.setGyoumuKousinTime(sysDateTime);

            creditCardJyouhou.setCreditkessaiyouno(creditkessaiyouNo);
            creditCardJyouhou.setCardbrandkbn(C_CardBrandKbn.BLNK);
            creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.SYOMEN);
            creditCardJyouhou.setGyoumuKousinsyaId(userId);
            creditCardJyouhou.setGyoumuKousinTime(sysDateTime);

            uiBean.setDispcreditkessaiyouno(dispCreditkessaiyouNo);
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUKANBI.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.SUMI);
            syoriCTL.setCredityuukoukakkbn(C_CreditYuukoukakKbn.OK);
            syoriCTL.setGyoumuKousinsyaId(userId);
            syoriCTL.setGyoumuKousinTime(sysDateTime);

            uiBean.setCredittrkjkkbn(C_CreditTrkjkKbn.SUMI);
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUHANEISYORIQR.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            String creditkessaiyouNo = uiBean.getCreditkessaiyouno1() + uiBean.getCreditkessaiyouno2() +
                uiBean.getCreditkessaiyouno3() + uiBean.getCreditkessaiyouno4() +
                uiBean.getCreditkessaiyouno5() + uiBean.getCreditkessaiyouno6();

            syoriCTL.setCredittrkjkkbn(C_CreditTrkjkKbn.SUMI);
            syoriCTL.setCredityuukoukakkbn(C_CreditYuukoukakKbn.OK);
            syoriCTL.setGyoumuKousinsyaId(userId);
            syoriCTL.setGyoumuKousinTime(sysDateTime);

            creditCardJyouhou.setCreditkessaiyouno(creditkessaiyouNo);
            creditCardJyouhou.setCredittrkhoukbn(C_CreditTrkhouKbn.QR);
            creditCardJyouhou.setGyoumuKousinsyaId(userId);
            creditCardJyouhou.setGyoumuKousinTime(sysDateTime);
        }

        BzGetProcessSummaryInBean summaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        MosnaiCheck mosnaiCheck = SWAKInjector.getInstance(MosnaiCheck.class);

        summaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        summaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        summaryInBean.setMosNo(uiBean.getMosno());

        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummary.exec(summaryInBean).get(0);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(bzGetProcessSummaryOutBean.getKouteiKanriId());

        mosnaiCheckParam.setCategoryID(kinou.getCategoryId());
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setKinouID(kinouId);
        mosnaiCheckParam.setSysDate(sysDate);
        mosnaiCheckParam.setKosID(userId);
        mosnaiCheckParam.setKosTime(sysDateTime);

        mosnaiCheck.exec(mosnaiCheckParam);

        bizDomManager.update(gyoumuKouteiInfo);

        if (mosnaiCheckParam.getMosnoKanri() != null) {
            sinkeiyakuDomManager.update(mosnaiCheckParam.getMosnoKanri());
        }

        if (mosnaiCheckParam.getListSkDenpyoData().size() != 0) {
            sinkeiyakuDomManager.insert(mosnaiCheckParam.getListSkDenpyoData());
        }

        sinkeiyakuDomManager.update(syoriCTL);

        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

        bzOutputProcessRecord.exec(
            bzGetProcessSummaryOutBean.getKouteiKanriId(),
            bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
            uiBean.getCreditinfotrkugmsyorikbn().getContent(),
            kinouNm,
            C_SyorikekkaKbn.KANRYOU);

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);
        SkProcessForwardMoschkExec skProcessForwardMoschkExec = SWAKInjector.getInstance(SkProcessForwardMoschkExec.class);

        String kouteiLockKey = bzCommonLockProcess.getKouteiLockKey();

        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm(kinouNm);
        skProcessForwardInBean.setKouteiLockkey(kouteiLockKey);
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setMoscheckrirekiyhKbn(C_YouhiKbn.HUYOU);

        skProcessForwardMoschkExec.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCTL, kouteiLockKey, null);

        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        boolean hanteiKekka = skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCTL,
            uiBean.getSkIdounaiyouBeforeBean());

        if (hanteiKekka) {
            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCTL);

            if (C_ErrorKbn.ERROR.eq(skIdounaiyouKekkaBean.getErrorKbn())) {
                for (String errorMsgId : skIdounaiyouKekkaBean.getErrorMsgLst()) {
                    errorMessageCollector.addMessage(errorMsgId);
                }

                errorMessageCollector.throwBizLogicException();
            }
        }
        HubiMsgEdit hubiMsgEdit = SWAKInjector.getInstance(HubiMsgEdit.class);
        SkHubiMsgRenkeiInfo skHubiMsgRenkeiInfo = SWAKInjector.getInstance(SkHubiMsgRenkeiInfo.class);

        ArrayList<String> hubiLst = hubiMsgEdit.getHubiMsgSourceData_1MousikomiNo(uiBean.getMosno());

        skHubiMsgRenkeiInfo.setMosno(uiBean.getMosno());
        skHubiMsgRenkeiInfo.setHhknnmkj(syoriCTL.getMosKihon().getHhknnmkj());
        skHubiMsgRenkeiInfo.setHubimsgData(hubiLst);

        String uniqueId = objStorageManager.save(skHubiMsgRenkeiInfo);
        uiBean.setUniqueId(uniqueId);

        uiBean.setHubimsgData(hubiLst.toArray(new String[hubiLst.size()]));

        StringBuffer sbMsg = new StringBuffer();
        sbMsg.append(MessageUtil.getMessage(MessageId.IAC0009));

        List<String> kekkaGamenMsgLst = mosnaiCheckParam.getListKekkaGmnMsg();

        if (kekkaGamenMsgLst != null && !kekkaGamenMsgLst.isEmpty()) {
            for (String msg : kekkaGamenMsgLst) {
                sbMsg.append(KAIGYOU);
                sbMsg.append(msg);
            }
        }

        messageManager.addMessageId(BizUtil.getGeneralMessageId(MessageId.IAC0009), sbMsg.toString());

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE1);
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE3);
    }

    public void pushModoruInputBL() {

        if (C_CreditInfoTourokuGamenSyoriKbn.AUTHORIKAKYMDNYUURYOKU.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            continueLockProcess();

            messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
            messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE3);
        }
        else if (C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUHANEISYORIQR.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            continueLockProcess();

            messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_MESSAGE2);
        }
    }

    public void pushModoruKeyBL() {

        if (C_CreditInfoTourokuGamenSyoriKbn.CREDITKESSAIYOUNOSYUTOKU.eq(uiBean.getCreditinfotrkugmsyorikbn()) ||
            C_CreditInfoTourokuGamenSyoriKbn.CREDITTOUROKUKANBI.eq(uiBean.getCreditinfotrkugmsyorikbn())) {

            unlockProcess();
        }
    }

    void continueLockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.continueLockProcess();
    }

    void unlockProcess() {

        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.unlockProcess();
    }

    private String checkDigitKessaiyouno(String pKessaiyouno) {

        int sum = 0;
        int result = 0;
        String checkDigit = "";
        int weight = 2;

        for (int n = pKessaiyouno.length() - 1; n >= 0; n--) {

            result = Integer.parseInt(Character.toString(pKessaiyouno.charAt(n))) * weight;

            if (result > 9) {
                sum += (result / 10) + (result % 10);
            }
            else {
                sum += result;
            }

            weight = (weight == 2) ? 1 : 2;
        }

        if (sum % 10 == 0) {
            checkDigit = "0";
        }
        else {
            checkDigit = String.valueOf(10 - sum % 10);
        }

        return checkDigit;
    }
}