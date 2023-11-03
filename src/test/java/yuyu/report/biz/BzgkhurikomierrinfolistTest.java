package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzGkHurikomiErrInfoListBean;
import yuyu.def.biz.bean.report.BzGkHurikomiErrInfoListDataSourceBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨振込入金エラー情報リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzgkhurikomierrinfolistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzGkHurikomiErrInfoListBean bzGkHurikomiErrInfoListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1998; i++) {
            BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = new BzGkHurikomiErrInfoListDataSourceBean();

            bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd("XX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu("XX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd("XXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej("XXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori("XXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori("XXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd("XXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej("XXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano("XXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu("XXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk("XXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1("XX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei("XX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd("XXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("XX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu("XXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa("X");
            bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk("XXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino("XXXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成27年11月 5日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg("外貨　通貨種類エラー　銀行：0009　支店：101　作成日：20151105　処理通番：00012345　エラー項目：取引幣種");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1("1");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd("09");
        bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn("2");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd("20151105");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd("20151106");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu("25");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom("20100101");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto("20161231");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd("0009");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej("SUMITOMO MITSUI");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori("201");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori("ABCDEFGHIJK");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd("101");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej("OOSAKAHONTEN");
        bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.TTYOKIN);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano("0000123456");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej("KOUZAMEIGININKOUZAMEIGININKOUZAMEIGININ");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu("USD");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa("4");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk("1000001002003");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("5");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2("6");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1("02");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei("03");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1("00012345");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd("20160119");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("7");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("11");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu("GBP");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa("8");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk("22000123456");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino("0000000000523455");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino("000002349876");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej("BBUUXXIIAANNGGDDIIEERRSSHHKKLL");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm("01 MOUBAN001 FURIKOMIIRAININ MEI");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成28年 1月20日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg("外貨　通貨種類エラー　銀行：　0009　支店：　101　作成日：　20150120　処理通番：　00012345　エラー項目：　取引幣種");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1("1");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd("09");
        bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn("2");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd("20151106");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu("25");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom("20100101");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto("20161231");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd("0009");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej("SUMITOMO MITSUI");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori("201");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori("ABCDEFGHIJK");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd("101");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej("OOSAKAHONTEN");
        bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.TTYOKIN);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano("0000123456");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej("KOUZAMEIGININKOUZAMEIGININKOUZAMEIGININ");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu("USD");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa("4");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk("1000001002003");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("5");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2("6");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1("02");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei("03");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1("00012345");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd("20160119");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("7");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("11");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu("GBP");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa("8");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk("22000123456");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino("0000000000523455");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino("000002349876");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej("BBUUXXIIAANNGGDDIIEERRSSHHII");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm("01 MOUBAN001 FURIKOMIIRAININ MEI");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean);

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean2 = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean2.setIrErrormsg("金額桁超エラー　銀行：　0009　支店：　101　作成日：　20160120　処理通番：　00012345　エラー項目：　取引前残高");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDatakbn1("2");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSyubetucd("09");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrCdkbn("3");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSakuseiymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrRenrakuymd("20151106");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrRenrakukaisuu("25");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKnjyymdfrom("20100101");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKnjyymdto("20161231");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrBankcd("0009");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrBanknmej("SUMITOMO MITSUI");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitencdtori("201");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitennmejtori("ABCDEFGHIJK");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitencd("101");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitennmej("OOSAKAHONTEN");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrYokinkbn(C_YokinKbn.TYOTIKU);
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKouzano("0000123456");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKznmej("KOUZAMEIGININKOUZAMEIGININKOUZAMEIGININ");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrZndktuukasyu("USD");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrZndkssketa("5");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrGktrhkmaezndk("1001002003");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKasikosikbn("6");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDatakbn2("7");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDtrecordkbn1("02");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDtrecordkousei("03");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSyorino1("00012345");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKnjyymd("20160119");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKsnymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrIribaraikbn("8");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhkkbn("11");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhktuukasyu("GBP");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhkssketa("9");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrGktrhkgk("22123456");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrBanksyoukaino("0000000000523455");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhksyoukaino("000002349876");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTekiyounaiyouej("BBUUXXIIAANNGGDDIIEERRSSHHII");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrIrninnm("01 MOUBAN001 FURIKOMIIRAININ MEI");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成28年 1月21日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg("外貨　通貨種類エラー　銀行：　0009　支店：　101　作成日：　20160121　処理通番：　00012345　エラー項目：　取引幣種");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1("1");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd("09");
        bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn("2");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd("20160121");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd("20151106");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu("25");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom("20100101");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto("20161231");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd("0009");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej("SUMITOMO MITSUI");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori("201");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori("ABCDEFGHIJK");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd("101");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej("OOSAKAHONTEN");
        bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.TTYOKIN);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano("0000123456");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej("KOUZAMEIGININKOUZAMEIGININKOUZAMEIGININ");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu("USD");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa("4");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk("1000001002003");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("5");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2("6");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1("02");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei("03");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1("00012345");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd("20160119");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("7");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("11");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu("GBP");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa("8");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk("22000123456");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino("0000000000523455");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino("000002349876");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej("BBUUXXIIAANNGGDDIIEERRSSHHII");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm("01 MOUBAN001 FURIKOMIIRAININ MEI");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean);

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean2 = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean2.setIrErrormsg("金額桁超エラー　銀行：　0009　支店：　101　作成日：　20160121　処理通番：　00012345　エラー項目：　取引前残高");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDatakbn1("2");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSyubetucd("09");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrCdkbn("3");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSakuseiymd("20160121");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrRenrakuymd("20151106");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrRenrakukaisuu("25");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKnjyymdfrom("20100101");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKnjyymdto("20161231");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrBankcd("0009");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrBanknmej("SUMITOMO MITSUI");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitencdtori("201");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitennmejtori("ABCDEFGHIJK");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitencd("101");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSitennmej("OOSAKAHONTEN");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrYokinkbn(C_YokinKbn.TYOTIKU);
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKouzano("0000123456");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKznmej("KOUZAMEIGININKOUZAMEIGININKOUZAMEIGININ");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrZndktuukasyu("USD");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrZndkssketa("5");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrGktrhkmaezndk("1001002003");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKasikosikbn("6");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDatakbn2("7");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDtrecordkbn1("02");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrDtrecordkousei("03");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrSyorino1("00012345");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKnjyymd("20160119");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrKsnymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrIribaraikbn("8");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhkkbn("11");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhktuukasyu("GBP");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhkssketa("9");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrGktrhkgk("22123456");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrBanksyoukaino("0000000000523455");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTrhksyoukaino("000002349876");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrTekiyounaiyouej("BBUUXXIIAANNGGDDIIEERRSSHHII");
        bzGkHurikomiErrInfoListDataSourceBean2.setIrIrninnm("01 MOUBAN001 FURIKOMIIRAININ MEI");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean2);

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean3 = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean3.setIrErrormsg("コード区分不正エラー　銀行：　0009　支店：　101　作成日：　20160121　処理通番：　00012345　エラー項目：　コード区分");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrDatakbn1("3");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSyubetucd("09");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrCdkbn("0");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSakuseiymd("20160121");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrRenrakuymd("20151106");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrRenrakukaisuu("25");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKnjyymdfrom("20100101");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKnjyymdto("20161231");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrBankcd("0009");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrBanknmej("SUMITOMO MITSUI");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSitencdtori("201");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSitennmejtori("ABCDEFGHIJK");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSitencd("101");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSitennmej("OOSAKAHONTEN");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKouzano("0000123456");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKznmej("KOUZAMEIGININKOUZAMEIGININKOUZAMEIGININ");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrZndktuukasyu("USD");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrZndkssketa("6");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrGktrhkmaezndk("123456789000000");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKasikosikbn("7");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrDatakbn2("8");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrDtrecordkbn1("02");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrDtrecordkousei("03");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrSyorino1("00012345");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKnjyymd("20160119");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrKsnymd("20160120");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrIribaraikbn("9");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrTrhkkbn("11");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrTrhktuukasyu("GBP");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrTrhkssketa("4");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrGktrhkgk("112233445566778");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrBanksyoukaino("0000000000523455");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrTrhksyoukaino("000002349876");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrTekiyounaiyouej("BBUUXXIIAANNGGDDIIEERRSSHHII");
        bzGkHurikomiErrInfoListDataSourceBean3.setIrIrninnm("01 MOUBAN001 FURIKOMIIRAININ MEI");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成28年 1月22日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.BLNK);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej("");
        bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm("");

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("biz", "", "bzgkhurikomierrinfolist", C_SyoruiCdKbn.CM_GKHURIKOMIERRINFOLIST);

        bzGkHurikomiErrInfoListBean.setIrTyouhyousakuseiymd(null);


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzGkHurikomiErrInfoListDataSourceBean bzGkHurikomiErrInfoListDataSourceBean = new BzGkHurikomiErrInfoListDataSourceBean();

        bzGkHurikomiErrInfoListDataSourceBean.setIrErrormsg(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn1(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyubetucd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrCdkbn(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSakuseiymd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakuymd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrRenrakukaisuu(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymdto(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrBankcd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanknmej(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencdtori(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmejtori(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitencd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSitennmej(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrYokinkbn(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKouzano(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKznmej(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndktuukasyu(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrZndkssketa(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkmaezndk(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKasikosikbn(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrDatakbn2(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkbn1(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrDtrecordkousei(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrSyorino1(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKnjyymd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrKsnymd(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrIribaraikbn(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkkbn(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhktuukasyu(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhkssketa(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrGktrhkgk(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrBanksyoukaino(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrTrhksyoukaino(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyouej(null);
        bzGkHurikomiErrInfoListDataSourceBean.setIrIrninnm(null);

        dataSouceList.add(bzGkHurikomiErrInfoListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzGkHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
