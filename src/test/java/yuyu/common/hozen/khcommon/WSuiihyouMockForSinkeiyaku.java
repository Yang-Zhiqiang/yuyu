package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbseihowebkaiyakuhrsuii.HbSeihoWebKaiyakuhrSuiiTest_execPostForm;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyou}のモッククラスです。<br />
 */
public class WSuiihyouMockForSinkeiyaku extends WSuiihyou{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        List<IT_Suiihyou> suiihyouLst = new ArrayList<>();

        if (caller == HbSeihoWebKaiyakuhrSuiiTest_execPostForm.class) {

            IT_Suiihyou suiihyou1 = new IT_Suiihyou();

            if (SYORIPTN == TESTPATTERN1) {

                suiihyou1.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARINONE);
                suiihyou1.setSjkkktusirrtsame(BizNumber.valueOf(-0.001));
                suiihyou1.setSjkkktusirrtup(BizNumber.valueOf(-0.002));
                suiihyou1.setSjkkktusirrtdown(BizNumber.valueOf(-0.003));

                suiihyou1.setMvaariwsame(BizCurrency.valueOf(1));
                suiihyou1.setMvaariwup(BizCurrency.valueOf(11));
                suiihyou1.setMvaariwdown(BizCurrency.valueOf(111));
                suiihyou1.setMvaariptumitatekin(BizCurrency.valueOf(2));

                suiihyou1.setMvanonewsame(BizCurrency.valueOf(12));
                suiihyou1.setMvanoneptumitatekin(BizCurrency.valueOf(23));
                suiihyouLst.add(suiihyou1);
            }
            else if (SYORIPTN == TESTPATTERN2) {

                suiihyou1.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                suiihyou1.setSjkkktusirrtsame(BizNumber.valueOf(0));
                suiihyou1.setSjkkktusirrtup(BizNumber.valueOf(0));
                suiihyou1.setSjkkktusirrtdown(BizNumber.valueOf(0));

                suiihyou1.setMvaariwsame(BizCurrency.valueOf(3));
                suiihyou1.setMvaariwup(BizCurrency.valueOf(33));
                suiihyou1.setMvaariwdown(BizCurrency.valueOf(333));
                suiihyou1.setMvaariptumitatekin(BizCurrency.valueOf(4));

                suiihyou1.setMvanonewsame(BizCurrency.valueOf(13));
                suiihyou1.setMvanoneptumitatekin(BizCurrency.valueOf(21));
                suiihyouLst.add(suiihyou1);
            }
            else if (SYORIPTN == TESTPATTERN3) {

                for (int i = 1; i < 100; i++) {

                    IT_Suiihyou suiihyou = new IT_Suiihyou();
                    suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARINONE);
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(-0.001));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(-0.002));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(-0.003));

                    suiihyou.setMvaariwsame(BizCurrency.valueOf(i));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(200 + i));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(400 + i));
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(100 + i));

                    suiihyou.setMvanonewsame(BizCurrency.valueOf(12));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(23));

                    suiihyouLst.add(suiihyou);
                }
            }
            else if (SYORIPTN == TESTPATTERN4) {

                for (int i = 1; i < 3; i++) {

                    IT_Suiihyou suiihyou = new IT_Suiihyou();
                    suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARINONE);
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.001));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.002));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.003));

                    suiihyou.setMvaariwsame(BizCurrency.valueOf(i));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(200 + i));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(400 + i));
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(100 + i));

                    suiihyou.setMvanonewsame(BizCurrency.valueOf(12));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(23));

                    suiihyouLst.add(suiihyou);
                }
            }
            else if (SYORIPTN == TESTPATTERN5) {

                int a = 3 / 0;
            }
            else if (SYORIPTN == TESTPATTERN6) {

                suiihyou1.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARINONE);
                suiihyou1.setSjkkktusirrtsame(BizNumber.valueOf(-99999999999L));
                suiihyou1.setSjkkktusirrtup(BizNumber.valueOf(-0.002));
                suiihyou1.setSjkkktusirrtdown(BizNumber.valueOf(-0.003));

                suiihyou1.setMvaariwsame(BizCurrency.valueOf(1));
                suiihyou1.setMvaariwup(BizCurrency.valueOf(11));
                suiihyou1.setMvaariwdown(BizCurrency.valueOf(111));
                suiihyou1.setMvaariptumitatekin(BizCurrency.valueOf(2));

                suiihyou1.setMvanonewsame(BizCurrency.valueOf(12));
                suiihyou1.setMvanoneptumitatekin(BizCurrency.valueOf(23));
                suiihyouLst.add(suiihyou1);
            }

            return suiihyouLst;

        }

        return super.exec(pWSuiihyouParam);
    }
}
