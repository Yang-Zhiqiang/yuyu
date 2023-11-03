package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouNenkin3}のモッククラスです。<br />
 */
public class WSuiihyouNenkin3MockForSinkeiyaku extends WSuiihyouNenkin3 {

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

        List<IT_Suiihyou> list = new ArrayList<IT_Suiihyou>();

        IT_Suiihyou suiihyou = new IT_Suiihyou();

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                for (int i = 0; i < 20; i++) {

                    suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(10));
                    suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(21));
                    suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(134));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(11));
                    suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(22));
                    suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(32));
                    suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(133));
                    suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(135));
                    suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(233));
                    suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(244));
                    suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(255));
                    suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(348));
                    suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(349));
                    suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(350));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(111));
                    suiihyou.setMvaariwsame(BizCurrency.valueOf(112));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(113));
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                    suiihyou.setMvaariwup2(BizCurrency.valueOf(160));
                    suiihyou.setMvaariwsame2(BizCurrency.valueOf(170));
                    suiihyou.setMvaariwdown2(BizCurrency.valueOf(180));
                    suiihyou.setMvanonewsame2(BizCurrency.valueOf(290));
                    suiihyou.setMvaariwup3(BizCurrency.valueOf(511));
                    suiihyou.setMvaariwsame3(BizCurrency.valueOf(521));
                    suiihyou.setMvaariwdown3(BizCurrency.valueOf(531));
                    suiihyou.setMvanonewsame3(BizCurrency.valueOf(641));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.1));
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(-0.1));

                    list.add(suiihyou);
                }
                return list;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                for (int i = 0; i < 20; i++) {

                    suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(10));
                    suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(21));
                    suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(134));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(11));
                    suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(22));
                    suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(32));
                    suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(133));
                    suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(135));
                    suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(233));
                    suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(244));
                    suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(255));
                    suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(348));
                    suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(349));
                    suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(350));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(111));
                    suiihyou.setMvaariwsame(BizCurrency.valueOf(112));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(113));
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                    suiihyou.setMvaariwup2(BizCurrency.valueOf(160));
                    suiihyou.setMvaariwsame2(BizCurrency.valueOf(170));
                    suiihyou.setMvaariwdown2(BizCurrency.valueOf(180));
                    suiihyou.setMvanonewsame2(BizCurrency.valueOf(290));
                    suiihyou.setMvaariwup3(BizCurrency.valueOf(511));
                    suiihyou.setMvaariwsame3(BizCurrency.valueOf(521));
                    suiihyou.setMvaariwdown3(BizCurrency.valueOf(531));
                    suiihyou.setMvanonewsame3(BizCurrency.valueOf(641));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(-0.1));
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0.1));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0));

                    list.add(suiihyou);

                }
                return list;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                for (int i = 0; i < 2; i++) {

                    suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    if (i == 0) {
                        suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                    }
                    else {
                        suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                    }
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(10));
                    suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(21));
                    suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(134));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(11));
                    suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(22));
                    suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(32));
                    suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(133));
                    suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(135));
                    suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(233));
                    suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(244));
                    suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(255));
                    suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(348));
                    suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(349));
                    suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(350));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(111));
                    suiihyou.setMvaariwsame(BizCurrency.valueOf(112));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(113));
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                    suiihyou.setMvaariwup2(BizCurrency.valueOf(160));
                    suiihyou.setMvaariwsame2(BizCurrency.valueOf(170));
                    suiihyou.setMvaariwdown2(BizCurrency.valueOf(180));
                    suiihyou.setMvanonewsame2(BizCurrency.valueOf(290));
                    suiihyou.setMvaariwup3(BizCurrency.valueOf(511));
                    suiihyou.setMvaariwsame3(BizCurrency.valueOf(521));
                    suiihyou.setMvaariwdown3(BizCurrency.valueOf(531));
                    suiihyou.setMvanonewsame3(BizCurrency.valueOf(641));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0));
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(-0.2));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

                    list.add(suiihyou);
                }
                return list;
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                for (int i = 0; i < 1; i++) {

                    suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    if (i == 0) {
                        suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                    }
                    else {
                        suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVANONE);
                    }
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(10));
                    suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(21));
                    suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(30));
                    suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(134));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(11));
                    suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(22));
                    suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(32));
                    suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(133));
                    suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(135));
                    suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(233));
                    suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(244));
                    suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(255));
                    suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(348));
                    suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(349));
                    suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(350));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(111));
                    suiihyou.setMvaariwsame(BizCurrency.valueOf(112));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(113));
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                    suiihyou.setMvaariwup2(BizCurrency.valueOf(160));
                    suiihyou.setMvaariwsame2(BizCurrency.valueOf(170));
                    suiihyou.setMvaariwdown2(BizCurrency.valueOf(180));
                    suiihyou.setMvanonewsame2(BizCurrency.valueOf(290));
                    suiihyou.setMvaariwup3(BizCurrency.valueOf(511));
                    suiihyou.setMvaariwsame3(BizCurrency.valueOf(521));
                    suiihyou.setMvaariwdown3(BizCurrency.valueOf(531));
                    suiihyou.setMvanonewsame3(BizCurrency.valueOf(641));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0));
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(-0.1));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(0.1));

                    list.add(suiihyou);
                }
                return list;
            }

            if (TESTPATTERN5.equals(SYORIPTN)) {
                return list;
            }

            if (TESTPATTERN6.equals(SYORIPTN)) {

                throw new CommonBizAppException("解約返戻金計算が実行できませんでした。");
            }

            if (TESTPATTERN7.equals(SYORIPTN)) {

                for (int i = 0; i < 20; i++) {

                    suiihyou = new IT_Suiihyou("01", "11807111118", BizDate.valueOf(20180101), 1);
                    suiihyou.setMvatekijyoutaikbn(C_MvaTekiyoujyoutaiKbn.MVAARI);
                    suiihyou.setMvaariptumitatekin(BizCurrency.valueOf(10 + i));
                    suiihyou.setMvaariptumitatekin2(BizCurrency.valueOf(31 + i));
                    suiihyou.setMvaariptumitatekin3(BizCurrency.valueOf(51 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaesame1(BizCurrency.valueOf(131 + i));
                    suiihyou.setMvanoneptumitatekin(BizCurrency.valueOf(11));
                    suiihyou.setMvanoneptumitatekin2(BizCurrency.valueOf(22));
                    suiihyou.setMvanoneptumitatekin3(BizCurrency.valueOf(32));
                    suiihyou.setMvaaritmttkgkkykkjmaeup1(BizCurrency.valueOf(161 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaedown1(BizCurrency.valueOf(181 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaeup2(BizCurrency.valueOf(231 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaesame2(BizCurrency.valueOf(211 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaedown2(BizCurrency.valueOf(251 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaeup3(BizCurrency.valueOf(291 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaesame3(BizCurrency.valueOf(271 + i));
                    suiihyou.setMvaaritmttkgkkykkjmaedown3(BizCurrency.valueOf(311 + i));
                    suiihyou.setMvaariwup(BizCurrency.valueOf(351 + i));
                    suiihyou.setMvaariwsame(BizCurrency.valueOf(331 + i));
                    suiihyou.setMvaariwdown(BizCurrency.valueOf(371 + i));
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(124));
                    suiihyou.setMvaariwup2(BizCurrency.valueOf(411 + i));
                    suiihyou.setMvaariwsame2(BizCurrency.valueOf(391 + i));
                    suiihyou.setMvaariwdown2(BizCurrency.valueOf(431 + i));
                    suiihyou.setMvanonewsame2(BizCurrency.valueOf(290));
                    suiihyou.setMvaariwup3(BizCurrency.valueOf(471 + i));
                    suiihyou.setMvaariwsame3(BizCurrency.valueOf(451 + i));
                    suiihyou.setMvaariwdown3(BizCurrency.valueOf(510 + i));
                    suiihyou.setMvanonewsame3(BizCurrency.valueOf(641));
                    suiihyou.setSjkkktusirrtup(BizNumber.valueOf(0.1));
                    suiihyou.setSjkkktusirrtsame(BizNumber.valueOf(0));
                    suiihyou.setSjkkktusirrtdown(BizNumber.valueOf(-0.1));

                    list.add(suiihyou);
                }
                return list;
            }

        }

        return super.exec(pWSuiihyouParam);
    }

    @Override
    public List<SuiihyouExtBean> getSuiihyouExtBeanLst() {
        List<SuiihyouExtBean> suiihyouExtBeanLst = new ArrayList<SuiihyouExtBean>();
        SuiihyouExtBean suiihyouExtBean = new SuiihyouExtBean();

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            for (int i = 0; i < 20; i++) {
                suiihyouExtBean = new SuiihyouExtBean();
                suiihyouExtBean.setKaiyakuKjRitu(BizNumber.valueOf((12345 + i)).divide(10000));
                suiihyouExtBean.setKaiyakuKjgk(BizCurrency.valueOf(120 + i));

                suiihyouExtBeanLst.add(suiihyouExtBean);
            }

            return suiihyouExtBeanLst;
        }
        return super.getSuiihyouExtBeanLst();
    }


}
