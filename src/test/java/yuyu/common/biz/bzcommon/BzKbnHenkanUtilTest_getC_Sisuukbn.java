package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通　区分変換処理クラスのメソッド {@link BzKbnHenkanUtil#getC_Sisuukbn(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKbnHenkanUtilTest_getC_Sisuukbn {

    @Inject
    private BzKbnHenkanUtil bzKbnHenkanUtil;

    @Test
    @TestOrder(10)
    public void testC_Sisuukbn_A1() {

        String before = "0";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(20)
    public void testC_Sisuukbn_A2() {

        String before = "1";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(30)
    public void testC_Sisuukbn_A3() {

        String before = "2";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(40)
    public void testConvKbn_B1() {

        String before = "0";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "0", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), false, "区分値変換結果");
    }

    @Test
    @TestOrder(50)
    public void testConvKbn_B2() {

        String before = "1";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "1", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

    @Test
    @TestOrder(60)
    public void testConvKbn_B3() {

        String before = "2";
        Class<?> clazz = C_Sisuukbn.class;
        C_SystemRenkeiHenkanHoukouKbn direction = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(before, clazz, direction);

        exStringEquals(kbnInfoBean.getKbnData(), "2", "変換後データ");
        exBooleanEquals(kbnInfoBean.isHenkanFlg(), true, "区分値変換結果");
    }

}