package yuyu.common.siharai.sicommon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;

import com.google.common.collect.Ordering;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金額計算（一時払終身）
 */
public class CalcHkShrKngkItijibrSysn {

    @Inject
    private static Logger logger;

    private CalcHkShrKngkBean calcHkShrKngkBean;

    public CalcHkShrKngkItijibrSysn() {
        calcHkShrKngkBean = SWAKInjector.getInstance(CalcHkShrKngkBean.class);
    }

    public CalcHkShrKngkBean getCalcHkShrKngkBean() {
        return calcHkShrKngkBean;
    }

    public C_ErrorKbn exec(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean) {

        logger.debug("▽ 保険金額計算（一時払終身） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pCalcHkShrKngkInputBean.getKykymd() == null
            || pCalcHkShrKngkInputBean.getCalckijyunymd() == null
            || C_SiinKbn.BLNK.eq(pCalcHkShrKngkInputBean.getSiinkbn())
            || C_HokenkinsyuruiKbn.BLNK.eq(pCalcHkShrKngkInputBean.getHokenkinsyuruikbn())
            || (pCalcHkShrKngkInputBean.getKihons() == null || pCalcHkShrKngkInputBean.getKihons().isOptional())
            || C_Tuukasyu.BLNK.eq(pCalcHkShrKngkInputBean.getTuukasyu())
            || (pCalcHkShrKngkInputBean.getHokenryou() == null || pCalcHkShrKngkInputBean.getHokenryou().isOptional())) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("【保険金額計算（一時払終身）】の与件が正しく設定されていません。");
            logger.debug("△ 保険金額計算（一時払終身） 終了");

            return errorKbn;
        }

        errorKbn = execCalcHkShrKngk(pCalcHkShrKngkInputBean);

        logger.debug("△ 保険金額計算（一時払終身） 終了");

