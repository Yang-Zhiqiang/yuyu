package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 書類コード取得のメソッド {@link GetSyoruicd#getSyoruicd_Yuukoukknkeikatyouka()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSyoruicdTest_getSyoruicd_Yuukoukknkeikatyouka {

    @Inject
    private GetSyoruicd getSyoruicd;

    @Test
    @TestOrder(10)
    public void testGetSyoruicd_Yuukoukknkeikatyouka_A1() {
        exClassificationEquals(getSyoruicd.getSyoruicd_Yuukoukknkeikatyouka(), C_SyoruiCdKbn.SK_YUUKOUKKNTYOUKALIST, "書類コード");
    }
}