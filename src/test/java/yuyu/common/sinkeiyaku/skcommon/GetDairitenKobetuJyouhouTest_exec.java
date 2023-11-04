package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 代理店個別情報取得クラスのメソッド {@link GetDairitenKobetuJyouhou#exec(String)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class GetDairitenKobetuJyouhouTest_exec {

    private final static String OYADRTENCD1 = null;

    private final static String OYADRTENCD2 = "";

    private final static String OYADRTENCD3 = "1003";

    private final static String OYADRTENCD4 = "1004";

    private final static String OYADRTENCD5 = "1005";

    private final static String OYADRTENCD6 = "5100002";

    private final static String OYADRTENCD7 = "2101079";

    @Inject
    private GetDairitenKobetuJyouhou getDairitenKobetuJyouhou;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_代理店個別情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetDairitenKobetuJyouhouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDairitenKobetuJyouhou());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD1,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD2,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou = sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(OYADRTENCD3);
        BizPropertyInitializer.initialize(skDairitenKobetuJyouhou);
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD3,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi(), C_YouhiKbn.HUYOU, "ＣＩＦコードチェック要否");
        assertNull(getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu());
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi(), C_YouhiblnkKbn.BLNK, "ＣＩＦコード前ゼロ埋め要否");
    }

    @Test()
    @TestOrder(40)
    public void testExec_A4() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD4,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi(), C_YouhiKbn.HUYOU, "ＣＩＦコードチェック要否");
        exNumericEquals(getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(),  2,  "ＣＩＦコード指定桁数");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi(), C_YouhiblnkKbn.BLNK, "ＣＩＦコード前ゼロ埋め要否");
    }

    @Test()
    @TestOrder(50)
    public void testExec_A5() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD5,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD3,
            null);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test()
    @TestOrder(70)
    public void testExec_A7() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD6,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi(), C_YouhiKbn.YOU, "ＣＩＦコードチェック要否");
        exNumericEquals(getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(),  14,  "ＣＩＦコード指定桁数");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi(), C_YouhiblnkKbn.YOU, "ＣＩＦコード前ゼロ埋め要否");
    }

    @Test()
    @TestOrder(80)
    public void testExec_A8() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD7,
            C_MosUketukeKbn.PAPERLESS);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi(), C_YouhiKbn.HUYOU, "ＣＩＦコードチェック要否");
        exNumericEquals(getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(),  15,  "ＣＩＦコード指定桁数");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi(), C_YouhiblnkKbn.HUYOU, "ＣＩＦコード前ゼロ埋め要否");
    }

    @Test()
    @TestOrder(90)
    public void testExec_A9() {
        GetDairitenKobetuJyouhouBean getDairitenKobetuJyouhouBean = getDairitenKobetuJyouhou.exec(OYADRTENCD4,
            C_MosUketukeKbn.SIRYOUSEIKYUU);

        exClassificationEquals(getDairitenKobetuJyouhouBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdCheckYouhi(), C_YouhiKbn.HUYOU, "ＣＩＦコードチェック要否");
        exNumericEquals(getDairitenKobetuJyouhouBean.getCifCdSiteiKetasuu(),  2,  "ＣＩＦコード指定桁数");
        exClassificationEquals(getDairitenKobetuJyouhouBean.getCifCdMaezeroumeYouhi(), C_YouhiblnkKbn.BLNK, "ＣＩＦコード前ゼロ埋め要否");
    }
}

