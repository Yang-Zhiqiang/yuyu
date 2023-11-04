package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 書類コード取得のメソッド {@link GetSyoruicd#getSyoruicd_Trksseikyu_idx()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSyoruicdTest_getSyoruicd_Trksseikyu_idx {

    @Inject
    private GetSyoruicd getSyoruicd;

    @Test
    @TestOrder(10)
    public void testGetSyoruicd_Trksseikyu_idx_A1() {
        exNumericEquals(getSyoruicd.getSyoruicd_Trksseikyu_idx(), 1, "書類コードインデックス");
    }
}