package yuyu.report.biz;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.report.BzHurikomiErrInfoListBean;
import yuyu.def.biz.bean.report.BzHurikomiErrInfoListDataSourceBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振込入金エラー情報リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzhurikomierrinfolistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private BzHurikomiErrInfoListBean bzHurikomiErrInfoListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1998; i++) {
            BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = new BzHurikomiErrInfoListDataSourceBean();

            bzHurikomiErrInfoListDataSourceBean.setIrErrormsg("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1("X");
            bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd("XX");
            bzHurikomiErrInfoListDataSourceBean.setIrCdkbn("X");
            bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrBankcd("XXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrSitencd("XXX");
            bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.BETUDAN);
            bzHurikomiErrInfoListDataSourceBean.setIrKouzano("XXXXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrKznmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("X");
            bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn("X");
            bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk("XXXXXXXXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2("X");
            bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino("XXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("X");
            bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("XX");
            bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk("XXXXXXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk("XXXXXXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta("XXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn("X");
            bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno("XXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno("XXX");
            bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd("XXXXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo("XXXXXXXXXXXXXXXXXXXX");

            dataSouceList.add(bzHurikomiErrInfoListDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成26年08月26日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg("金額桁超エラー　銀行：0009　支店：101　作成日：271105　照会番号：00012345　エラー項目：取引前残高");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1("1");
        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd("03");
        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn("2");
        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta("271105");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta("200101");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta("281231");
        bzHurikomiErrInfoListDataSourceBean.setIrBankcd("0009");
        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn("ミツイスミトモ");
        bzHurikomiErrInfoListDataSourceBean.setIrSitencd("101");
        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn("オオサカホンテン");
        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.TTYOKIN);
        bzHurikomiErrInfoListDataSourceBean.setIrKouzano("0000123456");
        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn("コウザメイギニンメイコウザメイギニンメイコウザメイギニンメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("4");
        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn("5");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk("1000001002003");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2("6");
        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino("00012345");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta("280119");
        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta("280120");
        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("7");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("11");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk("22000123456");
        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk("300000999");
        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta("280121");
        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta("280122");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn("8");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno("1072345");
        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno("090");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd("0003456789");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48("01 MOUBAN001 ﾌﾘｺﾐｲﾗｲﾆﾝﾒｲﾌﾘｺﾐｲﾗｲﾆﾝﾒｲ");
        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn("シムケギンコウメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn("シムケテンメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou("摘要内容摘要内容摘要内容");
        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo("EDIｼﾞｮｳﾎｳEDIｼﾞｮｳﾎｳ");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){

        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成28年01月20日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg("金額桁超エラー　銀行：　0009　支店：　101　作成日：　20160120　照会番号：　00012345　エラー項目：　取引前残高");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1("1");
        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd("03");
        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn("2");
        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta("271105");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta("200101");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta("281231");
        bzHurikomiErrInfoListDataSourceBean.setIrBankcd("0009");
        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn("ミツイスミトモ");
        bzHurikomiErrInfoListDataSourceBean.setIrSitencd("101");
        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn("オオサカホンテン");
        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.TTYOKIN);
        bzHurikomiErrInfoListDataSourceBean.setIrKouzano("0000123456");
        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn("コウザメイギニンメイコウザメイギニンメイコウザメイギニンメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("4");
        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn("5");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk("1000001002003");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2("6");
        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino("00012345");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta("280119");
        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta("280120");
        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("7");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("11");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk("22000123456");
        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk("300000999");
        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta("280121");
        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta("280122");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn("8");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno("1072345");
        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno("090");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd("0003456789");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48("01 MOUBAN001 ﾌﾘｺﾐｲﾗｲﾆﾝﾒｲﾌﾘｺﾐｲﾗｲﾆﾝﾒｲ");
        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn("シムケギンコウメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn("シムケテンメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou("摘要内容摘要内容摘要内容");
        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo("EDIｼﾞｮｳﾎｳEDIｼﾞｮｳﾎｳ");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean);

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean2 = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean2.setIrErrormsg("日付不正エラー　銀行：　0009　支店：　101　作成日：　20160120　照会番号：　00012345　エラー項目：　勘定日（自）");
        bzHurikomiErrInfoListDataSourceBean2.setIrDatakbn1("2");
        bzHurikomiErrInfoListDataSourceBean2.setIrSyubetucd("03");
        bzHurikomiErrInfoListDataSourceBean2.setIrCdkbn("3");
        bzHurikomiErrInfoListDataSourceBean2.setIrSakuseiymd6keta("271105");
        bzHurikomiErrInfoListDataSourceBean2.setIrKnjyymdfrom6keta("200230");
        bzHurikomiErrInfoListDataSourceBean2.setIrKnjyymdto6keta("281231");
        bzHurikomiErrInfoListDataSourceBean2.setIrBankcd("0009");
        bzHurikomiErrInfoListDataSourceBean2.setIrBanknmkn("ミツイスミトモ");
        bzHurikomiErrInfoListDataSourceBean2.setIrSitencd("101");
        bzHurikomiErrInfoListDataSourceBean2.setIrSitennmkn("オオサカホンテン");
        bzHurikomiErrInfoListDataSourceBean2.setIrYokinkbn(C_YokinKbn.TYOTIKU);
        bzHurikomiErrInfoListDataSourceBean2.setIrKouzano("0000123456");
        bzHurikomiErrInfoListDataSourceBean2.setIrKznmkn("コウザメイギニンメイコウザメイギニンメイコウザメイギニンメイ");
        bzHurikomiErrInfoListDataSourceBean2.setIrKasikosikbn("5");
        bzHurikomiErrInfoListDataSourceBean2.setIrTuutyousysykbn("6");
        bzHurikomiErrInfoListDataSourceBean2.setIrTrhkmaezndk("1000001002003");
        bzHurikomiErrInfoListDataSourceBean2.setIrDatakbn2("7");
        bzHurikomiErrInfoListDataSourceBean2.setIrSyoukaino("00012345");
        bzHurikomiErrInfoListDataSourceBean2.setIrKnjyymd6keta("280119");
        bzHurikomiErrInfoListDataSourceBean2.setIrAzkrhrdsymd6keta("280120");
        bzHurikomiErrInfoListDataSourceBean2.setIrIribaraikbn("8");
        bzHurikomiErrInfoListDataSourceBean2.setIrTrhkkbn("11");
        bzHurikomiErrInfoListDataSourceBean2.setIrTrhkgk("22000123456");
        bzHurikomiErrInfoListDataSourceBean2.setIrTatenkengk("300000999");
        bzHurikomiErrInfoListDataSourceBean2.setIrKknteijiymd6keta("280121");
        bzHurikomiErrInfoListDataSourceBean2.setIrHwtrhnknymd6keta("280122");
        bzHurikomiErrInfoListDataSourceBean2.setIrTgtkgtkbn("9");
        bzHurikomiErrInfoListDataSourceBean2.setIrTgtkgtno("1072345");
        bzHurikomiErrInfoListDataSourceBean2.setIrRyoutenno("090");
        bzHurikomiErrInfoListDataSourceBean2.setIrHrkmirnincd("0003456789");
        bzHurikomiErrInfoListDataSourceBean2.setIrHrkmirninnm48("01 MOUBAN001 ﾌﾘｺﾐｲﾗｲﾆﾝﾒｲﾌﾘｺﾐｲﾗｲﾆﾝﾒｲ");
        bzHurikomiErrInfoListDataSourceBean2.setIrSimukebanknmkn("シムケギンコウメイ");
        bzHurikomiErrInfoListDataSourceBean2.setIrSimuketennmkn("シムケテンメイ");
        bzHurikomiErrInfoListDataSourceBean2.setIrTekiyounaiyou("摘要内容摘要内容摘要内容");
        bzHurikomiErrInfoListDataSourceBean2.setIrEdiinfo("EDIｼﾞｮｳﾎｳEDIｼﾞｮｳﾎｳ");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){

        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成28年01月21日");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg("金額桁超エラー　銀行：　0009　支店：　101　作成日：　20160121　照会番号：　00023456　エラー項目：　取引前残高");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1("1");
        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd("03");
        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn("2");
        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta("271105");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta("200101");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta("281231");
        bzHurikomiErrInfoListDataSourceBean.setIrBankcd("0009");
        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn("ミツイスミトモ");
        bzHurikomiErrInfoListDataSourceBean.setIrSitencd("101");
        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn("オオサカホンテン");
        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.TTYOKIN);
        bzHurikomiErrInfoListDataSourceBean.setIrKouzano("0000123456");
        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn("コウザメイギニンメイコウザメイギニンメイコウザメイギニンメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("4");
        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn("5");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk("1000001002003");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2("6");
        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino("00023456");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta("280119");
        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta("280120");
        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("7");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("11");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk("22000123456");
        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk("300000999");
        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta("280121");
        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta("280122");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn("8");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno("1072345");
        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno("090");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd("0003456789");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48("01 MOUBAN001 ﾌﾘｺﾐｲﾗｲﾆﾝﾒｲﾌﾘｺﾐｲﾗｲﾆﾝﾒｲ");
        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn("シムケギンコウメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn("シムケテンメイ");
        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou("摘要内容摘要内容摘要内容");
        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo("EDIｼﾞｮｳﾎｳEDIｼﾞｮｳﾎｳ");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean);

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean2 = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean2.setIrErrormsg("日付不正エラー　銀行：　0009　支店：　101　作成日：　20160121　照会番号：　00023456　エラー項目：　勘定日（自）");
        bzHurikomiErrInfoListDataSourceBean2.setIrDatakbn1("2");
        bzHurikomiErrInfoListDataSourceBean2.setIrSyubetucd("03");
        bzHurikomiErrInfoListDataSourceBean2.setIrCdkbn("3");
        bzHurikomiErrInfoListDataSourceBean2.setIrSakuseiymd6keta("271105");
        bzHurikomiErrInfoListDataSourceBean2.setIrKnjyymdfrom6keta("200230");
        bzHurikomiErrInfoListDataSourceBean2.setIrKnjyymdto6keta("281231");
        bzHurikomiErrInfoListDataSourceBean2.setIrBankcd("0009");
        bzHurikomiErrInfoListDataSourceBean2.setIrBanknmkn("ミツイスミトモ");
        bzHurikomiErrInfoListDataSourceBean2.setIrSitencd("101");
        bzHurikomiErrInfoListDataSourceBean2.setIrSitennmkn("オオサカホンテン");
        bzHurikomiErrInfoListDataSourceBean2.setIrYokinkbn(C_YokinKbn.TYOTIKU);
        bzHurikomiErrInfoListDataSourceBean2.setIrKouzano("0000123456");
        bzHurikomiErrInfoListDataSourceBean2.setIrKznmkn("コウザメイギニンメイコウザメイギニンメイコウザメイギニンメイ");
        bzHurikomiErrInfoListDataSourceBean2.setIrKasikosikbn("5");
        bzHurikomiErrInfoListDataSourceBean2.setIrTuutyousysykbn("6");
        bzHurikomiErrInfoListDataSourceBean2.setIrTrhkmaezndk("1001002003");
        bzHurikomiErrInfoListDataSourceBean2.setIrDatakbn2("7");
        bzHurikomiErrInfoListDataSourceBean2.setIrSyoukaino("00023456");
        bzHurikomiErrInfoListDataSourceBean2.setIrKnjyymd6keta("280119");
        bzHurikomiErrInfoListDataSourceBean2.setIrAzkrhrdsymd6keta("280120");
        bzHurikomiErrInfoListDataSourceBean2.setIrIribaraikbn("8");
        bzHurikomiErrInfoListDataSourceBean2.setIrTrhkkbn("11");
        bzHurikomiErrInfoListDataSourceBean2.setIrTrhkgk("22123456");
        bzHurikomiErrInfoListDataSourceBean2.setIrTatenkengk("300999");
        bzHurikomiErrInfoListDataSourceBean2.setIrKknteijiymd6keta("280121");
        bzHurikomiErrInfoListDataSourceBean2.setIrHwtrhnknymd6keta("280122");
        bzHurikomiErrInfoListDataSourceBean2.setIrTgtkgtkbn("9");
        bzHurikomiErrInfoListDataSourceBean2.setIrTgtkgtno("1072345");
        bzHurikomiErrInfoListDataSourceBean2.setIrRyoutenno("090");
        bzHurikomiErrInfoListDataSourceBean2.setIrHrkmirnincd("0003456789");
        bzHurikomiErrInfoListDataSourceBean2.setIrHrkmirninnm48("01 MOUBAN001 ﾌﾘｺﾐｲﾗｲﾆﾝﾒｲﾌﾘｺﾐｲﾗｲﾆﾝﾒｲ");
        bzHurikomiErrInfoListDataSourceBean2.setIrSimukebanknmkn("シムケギンコウメイ");
        bzHurikomiErrInfoListDataSourceBean2.setIrSimuketennmkn("シムケテンメイ");
        bzHurikomiErrInfoListDataSourceBean2.setIrTekiyounaiyou("摘要内容摘要内容摘要内容");
        bzHurikomiErrInfoListDataSourceBean2.setIrEdiinfo("EDIｼﾞｮｳﾎｳEDIｼﾞｮｳﾎｳ");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean2);

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean3 = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean3.setIrErrormsg("コード区分不正エラー　銀行：　0009　支店：　101　作成日：　20160121　照会番号：　00023456　エラー項目：　コード区分");
        bzHurikomiErrInfoListDataSourceBean3.setIrDatakbn1("3");
        bzHurikomiErrInfoListDataSourceBean3.setIrSyubetucd("03");
        bzHurikomiErrInfoListDataSourceBean3.setIrCdkbn("0");
        bzHurikomiErrInfoListDataSourceBean3.setIrSakuseiymd6keta("271105");
        bzHurikomiErrInfoListDataSourceBean3.setIrKnjyymdfrom6keta("200201");
        bzHurikomiErrInfoListDataSourceBean3.setIrKnjyymdto6keta("281231");
        bzHurikomiErrInfoListDataSourceBean3.setIrBankcd("0009");
        bzHurikomiErrInfoListDataSourceBean3.setIrBanknmkn("ミツイスミトモ");
        bzHurikomiErrInfoListDataSourceBean3.setIrSitencd("101");
        bzHurikomiErrInfoListDataSourceBean3.setIrSitennmkn("オオサカホンテン");
        bzHurikomiErrInfoListDataSourceBean3.setIrYokinkbn(C_YokinKbn.HUTUUYUTYO);
        bzHurikomiErrInfoListDataSourceBean3.setIrKouzano("0000123456");
        bzHurikomiErrInfoListDataSourceBean3.setIrKznmkn("コウザメイギニンメイコウザメイギニンメイコウザメイギニンメイ");
        bzHurikomiErrInfoListDataSourceBean3.setIrKasikosikbn("6");
        bzHurikomiErrInfoListDataSourceBean3.setIrTuutyousysykbn("7");
        bzHurikomiErrInfoListDataSourceBean3.setIrTrhkmaezndk("10001002003");
        bzHurikomiErrInfoListDataSourceBean3.setIrDatakbn2("8");
        bzHurikomiErrInfoListDataSourceBean3.setIrSyoukaino("00023456");
        bzHurikomiErrInfoListDataSourceBean3.setIrKnjyymd6keta("280119");
        bzHurikomiErrInfoListDataSourceBean3.setIrAzkrhrdsymd6keta("280120");
        bzHurikomiErrInfoListDataSourceBean3.setIrIribaraikbn("9");
        bzHurikomiErrInfoListDataSourceBean3.setIrTrhkkbn("11");
        bzHurikomiErrInfoListDataSourceBean3.setIrTrhkgk("220123456");
        bzHurikomiErrInfoListDataSourceBean3.setIrTatenkengk("3000999");
        bzHurikomiErrInfoListDataSourceBean3.setIrKknteijiymd6keta("280121");
        bzHurikomiErrInfoListDataSourceBean3.setIrHwtrhnknymd6keta("280122");
        bzHurikomiErrInfoListDataSourceBean3.setIrTgtkgtkbn("4");
        bzHurikomiErrInfoListDataSourceBean3.setIrTgtkgtno("1072345");
        bzHurikomiErrInfoListDataSourceBean3.setIrRyoutenno("090");
        bzHurikomiErrInfoListDataSourceBean3.setIrHrkmirnincd("0003456789");
        bzHurikomiErrInfoListDataSourceBean3.setIrHrkmirninnm48("01 MOUBAN001 ﾌﾘｺﾐｲﾗｲﾆﾝﾒｲﾌﾘｺﾐｲﾗｲﾆﾝﾒｲ");
        bzHurikomiErrInfoListDataSourceBean3.setIrSimukebanknmkn("シムケギンコウメイ");
        bzHurikomiErrInfoListDataSourceBean3.setIrSimuketennmkn("シムケテンメイ");
        bzHurikomiErrInfoListDataSourceBean3.setIrTekiyounaiyou("摘要内容摘要内容摘要内容");
        bzHurikomiErrInfoListDataSourceBean3.setIrEdiinfo("EDIｼﾞｮｳﾎｳEDIｼﾞｮｳﾎｳ");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("平成28年01月22日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd("");


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg("");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1("");
        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd("");
        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn("");
        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrBankcd("");
        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn("");
        bzHurikomiErrInfoListDataSourceBean.setIrSitencd("");
        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn("");
        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(C_YokinKbn.BLNK);
        bzHurikomiErrInfoListDataSourceBean.setIrKouzano("");
        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn("");
        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn("");
        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn("");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk("");
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2("");
        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino("");
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn("");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn("");
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk("");
        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk("");
        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta("");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn("");
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno("");
        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno("");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd("");
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48("");
        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn("");
        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn("");
        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou("");
        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo("");

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
                createReport.createNewReportServiceBean("biz", "", "bzhurikomierrinfolist", C_SyoruiCdKbn.CM_HURIKOMIERRINFOLIST);

        bzHurikomiErrInfoListBean.setIrTyouhyousakuseiymd(null);


        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        BzHurikomiErrInfoListDataSourceBean bzHurikomiErrInfoListDataSourceBean = new BzHurikomiErrInfoListDataSourceBean();

        bzHurikomiErrInfoListDataSourceBean.setIrErrormsg(null);
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn1(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSyubetucd(null);
        bzHurikomiErrInfoListDataSourceBean.setIrCdkbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSakuseiymd6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdfrom6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymdto6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrBankcd(null);
        bzHurikomiErrInfoListDataSourceBean.setIrBanknmkn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSitencd(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSitennmkn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrYokinkbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKouzano(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKznmkn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKasikosikbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTuutyousysykbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkmaezndk(null);
        bzHurikomiErrInfoListDataSourceBean.setIrDatakbn2(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSyoukaino(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKnjyymd6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrAzkrhrdsymd6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrIribaraikbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkkbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTrhkgk(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTatenkengk(null);
        bzHurikomiErrInfoListDataSourceBean.setIrKknteijiymd6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrHwtrhnknymd6keta(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtkbn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTgtkgtno(null);
        bzHurikomiErrInfoListDataSourceBean.setIrRyoutenno(null);
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirnincd(null);
        bzHurikomiErrInfoListDataSourceBean.setIrHrkmirninnm48(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSimukebanknmkn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrSimuketennmkn(null);
        bzHurikomiErrInfoListDataSourceBean.setIrTekiyounaiyou(null);
        bzHurikomiErrInfoListDataSourceBean.setIrEdiinfo(null);

        dataSouceList.add(bzHurikomiErrInfoListDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, bzHurikomiErrInfoListBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}
