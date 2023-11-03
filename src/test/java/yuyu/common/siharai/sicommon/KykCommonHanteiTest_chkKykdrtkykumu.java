package yuyu.common.siharai.sicommon;


import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約内容共通判定クラスの契約者代理特約有無判定メソッド {@link KykCommonHantei#chkKykdrtkykumu(JT_SiKykKihon)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KykCommonHanteiTest_chkKykdrtkykumu {

    @Inject
    private KykCommonHantei kykCommonHantei;

    @Test
    @TestOrder(10)
    public void testChkKykdrtkykumu_A1() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setKykdrtkykhukaumu(C_UmuKbn.NONE);

        boolean result = kykCommonHantei.chkKykdrtkykumu(siKykKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(20)
    public void testChkKykdrtkykumu_A2() {

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000071");
        siKykKihon.setKykdrtkykhukaumu(C_UmuKbn.ARI);

        boolean result = kykCommonHantei.chkKykdrtkykumu(siKykKihon);

        exBooleanEquals(result, true, "判定結果フラグ");
    }

}
