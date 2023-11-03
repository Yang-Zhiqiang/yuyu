package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約手続注意情報取得クラスのメソッド {@link GetSkTtdkTyuui#getTtdkTyuui(String, C_SkeittdkrenrakuKbn)} テスト用クラスです<br />
 */

@RunWith(OrderedRunner.class)
public class GetSkTtdkTyuuiTest_getTtdkTyuui {

    private static String mosNo3 = "871229134";

    private static String mosNo4 = "871229142";

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約手続注意情報取得";

    private final static String sheetName = "テストデータ";

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetSkTtdkTyuuiTest_getTtdkTyuui.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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
    public void testGetTtdkTyuui_A1() {

        List<HT_SkTtdkTyuui> skTtdkTyuuiList = getSkTtdkTyuui.getTtdkTyuui(mosNo3,
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        exListEquals(skTtdkTyuuiList, null, "新契約手続注意テーブルエンティティリスト");
    }

    @Test
    @TestOrder(20)
    public void testGetTtdkTyuui_A2() {

        List<HT_SkTtdkTyuui> skTtdkTyuuiList = getSkTtdkTyuui.getTtdkTyuui(mosNo4,
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        exStringEquals(skTtdkTyuuiList.get(0).getMosno(), mosNo4, "申込番号");
        exClassificationEquals(skTtdkTyuuiList.get(0).getSkeittdkrenrakukbn(),
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO, "新契約手続連絡区分");
        exNumericEquals(skTtdkTyuuiList.get(0).getDatarenno(), 2, "データ連番");
        exStringEquals(skTtdkTyuuiList.get(0).getSkeittdktyuuinaiyou(), "新契約手続注意内容２", "新契約手続注意内容");
        exDateEquals(skTtdkTyuuiList.get(0).getTrkymd(), BizDate.valueOf(20160212), "登録日");

        exStringEquals(skTtdkTyuuiList.get(1).getMosno(), mosNo4, "申込番号");
        exClassificationEquals(skTtdkTyuuiList.get(1).getSkeittdkrenrakukbn(),
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO, "新契約手続連絡区分");
        exNumericEquals(skTtdkTyuuiList.get(1).getDatarenno(), 5, "データ連番");
        exStringEquals(skTtdkTyuuiList.get(1).getSkeittdktyuuinaiyou(), "新契約手続注意内容５", "新契約手続注意内容");
        exDateEquals(skTtdkTyuuiList.get(1).getTrkymd(), BizDate.valueOf(20160212), "登録日");

        exStringEquals(skTtdkTyuuiList.get(2).getMosno(), mosNo4, "申込番号");
        exClassificationEquals(skTtdkTyuuiList.get(2).getSkeittdkrenrakukbn(),
            C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO, "新契約手続連絡区分");
        exNumericEquals(skTtdkTyuuiList.get(2).getDatarenno(), 1, "データ連番");
        exStringEquals(skTtdkTyuuiList.get(2).getSkeittdktyuuinaiyou(), "新契約手続注意内容１", "新契約手続注意内容");
        exDateEquals(skTtdkTyuuiList.get(2).getTrkymd(), BizDate.valueOf(20160218), "登録日");
    }
}
