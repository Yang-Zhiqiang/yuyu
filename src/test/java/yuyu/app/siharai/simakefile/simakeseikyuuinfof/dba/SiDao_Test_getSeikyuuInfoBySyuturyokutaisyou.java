package yuyu.app.siharai.simakefile.simakeseikyuuinfof.dba;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiharaiSyoriJyoutaiKbn;
import yuyu.def.db.entity.JV_SeikyuuInfo;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求情報ファイル作成の機能ＤＡＯ　テストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiDao_Test_getSeikyuuInfoBySyuturyokutaisyou {

    @Inject
    private SiMakeSeikyuuInfoFDao siMakeSeikyuuInfoFDao;

    private final static String fileName = "UT-SP_単体テスト仕様書（DAO）_getSeikyuuInfoBySyuturyokutaisyou";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    public static void insertTestData1(String pDataNo) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(SiDao_Test_getSeikyuuInfoBySyuturyokutaisyou.class, fileName, sheetName);
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

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU, C_SeikyuuSyubetu.SB,
                null, null, null, null,
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 0, "請求情報ビューリストのサイズ");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void test_A2() {

        insertTestData1("データ001");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.MISEIKYUU, C_SeikyuuSyubetu.SBKRUKTK,
                null, null, null, null,
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 1, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "001", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void test_A3() {

        insertTestData1("データ002");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.MISEIKYUU, C_SeikyuuSyubetu.SBKRUKTK,
                BizDate.valueOf("20180102"), null, null, null,
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "003", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "004", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void test_A4() {

        insertTestData1("データ002");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.MISEIKYUU, C_SeikyuuSyubetu.SBKRUKTK,
                null, BizDate.valueOf("20180102"), null, null,
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "002", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "003", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void test_A5() {

        insertTestData1("データ003");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.MISEIKYUU, C_SeikyuuSyubetu.SBKRUKTK,
                null, null, BizDate.valueOf("20180105"), null,
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "006", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "007", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void test_A6() {

        insertTestData1("データ003");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.MISEIKYUU, C_SeikyuuSyubetu.SBKRUKTK,
                null, null, null, BizDate.valueOf("20180105"),
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "005", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "006", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void test_A7() {

        insertTestData1("データ004");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU, C_SeikyuuSyubetu.SB,
                null, null, null, null,
                BizDate.valueOf("20180107"), null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "009", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "010", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void test_A8() {

        insertTestData1("データ004");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU, C_SeikyuuSyubetu.SB,
                null, null, null, null,
                null, BizDate.valueOf("20180107"), null, null);

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "008", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "009", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void test_A9() {

        insertTestData1("データ005");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI, C_SeikyuuSyubetu.SB,
                null, null, null, null,
                null, null, BizDate.valueOf("20180109"), null);

        exNumericEquals(seikyuuInfoList.size(), 3, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "20808000071", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "012", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "20808000093", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "013", "請求番号");
        exStringEquals(seikyuuInfoList.get(2).getSyono(), "20808000107", "証券番号");
        exStringEquals(seikyuuInfoList.get(2).getSkno(), "014", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void test_A10() {

        insertTestData1("データ005");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI, C_SeikyuuSyubetu.SB,
                null, null, null, null,
                null, null, null, BizDate.valueOf("20180109"));

        exNumericEquals(seikyuuInfoList.size(), 2, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(0).getSyono(), "20808000060", "証券番号");
        exStringEquals(seikyuuInfoList.get(0).getSkno(), "011", "請求番号");
        exStringEquals(seikyuuInfoList.get(1).getSyono(), "20808000071", "証券番号");
        exStringEquals(seikyuuInfoList.get(1).getSkno(), "012", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void test_A11() {

        insertTestData1("データ006");

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI, C_SeikyuuSyubetu.SB,
                BizDate.valueOf("20180101"), BizDate.valueOf("20180103"),
                BizDate.valueOf("20190101"), BizDate.valueOf("20190103"),
                BizDate.valueOf("20200101"), BizDate.valueOf("20200103"),
                BizDate.valueOf("20210101"), BizDate.valueOf("20210103"));

        exNumericEquals(seikyuuInfoList.size(), 301, "請求情報ビューリストのサイズ");
        exStringEquals(seikyuuInfoList.get(300).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(300).getSkno(), "316", "請求番号");

    }

    @Test
    @TestOrder(111)
    @Transactional
    public void test_A12() {

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI, C_SeikyuuSyubetu.SB,
                null, null,
                null, null,
                null, null,
                null, null);

        exNumericEquals(seikyuuInfoList.size(), 301, "請求情報ビューリストのサイズ");

        exStringEquals(seikyuuInfoList.get(300).getSyono(), "60806019002", "証券番号");
        exStringEquals(seikyuuInfoList.get(300).getSkno(), "315", "請求番号");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }


    @Test
    @TestOrder(1000)
    @Transactional
    public void test_B1() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

        List<JV_SeikyuuInfo> seikyuuInfoList =
            siMakeSeikyuuInfoFDao.getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn.MISEIKYUU, C_SeikyuuSyubetu.SBKRUKTK,
                null, null, null, null,
                null, null, null, null);

        exNumericEquals(seikyuuInfoList.size(), 0, "請求情報ビューリストのサイズ");

    }

}