        return errorKbn;
    }

    private C_ErrorKbn execCalcHkShrKngk(CalcHkShrKngkInputBean pCalcHkShrKngkInputBean){

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        int syohinHanteiKbn = SyouhinUtil.hantei(pCalcHkShrKngkInputBean.getSyouhncd());

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pCalcHkShrKngkInputBean.getTuukasyu());

        BizCurrency kaiyakuhenreiknGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency tmttKnGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency hokenryoustGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency sibousGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency saigaisGk = BizCurrency.valueOf(0, currencyType);
        BizCurrency hokenknGk = BizCurrency.valueOf(0, currencyType);
        C_HknKknKbn hknKknKbn = C_HknKknKbn.BLNK;

        BizDate calckijyunYmd;
        if (BizDateUtil.compareYmd(pCalcHkShrKngkInputBean.getCalckijyunymd(),
                pCalcHkShrKngkInputBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            calckijyunYmd = pCalcHkShrKngkInputBean.getKykymd();
        }
        else {
            calckijyunYmd = pCalcHkShrKngkInputBean.getCalckijyunymd();
        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        BizDateYM kaiyakuhrKisnKijyunYM = keisanWKijunYM.exec(pCalcHkShrKngkInputBean.getKykymd(),
            calckijyunYmd, null, pCalcHkShrKngkInputBean.getHrkkaisuu(),
            pCalcHkShrKngkInputBean.getKykJyoutai(), pCalcHkShrKngkInputBean.getSyouhncd(),
            pCalcHkShrKngkInputBean.getYendthnkYmd());

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd(pCalcHkShrKngkInputBean.getSyouhncd());
        keisanWExtBean.setSyouhnsdno(pCalcHkShrKngkInputBean.getSyouhnsdno());
        keisanWExtBean.setRyouritusdno(pCalcHkShrKngkInputBean.getRyouritusdno());
        keisanWExtBean.setYoteiriritu(pCalcHkShrKngkInputBean.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(pCalcHkShrKngkInputBean.getHrkkaisuu());
        keisanWExtBean.setHknkknsmnkbn(pCalcHkShrKngkInputBean.getHknkknsmnkbn());
        keisanWExtBean.setHknkkn(pCalcHkShrKngkInputBean.getHknkkn());
        keisanWExtBean.setHrkkkn(pCalcHkShrKngkInputBean.getHrkkkn());
        keisanWExtBean.setHhknnen(pCalcHkShrKngkInputBean.getHhknnen());
        keisanWExtBean.setHhknsei(pCalcHkShrKngkInputBean.getHhknsei());
        keisanWExtBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        keisanWExtBean.setHokenryou(pCalcHkShrKngkInputBean.getHokenryou());
        keisanWExtBean.setKykymd(pCalcHkShrKngkInputBean.getKykymd());
        keisanWExtBean.setTuukasyu(pCalcHkShrKngkInputBean.getTuukasyu());
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu());
        keisanWExtBean.setKyksjkkktyouseiriritu(pCalcHkShrKngkInputBean.getKyksjkkktyouseiriritu());
        keisanWExtBean.setTmttkntaisyouym(pCalcHkShrKngkInputBean.getTmttkntaisyouym());
        keisanWExtBean.setTeiritutmttkngk(pCalcHkShrKngkInputBean.getTeiritutmttkngk());
        keisanWExtBean.setSisuurendoutmttkngk(pCalcHkShrKngkInputBean.getSisuurendoutmttkngk());
        keisanWExtBean.setTumitateriritu(pCalcHkShrKngkInputBean.getTumitateriritu());
        keisanWExtBean.setYendthnkymd(pCalcHkShrKngkInputBean.getYendthnkYmd());

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        errorKbn = keisanW.exec(pCalcHkShrKngkInputBean.getCalckijyunymd(), kaiyakuhrKisnKijyunYM, keisanWExtBean);

        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            logger.debug("【契約保全共通．解約返戻金計算】でエラーが発生しました。");

            return errorKbn;
        }

        kaiyakuhenreiknGk = keisanW.getW();
        tmttKnGk = keisanW.getV();

        hokenryoustGk = pCalcHkShrKngkInputBean.getHokenryou();

        if (C_Tuukasyu.JPY.eq(pCalcHkShrKngkInputBean.getTuukasyu())) {

            if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn){
                sibousGk = pCalcHkShrKngkInputBean.getKihons();
                hokenknGk = sibousGk;
            }
            else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syohinHanteiKbn) {
                sibousGk = tmttKnGk;
                hokenknGk = sibousGk;
            }

        } else {
            HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
            HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

            hanteiHokenKikanBean.setKykYmd(pCalcHkShrKngkInputBean.getKykymd());
            hanteiHokenKikanBean.setCalcKijyunYmd(pCalcHkShrKngkInputBean.getCalckijyunymd());
            hanteiHokenKikanBean.setSyouhnZokusei(pCalcHkShrKngkInputBean.getSyouhnZokusei());
            hanteiHokenKikanBean.setDai1hknkkn(pCalcHkShrKngkInputBean.getDai1hknkkn());

            hknKknKbn = hanteiHokenKikan.exec(hanteiHokenKikanBean);

            if(C_HknKknKbn.DAI1HKNKKN.eq(hknKknKbn)) {

                List<BizCurrency> shrgkLst = new ArrayList<>();

                shrgkLst.add(hokenryoustGk);
                shrgkLst.add(tmttKnGk);
                shrgkLst.add(kaiyakuhenreiknGk);

                sibousGk = getMaxKingaku(shrgkLst);

                shrgkLst.clear();

                shrgkLst.add(pCalcHkShrKngkInputBean.getKihons());
                shrgkLst.add(kaiyakuhenreiknGk);

                saigaisGk = getMaxKingaku(shrgkLst);

                if(C_HokenkinsyuruiKbn.SBHOKENKIN.eq(pCalcHkShrKngkInputBean.getHokenkinsyuruikbn())) {
                    if(!C_SiinKbn.SG.eq(pCalcHkShrKngkInputBean.getSiinkbn())){
                        hokenknGk = sibousGk;
                    }
                }
                else if(C_HokenkinsyuruiKbn.SAIGAIHOKENKIN.eq(pCalcHkShrKngkInputBean.getHokenkinsyuruikbn())) {
                    if(C_SiinKbn.SG.eq(pCalcHkShrKngkInputBean.getSiinkbn())){
                        hokenknGk = saigaisGk;
                    }
                }
            }
            else if(C_HknKknKbn.DAI2HKNKKN.eq(hknKknKbn)) {

                List<BizCurrency> shrgkLst = new ArrayList<>();

                shrgkLst.add(pCalcHkShrKngkInputBean.getKihons());
                shrgkLst.add(kaiyakuhenreiknGk);

                sibousGk = getMaxKingaku(shrgkLst);

                if(C_HokenkinsyuruiKbn.SBHOKENKIN.eq(pCalcHkShrKngkInputBean.getHokenkinsyuruikbn())) {
                    hokenknGk = sibousGk;
                }
            }
            else if(C_HknKknKbn.DAI3HKNKKN.eq(hknKknKbn)) {

                sibousGk = pCalcHkShrKngkInputBean.getKihons();

                if(C_HokenkinsyuruiKbn.SBHOKENKIN.eq(pCalcHkShrKngkInputBean.getHokenkinsyuruikbn())) {
                    hokenknGk = sibousGk;
                }
            }
            else {

                sibousGk = pCalcHkShrKngkInputBean.getKihons();

                hokenknGk = sibousGk;

            }
        }

        calcHkShrKngkBean.setKihons(pCalcHkShrKngkInputBean.getKihons());
        calcHkShrKngkBean.setKaiyakuhenreiknGk(kaiyakuhenreiknGk);
        calcHkShrKngkBean.setTmttKnGk(tmttKnGk);
        calcHkShrKngkBean.setHokenryoustGk(hokenryoustGk);
        calcHkShrKngkBean.setSibousGk(sibousGk);
        calcHkShrKngkBean.setSaigaisGk(saigaisGk);
        calcHkShrKngkBean.setHokenknGk(hokenknGk);
        calcHkShrKngkBean.setHknKknKbn(hknKknKbn);

        return errorKbn;
    }

    private BizCurrency getMaxKingaku(List<BizCurrency> pShrgkLst) {

        Comparator<BizCurrency> comparator = new Comparator<BizCurrency>() {

            @Override
            public int compare(BizCurrency pTarget1, BizCurrency pTarget2) {
                int iResult = pTarget2.compareTo(pTarget1);

                return iResult;
            }
        };

        Ordering<BizCurrency> ordering = Ordering.from(comparator);
        List<BizCurrency> sortShrgkLst = ordering.sortedCopy(pShrgkLst);

        return sortShrgkLst.get(0);
    }
}
