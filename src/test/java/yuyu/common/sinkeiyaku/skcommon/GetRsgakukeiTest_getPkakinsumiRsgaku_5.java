package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 領収金額合計取得クラスのメソッド {@link getPkakinsumiRsgaku#exec(HT_SyoriCTL,C_Tuukasyu,BizDate)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetRsgakukeiTest_getPkakinsumiRsgaku_5 {

    @Inject
    private GetRsgakukei getRsgakukei;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_領収金額合計取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(GetRsgakukeiTest_getPkakinsumiRsgaku_4.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ009", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

    }

    @Test
    @TestOrder(10)
    public void testGetPkakinsumiRsgaku_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        BizDate pRyosyuymd = BizDate.valueOf("20160420");

        BizDate pPkakinsyoriymd = BizDate.valueOf("20160421");

        getRsgakukei.getPkakinsumiRsgaku(syoriCTL, pRyosyuymd, pPkakinsyoriymd);

        exBizCalcbleEquals(getRsgakukei.getRsgakukei(), BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR), "領収金額合計");

        exClassificationEquals(getRsgakukei.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
    }

    @Test
    @TestOrder(20)
    public void testGetPkakinsumiRsgaku_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        BizDate pRyosyuymd = BizDate.valueOf("20160420");

        BizDate pPkakinsyoriymd = BizDate.valueOf("20160420");

        getRsgakukei.getPkakinsumiRsgaku(syoriCTL, pRyosyuymd, pPkakinsyoriymd);

        exBizCalcbleEquals(getRsgakukei.getRsgakukei(), BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR), "領収金額合計");

        exClassificationEquals(getRsgakukei.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
    }

    @Test
    @TestOrder(30)
    public void testGetPkakinsumiRsgaku_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        BizDate pRyosyuymd = BizDate.valueOf("20160419");

        BizDate pPkakinsyoriymd = BizDate.valueOf("20160421");

        getRsgakukei.getPkakinsumiRsgaku(syoriCTL, pRyosyuymd, pPkakinsyoriymd);

        exBizCalcbleEquals(getRsgakukei.getRsgakukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "領収金額合計");

        exClassificationEquals(getRsgakukei.getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
    }

    @Test
    @TestOrder(40)
    public void testGetPkakinsumiRsgaku_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        BizDate pRyosyuymd = BizDate.valueOf("20160419");

        BizDate pPkakinsyoriymd = BizDate.valueOf("20160420");

        getRsgakukei.getPkakinsumiRsgaku(syoriCTL, pRyosyuymd, pPkakinsyoriymd);

        exBizCalcbleEquals(getRsgakukei.getRsgakukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "領収金額合計");

        exClassificationEquals(getRsgakukei.getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
    }

    @Test
    @TestOrder(50)
    public void testGetPkakinsumiRsgaku_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");

        BizDate pRyosyuymd = BizDate.valueOf("20160419");

        BizDate pPkakinsyoriymd = BizDate.valueOf("20160420");

        getRsgakukei.getPkakinsumiRsgaku(syoriCTL, pRyosyuymd, pPkakinsyoriymd);

        exBizCalcbleEquals(getRsgakukei.getRsgakukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "領収金額合計");

        exClassificationEquals(getRsgakukei.getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
    }

}
