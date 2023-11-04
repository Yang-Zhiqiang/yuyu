package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;

/**
 * {@link KeisanZennouKoujyogaku}のモッククラスです<br />
 */
public class KeisanZennouKoujyogakuMockForKhansyuu extends KeisanZennouKoujyogaku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void setKjsmyouYenKawaserate(BizNumber pKjsmyouYenKawaserate) {

        super.setKjsmyouYenKawaserate(pKjsmyouYenKawaserate);
    }

    @Override
    public BizCurrency getZennouKoujyogaku(BizCurrency pKjsmyouzennounyuukinkgk,
        String pKjsmyouzennoukikanm,
        BizDate pKjsmyouzennoukaisiymd,
        BizCurrency pHrkp,
        C_Hrkkaisuu pHrkkaisuu,
        BizDateYM pSyoumeistartym,
        int pSyomeiKaisuuY,
        int pSyomeiKaisuuM) {

        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){
                return BizCurrency.valueOf(10000);
            }
            else if (SYORIPTN == TESTPATTERN2){
                return BizCurrency.valueOf(20000);
            }
        }

        if(caller == EditKoujyonaiyouTblTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){
                return BizCurrency.valueOf(18000);
            }
            else if (SYORIPTN == TESTPATTERN2){
                return BizCurrency.valueOf(80000);
            }
        }

        if(caller == KeisanKoujyogakuTest_exce.class) {
            if (SYORIPTN == TESTPATTERN1){
                return BizCurrency.valueOf(18000);
            }
            else if (SYORIPTN == TESTPATTERN2){
                return BizCurrency.valueOf(80000);

            }
            else if (SYORIPTN == TESTPATTERN3){
                return BizCurrency.valueOf(90000);

            }
        }

        return super.getZennouKoujyogaku(pKjsmyouzennounyuukinkgk,
            pKjsmyouzennoukikanm,
            pKjsmyouzennoukaisiymd,
            pHrkp,
            pHrkkaisuu,
            pSyoumeistartym,
            pSyomeiKaisuuY,
            pSyomeiKaisuuM);
    }

    @Override
    public KhZennouKoujyogakuBean doHaibunZennouKoujyogaku(
        BizCurrency pZennouKoujsymgaku,
        C_KoujyosyoumeipKbn pSyuKoujyosyoumeipKbn,
        List<KykSyouhnCommonParam> pKykSyouhnCommonParamLst) {

        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){

                KhZennouKoujyogakuBean khZennouKoujyogakuBean = new KhZennouKoujyogakuBean();

                List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = new ArrayList<KhShgtZennouKoujyogakuBean>();

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();
                khShgtZennouKoujyogakuBean.setSyouhncd("MD11");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(2500));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                khShgtZennouKoujyogakuBeanList.add(khShgtZennouKoujyogakuBean);

                khZennouKoujyogakuBean.setKhShgtZennouKoujyogakuBeanList(khShgtZennouKoujyogakuBeanList);

                List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(3300));
                khWkgtZennouKoujyogakuBean.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.IPPAN);

                khZennouKoujyogakuBean.setKhWkgtZennouKoujyogakuBeanList(khWkgtZennouKoujyogakuBeanList);

                return khZennouKoujyogakuBean;
            }
        }

        if(caller == EditKoujyonaiyouTblTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){

                KhZennouKoujyogakuBean khZennouKoujyogakuBean = new KhZennouKoujyogakuBean();

                List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = new ArrayList<KhShgtZennouKoujyogakuBean>();

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();
                khShgtZennouKoujyogakuBean.setSyouhncd("M120");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(12500));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                khShgtZennouKoujyogakuBeanList.add(khShgtZennouKoujyogakuBean);

                khZennouKoujyogakuBean.setKhShgtZennouKoujyogakuBeanList(khShgtZennouKoujyogakuBeanList);

                List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.IPPAN);

                khZennouKoujyogakuBean.setKhWkgtZennouKoujyogakuBeanList(khWkgtZennouKoujyogakuBeanList);

                return khZennouKoujyogakuBean;
            }
        }

        if (caller == KeisanKoujyogakuTest_exce.class) {

            if (SYORIPTN == TESTPATTERN1) {

                KhZennouKoujyogakuBean khZennouKoujyogakuBean = new KhZennouKoujyogakuBean();

                List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();
                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = new KhWkgtZennouKoujyogakuBean();

                khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean);

                khZennouKoujyogakuBean.setKhWkgtZennouKoujyogakuBeanList(khWkgtZennouKoujyogakuBeanList);
                return khZennouKoujyogakuBean;
            }

            else if (SYORIPTN == TESTPATTERN2){


                KhZennouKoujyogakuBean khZennouKoujyogakuBean = new KhZennouKoujyogakuBean();

                List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = new ArrayList<KhShgtZennouKoujyogakuBean>();

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();
                khShgtZennouKoujyogakuBean.setSyouhncd("M120");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(12500));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.BLNK);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                khShgtZennouKoujyogakuBeanList.add(khShgtZennouKoujyogakuBean);

                khZennouKoujyogakuBean.setKhShgtZennouKoujyogakuBeanList(khShgtZennouKoujyogakuBeanList);

                List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.IPPAN);
                khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean);

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean1 = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean1.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean1.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
                khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean1);


                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean2 = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean2.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean2.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.NENKIN);
                khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean2);

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean3 = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean3.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean3.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.BLNK);
                khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean3);

                khZennouKoujyogakuBean.setKhWkgtZennouKoujyogakuBeanList(khWkgtZennouKoujyogakuBeanList);

                return khZennouKoujyogakuBean;
            }

            else if (SYORIPTN == TESTPATTERN3){


                KhZennouKoujyogakuBean khZennouKoujyogakuBean = new KhZennouKoujyogakuBean();

                List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = new ArrayList<KhShgtZennouKoujyogakuBean>();

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();
                khShgtZennouKoujyogakuBean.setSyouhncd("M120");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(12500));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                khShgtZennouKoujyogakuBeanList.add(khShgtZennouKoujyogakuBean);

                khZennouKoujyogakuBean.setKhShgtZennouKoujyogakuBeanList(khShgtZennouKoujyogakuBeanList);

                List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.KAIGOIRYOU);
                khWkgtZennouKoujyogakuBeanList.add(khWkgtZennouKoujyogakuBean);
                khZennouKoujyogakuBean.setKhWkgtZennouKoujyogakuBeanList(khWkgtZennouKoujyogakuBeanList);

                return khZennouKoujyogakuBean;
            }

            else if (SYORIPTN == TESTPATTERN4){


                KhZennouKoujyogakuBean khZennouKoujyogakuBean = new KhZennouKoujyogakuBean();

                List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = new ArrayList<KhShgtZennouKoujyogakuBean>();

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();
                khShgtZennouKoujyogakuBean.setSyouhncd("M120");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(12500));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                khShgtZennouKoujyogakuBeanList.add(khShgtZennouKoujyogakuBean);

                khZennouKoujyogakuBean.setKhShgtZennouKoujyogakuBeanList(khShgtZennouKoujyogakuBeanList);

                List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = new ArrayList<KhWkgtZennouKoujyogakuBean>();

                KhWkgtZennouKoujyogakuBean khWkgtZennouKoujyogakuBean = new KhWkgtZennouKoujyogakuBean();
                khWkgtZennouKoujyogakuBean.setKhWkgtZennouKoujyogaku(BizCurrency.valueOf(23300));
                khWkgtZennouKoujyogakuBean.setKoujyosyoumeipKbn(C_KoujyosyoumeipKbn.NENKIN);

                return khZennouKoujyogakuBean;
            }


        }

        return super.doHaibunZennouKoujyogaku(pZennouKoujsymgaku,
            pSyuKoujyosyoumeipKbn,
            pKykSyouhnCommonParamLst);
    }

    @Override
    public KhShgtZennouKoujyogakuBean getKhShgtZennouKoujyogakuBean(String pSyouhncd,
        String pSyouhnsdno,
        List<KhShgtZennouKoujyogakuBean> pKhShgtZennouKoujyogakuBeanLst) {

        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();

                khShgtZennouKoujyogakuBean.setSyouhncd("MD11");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(2600));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                return khShgtZennouKoujyogakuBean;
            }
            else if (SYORIPTN == TESTPATTERN2){

                KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean = new KhShgtZennouKoujyogakuBean();

                khShgtZennouKoujyogakuBean.setSyouhncd("MD11");
                khShgtZennouKoujyogakuBean.setSyouhnsdno("1");
                khShgtZennouKoujyogakuBean.setKhShgtZennouKoujyogaku(BizCurrency.valueOf(3800));
                khShgtZennouKoujyogakuBean.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);
                khShgtZennouKoujyogakuBean.setSyutkkbn(C_SyutkKbn.SYU);

                return khShgtZennouKoujyogakuBean;
            }
        }

        return super.getKhShgtZennouKoujyogakuBean(pSyouhncd,
            pSyouhnsdno,
            pKhShgtZennouKoujyogakuBeanLst);
    }

    @Override
    public BizCurrency keisanTukiZennouGngk(BizCurrency pKjsmyouzennounyuukinkgk,
        BizCurrency pHenKjsmyouzennounyuukinkgk,
        BizCurrency pHrkp,
        BizCurrency pHenHrkp,
        BizDate pKjsmyouzennoukaisiymd,
        String pKjsmyouzennoukikanm,
        BizDateYM pSymKaisiYm,
        BizDateYM pSymEndYm,
        BizDateYM PSeisanKaisiYm) {

        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(7800);
            }
        }

        return super.keisanTukiZennouGngk(pKjsmyouzennounyuukinkgk,
            pHenKjsmyouzennounyuukinkgk,
            pHrkp,pHenHrkp, pKjsmyouzennoukaisiymd,
            pKjsmyouzennoukikanm,
            pSymKaisiYm,
            pSymEndYm,
            PSeisanKaisiYm);
    }

    @Override
    public BizCurrency keisanTukiZennouSymt(BizCurrency pKjsmyouzennounyuukinkgk,
        BizCurrency pHrkp,
        BizDate pKjsmyouzennoukaisiymd,
        String pKjsmyouzennoukikanm,
        BizDateYM pSymKaisiYm,
        BizDateYM pSymEndYm,
        BizDateYM PSeisanKaisiYm) {


        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {
            if (SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(8800);
            }
        }

        return super.keisanTukiZennouSymt(pKjsmyouzennounyuukinkgk,
            pHrkp,
            pKjsmyouzennoukaisiymd,
            pKjsmyouzennoukikanm,
            pSymKaisiYm,
            pSymEndYm,
            PSeisanKaisiYm);
    }
}
