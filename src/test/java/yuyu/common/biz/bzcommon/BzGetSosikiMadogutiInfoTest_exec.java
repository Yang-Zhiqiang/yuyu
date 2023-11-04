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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 組織窓口情報取得クラスのメソッド {@link BzGetSosikiMadogutiInfoKekkaBean#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetSosikiMadogutiInfoTest_exec {

    @Inject
    private BzGetSosikiMadogutiInfo getSosikiMadogutiInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_組織窓口情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BzGetSosikiMadogutiInfoTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void BzGetSousasyaSyozokuSosikiData() {

        MockObjectManager.initialize();
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSosikiMadoguti());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        String pSosikicd = "";

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        assertNull(bzGetSosikiMadogutiInfoKekkaBean);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        String pSosikicd = null;

        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        assertNull(bzGetSosikiMadogutiInfoKekkaBean);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        String pSosikicd = "1110000";
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getHassoukbn(), "", "発送区分");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm(), "", "漢字組織名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1(), "", "漢字組織住所１");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2(), "", "漢字組織住所２");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3(), "", "漢字組織住所３");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd(), "", "郵便番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getTelno(), "", "電話番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getFaxno(), "", "ＦＡＸ番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikznm(), "", "支社払出口座名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKouzanocd(), "", "口座番号ＣＤ");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikouzano(), "", "支社払出口座番号");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        String pSosikicd = "1234567";
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getHassoukbn(), "3", "発送区分");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm(), "漢字組織名組織区分名", "漢字組織名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1(), "漢字組織住所１", "漢字組織住所１");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2(), "漢字組織住所２", "漢字組織住所２");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3(), "漢字組織住所３", "漢字組織住所３");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd(), "123-4567", "郵便番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getTelno(), "123-45678-90123", "電話番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getFaxno(), "987-65432-10123", "ＦＡＸ番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikznm(), "払出口座名", "支社払出口座名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKouzanocd(), "2", "口座番号ＣＤ");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikouzano(), "1234567", "支社払出口座番号");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        String pSosikicd = "AAAAAAA";
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getHassoukbn(), "2", "発送区分");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm(), "漢字組織名ＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸ３ＸＸＸＸＸＸＸＸＸＥ組織区分名ＸＸＸＸ１ＸＥ", "漢字組織名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1(), "住所１ＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "漢字組織住所１");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2(), "住所２ＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "漢字組織住所２");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3(), "住所３ＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＸＸＸＸＸＥ", "漢字組織住所３");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd(), "123-4560", "郵便番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getTelno(), "123-45678-90120", "電話番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getFaxno(), "987-65432-10120", "ＦＡＸ番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikznm(), "口座名ＸＥ", "支社払出口座名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKouzanocd(), "1", "口座番号ＣＤ");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikouzano(), "1234560", "支社払出口座番号");


    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        String pSosikicd = "0000000";
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getHassoukbn(), "1", "発送区分");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm(), "", "漢字組織名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1(), "", "漢字組織住所１");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2(), "", "漢字組織住所２");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3(), "", "漢字組織住所３");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd(), "", "郵便番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getTelno(), "", "電話番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getFaxno(), "", "ＦＡＸ番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikznm(), "", "支社払出口座名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKouzanocd(), "", "口座番号ＣＤ");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikouzano(), "", "支社払出口座番号");


    }
    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        String pSosikicd = "2345678";
        BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(pSosikicd);

        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getHassoukbn(), "3", "発送区分");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm(), "", "漢字組織名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1(), "漢字組織住所１", "漢字組織住所１");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2(), "漢字組織住所２", "漢字組織住所２");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3(), "漢字組織住所３", "漢字組織住所３");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getPostalCd(), "123-4567", "郵便番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getTelno(), "123-45678-90123", "電話番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getFaxno(), "987-65432-10123", "ＦＡＸ番号");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikznm(), "払出口座名", "支社払出口座名");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getKouzanocd(), "2", "口座番号ＣＤ");
        exStringEquals(bzGetSosikiMadogutiInfoKekkaBean.getSisyaharaidasikouzano(), "1234567", "支社払出口座番号");

    }

}
