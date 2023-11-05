package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 書類コード取得のメソッド {@link GetSyoruicd#getSyoruicd_Trksseikyu_set()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSyoruicdTest_getSyoruicd_Trksseikyu_set {

    @Inject
    private GetSyoruicd getSyoruicd;

    @Test
    @TestOrder(10)
    public void testGetSyoruicd_Trksseikyu_set_A1() {
        C_SyoruiCdKbn[] trksseikyus = getSyoruicd.getSyoruicd_Trksseikyu_set();

        exNumericEquals(trksseikyus.length, 2, "レングス");
        exClassificationEquals(trksseikyus[0], C_SyoruiCdKbn.SK_TRKSSEIKYU_SOUHU, "書類コード");
        exClassificationEquals(trksseikyus[1], C_SyoruiCdKbn.SK_TRKSSEIKYU, "書類コード");
    }
}