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
import yuyu.def.siharai.bean.report.SiBikinsagyouListBean;
import yuyu.def.siharai.bean.report.SiBikinsagyouListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 備金作業リストテスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiBikinSagyouTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiBikinsagyouListBean siBikinsagyouListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki(null);
        siBikinsagyouListBean.setIrKessannnd(null);
        siBikinsagyouListBean.setIrBknkessankbn(null);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd(null);
        siBikinsagyouListBean.setIrHozonkkn(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = null;

        siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

        siBikinsagyouListDataSourceBean.setIrBkncd(null);
        siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku(null);
        siBikinsagyouListDataSourceBean.setIrBknkktiymd(null);
        siBikinsagyouListDataSourceBean.setIrCalckijyunymd(null);
        siBikinsagyouListDataSourceBean.setIrSisyacd(null);
        siBikinsagyouListDataSourceBean.setIrKigou(null);
        siBikinsagyouListDataSourceBean.setIrSyono(null);
        siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrTkkigou(null);
        siBikinsagyouListDataSourceBean.setIrKatazenkaku(null);
        siBikinsagyouListDataSourceBean.setIrSaisi(null);
        siBikinsagyouListDataSourceBean.setIrDoujibkn(null);
        siBikinsagyouListDataSourceBean.setIrSokyuuumu(null);
        siBikinsagyouListDataSourceBean.setIrSoukiumu(null);
        siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg(null);
        siBikinsagyouListDataSourceBean.setIrSakugenumu(null);
        siBikinsagyouListDataSourceBean.setIrNkumu(null);
        siBikinsagyouListDataSourceBean.setIrTenkanumu(null);
        siBikinsagyouListDataSourceBean.setIrKeimaeumu(null);
        siBikinsagyouListDataSourceBean.setIrSaihoumu(null);
        siBikinsagyouListDataSourceBean.setIrSzouumu(null);
        siBikinsagyouListDataSourceBean.setIrGoukeitani(null);
        siBikinsagyouListDataSourceBean.setIrGoukeikbn1(null);
        siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siBikinsagyouListDataSourceBean);


        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("");
        siBikinsagyouListBean.setIrKessannnd("");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.BLNK);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("");
        siBikinsagyouListBean.setIrHozonkkn("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = null;

        siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

        siBikinsagyouListDataSourceBean.setIrBkncd("");
        siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku("");
        siBikinsagyouListDataSourceBean.setIrBknkktiymd("");
        siBikinsagyouListDataSourceBean.setIrCalckijyunymd("");
        siBikinsagyouListDataSourceBean.setIrSisyacd("");
        siBikinsagyouListDataSourceBean.setIrKigou("");
        siBikinsagyouListDataSourceBean.setIrSyono("");
        siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrTkkigou("");
        siBikinsagyouListDataSourceBean.setIrKatazenkaku("");
        siBikinsagyouListDataSourceBean.setIrSaisi("");
        siBikinsagyouListDataSourceBean.setIrDoujibkn("");
        siBikinsagyouListDataSourceBean.setIrSokyuuumu("");
        siBikinsagyouListDataSourceBean.setIrSoukiumu("");
        siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg("");
        siBikinsagyouListDataSourceBean.setIrSakugenumu("");
        siBikinsagyouListDataSourceBean.setIrNkumu("");
        siBikinsagyouListDataSourceBean.setIrTenkanumu("");
        siBikinsagyouListDataSourceBean.setIrKeimaeumu("");
        siBikinsagyouListDataSourceBean.setIrSaihoumu("");
        siBikinsagyouListDataSourceBean.setIrSzouumu("");
        siBikinsagyouListDataSourceBean.setIrGoukeitani("");
        siBikinsagyouListDataSourceBean.setIrGoukeikbn1("");
        siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean.setIrPageno(1);

        dataSouceList.add(siBikinsagyouListDataSourceBean);


        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋－Ｗ　御中");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean1 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean2 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean3 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean4 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean5 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean6 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean7 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean8 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean9 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean10 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean11 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean12 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean13 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean14 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean15 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean16 = new SiBikinsagyouListDataSourceBean();


        siBikinsagyouListDataSourceBean1.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean1.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean1.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean1.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean1.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean1.setIrKigou("30");
        siBikinsagyouListDataSourceBean1.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean1.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean1.setIrSaisi("有");
        siBikinsagyouListDataSourceBean1.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean1.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean1.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean1.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean1.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean1.setIrNkumu("1");
        siBikinsagyouListDataSourceBean1.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean1.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean1.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean1.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean1.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean1.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean1.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean1.setIrPageno(1);

        siBikinsagyouListDataSourceBean2.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean2.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean2.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean2.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean2.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean2.setIrKigou("30");
        siBikinsagyouListDataSourceBean2.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean2.setIrBkngk(BizCurrency.valueOf(4000));
        siBikinsagyouListDataSourceBean2.setIrKihons(BizCurrency.valueOf(5000, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean2.setIrTks(BizCurrency.valueOf(6000));
        siBikinsagyouListDataSourceBean2.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean2.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean2.setIrSaisi("有");
        siBikinsagyouListDataSourceBean2.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean2.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean2.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean2.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean2.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean2.setIrNkumu("1");
        siBikinsagyouListDataSourceBean2.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean2.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean2.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean2.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean2.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean2.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean2.setIrGoukeikensuu1(BizNumber.valueOf(8000));
        siBikinsagyouListDataSourceBean2.setIrGoukeibikingk1(BizCurrency.valueOf(9000));
        siBikinsagyouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean2.setIrPageno(2);

        siBikinsagyouListDataSourceBean3.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean3.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean3.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean3.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean3.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean3.setIrKigou("30");
        siBikinsagyouListDataSourceBean3.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(99999999999L));
        siBikinsagyouListDataSourceBean3.setIrKihons(BizCurrency.valueOf(99999999999.99, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean3.setIrTks(BizCurrency.valueOf(99999999999.99));
        siBikinsagyouListDataSourceBean3.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean3.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean3.setIrSaisi("有");
        siBikinsagyouListDataSourceBean3.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean3.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean3.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean3.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean3.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean3.setIrNkumu("1");
        siBikinsagyouListDataSourceBean3.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean3.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean3.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean3.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean3.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean3.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean3.setIrGoukeikensuu1(BizNumber.valueOf(9999999));
        siBikinsagyouListDataSourceBean3.setIrGoukeibikingk1(BizCurrency.valueOf(999999999999999L));
        siBikinsagyouListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean3.setIrPageno(3);

        siBikinsagyouListDataSourceBean4.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean4.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean4.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean4.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean4.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean4.setIrKigou("30");
        siBikinsagyouListDataSourceBean4.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean4.setIrBkngk(BizCurrency.valueOf(999));
        siBikinsagyouListDataSourceBean4.setIrKihons(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean4.setIrTks(BizCurrency.valueOf(999));
        siBikinsagyouListDataSourceBean4.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean4.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean4.setIrSaisi("有");
        siBikinsagyouListDataSourceBean4.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean4.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean4.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean4.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean4.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean4.setIrNkumu("1");
        siBikinsagyouListDataSourceBean4.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean4.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean4.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean4.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean4.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean4.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean4.setIrGoukeikensuu1(BizNumber.valueOf(999));
        siBikinsagyouListDataSourceBean4.setIrGoukeibikingk1(BizCurrency.valueOf(999));
        siBikinsagyouListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean4.setIrPageno(4);

        siBikinsagyouListDataSourceBean5.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean5.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean5.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean5.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean5.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean5.setIrKigou("30");
        siBikinsagyouListDataSourceBean5.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean5.setIrBkngk(BizCurrency.valueOf(9999));
        siBikinsagyouListDataSourceBean5.setIrKihons(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean5.setIrTks(BizCurrency.valueOf(9999));
        siBikinsagyouListDataSourceBean5.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean5.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean5.setIrSaisi("有");
        siBikinsagyouListDataSourceBean5.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean5.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean5.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean5.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean5.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean5.setIrNkumu("1");
        siBikinsagyouListDataSourceBean5.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean5.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean5.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean5.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean5.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean5.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean5.setIrGoukeikensuu1(BizNumber.valueOf(9999));
        siBikinsagyouListDataSourceBean5.setIrGoukeibikingk1(BizCurrency.valueOf(9999));
        siBikinsagyouListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean5.setIrPageno(5);

        siBikinsagyouListDataSourceBean6.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean6.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean6.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean6.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean6.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean6.setIrKigou("30");
        siBikinsagyouListDataSourceBean6.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean6.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean6.setIrKihons(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean6.setIrTks(BizCurrency.valueOf(9.1));
        siBikinsagyouListDataSourceBean6.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean6.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean6.setIrSaisi("有");
        siBikinsagyouListDataSourceBean6.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean6.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean6.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean6.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean6.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean6.setIrNkumu("1");
        siBikinsagyouListDataSourceBean6.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean6.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean6.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean6.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean6.setIrPageno(6);

        siBikinsagyouListDataSourceBean7.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean7.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean7.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean7.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean7.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean7.setIrKigou("30");
        siBikinsagyouListDataSourceBean7.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean7.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean7.setIrKihons(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean7.setIrTks(BizCurrency.valueOf(9.22));
        siBikinsagyouListDataSourceBean7.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean7.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean7.setIrSaisi("有");
        siBikinsagyouListDataSourceBean7.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean7.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean7.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean7.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean7.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean7.setIrNkumu("1");
        siBikinsagyouListDataSourceBean7.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean7.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean7.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean7.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean7.setIrPageno(6);

        siBikinsagyouListDataSourceBean8.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean8.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean8.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean8.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean8.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean8.setIrKigou("30");
        siBikinsagyouListDataSourceBean8.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean8.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean8.setIrKihons(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        siBikinsagyouListDataSourceBean8.setIrTks(BizCurrency.valueOf(9.333));
        siBikinsagyouListDataSourceBean8.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean8.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean8.setIrSaisi("有");
        siBikinsagyouListDataSourceBean8.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean8.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean8.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean8.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean8.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean8.setIrNkumu("1");
        siBikinsagyouListDataSourceBean8.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean8.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean8.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean8.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean8.setIrPageno(6);

        siBikinsagyouListDataSourceBean9.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean9.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean9.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean9.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean9.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean9.setIrKigou("30");
        siBikinsagyouListDataSourceBean9.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean9.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean9.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean9.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean9.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean9.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean9.setIrSaisi("有");
        siBikinsagyouListDataSourceBean9.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean9.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean9.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean9.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean9.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean9.setIrNkumu("1");
        siBikinsagyouListDataSourceBean9.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean9.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean9.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean9.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean9.setIrPageno(6);

        siBikinsagyouListDataSourceBean10.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean10.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean10.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean10.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean10.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean10.setIrKigou("30");
        siBikinsagyouListDataSourceBean10.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean10.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean10.setIrKihons(BizCurrency.valueOf(5000));
        siBikinsagyouListDataSourceBean10.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean10.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean10.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean10.setIrSaisi("有");
        siBikinsagyouListDataSourceBean10.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean10.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean10.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean10.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean10.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean10.setIrNkumu("1");
        siBikinsagyouListDataSourceBean10.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean10.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean10.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean10.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean10.setIrPageno(6);

        siBikinsagyouListDataSourceBean11.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean11.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean11.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean11.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean11.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean11.setIrKigou("30");
        siBikinsagyouListDataSourceBean11.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean11.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean11.setIrKihons(BizCurrency.valueOf(99999999999L));
        siBikinsagyouListDataSourceBean11.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean11.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean11.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean11.setIrSaisi("有");
        siBikinsagyouListDataSourceBean11.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean11.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean11.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean11.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean11.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean11.setIrNkumu("1");
        siBikinsagyouListDataSourceBean11.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean11.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean11.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean11.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean11.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean11.setIrPageno(6);

        siBikinsagyouListDataSourceBean12.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean12.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean12.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean12.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean12.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean12.setIrKigou("30");
        siBikinsagyouListDataSourceBean12.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean12.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean12.setIrKihons(BizCurrency.valueOf(999));
        siBikinsagyouListDataSourceBean12.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean12.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean12.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean12.setIrSaisi("有");
        siBikinsagyouListDataSourceBean12.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean12.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean12.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean12.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean12.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean12.setIrNkumu("1");
        siBikinsagyouListDataSourceBean12.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean12.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean12.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean12.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean12.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean12.setIrPageno(6);

        siBikinsagyouListDataSourceBean13.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean13.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean13.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean13.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean13.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean13.setIrKigou("30");
        siBikinsagyouListDataSourceBean13.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean13.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean13.setIrKihons(BizCurrency.valueOf(9999));
        siBikinsagyouListDataSourceBean13.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean13.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean13.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean13.setIrSaisi("有");
        siBikinsagyouListDataSourceBean13.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean13.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean13.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean13.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean13.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean13.setIrNkumu("1");
        siBikinsagyouListDataSourceBean13.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean13.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean13.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean13.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean13.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean13.setIrPageno(6);

        siBikinsagyouListDataSourceBean14.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean14.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean14.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean14.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean14.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean14.setIrKigou("30");
        siBikinsagyouListDataSourceBean14.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean14.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean14.setIrKihons(BizCurrency.valueOf(9.1));
        siBikinsagyouListDataSourceBean14.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean14.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean14.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean14.setIrSaisi("有");
        siBikinsagyouListDataSourceBean14.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean14.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean14.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean14.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean14.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean14.setIrNkumu("1");
        siBikinsagyouListDataSourceBean14.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean14.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean14.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean14.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean14.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean14.setIrPageno(6);

        siBikinsagyouListDataSourceBean15.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean15.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean15.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean15.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean15.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean15.setIrKigou("30");
        siBikinsagyouListDataSourceBean15.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean15.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean15.setIrKihons(BizCurrency.valueOf(9.22));
        siBikinsagyouListDataSourceBean15.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean15.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean15.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean15.setIrSaisi("有");
        siBikinsagyouListDataSourceBean15.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean15.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean15.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean15.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean15.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean15.setIrNkumu("1");
        siBikinsagyouListDataSourceBean15.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean15.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean15.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean15.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean15.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean15.setIrPageno(6);

        siBikinsagyouListDataSourceBean16.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean16.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean16.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean16.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean16.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean16.setIrKigou("30");
        siBikinsagyouListDataSourceBean16.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean16.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean16.setIrKihons(BizCurrency.valueOf(9.333));
        siBikinsagyouListDataSourceBean16.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean16.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean16.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean16.setIrSaisi("有");
        siBikinsagyouListDataSourceBean16.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean16.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean16.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean16.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean16.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean16.setIrNkumu("1");
        siBikinsagyouListDataSourceBean16.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean16.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean16.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean16.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean16.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean16.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean16.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean16.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean16.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean16.setIrPageno(6);

        dataSouceList.add(siBikinsagyouListDataSourceBean1);
        dataSouceList.add(siBikinsagyouListDataSourceBean2);
        dataSouceList.add(siBikinsagyouListDataSourceBean3);
        dataSouceList.add(siBikinsagyouListDataSourceBean4);
        dataSouceList.add(siBikinsagyouListDataSourceBean5);
        dataSouceList.add(siBikinsagyouListDataSourceBean6);
        dataSouceList.add(siBikinsagyouListDataSourceBean7);
        dataSouceList.add(siBikinsagyouListDataSourceBean8);
        dataSouceList.add(siBikinsagyouListDataSourceBean9);
        dataSouceList.add(siBikinsagyouListDataSourceBean10);
        dataSouceList.add(siBikinsagyouListDataSourceBean11);
        dataSouceList.add(siBikinsagyouListDataSourceBean12);
        dataSouceList.add(siBikinsagyouListDataSourceBean13);
        dataSouceList.add(siBikinsagyouListDataSourceBean14);
        dataSouceList.add(siBikinsagyouListDataSourceBean15);
        dataSouceList.add(siBikinsagyouListDataSourceBean16);


        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siBikinsagyouListBean.setIrKessannnd("9999ＷＷ");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.SHNK);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("9999年99月99日");
        siBikinsagyouListBean.setIrHozonkkn("99ＷＷ");



        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <10000; i++) {

            SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

            siBikinsagyouListDataSourceBean.setIrBkncd("wwww");
            siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku("ＷＷＷ");
            siBikinsagyouListDataSourceBean.setIrBknkktiymd("9999年99月99日");
            siBikinsagyouListDataSourceBean.setIrCalckijyunymd("9999年99月99日");
            siBikinsagyouListDataSourceBean.setIrSisyacd("www");
            siBikinsagyouListDataSourceBean.setIrKigou("ww");
            siBikinsagyouListDataSourceBean.setIrSyono("wwwwwwwwwww");
            siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTkkigou("ww");
            siBikinsagyouListDataSourceBean.setIrKatazenkaku("ＷＷ");
            siBikinsagyouListDataSourceBean.setIrSaisi("Ｗ");
            siBikinsagyouListDataSourceBean.setIrDoujibkn("wwww wwww wwww wwww");
            siBikinsagyouListDataSourceBean.setIrSokyuuumu("w");
            siBikinsagyouListDataSourceBean.setIrSoukiumu("*");
            siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg("wwwwwwwwww");
            siBikinsagyouListDataSourceBean.setIrSakugenumu("w");
            siBikinsagyouListDataSourceBean.setIrNkumu("w");
            siBikinsagyouListDataSourceBean.setIrTenkanumu("w");
            siBikinsagyouListDataSourceBean.setIrKeimaeumu("w");
            siBikinsagyouListDataSourceBean.setIrSaihoumu("w");
            siBikinsagyouListDataSourceBean.setIrSzouumu("w");
            siBikinsagyouListDataSourceBean.setIrGoukeitani("ＷＷＷＷＷＷＷＷ");
            siBikinsagyouListDataSourceBean.setIrGoukeikbn1("主契約");
            siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinsagyouListDataSourceBean.setIrPageno(i);

            dataSouceList.add(siBikinsagyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i <18; i++) {

            SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

            siBikinsagyouListDataSourceBean.setIrBkncd("1000");
            siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku("即時");
            siBikinsagyouListDataSourceBean.setIrBknkktiymd("2019年 1月12日");
            siBikinsagyouListDataSourceBean.setIrCalckijyunymd("2019年 2月12日");
            siBikinsagyouListDataSourceBean.setIrSisyacd("200");
            siBikinsagyouListDataSourceBean.setIrKigou("30");
            siBikinsagyouListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTkkigou("70");
            siBikinsagyouListDataSourceBean.setIrKatazenkaku("転型");
            siBikinsagyouListDataSourceBean.setIrSaisi("有");
            siBikinsagyouListDataSourceBean.setIrDoujibkn("1234 5678 9012 3456");
            siBikinsagyouListDataSourceBean.setIrSokyuuumu("1");
            siBikinsagyouListDataSourceBean.setIrSoukiumu("*");
            siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg("error1001");
            siBikinsagyouListDataSourceBean.setIrSakugenumu("1");
            siBikinsagyouListDataSourceBean.setIrNkumu("1");
            siBikinsagyouListDataSourceBean.setIrTenkanumu("1");
            siBikinsagyouListDataSourceBean.setIrKeimaeumu("1");
            siBikinsagyouListDataSourceBean.setIrSaihoumu("1");
            siBikinsagyouListDataSourceBean.setIrSzouumu("1");
            siBikinsagyouListDataSourceBean.setIrGoukeitani("平成３０年　１月");
            siBikinsagyouListDataSourceBean.setIrGoukeikbn1("主契約");
            siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinsagyouListDataSourceBean.setIrPageno(1);

            dataSouceList.add(siBikinsagyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i <19; i++) {

            SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

            siBikinsagyouListDataSourceBean.setIrBkncd("1000");
            siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku("即時");
            siBikinsagyouListDataSourceBean.setIrBknkktiymd("2019年 1月12日");
            siBikinsagyouListDataSourceBean.setIrCalckijyunymd("2019年 2月12日");
            siBikinsagyouListDataSourceBean.setIrSisyacd("200");
            siBikinsagyouListDataSourceBean.setIrKigou("30");
            siBikinsagyouListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTkkigou("70");
            siBikinsagyouListDataSourceBean.setIrKatazenkaku("転型");
            siBikinsagyouListDataSourceBean.setIrSaisi("有");
            siBikinsagyouListDataSourceBean.setIrDoujibkn("1234 5678 9012 3456");
            siBikinsagyouListDataSourceBean.setIrSokyuuumu("1");
            siBikinsagyouListDataSourceBean.setIrSoukiumu("*");
            siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg("error1001");
            siBikinsagyouListDataSourceBean.setIrSakugenumu("1");
            siBikinsagyouListDataSourceBean.setIrNkumu("1");
            siBikinsagyouListDataSourceBean.setIrTenkanumu("1");
            siBikinsagyouListDataSourceBean.setIrKeimaeumu("1");
            siBikinsagyouListDataSourceBean.setIrSaihoumu("1");
            siBikinsagyouListDataSourceBean.setIrSzouumu("1");
            siBikinsagyouListDataSourceBean.setIrGoukeitani("平成３０年　１月");
            siBikinsagyouListDataSourceBean.setIrGoukeikbn1("主契約");
            siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinsagyouListDataSourceBean.setIrPageno(1);

            dataSouceList.add(siBikinsagyouListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i <19; i++) {

            SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

            siBikinsagyouListDataSourceBean.setIrBkncd("1000");
            siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku("即時");
            siBikinsagyouListDataSourceBean.setIrBknkktiymd("2019年 1月12日");
            siBikinsagyouListDataSourceBean.setIrCalckijyunymd("2019年 2月12日");
            siBikinsagyouListDataSourceBean.setIrSisyacd("200");
            siBikinsagyouListDataSourceBean.setIrKigou("30");
            siBikinsagyouListDataSourceBean.setIrSyono(String.valueOf(10000000001L + i));
            siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrTkkigou("70");
            siBikinsagyouListDataSourceBean.setIrKatazenkaku("転型");
            siBikinsagyouListDataSourceBean.setIrSaisi("有");
            siBikinsagyouListDataSourceBean.setIrDoujibkn("1234 5678 9012 3456");
            siBikinsagyouListDataSourceBean.setIrSokyuuumu("1");
            siBikinsagyouListDataSourceBean.setIrSoukiumu("*");
            siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg("error1001");
            siBikinsagyouListDataSourceBean.setIrSakugenumu("1");
            siBikinsagyouListDataSourceBean.setIrNkumu("1");
            siBikinsagyouListDataSourceBean.setIrTenkanumu("1");
            siBikinsagyouListDataSourceBean.setIrKeimaeumu("1");
            siBikinsagyouListDataSourceBean.setIrSaihoumu("1");
            siBikinsagyouListDataSourceBean.setIrSzouumu("1");
            siBikinsagyouListDataSourceBean.setIrGoukeitani("平成３０年　１月");
            siBikinsagyouListDataSourceBean.setIrGoukeikbn1("主契約");
            siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
            siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
            siBikinsagyouListDataSourceBean.setIrPageno(1);

            dataSouceList.add(siBikinsagyouListDataSourceBean);
        }

        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean = new SiBikinsagyouListDataSourceBean();

        siBikinsagyouListDataSourceBean.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean.setIrKigou("30");
        siBikinsagyouListDataSourceBean.setIrSyono("10000000020");
        siBikinsagyouListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean.setIrSaisi("有");
        siBikinsagyouListDataSourceBean.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean.setIrNkumu("1");
        siBikinsagyouListDataSourceBean.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean.setIrPageno(2);

        dataSouceList.add(siBikinsagyouListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.HNK);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean1 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean2 = new SiBikinsagyouListDataSourceBean();

        siBikinsagyouListDataSourceBean1.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean1.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean1.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean1.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean1.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean1.setIrKigou("30");
        siBikinsagyouListDataSourceBean1.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean1.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean1.setIrSaisi("有");
        siBikinsagyouListDataSourceBean1.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean1.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean1.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean1.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean1.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean1.setIrNkumu("1");
        siBikinsagyouListDataSourceBean1.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean1.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean1.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean1.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean1.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean1.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean1.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean1.setIrPageno(1);

        siBikinsagyouListDataSourceBean2.setIrBkncd("1000");
        siBikinsagyouListDataSourceBean2.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean2.setIrBknkktiymd("2019年 1月12日");
        siBikinsagyouListDataSourceBean2.setIrCalckijyunymd("2019年 2月12日");
        siBikinsagyouListDataSourceBean2.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean2.setIrKigou("30");
        siBikinsagyouListDataSourceBean2.setIrSyono("11000000001");
        siBikinsagyouListDataSourceBean2.setIrBkngk(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean2.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean2.setIrSaisi("有");
        siBikinsagyouListDataSourceBean2.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean2.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean2.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean2.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean2.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean2.setIrNkumu("1");
        siBikinsagyouListDataSourceBean2.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean2.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean2.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean2.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean2.setIrGoukeitani("平成３０年　１月");
        siBikinsagyouListDataSourceBean2.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean2.setIrGoukeikensuu1(BizNumber.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrGoukeibikingk1(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean2.setIrPageno(2);

        dataSouceList.add(siBikinsagyouListDataSourceBean1);
        dataSouceList.add(siBikinsagyouListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean1 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean2 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean3 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean4 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean5 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean6 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean7 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean8 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean9 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean10 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean11 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean12 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean13 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean14 = new SiBikinsagyouListDataSourceBean();
        SiBikinsagyouListDataSourceBean siBikinsagyouListDataSourceBean15 = new SiBikinsagyouListDataSourceBean();

        siBikinsagyouListDataSourceBean1.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean1.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean1.setIrBknkktiymd("2017年 2月 5日");
        siBikinsagyouListDataSourceBean1.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean1.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean1.setIrKigou("30");
        siBikinsagyouListDataSourceBean1.setIrSyono("10000000001");
        siBikinsagyouListDataSourceBean1.setIrBkngk(BizCurrency.valueOf(1000));
        siBikinsagyouListDataSourceBean1.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean1.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean1.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean1.setIrSaisi("有");
        siBikinsagyouListDataSourceBean1.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean1.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean1.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean1.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean1.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean1.setIrNkumu("1");
        siBikinsagyouListDataSourceBean1.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean1.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean1.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean1.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean1.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean1.setIrPageno(1);

        siBikinsagyouListDataSourceBean2.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean2.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean2.setIrBknkktiymd("2017年 2月10日");
        siBikinsagyouListDataSourceBean2.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean2.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean2.setIrKigou("30");
        siBikinsagyouListDataSourceBean2.setIrSyono("10000000002");
        siBikinsagyouListDataSourceBean2.setIrBkngk(BizCurrency.valueOf(2000));
        siBikinsagyouListDataSourceBean2.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean2.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean2.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean2.setIrSaisi("有");
        siBikinsagyouListDataSourceBean2.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean2.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean2.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean2.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean2.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean2.setIrNkumu("1");
        siBikinsagyouListDataSourceBean2.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean2.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean2.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean2.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean2.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean2.setIrPageno(1);

        siBikinsagyouListDataSourceBean3.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean3.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean3.setIrBknkktiymd("2017年 2月15日");
        siBikinsagyouListDataSourceBean3.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean3.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean3.setIrKigou("30");
        siBikinsagyouListDataSourceBean3.setIrSyono("10000000003");
        siBikinsagyouListDataSourceBean3.setIrBkngk(BizCurrency.valueOf(3000));
        siBikinsagyouListDataSourceBean3.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean3.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean3.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean3.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean3.setIrSaisi("有");
        siBikinsagyouListDataSourceBean3.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean3.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean3.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean3.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean3.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean3.setIrNkumu("1");
        siBikinsagyouListDataSourceBean3.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean3.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean3.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean3.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean3.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean3.setIrPageno(1);

        siBikinsagyouListDataSourceBean4.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean4.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean4.setIrBknkktiymd("2017年 2月20日");
        siBikinsagyouListDataSourceBean4.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean4.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean4.setIrKigou("30");
        siBikinsagyouListDataSourceBean4.setIrSyono("10000000004");
        siBikinsagyouListDataSourceBean4.setIrBkngk(BizCurrency.valueOf(4000));
        siBikinsagyouListDataSourceBean4.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean4.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean4.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean4.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean4.setIrSaisi("有");
        siBikinsagyouListDataSourceBean4.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean4.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean4.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean4.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean4.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean4.setIrNkumu("1");
        siBikinsagyouListDataSourceBean4.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean4.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean4.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean4.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean4.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean4.setIrPageno(1);

        siBikinsagyouListDataSourceBean5.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean5.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean5.setIrBknkktiymd("2017年 2月25日");
        siBikinsagyouListDataSourceBean5.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean5.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean5.setIrKigou("30");
        siBikinsagyouListDataSourceBean5.setIrSyono("10000000005");
        siBikinsagyouListDataSourceBean5.setIrBkngk(BizCurrency.valueOf(5000));
        siBikinsagyouListDataSourceBean5.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean5.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean5.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean5.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean5.setIrSaisi("有");
        siBikinsagyouListDataSourceBean5.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean5.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean5.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean5.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean5.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean5.setIrNkumu("1");
        siBikinsagyouListDataSourceBean5.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean5.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean5.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean5.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean5.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean5.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean5.setIrGoukeitani("平成２７年　２月");
        siBikinsagyouListDataSourceBean5.setIrGoukeikensuu1(BizNumber.valueOf(5));
        siBikinsagyouListDataSourceBean5.setIrGoukeibikingk1(BizCurrency.valueOf(15000));
        siBikinsagyouListDataSourceBean5.setIrPageno(1);

        siBikinsagyouListDataSourceBean6.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean6.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean6.setIrBknkktiymd("2017年 3月30日");
        siBikinsagyouListDataSourceBean6.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean6.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean6.setIrKigou("30");
        siBikinsagyouListDataSourceBean6.setIrSyono("10000000006");
        siBikinsagyouListDataSourceBean6.setIrBkngk(BizCurrency.valueOf(6000));
        siBikinsagyouListDataSourceBean6.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean6.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean6.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean6.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean6.setIrSaisi("有");
        siBikinsagyouListDataSourceBean6.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean6.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean6.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean6.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean6.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean6.setIrNkumu("1");
        siBikinsagyouListDataSourceBean6.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean6.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean6.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean6.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean6.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean6.setIrPageno(2);

        siBikinsagyouListDataSourceBean7.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean7.setIrHknsyuruinmryaku("即時");
        siBikinsagyouListDataSourceBean7.setIrBknkktiymd("2017年 3月31日");
        siBikinsagyouListDataSourceBean7.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean7.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean7.setIrKigou("30");
        siBikinsagyouListDataSourceBean7.setIrSyono("10000000007");
        siBikinsagyouListDataSourceBean7.setIrBkngk(BizCurrency.valueOf(7000));
        siBikinsagyouListDataSourceBean7.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean7.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean7.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean7.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean7.setIrSaisi("有");
        siBikinsagyouListDataSourceBean7.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean7.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean7.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean7.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean7.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean7.setIrNkumu("1");
        siBikinsagyouListDataSourceBean7.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean7.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean7.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean7.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean7.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean7.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean7.setIrGoukeitani("平成２７年　３月");
        siBikinsagyouListDataSourceBean7.setIrGoukeikensuu1(BizNumber.valueOf(2));
        siBikinsagyouListDataSourceBean7.setIrGoukeibikingk1(BizCurrency.valueOf(13000));
        siBikinsagyouListDataSourceBean7.setIrPageno(2);

        siBikinsagyouListDataSourceBean8.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean8.setIrGoukeitani("平成27年度");
        siBikinsagyouListDataSourceBean8.setIrGoukeikensuu1(BizNumber.valueOf(7));
        siBikinsagyouListDataSourceBean8.setIrGoukeibikingk1(BizCurrency.valueOf(28000));
        siBikinsagyouListDataSourceBean8.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinsagyouListDataSourceBean8.setIrPageno(3);

        siBikinsagyouListDataSourceBean9.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean9.setIrGoukeitani("即時保障型");
        siBikinsagyouListDataSourceBean9.setIrGoukeikensuu1(BizNumber.valueOf(7));
        siBikinsagyouListDataSourceBean9.setIrGoukeibikingk1(BizCurrency.valueOf(28000));
        siBikinsagyouListDataSourceBean9.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinsagyouListDataSourceBean9.setIrPageno(4);

        siBikinsagyouListDataSourceBean10.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean10.setIrHknsyuruinmryaku("受取");
        siBikinsagyouListDataSourceBean10.setIrBknkktiymd("2017年 3月20日");
        siBikinsagyouListDataSourceBean10.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean10.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean10.setIrKigou("30");
        siBikinsagyouListDataSourceBean10.setIrSyono("10000000008");
        siBikinsagyouListDataSourceBean10.setIrBkngk(BizCurrency.valueOf(8000));
        siBikinsagyouListDataSourceBean10.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean10.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean10.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean10.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean10.setIrSaisi("有");
        siBikinsagyouListDataSourceBean10.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean10.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean10.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean10.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean10.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean10.setIrNkumu("1");
        siBikinsagyouListDataSourceBean10.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean10.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean10.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean10.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean10.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean10.setIrPageno(5);

        siBikinsagyouListDataSourceBean11.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean11.setIrHknsyuruinmryaku("受取");
        siBikinsagyouListDataSourceBean11.setIrBknkktiymd("2017年 3月30日");
        siBikinsagyouListDataSourceBean11.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean11.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean11.setIrKigou("30");
        siBikinsagyouListDataSourceBean11.setIrSyono("10000000009");
        siBikinsagyouListDataSourceBean11.setIrBkngk(BizCurrency.valueOf(9000));
        siBikinsagyouListDataSourceBean11.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean11.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean11.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean11.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean11.setIrSaisi("有");
        siBikinsagyouListDataSourceBean11.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean11.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean11.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean11.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean11.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean11.setIrNkumu("1");
        siBikinsagyouListDataSourceBean11.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean11.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean11.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean11.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean11.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean11.setIrPageno(5);

        siBikinsagyouListDataSourceBean12.setIrBkncd("PC12");
        siBikinsagyouListDataSourceBean12.setIrHknsyuruinmryaku("受取");
        siBikinsagyouListDataSourceBean12.setIrBknkktiymd("2017年 3月31日");
        siBikinsagyouListDataSourceBean12.setIrCalckijyunymd("2017年 4月10日");
        siBikinsagyouListDataSourceBean12.setIrSisyacd("200");
        siBikinsagyouListDataSourceBean12.setIrKigou("30");
        siBikinsagyouListDataSourceBean12.setIrSyono("10000000010");
        siBikinsagyouListDataSourceBean12.setIrBkngk(BizCurrency.valueOf(10000));
        siBikinsagyouListDataSourceBean12.setIrKihons(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean12.setIrTks(BizCurrency.valueOf(0));
        siBikinsagyouListDataSourceBean12.setIrTkkigou("70");
        siBikinsagyouListDataSourceBean12.setIrKatazenkaku("転型");
        siBikinsagyouListDataSourceBean12.setIrSaisi("有");
        siBikinsagyouListDataSourceBean12.setIrDoujibkn("1234 5678 9012 3456");
        siBikinsagyouListDataSourceBean12.setIrSokyuuumu("1");
        siBikinsagyouListDataSourceBean12.setIrSoukiumu("*");
        siBikinsagyouListDataSourceBean12.setIrBknsgulisterrormsg("error1001");
        siBikinsagyouListDataSourceBean12.setIrSakugenumu("1");
        siBikinsagyouListDataSourceBean12.setIrNkumu("1");
        siBikinsagyouListDataSourceBean12.setIrTenkanumu("1");
        siBikinsagyouListDataSourceBean12.setIrKeimaeumu("1");
        siBikinsagyouListDataSourceBean12.setIrSaihoumu("1");
        siBikinsagyouListDataSourceBean12.setIrSzouumu("1");
        siBikinsagyouListDataSourceBean12.setIrGoukeiumukbn(C_UmuKbn.NONE);
        siBikinsagyouListDataSourceBean12.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean12.setIrGoukeitani("平成２７年　３月");
        siBikinsagyouListDataSourceBean12.setIrGoukeikensuu1(BizNumber.valueOf(3));
        siBikinsagyouListDataSourceBean12.setIrGoukeibikingk1(BizCurrency.valueOf(27000));
        siBikinsagyouListDataSourceBean12.setIrPageno(5);

        siBikinsagyouListDataSourceBean13.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean13.setIrGoukeitani("平成27年度");
        siBikinsagyouListDataSourceBean13.setIrGoukeikensuu1(BizNumber.valueOf(3));
        siBikinsagyouListDataSourceBean13.setIrGoukeibikingk1(BizCurrency.valueOf(27000));
        siBikinsagyouListDataSourceBean13.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinsagyouListDataSourceBean13.setIrPageno(6);

        siBikinsagyouListDataSourceBean14.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean14.setIrGoukeitani("毎年受取型");
        siBikinsagyouListDataSourceBean14.setIrGoukeikensuu1(BizNumber.valueOf(3));
        siBikinsagyouListDataSourceBean14.setIrGoukeibikingk1(BizCurrency.valueOf(27000));
        siBikinsagyouListDataSourceBean14.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinsagyouListDataSourceBean14.setIrPageno(7);

        siBikinsagyouListDataSourceBean15.setIrGoukeikbn1("主契約");
        siBikinsagyouListDataSourceBean15.setIrGoukeitani("PC12");
        siBikinsagyouListDataSourceBean15.setIrGoukeikensuu1(BizNumber.valueOf(10));
        siBikinsagyouListDataSourceBean15.setIrGoukeibikingk1(BizCurrency.valueOf(55000));
        siBikinsagyouListDataSourceBean15.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinsagyouListDataSourceBean15.setIrPageno(8);

        dataSouceList.add(siBikinsagyouListDataSourceBean1);
        dataSouceList.add(siBikinsagyouListDataSourceBean2);
        dataSouceList.add(siBikinsagyouListDataSourceBean3);
        dataSouceList.add(siBikinsagyouListDataSourceBean4);
        dataSouceList.add(siBikinsagyouListDataSourceBean5);
        dataSouceList.add(siBikinsagyouListDataSourceBean6);
        dataSouceList.add(siBikinsagyouListDataSourceBean7);
        dataSouceList.add(siBikinsagyouListDataSourceBean8);
        dataSouceList.add(siBikinsagyouListDataSourceBean9);
        dataSouceList.add(siBikinsagyouListDataSourceBean10);
        dataSouceList.add(siBikinsagyouListDataSourceBean11);
        dataSouceList.add(siBikinsagyouListDataSourceBean12);
        dataSouceList.add(siBikinsagyouListDataSourceBean13);
        dataSouceList.add(siBikinsagyouListDataSourceBean14);
        dataSouceList.add(siBikinsagyouListDataSourceBean15);

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "khKaiyakuBikinsagyoulistTest", C_SyoruiCdKbn.HK_BIKINSAGYOULIST  );

        siBikinsagyouListBean.setIrAtesaki("万事屋");
        siBikinsagyouListBean.setIrKessannnd("2019年度");
        siBikinsagyouListBean.setIrBknkessankbn(C_Bknkessankbn.KESSAN);
        siBikinsagyouListBean.setIrTyouhyousakuseiymd("2019年 4月10日");
        siBikinsagyouListBean.setIrHozonkkn("10年");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, siBikinsagyouListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}