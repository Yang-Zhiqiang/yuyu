package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備未解消リストＣＳＶ作成のメソッド {@link EditCsvHubiMikai#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditCsvHubiMikaiTest_exec_1 {

    @Inject
    private EditCsvHubiMikai editCsvHubiMikai;

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        int totalCount = editCsvHubiMikai.exec(BizDate.valueOf("20160412"));

        exNumericEquals(totalCount, 0, "出力件数");

    }
}
