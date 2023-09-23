package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.khcommon.KeisanHtyKeihi;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 源泉徴収額計算
 */
public class KeisanKhGensen {

    private C_RatesyutokukekkaKbn rateSyutokuKekkaKbn;

    private BizDate ratesyutokuYmd;

    private BizNumber kawaseRate;

    private C_UmuKbn gsBunriTaisyou;

    private BizCurrency yenHtyKeihi;

    private BizCurrency yenKztGk;

    private BizCurrency gensen;

    private BizCurrency yenGensen;

    private BizCurrency yenGsTszeiGkKokuz;

    private BizCurrency yenGsTszeiGkTihouz;

    private BizCurrency yenW;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanKhGensen() {
        super();
    }

    public C_ErrorKbn exec(
        String pSyono,
        C_Tuukasyu pTuukasyu,
        C_UmuKbn pYenshrtkUmu,
        BizCurrency pKaiyakuhr,
        BizCurrency pSonotashrkngkyen,
        BizDate pCalcKijyunYmd) {

        logger.debug("▽ 源泉徴収額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        C_RatesyutokukekkaKbn rateSyutokuKekkaKbnWk = C_RatesyutokukekkaKbn.SEIJYOU;
        BizDate ratesyutokuYmdWk = null;
        BizNumber zmkawaseRate = BizNumber.valueOf(0);
        BizNumber enKawaseRate = BizNumber.valueOf(0);

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        List<IT_KykSyouhn> kykSyouhSyuLst = hozenDomManager.getKykKihon(pSyono).getKykSyouhnsBySyutkkbn(
            C_SyutkKbn.SYU);

        if (kykSyouhSyuLst.size() == 0) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 源泉徴収額計算 終了");

            return errorKbn;
        }

        CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(kykSyouhSyuLst.get(0).getKyktuukasyu());

        BizCurrency kztGkEn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency enKaiyakuhr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenKztGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        gensen = BizCurrency.valueOf(0, kykCurrencyType);

        yenGensen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenGsTszeiGkKokuz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenGsTszeiGkTihouz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenW = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        int nensuu = YuyuBizConfig.getInstance().getKztKeikanensuu();

        BizDate kazeiKijyunYmd = kykSyouhSyuLst.get(0).getKykymd().addYears(nensuu);

        Boolean dateFlg = kazeiKijyunYmd.isRekijyou();

        if (!dateFlg) {

            kazeiKijyunYmd = kazeiKijyunYmd.getRekijyou().getNextDay();
        }

        C_UmuKbn gsbunritaisyou = kykSyouhSyuLst.get(0).getGsbunritaisyou();

        if (!(C_UmuKbn.ARI.eq(gsbunritaisyou) &&
            BizDateUtil.compareYmd(pCalcKijyunYmd, kazeiKijyunYmd) == BizDateUtil.COMPARE_LESSER)) {

            gsBunriTaisyou = C_UmuKbn.NONE;

            logger.debug("△ 源泉徴収額計算 終了");

            return errorKbn;
        }

        gsBunriTaisyou = C_UmuKbn.ARI;

        KeisanHtyKeihi keisanHtyKeihi = SWAKInjector.getInstance(KeisanHtyKeihi.class);

        keisanHtyKeihi.exec(pSyono, pTuukasyu);

        BizCurrency HtyKeihiEn = keisanHtyKeihi.getYenHtyKeihi();

        if (!C_Tuukasyu.JPY.eq(pTuukasyu) && !C_UmuKbn.ARI.eq(pYenshrtkUmu)) {

            C_ErrorKbn errorKbnWk = getKawaseRate.exec(pCalcKijyunYmd, C_KawaserateSyuruiKbn.PM17JIKAWASERATE, pTuukasyu,
                C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTB, C_KawasetsryKbn.JISSEIRATE, C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbnWk)) {

                rateSyutokuKekkaKbn = C_RatesyutokukekkaKbn.ERROR;

                logger.debug("△ 源泉徴収額計算 終了");

                return errorKbn;
            }

            enKawaseRate = getKawaseRate.getKawaserate();

            enKaiyakuhr = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pKaiyakuhr, enKawaseRate, C_HasuusyoriKbn.SUTE);
            rateSyutokuKekkaKbnWk = C_RatesyutokukekkaKbn.SEIJYOU;
            ratesyutokuYmdWk = getKawaseRate.getKwsrateKjYmd();
            zmkawaseRate = enKawaseRate;
        }
        else {

            enKaiyakuhr = pKaiyakuhr;
        }

        kztGkEn = enKaiyakuhr.add(pSonotashrkngkyen).subtract(HtyKeihiEn);

        if (kztGkEn.compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) < 0) {
            kztGkEn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        keisanGensen(kztGkEn, pTuukasyu, pYenshrtkUmu, enKawaseRate);

        yenHtyKeihi = HtyKeihiEn;
        yenKztGk = kztGkEn;
        yenW = enKaiyakuhr;
        rateSyutokuKekkaKbn = rateSyutokuKekkaKbnWk;
        ratesyutokuYmd = ratesyutokuYmdWk;
        kawaseRate = zmkawaseRate;

        logger.debug("△ 源泉徴収額計算 終了");

        return errorKbn;
    }

    public C_ErrorKbn execForDTuibarai(
        C_Tuukasyu pTuukasyu,
        C_UmuKbn pYenshrtkUmu,
        BizCurrency pSonotashrkngkyen,
        BizNumber pKawaseRate) {

        logger.debug("▽ 源泉徴収額計算（配当金追払用） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        yenHtyKeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenKztGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        gensen = BizCurrency.valueOf(0, kykCurrencyType);

        yenGensen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenGsTszeiGkKokuz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenGsTszeiGkTihouz = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        yenW = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        BizCurrency kztGkEn = pSonotashrkngkyen;

        keisanGensen(kztGkEn, pTuukasyu, pYenshrtkUmu, pKawaseRate);

        yenKztGk = kztGkEn;

        if (!C_Tuukasyu.JPY.eq(pTuukasyu) && !C_UmuKbn.ARI.eq(pYenshrtkUmu)) {
            kawaseRate = pKawaseRate;
        }

        logger.debug("△ 源泉徴収額計算（配当金追払用） 終了");


        return errorKbn;
    }

    private void keisanGensen(
        BizCurrency pKztGkEn,
        C_Tuukasyu pTuukasyu,
        C_UmuKbn pYenshrtkUmu,
        BizNumber pEnKawaseRate) {

        BizCurrency gensenShr = null;
        BizNumber gensenKaseiRateKz = YuyuBizConfig.getInstance().getGsbunrikzZeirituNationaltax();
        BizNumber gensenKaseiRateJk = YuyuBizConfig.getInstance().getGsbunrikzZeirituLocaltax();

        BizCurrency yenGsTszeiGkKokuzWk = pKztGkEn.multiply(gensenKaseiRateKz, 0, RoundingMode.DOWN);
        BizCurrency yenGsTszeiGkTihouzWk = pKztGkEn.multiply(gensenKaseiRateJk, 0, RoundingMode.DOWN);
        BizCurrency gensenEn = yenGsTszeiGkKokuzWk.add(yenGsTszeiGkTihouzWk);

        if (C_Tuukasyu.JPY.eq(pTuukasyu) || C_UmuKbn.ARI.eq(pYenshrtkUmu)) {

            gensenShr = gensenEn;
        }
        else {

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            BizCurrency kykTkTszeiGkKokuzWk  =
                keisanGaikakanzan.execDivide(pTuukasyu, yenGsTszeiGkKokuzWk, pEnKawaseRate, C_HasuusyoriKbn.SUTE);

            BizCurrency kykTkTszeiGkTihouzWk =
                keisanGaikakanzan.execDivide(pTuukasyu, yenGsTszeiGkTihouzWk, pEnKawaseRate, C_HasuusyoriKbn.SUTE);

            gensenShr = kykTkTszeiGkKokuzWk.add(kykTkTszeiGkTihouzWk);
        }

        gensen = gensenShr;
        yenGensen = gensenEn;
        yenGsTszeiGkKokuz = yenGsTszeiGkKokuzWk;
        yenGsTszeiGkTihouz = yenGsTszeiGkTihouzWk;
    }

    public C_RatesyutokukekkaKbn getRateSyutokuKekkaKbn() {
        return rateSyutokuKekkaKbn;
    }

    public BizDate getRatesyutokuYmd() {
        return ratesyutokuYmd;
    }

    public BizNumber getKawaseRate() {
        return kawaseRate;
    }

    public C_UmuKbn getGsBunriTaisyou() {
        return gsBunriTaisyou;
    }

    public BizCurrency getYenHtyKeihi() {
        return yenHtyKeihi;
    }

    public BizCurrency getYenKztGk() {
        return yenKztGk;
    }

    public BizCurrency getGensen() {
        return gensen;
    }

    public BizCurrency getYenGensen() {
        return yenGensen;
    }

    public BizCurrency getYenGsTszeiGkKokuz() {
        return yenGsTszeiGkKokuz;
    }

    public BizCurrency getYenGsTszeiGkTihouz() {
        return yenGsTszeiGkTihouz;
    }

    public BizCurrency getYenW() {
        return yenW;
    }
}
