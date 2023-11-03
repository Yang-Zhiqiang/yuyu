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
 * セキュリティ項目編集クラスのメソッド {@link EditSecurityKm#decode(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSecurityKmTest_decode {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testDecode_A1() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init(null);
        String value = editSecurityKm.decode(null);
        exStringEquals(value, null, "平文");
    }

    @Test
    @TestOrder(20)
    public void testDecode_A2() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("");
        String value = editSecurityKm.decode("");
        exStringEquals(value, "", "平文");
    }

    @Test
    @TestOrder(30)
    public void testDecode_B1() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("10000000001");
        String value = editSecurityKm.decode("12A31842D5B09D82AEF343115E22A86F");
        exStringEquals(value, "12A31842D5B09D82AEF343115E22A86F", "平文");
    }

    @Test
    @TestOrder(40)
    public void testDecode_B2() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("10000000001");
        String value = editSecurityKm.decode("12A31842D5B09D82AEF343115E22A86F");
        exStringEquals(value, "123456", "平文");
    }

    @Test
    @TestOrder(50)
    public void testDecode_B3() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("10000000001");
        String value = editSecurityKm.decode("12A31842D5B09D82AEF343115E22A86F");
        exStringEquals(value, "123456", "平文");
    }

    @Test
    @TestOrder(60)
    public void testDecode_C1() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("10000000001");
        String value = editSecurityKm.decode("");
        exStringEquals(value, "", "平文");
    }

    @Test
    @TestOrder(70)
    public void testDecode_C2() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("10000000001");
        String value = editSecurityKm.decode("12A31842D5B09D82AEF343115E22A86F");
        exStringEquals(value, "12A31842D5B09D82AEF343115E22A86F", "平文");
    }

    @Test
    @TestOrder(80)
    public void testDecode_C3() {
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

        EditSecurityKm editSecurityKm = EditSecurityKm.getInstance();
        editSecurityKm.init("10000000001");
        String value = editSecurityKm.decode("12A31842D5B09D82AEF343115E22A86F");
        exStringEquals(value, "123456", "平文");
    }
}