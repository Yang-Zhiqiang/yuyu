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
 * 案内収納用バッチ処理不能契約ミスリスト作成クラスのメソッド {@link AnsyuuBatSyoriHunoKykMisslistSks#addErrerMsg(String, String)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuBatSyoriHunoKykMisslistSksTest_addErrerMsg1 {

    @Inject
    private AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks;

    @Test
    @TestOrder(10)
    @Transactional
    public void testAddErrerMsg1_A1() {
        MockObjectManager.initialize();

        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000013", "ミスリストメッセージ202");

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
        exStringEquals(reporteditKhMisslstParamList.get(1).getSyoNo(), "17806000013", "証券番号");
    }
}
