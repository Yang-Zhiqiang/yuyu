package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 貯蓄性保険表示設定
 */
public class SetTyotikuseihokenhyouji {

    public static final BizCurrency KAIYAKUHR_HANTIEKIJYUN  = BizCurrency.valueOf(50000000, BizCurrencyTypes.YEN);

    private C_UmuKbn houteityotkhknhyj;

    private C_UmuKbn tyotkhknhyj;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public SetTyotikuseihokenhyouji() {
        super();
    }

    public C_ErrorKbn exec(IT_KykKihon pKykKihon) {

        logger.debug("▽ 貯蓄性保険表示設定 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhn.getSyouhncd());
        hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
        hanteiTyotikuseihokenBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
        hanteiTyotikuseihokenBean.setYoteiriritu(kykSyouhn.getYoteiriritu());
        hanteiTyotikuseihokenBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
        hanteiTyotikuseihokenBean.setHrkkkn(kykSyouhn.getHrkkkn());
        hanteiTyotikuseihokenBean.setHknkkn(kykSyouhn.getHknkkn());
        hanteiTyotikuseihokenBean.setHhknnen(kykSyouhn.getHhknnen());
        hanteiTyotikuseihokenBean.setHhknsei(kykSyouhn.getHhknsei());
        hanteiTyotikuseihokenBean.setKihons(kykSyouhn.getKihons());
        hanteiTyotikuseihokenBean.setHokenryou(kykSyouhn.getHokenryou());
        hanteiTyotikuseihokenBean.setKykymd(kykSyouhn.getKykymd());
        hanteiTyotikuseihokenBean.setKyktuukaSyu(kykSyouhn.getKyktuukasyu());
        hanteiTyotikuseihokenBean.setMosymd(pKykKihon.getMosymd());
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(kykSyouhn.getYoteirrthendohosyurrt());
        hanteiTyotikuseihokenBean.setHrkkeiro(pKykKihon.getHrkkeiro());
        hanteiTyotikuseihokenBean.setHaraimanymd(kykSyouhn.getHaraimanymd());
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
        hanteiTyotikuseihokenBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

        kekkaKbn = hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        logger.debug("△ 貯蓄性保険表示設定 終了");

        return kekkaKbn;
    }

    public C_ErrorKbn hanteiTyotikuseihoken(HanteiTyotikuseihokenBean pHanteiTyotikuseihokenBean) {

        logger.debug("▽ 貯蓄性保険判定処理 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;
        houteityotkhknhyj = C_UmuKbn.NONE;
        tyotkhknhyj = C_UmuKbn.NONE;

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
            pHanteiTyotikuseihokenBean.getSyouhnCd(), pHanteiTyotikuseihokenBean.getSyouhnsdNo());

        C_UmuKbn houteiTyotkseiUmu = syouhnZokusei.getHouteityotkseiumu();

        if (C_UmuKbn.ARI.eq(houteiTyotkseiUmu)) {

            houteityotkhknhyj = C_UmuKbn.ARI;
        }
        else {

            if (C_Hrkkaisuu.NEN.eq(pHanteiTyotikuseihokenBean.getHrkkaisuu()) &&
                C_Hrkkeiro.HURIKAE.eq(pHanteiTyotikuseihokenBean.getHrkkeiro())) {

                houteityotkhknhyj = C_UmuKbn.ARI;
            }
        }

        if (!pHanteiTyotikuseihokenBean.getTyotikuseihokenhyoujihanteiflag() || C_UmuKbn.ARI.eq(houteityotkhknhyj)) {
            logger.debug("△ 貯蓄性保険判定処理 終了");
            return kekkaKbn;
        }

        BizDate calcKijyunYmd = pHanteiTyotikuseihokenBean.getHaraimanymd().getPreviousDay();

        BizDateYM kaiyakuhrCalcKijyunYm = pHanteiTyotikuseihokenBean.getHaraimanymd().getBizDateYM();

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        BizCurrency kaiyakuHr = BizCurrency.valueOf(0);

        keisanWExtBean.setSyouhncd(pHanteiTyotikuseihokenBean.getSyouhnCd());
        keisanWExtBean.setSyouhnsdno(pHanteiTyotikuseihokenBean.getSyouhnsdNo());
        keisanWExtBean.setRyouritusdno(pHanteiTyotikuseihokenBean.getRyouritusdNo());
        keisanWExtBean.setYoteiriritu(pHanteiTyotikuseihokenBean.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(pHanteiTyotikuseihokenBean.getHrkkaisuu());
        keisanWExtBean.setHknkknsmnkbn(pHanteiTyotikuseihokenBean.getHknkknsmnkbn());
        keisanWExtBean.setHrkkknsmnkbn(pHanteiTyotikuseihokenBean.getHrkkknsmnkbn());
        keisanWExtBean.setHrkkkn(pHanteiTyotikuseihokenBean.getHrkkkn());
        keisanWExtBean.setHknkkn(pHanteiTyotikuseihokenBean.getHknkkn());
        keisanWExtBean.setHhknnen(pHanteiTyotikuseihokenBean.getHhknnen());
        keisanWExtBean.setHhknsei(pHanteiTyotikuseihokenBean.getHhknsei());
        keisanWExtBean.setKihons(pHanteiTyotikuseihokenBean.getKihons());
        keisanWExtBean.setHokenryou(pHanteiTyotikuseihokenBean.getHokenryou());
        keisanWExtBean.setKykymd(pHanteiTyotikuseihokenBean.getKykymd());
        keisanWExtBean.setTuukasyu(pHanteiTyotikuseihokenBean.getKyktuukaSyu());
        keisanWExtBean.setYoteirrthendohosyurrt(pHanteiTyotikuseihokenBean.getYoteirrthendohosyurrt());
        keisanWExtBean.setDai1hknkkn(pHanteiTyotikuseihokenBean.getDai1hknkkn());
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);

        C_ErrorKbn keisanWKekkaKbn = keisanW.exec(calcKijyunYmd, kaiyakuhrCalcKijyunYm, keisanWExtBean);

        if (C_ErrorKbn.ERROR.eq(keisanWKekkaKbn)) {

            kekkaKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 貯蓄性保険判定処理 終了");

            return kekkaKbn;
        }

        if (!C_Tuukasyu.JPY.eq(pHanteiTyotikuseihokenBean.getKyktuukaSyu())) {

            BizDate mosymd = pHanteiTyotikuseihokenBean.getMosymd();
            String mosymdNendo = "";

            if (mosymd.getMonth() <= 3) {

                mosymdNendo = mosymd.getBizDateY().addYears(-1).toString();
            }
            else {

                mosymdNendo = mosymd.getBizDateY().toString();
            }

            BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate =
                bizDomManager.getKijyungkHanteiKawaseRate(String.valueOf(mosymdNendo),
                    pHanteiTyotikuseihokenBean.getKyktuukaSyu());

            BizNumber kjngkhntiyukawaserate = kijyungkHanteiKawaseRate.getKjngkhntiyukawaserate();

            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            kaiyakuHr = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                keisanW.getW(),
                kjngkhntiyukawaserate,
                C_HasuusyoriKbn.SUTE);

        }
        else {

            kaiyakuHr = keisanW.getW();
        }

        if (KAIYAKUHR_HANTIEKIJYUN.compareTo(kaiyakuHr) <= 0) {

            tyotkhknhyj = C_UmuKbn.ARI;
        }

        logger.debug("△ 貯蓄性保険判定処理 終了");

        return kekkaKbn;
    }

    public C_UmuKbn getHouteityotkhknhyj() {
        return houteityotkhknhyj;
    }

    public C_UmuKbn getTyotkhknhyj() {
        return tyotkhknhyj;
    }

}