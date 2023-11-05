package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全区分パターン設定のメソッド {@link SetKhKbnPatternUtil#exec(SetKhKbnPatternUtilUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKhKbnPatternUtilTest_exec {

    @Inject
    private SetKhKbnPatternUtilUiBeanParamImpl setKhKbnPatternUtilUiBeanParamImpl;

    @Inject
    private SetKhKbnPatternUtil setKhKbnPatternUtil;

    @Inject
    private AS_Kinou kinou;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_HUBITOUROKU);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.HUBITOUROKU);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "19", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_HUBITOUROKU);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.HUBISYOUNIN);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "20", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_HUBITOUROKU);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.INPUTKEY);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), null, "処理結果区分パターンID");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_HUBIKAISYOU);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "21", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.INPUT);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "14", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.TENKEN);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "15", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.SYOUNIN);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "18", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.INPUTKEY);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "13", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.SYOUKAI);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), null, "処理結果区分パターンID");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.KYUUKZANNAIMATI);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "16", "処理結果区分パターンID");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        kinou.setKinouId(IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA);

        setKhKbnPatternUtilUiBeanParamImpl = SWAKInjector.getInstance(SetKhKbnPatternUtilUiBeanParamImpl.class);

        setKhKbnPatternUtilUiBeanParamImpl.setKhkinouModeIdKbn(C_KhkinouModeIdKbn.CARDTOUROKUMATI);

        setKhKbnPatternUtil.exec(setKhKbnPatternUtilUiBeanParamImpl);

        exStringEquals(setKhKbnPatternUtilUiBeanParamImpl.getPatternSyorikekkakbn(), "17", "処理結果区分パターンID");

    }
}
