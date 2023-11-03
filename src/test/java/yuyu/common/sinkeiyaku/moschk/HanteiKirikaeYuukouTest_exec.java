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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 切替契約有効判定のメソッド {@link HanteiKirikaeYuukou#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiKirikaeYuukouTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_切替契約有効判定";

    private final static String sheetName = "テストデータ";

    @Inject
    private HanteiKirikaeYuukou hanteiKirikaeYuukou;

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
            testDataAndTblMap = testDataMaker.getInData(CheckHubiKanriTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }


    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791212129");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610161400000");
        hanteiKirikaeYuukou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubMsgLst.size(), 3, "不備メッセージの件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0212", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "同時解約証券番号に該当する契約が存在しません。", "不備メッセージ");
        exClassificationEquals(hubMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");

        exStringEquals(hubMsgLst.get(1).getMessageId(), "WHC0082", "不備メッセージID");
        exStringEquals(hubMsgLst.get(1).getHubimsg(), "同時解約証券番号に該当する契約は切替対象商品ではありません。", "不備メッセージ");
        exClassificationEquals(hubMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubMsgLst.get(1).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");

        exStringEquals(hubMsgLst.get(2).getMessageId(), "WHC0083", "不備メッセージID");
        exStringEquals(hubMsgLst.get(2).getHubimsg(), "同時解約証券番号に該当する契約は給付金請求歴があるため切替対象ではありません。", "不備メッセージ");
        exClassificationEquals(hubMsgLst.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubMsgLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubMsgLst.get(2).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791212137");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610161400000");

        hanteiKirikaeYuukou.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "同時解約証券番号に該当する契約は当社所定の基準を満たさないため、取扱対象外です。", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791212145");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610161400000");

        hanteiKirikaeYuukou.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubMsgLst.size(), 2, "件数");
        exStringEquals(hubMsgLst.get(0).getMessageId(), "EHC0212", "不備メッセージID");
        exStringEquals(hubMsgLst.get(0).getHubimsg(), "同時解約証券番号に該当する契約が存在しません。", "不備メッセージ");
        exClassificationEquals(hubMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");

        exStringEquals(hubMsgLst.get(1).getMessageId(), "WHC0082", "不備メッセージID");
        exStringEquals(hubMsgLst.get(1).getHubimsg(), "同時解約証券番号に該当する契約は切替対象商品ではありません。", "不備メッセージ");
        exClassificationEquals(hubMsgLst.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubMsgLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubMsgLst.get(1).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791212152");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610161400000");

        hanteiKirikaeYuukou.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "同時解約証券番号に該当する契約が存在しません。", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610161400000");

        hanteiKirikaeYuukou.exec(mosnaiCheckParam);
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "同時解約証券番号に該当する契約は切替対象商品ではありません。", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");


    }
}
