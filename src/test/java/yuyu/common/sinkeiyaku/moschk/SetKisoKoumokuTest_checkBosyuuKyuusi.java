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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 基礎項目設定クラスのメソッド {@link SetKisoKoumoku#checkBosyuuKyuusi(MosnaiCheckParam, String, String
        , String, C_SkeijimuKbn, C_BoskyuusiRiyuuKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKisoKoumokuTest_checkBosyuuKyuusi {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SetKisoKoumoku setKisoKoumoku;

    private final static String fileName = "UT_SP_単体テスト仕様書_基礎項目設定";

    private final static String sheetName = "INデータ_20191008";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKisoKoumokuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBosyuuKyuusi());
    }

    @Test
    @TestOrder(10)
    public void testCheckBosyuuKyuusi_A1() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕﾈ", "", "", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.BLNK);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testCheckBosyuuKyuusi_A2() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "2", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.BLNK);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testCheckBosyuuKyuusi_A3() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20210224142000000");

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕﾍ", "1", "3", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.RATE);

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "THC1171", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】不備メッセージ１募集休止です。申込撤回のお手続きを実施ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20210224142000000", "業務用更新時間");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testCheckBosyuuKyuusi_A4() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20210224142000000");

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾆｱ", "1", "4", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.HANBAIRYOU);

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000033", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "KHC1171", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "（特認済）不備メッセージ２募集休止です。申込撤回のお手続きを実施ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20210224142000000", "業務用更新時間");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testCheckBosyuuKyuusi_A5() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20210224142000000");

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "5", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.OTHER);

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000041", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1026", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不備メッセージ３", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20210224142000000", "業務用更新時間");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testCheckBosyuuKyuusi_A6() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20210224142000000");

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "6", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.BLNK);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testCheckBosyuuKyuusi_A7() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20210224142000000");

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "7", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.BLNK);

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000066", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1171", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不備メッセージ６", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KIHON_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20210224142000000", "業務用更新時間");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testCheckBosyuuKyuusi_A8() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "3", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.RATE);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "不備メッセージ８のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testCheckBosyuuKyuusi_A9() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "4", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.HANBAIRYOU);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "不備メッセージ９のお取扱いは現在休止しています", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(100)
    public void testCheckBosyuuKyuusi_A10() {

        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        C_ErrorKbn errorKbn = setKisoKoumoku.checkBosyuuKyuusi(
            mosnaiCheckParam, "ﾕｱ", "1", "5", C_SkeijimuKbn.BLNK, C_BoskyuusiRiyuuKbn.OTHER);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "生保Ｗｅｂメッセージ１８", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "生保Ｗｅｂメッセージ２８", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }
}
