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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払込回数チェッククラスのメソッド {@link CheckHrkKaisuu#exec(MosnaiCheckParam , BM_SyouhnZokusei)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckHrkKaisuuTest_exec {

    private final static String mosNo1 = "780000014";

    private final static String mosNo2 = "780000022";

    private final static String mosNo3 = "780000030";

    private final static String mosNo4 = "860000017";

    private final static String mosNo5 = "860000025";

    private final static String mosNo6 = "860000033";

    private final static String mosNo7 = "860000041";

    private final static String mosNo8 = "860000058";

    private final static String mosNo9 = "860000066";

    private final static String mosNo10 = "860000074";

    private final static String mosNo11 = "860000082";

    private final static String mosNo12 = "860000090";

    private final static String fileName = "UT-SP_単体テスト仕様書_払込回数チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckHrkKaisuu checkHrkKaisuu;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckHrkKaisuuTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾁ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾂ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾃ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾄ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾅ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾆ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾇ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾈ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ｹ9", 1));

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルエンティティリストの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "780000014", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の一時払いは取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "780000014", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の２か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(2).getMosno(), "780000014", "申込番号");
        exNumericEquals(hubiMsg.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsg.get(2).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(2).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の２か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "780000022", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1108", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            "払込回数が「月払」以外の場合、２か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "780000022", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EBA0027", "メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期一括払保険料を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(2).getMosno(), "780000022", "申込番号");
        exNumericEquals(hubiMsg.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsg.get(2).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(2).getHubimsg(),
            "外貨建て一時払終身保険（即時保障型）　１０年毎利率再設定の２か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        try {
            checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);
        } catch(CommonBizAppException e) {

            syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
            List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
            exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリスト件数");

            exStringEquals(hubiMsg.get(0).getMosno(), "780000030", "申込番号");
            exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
            exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0019", "メッセージID");
            exStringEquals(hubiMsg.get(0).getHubimsg(),
                "外貨建て一時払終身保険（即時保障型）　１５年毎利率再設定の年１回払は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
            exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

            exStringEquals(hubiMsg.get(1).getMosno(), "780000030", "申込番号");
            exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
            exStringEquals(hubiMsg.get(1).getMessageId(), "EHC1108", "メッセージID");
            exStringEquals(hubiMsg.get(1).getHubimsg(),
                "払込回数が「月払」以外の場合、２か月一括払は取扱えません。", "不備メッセージ");
            exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
            exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
            exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

            exStringEquals(e.getMessage(),
                "システム整合性エラーです。主契約申込商品件数異常 申込番号：780000030", "エラーメッセージ");
            throw e;

        }

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリストの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBA0027", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "払込回数を入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000017", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EBC0007", "メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期一括払保険料は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリストの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の月払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の２か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリストの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860000033", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の年２回払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000033", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の６か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルエンティティリストの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の年１回払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(1).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の１２か月一括払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリストの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860000058", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0019", "メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            "初期死亡保険金抑制型一時払終身保険（外貨建）の年２回払は取扱えません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");

        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);

        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        mosnaiCheckParam.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);

        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        exBooleanEquals(C_SekmossakuseiErroutKbn.NONE.eq(mosnaiCheckParam.getSekmossakuseiErroutKbn())
                , true, "設計書申込書作成エラー出力区分");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        mosnaiCheckParam.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.NONE);

        checkHrkKaisuu.exec(mosnaiCheckParam, pSyouhinZokusei);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        exBooleanEquals(C_SekmossakuseiErroutKbn.NONE.eq(mosnaiCheckParam.getSekmossakuseiErroutKbn())
                , true, "設計書申込書作成エラー出力区分");

    }
}
