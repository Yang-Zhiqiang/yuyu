package yuyu.report.siharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiBikinjikouListBean;
import yuyu.def.siharai.bean.report.SiBikinjikouListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 備金時効リストテスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiBikinJikouTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiBikinjikouListBean siBikinjikouListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki(null);
        siBikinjikouListBean.setIrKessannnd(null);
        siBikinjikouListBean.setIrBknkessankbn(null);
        siBikinjikouListBean.setIrTyouhyousakuseiymd(null);
        siBikinjikouListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui(null);
        siBikinjikouListDataSourceBean1.setIrBkncd(null);
        siBikinjikouListDataSourceBean1.setIrSiharaiumu(null);
        siBikinjikouListDataSourceBean1.setIrBknkktiymd(null);
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd(null);
        siBikinjikouListDataSourceBean1.setIrSisyacd(null);
        siBikinjikouListDataSourceBean1.setIrKigou(null);
        siBikinjikouListDataSourceBean1.setIrSyono(null);
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou(null);
        siBikinjikouListDataSourceBean1.setIrKata(null);
        siBikinjikouListDataSourceBean1.setIrSaisiumu(null);
        siBikinjikouListDataSourceBean1.setIrSinsaumu(null);
        siBikinjikouListDataSourceBean1.setIrSoukiumu(null);
        siBikinjikouListDataSourceBean1.setIrSakugenumu(null);
        siBikinjikouListDataSourceBean1.setIrTenkanumu(null);
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo1(null);
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo2(null);
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo3(null);
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo4(null);
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean2.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean2.setIrKensuu1(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingaku1(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeitani(null);
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("");
        siBikinjikouListBean.setIrKessannnd("");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("");
        siBikinjikouListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("");
        siBikinjikouListDataSourceBean1.setIrBkncd("");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("");
        siBikinjikouListDataSourceBean1.setIrSisyacd("");
        siBikinjikouListDataSourceBean1.setIrKigou("");
        siBikinjikouListDataSourceBean1.setIrSyono("");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("");
        siBikinjikouListDataSourceBean1.setIrKata("");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo1("");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo2("");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo3("");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo4("");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean2.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean2.setIrKensuu1(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingaku1(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeitani("");
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋－W　御中");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean3 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean4 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean5 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean6 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean7 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean8 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean9 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean10 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean11 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean12 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean13 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean14 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean15 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean16 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean17 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean18 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean19 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean20 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean21 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
        siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean1.setIrSisyacd("100");
        siBikinjikouListDataSourceBean1.setIrKigou("20");
        siBikinjikouListDataSourceBean1.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("60");
        siBikinjikouListDataSourceBean1.setIrKata("転型");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo3("平成30年度");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo4("平成30年 1月");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean2.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean2.setIrKensuu1(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingaku1(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeitani("平成30年 1月");
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        siBikinjikouListDataSourceBean3.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean3.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean3.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean3.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean3.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean3.setIrSisyacd("100");
        siBikinjikouListDataSourceBean3.setIrKigou("20");
        siBikinjikouListDataSourceBean3.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(3000));
        siBikinjikouListDataSourceBean3.setIrKihons(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean3.setIrTks(BizCurrency.valueOf(5000));
        siBikinjikouListDataSourceBean3.setIrTkkigou("60");
        siBikinjikouListDataSourceBean3.setIrKata("転型");
        siBikinjikouListDataSourceBean3.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean3.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean3.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean3.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean3.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean3.setIrPageno(3);

        siBikinjikouListDataSourceBean4.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean4.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean4.setIrSyuukeiinfo3("平成30年度");
        siBikinjikouListDataSourceBean4.setIrSyuukeiinfo4("平成30年 1月");
        siBikinjikouListDataSourceBean4.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean4.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean4.setIrKensuu1(BizNumber.valueOf(8000));
        siBikinjikouListDataSourceBean4.setIrKingaku1(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean4.setIrBikinjikoulistgoukeitani("平成30年 1月");
        siBikinjikouListDataSourceBean4.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(18000));
        siBikinjikouListDataSourceBean4.setIrKingakugoukei(BizCurrency.valueOf(19000));
        siBikinjikouListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean4.setIrPageno(4);

        siBikinjikouListDataSourceBean5.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean5.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean5.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean5.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean5.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean5.setIrSisyacd("100");
        siBikinjikouListDataSourceBean5.setIrKigou("20");
        siBikinjikouListDataSourceBean5.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean5.setIrBkngk(BizCurrency.valueOf(9999999999999L));
        siBikinjikouListDataSourceBean5.setIrKihons(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean5.setIrTks(BizCurrency.valueOf(99999999999.99));
        siBikinjikouListDataSourceBean5.setIrTkkigou("60");
        siBikinjikouListDataSourceBean5.setIrKata("転型");
        siBikinjikouListDataSourceBean5.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean5.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean5.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean5.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean5.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean5.setIrPageno(5);

        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo3("平成30年度");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo4("平成30年 1月");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean6.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean6.setIrKensuu1(BizNumber.valueOf(999999));
        siBikinjikouListDataSourceBean6.setIrKingaku1(BizCurrency.valueOf(999999999999999L));
        siBikinjikouListDataSourceBean6.setIrBikinjikoulistgoukeitani("平成30年 1月");
        siBikinjikouListDataSourceBean6.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(9999999));
        siBikinjikouListDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(999999999999999L));
        siBikinjikouListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean6.setIrPageno(6);

        siBikinjikouListDataSourceBean7.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean7.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean7.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean7.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean7.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean7.setIrSisyacd("100");
        siBikinjikouListDataSourceBean7.setIrKigou("20");
        siBikinjikouListDataSourceBean7.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean7.setIrBkngk(BizCurrency.valueOf(999));
        siBikinjikouListDataSourceBean7.setIrKihons(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean7.setIrTks(BizCurrency.valueOf(999));
        siBikinjikouListDataSourceBean7.setIrTkkigou("60");
        siBikinjikouListDataSourceBean7.setIrKata("転型");
        siBikinjikouListDataSourceBean7.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean7.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean7.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean7.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean7.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean7.setIrPageno(7);

        siBikinjikouListDataSourceBean8.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean8.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean8.setIrSyuukeiinfo3("平成30年度");
        siBikinjikouListDataSourceBean8.setIrSyuukeiinfo4("平成30年 1月");
        siBikinjikouListDataSourceBean8.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean8.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean8.setIrKensuu1(BizNumber.valueOf(999));
        siBikinjikouListDataSourceBean8.setIrKingaku1(BizCurrency.valueOf(999));
        siBikinjikouListDataSourceBean8.setIrBikinjikoulistgoukeitani("平成30年 1月");
        siBikinjikouListDataSourceBean8.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(999));
        siBikinjikouListDataSourceBean8.setIrKingakugoukei(BizCurrency.valueOf(999));
        siBikinjikouListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean8.setIrPageno(8);

        siBikinjikouListDataSourceBean9.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean9.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean9.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean9.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean9.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean9.setIrSisyacd("100");
        siBikinjikouListDataSourceBean9.setIrKigou("20");
        siBikinjikouListDataSourceBean9.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean9.setIrBkngk(BizCurrency.valueOf(9999));
        siBikinjikouListDataSourceBean9.setIrKihons(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean9.setIrTks(BizCurrency.valueOf(9999));
        siBikinjikouListDataSourceBean9.setIrTkkigou("60");
        siBikinjikouListDataSourceBean9.setIrKata("転型");
        siBikinjikouListDataSourceBean9.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean9.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean9.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean9.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean9.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean9.setIrPageno(9);

        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo3("平成30年度");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo4("平成30年 1月");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean10.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean10.setIrKensuu1(BizNumber.valueOf(9999));
        siBikinjikouListDataSourceBean10.setIrKingaku1(BizCurrency.valueOf(9999));
        siBikinjikouListDataSourceBean10.setIrBikinjikoulistgoukeitani("平成30年 1月");
        siBikinjikouListDataSourceBean10.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(9999));
        siBikinjikouListDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9999));
        siBikinjikouListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean10.setIrPageno(10);

        siBikinjikouListDataSourceBean11.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean11.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean11.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean11.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean11.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean11.setIrSisyacd("100");
        siBikinjikouListDataSourceBean11.setIrKigou("20");
        siBikinjikouListDataSourceBean11.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean11.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean11.setIrKihons(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean11.setIrTks(BizCurrency.valueOf(9.1));
        siBikinjikouListDataSourceBean11.setIrTkkigou("60");
        siBikinjikouListDataSourceBean11.setIrKata("転型");
        siBikinjikouListDataSourceBean11.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean11.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean11.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean11.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean11.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean11.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean11.setIrPageno(11);

        siBikinjikouListDataSourceBean12.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean12.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean12.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean12.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean12.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean12.setIrSisyacd("100");
        siBikinjikouListDataSourceBean12.setIrKigou("20");
        siBikinjikouListDataSourceBean12.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean12.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean12.setIrKihons(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean12.setIrTks(BizCurrency.valueOf(9.22));
        siBikinjikouListDataSourceBean12.setIrTkkigou("60");
        siBikinjikouListDataSourceBean12.setIrKata("転型");
        siBikinjikouListDataSourceBean12.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean12.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean12.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean12.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean12.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean12.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean12.setIrPageno(11);

        siBikinjikouListDataSourceBean13.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean13.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean13.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean13.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean13.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean13.setIrSisyacd("100");
        siBikinjikouListDataSourceBean13.setIrKigou("20");
        siBikinjikouListDataSourceBean13.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean13.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean13.setIrKihons(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean13.setIrTks(BizCurrency.valueOf(9.333));
        siBikinjikouListDataSourceBean13.setIrTkkigou("60");
        siBikinjikouListDataSourceBean13.setIrKata("転型");
        siBikinjikouListDataSourceBean13.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean13.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean13.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean13.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean13.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean13.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean13.setIrPageno(11);

        siBikinjikouListDataSourceBean14.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean14.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean14.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean14.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean14.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean14.setIrSisyacd("100");
        siBikinjikouListDataSourceBean14.setIrKigou("20");
        siBikinjikouListDataSourceBean14.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean14.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean14.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean14.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean14.setIrTkkigou("60");
        siBikinjikouListDataSourceBean14.setIrKata("転型");
        siBikinjikouListDataSourceBean14.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean14.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean14.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean14.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean14.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean14.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean14.setIrPageno(11);

        siBikinjikouListDataSourceBean15.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean15.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean15.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean15.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean15.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean15.setIrSisyacd("100");
        siBikinjikouListDataSourceBean15.setIrKigou("20");
        siBikinjikouListDataSourceBean15.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean15.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean15.setIrKihons(BizCurrency.valueOf(4000));
        siBikinjikouListDataSourceBean15.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean15.setIrTkkigou("60");
        siBikinjikouListDataSourceBean15.setIrKata("転型");
        siBikinjikouListDataSourceBean15.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean15.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean15.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean15.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean15.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean15.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean15.setIrPageno(11);

        siBikinjikouListDataSourceBean16.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean16.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean16.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean16.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean16.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean16.setIrSisyacd("100");
        siBikinjikouListDataSourceBean16.setIrKigou("20");
        siBikinjikouListDataSourceBean16.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean16.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean16.setIrKihons(BizCurrency.valueOf(99999999999L));
        siBikinjikouListDataSourceBean16.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean16.setIrTkkigou("60");
        siBikinjikouListDataSourceBean16.setIrKata("転型");
        siBikinjikouListDataSourceBean16.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean16.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean16.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean16.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean16.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean16.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean16.setIrPageno(11);

        siBikinjikouListDataSourceBean17.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean17.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean17.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean17.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean17.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean17.setIrSisyacd("100");
        siBikinjikouListDataSourceBean17.setIrKigou("20");
        siBikinjikouListDataSourceBean17.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean17.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean17.setIrKihons(BizCurrency.valueOf(999));
        siBikinjikouListDataSourceBean17.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean17.setIrTkkigou("60");
        siBikinjikouListDataSourceBean17.setIrKata("転型");
        siBikinjikouListDataSourceBean17.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean17.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean17.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean17.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean17.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean17.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean17.setIrPageno(11);

        siBikinjikouListDataSourceBean18.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean18.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean18.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean18.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean18.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean18.setIrSisyacd("100");
        siBikinjikouListDataSourceBean18.setIrKigou("20");
        siBikinjikouListDataSourceBean18.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean18.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean18.setIrKihons(BizCurrency.valueOf(9999));
        siBikinjikouListDataSourceBean18.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean18.setIrTkkigou("60");
        siBikinjikouListDataSourceBean18.setIrKata("転型");
        siBikinjikouListDataSourceBean18.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean18.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean18.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean18.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean18.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean18.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean18.setIrPageno(11);

        siBikinjikouListDataSourceBean19.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean19.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean19.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean19.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean19.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean19.setIrSisyacd("100");
        siBikinjikouListDataSourceBean19.setIrKigou("20");
        siBikinjikouListDataSourceBean19.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean19.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean19.setIrKihons(BizCurrency.valueOf(9.1));
        siBikinjikouListDataSourceBean19.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean19.setIrTkkigou("60");
        siBikinjikouListDataSourceBean19.setIrKata("転型");
        siBikinjikouListDataSourceBean19.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean19.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean19.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean19.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean19.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean19.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean19.setIrPageno(11);

        siBikinjikouListDataSourceBean20.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean20.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean20.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean20.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean20.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean20.setIrSisyacd("100");
        siBikinjikouListDataSourceBean20.setIrKigou("20");
        siBikinjikouListDataSourceBean20.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean20.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean20.setIrKihons(BizCurrency.valueOf(9.22));
        siBikinjikouListDataSourceBean20.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean20.setIrTkkigou("60");
        siBikinjikouListDataSourceBean20.setIrKata("転型");
        siBikinjikouListDataSourceBean20.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean20.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean20.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean20.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean20.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean20.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean20.setIrPageno(11);

        siBikinjikouListDataSourceBean21.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean21.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean21.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean21.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean21.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean21.setIrSisyacd("100");
        siBikinjikouListDataSourceBean21.setIrKigou("20");
        siBikinjikouListDataSourceBean21.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean21.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean21.setIrKihons(BizCurrency.valueOf(9.333));
        siBikinjikouListDataSourceBean21.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean21.setIrTkkigou("60");
        siBikinjikouListDataSourceBean21.setIrKata("転型");
        siBikinjikouListDataSourceBean21.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean21.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean21.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean21.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean21.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean21.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean21.setIrPageno(11);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean3);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean4);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean5);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean6);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean7);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean8);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean9);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean10);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean11);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean12);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean13);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean14);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean15);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean16);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean17);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean18);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean19);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean20);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean21);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListBean.setIrKessannnd("9999ＷＷ");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siBikinjikouListBean.setIrHozonkkn("99ＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean1.setIrBkncd("wwww");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("9999.99.99");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("9999.99.99");
        siBikinjikouListDataSourceBean1.setIrSisyacd("www");
        siBikinjikouListDataSourceBean1.setIrKigou("ww");
        siBikinjikouListDataSourceBean1.setIrSyono("wwwwwwwwwww");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("ww");
        siBikinjikouListDataSourceBean1.setIrKata("ＷＷ");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("Ｗ");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("w");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("w");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean2.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean2.setIrKensuu1(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingaku1(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeitani("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);

        for(int i = 3;i < 10000;i++){

            SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean = new SiBikinjikouListDataSourceBean();

            siBikinjikouListDataSourceBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siBikinjikouListDataSourceBean.setIrBkncd("wwww");
            siBikinjikouListDataSourceBean.setIrSiharaiumu("*");
            siBikinjikouListDataSourceBean.setIrBknkktiymd("9999.99.99");
            siBikinjikouListDataSourceBean.setIrCalckijyunymd("9999.99.99");
            siBikinjikouListDataSourceBean.setIrSisyacd("www");
            siBikinjikouListDataSourceBean.setIrKigou("ww");
            siBikinjikouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            siBikinjikouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean.setIrTkkigou("ww");
            siBikinjikouListDataSourceBean.setIrKata("ＷＷ");
            siBikinjikouListDataSourceBean.setIrSaisiumu("Ｗ");
            siBikinjikouListDataSourceBean.setIrSinsaumu("*");
            siBikinjikouListDataSourceBean.setIrSoukiumu("*");
            siBikinjikouListDataSourceBean.setIrSakugenumu("w");
            siBikinjikouListDataSourceBean.setIrTenkanumu("w");
            siBikinjikouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinjikouListDataSourceBean.setIrPageno(i);

            iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for(int i = 0; i < 36;i++){
            SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();

            siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
            siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
            siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
            siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1.11");
            siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1.12");
            siBikinjikouListDataSourceBean1.setIrSisyacd("100");
            siBikinjikouListDataSourceBean1.setIrKigou("20");
            siBikinjikouListDataSourceBean1.setIrSyono(String.valueOf(11000000001L + i));
            siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrTkkigou("60");
            siBikinjikouListDataSourceBean1.setIrKata("転型");
            siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
            siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
            siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
            siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
            siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
            siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinjikouListDataSourceBean1.setIrPageno(1);

            iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for(int i = 0; i< 37;i++){
            SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();

            siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
            siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
            siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
            siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1.11");
            siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1.12");
            siBikinjikouListDataSourceBean1.setIrSisyacd("100");
            siBikinjikouListDataSourceBean1.setIrKigou("20");
            siBikinjikouListDataSourceBean1.setIrSyono(String.valueOf(11000000001L + i));
            siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrTkkigou("60");
            siBikinjikouListDataSourceBean1.setIrKata("転型");
            siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
            siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
            siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
            siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
            siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
            siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinjikouListDataSourceBean1.setIrPageno(1);

            iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        for(int i = 0; i< 37;i++){
            SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();

            siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
            siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
            siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
            siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1.11");
            siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1.12");
            siBikinjikouListDataSourceBean1.setIrSisyacd("100");
            siBikinjikouListDataSourceBean1.setIrKigou("20");
            siBikinjikouListDataSourceBean1.setIrSyono(String.valueOf(11000000001L + i));
            siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
            siBikinjikouListDataSourceBean1.setIrTkkigou("60");
            siBikinjikouListDataSourceBean1.setIrKata("転型");
            siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
            siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
            siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
            siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
            siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
            siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinjikouListDataSourceBean1.setIrPageno(1);

            iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        }

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
        siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean1.setIrSisyacd("100");
        siBikinjikouListDataSourceBean1.setIrKigou("20");
        siBikinjikouListDataSourceBean1.setIrSyono("11000000038");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("60");
        siBikinjikouListDataSourceBean1.setIrKata("転型");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(2);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
        siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean1.setIrSisyacd("100");
        siBikinjikouListDataSourceBean1.setIrKigou("20");
        siBikinjikouListDataSourceBean1.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("60");
        siBikinjikouListDataSourceBean1.setIrKata("転型");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrHknsyurui("特約年金 ");
        siBikinjikouListDataSourceBean2.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean2.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean2.setIrBknkktiymd("2019. 1.11");
        siBikinjikouListDataSourceBean2.setIrCalckijyunymd("2019. 1.12");
        siBikinjikouListDataSourceBean2.setIrSisyacd("100");
        siBikinjikouListDataSourceBean2.setIrKigou("20");
        siBikinjikouListDataSourceBean2.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean2.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrTkkigou("60");
        siBikinjikouListDataSourceBean2.setIrKata("転型");
        siBikinjikouListDataSourceBean2.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean2.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean2.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean2.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean2.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋");
        siBikinjikouListBean.setIrKessannnd("2016年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2016年 5月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean3 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean4 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean5 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean6 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean7 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean8 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean9 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean10 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean11 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean12 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean13 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("2016. 2.25");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2016. 2. 2");
        siBikinjikouListDataSourceBean1.setIrSisyacd("100");
        siBikinjikouListDataSourceBean1.setIrKigou("20");
        siBikinjikouListDataSourceBean1.setIrSyono("10000000001");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(1000));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("60");
        siBikinjikouListDataSourceBean1.setIrKata("転型");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo2("特約年金 ");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo3("平成27年度");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo4("平成27年 2月");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean2.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean2.setIrKensuu1(BizNumber.valueOf(1));
        siBikinjikouListDataSourceBean2.setIrKingaku1(BizCurrency.valueOf(1000));
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeitani("平成27年 2月");
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(1));
        siBikinjikouListDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(1000));
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        siBikinjikouListDataSourceBean3.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean3.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean3.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean3.setIrBknkktiymd("2016. 3.30");
        siBikinjikouListDataSourceBean3.setIrCalckijyunymd("2016. 2. 2");
        siBikinjikouListDataSourceBean3.setIrSisyacd("100");
        siBikinjikouListDataSourceBean3.setIrKigou("20");
        siBikinjikouListDataSourceBean3.setIrSyono("10000000002");
        siBikinjikouListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(2000));
        siBikinjikouListDataSourceBean3.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean3.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean3.setIrTkkigou("60");
        siBikinjikouListDataSourceBean3.setIrKata("転型");
        siBikinjikouListDataSourceBean3.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean3.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean3.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean3.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean3.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean3.setIrPageno(3);

        siBikinjikouListDataSourceBean4.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean4.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean4.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean4.setIrBknkktiymd("2016. 3.31");
        siBikinjikouListDataSourceBean4.setIrCalckijyunymd("2016. 2. 2");
        siBikinjikouListDataSourceBean4.setIrSisyacd("100");
        siBikinjikouListDataSourceBean4.setIrKigou("20");
        siBikinjikouListDataSourceBean4.setIrSyono("10000000003");
        siBikinjikouListDataSourceBean4.setIrBkngk(BizCurrency.valueOf(3000));
        siBikinjikouListDataSourceBean4.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean4.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean4.setIrTkkigou("60");
        siBikinjikouListDataSourceBean4.setIrKata("転型");
        siBikinjikouListDataSourceBean4.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean4.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean4.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean4.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean4.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean4.setIrPageno(3);

        siBikinjikouListDataSourceBean5.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean5.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean5.setIrSyuukeiinfo3("平成27年度");
        siBikinjikouListDataSourceBean5.setIrSyuukeiinfo4("平成27年 3月");
        siBikinjikouListDataSourceBean5.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean5.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean5.setIrKensuu1(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean5.setIrKingaku1(BizCurrency.valueOf(5000));
        siBikinjikouListDataSourceBean5.setIrBikinjikoulistgoukeitani("平成27年 3月");
        siBikinjikouListDataSourceBean5.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean5.setIrKingakugoukei(BizCurrency.valueOf(5000));
        siBikinjikouListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean5.setIrPageno(4);

        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo3("平成27年度");
        siBikinjikouListDataSourceBean6.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean6.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean6.setIrKensuu1(BizNumber.valueOf(3));
        siBikinjikouListDataSourceBean6.setIrKingaku1(BizCurrency.valueOf(6000));
        siBikinjikouListDataSourceBean6.setIrBikinjikoulistgoukeitani("平成27年度");
        siBikinjikouListDataSourceBean6.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(3));
        siBikinjikouListDataSourceBean6.setIrKingakugoukei(BizCurrency.valueOf(6000));
        siBikinjikouListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean6.setIrPageno(5);

        siBikinjikouListDataSourceBean7.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean7.setIrSyuukeiinfo2("特約年金 ");
        siBikinjikouListDataSourceBean7.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean7.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean7.setIrKensuu1(BizNumber.valueOf(3));
        siBikinjikouListDataSourceBean7.setIrKingaku1(BizCurrency.valueOf(6000));
        siBikinjikouListDataSourceBean7.setIrBikinjikoulistgoukeitani("特約年金");
        siBikinjikouListDataSourceBean7.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(3));
        siBikinjikouListDataSourceBean7.setIrKingakugoukei(BizCurrency.valueOf(6000));
        siBikinjikouListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean7.setIrPageno(6);

        siBikinjikouListDataSourceBean8.setIrHknsyurui("一時払終身");
        siBikinjikouListDataSourceBean8.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean8.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean8.setIrBknkktiymd("2016. 3.30");
        siBikinjikouListDataSourceBean8.setIrCalckijyunymd("2016. 2. 2");
        siBikinjikouListDataSourceBean8.setIrSisyacd("100");
        siBikinjikouListDataSourceBean8.setIrKigou("20");
        siBikinjikouListDataSourceBean8.setIrSyono("10000000004");
        siBikinjikouListDataSourceBean8.setIrBkngk(BizCurrency.valueOf(4000));
        siBikinjikouListDataSourceBean8.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean8.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean8.setIrTkkigou("60");
        siBikinjikouListDataSourceBean8.setIrKata("転型");
        siBikinjikouListDataSourceBean8.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean8.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean8.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean8.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean8.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean8.setIrPageno(7);

        siBikinjikouListDataSourceBean9.setIrHknsyurui("一時払終身");
        siBikinjikouListDataSourceBean9.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean9.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean9.setIrBknkktiymd("2016. 3.31");
        siBikinjikouListDataSourceBean9.setIrCalckijyunymd("2016. 2. 2");
        siBikinjikouListDataSourceBean9.setIrSisyacd("100");
        siBikinjikouListDataSourceBean9.setIrKigou("20");
        siBikinjikouListDataSourceBean9.setIrSyono("10000000005");
        siBikinjikouListDataSourceBean9.setIrBkngk(BizCurrency.valueOf(5000));
        siBikinjikouListDataSourceBean9.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean9.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean9.setIrTkkigou("60");
        siBikinjikouListDataSourceBean9.setIrKata("転型");
        siBikinjikouListDataSourceBean9.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean9.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean9.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean9.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean9.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean9.setIrPageno(7);

        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo2("一時払終身");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo3("平成27年度");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo4("平成27年 3月");
        siBikinjikouListDataSourceBean10.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean10.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean10.setIrKensuu1(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean10.setIrKingaku1(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean10.setIrBikinjikoulistgoukeitani("平成27年 3月");
        siBikinjikouListDataSourceBean10.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean10.setIrKingakugoukei(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean10.setIrPageno(8);

        siBikinjikouListDataSourceBean11.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean11.setIrSyuukeiinfo2("一時払終身");
        siBikinjikouListDataSourceBean11.setIrSyuukeiinfo3("平成27年度");
        siBikinjikouListDataSourceBean11.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean11.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean11.setIrKensuu1(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean11.setIrKingaku1(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean11.setIrBikinjikoulistgoukeitani("平成27年度");
        siBikinjikouListDataSourceBean11.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean11.setIrKingakugoukei(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean11.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean11.setIrPageno(9);

        siBikinjikouListDataSourceBean12.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean12.setIrSyuukeiinfo2("一時払終身");
        siBikinjikouListDataSourceBean12.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean12.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean12.setIrKensuu1(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean12.setIrKingaku1(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean12.setIrBikinjikoulistgoukeitani("一時払終身");
        siBikinjikouListDataSourceBean12.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(2));
        siBikinjikouListDataSourceBean12.setIrKingakugoukei(BizCurrency.valueOf(9000));
        siBikinjikouListDataSourceBean12.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean12.setIrPageno(10);

        siBikinjikouListDataSourceBean13.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean13.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean13.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean13.setIrKensuu1(BizNumber.valueOf(5));
        siBikinjikouListDataSourceBean13.setIrKingaku1(BizCurrency.valueOf(15000));
        siBikinjikouListDataSourceBean13.setIrBikinjikoulistgoukeitani("PC12");
        siBikinjikouListDataSourceBean13.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(5));
        siBikinjikouListDataSourceBean13.setIrKingakugoukei(BizCurrency.valueOf(15000));
        siBikinjikouListDataSourceBean13.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean13.setIrPageno(11);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean3);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean4);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean5);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean6);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean7);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean8);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean9);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean10);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean11);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean12);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean13);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "khcommon", "KhKaiyakuBikinjikoulistTest", C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

        siBikinjikouListBean.setIrAtesaki("万事屋－W　御中");
        siBikinjikouListBean.setIrKessannnd("2019年度");
        siBikinjikouListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        siBikinjikouListBean.setIrTyouhyousakuseiymd("2019年 1月10日");
        siBikinjikouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean1 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean2 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean3 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean4 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean5 = new SiBikinjikouListDataSourceBean();
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean6 = new SiBikinjikouListDataSourceBean();

        siBikinjikouListDataSourceBean1.setIrHknsyurui("特約年金 ");
        siBikinjikouListDataSourceBean1.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean1.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean1.setIrBknkktiymd("2019. 1. 6");
        siBikinjikouListDataSourceBean1.setIrCalckijyunymd("2019. 1. 6");
        siBikinjikouListDataSourceBean1.setIrSisyacd("100");
        siBikinjikouListDataSourceBean1.setIrKigou("20");
        siBikinjikouListDataSourceBean1.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        siBikinjikouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean1.setIrTkkigou("60");
        siBikinjikouListDataSourceBean1.setIrKata("転型");
        siBikinjikouListDataSourceBean1.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean1.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean1.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean1.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean1.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean1.setIrSyoruiukeymd("2019. 1. 6");
        siBikinjikouListDataSourceBean1.setIrYenukthyoji("*");
        siBikinjikouListDataSourceBean1.setIrKnsnkijyunymd("2019. 1. 6");
        siBikinjikouListDataSourceBean1.setIrYenkansantkykwsrate(BizNumber.valueOf(89.00));
        siBikinjikouListDataSourceBean1.setIrSiteituukahokenkngk("4,000.00 豪ドル");
        siBikinjikouListDataSourceBean1.setIrYenkasaiteihsygk("9,000");
        siBikinjikouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean1.setIrPageno(1);

        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo1("PC12");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo2("特約年金");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo3("平成30年度");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo4("平成30年 5月");
        siBikinjikouListDataSourceBean2.setIrSyuukeiinfo5("合計");
        siBikinjikouListDataSourceBean2.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBean2.setIrKensuu1(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingaku1(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeitani("平成30年 5月");
        siBikinjikouListDataSourceBean2.setIrBikinjikoulistgoukeicount(BizNumber.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrKingakugoukei(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean2.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBean2.setIrYenukthyoji("");
        siBikinjikouListDataSourceBean2.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBean2.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBean2.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBean2.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBean2.setIrPageno(2);

        siBikinjikouListDataSourceBean3.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean3.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean3.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean3.setIrBknkktiymd("2019. 1. 8");
        siBikinjikouListDataSourceBean3.setIrCalckijyunymd("2019. 1. 8");
        siBikinjikouListDataSourceBean3.setIrSisyacd("100");
        siBikinjikouListDataSourceBean3.setIrKigou("20");
        siBikinjikouListDataSourceBean3.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean3.setIrKihons(BizCurrency.valueOf(9999));
        siBikinjikouListDataSourceBean3.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean3.setIrTkkigou("60");
        siBikinjikouListDataSourceBean3.setIrKata("転型");
        siBikinjikouListDataSourceBean3.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean3.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean3.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean3.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean3.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean3.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBean3.setIrYenukthyoji(null);
        siBikinjikouListDataSourceBean3.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBean3.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBean3.setIrSiteituukahokenkngk(null);
        siBikinjikouListDataSourceBean3.setIrYenkasaiteihsygk(null);
        siBikinjikouListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean3.setIrPageno(3);

        siBikinjikouListDataSourceBean4.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean4.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean4.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean4.setIrBknkktiymd("2019. 1. 9");
        siBikinjikouListDataSourceBean4.setIrCalckijyunymd("2019. 1. 9");
        siBikinjikouListDataSourceBean4.setIrSisyacd("100");
        siBikinjikouListDataSourceBean4.setIrKigou("20");
        siBikinjikouListDataSourceBean4.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean4.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean4.setIrKihons(BizCurrency.valueOf(9.1));
        siBikinjikouListDataSourceBean4.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean4.setIrTkkigou("60");
        siBikinjikouListDataSourceBean4.setIrKata("転型");
        siBikinjikouListDataSourceBean4.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean4.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean4.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean4.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean4.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean4.setIrSyoruiukeymd("");
        siBikinjikouListDataSourceBean4.setIrYenukthyoji("");
        siBikinjikouListDataSourceBean4.setIrKnsnkijyunymd("");
        siBikinjikouListDataSourceBean4.setIrYenkansantkykwsrate(BizNumber.valueOf(89.99));
        siBikinjikouListDataSourceBean4.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBean4.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean4.setIrPageno(3);

        siBikinjikouListDataSourceBean5.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean5.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean5.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean5.setIrBknkktiymd("2019. 1.10");
        siBikinjikouListDataSourceBean5.setIrCalckijyunymd("2019. 1.11");
        siBikinjikouListDataSourceBean5.setIrSisyacd("100");
        siBikinjikouListDataSourceBean5.setIrKigou("20");
        siBikinjikouListDataSourceBean5.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean5.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean5.setIrKihons(BizCurrency.valueOf(9.22));
        siBikinjikouListDataSourceBean5.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean5.setIrTkkigou("60");
        siBikinjikouListDataSourceBean5.setIrKata("転型");
        siBikinjikouListDataSourceBean5.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean5.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean5.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean5.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean5.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean5.setIrSyoruiukeymd("2019. 1.12");
        siBikinjikouListDataSourceBean5.setIrYenukthyoji("*");
        siBikinjikouListDataSourceBean5.setIrKnsnkijyunymd("2019. 1.13");
        siBikinjikouListDataSourceBean5.setIrYenkansantkykwsrate(BizNumber.valueOf(109.00));
        siBikinjikouListDataSourceBean5.setIrSiteituukahokenkngk("4,000.00 豪ドル");
        siBikinjikouListDataSourceBean5.setIrYenkasaiteihsygk("9,000");
        siBikinjikouListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean5.setIrPageno(3);

        siBikinjikouListDataSourceBean6.setIrHknsyurui("特約年金");
        siBikinjikouListDataSourceBean6.setIrBkncd("PC12");
        siBikinjikouListDataSourceBean6.setIrSiharaiumu("*");
        siBikinjikouListDataSourceBean6.setIrBknkktiymd("9999.99.99");
        siBikinjikouListDataSourceBean6.setIrCalckijyunymd("9999.99.99");
        siBikinjikouListDataSourceBean6.setIrSisyacd("100");
        siBikinjikouListDataSourceBean6.setIrKigou("20");
        siBikinjikouListDataSourceBean6.setIrSyono("11000000001");
        siBikinjikouListDataSourceBean6.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean6.setIrKihons(BizCurrency.valueOf(9.333));
        siBikinjikouListDataSourceBean6.setIrTks(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBean6.setIrTkkigou("60");
        siBikinjikouListDataSourceBean6.setIrKata("転型");
        siBikinjikouListDataSourceBean6.setIrSaisiumu("有");
        siBikinjikouListDataSourceBean6.setIrSinsaumu("*");
        siBikinjikouListDataSourceBean6.setIrSoukiumu("*");
        siBikinjikouListDataSourceBean6.setIrSakugenumu("1");
        siBikinjikouListDataSourceBean6.setIrTenkanumu("1");
        siBikinjikouListDataSourceBean6.setIrSyoruiukeymd("9999.99.99");
        siBikinjikouListDataSourceBean6.setIrYenukthyoji("*");
        siBikinjikouListDataSourceBean6.setIrKnsnkijyunymd("9999.99.99");
        siBikinjikouListDataSourceBean6.setIrYenkansantkykwsrate(BizNumber.valueOf(999.99));
        siBikinjikouListDataSourceBean6.setIrSiteituukahokenkngk("99,999,999,999.99 豪ドル");
        siBikinjikouListDataSourceBean6.setIrYenkasaiteihsygk("9,999,999,999,999");
        siBikinjikouListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinjikouListDataSourceBean6.setIrPageno(3);

        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean1);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean2);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean3);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean4);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean5);
        iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean6);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siBikinjikouListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
