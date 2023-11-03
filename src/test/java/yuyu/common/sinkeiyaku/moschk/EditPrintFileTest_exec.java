package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.sinkeiyaku.skcommon.EditPdfKykKakuninIraisyo;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_KykKak;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 帳票ファイル編集クラスのメソッド {@link EditPrintFile#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPrintFileTest_exec {

    @Inject
    private EditPrintFile editPrintFile;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_帳票ファイル編集";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql = "delete from " + "AT_TyouhyouHozon";
        exDBEntityManager.createJPQL(jpql).executeUpdate();

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPrintFileTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);} catch (TestDataMakerException e) {
                e.printStackTrace();
            }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        MosnaiCheckParam mp = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        mp.setDataSyoriControl(syoriCTL);
        mp.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.YOU);
        mp.setSysDate(BizDate.valueOf("20160125"));
        mp.setKosID("TestKos");
        mp.setKosTime("20160125010101011");

        editPrintFile.exec(mp);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_KykKak> kykKakLst = syoriCTL.getKykKaks();

        exNumericEquals(kykKakLst.size(), 1, "契約確認テーブルエンティティリストのサイズ");
        exStringEquals(kykKakLst.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(kykKakLst.get(0).getRenno(), 1, "連番");
        exClassificationEquals(kykKakLst.get(0).getKykkaksyrui(), C_Kykkaksyrui.KETMAE, "契約確認種類");
        exStringEquals(kykKakLst.get(0).getKykkaktantcd(), "", "契約確認担当者コード");
        exStringEquals(kykKakLst.get(0).getKykkakkaisyacd(), "", "契約確認会社コード");
        exDateEquals(kykKakLst.get(0).getKykkakiraiymd(), BizDate.valueOf("20160125"), "契約確認依頼日");
        exDateEquals(kykKakLst.get(0).getKykkakkanytymd(), null, "契約確認完了予定日");
        exClassificationEquals(kykKakLst.get(0).getKykkakkekkbn(), C_KykkakkekKbn.BLNK, "契約確認結果区分");
        exDateEquals(kykKakLst.get(0).getKykkakkanymd(), null, "契約確認完了日");
        exStringEquals(kykKakLst.get(0).getKykkakcomment(), "", "契約確認コメント");
        exStringEquals(kykKakLst.get(0).getGyoumuKousinsyaId(), "TestKos", "業務用更新者ＩＤ");
        exStringEquals(kykKakLst.get(0).getGyoumuKousinTime(), "20160125010101011", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        MosnaiCheckParam mp = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");

        mp.setDataSyoriControl(syoriCTL);
        mp.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.YOU);
        mp.setSysDate(BizDate.valueOf("20160125"));
        mp.setKosID("TestKos");
        mp.setKosTime("20160125010101011");

        editPrintFile.exec(mp);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_KykKak> kykKakLst = syoriCTL.getKykKaks();

        kykKakLst = new SortHT_KykKak().OrderHT_KykKakByPkAsc(kykKakLst);

        exNumericEquals(kykKakLst.size(), 4, "契約確認テーブルエンティティリストのサイズ");
        exStringEquals(kykKakLst.get(3).getMosno(), "791112238", "申込番号");
        exNumericEquals(kykKakLst.get(3).getRenno(), 4, "連番");
        exClassificationEquals(kykKakLst.get(3).getKykkaksyrui(), C_Kykkaksyrui.KETMAE, "契約確認種類");
        exStringEquals(kykKakLst.get(3).getKykkaktantcd(), "", "契約確認担当者コード");
        exStringEquals(kykKakLst.get(3).getKykkakkaisyacd(), "", "契約確認会社コード");
        exDateEquals(kykKakLst.get(3).getKykkakiraiymd(), BizDate.valueOf("20160125"), "契約確認依頼日");
        exDateEquals(kykKakLst.get(3).getKykkakkanytymd(), null, "契約確認完了予定日");
        exClassificationEquals(kykKakLst.get(3).getKykkakkekkbn(), C_KykkakkekKbn.BLNK, "契約確認結果区分");
        exDateEquals(kykKakLst.get(3).getKykkakkanymd(), null, "契約確認完了日");
        exStringEquals(kykKakLst.get(3).getKykkakcomment(), "", "契約確認コメント");
        exStringEquals(kykKakLst.get(3).getGyoumuKousinsyaId(), "TestKos", "業務用更新者ＩＤ");
        exStringEquals(kykKakLst.get(3).getGyoumuKousinTime(), "20160125010101011", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        MosnaiCheckParam mp = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        mp.setDataSyoriControl(syoriCTL);
        mp.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.HUYOU);
        mp.setSysDate(BizDate.valueOf("20160125"));
        mp.setKosID("TestKos");
        mp.setKosTime("20160125010101011");

        editPrintFile.exec(mp);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_KykKak> kykKakLst = syoriCTL.getKykKaks();

        exNumericEquals(kykKakLst.size(), 0, "契約確認テーブルエンティティリストのサイズ");
        MockObjectManager.assertNotCalled(EditPdfKykKakuninIraisyo.class, "exec");
    }
}