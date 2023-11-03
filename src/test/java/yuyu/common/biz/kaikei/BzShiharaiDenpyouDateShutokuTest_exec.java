package yuyu.common.biz.kaikei;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.dao.BM_TuukabetuKyuusibiDao;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払伝票日付取得クラスのメソッド {@link BzShiharaiDenpyouDateShutoku#exec(BizDate, C_ShrhousiteiKbn, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzShiharaiDenpyouDateShutokuTest_exec {

    @Inject
    private BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払伝票日付取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzShiharaiDenpyouDateShutokuTest_exec.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20151229")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20151230")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160203")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160309")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160331")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160408")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160401")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160402")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160403")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160404")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160405")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160406")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160407")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160501")));
        bizDomManager.delete(bizDomManager.getTuukabetuKyuusibi(BizDate.valueOf("20160304")));

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        String bankCd = "0001";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, null, "支払伝票日付");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        String bankCd = "0002";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160520"), "支払伝票日付");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        String bankCd = "0003";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160523"), "支払伝票日付");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        String bankCd = "0004";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160524"), "支払伝票日付");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        String bankCd = "";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160520"), "支払伝票日付");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate syoriYmd = BizDate.valueOf("20151228");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        String bankCd = null;

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20151229"), "支払伝票日付");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate syoriYmd = BizDate.valueOf("20151228");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.AUD;
        String bankCd = "0007";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160104"), "支払伝票日付");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        BizDate syoriYmd = BizDate.valueOf("20160301");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_2EIGYOUBI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;
        String bankCd = "0008";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160303"), "支払伝票日付");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        BizDate syoriYmd = BizDate.valueOf("20160128");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;
        String bankCd = "0008";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160202"), "支払伝票日付");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate syoriYmd = BizDate.valueOf("20160307");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;
        String bankCd = "0010";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160308"), "支払伝票日付");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate syoriYmd = BizDate.valueOf("20160331");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        String bankCd = "0011";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160408"), "支払伝票日付");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate syoriYmd = BizDate.valueOf("20160301");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_3EIGYOUBI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        String bankCd = "0009";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160304"), "支払伝票日付");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        String bankCd = "0004";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160202"), "支払伝票日付");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate syoriYmd = BizDate.valueOf("20160519");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        String bankCd = "0004";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20160202"), "支払伝票日付");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        BizDate syoriYmd = BizDate.valueOf("20170128");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;
        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;
        String bankCd = "0008";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20170206"), "支払伝票日付");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        MockObjectManager.initialize();
        BizDate syoriYmd = BizDate.valueOf("20210128");
        C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.FB_YOKUJITU;
        C_Tuukasyu tuukasyu = C_Tuukasyu.EUR;
        String bankCd = "0008";

        BizDate shiwaraiDenpyouHizuke = bzShiharaiDenpyouDateShutoku.exec(syoriYmd, shrhousiteiKbn, tuukasyu, bankCd);

        exDateEquals(shiwaraiDenpyouHizuke, BizDate.valueOf("20210129"), "支払伝票日付");

        BizDate shutokuShuuryoubi = (BizDate)MockObjectManager.getArgument(
            BM_TuukabetuKyuusibiDao.class, "getTuukabetuKyuusibisByTuukatoriatukaiymdKyuusieurkbnBlank", 0, 1);
        exDateEquals(shutokuShuuryoubi, BizDate.valueOf("20210228"), "取得終了日");
    }
}
