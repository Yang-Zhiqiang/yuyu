package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_HuridenYouHassouKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhou#furikaeDenPageList()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_furikaeDenPageList{

    @Inject
    private BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_振替伝票情報";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzFurikaeDenpyouJouhouTest_furikaeDenPageList.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());
    }

    @Test
    @TestOrder(10)
    public void testFurikaeDenPageList_A1() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("564");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage1.getTorihikiNo(), "11110L", "取引番号");

        exNumericEquals(furikaeDenpyouPage1.getPageNo(), 1, "ページ番号");

        exStringEquals(furikaeDenpyouPage1.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage1.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiKurikosiGk(), BizCurrency.valueOf(0), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariKurikosiGk(), BizCurrency.valueOf(0), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage1.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr1[0], "name1", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr1[1], "", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr1[2], "", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr1[3], "", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr1[0], "name2", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr1[1], "", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr1[2], "", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr1[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr1 = furikaeDenpyouPage1.getKasiGks();

        exBizCalcbleEquals(kasigksArr1[0], BizCurrency.valueOf(50), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr1[1], BizCurrency.valueOf(0), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr1[2], BizCurrency.valueOf(0), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr1[3], BizCurrency.valueOf(0), "貸方金額配列[3]");


        BizCurrency[] karigksArr1 = furikaeDenpyouPage1.getKariGks();

        exBizCalcbleEquals(karigksArr1[0], BizCurrency.valueOf(50), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr1[1], BizCurrency.valueOf(0), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr1[2], BizCurrency.valueOf(0), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr1[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr1 = furikaeDenpyouPage1.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr1[0], "project1", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr1[1], "", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr1[2], "", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr1[3], "", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr1 = furikaeDenpyouPage1.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr1[0], "project2", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr1[1], "", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr1[2], "", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr1[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr1 = furikaeDenpyouPage1.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr1[0], "漢字摘要一", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr1[1], "", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr1[2], "", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr1[3], "", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr1 = furikaeDenpyouPage1.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr1[0], "漢字摘要二", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr1[1], "", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr1[2], "", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr1[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiGoukeiGk(), BizCurrency.valueOf(50), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariGoukeiGk(), BizCurrency.valueOf(50), "借方合計金額");

        exStringEquals(furikaeDenpyouPage1.getKjKariKurikosiGkHyjKm(), "合計", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage1.getKjKasiKurikosiGkHyjKm(), "合計", "漢字貸方繰越合計表示項目");
    }

    @Test
    @TestOrder(20)
    public void testFurikaeDenPageList_A2() {
        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(10));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("摘要一");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(20));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("摘要二");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean3 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean3.setDenKanjoKamokuNm("name3");
        bean3.setKinGk(BizCurrency.valueOf(30));
        bean3.setTekiyouKm("project3");
        bean3.setKjTekiyouKm("摘要三");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean3, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean4 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean4.setDenKanjoKamokuNm("name4");
        bean4.setKinGk(BizCurrency.valueOf(40));
        bean4.setTekiyouKm("project4");
        bean4.setKjTekiyouKm("摘要四");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean4, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean5 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean5.setDenKanjoKamokuNm("name5");
        bean5.setKinGk(BizCurrency.valueOf(50));
        bean5.setTekiyouKm("project5");
        bean5.setKjTekiyouKm("摘要五");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean5, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean6 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean6.setDenKanjoKamokuNm("name6");
        bean6.setKinGk(BizCurrency.valueOf(60));
        bean6.setTekiyouKm("project6");
        bean6.setKjTekiyouKm("摘要六");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean6, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean7 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean7.setDenKanjoKamokuNm("name7");
        bean7.setKinGk(BizCurrency.valueOf(70));
        bean7.setTekiyouKm("project7");
        bean7.setKjTekiyouKm("摘要七");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean7, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean8 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean8.setDenKanjoKamokuNm("name8");
        bean8.setKinGk(BizCurrency.valueOf(80));
        bean8.setTekiyouKm("project8");
        bean8.setKjTekiyouKm("摘要八");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean8, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean9 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean9.setDenKanjoKamokuNm("name9");
        bean9.setKinGk(BizCurrency.valueOf(90));
        bean9.setTekiyouKm("project9");
        bean9.setKjTekiyouKm("摘要九");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean9, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean10 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean10.setDenKanjoKamokuNm("name10");
        bean10.setKinGk(BizCurrency.valueOf(100));
        bean10.setTekiyouKm("project10");
        bean10.setKjTekiyouKm("摘要十");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean10, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean11 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean11.setDenKanjoKamokuNm("name11");
        bean11.setKinGk(BizCurrency.valueOf(110));
        bean11.setTekiyouKm("project11");
        bean11.setKjTekiyouKm("摘要十一");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean11, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean12 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean12.setDenKanjoKamokuNm("name12");
        bean12.setKinGk(BizCurrency.valueOf(120));
        bean12.setTekiyouKm("project12");
        bean12.setKjTekiyouKm("摘要十二");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean12, C_TaisyakuKbn.KARIKATA);

        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("564");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(false);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();
        exNumericEquals(size, 3, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage1.getTorihikiNo(), "11110", "取引番号");

        exNumericEquals(furikaeDenpyouPage1.getPageNo(), 1, "ページ番号");

        exStringEquals(furikaeDenpyouPage1.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage1.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiKurikosiGk(), BizCurrency.valueOf(0), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariKurikosiGk(), BizCurrency.valueOf(0), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage1.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        exBooleanEquals(furikaeDenpyouPage1.isGoukeiFlg(), false, "合計フラグ");

        String[] kjkasikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr1[0], "name1", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr1[1], "name2", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr1[2], "name3", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr1[3], "name4", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr1[0], "name10", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr1[1], "name11", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr1[2], "name12", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr1[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr1 = furikaeDenpyouPage1.getKasiGks();

        exBizCalcbleEquals(kasigksArr1[0], BizCurrency.valueOf(10), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr1[1], BizCurrency.valueOf(20), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr1[2], BizCurrency.valueOf(30), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr1[3], BizCurrency.valueOf(40), "貸方金額配列[3]");


        BizCurrency[] karigksArr1 = furikaeDenpyouPage1.getKariGks();

        exBizCalcbleEquals(karigksArr1[0], BizCurrency.valueOf(100), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr1[1], BizCurrency.valueOf(110), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr1[2], BizCurrency.valueOf(120), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr1[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr1 = furikaeDenpyouPage1.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr1[0], "project1", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr1[1], "project2", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr1[2], "project3", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr1[3], "project4", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr1 = furikaeDenpyouPage1.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr1[0], "project10", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr1[1], "project11", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr1[2], "project12", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr1[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr1 = furikaeDenpyouPage1.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr1[0], "摘要一", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr1[1], "摘要二", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr1[2], "摘要三", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr1[3], "摘要四", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr1 = furikaeDenpyouPage1.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr1[0], "摘要十", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr1[1], "摘要十一", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr1[2], "摘要十二", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr1[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiGoukeiGk(), BizCurrency.valueOf(100), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariGoukeiGk(), BizCurrency.valueOf(330), "借方合計金額");

        exStringEquals(furikaeDenpyouPage1.getKjKariKurikosiGkHyjKm(), "繰越", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage1.getKjKasiKurikosiGkHyjKm(), "繰越", "漢字貸方繰越合計表示項目");

        exBooleanEquals(furikaeDenpyouPage1.isGoukeiFlg(), false, "合計フラグ");


        FurikaeDenpyouPage furikaeDenpyouPage2 = resultLst.get(1);

        exStringEquals(furikaeDenpyouPage2.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage2.getTorihikiNo(), "11110", "取引番号");

        exNumericEquals(furikaeDenpyouPage2.getPageNo(), 2, "ページ番号");

        exStringEquals(furikaeDenpyouPage2.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage2.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage2.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage2.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage2.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage2.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage2.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKasiKurikosiGk(), BizCurrency.valueOf(100), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKariKurikosiGk(), BizCurrency.valueOf(330), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage2.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr2 = furikaeDenpyouPage2.getKjKasiKanjoukamokuNms();
        exStringEquals(kjkasikanjoukamokunmsArr2[0], "name5", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr2[1], "name6", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr2[2], "name7", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr2[3], "name8", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr2 = furikaeDenpyouPage2.getKjKariKanjoukamokuNms();
        exStringEquals(kjkarikanjoukamokunmsArr2[0], "", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr2[1], "", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr2[2], "", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr2[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr2 = furikaeDenpyouPage2.getKasiGks();

        exBizCalcbleEquals(kasigksArr2[0], BizCurrency.valueOf(50), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr2[1], BizCurrency.valueOf(60), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr2[2], BizCurrency.valueOf(70), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr2[3], BizCurrency.valueOf(80), "貸方金額配列[3]");

        BizCurrency[] karigksArr2 = furikaeDenpyouPage2.getKariGks();

        exBizCalcbleEquals(karigksArr2[0], BizCurrency.valueOf(0), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr2[1], BizCurrency.valueOf(0), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr2[2], BizCurrency.valueOf(0), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr2[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr2 = furikaeDenpyouPage2.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr2[0], "project5", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr2[1], "project6", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr2[2], "project7", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr2[3], "project8", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr2 = furikaeDenpyouPage2.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr2[0], "", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr2[1], "", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr2[2], "", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr2[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr2 = furikaeDenpyouPage2.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr2[0], "摘要五", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr2[1], "摘要六", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr2[2], "摘要七", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr2[3], "摘要八", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr2 = furikaeDenpyouPage2.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr2[0], "", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr2[1], "", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr2[2], "", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr2[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKasiGoukeiGk(), BizCurrency.valueOf(360), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKariGoukeiGk(), BizCurrency.valueOf(330), "借方合計金額");

        exStringEquals(furikaeDenpyouPage2.getKjKariKurikosiGkHyjKm(), "繰越", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage2.getKjKasiKurikosiGkHyjKm(), "繰越", "漢字貸方繰越合計表示項目");

        exBooleanEquals(furikaeDenpyouPage2.isGoukeiFlg(), false, "合計フラグ");


        FurikaeDenpyouPage furikaeDenpyouPage3 = resultLst.get(2);

        exStringEquals(furikaeDenpyouPage3.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage3.getTorihikiNo(), "11110", "取引番号");

        exNumericEquals(furikaeDenpyouPage3.getPageNo(), 3, "ページ番号");

        exStringEquals(furikaeDenpyouPage3.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage3.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage3.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage3.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage3.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage3.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage3.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKasiKurikosiGk(), BizCurrency.valueOf(360), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKariKurikosiGk(), BizCurrency.valueOf(330), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage3.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr3 = furikaeDenpyouPage3.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr3[0], "name9", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr3[1], "", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr3[2], "", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr3[3], "", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr3 = furikaeDenpyouPage3.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr3[0], "", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr3[1], "", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr3[2], "", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr3[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr3 = furikaeDenpyouPage3.getKasiGks();

        exBizCalcbleEquals(kasigksArr3[0], BizCurrency.valueOf(90), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr3[1], BizCurrency.valueOf(0), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr3[2], BizCurrency.valueOf(0), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr3[3], BizCurrency.valueOf(0), "貸方金額配列[3]");

        BizCurrency[] karigksArr3 = furikaeDenpyouPage3.getKariGks();

        exBizCalcbleEquals(karigksArr3[0], BizCurrency.valueOf(0), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr3[1], BizCurrency.valueOf(0), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr3[2], BizCurrency.valueOf(0), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr3[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr3 = furikaeDenpyouPage3.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr3[0], "project9", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr3[1], "", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr3[2], "", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr3[3], "", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr3 = furikaeDenpyouPage3.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr3[0], "", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr3[1], "", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr3[2], "", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr3[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr3 = furikaeDenpyouPage3.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr3[0], "摘要九", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr3[1], "", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr3[2], "", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr3[3], "", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr3 = furikaeDenpyouPage3.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr3[0], "", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr3[1], "", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr3[2], "", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr3[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKasiGoukeiGk(), BizCurrency.valueOf(450), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKariGoukeiGk(), BizCurrency.valueOf(330), "借方合計金額");

        exStringEquals(furikaeDenpyouPage3.getKjKariKurikosiGkHyjKm(), "合計", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage3.getKjKasiKurikosiGkHyjKm(), "合計", "漢字貸方繰越合計表示項目");

        exBooleanEquals(furikaeDenpyouPage3.isGoukeiFlg(), true, "合計フラグ");

    }

    @Test
    @TestOrder(20)
    public void testFurikaeDenPageList_A3() {
        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(100));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("摘要一");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(200));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("摘要二");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean3 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean3.setDenKanjoKamokuNm("name3");
        bean3.setKinGk(BizCurrency.valueOf(300));
        bean3.setTekiyouKm("project3");
        bean3.setKjTekiyouKm("摘要三");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean3, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean4 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean4.setDenKanjoKamokuNm("name4");
        bean4.setKinGk(BizCurrency.valueOf(400));
        bean4.setTekiyouKm("project4");
        bean4.setKjTekiyouKm("摘要四");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean4, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean5 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean5.setDenKanjoKamokuNm("name5");
        bean5.setKinGk(BizCurrency.valueOf(500));
        bean5.setTekiyouKm("project5");
        bean5.setKjTekiyouKm("摘要五");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean5, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean6 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean6.setDenKanjoKamokuNm("name6");
        bean6.setKinGk(BizCurrency.valueOf(600));
        bean6.setTekiyouKm("project6");
        bean6.setKjTekiyouKm("摘要六");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean6, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean7 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean7.setDenKanjoKamokuNm("name7");
        bean7.setKinGk(BizCurrency.valueOf(700));
        bean7.setTekiyouKm("project7");
        bean7.setKjTekiyouKm("摘要七");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean7, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean8 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean8.setDenKanjoKamokuNm("name8");
        bean8.setKinGk(BizCurrency.valueOf(800));
        bean8.setTekiyouKm("project8");
        bean8.setKjTekiyouKm("摘要八");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean8, C_TaisyakuKbn.KASIKATA);

        FurikaeDenpyouSiwakeMeisai bean9 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean9.setDenKanjoKamokuNm("name9");
        bean9.setKinGk(BizCurrency.valueOf(900));
        bean9.setTekiyouKm("project9");
        bean9.setKjTekiyouKm("摘要九");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean9, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(C_TaisyakuKbn.KASIKATA, BizCurrency.valueOf(100));

        FurikaeDenpyouSiwakeMeisai bean10 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean10.setDenKanjoKamokuNm("name10");
        bean10.setKinGk(BizCurrency.valueOf(900));
        bean10.setTekiyouKm("project10");
        bean10.setKjTekiyouKm("摘要十");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean10, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean11 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean11.setDenKanjoKamokuNm("name11");
        bean11.setKinGk(BizCurrency.valueOf(800));
        bean11.setTekiyouKm("project11");
        bean11.setKjTekiyouKm("摘要十一");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean11, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean12 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean12.setDenKanjoKamokuNm("name12");
        bean12.setKinGk(BizCurrency.valueOf(700));
        bean12.setTekiyouKm("project12");
        bean12.setKjTekiyouKm("摘要十二");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean12, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean13 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean13.setDenKanjoKamokuNm("name13");
        bean13.setKinGk(BizCurrency.valueOf(600));
        bean13.setTekiyouKm("project13");
        bean13.setKjTekiyouKm("摘要十三");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean13, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean14 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean14.setDenKanjoKamokuNm("name14");
        bean14.setKinGk(BizCurrency.valueOf(500));
        bean14.setTekiyouKm("project14");
        bean14.setKjTekiyouKm("摘要十四");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean14, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean15 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean15.setDenKanjoKamokuNm("name15");
        bean15.setKinGk(BizCurrency.valueOf(400));
        bean15.setTekiyouKm("project15");
        bean15.setKjTekiyouKm("摘要十五");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean15, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean16 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean16.setDenKanjoKamokuNm("name16");
        bean16.setKinGk(BizCurrency.valueOf(300));
        bean16.setTekiyouKm("project16");
        bean16.setKjTekiyouKm("摘要十六");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean16, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean17 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean17.setDenKanjoKamokuNm("name17");
        bean17.setKinGk(BizCurrency.valueOf(200));
        bean17.setTekiyouKm("project17");
        bean17.setKjTekiyouKm("摘要十七");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean17, C_TaisyakuKbn.KARIKATA);

        FurikaeDenpyouSiwakeMeisai bean18 = SWAKInjector.getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean18.setDenKanjoKamokuNm("name18");
        bean18.setKinGk(BizCurrency.valueOf(50));
        bean18.setTekiyouKm("project18");
        bean18.setKjTekiyouKm("摘要十八");
        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean18, C_TaisyakuKbn.KARIKATA);

        bzFurikaeDenpyouJouhou.seisanLastSiwakeMeisai(C_TaisyakuKbn.KARIKATA, BizCurrency.valueOf(150));

        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("564");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(false);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 3, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage1.getTorihikiNo(), "11110", "取引番号");

        exNumericEquals(furikaeDenpyouPage1.getPageNo(), 1, "ページ番号");

        exStringEquals(furikaeDenpyouPage1.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage1.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiKurikosiGk(), BizCurrency.valueOf(0), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariKurikosiGk(), BizCurrency.valueOf(0), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage1.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr1[0], "name1", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr1[1], "name2", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr1[2], "name3", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr1[3], "name4", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr1[0], "name10", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr1[1], "name11", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr1[2], "name12", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr1[3], "name13", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr1 = furikaeDenpyouPage1.getKasiGks();

        exBizCalcbleEquals(kasigksArr1[0], BizCurrency.valueOf(100), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr1[1], BizCurrency.valueOf(200), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr1[2], BizCurrency.valueOf(300), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr1[3], BizCurrency.valueOf(400), "貸方金額配列[3]");


        BizCurrency[] karigksArr1 = furikaeDenpyouPage1.getKariGks();

        exBizCalcbleEquals(karigksArr1[0], BizCurrency.valueOf(900), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr1[1], BizCurrency.valueOf(800), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr1[2], BizCurrency.valueOf(700), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr1[3], BizCurrency.valueOf(600), "借方金額配列[3]");

        String[] kasitekiyoukmsArr1 = furikaeDenpyouPage1.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr1[0], "project1", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr1[1], "project2", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr1[2], "project3", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr1[3], "project4", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr1 = furikaeDenpyouPage1.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr1[0], "project10", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr1[1], "project11", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr1[2], "project12", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr1[3], "project13", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr1 = furikaeDenpyouPage1.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr1[0], "摘要一", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr1[1], "摘要二", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr1[2], "摘要三", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr1[3], "摘要四", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr1 = furikaeDenpyouPage1.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr1[0], "摘要十", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr1[1], "摘要十一", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr1[2], "摘要十二", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr1[3], "摘要十三", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiGoukeiGk(), BizCurrency.valueOf(1000), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariGoukeiGk(), BizCurrency.valueOf(3000), "借方合計金額");

        exStringEquals(furikaeDenpyouPage1.getKjKariKurikosiGkHyjKm(), "繰越", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage1.getKjKasiKurikosiGkHyjKm(), "繰越", "漢字貸方繰越合計表示項目");

        FurikaeDenpyouPage furikaeDenpyouPage2 = resultLst.get(1);

        exStringEquals(furikaeDenpyouPage2.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage2.getTorihikiNo(), "11110", "取引番号");

        exNumericEquals(furikaeDenpyouPage2.getPageNo(), 2, "ページ番号");

        exStringEquals(furikaeDenpyouPage2.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage2.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage2.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage2.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage2.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage2.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage2.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKasiKurikosiGk(), BizCurrency.valueOf(1000), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKariKurikosiGk(), BizCurrency.valueOf(3000), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage2.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr2 = furikaeDenpyouPage2.getKjKasiKanjoukamokuNms();
        exStringEquals(kjkasikanjoukamokunmsArr2[0], "name5", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr2[1], "name6", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr2[2], "name7", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr2[3], "name8", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr2 = furikaeDenpyouPage2.getKjKariKanjoukamokuNms();
        exStringEquals(kjkarikanjoukamokunmsArr2[0], "name14", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr2[1], "name15", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr2[2], "name16", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr2[3], "name17", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr2 = furikaeDenpyouPage2.getKasiGks();

        exBizCalcbleEquals(kasigksArr2[0], BizCurrency.valueOf(500), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr2[1], BizCurrency.valueOf(600), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr2[2], BizCurrency.valueOf(700), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr2[3], BizCurrency.valueOf(800), "貸方金額配列[3]");

        BizCurrency[] karigksArr2 = furikaeDenpyouPage2.getKariGks();

        exBizCalcbleEquals(karigksArr2[0], BizCurrency.valueOf(500), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr2[1], BizCurrency.valueOf(400), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr2[2], BizCurrency.valueOf(300), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr2[3], BizCurrency.valueOf(200), "借方金額配列[3]");

        String[] kasitekiyoukmsArr2 = furikaeDenpyouPage2.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr2[0], "project5", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr2[1], "project6", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr2[2], "project7", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr2[3], "project8", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr2 = furikaeDenpyouPage2.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr2[0], "project14", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr2[1], "project15", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr2[2], "project16", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr2[3], "project17", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr2 = furikaeDenpyouPage2.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr2[0], "摘要五", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr2[1], "摘要六", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr2[2], "摘要七", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr2[3], "摘要八", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr2 = furikaeDenpyouPage2.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr2[0], "摘要十四", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr2[1], "摘要十五", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr2[2], "摘要十六", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr2[3], "摘要十七", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKasiGoukeiGk(), BizCurrency.valueOf(3600), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage2.getKariGoukeiGk(), BizCurrency.valueOf(4400), "借方合計金額");

        exStringEquals(furikaeDenpyouPage2.getKjKariKurikosiGkHyjKm(), "繰越", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage2.getKjKasiKurikosiGkHyjKm(), "繰越", "漢字貸方繰越合計表示項目");


        FurikaeDenpyouPage furikaeDenpyouPage3 = resultLst.get(2);

        exStringEquals(furikaeDenpyouPage3.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage3.getTorihikiNo(), "11110", "取引番号");

        exNumericEquals(furikaeDenpyouPage3.getPageNo(), 3, "ページ番号");

        exStringEquals(furikaeDenpyouPage3.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage3.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage3.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage3.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage3.getKjTantoukaNm(), "漢字組織名一", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage3.getKjTantoukaCd(), "D", "漢字担当コード");

        exStringEquals(furikaeDenpyouPage3.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKasiKurikosiGk(), BizCurrency.valueOf(3600), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKariKurikosiGk(), BizCurrency.valueOf(4400), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage3.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr3 = furikaeDenpyouPage3.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr3[0], "name9", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr3[1], "", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr3[2], "", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr3[3], "", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr3 = furikaeDenpyouPage3.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr3[0], "name18", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr3[1], "", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr3[2], "", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr3[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr3 = furikaeDenpyouPage3.getKasiGks();

        exBizCalcbleEquals(kasigksArr3[0], BizCurrency.valueOf(1000), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr3[1], BizCurrency.valueOf(0), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr3[2], BizCurrency.valueOf(0), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr3[3], BizCurrency.valueOf(0), "貸方金額配列[3]");

        BizCurrency[] karigksArr3 = furikaeDenpyouPage3.getKariGks();

        exBizCalcbleEquals(karigksArr3[0], BizCurrency.valueOf(200), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr3[1], BizCurrency.valueOf(0), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr3[2], BizCurrency.valueOf(0), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr3[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr3 = furikaeDenpyouPage3.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr3[0], "project9", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr3[1], "", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr3[2], "", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr3[3], "", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr3 = furikaeDenpyouPage3.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr3[0], "project18", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr3[1], "", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr3[2], "", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr3[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr3 = furikaeDenpyouPage3.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr3[0], "摘要九", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr3[1], "", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr3[2], "", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr3[3], "", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr3 = furikaeDenpyouPage3.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr3[0], "摘要十八", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr3[1], "", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr3[2], "", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr3[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKasiGoukeiGk(), BizCurrency.valueOf(4600), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage3.getKariGoukeiGk(), BizCurrency.valueOf(4600), "借方合計金額");

        exStringEquals(furikaeDenpyouPage3.getKjKariKurikosiGkHyjKm(), "合計", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage3.getKjKasiKurikosiGkHyjKm(), "合計", "漢字貸方繰越合計表示項目");

    }

    @Test
    @TestOrder(40)
    public void testFurikaeDenPageList_B1() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("500");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名二", "漢字担当課名");

    }

    @Test
    @TestOrder(50)
    public void testFurikaeDenPageList_B2() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("501");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名三漢字", "漢字担当課名");

    }

    @Test
    @TestOrder(60)
    public void testFurikaeDenPageList_B3() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("502");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名四漢", "漢字担当課名");

    }

    @Test
    @TestOrder(70)
    public void testFurikaeDenPageList_B4() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("503");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名五漢字", "漢字担当課名");

    }


    @Test
    @TestOrder(80)
    public void testFurikaeDenPageList_B5() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("504");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "漢字組織名六漢字", "漢字担当課名");

    }

    @Test
    @TestOrder(90)
    public void testFurikaeDenPageList_B6() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("505");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "", "漢字担当課名");

    }

    @Test
    @TestOrder(100)
    public void testFurikaeDenPageList_B7() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("506");

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "", "漢字担当課名");

    }

    @Test
    @TestOrder(110)
    public void testFurikaeDenPageList_C1() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("727");
        bzFurikaeDenpyouJouhou.setTantoCd(null);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage1.getTorihikiNo(), "11110L", "取引番号");

        exNumericEquals(furikaeDenpyouPage1.getPageNo(), 1, "ページ番号");

        exStringEquals(furikaeDenpyouPage1.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "組織", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaCd(), null, "漢字担当コード");

        exStringEquals(furikaeDenpyouPage1.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiKurikosiGk(), BizCurrency.valueOf(0), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariKurikosiGk(), BizCurrency.valueOf(0), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage1.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI4, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr1[0], "name1", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr1[1], "", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr1[2], "", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr1[3], "", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr1[0], "name2", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr1[1], "", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr1[2], "", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr1[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr1 = furikaeDenpyouPage1.getKasiGks();

        exBizCalcbleEquals(kasigksArr1[0], BizCurrency.valueOf(50), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr1[1], BizCurrency.valueOf(0), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr1[2], BizCurrency.valueOf(0), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr1[3], BizCurrency.valueOf(0), "貸方金額配列[3]");


        BizCurrency[] karigksArr1 = furikaeDenpyouPage1.getKariGks();

        exBizCalcbleEquals(karigksArr1[0], BizCurrency.valueOf(50), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr1[1], BizCurrency.valueOf(0), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr1[2], BizCurrency.valueOf(0), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr1[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr1 = furikaeDenpyouPage1.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr1[0], "project1", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr1[1], "", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr1[2], "", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr1[3], "", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr1 = furikaeDenpyouPage1.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr1[0], "project2", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr1[1], "", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr1[2], "", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr1[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr1 = furikaeDenpyouPage1.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr1[0], "漢字摘要一", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr1[1], "", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr1[2], "", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr1[3], "", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr1 = furikaeDenpyouPage1.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr1[0], "漢字摘要二", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr1[1], "", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr1[2], "", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr1[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiGoukeiGk(), BizCurrency.valueOf(50), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariGoukeiGk(), BizCurrency.valueOf(50), "借方合計金額");

        exStringEquals(furikaeDenpyouPage1.getKjKariKurikosiGkHyjKm(), "合計", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage1.getKjKasiKurikosiGkHyjKm(), "合計", "漢字貸方繰越合計表示項目");
    }

    @Test
    @TestOrder(120)
    public void testFurikaeDenPageList_C2() {

        FurikaeDenpyouSiwakeMeisai bean1 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean1.setDenKanjoKamokuNm("name1");
        bean1.setKinGk(BizCurrency.valueOf(50));
        bean1.setTekiyouKm("project1");
        bean1.setKjTekiyouKm("漢字摘要一");

        FurikaeDenpyouSiwakeMeisai bean2 = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean2.setDenKanjoKamokuNm("name2");
        bean2.setKinGk(BizCurrency.valueOf(50));
        bean2.setTekiyouKm("project2");
        bean2.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("727");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.BLNK0);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setTorihikiNo("11110");
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean1, C_TaisyakuKbn.KASIKATA);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean2, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();

        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage1 = resultLst.get(0);

        exStringEquals(furikaeDenpyouPage1.getSystemKbn(), "65", "システム区分");

        exStringEquals(furikaeDenpyouPage1.getTorihikiNo(), "11110L", "取引番号");

        exNumericEquals(furikaeDenpyouPage1.getPageNo(), 1, "ページ番号");

        exStringEquals(furikaeDenpyouPage1.getTorihikiYmdGengoKbn(), "H", "取引年月日元号区分");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiNen(), 28, "取引年");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiTsuki(), 4, "取引月");

        exNumericEquals(furikaeDenpyouPage1.getTorihikiBi(), 14, "取引日");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaNm(), "組織", "漢字担当課名");

        exStringEquals(furikaeDenpyouPage1.getKjTantoukaCd(), null, "漢字担当コード");

        exStringEquals(furikaeDenpyouPage1.getKjSystemNm(), "ゆうゆう新契約", "漢字システム名");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiKurikosiGk(), BizCurrency.valueOf(0), "貸方繰越金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariKurikosiGk(), BizCurrency.valueOf(0), "借方繰越金額");

        exClassificationEquals(furikaeDenpyouPage1.getHuridenYouHassouKbn(), C_HuridenYouHassouKbn.HASSOUSAKI4, "振替伝票用発送区分");

        String[] kjkasikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKasiKanjoukamokuNms();

        exStringEquals(kjkasikanjoukamokunmsArr1[0], "name1", "漢字貸方勘定科目名配列[0]");
        exStringEquals(kjkasikanjoukamokunmsArr1[1], "", "漢字貸方勘定科目名配列[1]");
        exStringEquals(kjkasikanjoukamokunmsArr1[2], "", "漢字貸方勘定科目名配列[2]");
        exStringEquals(kjkasikanjoukamokunmsArr1[3], "", "漢字貸方勘定科目名配列[3]");

        String[] kjkarikanjoukamokunmsArr1 = furikaeDenpyouPage1.getKjKariKanjoukamokuNms();

        exStringEquals(kjkarikanjoukamokunmsArr1[0], "name2", "漢字借方勘定科目名配列[0]");
        exStringEquals(kjkarikanjoukamokunmsArr1[1], "", "漢字借方勘定科目名配列[1]");
        exStringEquals(kjkarikanjoukamokunmsArr1[2], "", "漢字借方勘定科目名配列[2]");
        exStringEquals(kjkarikanjoukamokunmsArr1[3], "", "漢字借方勘定科目名配列[3]");

        BizCurrency[] kasigksArr1 = furikaeDenpyouPage1.getKasiGks();

        exBizCalcbleEquals(kasigksArr1[0], BizCurrency.valueOf(50), "貸方金額配列[0]");
        exBizCalcbleEquals(kasigksArr1[1], BizCurrency.valueOf(0), "貸方金額配列[1]");
        exBizCalcbleEquals(kasigksArr1[2], BizCurrency.valueOf(0), "貸方金額配列[2]");
        exBizCalcbleEquals(kasigksArr1[3], BizCurrency.valueOf(0), "貸方金額配列[3]");


        BizCurrency[] karigksArr1 = furikaeDenpyouPage1.getKariGks();

        exBizCalcbleEquals(karigksArr1[0], BizCurrency.valueOf(50), "借方金額配列[0]");
        exBizCalcbleEquals(karigksArr1[1], BizCurrency.valueOf(0), "借方金額配列[1]");
        exBizCalcbleEquals(karigksArr1[2], BizCurrency.valueOf(0), "借方金額配列[2]");
        exBizCalcbleEquals(karigksArr1[3], BizCurrency.valueOf(0), "借方金額配列[3]");

        String[] kasitekiyoukmsArr1 = furikaeDenpyouPage1.getKasiTekiyouKms();

        exStringEquals(kasitekiyoukmsArr1[0], "project1", "貸方摘要項目配列[0]");
        exStringEquals(kasitekiyoukmsArr1[1], "", "貸方摘要項目配列[1]");
        exStringEquals(kasitekiyoukmsArr1[2], "", "貸方摘要項目配列[2]");
        exStringEquals(kasitekiyoukmsArr1[3], "", "貸方摘要項目配列[3]");

        String[] karitekiyoukmsArr1 = furikaeDenpyouPage1.getKariTekiyouKms();

        exStringEquals(karitekiyoukmsArr1[0], "project2", "借方摘要項目配列[0]");
        exStringEquals(karitekiyoukmsArr1[1], "", "借方摘要項目配列[1]");
        exStringEquals(karitekiyoukmsArr1[2], "", "借方摘要項目配列[2]");
        exStringEquals(karitekiyoukmsArr1[3], "", "借方摘要項目配列[3]");

        String[] kjkasitekiyoukmsArr1 = furikaeDenpyouPage1.getKjKasiTekiyouKms();

        exStringEquals(kjkasitekiyoukmsArr1[0], "漢字摘要一", "貸方漢字摘要項目配列[0]");
        exStringEquals(kjkasitekiyoukmsArr1[1], "", "貸方漢字摘要項目配列[1]");
        exStringEquals(kjkasitekiyoukmsArr1[2], "", "貸方漢字摘要項目配列[2]");
        exStringEquals(kjkasitekiyoukmsArr1[3], "", "貸方漢字摘要項目配列[3]");

        String[] kjkaritekiyoukmsArr1 = furikaeDenpyouPage1.getKjKariTekiyouKms();

        exStringEquals(kjkaritekiyoukmsArr1[0], "漢字摘要二", "借方漢字摘要項目配列[0]");
        exStringEquals(kjkaritekiyoukmsArr1[1], "", "借方漢字摘要項目配列[1]");
        exStringEquals(kjkaritekiyoukmsArr1[2], "", "借方漢字摘要項目配列[2]");
        exStringEquals(kjkaritekiyoukmsArr1[3], "", "借方漢字摘要項目配列[3]");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKasiGoukeiGk(), BizCurrency.valueOf(50), "貸方合計金額");

        exBizCalcbleEquals(furikaeDenpyouPage1.getKariGoukeiGk(), BizCurrency.valueOf(50), "借方合計金額");

        exStringEquals(furikaeDenpyouPage1.getKjKariKurikosiGkHyjKm(), "合計", "漢字借方繰越合計表示項目");

        exStringEquals(furikaeDenpyouPage1.getKjKasiKurikosiGkHyjKm(), "合計", "漢字貸方繰越合計表示項目");
    }

}
