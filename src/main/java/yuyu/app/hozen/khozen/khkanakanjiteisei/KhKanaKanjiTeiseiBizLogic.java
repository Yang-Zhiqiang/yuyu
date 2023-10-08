package yuyu.app.hozen.khozen.khkanakanjiteisei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.hozen.khcommon.CheckHansyaSentakuInfo;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiLinc;
import yuyu.common.hozen.khcommon.HanteiLincBean;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetNkukt;
import yuyu.common.hozen.setuibean.SetSbHkukt;
import yuyu.common.hozen.setuibean.SetSiteiseikyuu;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HnsychkTaisyousyaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkaijyoKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 仮名漢字訂正 のビジネスロジックです。
 */
public class KhKanaKanjiTeiseiBizLogic {

    @Inject
    private KhKanaKanjiTeiseiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    private final KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

    private boolean tyotkhknhyjErrorflg;

    void init() {
    }

    void clear() {
    }

    void pushSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        isExist();

        checkJyoutai();

        setTtdkTyuui();

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        setBetukyk.exec(khozenCommonParam, uiBean);

        addConversationMessageId(uiBean.getWarningMessageIdList(), uiBean.getWarningMessageList(),
            KhKanaKanjiTeiseiConstants.INPUTKEYWARNING);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetHihokensya.exec(khozenCommonParam, uiBean);

        SetNkukt.exec(khozenCommonParam, uiBean);

        SetSbHkukt.exec(khozenCommonParam, uiBean);

        SetSiteiseikyuu.exec(khozenCommonParam, uiBean);

        Long khHenreikinKns = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(uiBean.getSyono());

        if (khHenreikinKns > 0) {
            messageManager.addConversationMessageId(KhKanaKanjiTeiseiConstants.INPUTKEYWARNING, MessageId.WIA1017);
        }

        IT_Kouza iTKouza = uiBean.getKykKihon().getKouza();

