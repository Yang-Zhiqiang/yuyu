package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsijisyoyhKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ設定クラスのメソッド {@link SetHubiMsg#exec(C_KetsrhkosKbn, String, MosnaiCheckParam, C_TknKbn, C_MsgKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHubiMsgTest_exec_3 {

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_不備メッセージ設定";

    private final static String sheetName = "INデータ";


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHubiMsgTest_exec_3.class, fileName, sheetName);
            testDataMaker.insDataByDataId("テストデータ2", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KOS_NONE;
        String message = "EBC1014 口座名義人同一区分に同一は指定できません。あああああいいいいい12345に口座名義人に使用できない文字が含まれています。";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        setHubiMsg.exec(ketsrhkosKbn, message, mosnaiCheckParam, tknKbn, pMsgKbn);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "口座名義人同一区分に同一は指定できません。あああああいいいいい１２３４５に口座名",
            "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "義人に使用できない文字が含まれています。", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.KETHORYU_HUBI;
        String message = "EAC0007 抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささAAAAAAAAAA1234567890BCDEFGを設定してください。";
        C_TknKbn tknKbn = C_TknKbn.NONE;
        C_MsgKbn pMsgKbn = C_MsgKbn.ERROR;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        List<HT_HubiMsg> hubiMsgList = syoriCTL.getHubiMsgs();

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user0100002000");
        mosnaiCheckParam.setKosTime("20160715111400000");

        assertNotNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 1, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 1, "その他特約条件付テーブル件数");

        setHubiMsg.exec(ketsrhkosKbn, message, mosnaiCheckParam, tknKbn, pMsgKbn);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.ARI, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.NONE, "成立区分");
        assertNull(syoriCTL.getTokujyou());
        exNumericEquals(syoriCTL.getSyouhnTokujyous().size(), 0, "商品別特条条件付テーブル件数");
        exNumericEquals(syoriCTL.getSonotaTkykJktks().size(), 0, "その他特約条件付テーブル件数");

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.YOU, "決定指示書要否区分");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(0), "決定保留不備があるため、再決定が必要です。", "決定指示ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(0), "WHC0018", "決定指示ＭＳＧＩＤ");
        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "条件付決定が取消されました。申込書入力にて契約内容を条件付前の状態に変更してください。", "結果画面ＭＳＧ");

        exNumericEquals(hubiMsgList.size(), 10, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsgList.get(9).getMosno(), "791112394", "申込番号");
        exNumericEquals(hubiMsgList.get(9).getRenno(), 10, "連番");
        exStringEquals(hubiMsgList.get(9).getMessageId(), "EAC0007", "メッセージＩＤ");
        exStringEquals(
            hubiMsgList.get(9).getHubimsg(),
            "抽出条件ああああああああああいいいいいいいいいいおおおおおおおおおおううううううううううええええええええええかかかかかかかかかかききききききききききここここここここここくくくくくくくくくくけけけけけけけけけけささささささささささＡＡＡＡＡＡＡＡＡＡ１２３４５６７８９０ＢＣＤＥＦＧを設定してください。",
            "不備メッセージ");
        exClassificationEquals(hubiMsgList.get(9).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsgList.get(9).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsgList.get(9).getGyoumuKousinsyaId(), "user0100002000", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgList.get(9).getGyoumuKousinTime(), "20160715111400000", "業務用更新時間");

    }
}
