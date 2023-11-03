package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通　暗号化ユーティリティクラスのメソッド {@link BzEncryptUtil#raydbEncrypt(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzEncryptUtilTest_raydbEncrypt {

    @Test
    @TestOrder(10)
    public void testraydbEncrypt_A1() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbEncrypt(null);
        exStringEquals(value, null, "暗号文");
    }

    @Test
    @TestOrder(20)
    public void testraydbEncrypt_A2() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbEncrypt("");
        exStringEquals(value, "", "暗号文");
    }

    @Test
    @TestOrder(30)
    public void testraydbEncrypt_B1() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbEncrypt("a");
        exStringEquals(value, "oXVJ95MGTmTPCKjdAFxMJw==", "暗号文");
    }

    @Test
    @TestOrder(40)
    public void testraydbEncrypt_B2() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbEncrypt("-1");
        exStringEquals(value, "aS5F11TcstdE0X12JvYbag==", "暗号文");
    }

    @Test
    @TestOrder(50)
    public void testraydbEncrypt_B3() {
        BzEncryptUtil bzEncryptUtil = BzEncryptUtil.getInstance();

        String value = bzEncryptUtil.raydbEncrypt("AbCd9876");
        exStringEquals(value, "R4M79lO4qNZRZN16T/HLYA==", "暗号文");
    }

}