package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouNenkin2}のモッククラスです。<br />
 */
public class WSuiihyouNenkin2Mock extends WSuiihyouNenkin2{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN6.equals(SYORIPTN)) {

            throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN7.equals(SYORIPTN)) {

            List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

            IT_Suiihyou suiihyou0;

            for (int i = 0; i <= 65; i++) {

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
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN8.equals(SYORIPTN)) {

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

        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && TESTPATTERN9.equals(SYORIPTN)) {

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
        else if (caller == EditSuiihyouTblNenkin2Test_editTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                BizDate tyouhyouymd = BizDate.valueOf("20190401");
                IT_Suiihyou suiihyou0;
                for (int i = 0; i < 12; i++) {
                    suiihyou0 = new IT_Suiihyou("01", "11807111118", tyouhyouymd.addDays(i), i);
                    if (i == 9 ) {
                        suiihyou0.setCalckijyunymd(BizDate.valueOf("20140302"));
                    }
                    else {
                        suiihyou0.setCalckijyunymd(BizDate.valueOf("20190302"));
                    }

                    suiihyou0.setKeikanensuu(1);
                    suiihyou0.setCalcym(BizDateYM.valueOf("201901"));
                    suiihyou0.setSuiihyousyubetu("1");
                    suiihyou0.setYenknsnkwsrateyendaka(BizNumber.valueOf(1));
                    suiihyou0.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(2));
                    suiihyou0.setYenknsnkwsrateyenyasu(BizNumber.valueOf(3));
                    suiihyou0.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(4));
                    suiihyou0.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(5));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(6));
                    suiihyou0.setMvanonewyensameyendaka(BizCurrency.valueOf(7));
                    suiihyou0.setMvanonewyensameyenkijyun(BizCurrency.valueOf(8));
                    suiihyou0.setMvanonewyensameyenyasu(BizCurrency.valueOf(9));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(10));
                    suiihyou0.setYenknsnkwsrateyendaka2(BizNumber.valueOf(11));
                    suiihyou0.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(12));
                    suiihyou0.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(13));
                    suiihyou0.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(14));
                    suiihyou0.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(15));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(16));
                    suiihyou0.setMvanonewyensameyendaka2(BizCurrency.valueOf(17));
                    suiihyou0.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(18));
                    suiihyou0.setMvanonewyensameyenyasu2(BizCurrency.valueOf(19));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(20));
                    suiihyou0.setYenknsnkwsrateyendaka3(BizNumber.valueOf(21));
                    suiihyou0.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(22));
                    suiihyou0.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(23));
                    suiihyou0.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(24));
                    suiihyou0.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(25));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(26));
                    suiihyou0.setMvanonewyensameyendaka3(BizCurrency.valueOf(27));
                    suiihyou0.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(28));
                    suiihyou0.setMvanonewyensameyenyasu3(BizCurrency.valueOf(29));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou0.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                    suiihyou0.setYtirrtcalckijyunrrt1(BizNumber.valueOf(31));
                    suiihyou0.setYtirrtcalckijyunrrt2(BizNumber.valueOf(32));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(33));
                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(34));
                    suiihyou0.setZennouzndkyen2(BizCurrency.valueOf(35));
                    suiihyou0.setZennouzndkyen3(BizCurrency.valueOf(36));
                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(37));
                    suiihyou0.setKihrkmpyen2(BizCurrency.valueOf(38));
                    suiihyou0.setKihrkmpyen3(BizCurrency.valueOf(39));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(40));
                    suiihyou0.setKihrkmp2(BizCurrency.valueOf(41));
                    suiihyou0.setKihrkmp3(BizCurrency.valueOf(42));

                    list.add(suiihyou0);
                }
                return list;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                BizDate tyouhyouymd = BizDate.valueOf("20190401");
                IT_Suiihyou suiihyou0;
                for (int i = 0; i < 2; i++) {
                    suiihyou0 = new IT_Suiihyou("01", "11807111118", tyouhyouymd.addDays(i), i);
                    if (i == 0 ) {
                        suiihyou0.setCalckijyunymd(BizDate.valueOf("20190302"));
                    }
                    else {
                        suiihyou0.setCalckijyunymd(BizDate.valueOf("20190303"));
                    }

                    suiihyou0.setKeikanensuu(1);
                    suiihyou0.setCalcym(BizDateYM.valueOf("201901"));
                    suiihyou0.setSuiihyousyubetu("1");
                    suiihyou0.setYenknsnkwsrateyendaka(BizNumber.valueOf(1));
                    suiihyou0.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(2));
                    suiihyou0.setYenknsnkwsrateyenyasu(BizNumber.valueOf(3));
                    suiihyou0.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(4));
                    suiihyou0.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(5));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(6));
                    suiihyou0.setMvanonewyensameyendaka(BizCurrency.valueOf(7));
                    suiihyou0.setMvanonewyensameyenkijyun(BizCurrency.valueOf(8));
                    suiihyou0.setMvanonewyensameyenyasu(BizCurrency.valueOf(9));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(10));
                    suiihyou0.setYenknsnkwsrateyendaka2(BizNumber.valueOf(11));
                    suiihyou0.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(12));
                    suiihyou0.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(13));
                    suiihyou0.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(14));
                    suiihyou0.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(15));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(16));
                    suiihyou0.setMvanonewyensameyendaka2(BizCurrency.valueOf(17));
                    suiihyou0.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(18));
                    suiihyou0.setMvanonewyensameyenyasu2(BizCurrency.valueOf(19));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(20));
                    suiihyou0.setYenknsnkwsrateyendaka3(BizNumber.valueOf(21));
                    suiihyou0.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(22));
                    suiihyou0.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(23));
                    suiihyou0.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(24));
                    suiihyou0.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(25));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(26));
                    suiihyou0.setMvanonewyensameyendaka3(BizCurrency.valueOf(27));
                    suiihyou0.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(28));
                    suiihyou0.setMvanonewyensameyenyasu3(BizCurrency.valueOf(29));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou0.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                    suiihyou0.setYtirrtcalckijyunrrt1(BizNumber.valueOf(31));
                    suiihyou0.setYtirrtcalckijyunrrt2(BizNumber.valueOf(32));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(33));
                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(34));
                    suiihyou0.setZennouzndkyen2(BizCurrency.valueOf(35));
                    suiihyou0.setZennouzndkyen3(BizCurrency.valueOf(36));
                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(37));
                    suiihyou0.setKihrkmpyen2(BizCurrency.valueOf(38));
                    suiihyou0.setKihrkmpyen3(BizCurrency.valueOf(39));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(40));
                    suiihyou0.setKihrkmp2(BizCurrency.valueOf(41));
                    suiihyou0.setKihrkmp3(BizCurrency.valueOf(42));

                    list.add(suiihyou0);
                }
                return list;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                BizDate tyouhyouymd = BizDate.valueOf("20190401");
                IT_Suiihyou suiihyou0;
                for (int i = 0; i < 1; i++) {
                    suiihyou0 = new IT_Suiihyou("01", "11807111118", tyouhyouymd.addDays(i), i);
                    suiihyou0.setCalckijyunymd(BizDate.valueOf("20190304"));
                    suiihyou0.setKeikanensuu(1);
                    suiihyou0.setCalcym(BizDateYM.valueOf("201901"));
                    suiihyou0.setSuiihyousyubetu("1");
                    suiihyou0.setYenknsnkwsrateyendaka(BizNumber.valueOf(1));
                    suiihyou0.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(2));
                    suiihyou0.setYenknsnkwsrateyenyasu(BizNumber.valueOf(3));
                    suiihyou0.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(4));
                    suiihyou0.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(5));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(6));
                    suiihyou0.setMvanonewyensameyendaka(BizCurrency.valueOf(7));
                    suiihyou0.setMvanonewyensameyenkijyun(BizCurrency.valueOf(8));
                    suiihyou0.setMvanonewyensameyenyasu(BizCurrency.valueOf(9));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(10));
                    suiihyou0.setYenknsnkwsrateyendaka2(BizNumber.valueOf(11));
                    suiihyou0.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(12));
                    suiihyou0.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(13));
                    suiihyou0.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(14));
                    suiihyou0.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(15));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(16));
                    suiihyou0.setMvanonewyensameyendaka2(BizCurrency.valueOf(17));
                    suiihyou0.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(18));
                    suiihyou0.setMvanonewyensameyenyasu2(BizCurrency.valueOf(19));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(20));
                    suiihyou0.setYenknsnkwsrateyendaka3(BizNumber.valueOf(21));
                    suiihyou0.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(22));
                    suiihyou0.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(23));
                    suiihyou0.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(24));
                    suiihyou0.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(25));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(26));
                    suiihyou0.setMvanonewyensameyendaka3(BizCurrency.valueOf(27));
                    suiihyou0.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(28));
                    suiihyou0.setMvanonewyensameyenyasu3(BizCurrency.valueOf(29));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou0.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                    suiihyou0.setYtirrtcalckijyunrrt1(BizNumber.valueOf(31));
                    suiihyou0.setYtirrtcalckijyunrrt2(BizNumber.valueOf(32));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(33));
                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(34));
                    suiihyou0.setZennouzndkyen2(BizCurrency.valueOf(35));
                    suiihyou0.setZennouzndkyen3(BizCurrency.valueOf(36));
                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(37));
                    suiihyou0.setKihrkmpyen2(BizCurrency.valueOf(38));
                    suiihyou0.setKihrkmpyen3(BizCurrency.valueOf(39));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(40));
                    suiihyou0.setKihrkmp2(BizCurrency.valueOf(41));
                    suiihyou0.setKihrkmp3(BizCurrency.valueOf(42));

                    list.add(suiihyou0);
                }
                return list;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();
                BizDate tyouhyouymd = BizDate.valueOf("20190401");
                IT_Suiihyou suiihyou0;
                for (int i = 0; i < 12; i++) {
                    suiihyou0 = new IT_Suiihyou("01", "11807111118", tyouhyouymd.addDays(i), i);
                    if (i == 9 ) {
                        suiihyou0.setCalckijyunymd(BizDate.valueOf("20140303"));
                    }
                    else {
                        suiihyou0.setCalckijyunymd(BizDate.valueOf("20190303"));
                    }

                    suiihyou0.setKeikanensuu(1);
                    suiihyou0.setCalcym(BizDateYM.valueOf("201901"));
                    suiihyou0.setSuiihyousyubetu("1");
                    suiihyou0.setYenknsnkwsrateyendaka(BizNumber.valueOf(1));
                    suiihyou0.setYenknsnkwsrateyenkijyun(BizNumber.valueOf(2));
                    suiihyou0.setYenknsnkwsrateyenyasu(BizNumber.valueOf(3));
                    suiihyou0.setYenknsnkwsrategkyendaka(BizCurrency.valueOf(4));
                    suiihyou0.setYenknsnkwsrategkyenyasu(BizCurrency.valueOf(5));
                    suiihyou0.setMvanonewsame(BizCurrency.valueOf(6));
                    suiihyou0.setMvanonewyensameyendaka(BizCurrency.valueOf(7));
                    suiihyou0.setMvanonewyensameyenkijyun(BizCurrency.valueOf(8));
                    suiihyou0.setMvanonewyensameyenyasu(BizCurrency.valueOf(9));
                    suiihyou0.setMvanoneptumitatekin(BizCurrency.valueOf(10));
                    suiihyou0.setYenknsnkwsrateyendaka2(BizNumber.valueOf(11));
                    suiihyou0.setYenknsnkwsrateyenkijyun2(BizNumber.valueOf(12));
                    suiihyou0.setYenknsnkwsrateyenyasu2(BizNumber.valueOf(13));
                    suiihyou0.setYenknsnkwsrategkyendaka2(BizCurrency.valueOf(14));
                    suiihyou0.setYenknsnkwsrategkyenyasu2(BizCurrency.valueOf(15));
                    suiihyou0.setMvanonewsame2(BizCurrency.valueOf(16));
                    suiihyou0.setMvanonewyensameyendaka2(BizCurrency.valueOf(17));
                    suiihyou0.setMvanonewyensameyenkijyun2(BizCurrency.valueOf(18));
                    suiihyou0.setMvanonewyensameyenyasu2(BizCurrency.valueOf(19));
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(20));
                    suiihyou0.setYenknsnkwsrateyendaka3(BizNumber.valueOf(21));
                    suiihyou0.setYenknsnkwsrateyenkijyun3(BizNumber.valueOf(22));
                    suiihyou0.setYenknsnkwsrateyenyasu3(BizNumber.valueOf(23));
                    suiihyou0.setYenknsnkwsrategkyendaka3(BizCurrency.valueOf(24));
                    suiihyou0.setYenknsnkwsrategkyenyasu3(BizCurrency.valueOf(25));
                    suiihyou0.setMvanonewsame3(BizCurrency.valueOf(26));
                    suiihyou0.setMvanonewyensameyendaka3(BizCurrency.valueOf(27));
                    suiihyou0.setMvanonewyensameyenkijyun3(BizCurrency.valueOf(28));
                    suiihyou0.setMvanonewyensameyenyasu3(BizCurrency.valueOf(29));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou0.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                    suiihyou0.setYtirrtcalckijyunrrt1(BizNumber.valueOf(31));
                    suiihyou0.setYtirrtcalckijyunrrt2(BizNumber.valueOf(32));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(33));
                    suiihyou0.setZennouzndkyen1(BizCurrency.valueOf(34));
                    suiihyou0.setZennouzndkyen2(BizCurrency.valueOf(35));
                    suiihyou0.setZennouzndkyen3(BizCurrency.valueOf(36));
                    suiihyou0.setKihrkmpyen1(BizCurrency.valueOf(37));
                    suiihyou0.setKihrkmpyen2(BizCurrency.valueOf(38));
                    suiihyou0.setKihrkmpyen3(BizCurrency.valueOf(39));
                    suiihyou0.setKihrkmp1(BizCurrency.valueOf(40));
                    suiihyou0.setKihrkmp2(BizCurrency.valueOf(41));
                    suiihyou0.setKihrkmp3(BizCurrency.valueOf(42));

                    list.add(suiihyou0);
                }
                return list;
            }
        }

        return super.exec(pWSuiihyouParam);
    }
}
