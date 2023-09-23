package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import com.google.common.base.Strings;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算
 */
public class CalcHkShrKngk {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    private CalcHkShrKngkBean calcHkShrKngkBean;

    public CalcHkShrKngk() {
        calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);
    }

    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        return calcHkShrKngkBean;
    }

    public C_ErrorKbn exec(String pSyouhnCd, Integer pSyouhnSdno, String pRyouritusdNo, BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHrkKaisuu, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHknKkn, Integer pHrkKkn, Integer pHhknNen,
        C_Hhknsei pHhknSei, BizCurrency pKihonS, BizDate pKykYmd, BizDate pCalckijyunYmd, String pSyoNo,
        C_Tuukasyu pTuukaSyu, Integer pDai1hknKkn, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, BizCurrency pHokenRyou,
        BizNumber pKaiyakusjkkktyouseiRiritu,BizNumber pKyksjkkktyouseiRiritu,
        BizDateYM pTmttkntaisyouYm,BizCurrency pTeiritutmttKngk,BizCurrency pSisuurendoutmttKngk,BizNumber pTumitateRiritu,
        C_HrkkknsmnKbn pHrkkknsmnKbn,BizDateYM pJkipjytYm,BizCurrency pPtmttKngk,BizCurrency pKihrkmPStgk,
        BizDate pFstPryosyuYmd,BizNumber pYoteirrthendohosyuRiritu,C_Kykjyoutai pKykJyoutai,
        BizDate pYendthnkYmd,  C_Sdpd pSdpdkbn,  C_Hrkkeiro pHrkkeiro) {

        logger.debug("▽ 保険金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd(pSyouhnCd);
        calcHkShrKngkInputBean.setSyouhnsdno(pSyouhnSdno);
        calcHkShrKngkInputBean.setRyouritusdno(pRyouritusdNo);
        calcHkShrKngkInputBean.setYoteiriritu(pYoteiRiritu);
        calcHkShrKngkInputBean.setHrkkaisuu(pHrkKaisuu);
        calcHkShrKngkInputBean.setHknkknsmnkbn(pHknkknsmnKbn);
        calcHkShrKngkInputBean.setHknkkn(pHknKkn);
        calcHkShrKngkInputBean.setHrkkkn(pHrkKkn);
        calcHkShrKngkInputBean.setHhknnen(pHhknNen);
        calcHkShrKngkInputBean.setHhknsei(pHhknSei);
        calcHkShrKngkInputBean.setKihons(pKihonS);
        calcHkShrKngkInputBean.setKykymd(pKykYmd);
        calcHkShrKngkInputBean.setCalckijyunymd(pCalckijyunYmd);
        calcHkShrKngkInputBean.setSyono(pSyoNo);
        calcHkShrKngkInputBean.setTuukasyu(pTuukaSyu);
        calcHkShrKngkInputBean.setDai1hknkkn(pDai1hknKkn);
        calcHkShrKngkInputBean.setSiinkbn(pSiinKbn);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(pHokenkinsyuruiKbn);
        calcHkShrKngkInputBean.setHokenryou(pHokenRyou);
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(pKaiyakusjkkktyouseiRiritu);
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(pKyksjkkktyouseiRiritu);
        calcHkShrKngkInputBean.setTmttkntaisyouym(pTmttkntaisyouYm);
        calcHkShrKngkInputBean.setTeiritutmttkngk(pTeiritutmttKngk);
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(pSisuurendoutmttKngk);
        calcHkShrKngkInputBean.setTumitateriritu(pTumitateRiritu);
        calcHkShrKngkInputBean.setHrkkknsmnKbn(pHrkkknsmnKbn);
        calcHkShrKngkInputBean.setJkipjytYm(pJkipjytYm);
        calcHkShrKngkInputBean.setPtmttKngk(pPtmttKngk);
        calcHkShrKngkInputBean.setKihrkmPStgk(pKihrkmPStgk);
        calcHkShrKngkInputBean.setFstPryosyuYmd(pFstPryosyuYmd);
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(pYoteirrthendohosyuRiritu);
        calcHkShrKngkInputBean.setKykJyoutai(pKykJyoutai);
        calcHkShrKngkInputBean.setYendthnkYmd(pYendthnkYmd);
        calcHkShrKngkInputBean.setSdpdkbn(pSdpdkbn);
        calcHkShrKngkInputBean.setHrkkeiro(pHrkkeiro);

        errorKbn = execSyouhinbetuCalcHkShrKngk(calcHkShrKngkInputBean);

        logger.debug("△ 保険金額計算 終了");

        return errorKbn;
    }

    public C_ErrorKbn execByKeisanWExt(String pSyoNo, BizDate pCalckijyunYmd, C_SiinKbn pSiinKbn,
        C_HokenkinsyuruiKbn pHokenkinsyuruiKbn, C_Sdpd pSdpdkbn, C_Hrkkeiro pHrkkeiro) {

        logger.debug("▽ 保険金額計算 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (Strings.isNullOrEmpty(pSyoNo)
            || pCalckijyunYmd == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【保険金額計算（解約返戻金計算拡張情報使用）】の与件が正しく設定されていません。");
            logger.debug("△ 保険金額計算 終了");

            return errorKbn;
        }

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        errorKbn = keisanWExt.exec(pSyoNo, pCalckijyunYmd);

        if (C_ErrorKbn.OK.eq(errorKbn)){
            keisanWExtBean = keisanWExt.getKeisanWExtBean();
        } else {
            logger.debug("【契約保全共通．解約返戻金計算拡張情報作成】でエラーが発生しました。");
            logger.debug("△ 保険金額計算 終了");

            return errorKbn;
        }

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

        calcHkShrKngkInputBean.setSyouhncd(keisanWExtBean.getSyouhncd());
        calcHkShrKngkInputBean.setSyouhnsdno(keisanWExtBean.getSyouhnsdno());
        calcHkShrKngkInputBean.setRyouritusdno(keisanWExtBean.getRyouritusdno());
        calcHkShrKngkInputBean.setYoteiriritu(keisanWExtBean.getYoteiriritu());
        calcHkShrKngkInputBean.setHrkkaisuu(keisanWExtBean.getHrkkaisuu());
        calcHkShrKngkInputBean.setHknkknsmnkbn(keisanWExtBean.getHknkknsmnkbn());
        calcHkShrKngkInputBean.setHknkkn(keisanWExtBean.getHknkkn());
        calcHkShrKngkInputBean.setHrkkkn(keisanWExtBean.getHrkkkn());
        calcHkShrKngkInputBean.setHhknnen(keisanWExtBean.getHhknnen());
        calcHkShrKngkInputBean.setHhknsei(keisanWExtBean.getHhknsei());
        calcHkShrKngkInputBean.setKihons(keisanWExtBean.getKihons());
        calcHkShrKngkInputBean.setKykymd(keisanWExtBean.getKykymd());
        calcHkShrKngkInputBean.setCalckijyunymd(pCalckijyunYmd);
        calcHkShrKngkInputBean.setSyono(pSyoNo);
        calcHkShrKngkInputBean.setTuukasyu(keisanWExtBean.getTuukasyu());
        calcHkShrKngkInputBean.setDai1hknkkn(keisanWExtBean.getDai1hknkkn());
        calcHkShrKngkInputBean.setSiinkbn(pSiinKbn);
        calcHkShrKngkInputBean.setHokenkinsyuruikbn(pHokenkinsyuruiKbn);
        calcHkShrKngkInputBean.setHokenryou(keisanWExtBean.getHokenryou());
        calcHkShrKngkInputBean.setKaiyakusjkkktyouseiriritu(keisanWExtBean.getKaiyakusjkkktyouseiriritu());
        calcHkShrKngkInputBean.setKyksjkkktyouseiriritu(keisanWExtBean.getKyksjkkktyouseiriritu());
        calcHkShrKngkInputBean.setTmttkntaisyouym(keisanWExtBean.getTmttkntaisyouym());
        calcHkShrKngkInputBean.setTeiritutmttkngk(keisanWExtBean.getTeiritutmttkngk());
        calcHkShrKngkInputBean.setSisuurendoutmttkngk(keisanWExtBean.getSisuurendoutmttkngk());
        calcHkShrKngkInputBean.setTumitateriritu(keisanWExtBean.getTumitateriritu());
        calcHkShrKngkInputBean.setHrkkknsmnKbn(keisanWExtBean.getHrkkknsmnkbn());
        calcHkShrKngkInputBean.setJkipjytYm(keisanWExtBean.getJkipjytym());
        calcHkShrKngkInputBean.setPtmttKngk(keisanWExtBean.getPtmttkngk());
        calcHkShrKngkInputBean.setKihrkmPStgk(keisanWExtBean.getKihrkmpstgk());
        calcHkShrKngkInputBean.setFstPryosyuYmd(keisanWExtBean.getFstpryosyuymd());
        calcHkShrKngkInputBean.setYoteirrthendohosyuRiritu(keisanWExtBean.getYoteirrthendohosyurrt());
        calcHkShrKngkInputBean.setKykJyoutai(keisanWExtBean.getKykJyoutai());
        calcHkShrKngkInputBean.setYendthnkYmd(keisanWExtBean.getYendthnkymd());
        calcHkShrKngkInputBean.setSdpdkbn(pSdpdkbn);
        calcHkShrKngkInputBean.setHrkkeiro(pHrkkeiro);

        errorKbn = execSyouhinbetuCalcHkShrKngk(calcHkShrKngkInputBean);

        logger.debug("△ 保険金額計算 終了");

        return errorKbn;
    }

    private C_ErrorKbn execSyouhinbetuCalcHkShrKngk(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        int syohinHanteiKbn = SyouhinUtil.SYOHIN_BLNK;
        syohinHanteiKbn = SyouhinUtil.hantei(pCalcHkShrKngkInputBean.getSyouhncd());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pCalcHkShrKngkInputBean.getTuukasyu());

        BM_SyouhnZokusei syouhnZokuseiSyu = bizDomManager.getSyouhnZokusei(pCalcHkShrKngkInputBean.getSyouhncd(),
            pCalcHkShrKngkInputBean.getSyouhnsdno());
        if (syouhnZokuseiSyu == null) {
            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("商品属性マスタが取得できませんでした。");

            return errorKbn;
        }
        pCalcHkShrKngkInputBean.setSyouhnZokusei(syouhnZokuseiSyu);

        if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == syohinHanteiKbn) {
            CalcHkShrKngkItijibrKojinNk calcHkShrKngkItijibrKojinNk = SWAKInjector.getInstance(CalcHkShrKngkItijibrKojinNk.class);
            errorKbn = calcHkShrKngkItijibrKojinNk.exec(pCalcHkShrKngkInputBean);

            if (C_ErrorKbn.OK.eq(errorKbn)){
                calcHkShrKngkBean = calcHkShrKngkItijibrKojinNk.getCalcHkShrKngkBean();
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(calcHkShrKngkBean.getKaiyakuhenreiknGk());
                calcHkShrKngkBean.setSbymdTmttKnGk(calcHkShrKngkBean.getTmttKnGk());
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0, currencyType));
            } else {
                logger.debug("【保険金給付金支払共通．保険金額計算（一時払個人年金）】でエラーが発生しました。");

                return errorKbn;
            }

        } else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
            CalcHkKngkHijynbrKojinNk calcHkKngkHijynbrKojinNk = SWAKInjector
                .getInstance(CalcHkKngkHijynbrKojinNk.class);
            errorKbn = calcHkKngkHijynbrKojinNk.exec(pCalcHkShrKngkInputBean);

            if (C_ErrorKbn.OK.eq(errorKbn)) {
                calcHkShrKngkBean = calcHkKngkHijynbrKojinNk.getCalcHkShrKngkBean();

                CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);

                BeanUtil.copyProperties(calcHkShrKngkInputBean, pCalcHkShrKngkInputBean);

                calcHkShrKngkInputBean.setCalckijyunymd(calcHkKngkHijynbrKojinNk.getCalcKijyunYmd());

                GetSibouymdW getSibouymdW = SWAKInjector.getInstance(GetSibouymdW.class);

                errorKbn = getSibouymdW.exec(calcHkShrKngkInputBean);

                if (C_ErrorKbn.OK.eq(errorKbn)) {
                    calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(getSibouymdW.getKaiyakuhenreiknGk());
                    calcHkShrKngkBean.setSbymdTmttKnGk(getSibouymdW.getTmttKnGk());
                    calcHkShrKngkBean.setPruikei(getSibouymdW.getPruikei());
                } else {
                    logger.debug("【保険金給付金支払共通．死亡日解約返戻金取得】でエラーが発生しました。");

                    return errorKbn;
                }

            } else {
                logger.debug("【保険金給付金支払共通．保険金額計算（平準払個人年金）】でエラーが発生しました。");

                return errorKbn;
            }

        } else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn
            || SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
            CalcHkShrKngkItijibrSysn calcHkShrKngkItijibrSysn = SWAKInjector
                .getInstance(CalcHkShrKngkItijibrSysn.class);
            errorKbn = calcHkShrKngkItijibrSysn.exec(pCalcHkShrKngkInputBean);

            if (C_ErrorKbn.OK.eq(errorKbn)){
                calcHkShrKngkBean = calcHkShrKngkItijibrSysn.getCalcHkShrKngkBean();
                calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(calcHkShrKngkBean.getKaiyakuhenreiknGk());
                calcHkShrKngkBean.setSbymdTmttKnGk(calcHkShrKngkBean.getTmttKnGk());
                calcHkShrKngkBean.setPruikei(BizCurrency.valueOf(0, currencyType));
            } else {
                logger.debug("【保険金給付金支払共通．保険金額計算（一時払終身）】でエラーが発生しました。");

                return errorKbn;
            }

        } else if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn) {

            CalcHkKngkHijynbrSysn calcHkKngkHijynbrSysn = SWAKInjector.getInstance(CalcHkKngkHijynbrSysn.class);
            errorKbn = calcHkKngkHijynbrSysn.exec(pCalcHkShrKngkInputBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)){

                logger.debug("【保険金給付金支払共通．保険金額計算（平準払終身）】でエラーが発生しました。");

                return errorKbn;

            }

            calcHkShrKngkBean = calcHkKngkHijynbrSysn.getCalcHkShrKngkBean();
            CalcHkShrKngkInputBean calcHkShrKngkInputBean = SWAKInjector.getInstance(CalcHkShrKngkInputBean.class);
            BeanUtil.copyProperties(calcHkShrKngkInputBean, pCalcHkShrKngkInputBean);
            calcHkShrKngkInputBean.setCalckijyunymd(calcHkKngkHijynbrSysn.getCalcKijyunYmd());

            GetSibouymdW getSibouymdW = SWAKInjector.getInstance(GetSibouymdW.class);
            errorKbn = getSibouymdW.exec(calcHkShrKngkInputBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                logger.debug("【保険金給付金支払共通．死亡日解約返戻金取得】でエラーが発生しました。");

                return errorKbn;

            }

            calcHkShrKngkBean.setKaiyakuhenreiknGk(getSibouymdW.getKaiyakuhenreiknGk());
            calcHkShrKngkBean.setTmttKnGk(getSibouymdW.getTmttKnGk());
            calcHkShrKngkBean.setSbymdKaiyakuhenreiknGk(getSibouymdW.getKaiyakuhenreiknGk());
            calcHkShrKngkBean.setSbymdTmttKnGk(getSibouymdW.getTmttKnGk());
            calcHkShrKngkBean.setPruikei(calcHkShrKngkBean.getHokenryoustGk());
        }


        return errorKbn;

    }
}