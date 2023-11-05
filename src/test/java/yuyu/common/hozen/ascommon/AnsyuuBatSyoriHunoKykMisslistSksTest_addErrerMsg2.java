package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Dbhanei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納用バッチ処理不能契約ミスリスト作成クラスのメソッド {@link AnsyuuBatSyoriHunoKykMisslistSks#addErrerMsg(String, String, String)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuBatSyoriHunoKykMisslistSksTest_addErrerMsg2 {

    @Inject
    private AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks;

    @Test
    @TestOrder(10)
    public void testAddErrerMsg2_A1() {

        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(0);

        String exceptionMsg = "";

        try {
            ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000024", "ミスリストメッセージ202", "ログメッセージ203");
        } catch (Exception e) {
            exceptionMsg = e.getMessage();
        }

        exStringEquals(exceptionMsg, "システム整合性エラーです。許容上限を超える数のエラーを検知しました。　許容上限＝0", "例外メッセージ");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testAddErrerMsg2_A2() {
        MockObjectManager.initialize();

        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000035", "ミスリストメッセージ202", "ログメッセージ303");

        KhozenCommonParam pKhozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        ansyuuBatSyoriHunoKykMisslistSks.createReport(pKhozenCommonParam, BizDate.valueOf(19990101));

        @SuppressWarnings("unchecked")
        List<EditKhMisslstParam> reporteditKhMisslstParamList =
        (List<EditKhMisslstParam>) MockObjectManager.getArgument(EditKhMisslstTbl.class, "editBean", 0, 2);

        exNumericEquals(reporteditKhMisslstParamList.size(), 2, "ミスリストTBL編集パラメータリストのサイズ");

        exNumericEquals(reporteditKhMisslstParamList.get(0).getSeqNo(), 1, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(0).getDataNo(), 1, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(0).getMisslistMsg(), "処理不能エラーのため、以下の契約に対する処理をスキップしました。システム管理者に連絡してください。\r\nエラー発生件数：1件（ミスリストには最大50件まで印字）", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(0).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(0).getSyoNo(), "", "証券番号");

        exNumericEquals(reporteditKhMisslstParamList.get(1).getSeqNo(), 2, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(1).getDataNo(), 2, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(1).getMisslistMsg(), "ミスリストメッセージ202", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(1).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(1).getSyoNo(), "17806000035", "証券番号");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testAddErrerMsg2_A3() {
        MockObjectManager.initialize();

        ansyuuBatSyoriHunoKykMisslistSks.setPageLimit(0);
        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000046", "ミスリストメッセージ203", "ログメッセージ303");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, BizDate.valueOf(19990101));

        @SuppressWarnings("unchecked")
        List<EditKhMisslstParam> reporteditKhMisslstParamList =
        (List<EditKhMisslstParam>) MockObjectManager.getArgument(EditKhMisslstTbl.class, "editBean", 0, 2);

        exNumericEquals(reporteditKhMisslstParamList.size(), 1, "ミスリストTBL編集パラメータリストのサイズ");

        exNumericEquals(reporteditKhMisslstParamList.get(0).getSeqNo(), 1, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(0).getDataNo(), 1, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(0).getMisslistMsg(), "処理不能エラーのため、以下の契約に対する処理をスキップしました。システム管理者に連絡してください。\r\nエラー発生件数：1件（ミスリストには最大-1件まで印字）", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(0).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(0).getSyoNo(), "", "証券番号");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testAddErrerMsg2_A4() {
        MockObjectManager.initialize();

        ansyuuBatSyoriHunoKykMisslistSks.setPageLimit(1);

        for (int i = 1; i < 16; i++) {
            ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000057", "ミスリストメッセージ" + i, "ログメッセージ" + i);
        }

        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000057", "ミスリストメッセージ" + 16, "ログメッセージ" + 16);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, BizDate.valueOf(19990101));

        @SuppressWarnings("unchecked")
        List<EditKhMisslstParam> reporteditKhMisslstParamList =
        (List<EditKhMisslstParam>) MockObjectManager.getArgument(EditKhMisslstTbl.class, "editBean", 0, 2);

        exNumericEquals(reporteditKhMisslstParamList.size(), 17, "ミスリストTBL編集パラメータリストのサイズ");

        exNumericEquals(reporteditKhMisslstParamList.get(0).getSeqNo(), 1, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(0).getDataNo(), 1, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(0).getMisslistMsg(), "処理不能エラーのため、以下の契約に対する処理をスキップしました。システム管理者に連絡してください。\r\nエラー発生件数：16件（ミスリストには最大16件まで印字）", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(0).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(0).getSyoNo(), "", "証券番号");

        exNumericEquals(reporteditKhMisslstParamList.get(16).getSeqNo(), 17, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(16).getDataNo(), 17, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(16).getMisslistMsg(), "ミスリストメッセージ16", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(16).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(16).getSyoNo(), "17806000057", "証券番号");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testAddErrerMsg2_A5() {

        MockObjectManager.initialize();

        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(1);

        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000220", "ミスリストメッセージ501", "ログメッセージ501");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, BizDate.valueOf(19990101));

        @SuppressWarnings("unchecked")
        List<EditKhMisslstParam> reporteditKhMisslstParamList =
        (List<EditKhMisslstParam>) MockObjectManager.getArgument(EditKhMisslstTbl.class, "editBean", 0, 2);

        exNumericEquals(reporteditKhMisslstParamList.size(), 2, "ミスリストTBL編集パラメータリストのサイズ");

        exNumericEquals(reporteditKhMisslstParamList.get(0).getSeqNo(), 1, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(0).getDataNo(), 1, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(0).getMisslistMsg(), "処理不能エラーのため、以下の契約に対する処理をスキップしました。システム管理者に連絡してください。\r\nエラー発生件数：1件（ミスリストには最大50件まで印字）", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(0).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(0).getSyoNo(), "", "証券番号");

        exNumericEquals(reporteditKhMisslstParamList.get(1).getSeqNo(), 2, "SEQ-NO");
        exNumericEquals(reporteditKhMisslstParamList.get(1).getDataNo(), 2, "データ番号");
        exStringEquals(reporteditKhMisslstParamList.get(1).getMisslistMsg(), "ミスリストメッセージ501", "ミスリストメッセージ");
        exClassificationEquals(reporteditKhMisslstParamList.get(1).getDBhaneikbn(), C_Dbhanei.NONE, "DB反映区分");
        exStringEquals(reporteditKhMisslstParamList.get(1).getSyoNo(), "17806000220", "証券番号");
    }
}
