package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouSyuusin2}のモッククラスです。<br />
 */
public class WSuiihyouSyuusin2MockForHozen extends WSuiihyouSyuusin2 {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {
        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        if (caller == EditSuiihyouTblSyuusin2Test_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                BizDate calcKijyunYmd = null;
                int wkKeikaNensuu = 0;
                int wkKeikaNensuuMax = 0;

                if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn())) {
                    calcKijyunYmd = pWSuiihyouParam.getKeisanWExtBean().getKykymd();
                    wkKeikaNensuuMax = 105 - pWSuiihyouParam.getKeisanWExtBean().getHhknnen();
                }
                else {
                    calcKijyunYmd = setOutoubi.exec(
                        C_TykzentykgoKbn.TYKGO,
                        pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                        C_Hrkkaisuu.NEN,
                        pWSuiihyouParam.getCalcKijyunYmd());

                    wkKeikaNensuu = BizDateUtil.calcDifference(calcKijyunYmd, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();
                    wkKeikaNensuuMax = 105 - pWSuiihyouParam.getKeisanWExtBean().getHhknnen() - wkKeikaNensuu;
                }

                for (int cnt = 0; cnt <= wkKeikaNensuuMax; cnt++) {

                    IT_Suiihyou suiihyou = new IT_Suiihyou();
                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                    suiihyou.setKeikanensuu(wkKeikaNensuu);
                    suiihyou.setCalckijyunymd(calcKijyunYmd);
                    suiihyou.setCalcym(calcKijyunYmd.getBizDateYM());

                    suiihyou.setYenknsnkwsrateyendaka(BizNumber.valueOf(101.01));
                    suiihyou.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(202.02));
                    suiihyou.setYenknsnkwsrateyenyasu(BizNumber.valueOf(303.03));
                    suiihyou.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(Long.valueOf("11"), BizCurrencyTypes.YEN));
                    suiihyou.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(Long.valueOf("33"), BizCurrencyTypes.YEN));

                    C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
                    if (wkKeikaNensuu < pWSuiihyouParam.getMvaTekiKkn()) {
                        mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
                    }
                    suiihyou.setMvatekijyoutaikbn(mvaTekiyoujyoutaiKbn);

                    suiihyou.setSuiihyousyubetu("99");

                    if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
                        suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.1111));
                        suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.2222));
                        suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.3333));
                        suiihyou.setSjkkktusirrthendouup(BizNumber.valueOf(0.1001));
                        suiihyou.setSjkkktusirrthendoudown(BizNumber.valueOf(0.3003));
                        suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0101"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0102"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0103"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvaariwup(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvaariwsame(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvaariwdown(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvaariwyenupyendaka(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyenupyenkijyun(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyenupyenyasu(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyensameyendaka(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyensameyenkijyun(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyensameyenyasu(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyendownyendaka(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyendownyenkijyun(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariwyendownyenyasu(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                    }
                    else {
                        suiihyou.setMvanonewsame(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                        suiihyou.setMvanonewyensameyendaka(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvanonewyensameyenkijyun(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvanonewyensameyenyasu(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"),
                            henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY)));
                        suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"),
                            henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())));
                    }
                    suiihyouList.add(suiihyou);

                    calcKijyunYmd = setOutoubi.exec(
                        C_TykzentykgoKbn.TYKGO,
                        pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
                        C_Hrkkaisuu.NEN,
                        calcKijyunYmd);

                    wkKeikaNensuu = wkKeikaNensuu + 1;
                }
                return suiihyouList;
            }
        }
        return super.exec(pWSuiihyouParam);
    }

    @Override
    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
        super.setYenkansannYhKbn(pYenkansannYhKbn);
    }
}
