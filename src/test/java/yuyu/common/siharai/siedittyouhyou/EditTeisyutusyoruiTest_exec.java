package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiEditTeisyutusyoruiBean;
import yuyu.def.siharai.bean.report.SiEditTeisyutusyoruiDataSourceBean;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご提出書類について編集のメソッド{@link EditTeisyutusyorui#exec(EditTeisyutusyoruiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTeisyutusyoruiTest_exec {
    @Inject
    private EditTeisyutusyorui editTeisyutusyorui;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ご提出書類について編集";

    private final static String sheetName = "テストデータ";

    private static BizCurrency SzkSyomeiHuyouSaikouGk;
    private static BizCurrency SzkSyomeiYouSaikouGk;


    @BeforeClass
    public static void testInit() {
        SzkSyomeiHuyouSaikouGk = YuyuSiharaiConfig.getInstance().getSzkSyomeiHuyouSaikouGk();
        SzkSyomeiYouSaikouGk = YuyuSiharaiConfig.getInstance().getSzkSyomeiYouSaikouGk();
    }

    @AfterClass
    public static void testClear() {
        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(SzkSyomeiHuyouSaikouGk);
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(SzkSyomeiYouSaikouGk);

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTeisyutusyoruiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiTyouhyoumsg());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        try {
            editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(null);

        try {
            editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuSyubetu'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean =
            SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.BLNK);

        try {
            editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuuSyubetu'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B1() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(2001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.ARI);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean2 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "代表選任届３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "代表選任届３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "代表選任届３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "代表選任届３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "代表選任届３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "代表選任届３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "代表選任届３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "代表選任届３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "代表選任届３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "戸籍謄本１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "戸籍謄本１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "戸籍謄本１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "戸籍謄本１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "戸籍謄本１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "戸籍謄本１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "戸籍謄本１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "戸籍謄本１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "戸籍謄本１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "本人確認書類３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "本人確認書類３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "本人確認書類３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "本人確認書類３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "本人確認書類３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "本人確認書類３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "本人確認書類３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "本人確認書類３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "本人確認書類３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "マイナンバー提供書類０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "マイナンバー提供書類０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "マイナンバー提供書類０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "マイナンバー提供書類０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "マイナンバー提供書類０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "マイナンバー提供書類０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "マイナンバー提供書類０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "マイナンバー提供書類０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "マイナンバー提供書類０９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B2() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 3, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書２９", "（ＩＲ）メッセージ９");


        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "本人確認書類５１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "本人確認書類５２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "本人確認書類５３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "本人確認書類５４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "本人確認書類５５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "本人確認書類５６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "本人確認書類５７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "本人確認書類５８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "本人確認書類５９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B3() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 4, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "請求書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "請求書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "請求書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "請求書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "請求書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "請求書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "請求書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "請求書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "請求書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "本人確認書類２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "本人確認書類２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "本人確認書類２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "本人確認書類２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "本人確認書類２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "本人確認書類２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "本人確認書類２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "本人確認書類２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "本人確認書類２９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B5() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(10000000));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B7() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B8() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(0);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.UKTSBARI);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.HHKN);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 3, "件数");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean2 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "代表選任届３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "代表選任届３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "代表選任届３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "代表選任届３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "代表選任届３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "代表選任届３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "代表選任届３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "代表選任届３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "代表選任届３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "戸籍謄本２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "戸籍謄本２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "戸籍謄本２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "戸籍謄本２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "戸籍謄本２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "戸籍謄本２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "戸籍謄本２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "戸籍謄本２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "戸籍謄本２９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_B12() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000000));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_B13() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(2999999));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_B14() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(10000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_B15() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(10000001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 3, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "請求書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "請求書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "請求書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "請求書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "請求書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "請求書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "請求書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "請求書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "請求書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "本人確認書類１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "本人確認書類１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "本人確認書類１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "本人確認書類１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "本人確認書類１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "本人確認書類１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "本人確認書類１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "本人確認書類１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "本人確認書類１９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_B16() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000000));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_B17() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(2999999));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_B18() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_B19() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(10000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_B20() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(1);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.UKTHONNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(10000000));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 5, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本４９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "本人確認書類４１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "本人確認書類４２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "本人確認書類４３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "本人確認書類４４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "本人確認書類４５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "本人確認書類４６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "本人確認書類４７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "本人確認書類４８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "本人確認書類４９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_B21() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.SOUZOKUNIN);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(2001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 4, "件数");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean2 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "代表選任届３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "代表選任届３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "代表選任届３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "代表選任届３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "代表選任届３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "代表選任届３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "代表選任届３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "代表選任届３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "代表選任届３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "戸籍謄本１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "戸籍謄本１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "戸籍謄本１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "戸籍謄本１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "戸籍謄本１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "戸籍謄本１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "戸籍謄本１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "戸籍謄本１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "戸籍謄本１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "本人確認書類２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "本人確認書類２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "本人確認書類２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "本人確認書類２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "本人確認書類２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "本人確認書類２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "本人確認書類２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "本人確認書類２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "本人確認書類２９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(211)
    @Transactional
    public void testExec_B22() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.KYKDAIRININ);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setKykdrknHtdjyt(C_KykdrknHtdjytKbn.BLNK);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 8, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "請求書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "請求書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "請求書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "請求書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "請求書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "請求書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "請求書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "請求書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "請求書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "契約者診断書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "契約者診断書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "契約者診断書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "契約者診断書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "契約者診断書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "契約者診断書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "契約者診断書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "契約者診断書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "契約者診断書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "代表選任届３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "代表選任届３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "代表選任届３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "代表選任届３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "代表選任届３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "代表選任届３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "代表選任届３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "代表選任届３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "代表選任届３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "事情届兼誓約書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "事情届兼誓約書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "事情届兼誓約書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "事情届兼誓約書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "事情届兼誓約書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "事情届兼誓約書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "事情届兼誓約書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "事情届兼誓約書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "事情届兼誓約書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean7 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(5);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg1(), "戸籍謄本１２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg2(), "戸籍謄本１２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg3(), "戸籍謄本１２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg4(), "戸籍謄本１２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg5(), "戸籍謄本１２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg6(), "戸籍謄本１２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg7(), "戸籍謄本１２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg8(), "戸籍謄本１２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg9(), "戸籍謄本１２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean8 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(6);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg1(), "契約者代理請求要件確認書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg2(), "契約者代理請求要件確認書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg3(), "契約者代理請求要件確認書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg4(), "契約者代理請求要件確認書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg5(), "契約者代理請求要件確認書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg6(), "契約者代理請求要件確認書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg7(), "契約者代理請求要件確認書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg8(), "契約者代理請求要件確認書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg9(), "契約者代理請求要件確認書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean9 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(7);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg1(), "本人確認書類８１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg2(), "本人確認書類８２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg3(), "本人確認書類８３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg4(), "本人確認書類８４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg5(), "本人確認書類８５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg6(), "本人確認書類８６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg7(), "本人確認書類８７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg8(), "本人確認書類８８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg9(), "本人確認書類８９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(212)
    @Transactional
    public void testExec_B23() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.KYKDAIRININ);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setKykdrknHtdjyt(C_KykdrknHtdjytKbn.SETTEI);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 6, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "事情届兼誓約書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "事情届兼誓約書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "事情届兼誓約書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "事情届兼誓約書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "事情届兼誓約書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "事情届兼誓約書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "事情届兼誓約書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "事情届兼誓約書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "事情届兼誓約書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "戸籍謄本１２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "戸籍謄本１２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "戸籍謄本１２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "戸籍謄本１２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "戸籍謄本１２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "戸籍謄本１２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "戸籍謄本１２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "戸籍謄本１２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "戸籍謄本１２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "契約者代理請求要件確認書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "契約者代理請求要件確認書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "契約者代理請求要件確認書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "契約者代理請求要件確認書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "契約者代理請求要件確認書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "契約者代理請求要件確認書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "契約者代理請求要件確認書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "契約者代理請求要件確認書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "契約者代理請求要件確認書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean7 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(5);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg1(), "本人確認書類８１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg2(), "本人確認書類８２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg3(), "本人確認書類８３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg4(), "本人確認書類８４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg5(), "本人確認書類８５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg6(), "本人確認書類８６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg7(), "本人確認書類８７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg8(), "本人確認書類８８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg9(), "本人確認書類８９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(213)
    @Transactional
    public void testExec_B24() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(false);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.HOUJIN);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setKykdrknHtdjyt(C_KykdrknHtdjytKbn.BLNK);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 3, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "本人確認書類５１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "本人確認書類５２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "本人確認書類５３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "本人確認書類５４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "本人確認書類５５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "本人確認書類５６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "本人確認書類５７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "本人確認書類５８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "本人確認書類５９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(214)
    @Transactional
    public void testExec_B25() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.KYKDAIRININ);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.NONE);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(true);
        editTeisyutusyoruiBean.setKykdrknHtdjyt(C_KykdrknHtdjytKbn.BLNK);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 8, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "精算金振込依頼書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "精算金振込依頼書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "精算金振込依頼書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "精算金振込依頼書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "精算金振込依頼書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "精算金振込依頼書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "精算金振込依頼書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "精算金振込依頼書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "精算金振込依頼書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "診断書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "診断書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "診断書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "診断書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "診断書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "診断書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "診断書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "診断書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "診断書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "契約者診断書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "契約者診断書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "契約者診断書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "契約者診断書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "契約者診断書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "契約者診断書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "契約者診断書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "契約者診断書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "契約者診断書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "代表選任届１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "代表選任届１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "代表選任届１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "代表選任届１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "代表選任届１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "代表選任届１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "代表選任届１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "代表選任届１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "代表選任届１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "事情届兼誓約書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "事情届兼誓約書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "事情届兼誓約書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "事情届兼誓約書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "事情届兼誓約書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "事情届兼誓約書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "事情届兼誓約書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "事情届兼誓約書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "事情届兼誓約書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean7 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(5);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg1(), "戸籍謄本１２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg2(), "戸籍謄本１２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg3(), "戸籍謄本１２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg4(), "戸籍謄本１２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg5(), "戸籍謄本１２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg6(), "戸籍謄本１２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg7(), "戸籍謄本１２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg8(), "戸籍謄本１２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg9(), "戸籍謄本１２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean8 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(6);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg1(), "契約者代理請求要件確認書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg2(), "契約者代理請求要件確認書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg3(), "契約者代理請求要件確認書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg4(), "契約者代理請求要件確認書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg5(), "契約者代理請求要件確認書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg6(), "契約者代理請求要件確認書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg7(), "契約者代理請求要件確認書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg8(), "契約者代理請求要件確認書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg9(), "契約者代理請求要件確認書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean9 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(7);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg1(), "本人確認書類８１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg2(), "本人確認書類８２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg3(), "本人確認書類８３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg4(), "本人確認書類８４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg5(), "本人確認書類８５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg6(), "本人確認書類８６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg7(), "本人確認書類８７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg8(), "本人確認書類８８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean9.getIrMsg9(), "本人確認書類８９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(215)
    @Transactional
    public void testExec_B26() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setKykHhknDou(true);
        editTeisyutusyoruiBean.setSbuktNin(2);
        editTeisyutusyoruiBean.setMousideninKbn(C_MousideninKbn.KYKDAIRININ);
        editTeisyutusyoruiBean.setUketorininsibouUmukbn(C_UketorininSibouUmuKbn.BLNK);
        editTeisyutusyoruiBean.setKyksyasibouUmukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setNstkhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setStdrsktkyhkUmu(C_UmuKbn.ARI);
        editTeisyutusyoruiBean.setUktKbn(C_UktKbn.KYK);
        editTeisyutusyoruiBean.setHokenKngk(BizCurrency.valueOf(3000001));
        editTeisyutusyoruiBean.setJisatuMenseki(false);
        editTeisyutusyoruiBean.setKykdrknHtdjyt(C_KykdrknHtdjytKbn.BLNK);
        editTeisyutusyoruiBean.setMynumbertksUmuKbn(C_UmuKbn.NONE);

        YuyuSiharaiConfig.getInstance().setSzkSyomeiHuyouSaikouGk(BizCurrency.valueOf(3000000));
        YuyuSiharaiConfig.getInstance().setSzkSyomeiYouSaikouGk(BizCurrency.valueOf(10000000));

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 7, "件数");
        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "契約者診断書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "契約者診断書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "契約者診断書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "契約者診断書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "契約者診断書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "契約者診断書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "契約者診断書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "契約者診断書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "契約者診断書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "代表選任届３１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "代表選任届３２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "代表選任届３３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "代表選任届３４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "代表選任届３５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "代表選任届３６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "代表選任届３７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "代表選任届３８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "代表選任届３９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(3);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg1(), "事情届兼誓約書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg2(), "事情届兼誓約書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg3(), "事情届兼誓約書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg4(), "事情届兼誓約書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg5(), "事情届兼誓約書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg6(), "事情届兼誓約書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg7(), "事情届兼誓約書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg8(), "事情届兼誓約書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean5.getIrMsg9(), "事情届兼誓約書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(4);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg1(), "戸籍謄本１２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg2(), "戸籍謄本１２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg3(), "戸籍謄本１２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg4(), "戸籍謄本１２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg5(), "戸籍謄本１２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg6(), "戸籍謄本１２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg7(), "戸籍謄本１２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg8(), "戸籍謄本１２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean6.getIrMsg9(), "戸籍謄本１２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean7 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(5);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg1(), "契約者代理請求要件確認書０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg2(), "契約者代理請求要件確認書０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg3(), "契約者代理請求要件確認書０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg4(), "契約者代理請求要件確認書０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg5(), "契約者代理請求要件確認書０５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg6(), "契約者代理請求要件確認書０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg7(), "契約者代理請求要件確認書０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg8(), "契約者代理請求要件確認書０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean7.getIrMsg9(), "契約者代理請求要件確認書０９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean8 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(6);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg1(), "本人確認書類８１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg2(), "本人確認書類８２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg3(), "本人確認書類８３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg4(), "本人確認書類８４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg5(), "本人確認書類８５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg6(), "本人確認書類８６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg7(), "本人確認書類８７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg8(), "本人確認書類８８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean8.getIrMsg9(), "本人確認書類８９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_C1() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setJikojyoukyouhksUmu(C_UmuKbn.ARI);

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 3, "件数");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean2 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(1);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg1(), "事故状況報告書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg2(), "事故状況報告書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg3(), "事故状況報告書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg4(), "事故状況報告書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg5(), "事故状況報告書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg6(), "事故状況報告書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg7(), "事故状況報告書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg8(), "事故状況報告書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean3.getIrMsg9(), "事故状況報告書１９", "（ＩＲ）メッセージ９");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(2);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg1(), "交通事故証明書１１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg2(), "交通事故証明書１２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg3(), "交通事故証明書１３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg4(), "交通事故証明書１４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg5(), "交通事故証明書１５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg6(), "交通事故証明書１６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg7(), "交通事故証明書１７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg8(), "交通事故証明書１８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean4.getIrMsg9(), "交通事故証明書１９", "（ＩＲ）メッセージ９");

    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_C2() {
        EditTeisyutusyoruiBean editTeisyutusyoruiBean = SWAKInjector.getInstance(EditTeisyutusyoruiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        editTeisyutusyoruiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        editTeisyutusyoruiBean.setSyoNo("10000000001");
        editTeisyutusyoruiBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        editTeisyutusyoruiBean.setJikojyoukyouhksUmu(C_UmuKbn.NONE);

        ReportServicesBean reportServicesBean = editTeisyutusyorui.exec(editTeisyutusyoruiBean);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "10000000001", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151212), "処理日付");

        SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean = (SiEditTeisyutusyoruiBean) (reportServicesBean
            .getParamObjectsData()
            .get(C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue()))[0];
        exStringEquals(siEditTeisyutusyoruiBean.getIrTyouhyousakuseiymd(), "２０１５年１２月１２日", "（ＩＲ）帳票作成日");
        exStringEquals(siEditTeisyutusyoruiBean.getIrSyono(), "10000000001", "（ＩＲ）証券番号");

        List<IReportDataSouceBean> detailBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.HK_TEISYUTUSYORUI.getValue());
        exNumericEquals(detailBeanLst.size(), 1, "件数");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean2 = (SiEditTeisyutusyoruiDataSourceBean)
            detailBeanLst.get(0);
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg1(), "診断書２１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg2(), "診断書２２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg3(), "診断書２３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg4(), "診断書２４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg5(), "診断書２５", "（ＩＲ）メッセージ５");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg6(), "診断書２６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg7(), "診断書２７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg8(), "診断書２８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditTeisyutusyoruiDataSourceBean2.getIrMsg9(), "診断書２９", "（ＩＲ）メッセージ９");

    }
}
