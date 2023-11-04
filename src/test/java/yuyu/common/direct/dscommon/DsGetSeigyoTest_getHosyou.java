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
import yuyu.common.direct.dscommon.HosyouBean;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ制御情報取得クラスのメソッド {@link DsGetSeigyo#getHosyou(DsSyouhinBean pDsSyouhinBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetSeigyoTest_getHosyou {

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

            testDataAndTblMap = testDataMaker.getInData(DsGetSeigyoTest_getHosyou.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

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
    public void testGetHosyou_A1() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("11807111199");

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHosyou_A2() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("17809000012");

        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testGetHosyou_A3() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("17809000023");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(),C_UmuKbn.ARI,"死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(),C_UmuKbn.ARI,"介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(),C_UmuKbn.NONE,"医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(),C_UmuKbn.NONE,"老後保障有無区分");
    }

    @Test
    @TestOrder(40)
    public void testGetHosyou_A4() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        dsSyouhinBean.setSyoNo("17809000034");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(),C_UmuKbn.ARI,"死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(),C_UmuKbn.NONE,"介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(),C_UmuKbn.NONE,"医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(),C_UmuKbn.NONE,"老後保障有無区分");
    }

    @Test
    @TestOrder(50)
    public void testGetHosyou_A5() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("17809000034");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(), C_UmuKbn.ARI, "死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(), C_UmuKbn.NONE, "介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(), C_UmuKbn.NONE, "医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(), C_UmuKbn.ARI, "老後保障有無区分");
    }

    @Test
    @TestOrder(60)
    public void testGetHosyou_A6() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.BLNK);
        dsSyouhinBean.setSyoNo("17809000034");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(), null, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(), null, "死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(), null, "介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(), null, "医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(), null, "老後保障有無区分");
    }

    @Test
    @TestOrder(70)
    public void testGetHosyou_A7() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.GKDTHIJYNBRNK);
        dsSyouhinBean.setSyoNo("17809000034");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(), C_UmuKbn.ARI, "死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(), C_UmuKbn.NONE, "介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(), C_UmuKbn.NONE, "医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(), C_UmuKbn.ARI, "老後保障有無区分");
    }

    @Test
    @TestOrder(80)
    public void testGetHosyou_A8() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);
        dsSyouhinBean.setSyoNo("17809000034");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(), C_UmuKbn.ARI, "死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(), C_UmuKbn.NONE, "介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(), C_UmuKbn.NONE, "医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(), C_UmuKbn.ARI, "老後保障有無区分");
    }

    @Test
    @TestOrder(90)
    public void testGetHosyou_A9() {

        DsSyouhinBean dsSyouhinBean = new DsSyouhinBean();
        dsSyouhinBean.setDsSyouhnbunruiKbn(C_DsSyouhnbunruiKbn.SNTKDTHIJYNBRSYSN);
        dsSyouhinBean.setSyoNo("17809000034");
        HosyouBean hosyouBean = dsGetSeigyo.getHosyou(dsSyouhinBean);

        exClassificationEquals(hosyouBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(hosyouBean.getSbHsyUmuKbn(), C_UmuKbn.ARI, "死亡保障有無区分");
        exClassificationEquals(hosyouBean.getKgHsyUmukbn(), C_UmuKbn.NONE, "介護保障有無区分");
        exClassificationEquals(hosyouBean.getIryHsyUmukbn(), C_UmuKbn.NONE, "医療保障有無区分");
        exClassificationEquals(hosyouBean.getRougoHsyUmukbn(), C_UmuKbn.NONE, "老後保障有無区分");
    }
}
