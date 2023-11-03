package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.conversion.annotations.Padding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.file.csv.AddressInfoFileBean;
import yuyu.def.biz.file.fixedlength.BzFbsoukinDataRecordLayoutFile;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.mapping.GenZT_DsKariPasswordTuutiRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#initialize(Class<?>, C_SystemRenkeiSyoriHousikiKbn, C_SystemRenkeiHenkanHoukouKbn)}<br />
 *  テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_initialize {

    @Inject
    private BzRenkeiHenkanUtil<?, ConvClass1> bzRenkeiHenkanUtil_A1;

    @Inject
    private BzRenkeiHenkanUtil<?, ConvClass2> bzRenkeiHenkanUtil_A2;

    @Inject
    private BzRenkeiHenkanUtil<?, AddressInfoFileBean> bzRenkeiHenkanUtil_A3;

    @Inject
    private BzRenkeiHenkanUtil<?, BzFbsoukinDataRecordLayoutFile> bzRenkeiHenkanUtil_A4;

    @Inject
    private BzRenkeiHenkanUtil<?, ConvClass9> bzRenkeiHenkanUtil_A5;

    @Inject
    private BzRenkeiHenkanUtil<?, AM_Batch> bzRenkeiHenkanUtil_A6;

    @Inject
    private BzRenkeiHenkanUtil<ZT_DsKariPasswordTuutiTy, ZT_DsKariPasswordTuutiRn> bzRenkeiHenkanUtil_A7;

    @Inject
    private BzRenkeiHenkanUtil<ZT_DsKariPasswordTuutiTy, ConvClass4> bzRenkeiHenkanUtil_A8;

    @Test
    @TestOrder(10)
    public void testInitialize_A1() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変更後レイアウトのレイアウト情報（クラス名：ConvClass1）が存在しません。"
                    , "エラーメッセージ");
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(20)
    public void testInitialize_A2() {

        bzRenkeiHenkanUtil_A2.initialize(ConvClass2.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

        List<String> list = (List<String>)getData("convDDList", bzRenkeiHenkanUtil_A2, BzRenkeiHenkanUtil.class);

        Collections.sort(list);

        exStringEquals(list.get(0), "ifcAitesyono", "メンバ変数．変換後DDリスト[0]");

        Map<String,Padding> map = (Map<String,Padding>)getData("convPadingMap", bzRenkeiHenkanUtil_A2, BzRenkeiHenkanUtil.class);

        exStringEquals(map.get("ifcAitesyono").mode(), "left", "メンバ変数．変換後パディングマップ");
        exStringEquals(String.valueOf(map.get("ifcAitesyono").length()), "20", "メンバ変数．変換後パディングマップ");
        exStringEquals(String.valueOf(map.get("ifcAitesyono").padChar()), "0", "メンバ変数．変換後パディングマップ");
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(30)
    public void testInitialize_A3() {

        bzRenkeiHenkanUtil_A3.initialize(AddressInfoFileBean.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

        List<String> list = (List<String>)getData("convDDList", bzRenkeiHenkanUtil_A3, BzRenkeiHenkanUtil.class);

        exStringEquals(list.get(0), "zenkokuChihouKoukyouDantaiCd", "メンバ変数．変換後DDリスト[0]");
        exStringEquals(list.get(1), "kyuuPostalCd", "メンバ変数．変換後DDリスト[1]");
        exStringEquals(list.get(2), "postalCd", "メンバ変数．変換後DDリスト[2]");
        exStringEquals(list.get(3), "todoufukenNmKana", "メンバ変数．変換後DDリスト[3]");
        exStringEquals(list.get(4), "sikutyousonNmKana", "メンバ変数．変換後DDリスト[4]");
        exStringEquals(list.get(5), "tyouikiNmKana", "メンバ変数．変換後DDリスト[5]");
        exStringEquals(list.get(6), "todoufukenNm", "メンバ変数．変換後DDリスト[6]");
        exStringEquals(list.get(7), "sikutyousonNm", "メンバ変数．変換後DDリスト[7]");
        exStringEquals(list.get(8), "tyouikiNm", "メンバ変数．変換後DDリスト[8]");
        exStringEquals(list.get(9), "tyouikiPostalCdBunkatuKbn", "メンバ変数．変換後DDリスト[9]");
        exStringEquals(list.get(10), "tyouikiKoazaMaibanchiKbn", "メンバ変数．変換後DDリスト[10]");
        exStringEquals(list.get(11), "tyoukiTyoumeHoyuuKbn", "メンバ変数．変換後DDリスト[11]");
        exStringEquals(list.get(12), "postalCdTyoukiHukusuuKbn", "メンバ変数．変換後DDリスト[12]");
        exStringEquals(list.get(13), "postalCdKousinKbn", "メンバ変数．変換後DDリスト[13]");
        exStringEquals(list.get(14), "postalCdKousinRiyuuKbn", "メンバ変数．変換後DDリスト[14]");
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(40)
    public void testInitialize_A4() {

        bzRenkeiHenkanUtil_A4.initialize(BzFbsoukinDataRecordLayoutFile.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                , C_SystemRenkeiFileSyubetuKbn.TXT_FIXEDLENGTH);

        List<String> list = (List<String>)getData("convDDList", bzRenkeiHenkanUtil_A4, BzRenkeiHenkanUtil.class);

        exStringEquals(list.get(0), "iffFbdatakbn", "メンバ変数．変換後DDリスト[0]");
        exStringEquals(list.get(1), "iffFbbankcd", "メンバ変数．変換後DDリスト[1]");
        exStringEquals(list.get(2), "iffFbbanknmkn", "メンバ変数．変換後DDリスト[2]");
        exStringEquals(list.get(3), "iffFbsitencd", "メンバ変数．変換後DDリスト[3]");
        exStringEquals(list.get(4), "iffFbsitennmkn", "メンバ変数．変換後DDリスト[4]");
        exStringEquals(list.get(5), "iffFbtegatakoukanjyono", "メンバ変数．変換後DDリスト[5]");
        exStringEquals(list.get(6), "iffFbyokinkbn", "メンバ変数．変換後DDリスト[6]");
        exStringEquals(list.get(7), "iffFbkouzano", "メンバ変数．変換後DDリスト[7]");
        exStringEquals(list.get(8), "iffFbkouzameigininnmkn", "メンバ変数．変換後DDリスト[8]");
        exStringEquals(list.get(9), "iffFbhrkmkingk", "メンバ変数．変換後DDリスト[9]");
        exStringEquals(list.get(10), "iffFbnewcd", "メンバ変数．変換後DDリスト[10]");
        exStringEquals(list.get(11), "iffFbkokyakucd1", "メンバ変数．変換後DDリスト[11]");
        exStringEquals(list.get(12), "iffFbkokyakucd2", "メンバ変数．変換後DDリスト[12]");
        exStringEquals(list.get(13), "iffFbhrkmsiteikbn", "メンバ変数．変換後DDリスト[13]");
        exStringEquals(list.get(14), "iffFbdummy8", "メンバ変数．変換後DDリスト[14]");
    }

    @Test
    @TestOrder(50)
    public void testInitialize_A5() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY
                    , C_SystemRenkeiFileSyubetuKbn.CSV_FIXEDLENGTH
                    );
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変更後レイアウトのレイアウト情報（クラス名：ConvClass1）が存在しません。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testInitialize_A6() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , null
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH
                    );
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testInitialize_A7() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , null
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH
                    );
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    public void testInitialize_A8() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                    , null
                    );
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(90)
    public void testInitialize_A9() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(null
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH
                    );
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(100)
    public void testInitialize_A10() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH
                    );
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "設定された処理方式の区分に誤りがあります。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(110)
    public void testInitialize_A11() {

        bzRenkeiHenkanUtil_A5.initialize(ConvClass9.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        Object convertedLayout = getData("convertedLayout", bzRenkeiHenkanUtil_A5, BzRenkeiHenkanUtil.class);
        Assert.assertEquals(convertedLayout, ConvClass9.class);

        exClassificationEquals((C_SystemRenkeiSyoriHousikiKbn)
                getData("systemRenkeiSyoriHousikiKbn", bzRenkeiHenkanUtil_A5, BzRenkeiHenkanUtil.class)
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , "メンバ変数．処理方式");

        exClassificationEquals((C_SystemRenkeiHenkanHoukouKbn)
                getData("systemRenkeiHenkanHoukouKbn", bzRenkeiHenkanUtil_A5, BzRenkeiHenkanUtil.class)
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                , "メンバ変数．変換方向");

        exBooleanEquals((boolean)getData("koteityouFlg", bzRenkeiHenkanUtil_A5, BzRenkeiHenkanUtil.class)
                , true
                , "メンバ変数．固定長化フラグ");

        List<String> list = (List<String>)getData("convDDList", bzRenkeiHenkanUtil_A5, BzRenkeiHenkanUtil.class);

        Collections.sort(list);

        exStringEquals(list.get(0), "batchClass", "メンバ変数．変換後DDリスト[0]");
        exStringEquals(list.get(1), "batchJobId", "メンバ変数．変換後DDリスト[1]");

        Map<String,Padding> map = (Map<String,Padding>)getData("convPadingMap", bzRenkeiHenkanUtil_A5, BzRenkeiHenkanUtil.class);
        exStringEquals(map.get("batchJobId").mode(), "left", "メンバ変数．変換後パディングマップ");
        exStringEquals(String.valueOf(map.get("batchJobId").length()), "20", "メンバ変数．変換後パディングマップ");
        exStringEquals(String.valueOf(map.get("batchJobId").padChar()), "0", "メンバ変数．変換後パディングマップ");
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(120)
    public void testInitialize_A12() {

        bzRenkeiHenkanUtil_A6.initialize(AM_Batch.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        List<String> list = (List<String>)getData("convDDList", bzRenkeiHenkanUtil_A6, BzRenkeiHenkanUtil.class);

        Collections.sort(list);

        exStringEquals(list.get(0), "batchClass", "メンバ変数．変換後DDリスト[1]");
        exStringEquals(list.get(1), "batchHeisouKbn", "メンバ変数．変換後DDリスト[2]");
        exStringEquals(list.get(2), "batchMode", "メンバ変数．変換後DDリスト[3]");
        exStringEquals(list.get(3), "kinouId", "メンバ変数．変換後DDリスト[4]");
        exStringEquals(list.get(4), "onlineHeisouKahiKbn", "メンバ変数．変換後DDリスト[5]");
        exStringEquals(list.get(5), "paramBeanClass", "メンバ変数．変換後DDリスト[6]");
        exStringEquals(list.get(6), "tajuukidouKahiKbn", "メンバ変数．変換後DDリスト[7]");
        exStringEquals(list.get(7), "tyuudanKahi", "メンバ変数．変換後DDリスト[8]");
    }

    @Test
    @TestOrder(130)
    public void testInitialize_A13() {

        try {
            bzRenkeiHenkanUtil_A5.initialize(ConvClass9.class
                    , null
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(140)
    public void testInitialize_A14() {

        try {
            bzRenkeiHenkanUtil_A5.initialize(ConvClass9.class
                    , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                    , null);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(150)
    public void testInitialize_A15() {

        try {
            bzRenkeiHenkanUtil_A5.initialize(null
                    , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(160)
    public void testInitialize_A16() {

        try {
            bzRenkeiHenkanUtil_A5.initialize(ConvClass9.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "設定された処理方式の区分に誤りがあります。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(170)
    public void testInitialize_A17() {

        try {
            bzRenkeiHenkanUtil_A7.initialize(null
                    , ZT_DsKariPasswordTuutiRn.class
                    , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "引数に null が存在します。設定内容をご確認ください。"
                    , "エラーメッセージ");
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(180)
    public void testInitialize_A18() {

        bzRenkeiHenkanUtil_A7.initialize(ZT_DsKariPasswordTuutiTy.class
                , ZT_DsKariPasswordTuutiRn.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        try {

            Class<?> clazz = BzRenkeiHenkanUtil.class;
            Field field = clazz.getDeclaredField("getMethodMap");
            field.setAccessible(true);
            Map<String,Method> getMethodMap = (Map<String, Method>) clazz.getDeclaredField("getMethodMap").get(bzRenkeiHenkanUtil_A7);
            Map<String,Method> setMethodMap = (Map<String, Method>) clazz.getDeclaredField("setMethodMap").get(bzRenkeiHenkanUtil_A7);

            exBooleanEquals(getMethodMap.get("ztykrpasswordtuutikey").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtykrpasswordtuutikey")), true , "（中継用）仮パスワード通知キー");
            exBooleanEquals(getMethodMap.get("ztydskokno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydskokno")), true , "（中継用）ＤＳ顧客番号");
            exBooleanEquals(getMethodMap.get("ztyatesakiyno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatesakiyno")), true , "（中継用）宛先郵便番号");
            exBooleanEquals(getMethodMap.get("ztyatesakiynobarcode").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatesakiynobarcode")), true , "（中継用）宛先郵便番号バーコード");
            exBooleanEquals(getMethodMap.get("ztysakuseimd").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtysakuseimd")), true , "（中継用）作成月日");
            exBooleanEquals(getMethodMap.get("ztysclakadskokno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtysclakadskokno")), true , "（中継用）スクランブル化ＤＳ顧客番号");
            exBooleanEquals(getMethodMap.get("ztyreigaisyorihyj").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyreigaisyorihyj")), true , "（中継用）例外処理表示");
            exBooleanEquals(getMethodMap.get("ztyyuubinbutukanpusakiyno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyyuubinbutukanpusakiyno")), true , "（中継用）郵便物還付先郵便番号");
            exBooleanEquals(getMethodMap.get("ztyyuubinbutukanpusakiadr").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyyuubinbutukanpusakiadr")), true , "（中継用）郵便物還付先住所");
            exBooleanEquals(getMethodMap.get("ztyatesakiadr1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatesakiadr1")), true , "（中継用）宛先住所１");
            exBooleanEquals(getMethodMap.get("ztyatesakiadr2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatesakiadr2")), true , "（中継用）宛先住所２");
            exBooleanEquals(getMethodMap.get("ztyatesakiadr3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatesakiadr3")), true , "（中継用）宛先住所３");
            exBooleanEquals(getMethodMap.get("ztyatena1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatena1")), true , "（中継用）宛名１");
            exBooleanEquals(getMethodMap.get("ztyatena2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyatena2")), true , "（中継用）宛名２");
            exBooleanEquals(getMethodMap.get("ztydai1syoukaisakifreearea1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydai1syoukaisakifreearea1")), true , "（中継用）第１照会先フリーエリア１");
            exBooleanEquals(getMethodMap.get("ztydai1syoukaisakifreearea2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydai1syoukaisakifreearea2")), true , "（中継用）第１照会先フリーエリア２");
            exBooleanEquals(getMethodMap.get("ztydai1syoukaisakifreearea3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydai1syoukaisakifreearea3")), true , "（中継用）第１照会先フリーエリア３");
            exBooleanEquals(getMethodMap.get("ztydai1syoukaisakifreearea4").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydai1syoukaisakifreearea4")), true , "（中継用）第１照会先フリーエリア４");
            exBooleanEquals(getMethodMap.get("ztydai1syoukaisakifreearea5").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydai1syoukaisakifreearea5")), true , "（中継用）第１照会先フリーエリア５");
            exBooleanEquals(getMethodMap.get("ztysakuseino").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtysakuseino")), true , "（中継用）作成No");
            exBooleanEquals(getMethodMap.get("ztyokyakusamanm").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyokyakusamanm")), true , "（中継用）お客様氏名");
            exBooleanEquals(getMethodMap.get("ztyhkymd").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyhkymd")), true , "（中継用）発行日");
            exBooleanEquals(getMethodMap.get("ztydskrhnnkakcdyoken").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtydskrhnnkakcdyoken")), true , "（中継用）ＤＳ仮本人確認コード与件");
            exBooleanEquals(getMethodMap.get("ztykrpasswordyuukouymd").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtykrpasswordyuukouymd")), true , "（中継用）仮パスワード有効年月日");
            exBooleanEquals(getMethodMap.get("ztyfreearea1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyfreearea1")), true , "（中継用）フリーエリア１");
            exBooleanEquals(getMethodMap.get("ztyfreearea2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyfreearea2")), true , "（中継用）フリーエリア２");
            exBooleanEquals(getMethodMap.get("ztyfreearea3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyfreearea3")), true , "（中継用）フリーエリア３");
            exBooleanEquals(getMethodMap.get("ztyfreearea4").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyfreearea4")), true , "（中継用）フリーエリア４");
            exBooleanEquals(getMethodMap.get("ztyfreearea5").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtyfreearea5")), true , "（中継用）フリーエリア５");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou1")), true , "（中継用）注意事項欄１");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou2")), true , "（中継用）注意事項欄２");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou3")), true , "（中継用）注意事項欄３");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou4").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou4")), true , "（中継用）注意事項欄４");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou5").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou5")), true , "（中継用）注意事項欄５");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou6").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou6")), true , "（中継用）注意事項欄６");
            exBooleanEquals(getMethodMap.get("ztytyuuijikou7").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("getZtytyuuijikou7")), true , "（中継用）注意事項欄７");

            exBooleanEquals(setMethodMap.get("zrnkrpasswordtuutikey").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnkrpasswordtuutikey")), true , "（連携用）仮パスワード通知キー");
            exBooleanEquals(setMethodMap.get("zrndskokno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndskokno")), true , "（連携用）ＤＳ顧客番号");
            exBooleanEquals(setMethodMap.get("zrnatesakiyno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatesakiyno")), true , "（連携用）宛先郵便番号");
            exBooleanEquals(setMethodMap.get("zrnatesakiynobarcode").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatesakiynobarcode")), true , "（連携用）宛先郵便番号バーコード");
            exBooleanEquals(setMethodMap.get("zrnsakuseimd").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnsakuseimd")), true , "（連携用）作成月日");
            exBooleanEquals(setMethodMap.get("zrnsclakadskokno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnsclakadskokno")), true , "（連携用）スクランブル化ＤＳ顧客番号");
            exBooleanEquals(setMethodMap.get("zrnreigaisyorihyj").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnreigaisyorihyj")), true , "（連携用）例外処理表示");
            exBooleanEquals(setMethodMap.get("zrnyuubinbutukanpusakiyno").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnyuubinbutukanpusakiyno")), true , "（連携用）郵便物還付先郵便番号");
            exBooleanEquals(setMethodMap.get("zrnyuubinbutukanpusakiadr").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnyuubinbutukanpusakiadr")), true , "（連携用）郵便物還付先住所");
            exBooleanEquals(setMethodMap.get("zrnatesakiadr1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatesakiadr1")), true , "（連携用）宛先住所１");
            exBooleanEquals(setMethodMap.get("zrnatesakiadr2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatesakiadr2")), true , "（連携用）宛先住所２");
            exBooleanEquals(setMethodMap.get("zrnatesakiadr3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatesakiadr3")), true , "（連携用）宛先住所３");
            exBooleanEquals(setMethodMap.get("zrnatena1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatena1")), true , "（連携用）宛名１");
            exBooleanEquals(setMethodMap.get("zrnatena2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnatena2")), true , "（連携用）宛名２");
            exBooleanEquals(setMethodMap.get("zrndai1syoukaisakifreearea1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndai1syoukaisakifreearea1")), true , "（連携用）第１照会先フリーエリア１");
            exBooleanEquals(setMethodMap.get("zrndai1syoukaisakifreearea2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndai1syoukaisakifreearea2")), true , "（連携用）第１照会先フリーエリア２");
            exBooleanEquals(setMethodMap.get("zrndai1syoukaisakifreearea3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndai1syoukaisakifreearea3")), true , "（連携用）第１照会先フリーエリア３");
            exBooleanEquals(setMethodMap.get("zrndai1syoukaisakifreearea4").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndai1syoukaisakifreearea4")), true , "（連携用）第１照会先フリーエリア４");
            exBooleanEquals(setMethodMap.get("zrndai1syoukaisakifreearea5").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndai1syoukaisakifreearea5")), true , "（連携用）第１照会先フリーエリア５");
            exBooleanEquals(setMethodMap.get("zrnsakuseino").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnsakuseino")), true , "（連携用）作成No");
            exBooleanEquals(setMethodMap.get("zrnokyakusamanm").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnokyakusamanm")), true , "（連携用）お客様氏名");
            exBooleanEquals(setMethodMap.get("zrnhkymd").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnhkymd")), true , "（連携用）発行日");
            exBooleanEquals(setMethodMap.get("zrndskrhnnkakcdyoken").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrndskrhnnkakcdyoken")), true , "（連携用）ＤＳ仮本人確認コード与件");
            exBooleanEquals(setMethodMap.get("zrnkrpasswordyuukouymd").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnkrpasswordyuukouymd")), true , "（連携用）仮パスワード有効年月日");
            exBooleanEquals(setMethodMap.get("zrnfreearea1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnfreearea1")), true , "（連携用）フリーエリア１");
            exBooleanEquals(setMethodMap.get("zrnfreearea2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnfreearea2")), true , "（連携用）フリーエリア２");
            exBooleanEquals(setMethodMap.get("zrnfreearea3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnfreearea3")), true , "（連携用）フリーエリア３");
            exBooleanEquals(setMethodMap.get("zrnfreearea4").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnfreearea4")), true , "（連携用）フリーエリア４");
            exBooleanEquals(setMethodMap.get("zrnfreearea5").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrnfreearea5")), true , "（連携用）フリーエリア５");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou1").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou1")), true , "（連携用）注意事項欄１");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou2").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou2")), true , "（連携用）注意事項欄２");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou3").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou3")), true , "（連携用）注意事項欄３");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou4").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou4")), true , "（連携用）注意事項欄４");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou5").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou5")), true , "（連携用）注意事項欄５");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou6").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou6")), true , "（連携用）注意事項欄６");
            exBooleanEquals(setMethodMap.get("zrntyuuijikou7").equals(GenZT_DsKariPasswordTuutiRn.class.getMethod("setZrntyuuijikou7")), true , "（連携用）注意事項欄７");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    @TestOrder(190)
    public void testInitialize_A19() {

        bzRenkeiHenkanUtil_A8.initialize(ZT_DsKariPasswordTuutiTy.class
                , ConvClass4.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY
                , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

        try {

            Class<?> clazz = BzRenkeiHenkanUtil.class;
            Field field = clazz.getDeclaredField("getMethodMap");
            field.setAccessible(true);
            Map<String,Method> getMethodMap = (Map<String, Method>) clazz.getDeclaredField("getMethodMap").get(bzRenkeiHenkanUtil_A8);
            Map<String,Method> setMethodMap = (Map<String, Method>) clazz.getDeclaredField("setMethodMap").get(bzRenkeiHenkanUtil_A8);

            exBooleanEquals(getMethodMap.get("ztyatesakiyno").equals(ZT_DsKariPasswordTuutiTy.class.getMethod("getZtyatesakiyno")), true , "（中継用）宛先郵便番号");

            exBooleanEquals(setMethodMap.get("zrnatesakiyno").equals(ZT_DsKariPasswordTuutiTy.class.getMethod("setZrnatesakiyno")), true , "（連携用）宛先郵便番号");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private Object getData(String pFieldName, Object pObject, Class<?> pObjectLayout) {

        Field field = null;

        Object data = null;

        try {
            field = pObjectLayout.getDeclaredField(pFieldName);
        } catch (NoSuchFieldException | SecurityException e) {
            throw new RuntimeException(e);
        }

        field.setAccessible(true);

        try {
            data = field.get(pObject);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
