package yuyu.common.biz.bzcommon;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.fieldconfig.MFieldDef;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#convData(C_SystemRenkeiHenkanHoukouKbn, MFieldDef, Object, boolean)} <br />
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convert {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testConvert_A1() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("SampleKbn");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(1);
        Object object = C_KahiKbn.KA;
        boolean koteityouFlg = false;

        try {
            bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "文字列型または数値型以外のデータ型の変換には対応していません。変換後ＤＤ項目ＩＤ：SampleKbn、変換対象データ：1"
                    , "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testConvert_A2() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = "勘定科目名勘定科目名勘定科目名勘定科目";
        boolean koteityouFlg = true;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "勘定科目名勘定科目名勘定科目名勘定科目　", "変換後データ");
    }

    @Test
    @TestOrder(30)
    public void testConvert_A3() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = Long.valueOf("1234567890");
        boolean koteityouFlg = true;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "１２３４５６７８９０　　　　　　　　　　", "変換後データ");
    }

    @Test
    @TestOrder(40)
    public void testConvert_A4() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = Long.valueOf("1223372036854775807");

        boolean koteityouFlg = true;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "1223372036854775807 ", "変換後データ");
    }

    @Test
    @TestOrder(50)
    public void testConvert_A5() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = "12345678901234567890";
        boolean koteityouFlg = true;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "12345678901234567890", "変換後データ");
    }

    @Test
    @TestOrder(60)
    public void testConvert_A6() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("Sample");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = "123456789012345678901";
        boolean koteityouFlg = true;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "12345678901234567890", "変換後データ");
    }

    @Test
    @TestOrder(70)
    public void testConvert_A7() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = Double.valueOf("123456");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "１２３４５６．０", "変換後データ");
    }

    @Test
    @TestOrder(80)
    public void testConvert_A8() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(2);
        Object object = Integer.parseInt("2");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "2", "変換後データ");
    }

    @Test
    @TestOrder(90)
    public void testConvert_A9() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = "12345678902234567890";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "12345678902234567890", "変換後データ");
    }

    @Test
    @TestOrder(100)
    public void testConvert_A10() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = "123456789022345678901";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "12345678902234567890", "変換後データ");
    }

    @Test
    @TestOrder(110)
    public void testConvert_A11() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = "123456 ";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "１２３４５６", "変換後データ");
    }

    @Test
    @TestOrder(120)
    public void testConvert_A12() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = Long.valueOf("123456");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "１２３４５６", "変換後データ");
    }

    @Test
    @TestOrder(130)
    public void testConvert_A13() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(4);
        Object object = Long.valueOf("123");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "123", "変換後データ");
    }

    @Test
    @TestOrder(140)
    public void testConvert_A14() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = "１２３４５６７８９０１２３４５６７８９０　";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "12345678901234567890", "変換後データ");
    }

    @Test
    @TestOrder(150)
    public void testConvert_A15() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = "１２３４５６７８９０１２３４５６７８９０１　";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "12345678901234567890", "変換後データ");
    }

    @Test
    @TestOrder(160)
    public void testConvert_A16() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Long");
        Object object = "１２３４５６７８９０";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Long)data, Long.parseLong("1234567890"), "変換後データ");
    }

    @Test
    @TestOrder(170)
    public void testConvert_A17() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Long");
        Object object = "1234567890";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Long)data, Long.valueOf("1234567890"), "変換後データ");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(180)
    public void testConvert_A18() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Long");
        Object object = "1k";
        boolean koteityouFlg = false;

        try {
            bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変換対象データに数字項目以外の文字列が設定されています。変換後ＤＤ項目ＩＤ：null、変換対象データ：1k"
                    , "エラーメッセージ");

            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(190)
    public void testConvert_A19() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Long");
        Object object = "";
        boolean koteityouFlg = false;

        try {
            bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変換対象データに数字項目以外の文字列が設定されています。変換後ＤＤ項目ＩＤ：null、変換対象データ："
                    , "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(200)
    public void testConvert_A20() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Double");
        Object object = "123456";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Double)data, Double.valueOf("123456"), "変換後データ");
    }

    @Test
    @TestOrder(210)
    public void testConvert_A21() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Integer");
        Object object = "2";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Integer)data, Integer.valueOf("2"), "変換後データ");
    }

    @Test
    @TestOrder(220)
    public void testConvert_A22() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Long");
        Object object = Long.valueOf("123456");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Long)data, Long.valueOf("123456"), "変換後データ");
    }

    @Test
    @TestOrder(230)
    public void testConvert_A23() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Double");
        Object object = Double.valueOf("1234.56");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Double)data, Double.valueOf("1234.56"), "変換後データ");
    }

    @Test
    @TestOrder(240)
    public void testConvert_A24() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Integer");
        Object object = Integer.valueOf("2");
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exNumericEquals((Integer)data, Integer.valueOf("2"), "変換後データ");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(250)
    public void testConvert_A25() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("Long");
        Object object = C_KahiKbn.KA;
        boolean koteityouFlg = false;

        try {
            bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "文字列型または数値型以外のデータ型の変換には対応していません。変換後ＤＤ項目ＩＤ：null、変換対象データ：1"
                    , "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(260)
    public void testConvert_A26() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("KBN");
        Object object = C_KahiKbn.KA;
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exClassificationEquals((C_KahiKbn)data, C_KahiKbn.KA, "変換後データ");
    }

    @Test
    @TestOrder(270)
    public void testConvert_A27() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("batchJobId");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(20);
        Object object = Long.valueOf("1234567");
        Map<String,Padding> padingMap = new HashMap<String,Padding>();
        PropertyDescriptor pd;
        Method method = null;

        try {
            pd = new PropertyDescriptor("batchJobId",ConvClass10.class);
            method = pd.getWriteMethod();
            padingMap.put("batchJobId", method.getAnnotation(Padding.class));

            Field field = BzRenkeiHenkanUtil.class.getDeclaredField("convPadingMap");
            field.setAccessible(true);
            field.set(bzRenkeiHenkanUtil, padingMap);

            boolean koteityouFlg = true;

            Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

            exStringEquals(String.valueOf(data), "00000000000001234567", "変換後データ");

            padingMap = null;
            field.set(bzRenkeiHenkanUtil, padingMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(280)
    public void testConvert_A28() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("ifcBankcd");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("H");
        mFieldDef.setMaxlength(4);
        Object object = String.valueOf("12");
        Map<String,Padding> padingMap = new HashMap<String,Padding>();
        PropertyDescriptor pd;
        Method method = null;

        try {
            pd = new PropertyDescriptor("ifcBankcd",ConvClass10.class);
            method = pd.getWriteMethod();
            padingMap.put("ifcBankcd", method.getAnnotation(Padding.class));

            Field field = BzRenkeiHenkanUtil.class.getDeclaredField("convPadingMap");
            field.setAccessible(true);
            field.set(bzRenkeiHenkanUtil, padingMap);

            boolean koteityouFlg = true;

            Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

            exStringEquals(String.valueOf(data), "12++", "変換後データ");

            padingMap = null;
            field.set(bzRenkeiHenkanUtil, padingMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(290)
    public void testConvert_A29() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("ifcBanknmkj");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = String.valueOf("サンプル銀行");
        Map<String,Padding> padingMap = new HashMap<String,Padding>();
        PropertyDescriptor pd;
        Method method = null;

        try {
            pd = new PropertyDescriptor("ifcBanknmkj",ConvClass10.class);
            method = pd.getWriteMethod();
            padingMap.put("ifcBanknmkj", method.getAnnotation(Padding.class));

            Field field = BzRenkeiHenkanUtil.class.getDeclaredField("convPadingMap");
            field.setAccessible(true);
            field.set(bzRenkeiHenkanUtil, padingMap);

            boolean koteityouFlg = true;

            Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

            exStringEquals(String.valueOf(data), "＠＠＠＠＠＠＠＠＠＠＠＠＠＠サンプル銀行", "変換後データ");

            padingMap = null;
            field.set(bzRenkeiHenkanUtil, padingMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(300)
    public void testConvert_A30() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("ifcBanknmkn");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = String.valueOf("サンプルキンゴウ");
        Map<String,Padding> padingMap = new HashMap<String,Padding>();
        PropertyDescriptor pd;
        Method method = null;

        try {
            pd = new PropertyDescriptor("ifcBanknmkn",ConvClass10.class);
            method = pd.getWriteMethod();
            padingMap.put("ifcBanknmkn", method.getAnnotation(Padding.class));

            Field field = BzRenkeiHenkanUtil.class.getDeclaredField("convPadingMap");
            field.setAccessible(true);
            field.set(bzRenkeiHenkanUtil, padingMap);

            boolean koteityouFlg = true;

            Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

            exStringEquals(String.valueOf(data), "サンプルキンゴウ＊＊＊＊＊＊＊　　　　　", "変換後データ");

            padingMap = null;
            field.set(bzRenkeiHenkanUtil, padingMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(310)
    public void testConvert_A31() throws Exception {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setId("ifcBanknmkn_0");
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = String.valueOf("サンプルキンゴウ");
        Map<String,Padding> padingMap = new HashMap<String,Padding>();
        PropertyDescriptor pd;
        Method method = null;

        try {
            pd = new PropertyDescriptor("ifcBanknmkn_0",ConvClass10.class);
            method = pd.getWriteMethod();
            padingMap.put("ifcBanknmkn_0", method.getAnnotation(Padding.class));

            Field field = BzRenkeiHenkanUtil.class.getDeclaredField("convPadingMap");
            field.setAccessible(true);
            field.set(bzRenkeiHenkanUtil, padingMap);

            boolean koteityouFlg = true;

            bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "パディングアノテーションの桁数に０が設定されています。ＤＤ項目が正しく申請されているかご確認ください。ＤＤ項目ＩＤ：ifcBanknmkn_0"
                    , "エラーメッセージ");
        }
    }


    @Test
    @TestOrder(320)
    public void testConvert_A32() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("String");
        mFieldDef.setZenhanKbn("Z");
        mFieldDef.setMaxlength(20);
        Object object = BizNumber.valueOf(123456.78);
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exStringEquals(String.valueOf(data), "１２３４５６．７８", "変換後データ");
    }

    @Test
    @TestOrder(330)
    public void testConvert_A33() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("BizNumber");
        Object object = "123456";
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exBizCalcbleEquals((BizNumber)data, BizNumber.valueOf(123456), "変換後データ");
    }


    @Test
    @TestOrder(340)
    public void testConvert_A34() {
        C_SystemRenkeiHenkanHoukouKbn systemRenkeiHenkanHoukouKbn = C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY;
        MFieldDef mFieldDef = new MFieldDef();
        mFieldDef.setType("BizNumber");
        Object object = BizNumber.valueOf(1234.56);
        boolean koteityouFlg = false;

        Object data = bzRenkeiHenkanUtil.convert(systemRenkeiHenkanHoukouKbn, mFieldDef, object, koteityouFlg);

        exBizCalcbleEquals((BizNumber)data, BizNumber.valueOf(1234.56), "変換後データ");
    }

}
