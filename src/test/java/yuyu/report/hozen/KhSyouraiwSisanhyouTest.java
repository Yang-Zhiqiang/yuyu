package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.bean.report.KhSyouraiwSisanhyouBean;
import yuyu.def.hozen.bean.report.KhSyouraiwSisanhyouDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 将来解約返戻金試算表 帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhSyouraiwSisanhyouTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private   KhSyouraiwSisanhyouBean khSyouraiwSisanhyouBean  ;

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd(null);
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(0,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn(null);
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(null);
        khSyouraiwSisanhyouBean.setIrSisuurendourate(null);
        khSyouraiwSisanhyouBean.setIrTmttknitenymd(null);
        khSyouraiwSisanhyouBean.setIrKijyunkingaku(null);
        khSyouraiwSisanhyouBean.setIrNkgnsgk(null);
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(0);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(1234,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.ZERO);
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.ZERO);
        khSyouraiwSisanhyouBean.setIrTmttknitenymd("");
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("");
        khSyouraiwSisanhyouBean.setIrNkgnsgk("");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(1);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(99999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("2026年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999999999.99,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("12");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrTmttknitenymd("2019年 5月15日");
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("1,002 米ドル");
        khSyouraiwSisanhyouBean.setIrNkgnsgk("1,113 米ドル");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(4000));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(4001));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(4002));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(4003));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(4004));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(4005));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(4006));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(4007));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(4008));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(4009));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(4010));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(4011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin11(BizCurrency.valueOf(9999999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate0(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate1(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate2(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate3(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate4(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate5(BizNumber.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate6(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate7(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate8(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate9(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate10(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate11(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate0(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate1(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate2(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate3(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate4(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate5(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate6(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate7(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate8(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate9(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate10(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate11(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate0(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate1(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate2(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate3(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate4(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate5(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate6(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate7(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate8(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate9(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate10(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate11(BizNumber.valueOf(9.22));

            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin0(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin1(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin2(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin3(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin4(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin5(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin6(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin7(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin8(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin9(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin10(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin11(BizCurrency.valueOf(9.33));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate0(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate1(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate2(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate3(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate4(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate5(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate6(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate7(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate8(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate9(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate10(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate11(BizNumber.valueOf(9.333));

            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin0(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin1(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin2(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin3(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin4(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin5(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin6(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin7(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin8(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin9(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin10(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin11(BizCurrency.valueOf(9.44));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.MALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("9999年99月99日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("999");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(999));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(999));
        khSyouraiwSisanhyouBean.setIrTmttknitenymd("9999年99月99日");
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("999,999,999 ＷＷＷ");
        khSyouraiwSisanhyouBean.setIrNkgnsgk("999,999,999 ＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 9; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(99);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(99);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.HJN);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9999,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 10; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(i);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(0);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.HUMEI);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(9.6));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9.1,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 11; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(i);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(0);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(9.28));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9.22,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 2; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(i);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(0);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2018/03/02 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(9.433,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9.333));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrHrkkkn(99);
        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(106);
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("1,002 米ドル");
        khSyouraiwSisanhyouBean.setIrNkgnsgk("1,113 米ドル");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        for (int i = 0; i < 5; i++) {
            KhSyouraiwSisanhyouDataSourceBean khSyouraiwSisanhyouDataSourceBean = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000000.01));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1000000.02));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1000000.03));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1000000.04));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1000000.05));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1000000.06));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1000000.07));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1000000.08));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1000000.09));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1000000.10));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1000000.11));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1000000.12));

            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000001));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2000002));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2000003));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2000004));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2000005));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2000006));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2000007));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2000008));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2000009));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2000010));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2000011));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2000012));

            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.01));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(300.02));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(300.03));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(300.04));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(300.05));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(300.06));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(300.07));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(300.08));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(300.09));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(300.10));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(300.11));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(300.12));

            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(4000000.01));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(4000000.02));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(4000000.03));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(4000000.04));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(4000000.05));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(4000000.06));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(4000000.07));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(4000000.08));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(4000000.09));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(4000000.10));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(4000000.11));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(4000000.12));

            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk0(BizCurrency.valueOf(5000000.01));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk1(BizCurrency.valueOf(5000000.02));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk2(BizCurrency.valueOf(5000000.03));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk3(BizCurrency.valueOf(5000000.04));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk4(BizCurrency.valueOf(5000000.05));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk5(BizCurrency.valueOf(5000000.06));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk6(BizCurrency.valueOf(5000000.07));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk7(BizCurrency.valueOf(5000000.08));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk8(BizCurrency.valueOf(5000000.09));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk9(BizCurrency.valueOf(5000000.10));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk10(BizCurrency.valueOf(5000000.11));
            khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk11(BizCurrency.valueOf(5000000.12));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd(null);
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouBean.setIrHknkkn(null);
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(null);
        khSyouraiwSisanhyouBean.setIrSisuurendourate(null);
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(104);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(1234));
        khSyouraiwSisanhyouBean.setIrHknkkn("");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.ZERO);
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.ZERO);
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(104);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年 2月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(104);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(200)
    @Transactional
    public void testCreateReport20(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.MALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999));
        khSyouraiwSisanhyouBean.setIrHknkkn("999ＷＷ");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(99));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(99));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(104);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(99);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(99);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(210)
    @Transactional
    public void testCreateReport21(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(104);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(4000));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(4001));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(4002));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(4003));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(4004));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(4005));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(4006));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(4007));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(4008));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(4009));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(4010));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(4011));


        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin11(BizCurrency.valueOf(9999999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate0(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate1(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate2(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate3(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate4(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate5(BizNumber.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate6(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate7(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate8(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate9(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate10(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate11(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate0(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate1(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate2(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate3(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate4(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate5(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate6(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate7(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate8(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate9(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate10(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate11(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate0(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate1(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate2(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate3(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate4(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate5(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate6(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate7(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate8(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate9(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate10(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate11(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin0(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin1(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin2(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin3(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin4(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin5(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin6(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin7(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin8(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin9(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin10(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin11(BizCurrency.valueOf(9.33));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate0(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate1(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate2(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate3(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate4(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate5(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate6(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate7(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate8(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate9(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate10(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate11(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin0(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin1(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin2(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin3(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin4(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin5(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin6(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin7(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin8(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin9(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin10(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin11(BizCurrency.valueOf(9.44));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testCreateReport22(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(9.28));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9.333,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(105);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 2; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(i);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(0);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testCreateReport23() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(107);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));

        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(4000));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(4001));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(4002));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(4003));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(4004));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(4005));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(4006));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(4007));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(4008));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(4009));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(4010));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(4011));


        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        for (int i = 0; i < 2; i++) {

            if (i == 0) {
                KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1 = new KhSyouraiwSisanhyouDataSourceBean();
                khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
                khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
                khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate0(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate1(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate2(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate3(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate4(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate5(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate6(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate7(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate8(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate9(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate10(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate11(BizNumber.valueOf(999.99));

                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin0(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin1(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin2(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin3(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin4(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin5(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin6(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin7(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin8(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin9(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin10(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin11(BizCurrency.valueOf(9999999.99));

                dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);
            }
            else {
                KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2 = new KhSyouraiwSisanhyouDataSourceBean();
                khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(3);
                khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(1);
                khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(26);
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate0(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate1(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate2(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate3(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate4(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate5(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate6(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate7(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate8(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate9(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate10(BizNumber.valueOf(999.99));
                khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate11(BizNumber.valueOf(999.99));

                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin0(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin1(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin2(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin3(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin4(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin5(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin6(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin7(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin8(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin9(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin10(BizCurrency.valueOf(0));
                khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin11(BizCurrency.valueOf(0));

                dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);
            }

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate0(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate1(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate2(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate3(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate4(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate5(BizNumber.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate6(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate7(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate8(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate9(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate10(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate11(BizNumber.valueOf(999));

            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate0(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate1(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate2(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate3(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate4(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate5(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate6(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate7(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate8(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate9(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate10(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate11(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate0(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate1(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate2(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate3(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate4(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate5(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate6(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate7(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate8(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate9(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate10(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate11(BizNumber.valueOf(9.22));

            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin0(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin1(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin2(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin3(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin4(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin5(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin6(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin7(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin8(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin9(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin10(BizCurrency.valueOf(9.3));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin11(BizCurrency.valueOf(9.3));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate0(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate1(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate2(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate3(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate4(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate5(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate6(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate7(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate8(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate9(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate10(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate11(BizNumber.valueOf(9.333));

            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin0(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin1(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin2(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin3(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin4(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin5(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin6(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin7(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin8(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin9(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin10(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin11(BizCurrency.valueOf(9.44));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin0(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin1(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin2(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin3(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin4(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin5(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin6(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin7(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin8(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin9(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin10(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin11(BizCurrency.valueOf(9.454));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin0(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin1(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin2(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin3(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin4(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin5(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin6(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin7(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin8(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin9(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin10(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin11(BizCurrency.valueOf(9.454));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin0(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin1(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin2(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin3(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin4(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin5(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin6(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin7(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin8(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin9(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin10(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin11(BizCurrency.valueOf(9.454));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate11(BizNumber.valueOf(999.99));

            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin0(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin1(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin2(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin3(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin4(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin5(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin6(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin7(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin8(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin9(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin10(BizCurrency.valueOf(9.454));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin11(BizCurrency.valueOf(9.454));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testCreateReport24() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年 2月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(107);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testCreateReport25() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm(null);
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime(null);
        khSyouraiwSisanhyouBean.setIrWarningmsg(null);
        khSyouraiwSisanhyouBean.setIrSyono(null);
        khSyouraiwSisanhyouBean.setIrSisanymd(null);
        khSyouraiwSisanhyouBean.setIrKykymd(null);
        khSyouraiwSisanhyouBean.setIrKanyuujinen(null);
        khSyouraiwSisanhyouBean.setIrSeibetu(null);
        khSyouraiwSisanhyouBean.setIrHknsyurui(null);
        khSyouraiwSisanhyouBean.setIrItijibrp(null);
        khSyouraiwSisanhyouBean.setIrHknkkn(null);
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrHrkkkn(null);
        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(null);
        khSyouraiwSisanhyouBean.setIrKijyunkingaku(null);
        khSyouraiwSisanhyouBean.setIrNkgnsgk(null);

        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(106);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean khSyouraiwSisanhyouDataSourceBean = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk11(BizCurrency.valueOf(0));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testCreateReport26() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("");
        khSyouraiwSisanhyouBean.setIrWarningmsg("");
        khSyouraiwSisanhyouBean.setIrSyono("");
        khSyouraiwSisanhyouBean.setIrSisanymd("");
        khSyouraiwSisanhyouBean.setIrKykymd("");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(0);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.BLNK);
        khSyouraiwSisanhyouBean.setIrHknsyurui("");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouBean.setIrHknkkn("");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.BLNK);
        khSyouraiwSisanhyouBean.setIrHrkkkn(0);
        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("");
        khSyouraiwSisanhyouBean.setIrNkgnsgk("");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(106);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean khSyouraiwSisanhyouDataSourceBean = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(0));

        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk0(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk1(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk2(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk3(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk4(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk5(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk6(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk7(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk8(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk9(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk10(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk11(BizCurrency.valueOf(0));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testCreateReport27(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrHknkkn("999");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrHrkkkn(999);
        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("999,999,999 ＷＷＷ");
        khSyouraiwSisanhyouBean.setIrNkgnsgk("999,999,999 ＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(106);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean khSyouraiwSisanhyouDataSourceBean = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));

        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(999999999));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(999999999));

        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(999.99));

        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(9999999.99));

        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk0(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk1(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk2(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk3(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk4(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk5(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk6(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk7(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk8(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk9(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk10(BizCurrency.valueOf(9999999.99));
        khSyouraiwSisanhyouDataSourceBean.setIrKihrkmpstgk11(BizCurrency.valueOf(9999999.99));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testCreateReport28(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(9.28));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9.333,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrTmttknitenymd("2019年 5月15日");
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("1,002 米ドル");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(108);
        khSyouraiwSisanhyouBean.setIrNkgnsgk("1,113 米ドル");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 2; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(i);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(0);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(0));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testCreateReport29(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("wwwwwwwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(9.28));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(9.333,BizCurrencyTypes.AU_DOLLAR));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrTmttknitenymd("2019年 5月15日");
        khSyouraiwSisanhyouBean.setIrKijyunkingaku("1,002 米ドル");
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(108);
        khSyouraiwSisanhyouBean.setIrNkgnsgk("1,113 米ドル");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean;

        for (int i = 0; i < 9; i++) {

            khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(i);
            khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(99);
            khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(99);
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(0));
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.ZERO);
            khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.ZERO);

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testCreateReport30(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年 2月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(107);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testCreateReport31(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("◎将来の解約返戻金額（円）の試算には平成Z9年Z9月Z9日の為替レートを使用しています。");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrYendthnkymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrItijibrp(BizCurrency.valueOf(0));
        khSyouraiwSisanhyouBean.setIrHknkkn("99");
        khSyouraiwSisanhyouBean.setIrHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrTeiritutmttrate(BizNumber.valueOf(5));
        khSyouraiwSisanhyouBean.setIrSisuurendourate(BizNumber.valueOf(8));
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(107);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin0(BizCurrency.valueOf(4000));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin1(BizCurrency.valueOf(4001));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin2(BizCurrency.valueOf(4002));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin3(BizCurrency.valueOf(4003));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin4(BizCurrency.valueOf(4004));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin5(BizCurrency.valueOf(4005));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin6(BizCurrency.valueOf(4006));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin7(BizCurrency.valueOf(4007));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin8(BizCurrency.valueOf(4008));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin9(BizCurrency.valueOf(4009));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin10(BizCurrency.valueOf(4010));
        khSyouraiwSisanhyouDataSourceBean.setIrPtumitatekin11(BizCurrency.valueOf(4011));


        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrPtumitatekin11(BizCurrency.valueOf(9999999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate0(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate1(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate2(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate3(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate4(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate5(BizNumber.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate6(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate7(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate8(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate9(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate10(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate11(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrPtumitatekin11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate0(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate1(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate2(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate3(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate4(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate5(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate6(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate7(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate8(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate9(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate10(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate11(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrPtumitatekin11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate0(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate1(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate2(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate3(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate4(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate5(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate6(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate7(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate8(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate9(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate10(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate11(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin0(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin1(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin2(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin3(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin4(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin5(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin6(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin7(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin8(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin9(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin10(BizCurrency.valueOf(9.33));
            khSyouraiwSisanhyouDataSourceBean4.setIrPtumitatekin11(BizCurrency.valueOf(9.33));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate0(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate1(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate2(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate3(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate4(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate5(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate6(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate7(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate8(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate9(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate10(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate11(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin0(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin1(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin2(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin3(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin4(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin5(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin6(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin7(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin8(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin9(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin10(BizCurrency.valueOf(9.44));
            khSyouraiwSisanhyouDataSourceBean5.setIrPtumitatekin11(BizCurrency.valueOf(9.44));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean6.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean7.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean8.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate11(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin0(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin1(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin2(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin3(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin4(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin5(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin6(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin7(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin8(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin9(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin10(BizCurrency.valueOf(9.444));
            khSyouraiwSisanhyouDataSourceBean9.setIrPtumitatekin11(BizCurrency.valueOf(9.444));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testCreateReport32(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrSyono("wwwwwwwwwww");
        khSyouraiwSisanhyouBean.setIrSisanymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKykymd("ＷＷ99年99月99日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(999);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.USD);
        khSyouraiwSisanhyouBean.setIrHrkkkn(999);
        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(109);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika0(BizCurrency.valueOf(1000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika1(BizCurrency.valueOf(1001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika2(BizCurrency.valueOf(1002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika3(BizCurrency.valueOf(1003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika4(BizCurrency.valueOf(1004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika5(BizCurrency.valueOf(1005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika6(BizCurrency.valueOf(1006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika7(BizCurrency.valueOf(1007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika8(BizCurrency.valueOf(1008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika9(BizCurrency.valueOf(1009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika10(BizCurrency.valueOf(1010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhrgaika11(BizCurrency.valueOf(1011));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate0(BizNumber.valueOf(300.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate1(BizNumber.valueOf(301.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate2(BizNumber.valueOf(302.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate3(BizNumber.valueOf(303.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate4(BizNumber.valueOf(304.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate5(BizNumber.valueOf(305.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate6(BizNumber.valueOf(306.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate7(BizNumber.valueOf(307.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate8(BizNumber.valueOf(308.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate9(BizNumber.valueOf(309.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate10(BizNumber.valueOf(310.00));
        khSyouraiwSisanhyouDataSourceBean.setIrKawaserate11(BizNumber.valueOf(311.00));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean1.setIrKawaserate11(BizNumber.valueOf(999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhrgaika11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate0(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate1(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate2(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate3(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate4(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate5(BizNumber.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate6(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate7(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate8(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate9(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate10(BizNumber.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKawaserate11(BizNumber.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate0(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate1(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate2(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate3(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate4(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate5(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate6(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate7(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate8(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate9(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate10(BizNumber.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean3.setIrKawaserate11(BizNumber.valueOf(9.1));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.1));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate0(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate1(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate2(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate3(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate4(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate5(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate6(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate7(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate8(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate9(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate10(BizNumber.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean4.setIrKawaserate11(BizNumber.valueOf(9.22));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.22));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate0(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate1(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate2(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate3(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate4(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate5(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate6(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate7(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate8(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate9(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate10(BizNumber.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean5.setIrKawaserate11(BizNumber.valueOf(9.333));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean6.setIrKawaserate11(BizNumber.valueOf(999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean7.setIrKawaserate11(BizNumber.valueOf(999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean8.setIrKawaserate11(BizNumber.valueOf(999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika0(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika1(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika2(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika3(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika4(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika5(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika6(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika7(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika8(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika9(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika10(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhrgaika11(BizCurrency.valueOf(9.333));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate0(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate1(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate2(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate3(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate4(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate5(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate6(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate7(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate8(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate9(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate10(BizNumber.valueOf(999.99));
            khSyouraiwSisanhyouDataSourceBean9.setIrKawaserate11(BizNumber.valueOf(999.99));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(330)
    @Transactional
    public void testCreateReport33(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhSyouraiwSisanhyouTest", C_SyoruiCdKbn.KK_SYOURAIW_SISANHYOU);
        khSyouraiwSisanhyouBean.setIrUsernm("坂田銀時");
        khSyouraiwSisanhyouBean.setIrSakuseiymdtime("2016/08/09 16:55");
        khSyouraiwSisanhyouBean.setIrWarningmsg("");
        khSyouraiwSisanhyouBean.setIrSyono("10000000001");
        khSyouraiwSisanhyouBean.setIrSisanymd("平成26年 8月10日");
        khSyouraiwSisanhyouBean.setIrKykymd("平成26年10月 8日");
        khSyouraiwSisanhyouBean.setIrKanyuujinen(25);
        khSyouraiwSisanhyouBean.setIrSeibetu(C_Seibetu.FEMALE);
        khSyouraiwSisanhyouBean.setIrHknsyurui("保険種類");
        khSyouraiwSisanhyouBean.setIrHkgkgaika(BizCurrency.valueOf(999999999.99));
        khSyouraiwSisanhyouBean.setIrKyktuukasyu(C_Tuukasyu.JPY);
        khSyouraiwSisanhyouBean.setIrHrkkkn(99);
        khSyouraiwSisanhyouBean.setIrHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        khSyouraiwSisanhyouBean.setIrSyouhnhanteikekka(109);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();
        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean  = new KhSyouraiwSisanhyouDataSourceBean();

        khSyouraiwSisanhyouDataSourceBean.setIrGrayflg(2);
        khSyouraiwSisanhyouDataSourceBean.setIrKeikanensuu(0);
        khSyouraiwSisanhyouDataSourceBean.setIrHhknnen(5);
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen0(BizCurrency.valueOf(2000));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen1(BizCurrency.valueOf(2001));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen2(BizCurrency.valueOf(2002));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen3(BizCurrency.valueOf(2003));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen4(BizCurrency.valueOf(2004));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen5(BizCurrency.valueOf(2005));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen6(BizCurrency.valueOf(2006));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen7(BizCurrency.valueOf(2007));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen8(BizCurrency.valueOf(2008));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen9(BizCurrency.valueOf(2009));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen10(BizCurrency.valueOf(2010));
        khSyouraiwSisanhyouDataSourceBean.setIrKaiyakuhryen11(BizCurrency.valueOf(2011));

        dataSouceList.add(khSyouraiwSisanhyouDataSourceBean);

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean1;

        for (int i = 0; i < 2; i++) {
            khSyouraiwSisanhyouDataSourceBean1  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean1.setIrGrayflg(3);
            khSyouraiwSisanhyouDataSourceBean1.setIrKeikanensuu(1);
            khSyouraiwSisanhyouDataSourceBean1.setIrHhknnen(26);
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen0(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen1(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen2(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen3(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen4(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen5(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen6(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen7(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen8(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen9(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen10(BizCurrency.valueOf(999999999));
            khSyouraiwSisanhyouDataSourceBean1.setIrKaiyakuhryen11(BizCurrency.valueOf(999999999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean1);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean2;

        for (int i = 0; i < 3; i++) {
            khSyouraiwSisanhyouDataSourceBean2  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean2.setIrGrayflg(4);
            khSyouraiwSisanhyouDataSourceBean2.setIrKeikanensuu(2);
            khSyouraiwSisanhyouDataSourceBean2.setIrHhknnen(27);
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen0(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen1(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen2(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen3(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen4(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen5(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen6(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen7(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen8(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen9(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen10(BizCurrency.valueOf(999));
            khSyouraiwSisanhyouDataSourceBean2.setIrKaiyakuhryen11(BizCurrency.valueOf(999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean2);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean3;

        for (int i = 0; i < 4; i++) {
            khSyouraiwSisanhyouDataSourceBean3  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean3.setIrGrayflg(5);
            khSyouraiwSisanhyouDataSourceBean3.setIrKeikanensuu(3);
            khSyouraiwSisanhyouDataSourceBean3.setIrHhknnen(28);
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean3.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean3);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean4;

        for (int i = 0; i < 5; i++) {
            khSyouraiwSisanhyouDataSourceBean4  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean4.setIrGrayflg(6);
            khSyouraiwSisanhyouDataSourceBean4.setIrKeikanensuu(4);
            khSyouraiwSisanhyouDataSourceBean4.setIrHhknnen(29);
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean4.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean4);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean5;

        for (int i = 0; i < 6; i++) {
            khSyouraiwSisanhyouDataSourceBean5  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean5.setIrGrayflg(7);
            khSyouraiwSisanhyouDataSourceBean5.setIrKeikanensuu(5);
            khSyouraiwSisanhyouDataSourceBean5.setIrHhknnen(30);
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean5.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean5);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean6;

        for (int i = 0; i < 7; i++) {
            khSyouraiwSisanhyouDataSourceBean6  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean6.setIrGrayflg(8);
            khSyouraiwSisanhyouDataSourceBean6.setIrKeikanensuu(6);
            khSyouraiwSisanhyouDataSourceBean6.setIrHhknnen(31);
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean6.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean6);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean7;

        for (int i = 0; i < 8; i++) {
            khSyouraiwSisanhyouDataSourceBean7  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean7.setIrGrayflg(9);
            khSyouraiwSisanhyouDataSourceBean7.setIrKeikanensuu(7);
            khSyouraiwSisanhyouDataSourceBean7.setIrHhknnen(32);
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean7.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean7);

        }

        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean8;

        for (int i = 0; i < 9; i++) {
            khSyouraiwSisanhyouDataSourceBean8  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean8.setIrGrayflg(10);
            khSyouraiwSisanhyouDataSourceBean8.setIrKeikanensuu(8);
            khSyouraiwSisanhyouDataSourceBean8.setIrHhknnen(33);
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean8.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean8);

        }


        KhSyouraiwSisanhyouDataSourceBean  khSyouraiwSisanhyouDataSourceBean9;

        for (int i = 0; i < 10; i++) {
            khSyouraiwSisanhyouDataSourceBean9  = new KhSyouraiwSisanhyouDataSourceBean();

            khSyouraiwSisanhyouDataSourceBean9.setIrGrayflg(11);
            khSyouraiwSisanhyouDataSourceBean9.setIrKeikanensuu(9);
            khSyouraiwSisanhyouDataSourceBean9.setIrHhknnen(34);
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen0(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen1(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen2(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen3(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen4(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen5(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen6(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen7(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen8(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen9(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen10(BizCurrency.valueOf(9999));
            khSyouraiwSisanhyouDataSourceBean9.setIrKaiyakuhryen11(BizCurrency.valueOf(9999));

            dataSouceList.add(khSyouraiwSisanhyouDataSourceBean9);

        }
        reportTestBean.addParamObjects(dataSouceList, khSyouraiwSisanhyouBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

}
