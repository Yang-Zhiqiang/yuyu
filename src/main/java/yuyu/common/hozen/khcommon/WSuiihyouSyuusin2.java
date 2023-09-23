package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成（終身２）
 */
public class WSuiihyouSyuusin2 {

    private final static String errorMsg = "解約返戻金計算が実行できませんでした。";

    private final static String SUIIHYOUSYUBETU_SYSN2_SIN = "10";

    private final static String SUIIHYOUSYUBETU_SYSN2_SAI = "01";

    private final static String SUIIHYOUSYUBETU_YENDTSYSNHNK2 = "04";

    private C_YouhiKbn yenkansannYhKbn = C_YouhiKbn.YOU;

    @Inject
    private static Logger logger;

    public WSuiihyouSyuusin2() {
        super();
    }

    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
        yenkansannYhKbn = pYenkansannYhKbn;
    }

    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        logger.debug("▽ 解約返戻金推移表作成（終身２） 開始");

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate calcKijyunYmd = null;
        BizDateYM calcKijyunYm = null;
        int wkKeikaNensuu = 0;
        int wkKeikaNensuuMax = 0;
        boolean calcYmdHoseiFlg = false;
        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (!pWSuiihyouParam.getKeisanWExtBean().getKykymd().getNextYear().isRekijyou()){
            calcYmdHoseiFlg = true;
        }

        if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn()) ||
            (C_SinsaihkKbn.SAI.eq(pWSuiihyouParam.getSinsaihkKbn()) &&
                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pWSuiihyouParam.getSyoukensaihkKbn()))) {
            calcKijyunYmd = pWSuiihyouParam.getKeisanWExtBean().getKykymd();
            calcKijyunYm = calcKijyunYmd.getBizDateYM();
            wkKeikaNensuuMax = 105 - pWSuiihyouParam.getKeisanWExtBean().getHhknnen();
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            calcKijyunYmd = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                C_Hrkkaisuu.NEN,
                pWSuiihyouParam.getCalcKijyunYmd());
            calcKijyunYm = calcKijyunYmd.getBizDateYM();

            if (calcYmdHoseiFlg){
                calcKijyunYmd = calcKijyunYmd.getNextDay();
            }

            wkKeikaNensuu = BizDateUtil.calcDifference(calcKijyunYmd, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();
            wkKeikaNensuuMax = 105 - pWSuiihyouParam.getKeisanWExtBean().getHhknnen() - wkKeikaNensuu;
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizNumber kawaserateCenter = BizNumber.ZERO;
        BizNumber kawaserateEndaka = BizNumber.ZERO;
        BizNumber kawaserateEnyasi = BizNumber.ZERO;

        if (C_YouhiKbn.YOU.eq(yenkansannYhKbn)) {

            getKawaseRate.exec(
                pWSuiihyouParam.getKwsratekjymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU );

            kawaserateCenter = getKawaseRate.getKawaserate();
            kawaserateEndaka = kawaserateCenter.subtract(YuyuHozenConfig.getInstance().getKawaserateHendouYenup());
            kawaserateEnyasi = kawaserateCenter.add(YuyuHozenConfig.getInstance().getKawaserateHendouYendown());
        }

        BizNumber kaiyakuSjkTsRitu = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu();
        BizNumber kaiyakuSjkTsRituUp = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu().add(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtUp());
        BizNumber kaiyakuSjkTsRituDown = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu().subtract(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());

        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        for (int cnt = 0; cnt <= wkKeikaNensuuMax; cnt++) {

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            BizDateYM kijyunYm = keisanWKijunYM.exec(
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                calcKijyunYmd,
                null,
                C_Hrkkaisuu.ITIJI,
                C_Kykjyoutai.ITIJIBARAI,
                pWSuiihyouParam.getKeisanWExtBean().getSyouhncd(),
                pWSuiihyouParam.getKeisanWExtBean().getYendthnkymd());

            C_MvaTekiyoujyoutaiKbn  mvaTekiyoujyoutaiKbn = setMvatekijyoutaikbn(
                calcKijyunYmd,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                pWSuiihyouParam.getKeisanWExtBean().getHknkkn(),
                pWSuiihyouParam.getMvaTekiUmu(),
                pWSuiihyouParam.getMvaTekiKkn());

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

            BizCurrency mvaariwyensameyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvanonewyensameyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvanonewsame = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));
            BizCurrency mvanoneptumitatekin = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));
            BizCurrency mvaariwyensameyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvanonewyensameyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwyensameyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvanonewyensameyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));

            pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRitu);

            C_ErrorKbn errorKbn = keisanW.exec(calcKijyunYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(errorMsg);
            }

            BizCurrency kaiyakuhrSame = keisanW.getW();
            BizCurrency tsumitateKngk = keisanW.getV();

            List<BizCurrency> wyenlst = getKaiyakuhrknYenKnsn(
                kaiyakuhrSame,
                kawaserateCenter,
                kawaserateEndaka,
                kawaserateEnyasi);

            BizCurrency wyensameyenkijyun = wyenlst.get(0);
            BizCurrency wyensameyenendaka = wyenlst.get(1);
            BizCurrency wyensameyenenyasu = wyenlst.get(2);

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
                mvaariwyensameyenkijyun = wyensameyenkijyun;
                mvaariwyensameyendaka = wyensameyenendaka;
                mvaariwyensameyenyasu = wyensameyenenyasu;
            }
            else {
                mvanoneptumitatekin = tsumitateKngk;
                mvanonewsame = kaiyakuhrSame;
                mvanonewyensameyenkijyun = wyensameyenkijyun;
                mvanonewyensameyendaka = wyensameyenendaka;
                mvanonewyensameyenyasu = wyensameyenenyasu;
            }

            BizCurrency mvaariwyenupyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwyenupyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwyenupyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwup = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituUp);

                errorKbn = keisanW.exec(calcKijyunYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(errorMsg);
                }

                mvaariwup = keisanW.getW();

                wyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwup,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyenupyenkijyun = wyenlst.get(0);
                mvaariwyenupyendaka = wyenlst.get(1);
                mvaariwyenupyenyasu = wyenlst.get(2);
            }


            BizCurrency mvaariwyendownyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwyendownyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwyendownyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
            BizCurrency mvaariwdown = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {

                pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituDown);

                errorKbn = keisanW.exec(calcKijyunYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(errorMsg);
                }

                mvaariwdown = keisanW.getW();

                wyenlst = getKaiyakuhrknYenKnsn(
                    mvaariwdown,
                    kawaserateCenter,
                    kawaserateEndaka,
                    kawaserateEnyasi);

                mvaariwyendownyenkijyun = wyenlst.get(0);
                mvaariwyendownyendaka = wyenlst.get(1);
                mvaariwyendownyenyasu = wyenlst.get(2);
            }

            IT_Suiihyou suiihyou = new IT_Suiihyou();

            suiihyou.setKeikanensuu(wkKeikaNensuu);
            suiihyou.setCalckijyunymd(calcKijyunYmd);
            suiihyou.setCalcym(calcKijyunYm);

            suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
            suiihyou.setYenknsnkwsrateyenkijyun(kawaserateCenter);
            suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasi);
            suiihyou.setYenknsnkwsrategkyendaka(
                BizCurrency.valueOf(new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYenup().toString()),
                    BizCurrencyTypes.YEN));
            suiihyou.setYenknsnkwsrategkyenyasu(
                BizCurrency.valueOf(new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYendown().toString()),
                    BizCurrencyTypes.YEN));
            suiihyou.setMvatekijyoutaikbn(mvaTekiyoujyoutaiKbn);

            if (C_Tuukasyu.JPY.eq(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())) {
                suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_YENDTSYSNHNK2);
            }
            else {
                if(C_SinsaihkKbn.SIN.eq(csinsaihkKbn)){
                    suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_SYSN2_SIN);
                }else{
                    suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_SYSN2_SAI);
                }
            }

            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
                suiihyou.setSjkkktusirrtup(kaiyakuSjkTsRituUp);
                suiihyou.setSjkkktusirrtsame(kaiyakuSjkTsRitu);
                suiihyou.setSjkkktusirrtdown(kaiyakuSjkTsRituDown);
                suiihyou.setSjkkktusirrthendouup(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
                suiihyou.setSjkkktusirrthendoudown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
                suiihyou.setMvaariwsame(kaiyakuhrSame);
                suiihyou.setMvaariwyensameyenkijyun(mvaariwyensameyenkijyun);
                suiihyou.setMvaariptumitatekin(tsumitateKngk);

                if(wkKeikaNensuu != 0){
                    suiihyou.setMvaariwup(mvaariwup);
                    suiihyou.setMvaariwdown(mvaariwdown);
                    suiihyou.setMvaariwyenupyendaka(mvaariwyenupyendaka);
                    suiihyou.setMvaariwyenupyenkijyun(mvaariwyenupyenkijyun);
                    suiihyou.setMvaariwyenupyenyasu(mvaariwyenupyenyasu);
                    suiihyou.setMvaariwyensameyendaka(mvaariwyensameyendaka);
                    suiihyou.setMvaariwyensameyenyasu(mvaariwyensameyenyasu);
                    suiihyou.setMvaariwyendownyendaka(mvaariwyendownyendaka);
                    suiihyou.setMvaariwyendownyenkijyun(mvaariwyendownyenkijyun);
                    suiihyou.setMvaariwyendownyenyasu(mvaariwyendownyenyasu);
                }else{
                    suiihyou.setMvaariwup(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyenupyendaka(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyenupyenkijyun(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyenupyenyasu(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyensameyendaka(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyensameyenyasu(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyendownyendaka(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyendownyenkijyun(BizCurrency.valueOf(0));
                    suiihyou.setMvaariwyendownyenyasu(BizCurrency.valueOf(0));
                }
            }
            else {
                suiihyou.setMvanonewsame(mvanonewsame);
                suiihyou.setMvanonewyensameyendaka(mvanonewyensameyendaka);
                suiihyou.setMvanonewyensameyenkijyun(mvanonewyensameyenkijyun);
                suiihyou.setMvanonewyensameyenyasu(mvanonewyensameyenyasu);
                suiihyou.setMvanoneptumitatekin(mvanoneptumitatekin);
            }

            suiihyouList.add(suiihyou);

            calcKijyunYmd = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO,
                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                C_Hrkkaisuu.NEN,
                calcKijyunYmd);
            calcKijyunYm = calcKijyunYmd.getBizDateYM();

            if (calcYmdHoseiFlg){
                calcKijyunYmd = calcKijyunYmd.getNextDay();
            }

            wkKeikaNensuu = wkKeikaNensuu + 1;
        }

        logger.debug("△ 解約返戻金推移表作成（終身２） 終了");
        return suiihyouList;
    }

    private C_MvaTekiyoujyoutaiKbn setMvatekijyoutaikbn(
        BizDate  pCalcKijyunYmd,
        BizDate  pKykYmd,
        int      pHknkkn,
        C_UmuKbn pMvaTekiUmu,
        int      pMvaTekiKkn){

        C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.BLNK;
        int wkMvaTekikkn = pMvaTekiKkn;

        BizDateSpan mvaKeikaYm = BizDateUtil.calcDifference(pCalcKijyunYmd, pKykYmd);
        int mvaKeikaNensuu = mvaKeikaYm.getYears();

        if(C_UmuKbn.ARI.eq(pMvaTekiUmu) && mvaKeikaNensuu < wkMvaTekikkn) {
            mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
        }
        else if((C_UmuKbn.ARI.eq(pMvaTekiUmu) && mvaKeikaNensuu >= wkMvaTekikkn) || C_UmuKbn.NONE.eq(pMvaTekiUmu)){
            mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
        }

        return mvaTekiyoujyoutaiKbn;
    }

    private List<BizCurrency> getKaiyakuhrknYenKnsn(
        BizCurrency pW,
        BizNumber pKawaserateCenter,
        BizNumber pKawaserateEndaka,
        BizNumber pKawaserateEnyasi) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency wyenyenkijyun = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency wyenyendaka = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency wyenyenyasu = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        List<BizCurrency> wyenlst = null;

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pW,
            pKawaserateCenter,
            C_HasuusyoriKbn.AGE);

        wyenyenkijyun = keisanGaikakanzan.getKanzanGaku();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pW,
            pKawaserateEndaka,
            C_HasuusyoriKbn.AGE);

        wyenyendaka = keisanGaikakanzan.getKanzanGaku();

        keisanGaikakanzan.exec(
            C_Tuukasyu.JPY,
            pW,
            pKawaserateEnyasi,
            C_HasuusyoriKbn.AGE);

        wyenyenyasu = keisanGaikakanzan.getKanzanGaku();

        wyenlst = new ArrayList<BizCurrency>();
        wyenlst.add(wyenyenkijyun);
        wyenlst.add(wyenyendaka);
        wyenlst.add(wyenyenyasu);

        return wyenlst;

    }
}
