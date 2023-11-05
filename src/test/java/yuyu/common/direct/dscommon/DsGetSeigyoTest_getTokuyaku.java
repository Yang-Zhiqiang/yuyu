package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.direct.dscommon.DsGetSeigyo;
import yuyu.common.direct.dscommon.DsSyouhinBean;
import yuyu.common.direct.dscommon.TokuyakuBean;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ制御情報取得クラスのメソッド {@link DsGetSeigyo#getTokuyaku(DsSyouhinBean pDsSyouhinBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetSeigyoTest_getTokuyaku {

    @Inject
    private DsGetSeigyo dsGetSeigyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ制御情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(DsGetSeigyoTest_getTokuyaku.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testGetTokuyaku_A1() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111199");

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);

        exClassificationEquals(tokuyakuBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetTokuyaku_A2() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("17809000045");

        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);

        exClassificationEquals(tokuyakuBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testGetTokuyaku_A3() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("17809000056");
        TokuyakuBean tokuyakuBean = dsGetSeigyo.getTokuyaku(dsSyouhinBean);

        exClassificationEquals(tokuyakuBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(tokuyakuBean.getKykdrTkykhukaumu(), C_UmuKbn.NONE, "保険契約者代理特約付加有無");
        exClassificationEquals(tokuyakuBean.getStdrskTkyhkumu(), C_UmuKbn.NONE, "指定代理請求特約付加有無");
        exClassificationEquals(tokuyakuBean.getYenNyknThkumu(), C_UmuKbn.ARI, "円入金特約付加有無");
        exClassificationEquals(tokuyakuBean.getGaikaNyknTkhkumu(), C_UmuKbn.ARI, "外貨入金特約付加有無");
        exClassificationEquals(tokuyakuBean.getTargetTkhkumu(), C_UmuKbn.NONE, "ターゲット特約付加有無");
        exClassificationEquals(tokuyakuBean.getInitSbjiYenSitiHsyTkhukaumu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約付加有無");
        exClassificationEquals(tokuyakuBean.getJyudKaigoMeharaiTkhukaumu(), C_UmuKbn.ARI, "重度介護前払特約付加有無");
        exClassificationEquals(tokuyakuBean.getJyudKaigoMeharaiTkhukaumu(), C_UmuKbn.ARI, "税制適格特約付加有無");
        exClassificationEquals(tokuyakuBean.getTeikiShrTkykhukaumu(), C_UmuKbn.ARI, "定期支払特約付加有無");
    }
}
