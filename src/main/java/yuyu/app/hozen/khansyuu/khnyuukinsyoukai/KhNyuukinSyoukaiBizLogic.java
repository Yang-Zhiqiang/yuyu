package yuyu.app.hozen.khansyuu.khnyuukinsyoukai;

import static yuyu.app.hozen.khansyuu.khnyuukinsyoukai.GenKhNyuukinSyoukaiConstants.*;
import static yuyu.app.hozen.khansyuu.khnyuukinsyoukai.KhNyuukinSyoukaiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.hozen.khansyuu.khnyuukinsyoukai.dba.KhNyuukinSyoukaiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.CheckHrkkigetuMitouraiP;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuConstants;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetDattai;
import yuyu.common.hozen.setuibean.SetHaraikomiInfo;
import yuyu.common.hozen.setuibean.SetKariukekin;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetTetudukityuui;
import yuyu.common.hozen.setuibean.SetTokusin;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyksyoukaiKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 入金照会 のビジネスロジックです。
 */
public class KhNyuukinSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhNyuukinSyoukaiUiBean uiBean;

    @Inject
    private KhNyuukinSyoukaiDao khNyuukinSyoukaiDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
        clear();
    }

    void clear() {
    }

    public void nyuuryokuBtnSyori(){
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyono(uiBean.getVkihnsyono());

        IT_KykKihon kykKihon = khNyuukinSyoukaiDao.getKykKihon(uiBean.getSyono());

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {
            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {
                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, checkYuukouJyoutai
                    .getWarningMessageIDList().get(i), checkYuukouJyoutai.getWarningMessageList().get(i));
            }
        }

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, uiBean.getSyono());

        if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
            throw new BizLogicException(hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }
        else if (C_SyorikahiKbn.TYUUITRATKIKA.eq(syorikahiKbn)) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                hanteiTetuduki.getMessageID(), hanteiTetuduki.getMessageParam());
        }

        IT_AnsyuKihon ansyuKihon = khNyuukinSyoukaiDao.getAnsyuKihon(uiBean.getSyono());
        BizDateYM jyuutouym = ansyuKihon.getJkipjytym();

        Integer jyutoukaisuuy = null;
        Integer jyutoukaisuum = null;
        if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
            if (C_TkiktbrisyuruiKbn.BLNK.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.NONE.eq(kykKihon.getTikiktbrisyuruikbn())) {
                jyutoukaisuum = 1;
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                jyutoukaisuum = 6;
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                jyutoukaisuum = 12;
            }
        }
        else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {
            jyutoukaisuuy = 1;
        }
        else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {
            jyutoukaisuum = 6;
        }

        uiBean.setNyksyoukaikbn(C_NyksyoukaiKbn.KEIZOKUPNYUUKINNSISAN);
        uiBean.setJyuutouym(jyuutouym);
        uiBean.setJyutoukaisuuy(jyutoukaisuuy);
        uiBean.setJyutoukaisuum(jyutoukaisuum);

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);
        setToriatukaiTyuui.exec(khozenCommonParam, uiBean);

        SetKihon.exec(khozenCommonParam, uiBean);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);
        setBetukyk.exec(khozenCommonParam, uiBean);
        for(int i = 0; i< uiBean.getWarningMessageIdList().size(); i++){
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, BizUtil
                .getGeneralMessageId(uiBean.getWarningMessageIdList().get(i)), uiBean.getWarningMessageList().get(i));
        }

        SetTetudukityuui.exec(khozenCommonParam, uiBean);

        SetKeiyakusya.exec(khozenCommonParam, uiBean);

        SetHaraikomiInfo setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);
        setHaraikomiInfo.exec(khozenCommonParam, uiBean);

        SetTokusin.exec(khozenCommonParam, uiBean);

        SetKariukekin setKariukekin = SWAKInjector.getInstance(SetKariukekin.class);
        setKariukekin.exec(khozenCommonParam, uiBean);

        SetDattai.exec(khozenCommonParam, uiBean);
    }

    public void syoukaiBtnSyori(){
        checkZero();

        IT_KykKihon kykKihon = khNyuukinSyoukaiDao.getKykKihon(uiBean.getSyono());
        C_Hrkkaisuu hrkkaisuu = kykKihon.getHrkkaisuu();
        C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = kykKihon.getTikiktbrisyuruikbn();
        C_Hrkkeiro hrkkeiro = kykKihon.getHrkkeiro();
        BizCurrency hrkp = kykKihon.getHrkp();

        List<IT_KykSyouhn> kykSyouhnLst = khNyuukinSyoukaiDao.getKykSyouhn(kykKihon, C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        BizDate kykymd = kykSyouhn.getKykymd();
        C_Kykjyoutai kykjyoutai = kykSyouhn.getKykjyoutai();
        String syouhncd = kykSyouhn.getSyouhncd();
        C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();

        IT_AnsyuKihon ansyuKihon = khNyuukinSyoukaiDao.getAnsyuKihon(uiBean.getSyono());
        BizDateYM jyuutouym = ansyuKihon.getJkipjytym();
        BizDate syuharaimanymd = ansyuKihon.getSyuharaimanymd();

        BizDateYM annaisaikaiym = null;

        /**
        if (C_NyksyoukaiKbn.ZENNOUNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) {
            annaisaikaiym = jyuutouym.addYears(uiBean.getJyutoukaisuuy());
        }
         */

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        C_Tuukasyu hrkpTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(hrkp.getType());

        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

        C_ErrorKbn errorKbn = getasPRsTuuka.exec(uiBean.getSyono());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException("保険料領収通貨取得エラー。　証券番号＝" + uiBean.getSyono());
        }

        C_Tuukasyu rstuukasyu = getasPRsTuuka.getRstuukasyu();

        if (!hrkpTuukasyu.eq(rstuukasyu)) {
            uiBean.setKeisanprstuukaknsnumn(C_UmuKbn.ARI);
        }
        else {
            uiBean.setKeisanprstuukaknsnumn(C_UmuKbn.NONE);
        }

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        boolean syoriKekka = checkYuuyokkngai.exec(uiBean.getSyono(), uiBean.getRsyymd());

        if (!syoriKekka) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIA0007,
                RYOUSYUYMD);
        }

        if (C_UmuKbn.ARI.eq(uiBean.getKeisanprstuukaknsnumn())) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF3013);
        }

        /**
        if (C_NyksyoukaiKbn.ZENNOUNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) {
            if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                throw new BizLogicException("{入金照会区分名}は、年１回払契約・１２ヶ月定期一括契約のみ指定可能です。");
            }
            else if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                if (C_TkiktbrisyuruiKbn.BLNK.eq(tkiktbrisyuruiKbn) ||
                    C_TkiktbrisyuruiKbn.NONE.eq(tkiktbrisyuruiKbn) ||
                    C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tkiktbrisyuruiKbn)) {
                    throw new BizLogicException("{入金照会区分名}は、年１回払契約・１２ヶ月定期一括契約のみ指定可能です。");
                }
            }

            if (uiBean.getJyuutouym() != null) {
                throw new BizLogicException(" {入金照会区分名}の場合、充当年月は指定できません。");
            }

            if (uiBean.getJyutoukaisuum() != null) {
                throw new BizLogicException(MessageId.EIF3007, uiBean.getNyksyoukaikbn().getContent());
            }

            if (uiBean.getJyutoukaisuuy() == null) {
                throw new BizLogicException(MessageId.EIF3008, uiBean.getNyksyoukaikbn().getContent());
            }

            if (uiBean.getJyutoukaisuuy() < 2) {
                throw new BizLogicException(MessageId.EIF3016, uiBean.getNyksyoukaikbn().getContent());
            }

            BizDate rskakoymd = BizDate.valueOf(jyuutouym.addYears(-1), kykymd.getDay());
            if (!rskakoymd.isRekijyou()) {
                rskakoymd = rskakoymd.getRekijyou();
            }

            if (BizDateUtil.compareYmd(uiBean.getRsyymd(), rskakoymd) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIF3010, uiBean.getNyksyoukaikbn().getContent());
            }
        }
         */

        if (C_NyksyoukaiKbn.KEIZOKUPNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) {
            if (uiBean.getJyutoukaisuuy() == null && uiBean.getJyutoukaisuum() == null) {
                throw new BizLogicException(MessageId.EIF3062, uiBean.getNyksyoukaikbn().getContent());
            }

            if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                if (uiBean.getJyutoukaisuuy() == null) {
                    throw new BizLogicException(MessageId.EIF3008, hrkkaisuu.getContent());
                }

                if (uiBean.getJyutoukaisuum() != null) {
                    throw new BizLogicException(MessageId.EIF3007, hrkkaisuu.getContent());
                }
            }

            if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu) || C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                if (uiBean.getJyutoukaisuuy() != null) {
                    throw new BizLogicException(MessageId.EIF3012, hrkkaisuu.getContent());
                }
            }

            if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                if (uiBean.getJyutoukaisuum() != 6 && uiBean.getJyutoukaisuum() != 12) {
                    throw new BizLogicException(MessageId.EIF3063, hrkkaisuu.getContent(), JUNE_OR_DECEMBER);
                }
            }
            else if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                if (C_TkiktbrisyuruiKbn.BLNK.eq(tkiktbrisyuruiKbn) || C_TkiktbrisyuruiKbn.NONE.eq(tkiktbrisyuruiKbn)) {
                    if (uiBean.getJyutoukaisuum() < 1 || uiBean.getJyutoukaisuum() > 12) {
                        throw new BizLogicException(MessageId.EIF3063, hrkkaisuu.getContent(), JANUARY_FROM_DECEMBER);
                    }
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(tkiktbrisyuruiKbn)) {
                    if (uiBean.getJyutoukaisuum() != 6 && uiBean.getJyutoukaisuum() != 12) {
                        throw new BizLogicException(MessageId.EIF3063, tkiktbrisyuruiKbn.getContent(),JUNE_OR_DECEMBER);
                    }
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(tkiktbrisyuruiKbn)) {
                    if (uiBean.getJyutoukaisuum() != 12) {
                        throw new BizLogicException(MessageId.EIF3063, tkiktbrisyuruiKbn.getContent(), DECEMBER);
                    }
                }
            }

            if (C_Hrkkaisuu.NEN.eq(hrkkaisuu) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP =
                    SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);

                boolean existsFlg = checkHrkkigetuMitouraiP.exists(uiBean.getRsyymd(), uiBean.getJyuutouym(),
                    hrkkaisuu, uiBean.getJyutoukaisuuy() == null ? 0 : uiBean.getJyutoukaisuuy(),
                        uiBean.getJyutoukaisuum() == null ? 0 : uiBean.getJyutoukaisuum());

                if (existsFlg) {
                    throw new BizLogicException(MessageId.EIF3077);
                }
            }
        }

        BizDateYM newJyuutouym = uiBean.getJyuutouym();
        if (uiBean.getJyutoukaisuuy() != null) {
            newJyuutouym = newJyuutouym.addYears(uiBean.getJyutoukaisuuy());
        }
        if (uiBean.getJyutoukaisuum() != null ) {
            newJyuutouym = newJyuutouym.addMonths(uiBean.getJyutoukaisuum());
        }

        if (BizDateUtil.compareYm(syuharaimanymd.getBizDateYM(), newJyuutouym) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EIF3071);
        }

        if (!C_Kykjyoutai.HRKMTYUU.eq(kykjyoutai) && !C_Kykjyoutai.IKKATUNK.eq(kykjyoutai)) {
            throw new BizLogicException(MessageId.EIF3064, uiBean.getNyksyoukaikbn().getContent());
        }

        BizCurrency rsgaku = BizCurrency.valueOf(0);
        BizDate ryosyujikwsratekjymd = null;
        BizNumber ryosyujikwsrate = BizNumber.optional();
        BizDate hrkkigenymd = null;

        /**
        if (C_NyksyoukaiKbn.ZENNOUNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) {
            KeisanZennouNyuukinGk keisanZennouNyuukinGk = SWAKInjector.getInstance(KeisanZennouNyuukinGk.class);

            C_ErrorKbn newErrorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(syouhncd, kykymd, hrkp,
                uiBean.getRsyymd(), jyuutouym, uiBean.getJyutoukaisuuy());

            rsgaku = keisanZennouNyuukinGk.getZennouNyuukinGk();
        }
         */

        if (C_NyksyoukaiKbn.KEIZOKUPNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) {
            C_Nykkeiro nykkeiro = C_Nykkeiro.BLNK;

            if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                nykkeiro = C_Nykkeiro.OTHER;
            }
            if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                nykkeiro = C_Nykkeiro.CREDIT;
            }

            Integer jyuutounensuu = 0;
            Integer jyuutoutukisuu = 0;
            if (uiBean.getJyutoukaisuuy() != null) {
                jyuutounensuu = uiBean.getJyutoukaisuuy();
            }
            if (uiBean.getJyutoukaisuum() != null) {
                jyuutoutukisuu = uiBean.getJyutoukaisuum();
            }

            KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

            C_ErrorKbn newErrorKbn = keisanRsgaku.exec(kykKihon, nykkeiro, C_NyknaiyouKbn.KEIZOKUP, uiBean.getRsyymd(),
                uiBean.getJyuutouym(), jyuutounensuu, jyuutoutukisuu);

            if (C_ErrorKbn.ERROR.eq(newErrorKbn)) {
                String errorRiyuu =  keisanRsgaku.getErrorRiyuu();
                List<String> errorCd = keisanRsgaku.getErrorCd();

                if (errorCd.contains(KeisanRsgakuConstants.ERRCD_WARIBIKITEKIYOUKIKAN_ERR)) {
                    throw new BizLogicException(MessageId.EIF3065);
                }
                else if (errorCd.contains(KeisanRsgakuConstants.ERRCD_KAWASERATESYUTOKUERR)) {
                    throw new BizLogicException(MessageId.EIF3066);
                }
                else {
                    throw new CommonBizAppException(
                        "領収金額計算エラー。エラー理由＝" + errorRiyuu + "　証券番号＝" + uiBean.getSyono());
                }
            }

            KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
            rsgaku = keisanRsgkOutBean.getRsgakuGoukei();

            if (keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().size() > 0) {
                ryosyujikwsratekjymd = keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsratekjymd();
                ryosyujikwsrate = keisanRsgkOutBean.getKeisanRsgkUtiwakeBeanLst().get(0).getRyosyukwsrate();
            }
        }

        if (C_NyksyoukaiKbn.KEIZOKUPNYUUKINNSISAN.eq(uiBean.getNyksyoukaikbn())) {
            if (C_UmuKbn.ARI.eq(uiBean.getKeisanprstuukaknsnumn())) {

                hrkkigenymd = uiBean.getRsyymd().getBizDateYM().getLastDay().
                    getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
            }
            else {
                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

                setYuuyokknmanryobi.exec(uiBean.getSyono(), uiBean.getJyuutouym());

                hrkkigenymd = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();
            }
        }

        uiBean.setRsgaku(rsgaku);
        uiBean.setAnnaisaikaiym(annaisaikaiym);
        uiBean.setRyosyujikwsratekjymd(ryosyujikwsratekjymd);
        uiBean.setRyosyujikwsrate(ryosyujikwsrate);
        uiBean.setRstuukasyu(rstuukasyu);
        uiBean.setKyktuukasyu(kyktuukasyu);
        uiBean.setHrkkigenymd(hrkkigenymd);

        if (C_UmuKbn.ARI.eq(uiBean.getKeisanprstuukaknsnumn()) &&
            BizDateUtil.compareYmd(uiBean.getRsyymd().getBizDateYM().addMonths(-1).getLastDay().
                getBusinessDay(CHolidayAdjustingMode.PREVIOUS), ryosyujikwsratekjymd) == BizDateUtil.COMPARE_EQUAL) {

            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING2, MessageId.WIF3024);
        }
    }

    void pushModorubtnbysyoukaiBL() {

        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

        uiBean.setRsgaku(BizCurrency.optional());
        uiBean.setAnnaisaikaiym(null);
        uiBean.setRyosyujikwsratekjymd(null);
        uiBean.setRyosyujikwsrate(BizNumber.optional());
        uiBean.setRstuukasyu(C_Tuukasyu.BLNK);
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
    }

    private void checkZero() {
        if (uiBean.getJyutoukaisuuy() != null && uiBean.getJyutoukaisuuy() == 0) {
            errorMessageCollector.addMessage(MessageId.EAV0019, DDID_NYUUKINSYOUKAIINFO_JYUTOUKAISUUY);
        }

        if (uiBean.getJyutoukaisuum() != null && uiBean.getJyutoukaisuum() == 0) {
            errorMessageCollector.addMessage(MessageId.EAV0019, DDID_NYUUKINSYOUKAIINFO_JYUTOUKAISUUM);
        }

        if (errorMessageCollector.exists()) {
            throw new BizLogicException(errorMessageCollector);
        }
    }
}
