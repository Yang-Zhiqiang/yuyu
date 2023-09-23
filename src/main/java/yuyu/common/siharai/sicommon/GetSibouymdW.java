package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.KeisanV;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 死亡日解約返戻金取得
 */
public class GetSibouymdW {

    @Inject
    private static Logger logger;

    private BizCurrency kaiyakuhenreiknGk;

    private BizCurrency tmttKnGk;

    private BizCurrency pruikei;

    public BizCurrency getKaiyakuhenreiknGk() {
        return kaiyakuhenreiknGk;
    }

    public BizCurrency getTmttKnGk() {
        return tmttKnGk;
    }

    public BizCurrency getPruikei() {
        return pruikei;
    }

    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {

        logger.debug("▽ 死亡日解約返戻金取得 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pCalcHkShrKngkInputBean.getCalckijyunymd() == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【死亡日解約返戻金取得】の与件が正しく設定されていません。");
            logger.debug("△ 死亡日解約返戻金取得 終了");

            return errorKbn;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pCalcHkShrKngkInputBean.getSyouhncd());

        errorKbn = execGetSibouymdW(pCalcHkShrKngkInputBean, syohinHanteiKbn);

        logger.debug("△ 死亡日解約返戻金取得 終了");

        return errorKbn;
    }

    private C_ErrorKbn execGetSibouymdW(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean, int pSyohinHanteiKbn){

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(pCalcHkShrKngkInputBean.getKykymd(),
            pCalcHkShrKngkInputBean.getCalckijyunymd(), pCalcHkShrKngkInputBean.getJkipjytYm(),
            pCalcHkShrKngkInputBean.getHrkkaisuu(), pCalcHkShrKngkInputBean.getKykJyoutai(),
            pCalcHkShrKngkInputBean.getSyouhncd(), pCalcHkShrKngkInputBean.getYendthnkYmd());

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd(pCalcHkShrKngkInputBean.getSyouhncd());
        keisanWExtBean.setSyouhnsdno(pCalcHkShrKngkInputBean.getSyouhnsdno());
        keisanWExtBean.setRyouritusdno(pCalcHkShrKngkInputBean.getRyouritusdno());
        keisanWExtBean.setYoteiriritu(pCalcHkShrKngkInputBean.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(pCalcHkShrKngkInputBean.getHrkkaisuu());
        keisanWExtBean.setHknkknsmnkbn(pCalcHkShrKngkInputBean.getHknkknsmnkbn());
        keisanWExtBean.setHknkkn(pCalcHkShrKngkInputBean.getHknkkn());
        keisanWExtBean.setHrkkkn(pCalcHkShrKngkInputBean.getHrkkkn());
        keisanWExtBean.setHrkkknsmnkbn(pCalcHkShrKngkInputBean.getHrkkknsmnKbn());
        keisanWExtBean.setHhknnen(pCalcHkShrKngkInputBean.getHhknnen());
        keisanWExtBean.setHhknsei(pCalcHkShrKngkInputBean.getHhknsei());
        keisanWExtBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        keisanWExtBean.setKykymd(pCalcHkShrKngkInputBean.getKykymd());
        keisanWExtBean.setTuukasyu(pCalcHkShrKngkInputBean.getTuukasyu());
        keisanWExtBean.setHokenryou(pCalcHkShrKngkInputBean.getHokenryou());
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu());
        keisanWExtBean.setKyksjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKyksjkkktyouseiriritu());
        keisanWExtBean.setTmttkntaisyouym(pCalcHkShrKngkInputBean.getTmttkntaisyouym());
        keisanWExtBean.setTeiritutmttkngk(pCalcHkShrKngkInputBean.getTeiritutmttkngk());
        keisanWExtBean.setSisuurendoutmttkngk(pCalcHkShrKngkInputBean.getSisuurendoutmttkngk());
        keisanWExtBean.setTumitateriritu(pCalcHkShrKngkInputBean.getTumitateriritu());
        keisanWExtBean.setJkipjytym(pCalcHkShrKngkInputBean.getJkipjytYm());
        keisanWExtBean.setPtmttkngk(pCalcHkShrKngkInputBean.getPtmttKngk());
        keisanWExtBean.setKihrkmpstgk(pCalcHkShrKngkInputBean.getKihrkmPStgk());
        keisanWExtBean.setFstpryosyuymd(pCalcHkShrKngkInputBean.getFstPryosyuYmd());
        keisanWExtBean.setYoteirrthendohosyurrt(pCalcHkShrKngkInputBean.getYoteirrthendohosyuRiritu());
        keisanWExtBean.setYendthnkymd(pCalcHkShrKngkInputBean.getYendthnkYmd());
        keisanWExtBean.setDai1hknkkn(pCalcHkShrKngkInputBean.getDai1hknkkn());
        keisanWExtBean.setKykJyoutai(pCalcHkShrKngkInputBean.getKykJyoutai());

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        errorKbn = keisanW.exec(pCalcHkShrKngkInputBean.getCalckijyunymd(), kaiyakuhrKisnKijyunYM, keisanWExtBean);

        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            logger.debug("【契約保全共通．解約返戻金計算】でエラーが発生しました。");

            return errorKbn;
        }

        kaiyakuhenreiknGk = keisanW.getW();
        pruikei = keisanW.getPruikei();

        if (pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            KeisanV keisanV = SWAKInjector.getInstance(KeisanV.class);

            errorKbn = keisanV.exec(
                pCalcHkShrKngkInputBean.getCalckijyunymd(),
                kaiyakuhrKisnKijyunYM,
                pCalcHkShrKngkInputBean.getKykymd(),
                pCalcHkShrKngkInputBean.getSyouhncd(),
                pCalcHkShrKngkInputBean.getSyouhnsdno(),
                pCalcHkShrKngkInputBean.getRyouritusdno(),
                pCalcHkShrKngkInputBean.getYoteiriritu(),
                pCalcHkShrKngkInputBean.getHrkkaisuu(),
                pCalcHkShrKngkInputBean.getHhknsei(),
                pCalcHkShrKngkInputBean.getHhknnen(),
                pCalcHkShrKngkInputBean.getHknkknsmnkbn(),
                pCalcHkShrKngkInputBean.getHknkkn(),
                pCalcHkShrKngkInputBean.getHrkkknsmnKbn(),
                pCalcHkShrKngkInputBean.getHrkkkn(),
                pCalcHkShrKngkInputBean.getKihons(),
                keisanW.getKeikanensuu(),
                keisanW.getKeikatukisuu(),
                pCalcHkShrKngkInputBean.getTuukasyu(),
                pCalcHkShrKngkInputBean.getHokenryou(),
                pCalcHkShrKngkInputBean.getSyouhnZokusei().getTyksenhokanhoukbn(),
                pCalcHkShrKngkInputBean.getKykJyoutai(),
                pCalcHkShrKngkInputBean.getDai1hknkkn());

            if (!C_ErrorKbn.OK.eq(errorKbn)) {
                logger.debug("【契約保全共通．保険料積立金計算】でエラーが発生しました。");
                return errorKbn;
            }

            tmttKnGk = keisanV.getV();
        }
        else {
            tmttKnGk = keisanW.getV();
        }

        return errorKbn;
    }
}
