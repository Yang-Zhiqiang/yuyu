package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kzdou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 基本情報設定のメソッド{@link SetKouzaInfo#init(SetKouzaInfoExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKouzaInfoTest_init {

    private SetKouzaInfoExecUiBeanParamImpl uiBeanParam;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        uiBeanParam = SWAKInjector.getInstance(SetKouzaInfoExecUiBeanParamImpl.class);

        uiBeanParam.setKzdoukbn(C_Kzdou.DOUITU);
        uiBeanParam.setVkykskyknmkn("口座名義人氏名（カナ）");
        uiBeanParam.setKzmeiginmkn("");

        boolean result = SetKouzaInfo.init(uiBeanParam);

        exStringEquals(uiBeanParam.getKzmeiginmkn(),"口座名義人氏名（カナ）","（口座情報）口座名義人氏名（カナ）");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        uiBeanParam = SWAKInjector.getInstance(SetKouzaInfoExecUiBeanParamImpl.class);

        uiBeanParam.setKzdoukbn(C_Kzdou.BLNK);
        uiBeanParam.setVkykskyknmkn("口座名義人氏名（カナ）");
        uiBeanParam.setKzmeiginmkn("");

        boolean result = SetKouzaInfo.init(uiBeanParam);

        exStringEquals(uiBeanParam.getKzmeiginmkn(),"","（口座情報）口座名義人氏名（カナ）");

        exBooleanEquals(result, true, "処理結果");
    }
}
