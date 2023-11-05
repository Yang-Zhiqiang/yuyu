package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * スキップキーテーブル格納処理クラスのメイン処理{@link BzSkipKeyTableKakunou#exec()}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSkipKeyTableKakunouTest_exec {

    @Inject
    private BzSkipKeyTableKakunou bzSkipKeyTableKakunou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_スキップキーテーブル格納処理";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSkipKeyTableKakunouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {


        bzSkipKeyTableKakunou.exec();
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);


        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd("");
        bzRecoveryDatasikibetuBean.setIbTableid("");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1("");

        bzSkipKeyTableKakunou.exec();
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);


        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd("JCD01");
        bzRecoveryDatasikibetuBean.setIbTableid("BT_DenpyoData");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("Bz105");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1("10");


        bzSkipKeyTableKakunou.exec();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_SkipKey skipKey = bizDomManager.getSkipKey("JCD01_BT_DenpyoData_Bz105_10____");

        exStringEquals(skipKey.getKakutyoujobcd(), "JCD01", "拡張ジョブコード");
        exStringEquals(skipKey.getTableid(), "BT_DenpyoData", "テーブルＩＤ");
        exStringEquals(skipKey.getRecoveryfilterid(), "Bz105", "リカバリフィルタＩＤ");
        exStringEquals(skipKey.getRecoveryfilterkey1(), "10", "リカバリフィルタキー１");
        exStringEquals(skipKey.getRecoveryfilterkey2(), null, "リカバリフィルタキー２");
        exStringEquals(skipKey.getRecoveryfilterkey3(), null, "リカバリフィルタキー３");
        exStringEquals(skipKey.getRecoveryfilterkey4(), null, "リカバリフィルタキー４");
        exStringEquals(skipKey.getRecoveryfilterkey5(), null, "リカバリフィルタキー５");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);


        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd("JCD01");
        bzRecoveryDatasikibetuBean.setIbTableid("BT_DenpyoData");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("Bz105");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1("10");

        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2("");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3("");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey4("");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey5("");

        bzSkipKeyTableKakunou.exec();

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);


        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd("JCD01");
        bzRecoveryDatasikibetuBean.setIbTableid("BT_DenpyoData");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("Bz105");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1("10");

        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2("001");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3("002");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey4("003");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey5("004");


        bzSkipKeyTableKakunou.exec();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_SkipKey skipKey = bizDomManager.getSkipKey("JCD01_BT_DenpyoData_Bz105_10_001_002_003_004");

        exStringEquals(skipKey.getKakutyoujobcd(), "JCD01", "拡張ジョブコード");
        exStringEquals(skipKey.getTableid(), "BT_DenpyoData", "テーブルＩＤ");
        exStringEquals(skipKey.getRecoveryfilterid(), "Bz105", "リカバリフィルタＩＤ");
        exStringEquals(skipKey.getRecoveryfilterkey1(), "10", "リカバリフィルタキー１");
        exStringEquals(skipKey.getRecoveryfilterkey2(), "001", "リカバリフィルタキー２");
        exStringEquals(skipKey.getRecoveryfilterkey3(), "002", "リカバリフィルタキー３");
        exStringEquals(skipKey.getRecoveryfilterkey4(), "003", "リカバリフィルタキー４");
        exStringEquals(skipKey.getRecoveryfilterkey5(), "004", "リカバリフィルタキー５");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean = SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);


        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd("JCD01JCD02JCD03JCD04");
        bzRecoveryDatasikibetuBean.setIbTableid("BT_SinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikae");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid("Bz105");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1("1012345678901234567890123456789012345678");

        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2("1012345678901234567890123456789012345677");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3("1012345678901234567890123456789012345676");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey4("1012345678901234567890123456789012345675");
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey5("1012345678901234567890123456789012345674");


        bzSkipKeyTableKakunou.exec();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BT_SkipKey skipKey = bizDomManager.getSkipKey("JCD01JCD02JCD03JCD04_BT_SinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikae_Bz105_1012345678901234567890123456789012345678_1012345678901234567890123456789012345677_1012345678901234567890123456789012345676_1012345678901234567890123456789012345675_1012345678901234567890123456789012345674");

        exStringEquals(skipKey.getKakutyoujobcd(), "JCD01JCD02JCD03JCD04", "拡張ジョブコード");
        exStringEquals(skipKey.getTableid(), "BT_SinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikaeDenSinkeiyakuHurikae", "テーブルＩＤ");
        exStringEquals(skipKey.getRecoveryfilterid(), "Bz105", "リカバリフィルタＩＤ");
        exStringEquals(skipKey.getRecoveryfilterkey1(), "1012345678901234567890123456789012345678", "リカバリフィルタキー１");
        exStringEquals(skipKey.getRecoveryfilterkey2(), "1012345678901234567890123456789012345677", "リカバリフィルタキー２");
        exStringEquals(skipKey.getRecoveryfilterkey3(), "1012345678901234567890123456789012345676", "リカバリフィルタキー３");
        exStringEquals(skipKey.getRecoveryfilterkey4(), "1012345678901234567890123456789012345675", "リカバリフィルタキー４");
        exStringEquals(skipKey.getRecoveryfilterkey5(), "1012345678901234567890123456789012345674", "リカバリフィルタキー５");
    }

}
