package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.lang.reflect.Field;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_EncryptKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * セキュリティ項目編集クラスのメソッド {@link EditSecurityKm#getEncodeData(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSecurityKmTest_getEncodeData {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testGetEncodeData_A1() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SURU);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData(null, null);
        exStringEquals(value, null, "暗号文");
    }

    @Test
    @TestOrder(20)
    public void testGetEncodeData_A2() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SURU);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData("", "");
        exStringEquals(value, "", "暗号文");
    }

    @Test
    @TestOrder(30)
    public void testGetEncodeData_B1() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SINAI);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData("10000000001", "123456");
        exStringEquals(value, "123456", "暗号文");
    }

    @Test
    @TestOrder(40)
    public void testGetEncodeData_B2() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SURU);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData("10000000001", "123456");
        exStringEquals(value, "12A31842D5B09D82AEF343115E22A86F", "暗号文");
    }

    @Test
    @TestOrder(50)
    public void testGetEncodeData_B3() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SINAI);
        YuyuBaseConfig.getInstance().setDebugMode(false);

        String value = EditSecurityKm.getEncodeData("10000000001", "123456");
        exStringEquals(value, "12A31842D5B09D82AEF343115E22A86F", "暗号文");
    }

    @Test
    @TestOrder(60)
    public void testGetEncodeData_C1() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SURU);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData("10000000001", "");
        exStringEquals(value, "", "暗号文");
    }

    @Test
    @TestOrder(70)
    public void testGetEncodeData_C2() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SINAI);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData("10000000001", "123456");
        exStringEquals(value, "123456", "暗号文");
    }

    @Test
    @TestOrder(80)
    public void testGetEncodeData_C3() {
        try {
            Object o = EditSecurityKm.getInstance();
            Field f = EditSecurityKm.class.getDeclaredField("encryptKbn");
            f.setAccessible(true);
            f.set(o, null);
        } catch (Exception e) {
            e.toString();
        }

        YuyuBizConfig.getInstance().setEncryptKbn(C_EncryptKbn.SURU);
        YuyuBaseConfig.getInstance().setDebugMode(true);

        String value = EditSecurityKm.getEncodeData("10000000001", "123456");
        exStringEquals(value, "12A31842D5B09D82AEF343115E22A86F", "暗号文");
    }
}