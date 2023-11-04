package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通　暗号化ユーティリティクラスのメソッド {@link BzEncryptUtil#raydbDecrypt(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzEncryptUtilTest_raydbDecrypt {

    @Test
    @TestOrder(10)
    public void testraydbDecrypt_A1() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbDecrypt(null);
        exStringEquals(value, null, "平文");
    }

    @Test
    @TestOrder(20)
    public void testraydbDecrypt_A2() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbDecrypt("");
        exStringEquals(value, "", "平文");
    }

    @Test
    @TestOrder(30)
    public void testraydbDecrypt_B1() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbDecrypt("oXVJ95MGTmTPCKjdAFxMJw==");
        exStringEquals(value, "a", "平文");
    }

    @Test
    @TestOrder(40)
    public void testraydbDecrypt_B2() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbDecrypt("aS5F11TcstdE0X12JvYbag==");
        exStringEquals(value, "-1", "平文");
    }

    @Test
    @TestOrder(50)
    public void testraydbDecrypt_B3() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbDecrypt("R4M79lO4qNZRZN16T/HLYA==");
        exStringEquals(value, "AbCd9876", "平文");
    }

}