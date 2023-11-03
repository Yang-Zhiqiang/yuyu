package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouNenkin}のモッククラスです。<br />
 */
public class WSuiihyouNenkinMockForSinkeiyaku extends WSuiihyouNenkin {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;
    @Override
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                return list;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                IT_Suiihyou suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                suiihyou0.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(3000));
                suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(2000));
                suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(1000));

                suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake11(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake21(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake12(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake22(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake13(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake23(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                list.add(suiihyou0);
                return list;

            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                IT_Suiihyou suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                suiihyou0.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                suiihyou0.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(0.3));
                suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(0.2));
                suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

                suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake11(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake21(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake12(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake22(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake13(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setTutmttknutiwake23(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                list.add(suiihyou0);
                return list;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                IT_Suiihyou iT_Suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                iT_Suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                iT_Suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                iT_Suiihyou.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                iT_Suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.3));
                iT_Suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.2));
                iT_Suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

                list.add(iT_Suiihyou);
                return list;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

                IT_Suiihyou suiihyou0;

                for (int i = 0; i < 20; i++) {

                    suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    if (i == 0) {
                        suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                    } else {
                        suiihyou0.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                    }

                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                    if (i == 0) {
                        suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(-0.015));
                        suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(-0.025));
                        suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(-0.035));
                    }
                    else if (i == 1) {
                        suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(0));
                        suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(0));
                        suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(0));
                    }

                    else {
                        suiihyou0.setSjkkktusirrtsame(BizNumber.valueOf(0.03));
                        suiihyou0.setSjkkktusirrtup(BizNumber.valueOf(0.02));
                        suiihyou0.setSjkkktusirrtdown(BizNumber.valueOf(0.01));
                    }

                    suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setTutmttknutiwake11(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setTutmttknutiwake21(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                    suiihyou0.setTutmttknutiwake12(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setTutmttknutiwake22(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                    suiihyou0.setTutmttknutiwake13(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setTutmttknutiwake23(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                    suiihyou0.setMvaariptumitatekin2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariptumitatekin(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariptumitatekin3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwsame2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwup2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwdown2(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwsame(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwup(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwdown(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwsame3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwup3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));
                    suiihyou0.setMvaariwdown3(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

                    list.add(suiihyou0);
                }

                return list;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

                IT_Suiihyou suiihyou0;

                for (int i = 0; i <= 50; i++) {

                    suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);

                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                    list.add(suiihyou0);
                }

                return list;
            }
            else if (TESTPATTERN8.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

                IT_Suiihyou suiihyou0;

                for (int i = 0; i <= 11; i++) {

                    suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);

                    if (i == 0) {

                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(0));
                        suiihyou0.setZennouzndkyen1(null);
                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));

                    }
                    else if (i == 1) {

                        suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                    }
                    else if (i == 3) {

                        suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                    }
                    else {

                        suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));
                    }

                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));


                    list.add(suiihyou0);
                }

                return list;
            }
            else if (TESTPATTERN9.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

                IT_Suiihyou suiihyou0;

                for (int i = 0; i <= 11; i++) {

                    suiihyou0 = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);

                    if (i == 0) {

                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(0));
                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                    }
                    else if (i == 1) {

                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                    }
                    else if (i == 3) {

                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

                    }
                    else {

                        suiihyou0.setKihrkmp1(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
                        suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));
                    }

                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(30, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(2, BizCurrencyTypes.YEN));

                    list.add(suiihyou0);
                }

                return list;
            }
            else if (TESTPATTERN10.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                IT_Suiihyou iT_Suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                iT_Suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                iT_Suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

                iT_Suiihyou.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                iT_Suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.3));
                iT_Suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.2));
                iT_Suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

                list.add(iT_Suiihyou);
                return list;
            }
            else if (TESTPATTERN11.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                IT_Suiihyou iT_Suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                iT_Suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                iT_Suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));

                iT_Suiihyou.setMvanonewsame2(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanonewsame(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
                iT_Suiihyou.setMvanonewsame3(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN));

                iT_Suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.3));
                iT_Suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.2));
                iT_Suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

                list.add(iT_Suiihyou);
                return list;
            }
        }

        return super.exec(pWSuiihyouParam);
    }

    @Override
    public List<SuiihyouExtBean> getSuiihyouExtBeanLst() {
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                List<SuiihyouExtBean> suiihyouExtBeanList = new ArrayList<SuiihyouExtBean>();

                for (int i = 0; i < 20; i++) {

                    SuiihyouExtBean suiihyouExtBean = new SuiihyouExtBean();

                    if (i == 0) {
                        suiihyouExtBean.setSjkkktusirrtSame(BizNumber.valueOf(-0.015));
                        suiihyouExtBean.setSjkkktusirrtUp(BizNumber.valueOf(-0.025));
                        suiihyouExtBean.setSjkkktusirrtDown(BizNumber.valueOf(-0.035));
                    }
                    else if (i == 1) {
                        suiihyouExtBean.setSjkkktusirrtSame(BizNumber.valueOf(0));
                        suiihyouExtBean.setSjkkktusirrtUp(BizNumber.valueOf(0));
                        suiihyouExtBean.setSjkkktusirrtDown(BizNumber.valueOf(0));
                    }
                    else {
                        suiihyouExtBean.setSjkkktusirrtSame(BizNumber.valueOf(0.03));
                        suiihyouExtBean.setSjkkktusirrtUp(BizNumber.valueOf(0.02));
                        suiihyouExtBean.setSjkkktusirrtDown(BizNumber.valueOf(0.01));
                    }

                    suiihyouExtBean.setSjkkktusirrtHendouUp(null);
                    suiihyouExtBean.setSjkkktusirrtHendouDown(null);
                    suiihyouExtBean.setSisuuUpRitu(null);
                    suiihyouExtBean.setMvaAriPTumitatekin(BizCurrency.valueOf(40000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaAriTmttkgkKykkjmaeUp(BizCurrency.valueOf(41000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaAriTmttkgkKykkjmaeSame(BizCurrency.valueOf(42000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaAriTmttkgkKykjmaeDown(BizCurrency.valueOf(43000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaAriWUp(BizCurrency.valueOf(44000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaAriWSame(BizCurrency.valueOf(45000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaAriWDown(BizCurrency.valueOf(46000, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaNoneWSame(BizCurrency.valueOf(4700, BizCurrencyTypes.YEN));
                    suiihyouExtBean.setMvaNonePTumitatekin(BizCurrency.valueOf(4800, BizCurrencyTypes.YEN));

                    suiihyouExtBeanList.add(suiihyouExtBean);
                }

                return suiihyouExtBeanList;
            }

            List<SuiihyouExtBean> list = new ArrayList<SuiihyouExtBean>();
            return list;
        }
        return super.getSuiihyouExtBeanLst();
    }
}
