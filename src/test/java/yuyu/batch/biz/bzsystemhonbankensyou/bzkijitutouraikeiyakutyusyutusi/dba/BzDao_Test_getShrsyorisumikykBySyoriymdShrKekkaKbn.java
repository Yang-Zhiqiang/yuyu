package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakutyusyutusi.dba;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 期日到来契約抽出（保険金）DAOクラス　テストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BzDao_Test_getShrsyorisumikykBySyoriymdShrKekkaKbn {

    @Inject
    private BzKijituTouraiKeiyakuTyusyutuSiDao bzkijituTouraiKeiyakuTyusyutuSiDao;

    private final static String fileName = "UT-SP_単体テスト仕様書（DAO）_getShrsyorisumikykBySyoriymdShrKekkaKbn";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    public static void insertTestData1(String pDataNo) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(BzDao_Test_getShrsyorisumikykBySyoriymdShrKekkaKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId(pDataNo, testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void test_A1() {

        insertTestData1("データ001");

        List<JT_Sk> jT_SkLst = new ArrayList<JT_Sk>();

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                BizDate.valueOf("20200308"), C_ShrKekkaKbn.SHR);
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {
                jT_SkLst.add(jtSkEntity);
            }
        }

        exNumericEquals(jT_SkLst.size(), 0, "請求TBLエンティティ（支払済）リストのサイズ");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void test_A2() {

        List<JT_Sk> jT_SkLst = new ArrayList<JT_Sk>();

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                BizDate.valueOf("20200309"), C_ShrKekkaKbn.ITIBU_SHR);
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {
                jT_SkLst.add(jtSkEntity);
            }
        }

        exNumericEquals(jT_SkLst.size(), 0, "請求TBLエンティティ（支払済）リストのサイズ");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void test_B1() {

        List<JT_Sk> jT_SkLst = new ArrayList<JT_Sk>();

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                BizDate.valueOf("20200309"), C_ShrKekkaKbn.SHR);
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {
                jT_SkLst.add(jtSkEntity);
            }
        }

        exNumericEquals(jT_SkLst.size(), 1, "請求TBLエンティティ（支払済）リストのサイズ");
        exStringEquals(jT_SkLst.get(0).getSyono(), "99806001168", "証券番号");
        exStringEquals(jT_SkLst.get(0).getSkno(), "001", "請求番号");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void test_B2() {

        List<JT_Sk> jT_SkLst = new ArrayList<JT_Sk>();

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                BizDate.valueOf("20200310"), C_ShrKekkaKbn.SHR, C_ShrKekkaKbn.NENKINSHR);
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {
                jT_SkLst.add(jtSkEntity);
            }
        }

        exNumericEquals(jT_SkLst.size(), 2, "請求TBLエンティティ（支払済）リストのサイズ");
        exStringEquals(jT_SkLst.get(0).getSyono(), "99806001179", "証券番号");
        exStringEquals(jT_SkLst.get(0).getSkno(), "002", "請求番号");
        exStringEquals(jT_SkLst.get(1).getSyono(), "99806001180", "証券番号");
        exStringEquals(jT_SkLst.get(1).getSkno(), "003", "請求番号");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void test_B3() {

        C_ShrKekkaKbn[] c_ShrKekkaKbn = {C_ShrKekkaKbn.SHR, C_ShrKekkaKbn.NENKINSHR};

        List<JT_Sk> jT_SkLst = new ArrayList<JT_Sk>();

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                BizDate.valueOf("20200310"), c_ShrKekkaKbn);
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {
                jT_SkLst.add(jtSkEntity);
            }
        }

        exNumericEquals(jT_SkLst.size(), 2, "請求TBLエンティティ（支払済）リストのサイズ");
        exStringEquals(jT_SkLst.get(0).getSyono(), "99806001179", "証券番号");
        exStringEquals(jT_SkLst.get(0).getSkno(), "002", "請求番号");
        exStringEquals(jT_SkLst.get(1).getSyono(), "99806001180", "証券番号");
        exStringEquals(jT_SkLst.get(1).getSkno(), "003", "請求番号");

    }

    @Test
    @TestOrder(1000)
    @Transactional
    public void test_C1() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

        List<JT_Sk> jT_SkLst = new ArrayList<JT_Sk>();

        try (
            ExDBResults<JT_Sk> jT_SkList = bzkijituTouraiKeiyakuTyusyutuSiDao.getShrsyorisumikykBySyoriymdShrKekkaKbn(
                BizDate.valueOf("20200309"), C_ShrKekkaKbn.SHR);
            ) {

            for (JT_Sk jtSkEntity : jT_SkList) {
                jT_SkLst.add(jtSkEntity);
            }
        }

        exNumericEquals(jT_SkLst.size(), 0, "請求TBLエンティティ（支払済）リストのサイズ");

    }

}