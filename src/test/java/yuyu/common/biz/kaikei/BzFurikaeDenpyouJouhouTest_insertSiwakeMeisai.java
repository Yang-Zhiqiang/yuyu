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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhou#insertSiwakeMeisai()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_insertSiwakeMeisai{

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
            testDataAndTblMap = testDataMaker.getInData(BzFurikaeDenpyouJouhouTest_insertSiwakeMeisai.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTantouCd());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());
    }

    @Test
    @TestOrder(10)
    public void testInsertSiwakeMeisai_A1() {
        FurikaeDenpyouSiwakeMeisai bean = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean.setDenKanjoKamokuNm("name1");
        bean.setKinGk(BizCurrency.valueOf(30));
        bean.setTekiyouKm("project1");
        bean.setKjTekiyouKm("漢字摘要一");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("101");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(true);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean, C_TaisyakuKbn.KASIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();
        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage = resultLst.get(0);

        String[]  kjkasikanjoukamokunmsArr = furikaeDenpyouPage.getKjKasiKanjoukamokuNms();
        exStringEquals(kjkasikanjoukamokunmsArr[0], "name1", "漢字貸方勘定科目名配列[0]");

        String[] kjkarikanjoukamokunmsArr = furikaeDenpyouPage.getKjKariKanjoukamokuNms();
        exStringEquals(kjkarikanjoukamokunmsArr[0], "", "漢字借方勘定科目名配列[0]");

        BizCurrency[] kasigksArr = furikaeDenpyouPage.getKasiGks();
        exBizCalcbleEquals(kasigksArr[0], BizCurrency.valueOf(30), "貸方金額配列[0]");

        String[] kasitekiyoukmsArr = furikaeDenpyouPage.getKasiTekiyouKms();
        exStringEquals(kasitekiyoukmsArr[0], "project1", "貸方摘要項目配列[0]");

        String[] kjkasitekiyoukmsArr = furikaeDenpyouPage.getKjKasiTekiyouKms();
        exStringEquals(kjkasitekiyoukmsArr[0], "漢字摘要一", "貸方漢字摘要項目配列[0]");

        exBizCalcbleEquals(furikaeDenpyouPage.getKasiGoukeiGk(), BizCurrency.valueOf(30), "貸方合計金額");
    }

    @Test
    @TestOrder(20)
    public void testInsertSiwakeMeisai_A2() {
        FurikaeDenpyouSiwakeMeisai bean = SWAKInjector
            .getInstance(FurikaeDenpyouSiwakeMeisai.class);
        bean.setDenKanjoKamokuNm("name2");
        bean.setKinGk(BizCurrency.valueOf(50));
        bean.setTekiyouKm("project2");
        bean.setKjTekiyouKm("漢字摘要二");

        bzFurikaeDenpyouJouhou.setDenYmd(BizDate.valueOf(20160414));
        bzFurikaeDenpyouJouhou.setHuriDenAtesakiCd("101");
        bzFurikaeDenpyouJouhou.setTantoCd(C_TantouCdKbn.HURIKAE);
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        bzFurikaeDenpyouJouhou.setLastGroupDispFlg(false);

        bzFurikaeDenpyouJouhou.insertSiwakeMeisai(bean, C_TaisyakuKbn.KARIKATA);

        List<FurikaeDenpyouPage> resultLst = bzFurikaeDenpyouJouhou.furikaeDenPageList();

        int size = resultLst.size();
        exNumericEquals(size, 1, "振替伝票ページ情報リスト＃size");

        FurikaeDenpyouPage furikaeDenpyouPage = resultLst.get(0);

        String[] kjkarikanjoukamokunmsArr = furikaeDenpyouPage.getKjKariKanjoukamokuNms();
        exStringEquals(kjkarikanjoukamokunmsArr[0], "name2", "漢字借方勘定科目名配列[0]");

        String[]  kjkasikanjoukamokunmsArr = furikaeDenpyouPage.getKjKasiKanjoukamokuNms();
        exStringEquals(kjkasikanjoukamokunmsArr[0], "", "漢字貸方勘定科目名配列[0]");

        BizCurrency[] karigksArr = furikaeDenpyouPage.getKariGks();
        exBizCalcbleEquals(karigksArr[0], BizCurrency.valueOf(50), "借方金額配列[0]");

        String[] karitekiyoukmsArr = furikaeDenpyouPage.getKariTekiyouKms();
        exStringEquals(karitekiyoukmsArr[0], "project2", "借方摘要項目配列[0]");

        String[] kjkaritekiyoukmsArr = furikaeDenpyouPage.getKjKariTekiyouKms();
        exStringEquals(kjkaritekiyoukmsArr[0], "漢字摘要二", "借方漢字摘要項目配列[0]");

        exBizCalcbleEquals(furikaeDenpyouPage.getKariGoukeiGk(), BizCurrency.valueOf(50), "借方合計金額");
    }


}
