package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
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
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SosikiNmKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 操作者所属組織情報設定クラスのメソッド {@link BzGetSyozokuSosikiDataBean#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetSousasyaSyozokuSosikiDataTest_exec {

    @Inject
    private BzGetSousasyaSyozokuSosikiData bzGetSousasyaSyozokuSosikiData;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_操作者所属組織情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BzGetSousasyaSyozokuSosikiDataTest_exec.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());
        baseDomManager.delete(baseDomManager.getAllUserIdKanrens());
        baseDomManager.delete(baseDomManager.getAllIdCards());
        baseDomManager.delete(baseDomManager.getAllUsers());
    }

    @Test
    @TestOrder(10)
    public void testExce_A1() {

        String pUserId = "";
        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        assertNull(getSyozokuSosikiDataBean);
    }

    @Test
    @TestOrder(20)
    public void testExce_A2() {

        String pUserId = null;
        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        assertNull(getSyozokuSosikiDataBean);
    }

    @Test
    @TestOrder(30)
    public void testExce_A3() {

        String pUserId = "01100999";
        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        assertNull(getSyozokuSosikiDataBean);
    }

    @Test
    @TestOrder(40)
    public void testExce_A4() {

        String pUserId = "01100001";

        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        exStringEquals(getSyozokuSosikiDataBean.getSosikicd(),"0010001","組織コード");
        exClassificationEquals(getSyozokuSosikiDataBean.getSosikinmkbn(),C_SosikiNmKbn.BU,"組織名区分");
        exStringEquals(getSyozokuSosikiDataBean.getSosikinm20(),"ソシキ００１０００１","組織名");
        exStringEquals(getSyozokuSosikiDataBean.getKanjisosikinm20(),"組織００１０００１","漢字組織名");

    }

    @Test
    @TestOrder(50)
    public void testExce_A5() {

        String pUserId = "AAAAAAAA";

        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        exStringEquals(getSyozokuSosikiDataBean.getSosikicd(),"AAAAAAB","組織コード");
        exClassificationEquals(getSyozokuSosikiDataBean.getSosikinmkbn(),C_SosikiNmKbn.BU,"組織名区分");
        exStringEquals(getSyozokuSosikiDataBean.getSosikinm20(),"ソシキＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ","組織名");
        exStringEquals(getSyozokuSosikiDataBean.getKanjisosikinm20(),"組織ＸＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ","漢字組織名");

    }

    @Test
    @TestOrder(60)
    public void testExce_A6() {

        String pUserId = "01100003";

        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        exStringEquals(getSyozokuSosikiDataBean.getSosikicd(),"0010003","組織コード");
        exClassificationEquals(getSyozokuSosikiDataBean.getSosikinmkbn(),null,"組織名区分");
        exStringEquals(getSyozokuSosikiDataBean.getSosikinm20(),"","組織名");
        exStringEquals(getSyozokuSosikiDataBean.getKanjisosikinm20(),"","漢字組織名");

    }

    @Test
    @TestOrder(70)
    public void testExce_A7() {

        String pUserId = "BBBBBBBB";

        BzGetSousasyaSyozokuSosikiDataBean getSyozokuSosikiDataBean = bzGetSousasyaSyozokuSosikiData.exec(pUserId);

        exStringEquals(getSyozokuSosikiDataBean.getSosikicd(),"0010004","組織コード");
        exClassificationEquals(getSyozokuSosikiDataBean.getSosikinmkbn(),C_SosikiNmKbn.BU,"組織名区分");
        exStringEquals(getSyozokuSosikiDataBean.getSosikinm20(),"ソシキ００１０００４","組織名");
        exStringEquals(getSyozokuSosikiDataBean.getKanjisosikinm20(),"組織００１０００４","漢字組織名");

    }

}
