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
import yuyu.common.hozen.khcommon.JtKaisukeisan;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
/**
 * 契約保全 案内収納共通 年１回払年２回払領収金額計算
 */
public class KeisanNenHalfyRsgaku {

    private String errorRiyuu;

    private List<String> errorCd;

    private KeisanRsgkOutBean keisanRsgkOutBean;

    @Inject
    private static Logger logger;

    public C_ErrorKbn exec(KeisanNenHalfyRsgakuBean pKeisanNenHalfyRsgakuBean) {

        logger.debug("▽ 年１回払年２回払領収金額計算 開始");

        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKeisanNenHalfyRsgakuBean == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getHrkkaisuu() == null ||
            C_Hrkkaisuu.BLNK.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getNykkeiro() == null ||
            C_Nykkeiro.BLNK.eq(pKeisanNenHalfyRsgakuBean.getNykkeiro())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getNyknaiyoukbn() == null ||
            C_NyknaiyouKbn.BLNK.eq(pKeisanNenHalfyRsgakuBean.getNyknaiyoukbn())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getRsymd() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getJyutoustartym() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (!C_Hrkkaisuu.NEN.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu()) &&
            !C_Hrkkaisuu.HALFY.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_HRKKAISUU_CHKERROR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKAISUU_CHKERROR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (C_Hrkkaisuu.NEN.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu()) &&
            pKeisanNenHalfyRsgakuBean.getJyuutounensuu() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (C_Hrkkaisuu.HALFY.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu()) &&
            pKeisanNenHalfyRsgakuBean.getJyuutoutukisuu() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getRstuukasyu() == null ||
            C_Tuukasyu.BLNK.eq(pKeisanNenHalfyRsgakuBean.getRstuukasyu())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanNenHalfyRsgakuBean.getKeisanRsgakuSyouhinBeanLst() == null ||
            pKeisanNenHalfyRsgakuBean.getKeisanRsgakuSyouhinBeanLst().size() == 0) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return resultKbn;
        }

        for (KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean : pKeisanNenHalfyRsgakuBean.getKeisanRsgakuSyouhinBeanLst()) {

            if (BizUtil.isBlank(keisanRsgakuSyouhinBean.getSyouhncd())) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 年１回払年２回払領収金額計算 終了");

                return resultKbn;
            }

            if (keisanRsgakuSyouhinBean.getSyouhnsdno() == null) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 年１回払年２回払領収金額計算 終了");

                return resultKbn;
            }

            if (BizUtil.isBlank(keisanRsgakuSyouhinBean.getRyouritusdno())) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 年１回払年２回払領収金額計算 終了");

                return resultKbn;
            }

            if (keisanRsgakuSyouhinBean.getHokenryou() == null ||
                keisanRsgakuSyouhinBean.getHokenryou().isOptional()) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 年１回払年２回払領収金額計算 終了");

                return resultKbn;
            }
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType rstuukaCurrencyType = henkanTuuka.henkanTuukaKbnToType(pKeisanNenHalfyRsgakuBean.getRstuukasyu());
        BizCurrency hokenryouGoukei = BizCurrency.valueOf(0, rstuukaCurrencyType);
        Integer annaikaisuu = 0;

        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = new ArrayList<KeisanRsgkUtiwakeBean>();
        JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

        jtKaisukeisan.exec(pKeisanNenHalfyRsgakuBean.getJyuutounensuu(), pKeisanNenHalfyRsgakuBean.getJyuutoutukisuu(),
            pKeisanNenHalfyRsgakuBean.getHrkkaisuu());

        annaikaisuu = jtKaisukeisan.getJyutoukaisuu();

        BizCurrency hokenryouTukiGoukei = BizCurrency.valueOf(0, rstuukaCurrencyType);
        BizDate ryosyuKwsrateKjymd = null;
        BizNumber ryosyuKwsrate = BizNumber.valueOf(0);
        C_Tuukasyu hokenryouTuukasyu = C_Tuukasyu.BLNK;

        for (KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean : pKeisanNenHalfyRsgakuBean.getKeisanRsgakuSyouhinBeanLst()) {

            hokenryouTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(keisanRsgakuSyouhinBean.getHokenryou().getType());

            if (!pKeisanNenHalfyRsgakuBean.getRstuukasyu().eq(hokenryouTuukasyu)) {

                GetHrkKawaseRateKijyun getHrkKawaseRateKijyun = SWAKInjector.getInstance(GetHrkKawaseRateKijyun.class);

                C_ErrorKbn getHrkKawaseRateKijyunResult = getHrkKawaseRateKijyun.exec(
                    pKeisanNenHalfyRsgakuBean.getNyknaiyoukbn(),
                    pKeisanNenHalfyRsgakuBean.getNykkeiro(),
                    pKeisanNenHalfyRsgakuBean.getRsymd(),
                    pKeisanNenHalfyRsgakuBean.getJyutoustartym(),
                    pKeisanNenHalfyRsgakuBean.getJyuutounensuu(),
                    pKeisanNenHalfyRsgakuBean.getJyuutoutukisuu(),
                    pKeisanNenHalfyRsgakuBean.getHrkkaisuu());

                if (C_ErrorKbn.ERROR.eq(getHrkKawaseRateKijyunResult)) {

                    resultKbn = C_ErrorKbn.ERROR;

                    errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_HRKKWSRATEKJYMD_ERR
                        + getHrkKawaseRateKijyun.getErrorRiyuu();
                    errorCd.add(KeisanRsgakuConstants.ERRCD_HRKKWSRATEKJYMD_ERR);
                    errorCd.addAll(getHrkKawaseRateKijyun.getErrorCd());

                    logger.debug("△ 年１回払年２回払領収金額計算 終了");

                    return resultKbn;
                }

                KeisanPRsTuukaKnsn keisanPRsTuukaKnsn = SWAKInjector.getInstance(KeisanPRsTuukaKnsn.class);

                C_ErrorKbn keisanPRsTuukaKnsnResult = keisanPRsTuukaKnsn.exec(
                    getHrkKawaseRateKijyun.getKawaseRateKijyun(),
                    keisanRsgakuSyouhinBean.getHokenryou(),
                    hokenryouTuukasyu,
                    pKeisanNenHalfyRsgakuBean.getRstuukasyu());

                if (C_ErrorKbn.ERROR.eq(keisanPRsTuukaKnsnResult)) {

                    resultKbn = C_ErrorKbn.ERROR;

                    errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_PTUUKAKNSN_ERR
                        + keisanPRsTuukaKnsn.getErrorRiyuu();
                    errorCd.add(KeisanRsgakuConstants.ERRCD_PTUUKAKNSN_ERR);
                    errorCd.addAll(keisanPRsTuukaKnsn.getErrorCd());

                    logger.debug("△ 年１回払年２回払領収金額計算 終了");

                    return resultKbn;
                }

                hokenryouTukiGoukei = hokenryouTukiGoukei.add(keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsngop());

                ryosyuKwsrateKjymd = keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsnkwsratekjnymd();

                ryosyuKwsrate = keisanPRsTuukaKnsn.getPRsTuukaKnsn().getRstuukaknsnkwsrate();
            }
            else {

                hokenryouTukiGoukei = hokenryouTukiGoukei.add(keisanRsgakuSyouhinBean.getHokenryou());
            }
        }

        BizDateYM jyutoustartym = pKeisanNenHalfyRsgakuBean.getJyutoustartym();

        for (int i = 0; i < annaikaisuu; i++) {

            hokenryouGoukei = hokenryouGoukei.add(hokenryouTukiGoukei);

            KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);

            keisanRsgkUtiwakeBean.setJyutoustartym(jyutoustartym);

            if (C_Hrkkaisuu.NEN.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu())) {

                keisanRsgkUtiwakeBean.setJyuutounensuu(1);
            }
            else {

                keisanRsgkUtiwakeBean.setJyuutounensuu(0);
            }

            if (C_Hrkkaisuu.HALFY.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu())) {

                keisanRsgkUtiwakeBean.setJyuutoutukisuu(6);
            }
            else {

                keisanRsgkUtiwakeBean.setJyuutoutukisuu(0);
            }

            keisanRsgkUtiwakeBean.setRsgaku(hokenryouTukiGoukei);
            keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(ryosyuKwsrateKjymd);
            keisanRsgkUtiwakeBean.setRyosyukwsrate(ryosyuKwsrate);
            keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.NONE);
            keisanRsgkUtiwakeBean.setIktwaribikikgk(BizCurrency.valueOf(0, rstuukaCurrencyType));

            keisanRsgkUtiwakeBeanLst.add(keisanRsgkUtiwakeBean);

            if (C_Hrkkaisuu.NEN.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu())) {

                jyutoustartym = jyutoustartym.addYears(1);
            }

            else if (C_Hrkkaisuu.HALFY.eq(pKeisanNenHalfyRsgakuBean.getHrkkaisuu())) {

                jyutoustartym = jyutoustartym.addMonths(6);
            }
        }

        keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);
        keisanRsgkOutBean.setRsgakuGoukei(hokenryouGoukei);
        keisanRsgkOutBean.setIktwaribikikgkGoukei(BizCurrency.valueOf(0, rstuukaCurrencyType));
        keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanLst);

        logger.debug("△ 年１回払年２回払領収金額計算 終了");

        return resultKbn;
    }

    public C_ErrorKbn exec(IT_KykKihon pKykKihon,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyouKbn,
        BizDate pRsymd,
        BizDateYM pJyutoustartym,
        Integer pJyuutounensuu,
        Integer pJyuutoutukisuu) {

        logger.debug("▽ 年１回払年２回払領収金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKykKihon == null) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        if (pNykkeiro == null || C_Nykkeiro.BLNK.eq(pNykkeiro)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        if (pNyknaiyouKbn == null || C_NyknaiyouKbn.BLNK.eq(pNyknaiyouKbn)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        if (pRsymd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        if (pJyutoustartym == null) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        if (pJyuutounensuu == null) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        if (pJyuutoutukisuu == null) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhns();

        List<KeisanRsgakuSyouhinBean> keisanTukiRsgakuBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();

        for (IT_KykSyouhn kykSyouhn: kykSyouhnList) {

            KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);

            keisanRsgakuSyouhinBean.setSyouhncd(kykSyouhn.getSyouhncd());
            keisanRsgakuSyouhinBean.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
            keisanRsgakuSyouhinBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
            keisanRsgakuSyouhinBean.setHokenryou(kykSyouhn.getHokenryou());

            keisanTukiRsgakuBeanList.add(keisanRsgakuSyouhinBean);
        }

        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

        C_ErrorKbn getasPRsTuukaResult = getasPRsTuuka.exec(pKykKihon.getSyono());

        if (C_ErrorKbn.ERROR.eq(getasPRsTuukaResult)) {

            errorKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_PRSTUUKA_ERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_PRSTUUKA_ERR);

            logger.debug("△ 年１回払年２回払領収金額計算 終了");

            return errorKbn;
        }

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        keisanNenHalfyRsgakuBean.setNykkeiro(pNykkeiro);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(pNyknaiyouKbn);
        keisanNenHalfyRsgakuBean.setRsymd(pRsymd);
        keisanNenHalfyRsgakuBean.setJyutoustartym(pJyutoustartym);
        keisanNenHalfyRsgakuBean.setJyuutounensuu(pJyuutounensuu);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(pJyuutoutukisuu);
        keisanNenHalfyRsgakuBean.setRstuukasyu(getasPRsTuuka.getRstuukasyu());
        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanTukiRsgakuBeanList);

        C_ErrorKbn keisanNenHalfyRsgakuResult = exec(keisanNenHalfyRsgakuBean);

        if (C_ErrorKbn.ERROR.eq(keisanNenHalfyRsgakuResult)) {

            errorKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 年１回払年２回払領収金額計算 終了");

        return errorKbn;
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
}
