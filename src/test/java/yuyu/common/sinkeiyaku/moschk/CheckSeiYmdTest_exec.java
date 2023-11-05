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
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生年月日範囲チェックのメソッド {@link CheckSeiYmd#exec()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckSeiYmdTest_exec {

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "860000173";

    private final static String fileName = "UT_SP_単体テスト仕様書_生年月日範囲チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckSeiYmd checkSeiYmd;

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
            testDataAndTblMap = testDataMaker.getInData(CheckSeiYmdTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150610"));
        BizDate seiYmd = null;
        String hubiMsg = null;

        checkSeiYmd.exec(mosnaiCheckParam, seiYmd, hubiMsg);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsgLst.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150610"));
        BizDate seiYmd = BizDate.valueOf("20150609");
        String hubiMsg = "";

        checkSeiYmd.exec(mosnaiCheckParam, seiYmd, hubiMsg);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(String.valueOf(hubiMsgLst.size()), "0", "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_B2() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150610"));
        BizDate seiYmd = BizDate.valueOf("20150610");
        String hubiMsg = "生年月日";

        checkSeiYmd.exec(mosnaiCheckParam, seiYmd, hubiMsg);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(String.valueOf(hubiMsgLst.size()), "0", "不備メッセージテーブルの件数");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_B3() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20150610"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150610161400000");
        BizDate seiYmd = BizDate.valueOf("20150611");
        String hubiMsg = "生年月日";

        checkSeiYmd.exec(mosnaiCheckParam, seiYmd, hubiMsg);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsgLst.get(0).getMosno(), mosNo1, "申込番号");
        exNumericEquals(hubiMsgLst.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsgLst.get(0).getMessageId(), "EBC0046", "不備メッセージID");
        exStringEquals(hubiMsgLst.get(0).getHubimsg(), "生年月日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsgLst.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsgLst.get(0).getGyoumuKousinTime(), "20150610161400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_B4() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20180109"));
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20160911191800000");
        BizDate seiYmd = BizDate.valueOf("20180110");
        String hubiMsg = "年月日";

        checkSeiYmd.exec(mosnaiCheckParam, seiYmd, hubiMsg);

        List<HT_HubiMsg> hubiMsgLst = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(String.valueOf(hubiMsgLst.size()), "0", "不備メッセージテーブルの件数");

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN,
            "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "年月日先日付け", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
    }

}