package yuyu.common.siharai.sicommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.siedittyouhyou.EditEnkaryuuiTest_exec;
import yuyu.common.siharai.siedittyouhyou.EditSiharaimeisaisyoTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;

/**
 * {@link SiMeisaiCommonHensyu}のモッククラスです。<br />
 */
public class SiMeisaiCommonHensyuMock extends SiMeisaiCommonHensyu{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private List<SiMeisaiCommonHensyuResultBean>[] sisansyoHensyuResult;

    @Override
    public C_ErrorKbn sisansyoHensyu(SiHkkingakuSisanParamBean siHkkingakuSisanParamBean, List<SiSiDetailParamBean> siSiDetailParamBeanList) {
        if (caller == EditEnkaryuuiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                super.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanList);
                return C_ErrorKbn.ERROR;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanList);
    }

    @Override
    public List<SiMeisaiCommonHensyuResultBean>[] getSisansyoHensyuResult() {
        if (caller == EditEnkaryuuiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return sisansyoHensyuResult;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                List<SiMeisaiCommonHensyuResultBean> sisansyoYenHensyuKekka = new ArrayList<>();
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean.setTekiYou("円貨給付名１");
                siMeisaiCommonHensyuYenResultBean.setShrGkMeisai(BizCurrency.valueOf(111111));
                siMeisaiCommonHensyuYenResultBean.setRendouShrGkMeisai(100001);
                siMeisaiCommonHensyuYenResultBean.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean.setDetailBikou("円貨備考１");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean2 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean2.setTekiYou("円貨給付名２");
                siMeisaiCommonHensyuYenResultBean2.setShrGkMeisai(BizCurrency.valueOf(222222));
                siMeisaiCommonHensyuYenResultBean2.setRendouShrGkMeisai(200002);
                siMeisaiCommonHensyuYenResultBean2.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean2.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean2.setDetailBikou("円貨備考２");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean2);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean3 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean3.setTekiYou("円貨給付名３");
                siMeisaiCommonHensyuYenResultBean3.setShrGkMeisai(BizCurrency.valueOf(333333));
                siMeisaiCommonHensyuYenResultBean3.setRendouShrGkMeisai(30003);
                siMeisaiCommonHensyuYenResultBean3.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean3.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean3.setDetailBikou("円貨備考３");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean3);

                sisansyoHensyuResult = new ArrayList[1];
                sisansyoHensyuResult[0] = sisansyoYenHensyuKekka;

                return sisansyoHensyuResult;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                List<SiMeisaiCommonHensyuResultBean> sisansyoSiteituukaHensyuKekka = new ArrayList<>();
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean.setTekiYou("外貨給付名１");
                siMeisaiCommonHensyuResultBean.setShrGkMeisai(BizCurrency.valueOf(1111111));
                siMeisaiCommonHensyuResultBean.setRendouShrGkMeisai(111111100);
                siMeisaiCommonHensyuResultBean.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean.setDetailBikou("外貨備考１");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean2 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean2.setTekiYou("外貨給付名２");
                siMeisaiCommonHensyuResultBean2.setShrGkMeisai(BizCurrency.valueOf(2222222));
                siMeisaiCommonHensyuResultBean2.setRendouShrGkMeisai(222222200);
                siMeisaiCommonHensyuResultBean2.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean2.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean2.setDetailBikou("外貨備考２");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean2);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean3 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean3.setTekiYou("外貨給付名３");
                siMeisaiCommonHensyuResultBean3.setShrGkMeisai(BizCurrency.valueOf(3333333));
                siMeisaiCommonHensyuResultBean3.setRendouShrGkMeisai(333333300);
                siMeisaiCommonHensyuResultBean3.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean3.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean3.setDetailBikou("外貨備考３");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean3);

                List<SiMeisaiCommonHensyuResultBean> sisansyoYenHensyuKekka = new ArrayList<>();
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean.setTekiYou("円貨給付名１");
                siMeisaiCommonHensyuYenResultBean.setShrGkMeisai(BizCurrency.valueOf(111111));
                siMeisaiCommonHensyuYenResultBean.setRendouShrGkMeisai(100001);
                siMeisaiCommonHensyuYenResultBean.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean.setDetailBikou("円貨備考１");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean2 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean2.setTekiYou("円貨給付名２");
                siMeisaiCommonHensyuYenResultBean2.setShrGkMeisai(BizCurrency.valueOf(222222));
                siMeisaiCommonHensyuYenResultBean2.setRendouShrGkMeisai(200002);
                siMeisaiCommonHensyuYenResultBean2.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean2.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean2.setDetailBikou("円貨備考２");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean2);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean3 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean3.setTekiYou("円貨給付名３");
                siMeisaiCommonHensyuYenResultBean3.setShrGkMeisai(BizCurrency.valueOf(333333));
                siMeisaiCommonHensyuYenResultBean3.setRendouShrGkMeisai(30003);
                siMeisaiCommonHensyuYenResultBean3.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean3.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean3.setDetailBikou("円貨備考３");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean3);

                sisansyoHensyuResult = new ArrayList[2];
                sisansyoHensyuResult[0] = sisansyoSiteituukaHensyuKekka;
                sisansyoHensyuResult[1] = sisansyoYenHensyuKekka;

                return sisansyoHensyuResult;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                List<SiMeisaiCommonHensyuResultBean> sisansyoSiteituukaHensyuKekka = new ArrayList<>();
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean.setTekiYou("外貨給付名１");
                siMeisaiCommonHensyuResultBean.setShrGkMeisai(BizCurrency.valueOf(1111111));
                siMeisaiCommonHensyuResultBean.setRendouShrGkMeisai(111111100);
                siMeisaiCommonHensyuResultBean.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean.setDetailBikou("外貨備考１");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean2 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean2.setTekiYou("外貨給付名２");
                siMeisaiCommonHensyuResultBean2.setShrGkMeisai(BizCurrency.valueOf(2222222));
                siMeisaiCommonHensyuResultBean2.setRendouShrGkMeisai(222222200);
                siMeisaiCommonHensyuResultBean2.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean2.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean2.setDetailBikou("外貨備考２");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean2);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean3 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean3.setTekiYou("外貨給付名３");
                siMeisaiCommonHensyuResultBean3.setShrGkMeisai(BizCurrency.valueOf(3333333));
                siMeisaiCommonHensyuResultBean3.setRendouShrGkMeisai(333333300);
                siMeisaiCommonHensyuResultBean3.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean3.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean3.setDetailBikou("外貨備考３");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean3);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean4 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean4.setTekiYou("外貨給付名４");
                siMeisaiCommonHensyuResultBean4.setShrGkMeisai(BizCurrency.valueOf(4444444));
                siMeisaiCommonHensyuResultBean4.setRendouShrGkMeisai(444444400);
                siMeisaiCommonHensyuResultBean4.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean4.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean4.setDetailBikou("外貨備考４");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean4);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean5 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean5.setTekiYou("外貨給付名５");
                siMeisaiCommonHensyuResultBean5.setShrGkMeisai(BizCurrency.valueOf(5555555));
                siMeisaiCommonHensyuResultBean5.setRendouShrGkMeisai(555555500);
                siMeisaiCommonHensyuResultBean5.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean5.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean5.setDetailBikou("外貨備考５");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean5);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean6 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean6.setTekiYou("外貨給付名６");
                siMeisaiCommonHensyuResultBean6.setShrGkMeisai(BizCurrency.valueOf(6666666));
                siMeisaiCommonHensyuResultBean6.setRendouShrGkMeisai(666666600);
                siMeisaiCommonHensyuResultBean6.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean6.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean6.setDetailBikou("外貨備考６");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean6);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean7 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean7.setTekiYou("外貨給付名７");
                siMeisaiCommonHensyuResultBean7.setShrGkMeisai(BizCurrency.valueOf(7777777));
                siMeisaiCommonHensyuResultBean7.setRendouShrGkMeisai(777777700);
                siMeisaiCommonHensyuResultBean7.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean7.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean7.setDetailBikou("外貨備考７");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean7);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean8 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean8.setTekiYou("外貨給付名８");
                siMeisaiCommonHensyuResultBean8.setShrGkMeisai(BizCurrency.valueOf(8888888));
                siMeisaiCommonHensyuResultBean8.setRendouShrGkMeisai(888888800);
                siMeisaiCommonHensyuResultBean8.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean8.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean8.setDetailBikou("外貨備考８");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean8);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean9 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean9.setTekiYou("外貨給付名９");
                siMeisaiCommonHensyuResultBean9.setShrGkMeisai(BizCurrency.valueOf(9999999));
                siMeisaiCommonHensyuResultBean9.setRendouShrGkMeisai(999999900);
                siMeisaiCommonHensyuResultBean9.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean9.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean9.setDetailBikou("外貨備考９");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean9);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean10 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean10.setTekiYou("外貨給付名１０");
                siMeisaiCommonHensyuResultBean10.setShrGkMeisai(BizCurrency.valueOf(1010101));
                siMeisaiCommonHensyuResultBean10.setRendouShrGkMeisai(101010100);
                siMeisaiCommonHensyuResultBean10.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean10.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean10.setDetailBikou("外貨備考１０");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean10);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean11 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean11.setTekiYou("外貨給付名１１");
                siMeisaiCommonHensyuResultBean11.setShrGkMeisai(BizCurrency.valueOf(1101101));
                siMeisaiCommonHensyuResultBean11.setRendouShrGkMeisai(110110100);
                siMeisaiCommonHensyuResultBean11.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean11.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean11.setDetailBikou("外貨備考１１");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean11);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean12 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean12.setTekiYou("外貨給付名１２");
                siMeisaiCommonHensyuResultBean12.setShrGkMeisai(BizCurrency.valueOf(1201201));
                siMeisaiCommonHensyuResultBean12.setRendouShrGkMeisai(120120100);
                siMeisaiCommonHensyuResultBean12.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean12.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean12.setDetailBikou("外貨備考１２");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean12);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuResultBean13 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuResultBean13.setTekiYou("外貨給付名１３");
                siMeisaiCommonHensyuResultBean13.setShrGkMeisai(BizCurrency.valueOf(1301301));
                siMeisaiCommonHensyuResultBean13.setRendouShrGkMeisai(130130100);
                siMeisaiCommonHensyuResultBean13.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.USD);
                siMeisaiCommonHensyuResultBean13.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuResultBean13.setDetailBikou("外貨備考１３");
                sisansyoSiteituukaHensyuKekka.add(siMeisaiCommonHensyuResultBean13);

                List<SiMeisaiCommonHensyuResultBean> sisansyoYenHensyuKekka = new ArrayList<>();
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean.setTekiYou("円貨給付名１");
                siMeisaiCommonHensyuYenResultBean.setShrGkMeisai(BizCurrency.valueOf(111111));
                siMeisaiCommonHensyuYenResultBean.setRendouShrGkMeisai(100001);
                siMeisaiCommonHensyuYenResultBean.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean.setDetailBikou("円貨備考１");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean2 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean2.setTekiYou("円貨給付名２");
                siMeisaiCommonHensyuYenResultBean2.setShrGkMeisai(BizCurrency.valueOf(222222));
                siMeisaiCommonHensyuYenResultBean2.setRendouShrGkMeisai(200002);
                siMeisaiCommonHensyuYenResultBean2.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean2.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean2.setDetailBikou("円貨備考２");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean2);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean3 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean3.setTekiYou("円貨給付名３");
                siMeisaiCommonHensyuYenResultBean3.setShrGkMeisai(BizCurrency.valueOf(333333));
                siMeisaiCommonHensyuYenResultBean3.setRendouShrGkMeisai(30003);
                siMeisaiCommonHensyuYenResultBean3.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean3.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean3.setDetailBikou("円貨備考３");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean3);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean4 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean4.setTekiYou("円貨給付名４");
                siMeisaiCommonHensyuYenResultBean4.setShrGkMeisai(BizCurrency.valueOf(444444));
                siMeisaiCommonHensyuYenResultBean4.setRendouShrGkMeisai(400004);
                siMeisaiCommonHensyuYenResultBean4.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean4.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean4.setDetailBikou("円貨備考４");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean4);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean5 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean5.setTekiYou("円貨給付名５");
                siMeisaiCommonHensyuYenResultBean5.setShrGkMeisai(BizCurrency.valueOf(555555));
                siMeisaiCommonHensyuYenResultBean5.setRendouShrGkMeisai(50005);
                siMeisaiCommonHensyuYenResultBean5.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean5.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean5.setDetailBikou("円貨備考５");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean5);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean6 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean6.setTekiYou("円貨給付名６");
                siMeisaiCommonHensyuYenResultBean6.setShrGkMeisai(BizCurrency.valueOf(666666));
                siMeisaiCommonHensyuYenResultBean6.setRendouShrGkMeisai(600006);
                siMeisaiCommonHensyuYenResultBean6.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean6.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean6.setDetailBikou("円貨備考６");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean6);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean7 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean7.setTekiYou("円貨給付名７");
                siMeisaiCommonHensyuYenResultBean7.setShrGkMeisai(BizCurrency.valueOf(777777));
                siMeisaiCommonHensyuYenResultBean7.setRendouShrGkMeisai(70007);
                siMeisaiCommonHensyuYenResultBean7.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean7.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean7.setDetailBikou("円貨備考７");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean7);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean8 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean8.setTekiYou("円貨給付名８");
                siMeisaiCommonHensyuYenResultBean8.setShrGkMeisai(BizCurrency.valueOf(888888));
                siMeisaiCommonHensyuYenResultBean8.setRendouShrGkMeisai(800008);
                siMeisaiCommonHensyuYenResultBean8.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean8.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean8.setDetailBikou("円貨備考８");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean8);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean9 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean9.setTekiYou("円貨給付名９");
                siMeisaiCommonHensyuYenResultBean9.setShrGkMeisai(BizCurrency.valueOf(999999));
                siMeisaiCommonHensyuYenResultBean9.setRendouShrGkMeisai(90009);
                siMeisaiCommonHensyuYenResultBean9.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean9.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean9.setDetailBikou("円貨備考９");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean9);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean10 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean10.setTekiYou("円貨給付名１０");
                siMeisaiCommonHensyuYenResultBean10.setShrGkMeisai(BizCurrency.valueOf(101010));
                siMeisaiCommonHensyuYenResultBean10.setRendouShrGkMeisai(100010);
                siMeisaiCommonHensyuYenResultBean10.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean10.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean10.setDetailBikou("円貨備考１０");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean10);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean11 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean11.setTekiYou("円貨給付名１１");
                siMeisaiCommonHensyuYenResultBean11.setShrGkMeisai(BizCurrency.valueOf(110110));
                siMeisaiCommonHensyuYenResultBean11.setRendouShrGkMeisai(110011);
                siMeisaiCommonHensyuYenResultBean11.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean11.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean11.setDetailBikou("円貨備考１１");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean11);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean12 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean12.setTekiYou("円貨給付名１２");
                siMeisaiCommonHensyuYenResultBean12.setShrGkMeisai(BizCurrency.valueOf(121212));
                siMeisaiCommonHensyuYenResultBean12.setRendouShrGkMeisai(120012);
                siMeisaiCommonHensyuYenResultBean12.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean12.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean12.setDetailBikou("円貨備考１２");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean12);
                SiMeisaiCommonHensyuResultBean  siMeisaiCommonHensyuYenResultBean13 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiCommonHensyuYenResultBean13.setTekiYou("円貨給付名１３");
                siMeisaiCommonHensyuYenResultBean13.setShrGkMeisai(BizCurrency.valueOf(131313));
                siMeisaiCommonHensyuYenResultBean13.setRendouShrGkMeisai(130013);
                siMeisaiCommonHensyuYenResultBean13.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuYenResultBean13.setRendouShrknGkMeisaiHugou(0);
                siMeisaiCommonHensyuYenResultBean13.setDetailBikou("円貨備考１３");
                sisansyoYenHensyuKekka.add(siMeisaiCommonHensyuYenResultBean13);

                sisansyoHensyuResult = new ArrayList[2];
                sisansyoHensyuResult[0] = sisansyoSiteituukaHensyuKekka;
                sisansyoHensyuResult[1] = sisansyoYenHensyuKekka;

                return sisansyoHensyuResult;
            }
        }
        return super.getSisansyoHensyuResult();
    }

    @Override
    public C_ErrorKbn siMeisaiHensyu(JT_Sk pJtSk, List<JT_SiDetail> pSiDetailLst, BizDate pSibouYmd,
        C_KanryotuutioutKbn pKanryoTuutioutKbn) {

        if (caller == EditSiharaimeisaisyoTest_exec.class) {
            if (!TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.siMeisaiHensyu(pJtSk, pSiDetailLst, pSibouYmd, pKanryoTuutioutKbn);
    }

    @Override
    public List<SiMeisaiCommonHensyuResultBean> getSiMeisaiHensyuResult() {
        if (caller == EditSiharaimeisaisyoTest_exec.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return new ArrayList<>();

            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                List<SiMeisaiCommonHensyuResultBean> siMeisaiHensyuResult = new ArrayList<>();

                SiMeisaiCommonHensyuResultBean  siMeisaiHensyuResultBean1 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiHensyuResultBean1.setTekiYou("死亡保険金");
                siMeisaiHensyuResultBean1.setShrGkMeisai(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));
                siMeisaiHensyuResultBean1.setDetailBikou("死亡日：２０１６年 ７月１０日");
                siMeisaiHensyuResult.add(siMeisaiHensyuResultBean1);

                SiMeisaiCommonHensyuResultBean  siMeisaiHensyuResultBean2 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiHensyuResultBean2.setTekiYou("死亡保険金２");
                siMeisaiHensyuResultBean2.setShrGkMeisai(BizCurrency.valueOf(223, BizCurrencyTypes.YEN));
                siMeisaiHensyuResultBean2.setDetailBikou("死亡日２：２０１６年 ７月１０日");
                siMeisaiHensyuResult.add(siMeisaiHensyuResultBean2);

                SiMeisaiCommonHensyuResultBean  siMeisaiHensyuResultBean3 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiHensyuResultBean3.setTekiYou("死亡保険金３");
                siMeisaiHensyuResultBean3.setShrGkMeisai(BizCurrency.valueOf(323, BizCurrencyTypes.YEN));
                siMeisaiHensyuResultBean3.setDetailBikou("死亡日３：２０１６年 ７月１０日");
                siMeisaiHensyuResult.add(siMeisaiHensyuResultBean3);

                return siMeisaiHensyuResult;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                List<SiMeisaiCommonHensyuResultBean> siMeisaiHensyuResult = new ArrayList<>();

                SiMeisaiCommonHensyuResultBean  siMeisaiHensyuResultBean1 = SWAKInjector.getInstance(SiMeisaiCommonHensyuResultBean.class);
                siMeisaiHensyuResultBean1.setTekiYou("死亡保険金");
                siMeisaiHensyuResultBean1.setShrGkMeisai(BizCurrency.valueOf(123, BizCurrencyTypes.YEN));
                siMeisaiHensyuResultBean1.setDetailBikou("死亡日：２０１６年 ７月１０日");
                siMeisaiHensyuResult.add(siMeisaiHensyuResultBean1);

                return siMeisaiHensyuResult;
            }
        }

        return super.getSiMeisaiHensyuResult();
    }
}
