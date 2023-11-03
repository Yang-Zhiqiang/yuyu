package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 予定契約日チェッククラスのメソッド {@link CheckYoteiKykYmd#exec(MosnaiCheckParam pMP)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckYoteiKykYmdTest_exec {

    private final static String mosNo1 = "860000017";

    private final static String mosNo2 = "860000025";

    private final static String mosNo3 = "860000033";

    private final static String mosNo4 = "860000041";

    private final static String mosNo5 = "860000058";

    private final static String mosNo6 = "860000066";


    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_予定契約日チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckYoteiKykYmdTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }}
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.getDataSyoriControl().setMosKihon(mosKihon);
        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(pMP.getSekmossakuseiErrmsg1(), "計算基準日エラー　計算基準日指定範囲外", "設計書申込書作成エラーメッセージ１");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "１ヶ月前から２ヶ月後の範囲にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(pMP.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.getDataSyoriControl().setMosKihon(mosKihon);
        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(pMP.getSekmossakuseiErrmsg1(),"", "設計書申込書作成エラーメッセージ１");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(pMP.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.getDataSyoriControl().setMosKihon(mosKihon);
        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(pMP.getSekmossakuseiErrmsg1(),"", "設計書申込書作成エラーメッセージ１");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(pMP.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.getDataSyoriControl().setMosKihon(mosKihon);
        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(pMP.getSekmossakuseiErrmsg1(),"", "設計書申込書作成エラーメッセージ１");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(pMP.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.getDataSyoriControl().setMosKihon(mosKihon);
        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(pMP.getSekmossakuseiErrmsg1(), "計算基準日エラー　計算基準日指定範囲外", "設計書申込書作成エラーメッセージ１");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "１ヶ月前から２ヶ月後の範囲にしてください", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(pMP.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分 ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setYoteiKykymdKbn(C_YoteikykymdKbn.AUTO);
        pMP.setDataSyoriControl(syoriCTL);
        pMP.getDataSyoriControl().setMosKihon(mosKihon);
        CheckYoteiKykYmd checkYoteiKykYmd = SWAKInjector.getInstance(CheckYoteiKykYmd.class);
        checkYoteiKykYmd.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(pMP.getSekmossakuseiErrmsg1(),"", "設計書申込書作成エラーメッセージ１");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(pMP.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分 ");
    }
}
