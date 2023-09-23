package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanIkkatuWaribikiKikan;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 案内収納共通 月払領収金額計算
 */
public class KeisanTukiRsgaku {

    private String errorRiyuu;

    private List<String> errorCd;

    private KeisanRsgkOutBean keisanRsgkOutBean;

    @Inject
    private static Logger logger;

    public KeisanTukiRsgaku() {
        super();
    }

    public String getErrorRiyuu() {
        return errorRiyuu;
    }

    public List<String> getErrorCd() {
        return errorCd;
    }

    public KeisanRsgkOutBean getKeisanRsgkOutBean() {
        return keisanRsgkOutBean;
    }

    public C_ErrorKbn exec(KeisanTukiRsgakuBean pKeisanTukiRsgakuBean) {

        logger.debug("▽ 月払領収金額計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKeisanTukiRsgakuBean == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getNykkeiro() == null ||
            C_Nykkeiro.BLNK.eq(pKeisanTukiRsgakuBean.getNykkeiro())) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getNyknaiyoukbn() == null ||
            C_NyknaiyouKbn.BLNK.eq(pKeisanTukiRsgakuBean.getNyknaiyoukbn())) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getRsymd() == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getJyutoustartym() == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getJyuutoutukisuu() == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getRstuukasyu() == null ||
            C_Tuukasyu.BLNK.eq(pKeisanTukiRsgakuBean.getRstuukasyu())) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pKeisanTukiRsgakuBean.getKeisanRsgakuSyouhinBeanLst() == null ||
            pKeisanTukiRsgakuBean.getKeisanRsgakuSyouhinBeanLst().size() == 0) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        for (KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean : pKeisanTukiRsgakuBean.getKeisanRsgakuSyouhinBeanLst()) {

            if (BizUtil.isBlank(keisanRsgakuSyouhinBean.getSyouhncd())) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 月払領収金額計算 終了");
                return kekkaKbn;
            }

            if (keisanRsgakuSyouhinBean.getSyouhnsdno() == null) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 月払領収金額計算 終了");
                return kekkaKbn;
            }

            if (BizUtil.isBlank(keisanRsgakuSyouhinBean.getRyouritusdno())) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 月払領収金額計算 終了");
                return kekkaKbn;
            }

            if (keisanRsgakuSyouhinBean.getHokenryou() == null || keisanRsgakuSyouhinBean.getHokenryou().isOptional()) {

                kekkaKbn = C_ErrorKbn.ERROR;
                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 月払領収金額計算 終了");
                return kekkaKbn;
            }
        }

        KeisanIkkatuWaribikiKikan ikkatuWaribikiKikan = SWAKInjector.getInstance(KeisanIkkatuWaribikiKikan.class);

        ikkatuWaribikiKikan.exec(
            pKeisanTukiRsgakuBean.getRsymd(),
            pKeisanTukiRsgakuBean.getJyutoustartym(),
            pKeisanTukiRsgakuBean.getJyuutoutukisuu());

        int wrbkTekikknTksu = ikkatuWaribikiKikan.getWrbkTekikknTksu();

        if (wrbkTekikknTksu >= 3) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_WARIBIKITEKIYOUKIKAN_ERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_WARIBIKITEKIYOUKIKAN_ERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType rstuukaCurrencyType = henkanTuuka.henkanTuukaKbnToType(pKeisanTukiRsgakuBean.getRstuukasyu());
        BizCurrency hokenryouGoukei = BizCurrency.valueOf(0, rstuukaCurrencyType);
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanlist = new ArrayList<KeisanRsgkUtiwakeBean>();
        BizCurrency hokenryouTukiGoukei = BizCurrency.valueOf(0, rstuukaCurrencyType);
        BizDate rsKwsrateKjymd = null;
        BizNumber rsKwsrate = BizNumber.valueOf(0);
        C_Tuukasyu hokenryouTuukasyu = C_Tuukasyu.BLNK;

        for (KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean : pKeisanTukiRsgakuBean.getKeisanRsgakuSyouhinBeanLst()) {

            hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(keisanRsgakuSyouhinBean.getHokenryou().getType());

            if (!hokenryouTuukasyu.eq(pKeisanTukiRsgakuBean.getRstuukasyu())) {

                GetHrkKawaseRateKijyun getHrkKawaseRateKijyun = SWAKInjector.getInstance(GetHrkKawaseRateKijyun.class);

                C_ErrorKbn errorKbn = getHrkKawaseRateKijyun.exec(
                    pKeisanTukiRsgakuBean.getNyknaiyoukbn(),
                    pKeisanTukiRsgakuBean.getNykkeiro(),
                    pKeisanTukiRsgakuBean.getRsymd(),
                    pKeisanTukiRsgakuBean.getJyutoustartym(),
                    0,
                    pKeisanTukiRsgakuBean.getJyuutoutukisuu(),
                    C_Hrkkaisuu.TUKI);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    kekkaKbn = C_ErrorKbn.ERROR;

                    errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_HRKKWSRATEKJYMD_ERR + getHrkKawaseRateKijyun.getErrorRiyuu();
                    errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKWSRATEKJYMD_ERR);
                    errorCd.addAll(getHrkKawaseRateKijyun.getErrorCd());

                    logger.debug("△ 月払領収金額計算 終了");
                    return kekkaKbn;
                }

                KeisanPRsTuukaKnsn keisanPRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsn.class);

                C_ErrorKbn keisanPRsTuukaKnsnErrorKbn = keisanPRsTuukaKnsn.exec(
                    getHrkKawaseRateKijyun.getKawaseRateKijyun(),
                    keisanRsgakuSyouhinBean.getHokenryou(),
                    hokenryouTuukasyu,
                    pKeisanTukiRsgakuBean.getRstuukasyu());

                if (C_ErrorKbn.ERROR.eq(keisanPRsTuukaKnsnErrorKbn)) {

                    kekkaKbn = C_ErrorKbn.ERROR;

                    errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_PTUUKAKNSN_ERR + keisanPRsTuukaKnsn.getErrorRiyuu();
                    errorCd.add(KeisanRsgakuConstants.ERRCD_PTUUKAKNSN_ERR);
                    errorCd.addAll(keisanPRsTuukaKnsn.getErrorCd());

                    logger.debug("△ 月払領収金額計算 終了");
                    return kekkaKbn;
                }

                KeisanPRsTuukaKnsnKekkaBean keisanPRsTuukaKnsnKekkaBean = keisanPRsTuukaKnsn.getPRsTuukaKnsn();
                hokenryouTukiGoukei = hokenryouTukiGoukei.add(keisanPRsTuukaKnsnKekkaBean.getRstuukaknsngop());
                rsKwsrateKjymd = keisanPRsTuukaKnsnKekkaBean.getRstuukaknsnkwsratekjnymd();
                rsKwsrate = keisanPRsTuukaKnsnKekkaBean.getRstuukaknsnkwsrate();

            }
            else {
                hokenryouTukiGoukei = hokenryouTukiGoukei.add(keisanRsgakuSyouhinBean.getHokenryou());
            }
        }

        BizDateYM jyutoustartYm = pKeisanTukiRsgakuBean.getJyutoustartym();

        for (int i = 0; i < pKeisanTukiRsgakuBean.getJyuutoutukisuu(); i++) {

            hokenryouGoukei = hokenryouGoukei.add(hokenryouTukiGoukei);

            KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);
            keisanRsgkUtiwakeBean.setJyutoustartym(jyutoustartYm);
            keisanRsgkUtiwakeBean.setJyuutounensuu(0);
            keisanRsgkUtiwakeBean.setJyuutoutukisuu(1);
            keisanRsgkUtiwakeBean.setRsgaku(hokenryouTukiGoukei);
            keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(rsKwsrateKjymd);
            keisanRsgkUtiwakeBean.setRyosyukwsrate(rsKwsrate);
            keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.NONE);
            keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(0, rstuukaCurrencyType));

            keisanRsgkUtiwakeBeanlist.add(keisanRsgkUtiwakeBean);

            jyutoustartYm = jyutoustartYm.addMonths(1);
        }

        keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);

        keisanRsgkOutBean.setRsgakuGoukei(hokenryouGoukei);
        keisanRsgkOutBean.setIktwaribikikgkGoukei(BizCurrency.valueOf(0, rstuukaCurrencyType));
        keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanlist);

        logger.debug("△ 月払領収金額計算 終了");

        return kekkaKbn;
    }


    public C_ErrorKbn exec(IT_KykKihon pKykKihon, C_Nykkeiro pNykkeiro, C_NyknaiyouKbn pNyknaiyouKbn, BizDate pRsYmd,
        BizDateYM pJyuutouStartYm, Integer pJyuutoutukisuu ) {

        logger.debug("▽ 月払領収金額計算 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKykKihon ==  null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pNykkeiro == null ||
            C_Nykkeiro.BLNK.eq(pNykkeiro)) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pNyknaiyouKbn == null ||
            C_NyknaiyouKbn.BLNK.eq(pNyknaiyouKbn)) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pRsYmd == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pJyuutouStartYm == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        if (pJyuutoutukisuu == null) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhns();
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<>();

        for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

            KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
            keisanRsgakuSyouhinBean.setSyouhncd(kykSyouhn.getSyouhncd());
            keisanRsgakuSyouhinBean.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
            keisanRsgakuSyouhinBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
            keisanRsgakuSyouhinBean.setHokenryou(kykSyouhn.getHokenryou());

            keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean);
        }

        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
        C_ErrorKbn getasPRsTuukaKekkaKbn = getasPRsTuuka.exec(pKykKihon.getSyono());

        if (C_ErrorKbn.ERROR.eq(getasPRsTuukaKekkaKbn)) {

            kekkaKbn = C_ErrorKbn.ERROR;
            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_PRSTUUKA_ERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_PRSTUUKA_ERR);

            logger.debug("△ 月払領収金額計算 終了");
            return kekkaKbn;
        }

        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(pNykkeiro);
        keisanTukiRsgakuBean.setNyknaiyoukbn(pNyknaiyouKbn);
        keisanTukiRsgakuBean.setRsymd(pRsYmd);
        keisanTukiRsgakuBean.setJyutoustartym(pJyuutouStartYm);
        keisanTukiRsgakuBean.setJyuutoutukisuu(pJyuutoutukisuu);
        keisanTukiRsgakuBean.setRstuukasyu(getasPRsTuuka.getRstuukasyu());
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn keisanTukiRsgakuKekkaKbn = exec(keisanTukiRsgakuBean);

        if (C_ErrorKbn.ERROR.eq(keisanTukiRsgakuKekkaKbn)) {

            kekkaKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 月払領収金額計算 終了");

        return kekkaKbn;
    }
}
