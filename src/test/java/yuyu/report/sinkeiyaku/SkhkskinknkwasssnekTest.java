package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkHkskinknkwasssnekBean;
import yuyu.def.sinkeiyaku.bean.report.SkHkskinknkwasssnekDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 複数回入金為替差損益帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkhkskinknkwasssnekTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkHkskinknkwasssnekBean skHkskinknkwasssnekBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkhkskinknkwasssnekTest", C_SyoruiCdKbn.SK_HUKUSUUKAINYUUKINKAWASESASONEKI);

        skHkskinknkwasssnekBean.setIrAtesaki(null);
        skHkskinknkwasssnekBean.setIrTyouhyousakuseiymd(null);
        skHkskinknkwasssnekBean.setIrTyouhyoutitle(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();

        skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka(null);
        skHkskinknkwasssnekDataSourceBean.setIrMosno(null);
        skHkskinknkwasssnekDataSourceBean.setIrKyknmkn(null);
        skHkskinknkwasssnekDataSourceBean.setIrSeiritujk(null);
        skHkskinknkwasssnekDataSourceBean.setIrSeirituymd(null);
        skHkskinknkwasssnekDataSourceBean.setIrRenno(null);
        skHkskinknkwasssnekDataSourceBean.setIrRsgaku(null);
        skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd(null);
        skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd(null);
        skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(null);
        skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(null);
        skHkskinknkwasssnekDataSourceBean.setIrZenhnkn(null);
        skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(null);
        skHkskinknkwasssnekDataSourceBean.setIrGkkawasesaeki(null);
        skHkskinknkwasssnekDataSourceBean.setIrGkkawasesason(null);
        skHkskinknkwasssnekDataSourceBean.setIrRenno2(null);
        skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd(null);
        skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(null);
        skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(null);
        skHkskinknkwasssnekDataSourceBean.setIrPkakingk(null);
        skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(null);
        skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(null);
        skHkskinknkwasssnekDataSourceBean.setIrRenno3(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaidngakugk(null);
        skHkskinknkwasssnekDataSourceBean.setIrRenno4(null);
        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymd(null);
        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymdkwsrate(null);
        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(null);
        skHkskinknkwasssnekDataSourceBean.setIrSeiritudngaku(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(null);
        skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(null);
        skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesaeki(null);
        skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesason(null);
        skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesaeki(null);
        skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesason(null);

        dataSouceList.add(skHkskinknkwasssnekDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skHkskinknkwasssnekBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkhkskinknkwasssnekTest", C_SyoruiCdKbn.SK_HUKUSUUKAINYUUKINKAWASESASONEKI);

        skHkskinknkwasssnekBean.setIrAtesaki("");
        skHkskinknkwasssnekBean.setIrTyouhyousakuseiymd("");
        skHkskinknkwasssnekBean.setIrTyouhyoutitle("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean1 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean1.setIrNyukintuuka("");
        skHkskinknkwasssnekDataSourceBean1.setIrMosno("");
        skHkskinknkwasssnekDataSourceBean1.setIrKyknmkn("");
        skHkskinknkwasssnekDataSourceBean1.setIrSeiritujk("");
        skHkskinknkwasssnekDataSourceBean1.setIrSeirituymd("");
        skHkskinknkwasssnekDataSourceBean1.setIrRenno(0);
        skHkskinknkwasssnekDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean1.setIrNyknsyoriymd("");
        skHkskinknkwasssnekDataSourceBean1.setIrTyakkinymd("");
        skHkskinknkwasssnekDataSourceBean1.setIrTyakkinkwsrate(BizNumber.valueOf(0));
        skHkskinknkwasssnekDataSourceBean1.setIrTyakkindengk(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymd("");
        skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(0));
        skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymddengk(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean1.setIrZenhnkn("");
        skHkskinknkwasssnekDataSourceBean1.setIrKawasesasoneki(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean1.setHnknTitleHyoujiFlg("2");
        skHkskinknkwasssnekDataSourceBean1.setOver10LineKaipageFlg(0);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean1);

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("");
            skHkskinknkwasssnekDataSourceBeanBlank.setOver10LineKaipageFlg(0);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanGoukei1 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBeanGoukei1.setIrNyukintuuka("");
        skHkskinknkwasssnekDataSourceBeanGoukei1.setIrMosno("");
        skHkskinknkwasssnekDataSourceBeanGoukei1.setNyknGukiTitle("第１回合計為替差益");
        skHkskinknkwasssnekDataSourceBeanGoukei1.setIrGkkawasesaeki(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBeanGoukei1.setOver10LineKaipageFlg(0);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBeanGoukei1);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanGoukei2 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBeanGoukei2.setIrNyukintuuka("");
        skHkskinknkwasssnekDataSourceBeanGoukei2.setIrMosno("");
        skHkskinknkwasssnekDataSourceBeanGoukei2.setNyknGukiTitle("第１回合計為替差損");
        skHkskinknkwasssnekDataSourceBeanGoukei2.setIrGkkawasesason(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBeanGoukei2.setOver10LineKaipageFlg(0);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBeanGoukei2);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanTitleBlank1 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBeanTitleBlank1.setIrNyukintuuka("");
        skHkskinknkwasssnekDataSourceBeanTitleBlank1.setIrMosno("");
        skHkskinknkwasssnekDataSourceBeanTitleBlank1.setOver10LineKaipageFlg(0);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBeanTitleBlank1);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanTitleBlank2 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBeanTitleBlank2.setIrNyukintuuka("");
        skHkskinknkwasssnekDataSourceBeanTitleBlank2.setIrMosno("");
        skHkskinknkwasssnekDataSourceBeanTitleBlank2.setOver10LineKaipageFlg(0);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBeanTitleBlank2);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean2 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean2.setIrNyukintuuka("");
        skHkskinknkwasssnekDataSourceBean2.setIrMosno("");
        skHkskinknkwasssnekDataSourceBean2.setIrRenno2(0);
        skHkskinknkwasssnekDataSourceBean2.setIrPkakinsyoriymd("");
        skHkskinknkwasssnekDataSourceBean2.setIrPkakinrsymdkwsrate(BizNumber.valueOf(0));
        skHkskinknkwasssnekDataSourceBean2.setIrKarisyokaidngaku(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean2.setIrPkakingk(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean2.setIrPkakindengk(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean2.setIrKasisyokaidngaku(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean2.setOver10LineKaipageFlg(0);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean2);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean3 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean3.setIrRenno3(0);
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaidnrsgakugk(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaidngakugk(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrRenno4(0);
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudnrsymd("");
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudnrsgaku(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudngaku(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaigkkawasesason(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrTuukasyugkkawasesason(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(0));
        skHkskinknkwasssnekDataSourceBean3.setOver10LineKaipageFlg(1);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, skHkskinknkwasssnekBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkhkskinknkwasssnekTest", C_SyoruiCdKbn.SK_HUKUSUUKAINYUUKINKAWASESASONEKI);

        skHkskinknkwasssnekBean.setIrAtesaki("代理店契約室　御中");
        skHkskinknkwasssnekBean.setIrTyouhyousakuseiymd("2019年 8月 8日");
        skHkskinknkwasssnekBean.setIrTyouhyoutitle("2020年度第１四半期　複数回入金・過剰入金為替差損益");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 8; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();

            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456780");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.DOLLAR));
            skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd("20200704");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd("20200705");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
            skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd("20200706");
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(BizCurrency.valueOf(202, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrZenhnkn("返金済");
            skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(BizCurrency.valueOf(303, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(1);

            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean1 = new SkHkskinknkwasssnekDataSourceBean();

        skHkskinknkwasssnekDataSourceBean1.setIrNyukintuuka("米ドル入金");
        skHkskinknkwasssnekDataSourceBean1.setIrMosno("123456780");
        skHkskinknkwasssnekDataSourceBean1.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean1.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean1.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean1.setIrRenno(9);
        skHkskinknkwasssnekDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean1.setIrNyknsyoriymd("20200704");
        skHkskinknkwasssnekDataSourceBean1.setIrTyakkinymd("20201215");
        skHkskinknkwasssnekDataSourceBean1.setIrTyakkinkwsrate(BizNumber.valueOf(12.1));
        skHkskinknkwasssnekDataSourceBean1.setIrTyakkindengk(BizCurrency.valueOf(101, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymd("20201216");
        skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23.1));
        skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymddengk(BizCurrency.valueOf(202, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean1.setIrZenhnkn("返金済");
        skHkskinknkwasssnekDataSourceBean1.setIrKawasesasoneki(BizCurrency.valueOf(303, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean1.setOver10LineKaipageFlg(1);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean1);

        for(int i = 0; i < 5; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456780");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(1);
            if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(404, BizCurrencyTypes.YEN));
            }
            else if (i == 2) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(505, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        for (int i = 0; i < 8; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456780");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno2(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd("20200707");
            skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24));
            skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(BizCurrency.valueOf(105, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8888, BizCurrencyTypes.DOLLAR));
            skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(BizCurrency.valueOf(106, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(1);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean2 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean2.setIrNyukintuuka("米ドル入金");
        skHkskinknkwasssnekDataSourceBean2.setIrMosno("123456780");
        skHkskinknkwasssnekDataSourceBean2.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean2.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean2.setIrRenno2(9);
        skHkskinknkwasssnekDataSourceBean2.setIrPkakinsyoriymd("20200707");
        skHkskinknkwasssnekDataSourceBean2.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.1));
        skHkskinknkwasssnekDataSourceBean2.setIrKarisyokaidngaku(BizCurrency.valueOf(1005, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrPkakingk(BizCurrency.valueOf(8.1, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean2.setIrPkakindengk(BizCurrency.valueOf(1006, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrKasisyokaidngaku(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrRenno3(1);
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7777, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaidngakugk(BizCurrency.valueOf(909, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrRenno4(1);
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudnrsymd("20200708");
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.1));
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudnrsgaku(BizCurrency.valueOf(6666, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudngaku(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(103, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaigkkawasesason(BizCurrency.valueOf(104, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setOver10LineKaipageFlg(1);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean2);

        for (int i = 0; i < 10; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();

            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456781");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
            skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd("20200704");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd("20201215");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
            skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd("20201216");
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrZenhnkn("返金済");
            skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(2);
            if (i == 9) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.DOLLAR));
            }

            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456781");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(2);
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(4004, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(5005, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        for (int i = 0; i < 10; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456781");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno2(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd("20200707");
            skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.1));
            skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(BizCurrency.valueOf(1005, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(888, BizCurrencyTypes.DOLLAR));
            skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(BizCurrency.valueOf(1006, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(BizCurrency.valueOf(8008, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(2);
            if (i == 9) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrRenno3(1);
                skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(777, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaidngakugk(BizCurrency.valueOf(9009, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrRenno4(1);
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymd("20200708");
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.456));
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(666, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudngaku(BizCurrency.valueOf(1002, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(1003, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(1004, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        for (int i = 0; i < 11; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();

            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456782");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd("20200704");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd("20201215");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
            skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd("20201216");
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrZenhnkn("返金済");
            skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("0");
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(3);
            if (i == 7) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.456));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23.456));
            }
            else if (i == 8) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.454));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23.454));
            }
            else if (i == 9) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
            }
            else if (i == 10) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
                skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(4);
            }

            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("123456782");
            skHkskinknkwasssnekDataSourceBeanBlank.setOver10LineKaipageFlg(4);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456782");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(4);
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        for (int i = 0; i < 11; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456782");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno2(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd("20200707");
            skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24));
            skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(BizCurrency.valueOf(1005, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8.1, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(BizCurrency.valueOf(1006, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(BizCurrency.valueOf(8008, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(4);
            if (i == 7) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.456));
            }
            else if (i == 8) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8.333, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.454));
            }
            else if (i == 9) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8888, BizCurrencyTypes.YEN));
            }
            else if (i == 10) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(888, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrRenno3(1);
                skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7.1, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaidngakugk(BizCurrency.valueOf(9009, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrRenno4(1);
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymd("20200708");
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.454));
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(6.1, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudngaku(BizCurrency.valueOf(1002, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(1003, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(1004, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(5);
                skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("1");
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        for (int i = 0; i < 11; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();

            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456783");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd("20200704");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd("20201215");
            skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
            skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd("20201216");
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
            skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrZenhnkn("返金済");
            skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("0");
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(6);
            if (i == 7) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.1, BizCurrencyTypes.YEN));
            }
            else if (i == 8) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.22, BizCurrencyTypes.YEN));
            }
            else if (i == 9) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
            }
            else if (i == 10) {
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
                skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(7);
            }

            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("123456783");
            skHkskinknkwasssnekDataSourceBeanBlank.setOver10LineKaipageFlg(7);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456783");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(7);
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(909, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(909, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean3 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean3.setIrNyukintuuka("米ドル入金");
        skHkskinknkwasssnekDataSourceBean3.setIrMosno("123456783");
        skHkskinknkwasssnekDataSourceBean3.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean3.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean3.setIrRenno2(1);
        skHkskinknkwasssnekDataSourceBean3.setIrPkakinsyoriymd("20200707");
        skHkskinknkwasssnekDataSourceBean3.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.1));
        skHkskinknkwasssnekDataSourceBean3.setIrKarisyokaidngaku(BizCurrency.valueOf(105, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrPkakingk(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrPkakindengk(BizCurrency.valueOf(106, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrKasisyokaidngaku(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrRenno3(1);
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7.22, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaidngakugk(BizCurrency.valueOf(909, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrRenno4(1);
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudnrsymd("20200708");
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.1));
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudnrsgaku(BizCurrency.valueOf(6.22, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean3.setIrSeiritudngaku(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(103, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setIrSyokaigkkawasesason(BizCurrency.valueOf(104, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean3.setOver10LineKaipageFlg(7);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean3);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean4 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean4.setIrNyukintuuka("米ドル入金");
        skHkskinknkwasssnekDataSourceBean4.setIrMosno("123456784");
        skHkskinknkwasssnekDataSourceBean4.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean4.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean4.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean4.setIrRenno(1);
        skHkskinknkwasssnekDataSourceBean4.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean4.setIrNyknsyoriymd("20200704");
        skHkskinknkwasssnekDataSourceBean4.setIrTyakkinymd("20201215");
        skHkskinknkwasssnekDataSourceBean4.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
        skHkskinknkwasssnekDataSourceBean4.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean4.setIrSyokaiprsymd("20201216");
        skHkskinknkwasssnekDataSourceBean4.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
        skHkskinknkwasssnekDataSourceBean4.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean4.setIrZenhnkn("返金済");
        skHkskinknkwasssnekDataSourceBean4.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean4.setHnknTitleHyoujiFlg("2");
        skHkskinknkwasssnekDataSourceBean4.setOver10LineKaipageFlg(8);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean4);

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("123456784");
            skHkskinknkwasssnekDataSourceBeanBlank.setOver10LineKaipageFlg(8);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456784");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(8);
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        for (int i = 0; i < 11; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBean.setIrMosno("123456784");
            skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
            skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean.setIrRenno2(i+1);
            skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd("20200707");
            skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24));
            skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(BizCurrency.valueOf(1005, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(BizCurrency.valueOf(1006, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(BizCurrency.valueOf(8008, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(8);
            if (i == 7) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8.1, BizCurrencyTypes.YEN));
            }
            else if (i == 8) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8.22, BizCurrencyTypes.YEN));
            }
            else if (i == 9) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8.333, BizCurrencyTypes.YEN));
            }
            else if (i == 10) {
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(8888, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrRenno3(1);
                skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7.333, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaidngakugk(BizCurrency.valueOf(9009, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrRenno4(1);
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymd("20200708");
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.1));
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(6.333, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrSeiritudngaku(BizCurrency.valueOf(1002, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(1003, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(1004, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(9);
                skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("1");
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean5 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean5.setIrNyukintuuka("米ドル入金");
        skHkskinknkwasssnekDataSourceBean5.setIrMosno("123456785");
        skHkskinknkwasssnekDataSourceBean5.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean5.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean5.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean5.setIrRenno(1);
        skHkskinknkwasssnekDataSourceBean5.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean5.setIrNyknsyoriymd("20200704");
        skHkskinknkwasssnekDataSourceBean5.setIrTyakkinymd("20201215");
        skHkskinknkwasssnekDataSourceBean5.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
        skHkskinknkwasssnekDataSourceBean5.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean5.setIrSyokaiprsymd("20201216");
        skHkskinknkwasssnekDataSourceBean5.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
        skHkskinknkwasssnekDataSourceBean5.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean5.setIrZenhnkn("返金済");
        skHkskinknkwasssnekDataSourceBean5.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean5.setHnknTitleHyoujiFlg("2");
        skHkskinknkwasssnekDataSourceBean5.setOver10LineKaipageFlg(10);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean5);

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("123456785");
            skHkskinknkwasssnekDataSourceBeanBlank.setOver10LineKaipageFlg(10);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("米ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456785");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(10);
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean6 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean6.setIrNyukintuuka("米ドル入金");
        skHkskinknkwasssnekDataSourceBean6.setIrMosno("123456785");
        skHkskinknkwasssnekDataSourceBean6.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean6.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean6.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean6.setIrRenno2(1);
        skHkskinknkwasssnekDataSourceBean6.setIrPkakinsyoriymd("20200707");
        skHkskinknkwasssnekDataSourceBean6.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.1));
        skHkskinknkwasssnekDataSourceBean6.setIrKarisyokaidngaku(BizCurrency.valueOf(105, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrPkakingk(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrPkakindengk(BizCurrency.valueOf(106, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrKasisyokaidngaku(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrRenno3(1);
        skHkskinknkwasssnekDataSourceBean6.setIrSyokaidnrsgakugk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean6.setIrSyokaidngakugk(BizCurrency.valueOf(909, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrRenno4(1);
        skHkskinknkwasssnekDataSourceBean6.setIrSeiritudnrsymd("20200708");
        skHkskinknkwasssnekDataSourceBean6.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.1));
        skHkskinknkwasssnekDataSourceBean6.setIrSeiritudnrsgaku(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        skHkskinknkwasssnekDataSourceBean6.setIrSeiritudngaku(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(103, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrSyokaigkkawasesason(BizCurrency.valueOf(104, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(606, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrTuukasyugkkawasesason(BizCurrency.valueOf(707, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(107, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(108, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean6.setOver10LineKaipageFlg(10);

        dataSouceList.add(skHkskinknkwasssnekDataSourceBean6);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean7 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean7.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean7.setIrMosno("123456786");
        skHkskinknkwasssnekDataSourceBean7.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean7.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean7.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean7.setIrRenno(1);
        skHkskinknkwasssnekDataSourceBean7.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skHkskinknkwasssnekDataSourceBean7.setIrNyknsyoriymd("20200704");
        skHkskinknkwasssnekDataSourceBean7.setIrTyakkinymd("20201215");
        skHkskinknkwasssnekDataSourceBean7.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
        skHkskinknkwasssnekDataSourceBean7.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean7.setIrSyokaiprsymd("20201216");
        skHkskinknkwasssnekDataSourceBean7.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
        skHkskinknkwasssnekDataSourceBean7.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean7.setIrZenhnkn("返金済");
        skHkskinknkwasssnekDataSourceBean7.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean7.setHnknTitleHyoujiFlg("2");
        skHkskinknkwasssnekDataSourceBean7.setOver10LineKaipageFlg(11);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean7);

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("豪ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("123456786");
            skHkskinknkwasssnekDataSourceBeanBlank.setOver10LineKaipageFlg(11);
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("豪ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456786");
            skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(11);
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean8 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean8.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean8.setIrMosno("123456786");
        skHkskinknkwasssnekDataSourceBean8.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean8.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean8.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean8.setIrRenno2(1);
        skHkskinknkwasssnekDataSourceBean8.setIrPkakinsyoriymd("20200707");
        skHkskinknkwasssnekDataSourceBean8.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.1));
        skHkskinknkwasssnekDataSourceBean8.setIrKarisyokaidngaku(BizCurrency.valueOf(105, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrPkakingk(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.AU_DOLLAR));
        skHkskinknkwasssnekDataSourceBean8.setIrPkakindengk(BizCurrency.valueOf(106, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrKasisyokaidngaku(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrRenno3(1);
        skHkskinknkwasssnekDataSourceBean8.setIrSyokaidnrsgakugk(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrSyokaidngakugk(BizCurrency.valueOf(909, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrRenno4(1);
        skHkskinknkwasssnekDataSourceBean8.setIrSeiritudnrsymd("20200708");
        skHkskinknkwasssnekDataSourceBean8.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(25.1));
        skHkskinknkwasssnekDataSourceBean8.setIrSeiritudnrsgaku(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrSeiritudngaku(BizCurrency.valueOf(102, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(103, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrSyokaigkkawasesason(BizCurrency.valueOf(104, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(6006, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrTuukasyugkkawasesason(BizCurrency.valueOf(7007, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(1007, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(1008, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean8.setOver10LineKaipageFlg(11);
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean8);

        reportTestBean.addParamObjects(dataSouceList, skHkskinknkwasssnekBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkhkskinknkwasssnekTest", C_SyoruiCdKbn.SK_HUKUSUUKAINYUUKINKAWASESASONEKI);

        skHkskinknkwasssnekBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skHkskinknkwasssnekBean.setIrTyouhyousakuseiymd("9999年99月99日");
        skHkskinknkwasssnekBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 99; i++) {

            for (int j = 0; j < 10; j++) {
                SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();

                skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
                skHkskinknkwasssnekDataSourceBean.setIrMosno("wwwwwwwww");
                skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
                skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
                if (i == 0) {
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("ＷＷＷ");
                }
                skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("99999999");
                skHkskinknkwasssnekDataSourceBean.setIrRenno(999);
                skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd("99999999");
                skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd("99999999");
                skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(999.99));
                skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd("99999999");
                skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(999.99));
                skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrZenhnkn("ＷＷＷ");
                skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
                skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(i);

                dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
            }

            for (int j = 0; j < 4; j++){

                SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("ＷＷＷＷＷ");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("wwwwwwwww");
                skHkskinknkwasssnekDataSourceBeanBlank1.setOver10LineKaipageFlg(i);
                if (j == 0) {
                    skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                    skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                }
                else if (j == 1) {
                    skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                    skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                }
                dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
            }

            for (int j = 0; j < 10; j++) {
                SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();
                skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("ＷＷＷＷＷ");
                skHkskinknkwasssnekDataSourceBean.setIrMosno("wwwwwwwww");
                skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
                skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
                if (i == 0) {
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("ＷＷＷ");
                }
                skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("99999999");
                skHkskinknkwasssnekDataSourceBean.setIrRenno2(999);
                skHkskinknkwasssnekDataSourceBean.setIrPkakinsyoriymd("99999999");
                skHkskinknkwasssnekDataSourceBean.setIrPkakinrsymdkwsrate(BizNumber.valueOf(999.99));
                skHkskinknkwasssnekDataSourceBean.setIrKarisyokaidngaku(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrPkakingk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
                skHkskinknkwasssnekDataSourceBean.setIrPkakindengk(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setIrKasisyokaidngaku(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean.setOver10LineKaipageFlg(i);
                if (j == 9) {
                    skHkskinknkwasssnekDataSourceBean.setIrRenno3(999);
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
                    if (i == 94) {
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(777, BizCurrencyTypes.YEN));
                    }
                    else if (i == 95) {
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7777, BizCurrencyTypes.YEN));
                    }
                    else if (i == 96) {
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7.1, BizCurrencyTypes.YEN));
                    }
                    else if (i == 97) {
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7.22, BizCurrencyTypes.YEN));
                    }
                    else if (i == 98) {
                        skHkskinknkwasssnekDataSourceBean.setIrSyokaidnrsgakugk(BizCurrency.valueOf(7.333, BizCurrencyTypes.YEN));
                    }
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaidngakugk(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrRenno4(999);
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymd("99999999");
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(999.99));
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(9999999999.99, BizCurrencyTypes.DOLLAR));
                    if (i == 94) {
                        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(666, BizCurrencyTypes.YEN));
                    }
                    else if (i == 95) {
                        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(6666, BizCurrencyTypes.YEN));
                    }
                    else if (i == 96) {
                        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(6.1, BizCurrencyTypes.YEN));
                    }
                    else if (i == 97) {
                        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(6.22, BizCurrencyTypes.YEN));
                    }
                    else if (i == 98) {
                        skHkskinknkwasssnekDataSourceBean.setIrSeiritudnrsgaku(BizCurrency.valueOf(6.333, BizCurrencyTypes.YEN));
                    }
                    skHkskinknkwasssnekDataSourceBean.setIrSeiritudngaku(BizCurrency.valueOf(9999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrSyokaigkkawasesason(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyugkkawasesason(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                    skHkskinknkwasssnekDataSourceBean.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(999999999999999.0, BizCurrencyTypes.YEN));
                }
                dataSouceList.add(skHkskinknkwasssnekDataSourceBean);
            }
        }

        reportTestBean.addParamObjects(dataSouceList, skHkskinknkwasssnekBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    public void testCreateReport5() {
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkhkskinknkwasssnekTest", C_SyoruiCdKbn.SK_HUKUSUUKAINYUUKINKAWASESASONEKI);

        skHkskinknkwasssnekBean.setIrAtesaki("代理店契約室　御中");
        skHkskinknkwasssnekBean.setIrTyouhyousakuseiymd("2019年 8月 8日");
        skHkskinknkwasssnekBean.setIrTyouhyoutitle("2020年度第１四半期　複数回入金・過剰入金為替差損益");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i < 11; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBean1.setIrNyukintuuka("豪ドル入金");
            skHkskinknkwasssnekDataSourceBean1.setIrMosno("123456782");
            skHkskinknkwasssnekDataSourceBean1.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean1.setIrSeiritujk("不成立");
            skHkskinknkwasssnekDataSourceBean1.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean1.setIrRenno(i);
            skHkskinknkwasssnekDataSourceBean1.setIrRsgaku(BizCurrency.valueOf(9999999999.11, BizCurrencyTypes.AU_DOLLAR));
            skHkskinknkwasssnekDataSourceBean1.setIrNyknsyoriymd("20200704");
            skHkskinknkwasssnekDataSourceBean1.setIrTyakkinymd("20201215");
            skHkskinknkwasssnekDataSourceBean1.setIrTyakkinkwsrate(BizNumber.valueOf(112.11));
            skHkskinknkwasssnekDataSourceBean1.setIrTyakkindengk(BizCurrency.valueOf(100000000001.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymd("20201216");
            skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(113.11));
            skHkskinknkwasssnekDataSourceBean1.setIrSyokaiprsymddengk(BizCurrency.valueOf(200000000002.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean1.setIrZenhnkn("返金済");
            skHkskinknkwasssnekDataSourceBean1.setIrKawasesasoneki(BizCurrency.valueOf(300000000003.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean1.setHnknTitleHyoujiFlg("2");
            dataSouceList.add(skHkskinknkwasssnekDataSourceBean1);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean11 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean11.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean11.setIrMosno("123456782");
        skHkskinknkwasssnekDataSourceBean11.setNyknGukiTitle("第１回合計為替差益");
        skHkskinknkwasssnekDataSourceBean11.setIrGkkawasesaeki(BizCurrency.valueOf(999999999999991.0, BizCurrencyTypes.YEN));
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean11);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean12 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean12.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean12.setIrMosno("123456782");
        skHkskinknkwasssnekDataSourceBean12.setNyknGukiTitle("第１回合計為替差損");
        skHkskinknkwasssnekDataSourceBean12.setIrGkkawasesason(BizCurrency.valueOf(999999999999992.0, BizCurrencyTypes.YEN));
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean12);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean13 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean13.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean13.setIrMosno("123456782");
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean13);

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean14 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean14.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean14.setIrMosno("123456782");
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean14);

        for (int i = 1; i < 3; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBean1.setIrNyukintuuka("豪ドル入金");
            skHkskinknkwasssnekDataSourceBean1.setIrMosno("123456782");
            skHkskinknkwasssnekDataSourceBean1.setIrKyknmkn("タナカ　タロウ");
            skHkskinknkwasssnekDataSourceBean1.setIrSeiritujk("不成立");
            skHkskinknkwasssnekDataSourceBean1.setIrSeirituymd("20200703");
            skHkskinknkwasssnekDataSourceBean1.setIrRenno2(i);
            skHkskinknkwasssnekDataSourceBean1.setIrPkakinsyoriymd("20200804");
            skHkskinknkwasssnekDataSourceBean1.setIrPkakinrsymdkwsrate(BizNumber.valueOf(213.11));
            skHkskinknkwasssnekDataSourceBean1.setIrKarisyokaidngaku(BizCurrency.valueOf(100000000002.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean1.setIrPkakingk(BizCurrency.valueOf(9999999999.22, BizCurrencyTypes.AU_DOLLAR));
            skHkskinknkwasssnekDataSourceBean1.setIrPkakindengk(BizCurrency.valueOf(200000000003.0, BizCurrencyTypes.YEN));
            skHkskinknkwasssnekDataSourceBean1.setIrKasisyokaidngaku(BizCurrency.valueOf(300000000004.0, BizCurrencyTypes.YEN));
            if (i == 2) {
                skHkskinknkwasssnekDataSourceBean1.setIrRenno3(333);
                skHkskinknkwasssnekDataSourceBean1.setIrSyokaidnrsgakugk(BizCurrency.valueOf(9999999999.97, BizCurrencyTypes.AU_DOLLAR));
                skHkskinknkwasssnekDataSourceBean1.setIrSyokaidngakugk(BizCurrency.valueOf(400000000001.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean1.setIrRenno4(444);
                skHkskinknkwasssnekDataSourceBean1.setIrSeiritudnrsymd("20200904");
                skHkskinknkwasssnekDataSourceBean1.setIrSeiritudnrsymdkwsrate(BizNumber.valueOf(313.11));
                skHkskinknkwasssnekDataSourceBean1.setIrSeiritudnrsgaku(BizCurrency.valueOf(9999999999.96, BizCurrencyTypes.AU_DOLLAR));
                skHkskinknkwasssnekDataSourceBean1.setIrSeiritudngaku(BizCurrency.valueOf(400000000002.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean1.setIrSyokaigkkawasesaeki(BizCurrency.valueOf(199999999999999.0, BizCurrencyTypes.YEN));
                skHkskinknkwasssnekDataSourceBean1.setIrSyokaigkkawasesason(BizCurrency.valueOf(299999999999999.0, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBean1);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean.setIrMosno("123456786");
        skHkskinknkwasssnekDataSourceBean.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean.setIrRenno(1);
        skHkskinknkwasssnekDataSourceBean.setIrRsgaku(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skHkskinknkwasssnekDataSourceBean.setIrNyknsyoriymd("20200704");
        skHkskinknkwasssnekDataSourceBean.setIrTyakkinymd("20201215");
        skHkskinknkwasssnekDataSourceBean.setIrTyakkinkwsrate(BizNumber.valueOf(12.11));
        skHkskinknkwasssnekDataSourceBean.setIrTyakkindengk(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymd("20201216");
        skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymdkwsrate(BizNumber.valueOf(23));
        skHkskinknkwasssnekDataSourceBean.setIrSyokaiprsymddengk(BizCurrency.valueOf(2002, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean.setIrZenhnkn("返金済");
        skHkskinknkwasssnekDataSourceBean.setIrKawasesasoneki(BizCurrency.valueOf(3003, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean.setHnknTitleHyoujiFlg("2");
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean);

        for (int i = 0; i < 9; i++) {
            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank.setIrNyukintuuka("豪ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank.setIrMosno("123456786");
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank);
        }

        for (int i = 0; i < 4; i++){

            SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBeanBlank1 = new SkHkskinknkwasssnekDataSourceBean();
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrNyukintuuka("豪ドル入金");
            skHkskinknkwasssnekDataSourceBeanBlank1.setIrMosno("123456786");
            if (i == 0) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差益");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesaeki(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            else if (i == 1) {
                skHkskinknkwasssnekDataSourceBeanBlank1.setNyknGukiTitle("第１回合計為替差損");
                skHkskinknkwasssnekDataSourceBeanBlank1.setIrGkkawasesason(BizCurrency.valueOf(10010, BizCurrencyTypes.YEN));
            }
            dataSouceList.add(skHkskinknkwasssnekDataSourceBeanBlank1);
        }

        SkHkskinknkwasssnekDataSourceBean skHkskinknkwasssnekDataSourceBean2 = new SkHkskinknkwasssnekDataSourceBean();
        skHkskinknkwasssnekDataSourceBean2.setIrNyukintuuka("豪ドル入金");
        skHkskinknkwasssnekDataSourceBean2.setIrMosno("123456786");
        skHkskinknkwasssnekDataSourceBean2.setIrKyknmkn("タナカ　タロウ");
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritujk("成立");
        skHkskinknkwasssnekDataSourceBean2.setIrSeirituymd("20200703");
        skHkskinknkwasssnekDataSourceBean2.setIrRenno2(1);
        skHkskinknkwasssnekDataSourceBean2.setIrPkakinsyoriymd("20200707");
        skHkskinknkwasssnekDataSourceBean2.setIrPkakinrsymdkwsrate(BizNumber.valueOf(24.1));
        skHkskinknkwasssnekDataSourceBean2.setIrKarisyokaidngaku(BizCurrency.valueOf(105, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrPkakingk(BizCurrency.valueOf(9999999999.0, BizCurrencyTypes.AU_DOLLAR));
        skHkskinknkwasssnekDataSourceBean2.setIrPkakindengk(BizCurrency.valueOf(106, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrKasisyokaidngaku(BizCurrency.valueOf(808, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrRenno3(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaidnrsgakugk(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaidngakugk(null);
        skHkskinknkwasssnekDataSourceBean2.setIrRenno4(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudnrsymd(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudnrsymdkwsrate(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudnrsgaku(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSeiritudngaku(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaigkkawasesaeki(null);
        skHkskinknkwasssnekDataSourceBean2.setIrSyokaigkkawasesason(null);
        skHkskinknkwasssnekDataSourceBean2.setIrTuukasyugkkawasesaeki(BizCurrency.valueOf(399999999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrTuukasyugkkawasesason(BizCurrency.valueOf(499999999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrTuukasyusykigkkawasesaeki(BizCurrency.valueOf(599999999999999.0, BizCurrencyTypes.YEN));
        skHkskinknkwasssnekDataSourceBean2.setIrTuukasyusykigkkawasesason(BizCurrency.valueOf(699999999999999.0, BizCurrencyTypes.YEN));
        dataSouceList.add(skHkskinknkwasssnekDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, skHkskinknkwasssnekBean);
        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
