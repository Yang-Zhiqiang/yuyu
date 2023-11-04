package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 発売期間チェック {@link CheckHatubaikkn#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckHatubaikknTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_発売期間チェック";

    private final static String sheetName = "INデータ_20160909";

    @Inject
    private CheckHatubaikkn checkHatubaikkn;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckHatubaikknTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(msgLst.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(msgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(msgLst.get(0).getMessageId(), "EHC0188", "メッセージＩＤ");
        exStringEquals(msgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定が発売期間範囲外です。", "不備メッセージ");
        exClassificationEquals(msgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(msgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(msgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(msgLst.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112238");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(msgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定が発売期間範囲外です。", "不備メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112246");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(msgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定が発売期間範囲外です。", "不備メッセージ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112253");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(msgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１５年毎利率再設定が発売期間範囲外です。", "不備メッセージ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112261");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112279");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112378");
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("790000012");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(msgLst.get(0).getMosno(), "790000012", "申込番号");
        exNumericEquals(msgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(msgLst.get(0).getMessageId(), "EHC0188", "メッセージＩＤ");
        exStringEquals(msgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定が発売期間範囲外です。", "不備メッセージ");
        exClassificationEquals(msgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(msgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(msgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(msgLst.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("790000020");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("790000038");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("790000046");

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        checkHatubaikkn.exec(mosnaiCheckParam);

        List<HT_HubiMsg> msgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(msgLst.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exStringEquals(msgLst.get(0).getMosno(), "790000046", "申込番号");
        exNumericEquals(msgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(msgLst.get(0).getMessageId(), "EHC0188", "メッセージＩＤ");
        exStringEquals(msgLst.get(0).getHubimsg(), "外貨建て一時払終身保険（毎年受取型）　１０年毎利率再設定が発売期間範囲外です。", "不備メッセージ");
        exClassificationEquals(msgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(msgLst.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(msgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(msgLst.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }
}