        if (iTKouza != null) {

            uiBean.setKzkykdoukbn(iTKouza.getKzkykdoukbn());
            uiBean.setKzmeiginmkn(iTKouza.getKzmeiginmkn());
            uiBean.setKzUmuKbn(C_UmuKbn.ARI);
        }
    }

    void pushKakuninBL() {

        if (uiBean.getNewkyknmkjkhuka()) {
            uiBean.setNewkyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setNewkyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        }

        if (uiBean.getNewhhknnmkjkhuka()) {
            uiBean.setNewhhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setNewhhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        }

        if (uiBean.getSbuktnmkjkhuka1()) {
            uiBean.setSbuktnmkjhukakbn1(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setSbuktnmkjhukakbn1(C_KjkhukaKbn.BLNK);
        }

        if (uiBean.getSbuktnmkjkhuka2()) {
            uiBean.setSbuktnmkjhukakbn2(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setSbuktnmkjhukakbn2(C_KjkhukaKbn.BLNK);
        }

        if (uiBean.getSbuktnmkjkhuka3()) {
            uiBean.setSbuktnmkjhukakbn3(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setSbuktnmkjhukakbn3(C_KjkhukaKbn.BLNK);
        }

        if (uiBean.getSbuktnmkjkhuka4()) {
            uiBean.setSbuktnmkjhukakbn4(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setSbuktnmkjhukakbn4(C_KjkhukaKbn.BLNK);
        }

        if (uiBean.getNewstdrsknmkjhuka()) {
            uiBean.setNewstdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        }
        else {
            uiBean.setNewstdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        }

        kanaChk(uiBean.getNewkyknmkn(), KhKanaKanjiTeiseiConstants.NEWKYKNMKN, 0);

        kanaChk(uiBean.getNewhhknnmkn(), KhKanaKanjiTeiseiConstants.NEWHHKNNMKN, 0);

        kanaChk(uiBean.getSbuktnmkn1(), KhKanaKanjiTeiseiConstants.SBUKTNMKN1, 0);
        kanaChk(uiBean.getSbuktnmkn2(), KhKanaKanjiTeiseiConstants.SBUKTNMKN2, 0);
        kanaChk(uiBean.getSbuktnmkn3(), KhKanaKanjiTeiseiConstants.SBUKTNMKN3, 0);
        kanaChk(uiBean.getSbuktnmkn4(), KhKanaKanjiTeiseiConstants.SBUKTNMKN4, 0);

        kanaChk(uiBean.getNewstdrsknmkn(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKN, 0);

        if (!StringUtil.isNullOrBlank(uiBean.getNewkzmeiginmkn())) {
            if (!CheckMeigininNmKana.isCheckOK_Tuuka(uiBean.getNewkzmeiginmkn(), C_Tuukasyu.JPY)) {
                throw new BizLogicException(MessageId.EBC0046,
                    MessageUtil.getMessage(KhKanaKanjiTeiseiConstants.DDID_KZMEIGIINFO_NEWKZMEIGINMKN.getErrorResourceKey()));
            }
        }

        kanaChk(uiBean.getNewkyknmkn(), KhKanaKanjiTeiseiConstants.NEWKYKNMKN, 1);

        kanaChk(uiBean.getNewhhknnmkn(), KhKanaKanjiTeiseiConstants.NEWHHKNNMKN, 1);

        kanaChk(uiBean.getSbuktnmkn1(), KhKanaKanjiTeiseiConstants.SBUKTNMKN1, 1);
        kanaChk(uiBean.getSbuktnmkn2(), KhKanaKanjiTeiseiConstants.SBUKTNMKN2, 1);
        kanaChk(uiBean.getSbuktnmkn3(), KhKanaKanjiTeiseiConstants.SBUKTNMKN3, 1);
        kanaChk(uiBean.getSbuktnmkn4(), KhKanaKanjiTeiseiConstants.SBUKTNMKN4, 1);

        kanaChk(uiBean.getNewstdrsknmkn(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKN, 1);

        kanjiChk(uiBean.getNewkyknmkj(), KhKanaKanjiTeiseiConstants.NEWKYKNMKJ);

        kanjiChk(uiBean.getNewhhknnmkj(), KhKanaKanjiTeiseiConstants.NEWHHKNNMKJ);

        kanjiChk(uiBean.getSbuktnmkj1(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ1);

        kanjiChk(uiBean.getSbuktnmkj2(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ2);

        kanjiChk(uiBean.getSbuktnmkj3(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ3);

        kanjiChk(uiBean.getSbuktnmkj4(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ4);

        kanjiChk(uiBean.getNewstdrsknmkj(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKJ);

        if (!CheckKana.isKyoyouKetaHankaku_Kouza(uiBean.getNewkzmeiginmkn())){
            throw new BizLogicException(MessageId.EBC1012,
                MessageUtil.getMessage(KhKanaKanjiTeiseiConstants.DDID_KZMEIGIINFO_NEWKZMEIGINMKN.getErrorResourceKey()));
        }


        String kyknmkj = "";

        C_KjkhukaKbn kyknmkjkhukakbn = C_KjkhukaKbn.BLNK;

        String kyknkn = "";

        String hhknnmkj = "";

        C_KjkhukaKbn hhknnmkjkhukakbn = C_KjkhukaKbn.BLNK;

        String hhknnmkn = "";

        C_UktKbn sbuktkbn = C_UktKbn.BLNK;

        if (StringUtil.isNullOrBlank(uiBean.getNewkyknmkj()) && C_KjkhukaKbn.BLNK.eq(uiBean.getNewkyknmkjkhukakbn())) {
            kyknmkj =  uiBean.getVkykskyknmkj();
            kyknmkjkhukakbn = uiBean.getVkykskyknmkjkhukakbn();
        }
        else {
            kyknmkj =  uiBean.getNewkyknmkj();
            kyknmkjkhukakbn = uiBean.getNewkyknmkjkhukakbn();
        }

        if (!StringUtil.isNullOrBlank(uiBean.getNewkyknmkn())) {
            kyknkn = uiBean.getNewkyknmkn();
        }
        else {
            kyknkn = uiBean.getVkykskyknmkn();
        }

        if (StringUtil.isNullOrBlank(uiBean.getNewhhknnmkj()) &&
            C_KjkhukaKbn.BLNK.eq(uiBean.getNewhhknnmkjkhukakbn())) {
            hhknnmkj = uiBean.getVhhkshhknnmkj();
            hhknnmkjkhukakbn = uiBean.getVhhkshhknnmkjkhukakbn();
        }
        else {
            hhknnmkj = uiBean.getNewhhknnmkj();
            hhknnmkjkhukakbn = uiBean.getNewhhknnmkjkhukakbn();
        }

        if (!StringUtil.isNullOrBlank(uiBean.getNewhhknnmkn())) {
            hhknnmkn = uiBean.getNewhhknnmkn();
        }
        else {
            hhknnmkn = uiBean.getVhhkshhknnmkn();
        }

        if (!kyknmkj.equals(uiBean.getVkykskyknmkj()) || !kyknkn.equals(uiBean.getVkykskyknmkn()) ||
            !kyknmkjkhukakbn.eq(uiBean.getVkykskyknmkjkhukakbn())) {
            uiBean.setKykUmuKbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKykUmuKbn(C_UmuKbn.NONE);
        }

        if (!hhknnmkj.equals(uiBean.getVhhkshhknnmkj()) || !hhknnmkn.equals(uiBean.getVhhkshhknnmkn()) ||
            !hhknnmkjkhukakbn.eq(uiBean.getVhhkshhknnmkjkhukakbn())) {
            uiBean.setVhhkUmuKbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setVhhkUmuKbn(C_UmuKbn.NONE);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKykUmuKbn())) {

            if (StringUtil.isNullOrBlank(uiBean.getNewkyknmkj()) &&
                !C_KjkhukaKbn.BLNK.eq(uiBean.getNewkyknmkjkhukakbn())) {

                throw new BizLogicException(MessageId.EBC0043, KhKanaKanjiTeiseiConstants.NEWKYKNMKJ);
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKykUmuKbn()) ||
            C_UmuKbn.ARI.eq(uiBean.getVhhkUmuKbn())) {

            if (C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {

                if (!kyknkn.equals(hhknnmkn)) {
                    throw new BizLogicException(MessageId.EIA0057, KhKanaKanjiTeiseiConstants.NEWKYKNMKN,
                        KhKanaKanjiTeiseiConstants.NEWHHKNNMKN);
                }

                if (!kyknmkj.equals(hhknnmkj)) {
                    throw new BizLogicException(MessageId.EIA0057, KhKanaKanjiTeiseiConstants.NEWKYKNMKJ,
                        KhKanaKanjiTeiseiConstants.NEWHHKNNMKJ);
                }

                if (!kyknmkjkhukakbn.eq(hhknnmkjkhukakbn)) {
                    throw new BizLogicException(MessageId.EIA0057, KhKanaKanjiTeiseiConstants.KYKHNMKJKHUKAKBN,
                        KhKanaKanjiTeiseiConstants.HHKNNMKJHUKAKBN);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getVhhkUmuKbn()) && StringUtil.isNullOrBlank(uiBean.getNewhhknnmkj()) &&
            !C_KjkhukaKbn.BLNK.eq(uiBean.getNewhhknnmkjkhukakbn())) {

            throw new BizLogicException(MessageId.EBC0043, KhKanaKanjiTeiseiConstants.NEWHHKNNMKJ);
        }

        if (!C_UktKbn.BLNK.eq(uiBean.getNewnenkinuktkbn())) {
            uiBean.setVnkuknenkinUmuKbn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setVnkuknenkinUmuKbn(C_UmuKbn.NONE);
        }

        if (!C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1()) || !StringUtil.isNullOrBlank(uiBean.getSbuktnmkn1()) ||
            !StringUtil.isNullOrBlank(uiBean.getSbuktnmkj1()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getSbuktnmkjhukakbn1())) {

            uiBean.setSbuktUmuKbn1(C_UmuKbn.ARI);
            sbuktkbn = uiBean.getSbuktkbn1();
        }
        else {
            uiBean.setSbuktUmuKbn1(C_UmuKbn.NONE);
            sbuktkbn = uiBean.getVshktdispsbuktkbn1();
        }

        if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkn2()) || !StringUtil.isNullOrBlank(uiBean.getSbuktnmkj2()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getSbuktnmkjhukakbn2())) {

            uiBean.setSbuktUmuKbn2(C_UmuKbn.ARI);
        }
        else {
            uiBean.setSbuktUmuKbn2(C_UmuKbn.NONE);
        }

        if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkn3()) || !StringUtil.isNullOrBlank(uiBean.getSbuktnmkj3()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getSbuktnmkjhukakbn3())) {

            uiBean.setSbuktUmuKbn3(C_UmuKbn.ARI);
        }
        else {
            uiBean.setSbuktUmuKbn3(C_UmuKbn.NONE);
        }

        if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkn4()) || !StringUtil.isNullOrBlank(uiBean.getSbuktnmkj4()) ||
            !C_KjkhukaKbn.BLNK.eq(uiBean.getSbuktnmkjhukakbn4())) {

            uiBean.setSbuktUmuKbn4(C_UmuKbn.ARI);
        }
        else {
            uiBean.setSbuktUmuKbn4(C_UmuKbn.NONE);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn1()) || C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn2()) ||
            C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn3()) || C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn4())) {
            if (uiBean.getVshktsbuktnin() >= 5) {
                throw new BizLogicException(MessageId.EIC1002);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn1()) && C_UktKbn.BLNK.eq(uiBean.getSbuktkbn1())) {
                throw new BizLogicException(MessageId.EBC0043, KhKanaKanjiTeiseiConstants.SBUKTKBN);
            }

            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getSbuktkbn1())) {
                if(!C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getVshktdispsbuktkbn1())) {
                    throw new BizLogicException(MessageId.EIA1009, "変更前の死亡受取人区分が「特定名義」以外", "変更後の死亡受取人区分に「特定名義」");
                }
                nyuuryokuChk(uiBean.getSbuktnmkn1(), KhKanaKanjiTeiseiConstants.SBUKTNMKN1, 0);
                nyuuryokuChk(uiBean.getSbuktnmkj1(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ1, 0);
            }
            else {
                nyuuryokuChk(uiBean.getSbuktnmkn1(), KhKanaKanjiTeiseiConstants.SBUKTNMKN1, 1);
                nyuuryokuChk(uiBean.getSbuktnmkj1(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ1, 1);

                if (!C_KjkhukaKbn.BLNK.eq(uiBean.getSbuktnmkjhukakbn1())) {
                    throw new BizLogicException(MessageId.EBC0007, KhKanaKanjiTeiseiConstants.SBUKTKJHUKAKBN);
                }
                if (uiBean.getVshktsbuktnin() > 1) {
                    throw new BizLogicException(MessageId.EIF1070);
                }
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn2())) {

                nyuuryokuChk(uiBean.getSbuktnmkn2(), KhKanaKanjiTeiseiConstants.SBUKTNMKN2, 0);
                nyuuryokuChk(uiBean.getSbuktnmkj2(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ2, 0);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn3())) {

                nyuuryokuChk(uiBean.getSbuktnmkn3(), KhKanaKanjiTeiseiConstants.SBUKTNMKN3, 0);
                nyuuryokuChk(uiBean.getSbuktnmkj3(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ3, 0);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn4())) {

                nyuuryokuChk(uiBean.getSbuktnmkn4(), KhKanaKanjiTeiseiConstants.SBUKTNMKN4, 0);
                nyuuryokuChk(uiBean.getSbuktnmkj4(), KhKanaKanjiTeiseiConstants.SBUKTNMKNJ4, 0);
            }

            if (C_UktKbn.KYK.eq(uiBean.getSbuktkbn1()) && C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                throw new BizLogicException(MessageId.EBC1002);
            }

            if (C_UktKbn.HHKN.eq(uiBean.getSbuktkbn1()) && C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                throw new BizLogicException(MessageId.EBC1003);
            }
        }

        IT_KykSonotaTkyk kykSonotaTkyk = uiBean.getKykKihon().getKykSonotaTkyk();

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
            if (!C_UktkaijyoKbn.BLNK.eq(uiBean.getStdrskkaijyokbn()) || !C_UktKbn.BLNK.eq(uiBean.getNewstdruktkbn()) ||
                !StringUtil.isNullOrBlank(uiBean.getNewstdrsknmkn()) ||
                !StringUtil.isNullOrBlank(uiBean.getNewstdrsknmkj()) ||
                !C_KjkhukaKbn.BLNK.eq(uiBean.getNewstdrsknmkjhukakbn())) {
                uiBean.setStdrskUmuKbn(C_UmuKbn.ARI);
            }
            else {
                uiBean.setStdrskUmuKbn(C_UmuKbn.NONE);
            }

            C_UktKbn stdruktkbn = null;
            if (C_UktKbn.BLNK.eq(uiBean.getNewstdruktkbn())) {
                stdruktkbn = uiBean.getVstsksiteidruktkbn();
            } else {
                stdruktkbn = uiBean.getNewstdruktkbn();
            }

            if (C_UmuKbn.ARI.eq(uiBean.getStdrskUmuKbn())) {
                if (!C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {
                    if (C_UktKbn.BLNK.eq(uiBean.getNewstdruktkbn())) {
                        throw new BizLogicException(MessageId.EBC0043, KhKanaKanjiTeiseiConstants.STDRUKTKBN);
                    }

                    if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewstdruktkbn())) {
                        nyuuryokuChk(uiBean.getNewstdrsknmkn(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKN, 0);
                        nyuuryokuChk(uiBean.getNewstdrsknmkj(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKJ, 0);
                    }
                    if (!C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewstdruktkbn())) {
                        nyuuryokuChk(uiBean.getNewstdrsknmkn(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKN, 1);
                        nyuuryokuChk(uiBean.getNewstdrsknmkj(), KhKanaKanjiTeiseiConstants.NEWSTDRSKNMKJ, 1);
                        if (!C_KjkhukaKbn.BLNK.eq(uiBean.getNewstdrsknmkjhukakbn())) {
                            throw new BizLogicException(MessageId.EBC0007, KhKanaKanjiTeiseiConstants.STDRSKNMKJHUKAKBN);
                        }
                    }
                }

                if (C_UktKbn.KYK.eq(uiBean.getNewstdruktkbn()) && C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                    throw new BizLogicException(MessageId.EBC1001);
                }
                if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewstdruktkbn())
                    && C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn1())) {
                    throw new BizLogicException(MessageId.EIA1068, C_UktKbn.TOUROKUKAZOKU1.getContent());
                }
                if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewstdruktkbn())
                    && C_UmuKbn.NONE.eq(uiBean.getVtrkkzktrkkzkumukbn2())) {
                    throw new BizLogicException(MessageId.EIA1068, C_UktKbn.TOUROKUKAZOKU2.getContent());
                }
                if (C_UktKbn.SBUK.eq(uiBean.getNewstdruktkbn()) && uiBean.getVshktsbuktnin() >= 2) {
                    throw new BizLogicException(MessageId.EBC1004);
                }
                if (C_UktKbn.SBUK.eq(uiBean.getNewstdruktkbn()) && C_UktKbn.SOUZOKUNIN.eq(sbuktkbn)) {
                    throw new BizLogicException(MessageId.EBC1006);
                }
            }
            else {

                if (C_UktKbn.KYK.eq(uiBean.getVstsksiteidruktkbn()) && C_Tdk.HONNIN.eq(uiBean.getVkykskkkyktdk())) {
                    throw new BizLogicException(MessageId.EBC1001);
                }

                if (C_UktKbn.SBUK.eq(uiBean.getVstsksiteidruktkbn()) && uiBean.getVshktsbuktnin() >= 2) {
                    throw new BizLogicException(MessageId.EBC1004);
                }

                if (C_UktKbn.SBUK.eq(uiBean.getVstsksiteidruktkbn()) && C_UktKbn.SOUZOKUNIN.eq(sbuktkbn)) {
                    throw new BizLogicException(MessageId.EBC1006);
                }
            }
            if (C_UktKbn.KYK.eq(sbuktkbn) &&
                C_UktKbn.SBUK.eq(stdruktkbn)) {

                throw new BizLogicException(MessageId.EIA1019, C_UktKbn.KYK.getContent(C_UktKbn.PATTERN_KHSBUK));
            }
            if (C_UktKbn.HHKN.eq(sbuktkbn) &&
                C_UktKbn.SBUK.eq(stdruktkbn)) {

                throw new BizLogicException(MessageId.EIA1019, C_UktKbn.HHKN.getContent(C_UktKbn.PATTERN_KHSBUK));
            }
        }

        C_KzkykdouKbn newkzkykdoukbn = uiBean.getNewkzkykdoukbn();

        String newkzmeiginmkn = uiBean.getNewkzmeiginmkn();

        if (C_UmuKbn.ARI.eq(uiBean.getKzUmuKbn())) {

            if (!C_KzkykdouKbn.BLNK.eq(newkzkykdoukbn)) {
                uiBean.setKzmeigiUmuKbn(C_UmuKbn.ARI);
            }

            if (!StringUtil.isNullOrBlank(newkzmeiginmkn)) {
                uiBean.setKzmeigiUmuKbn(C_UmuKbn.ARI);
            }

            if (C_UmuKbn.ARI.eq(uiBean.getKzmeigiUmuKbn())) {
                if (C_KzkykdouKbn.BLNK.eq(newkzkykdoukbn)) {
                    throw new BizLogicException(MessageId.EBC0043,
                        MessageUtil.getMessage(KhKanaKanjiTeiseiConstants.DDID_KZMEIGIINFO_NEWKZKYKDOUKBN.getErrorResourceKey()));
                }

                if (!StringUtil.isNullOrBlank(newkzmeiginmkn)) {
                    if(C_KzkykdouKbn.DOUITU.eq(newkzkykdoukbn)) {
                        throw new BizLogicException(MessageId.EBA0108,
                            MessageUtil.getMessage(KhKanaKanjiTeiseiConstants.DDID_KZMEIGIINFO_NEWKZMEIGINMKN.getErrorResourceKey()));
                    }
                }
                else {
                    if(C_KzkykdouKbn.SITEI.eq(newkzkykdoukbn)){
                        throw new BizLogicException(MessageId.EBC0043,
                            MessageUtil.getMessage(KhKanaKanjiTeiseiConstants.DDID_KZMEIGIINFO_NEWKZMEIGINMKN.getErrorResourceKey()));
                    }
                    uiBean.setNewkzmeiginmkn(kyknkn);
                }
            }

            if ((C_Kykjyoutai.HRKMTYUU.eq(uiBean.getVkihnkykjyoutai())||C_Kykjyoutai.IKKATUNK.eq(uiBean.getVkihnkykjyoutai())) &&
                !StringUtil.isNullOrBlank(uiBean.getNewkyknmkn())) {

                if (C_KzkykdouKbn.DOUITU.eq(uiBean.getKzkykdoukbn()) && C_UmuKbn.NONE.eq(uiBean.getKzmeigiUmuKbn())) {
                    throw new BizLogicException(MessageId.EIA1028);
                }
            }
        }

        if (C_UmuKbn.NONE.eq(uiBean.getKykUmuKbn()) && C_UmuKbn.NONE.eq(uiBean.getVhhkUmuKbn()) &&
            C_UmuKbn.NONE.eq(uiBean.getVnkuknenkinUmuKbn()) && C_UmuKbn.NONE.eq(uiBean.getSbuktUmuKbn1()) &&
            C_UmuKbn.NONE.eq(uiBean.getSbuktUmuKbn2()) && C_UmuKbn.NONE.eq(uiBean.getSbuktUmuKbn3()) &&
            C_UmuKbn.NONE.eq(uiBean.getSbuktUmuKbn4()) && C_UmuKbn.NONE.eq(uiBean.getStdrskUmuKbn()) &&
            C_UmuKbn.NONE.eq(uiBean.getKzmeigiUmuKbn()) ) {
            throw new BizLogicException(MessageId.EIA0044, KhKanaKanjiTeiseiConstants.MEIGIJYOUHOU);
        }

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
        C_ErrorKbn tyotkhknhyjsetkbn = setTyotikuseihokenhyouji.exec(uiBean.getKykKihon());
        C_UmuKbn houteityotkhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();
        C_UmuKbn tyotkhknhyj = setTyotikuseihokenhyouji.getTyotkhknhyj();

        if (C_UmuKbn.ARI.eq(uiBean.getKykUmuKbn())) {
            IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();

            checkHansyaSentakuInfo(C_HnsychkTaisyousyaKbn.KYK, kyknkn, kyknmkj, kyknmkjkhukakbn, kykSya.getKykseiymd(),
                kykSya.getTsinyno(), tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getVhhkUmuKbn())) {
            IT_HhknSya hhknSya = uiBean.getKykKihon().getHhknSya();

            checkHansyaSentakuInfo(C_HnsychkTaisyousyaKbn.HHKN, hhknnmkn, hhknnmkj, hhknnmkjkhukakbn,
                hhknSya.getHhknseiymd(), hhknSya.getHhknyno(), tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
        }

        C_HnsychkTaisyousyaKbn hnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.BLNK;

        if (C_UmuKbn.ARI.eq(uiBean.getVshktsbhkuktumu())) {
            hnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.SBSUKT;
        }
        if (C_UmuKbn.ARI.eq(uiBean.getVshktsbkyuuhukinuktumu())) {
            hnsychkTaisyousyaKbn = C_HnsychkTaisyousyaKbn.SBKYFKUKT;
        }

        IT_KykSya kykSya = uiBean.getKykKihon().getKykSya();

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn1())) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getSbuktkbn1())) {

                checkHansyaSentakuInfo(hnsychkTaisyousyaKbn, uiBean.getSbuktnmkn1(), uiBean.getSbuktnmkj1(),
                    uiBean.getSbuktnmkjhukakbn1(), uiBean.getVshktdispsbuktseiymd1(), kykSya.getTsinyno(),
                    tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn2())) {

            checkHansyaSentakuInfo(hnsychkTaisyousyaKbn, uiBean.getSbuktnmkn2(), uiBean.getSbuktnmkj2(),
                uiBean.getSbuktnmkjhukakbn2(), uiBean.getVshktdispsbuktseiymd2(), kykSya.getTsinyno(),
                tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn3())) {

            checkHansyaSentakuInfo(hnsychkTaisyousyaKbn, uiBean.getSbuktnmkn3(), uiBean.getSbuktnmkj3(),
                uiBean.getSbuktnmkjhukakbn3(), uiBean.getVshktdispsbuktseiymd3(), kykSya.getTsinyno(),
                tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn4())) {

            checkHansyaSentakuInfo(hnsychkTaisyousyaKbn, uiBean.getSbuktnmkn4(), uiBean.getSbuktnmkj4(),
                uiBean.getSbuktnmkjhukakbn4(), uiBean.getVshktdispsbuktseiymd4(), kykSya.getTsinyno(),
                tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getStdrskUmuKbn())) {
            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewstdruktkbn())) {

                checkHansyaSentakuInfo(C_HnsychkTaisyousyaKbn.STDRSK, uiBean.getNewstdrsknmkn(),
                    uiBean.getNewstdrsknmkj(), uiBean.getNewstdrsknmkjhukakbn(), uiBean.getVstskstdrskseiymd(),
                    kykSya.getTsinyno(),tyotkhknhyjsetkbn, houteityotkhknhyj, tyotkhknhyj);
            }
            else if (C_UktKbn.TOUROKUKAZOKU1.eq(uiBean.getNewstdruktkbn())) {

                checkHansyaSentakuInfo(C_HnsychkTaisyousyaKbn.STDRSK, uiBean.getVtrkkzktrkkzknmkn1(),
                    uiBean.getVtrkkzktrkkzknmkj1(), uiBean.getVtrkkzktrkkzknmkjkhukakbn1(),
                    uiBean.getVtrkkzktrkkzkseiymd1(), uiBean.getVtrkkzktrkkzkyno1(),tyotkhknhyjsetkbn,
                    houteityotkhknhyj, tyotkhknhyj);
            }
            else if (C_UktKbn.TOUROKUKAZOKU2.eq(uiBean.getNewstdruktkbn())) {

                checkHansyaSentakuInfo(C_HnsychkTaisyousyaKbn.STDRSK, uiBean.getVtrkkzktrkkzknmkn2(),
                    uiBean.getVtrkkzktrkkzknmkj2(), uiBean.getVtrkkzktrkkzknmkjkhukakbn2(),
                    uiBean.getVtrkkzktrkkzkseiymd2(), uiBean.getVtrkkzktrkkzkyno2(), tyotkhknhyjsetkbn,
                    houteityotkhknhyj, tyotkhknhyj);
            }
        }

        if (uiBean.getVshktsbuktnin() >= 5) {
            messageManager.addConversationMessageId(KhKanaKanjiTeiseiConstants.SYOUKAIWARNING, MessageId.WBA0016);
        }

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTeikishrtkykhukaumu())) {
            if (!uiBean.getVkykskyknmkn().equals(uiBean.getNewkyknmkn())) {
                messageManager.addConversationMessageId(KhKanaKanjiTeiseiConstants.SYOUKAIWARNING, MessageId.WIA1027);
            }
        }

        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void pushKakuteiBL() {

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTime = BizDate.getSysDateTimeMilli();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        String henkouSikibetukey = khozenCommonParam.getSikibetuKey(uiBean.getSyono());

        tableMaintenanceUtil.backUp(uiBean.getSyono(), henkouSikibetukey);

        uiBean.getKykKihon().setSyhenkouymd(sysDate);
        uiBean.getKykKihon().setGyoumuKousinKinou(kinou.getKinouId());
        uiBean.getKykKihon().setGyoumuKousinsyaId(baseUserInfo.getUserId());
        uiBean.getKykKihon().setGyoumuKousinTime(sysDateTime);
        if (C_UmuKbn.ARI.eq(uiBean.getKykUmuKbn())) {
            uiBean.getKykKihon().setLastkyknmkanakjteiymd(sysDate);
        }
        IT_KhTtdkRireki khTtdkRireki =  uiBean.getKykKihon().createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(henkouSikibetukey);

        if (C_UmuKbn.ARI.eq(uiBean.getKykUmuKbn())) {
            uiBean.getKykKihon().getKykSya().setGyoumuKousinKinou(kinou.getKinouId());
            uiBean.getKykKihon().getKykSya().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            uiBean.getKykKihon().getKykSya().setGyoumuKousinTime(sysDateTime);

            if (!StringUtil.isNullOrBlank(uiBean.getNewkyknmkn())) {
                uiBean.getKykKihon().getKykSya().setKyknmkn(uiBean.getNewkyknmkn());
            }
            if (!StringUtil.isNullOrBlank(uiBean.getNewkyknmkj())) {
                uiBean.getKykKihon().getKykSya().setKyknmkj(uiBean.getNewkyknmkj());
                uiBean.getKykKihon().getKykSya().setKyknmkjkhukakbn(uiBean.getNewkyknmkjkhukakbn());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getVhhkUmuKbn())) {
            uiBean.getKykKihon().getHhknSya().setGyoumuKousinKinou(kinou.getKinouId());
            uiBean.getKykKihon().getHhknSya().setGyoumuKousinsyaId(baseUserInfo.getUserId());
            uiBean.getKykKihon().getHhknSya().setGyoumuKousinTime(sysDateTime);

            if (!StringUtil.isNullOrBlank(uiBean.getNewhhknnmkn())) {
                uiBean.getKykKihon().getHhknSya().setHhknnmkn(uiBean.getNewhhknnmkn());
            }
            if (!StringUtil.isNullOrBlank(uiBean.getNewhhknnmkj())) {
                uiBean.getKykKihon().getHhknSya().setHhknnmkj(uiBean.getNewhhknnmkj());
                uiBean.getKykKihon().getHhknSya().setHhknnmkjkhukakbn(uiBean.getNewhhknnmkjkhukakbn());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getVnkuknenkinUmuKbn())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.NKUKT, 1);

            kykUkt.setUktkbn(uiBean.getNewnenkinuktkbn());
            kykUkt.setGyoumuKousinKinou(kinou.getKinouId());
            kykUkt.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykUkt.setGyoumuKousinTime(sysDateTime);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn1())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(
                C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno1());

            kykUkt.setGyoumuKousinKinou(kinou.getKinouId());
            kykUkt.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykUkt.setGyoumuKousinTime(sysDateTime);

            kykUkt.setUktkbn(uiBean.getSbuktkbn1());
            if (C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getSbuktkbn1())) {
                kykUkt.setUktnmkn(uiBean.getSbuktnmkn1());
                kykUkt.setUktnmkj(uiBean.getSbuktnmkj1());
                kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn1());

            } else {
                kykUkt.setUktnmkn("");
                kykUkt.setUktnmkj("");
                kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn2())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(
                C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno2());

            kykUkt.setGyoumuKousinKinou(kinou.getKinouId());
            kykUkt.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykUkt.setGyoumuKousinTime(sysDateTime);

            if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkn2())) {
                kykUkt.setUktnmkn(uiBean.getSbuktnmkn2());
            }
            if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkj2())) {
                kykUkt.setUktnmkj(uiBean.getSbuktnmkj2());
                kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn2());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn3())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(
                C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno3());

            kykUkt.setGyoumuKousinKinou(kinou.getKinouId());
            kykUkt.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykUkt.setGyoumuKousinTime(sysDateTime);

            if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkn3())) {
                kykUkt.setUktnmkn(uiBean.getSbuktnmkn3());
            }
            if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkj3())) {
                kykUkt.setUktnmkj(uiBean.getSbuktnmkj3());
                kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn3());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getSbuktUmuKbn4())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(
                C_UktsyuKbn.SBUKT, uiBean.getVshktsbuktsyurenno4());

            kykUkt.setGyoumuKousinKinou(kinou.getKinouId());
            kykUkt.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykUkt.setGyoumuKousinTime(sysDateTime);

            if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkn4())) {
                kykUkt.setUktnmkn(uiBean.getSbuktnmkn4());
            }
            if (!StringUtil.isNullOrBlank(uiBean.getSbuktnmkj4())) {
                kykUkt.setUktnmkj(uiBean.getSbuktnmkj4());
                kykUkt.setUktnmkjkhukakbn(uiBean.getSbuktnmkjhukakbn4());
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getStdrskUmuKbn())) {
            IT_KykUkt kykUkt = uiBean.getKykKihon().getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

            kykUkt.setGyoumuKousinKinou(kinou.getKinouId());
            kykUkt.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            kykUkt.setGyoumuKousinTime(sysDateTime);

            if (C_UktkaijyoKbn.KAIJYO.eq(uiBean.getStdrskkaijyokbn())) {
                kykUkt.setUktkbn(C_UktKbn.NASI);
                kykUkt.setUktnmkn("");
                kykUkt.setUktnmkj("");
                kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                kykUkt.setUktseiymd(null);
            }
            else {
                kykUkt.setUktkbn(uiBean.getNewstdruktkbn());
                kykUkt.setUktnmkn(uiBean.getNewstdrsknmkn());
                kykUkt.setUktnmkj(uiBean.getNewstdrsknmkj());
                kykUkt.setUktnmkjkhukakbn(uiBean.getNewstdrsknmkjhukakbn());

                if (!C_UktKbn.TOKUTEIMEIGI.eq(uiBean.getNewstdruktkbn())) {
                    kykUkt.setUktseiymd(null);
                }
            }
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKzmeigiUmuKbn())) {

            IT_Kouza iTKouza = uiBean.getKykKihon().getKouza();

            iTKouza.setKzkykdoukbn(uiBean.getNewkzkykdoukbn());
            iTKouza.setKzmeiginmkn(uiBean.getNewkzmeiginmkn());

            iTKouza.setGyoumuKousinKinou(kinou.getKinouId());
            iTKouza.setGyoumuKousinsyaId(baseUserInfo.getUserId());
            iTKouza.setGyoumuKousinTime(sysDateTime);
        }

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);

        pALKykNaiyouKousin.exec(uiBean.getKykKihon());

        String youkyuuno = pALKykNaiyouKousin.getYoukyuuno();
        String hhknSakuinmeino = pALKykNaiyouKousin.getHhknSakuinmeino();
        String kykSakuinmeino = pALKykNaiyouKousin.getKykSakuinmeino();
        C_NayoseJissiKekkaKbn kykJissiKekkaKbn = pALKykNaiyouKousin.getKykSyaNayoseJissiKekkaKbn();
        C_NayoseJissiKekkaKbn hhknJissiKekkaKbn = pALKykNaiyouKousin.getHhknSyaNayoseJissiKekkaKbn();


        if (C_UmuKbn.ARI.eq(uiBean.getKykUmuKbn()) && !C_NayoseJissiKekkaKbn.BLNK.eq(kykJissiKekkaKbn)) {
            uiBean.getKykKihon().getKykSya().setKyksakuinmeino(kykSakuinmeino);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getVhhkUmuKbn()) && !C_NayoseJissiKekkaKbn.BLNK.eq(hhknJissiKekkaKbn)) {
            uiBean.getKykKihon().getHhknSya().setHhknsakuinmeino(hhknSakuinmeino);
        }

        khLincSousinDataSyori(khozenCommonParam, sysDate, tableMaintenanceUtil.getBakKykKihon());

        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(uiBean.getSyono());
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysDateTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setYoukyuuNo(youkyuuno);

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        hozenDomManager.update(uiBean.getKykKihon());

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void pushModoruByConfirmBL() {
        messageManager.removeConversationMessage(KhKanaKanjiTeiseiConstants.SYOUKAIWARNING);
    }

    void isExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }
        uiBean.setKykKihon(kykKihon);
    }

    void checkJyoutai() {

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            addConversationMessageId(checkYuukouJyoutai.getWarningMessageIDList(),
                checkYuukouJyoutai.getWarningMessageList(), KhKanaKanjiTeiseiConstants.INPUTKEYWARNING);
        }
    }

    void setTtdkTyuui() {

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhKanaKanjiTeiseiConstants.INPUTKEYWARNING,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
    }

    void checkHansyaSentakuInfo(C_HnsychkTaisyousyaKbn pHnsychkTaisyousyaKbn, String pNmKn, String pNmKj,
        C_KjkhukaKbn pKjkhukaKbn, BizDate pBirthday, String pMailNo, C_ErrorKbn pTtyotkhknhyjsetkbn,
        C_UmuKbn pHouteityotkhknhyj, C_UmuKbn pTyotkhknhyj) {

        CheckHansyaSentakuInfo checkHansyaSentakuInfo = SWAKInjector.getInstance(CheckHansyaSentakuInfo.class);

        boolean warningFlg = checkHansyaSentakuInfo.exec(pHnsychkTaisyousyaKbn, pNmKn, pNmKj, pKjkhukaKbn, pBirthday,
            pMailNo, pTtyotkhknhyjsetkbn, pHouteityotkhknhyj, pTyotkhknhyj);
        List<String> worningMsgIdList = checkHansyaSentakuInfo.getWarningMsgIdList();
        List<String> worningMsgList = checkHansyaSentakuInfo.getWarningMsgList();

        if (!warningFlg) {
            for (int count = 0; count < worningMsgIdList.size(); count++) {
                if ("WIA1029".equals(worningMsgIdList.get(count))) {
                    if (!tyotkhknhyjErrorflg) {

                        messageManager.addConversationMessageId(KhKanaKanjiTeiseiConstants.SYOUKAIWARNING,
                            BizUtil.getGeneralMessageId(worningMsgIdList.get(count)),
                            worningMsgList.get(count));
                        tyotkhknhyjErrorflg = true;
                    }
                }
                else {

                    messageManager.addConversationMessageId(KhKanaKanjiTeiseiConstants.SYOUKAIWARNING,
                        BizUtil.getGeneralMessageId(worningMsgIdList.get(count)),
                        worningMsgList.get(count));
                }
            }
        }
    }

    void kanaChk(String pKana, String messageParam, int checkParam) {

        if (checkParam == 0) {
            if (!CheckKana.isKyokaMoji(pKana)) {
                throw new BizLogicException(MessageId.EBC0046, messageParam);
            }
        }
        else {
            if (!CheckKana.isKyoyouKetaHankaku(pKana, YuyuBizConfig.getInstance().getKanaNmKyoyou())) {
                throw new BizLogicException(MessageId.EBC0004, messageParam,
                    YuyuBizConfig.getInstance().getKanaNmKyoyou().toString());
            }
        }
    }

    void kanjiChk(String pKanj, String messageParam) {
        if (!CheckMeigininNmKanji.isCheckOK(pKanj, C_Kojinhjn.KOJIN)) {
            throw new BizLogicException(MessageId.EBC0046, messageParam);
        }
    }
    void nyuuryokuChk (String pInputStr, String messageParam, int checkParam) {

        if (checkParam == 0) {
            if (StringUtil.isNullOrBlank(pInputStr)) {
                throw new BizLogicException(MessageId.EBC0043, messageParam);
            }
        }
        else {
            if (!StringUtil.isNullOrBlank(pInputStr)) {
                throw new BizLogicException(MessageId.EBC0007, messageParam);
            }
        }
    }

    void addConversationMessageId(List<String> pWarningMessageIdLst, List<String> pWarningMessageLst, int pGroupId) {

        if (pWarningMessageIdLst != null) {
            for (int i = 0; i < pWarningMessageIdLst.size(); i++) {

                String warningMessageId = pWarningMessageIdLst.get(i);
                messageManager.addConversationMessageId(pGroupId, BizUtil.getGeneralMessageId(warningMessageId),
                    pWarningMessageLst.get(i));
            }
        }
    }

    private void khLincSousinDataSyori(KhozenCommonParam pKhozenCommonParam, BizDate pSyoriYmd,
        IT_BAK_KykKihon pBAK_KykKihon) {

        IT_KhLincKihon khLincKihon = uiBean.getKykKihon().getKhLincKihon();

        Long linckanyuusyano = null;
        if (khLincKihon != null) {
            linckanyuusyano = khLincKihon.getLinckanyuusyano();
        }

        HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);
        HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

        hanteiLincBean.setSyoriYmd(pSyoriYmd);
        hanteiLincBean.setBakKykKihon(pBAK_KykKihon);
        hanteiLincBean.setKykKihon(uiBean.getKykKihon());
        hanteiLincBean.setKanyuusyaNo(linckanyuusyano);

        hanteiLinc.exec(hanteiLincBean, pKhozenCommonParam);
    }


}
