package yuyu.common.hozen.ascommon;

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
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納用バッチ処理不能契約ミスリスト作成クラスのメソッド {@link AnsyuuBatSyoriHunoKykMisslistSks#createReport(KhozenCommonParam, BizDate)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuBatSyoriHunoKykMisslistSksTest_createReport {

    @Inject
    private AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_案内収納用バッチ処理不能契約ミスリスト作成";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(AnsyuuBatSyoriHunoKykMisslistSksTest_createReport.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        AT_SequenceValue sequenceValue = baseDomManager.getSequenceValueByIdKeys("90", "_DEFAULT_");
        AT_TyouhyouHozon tyouhyouHozon = baseDomManager.getTyouhyouHozon("000000000000000006");
        if (sequenceValue != null) {
            baseDomManager.delete(sequenceValue);
        }
        if (tyouhyouHozon != null) {
            baseDomManager.delete(tyouhyouHozon);
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport_A1() {
        MockObjectManager.initialize();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String reportKey = ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, BizDate.valueOf(20200101));

        exStringEquals(reportKey, "000000000000000006", "帳票キー");

        BizDate syoriymd = (BizDate) MockObjectManager.getArgument(EditKhMisslstTbl.class, "editBean", 0, 3);
        @SuppressWarnings("unchecked")
        List<EditKhMisslstParam> reporteditKhMisslstParamList =
        (List<EditKhMisslstParam>) MockObjectManager.getArgument(EditKhMisslstTbl.class, "editBean", 0, 2);

        int dateNo = reporteditKhMisslstParamList.get(0).getDataNo();
        int seqNo = reporteditKhMisslstParamList.get(0).getSeqNo();
        String misslistMsg = reporteditKhMisslstParamList.get(0).getMisslistMsg();
        C_Dbhanei dbhaneikbn = reporteditKhMisslstParamList.get(0).getDBhaneikbn();
        String syoNo = reporteditKhMisslstParamList.get(0).getSyoNo();

        exDateEquals(syoriymd, BizDate.valueOf(20200101), "処理日");

        exNumericEquals(dateNo, 1, "データ番号");
        exNumericEquals(seqNo, 1, "SEQ-NO");
        exStringEquals(misslistMsg, "処理不能エラーのため、以下の契約に対する処理をスキップしました。システム管理者に連絡してください。"
            + "\r\n" + "エラー発生件数：0件（ミスリストには最大50件まで印字）",
            "ミスリストメッセージ");
        exClassificationEquals(dbhaneikbn, C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(syoNo, "", "証券番号");
    }
}
