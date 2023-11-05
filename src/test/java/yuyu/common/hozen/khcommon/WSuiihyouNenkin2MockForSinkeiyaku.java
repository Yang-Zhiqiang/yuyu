package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouNenkin2}のモッククラスです。<br />
 */
public class WSuiihyouNenkin2MockForSinkeiyaku extends WSuiihyouNenkin2 {

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
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

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
                    suiihyou0.setMvanoneptumitatekin2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    suiihyou0.setMvanoneptumitatekin3(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    suiihyou0.setYtirrtcalckijyunrrt3(BizNumber.valueOf(1));

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
        }
        return super.exec(pWSuiihyouParam);
    }
}
