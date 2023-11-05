package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HrkmirninEditPtnKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SkHurikomiKouzaInfoクラスのメソッド {@link SkHurikomiKouzaInfo#getHurikomiInfoGaika(SkHurikomiKouzaInfoBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkHurikomiKouzaInfoTest_getHurikomiInfoGaika {

    private final static String kouzano1 = "4733950021";

    private final static String kouzano2 = "2233950021";

    private final static String kouzano3 = "4733950022";

    private final static String kouzano4 = "0001234567";

    private final static String kouzano5 = "0007654321";

    @Inject
    private SkHurikomiKouzaInfo skHurikomiKouzaInfo;

    @Inject
    private SkHurikomiKouzaInfoBean skHurikomiKouzaInfoBean;

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約振込入金口座情報取得";
    private final static String sheetName = "テストデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HM_HurikomiKouza hurikomiKouza1 = new HM_HurikomiKouza("2401", "401", "4733950021", C_Tuukasyu.EUR, "2783721321");
        hurikomiKouza1.setYokinkbn(C_YokinKbn.TOUZA);
        hurikomiKouza1.setOyadrtencd("2235131");
        hurikomiKouza1.setNyuukinoyadrtennm("入金用親代理店名五");
        hurikomiKouza1.setOyadrtensyoritarget(C_TaisyouKbn.TAISYOU);
        hurikomiKouza1.setJidonykntargethyouji(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza1.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HYOUJYUN);
        hurikomiKouza1.setSiteituuka(C_Tuukasyu.USD);
        hurikomiKouza1.setHonkouzacd("200");

        sinkeiyakuDomManager.insert(hurikomiKouza1);

        HM_HurikomiKouza hurikomiKouza2 = new HM_HurikomiKouza("2402", "402", "2233950021", C_Tuukasyu.EUR, "2783721320");
        hurikomiKouza2.setYokinkbn(C_YokinKbn.HUTUU);
        hurikomiKouza2.setOyadrtencd("2235130");
        hurikomiKouza2.setNyuukinoyadrtennm("入金用親代理店名");
        hurikomiKouza2.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza2.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza2.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HRKMIRNINKETUGOU);
        hurikomiKouza2.setSiteituuka(C_Tuukasyu.EUR);
        hurikomiKouza2.setHonkouzacd("300");

        sinkeiyakuDomManager.insert(hurikomiKouza2);

        HM_HurikomiKouza hurikomiKouza3 = new HM_HurikomiKouza("2401", "401", "1234567", C_Tuukasyu.EUR, "2783721321");
        hurikomiKouza3.setYokinkbn(C_YokinKbn.TOUZA);
        hurikomiKouza3.setOyadrtencd("2235131");
        hurikomiKouza3.setNyuukinoyadrtennm("入金用親代理店名五");
        hurikomiKouza3.setOyadrtensyoritarget(C_TaisyouKbn.TAISYOU);
        hurikomiKouza3.setJidonykntargethyouji(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza3.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HYOUJYUN);
        hurikomiKouza3.setSiteituuka(C_Tuukasyu.USD);
        hurikomiKouza3.setHonkouzacd("200");

        sinkeiyakuDomManager.insert(hurikomiKouza3);

        HM_HurikomiKouza hurikomiKouza4 = new HM_HurikomiKouza("2402", "402", "7654321", C_Tuukasyu.EUR, "2783721320");
        hurikomiKouza4.setYokinkbn(C_YokinKbn.HUTUU);
        hurikomiKouza4.setOyadrtencd("2235130");
        hurikomiKouza4.setNyuukinoyadrtennm("入金用親代理店名");
        hurikomiKouza4.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza4.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza4.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HRKMIRNINKETUGOU);
        hurikomiKouza4.setSiteituuka(C_Tuukasyu.EUR);
        hurikomiKouza4.setHonkouzacd("300");

        sinkeiyakuDomManager.insert(hurikomiKouza4);

        HM_HurikomiKouza hurikomiKouza5 = new HM_HurikomiKouza("2402", "402", "7654321", C_Tuukasyu.EUR, "2783721321");
        hurikomiKouza5.setYokinkbn(C_YokinKbn.HUTUU);
        hurikomiKouza5.setOyadrtencd("2235130");
        hurikomiKouza5.setNyuukinoyadrtennm("入金用親代理店名");
        hurikomiKouza5.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza5.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza5.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HRKMIRNINKETUGOU);
        hurikomiKouza5.setSiteituuka(C_Tuukasyu.EUR);
        hurikomiKouza5.setHonkouzacd("300");

        sinkeiyakuDomManager.insert(hurikomiKouza5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHurikomiKouza());
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testGetHurikomiInfoGaika_A1() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano4);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninNm("2215WBa0328 Cak121 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getKouzaNo(), "1234567", "口座番号");
        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "22", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "Cak121", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "2235131", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "入金用親代理店名五", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.HITAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.TAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.USD, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "200", "本口座コード");
    }

    @Test
    @TestOrder(20)
    public void testGetHurikomiInfoGaika_A2() {

        skHurikomiKouzaInfoBean.setBankCd("2402");
        skHurikomiKouzaInfoBean.setSitenCd("402");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano2);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninNm(" 2215WBa0328 Cak122 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getKouzaNo(), kouzano2, "口座番号");
        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "2215WBa0328 Cak122", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "2235130", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "入金用親代理店名", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.TAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.HITAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.EUR, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "300", "本口座コード");
    }

    @Test
    @TestOrder(30)
    public void testGetHurikomiInfoGaika_A3() {

        skHurikomiKouzaInfoBean.setBankCd("3202");
        skHurikomiKouzaInfoBean.setSitenCd("202");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano3);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.USD);
        skHurikomiKouzaInfoBean.setHrkmirninNm(" 6 625WBa0328 Cak122 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getKouzaNo(), kouzano3, "口座番号");
        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "6 625WBa0328 Cak122", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.TAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.HITAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.BLNK, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "", "本口座コード");
    }

    @Test
    @TestOrder(40)
    public void testGetHurikomiInfoGaika_A4() {

        skHurikomiKouzaInfoBean.setBankCd("2402");
        skHurikomiKouzaInfoBean.setSitenCd("402");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano5);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninNm(" 2215WBa0328 Cak122 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getKouzaNo(), "7654321", "口座番号");
        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "2215WBa0328 Cak122", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.TAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.HITAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.BLNK, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "", "本口座コード");
    }

    @Test
    @TestOrder(60)
    public void testGetHurikomiInfoGaika_B1() {


        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(70)
    public void testGetHurikomiInfoGaika_B2() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("9ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(80)
    public void testGetHurikomiInfoGaika_B3() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("41234567");
        skHurikomiKouzaInfoBean.setHrkmirninNm("9ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(90)
    public void testGetHurikomiInfoGaika_B4() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(100)
    public void testGetHurikomiInfoGaika_B5() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("12345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(110)
    public void testGetHurikomiInfoGaika_B6() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(120)
    public void testGetHurikomiInfoGaika_B7() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(130)
    public void testGetHurikomiInfoGaika_B8() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(140)
    public void testGetHurikomiInfoGaika_B9() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(150)
    public void testGetHurikomiInfoGaika_B10() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("4112345678 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(160)
    public void testGetHurikomiInfoGaika_B11() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("411234567890ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "0ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(170)
    public void testGetHurikomiInfoGaika_B12() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789ＳＵＭＩＴＯＭＯ ＨＡＮＡＫＯ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ＳＵＭＩＴＯＭＯ ＨＡＮＡＫＯ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(180)
    public void testGetHurikomiInfoGaika_B13() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(160)
    public void testGetHurikomiInfoGaika_B14() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("SMBCﾆﾂｺｳｼﾖｳｹﾝ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｹﾝ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(170)
    public void testGetHurikomiInfoGaika_B15() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }

    @Test
    @TestOrder(180)
    public void testGetHurikomiInfoGaika_B16() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ1ｱｲｳ2ﾌﾘｺﾐﾆﾝ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ1ｱｲｳ2ﾌﾘｺﾐﾆﾝ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(190)
    public void testGetHurikomiInfoGaika_B17() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789 ");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｱ123456789 ｽﾐﾄﾓ ﾊﾅｺ ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(200)
    public void testGetHurikomiInfoGaika_B18() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789 ＳＵＭＩＴＯＭＯ ＨＡＮＡＫＯ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ＳＵＭＩＴＯＭＯ ＨＡＮＡＫＯ", "振込依頼人名（カナ）");

    }

    @Test
    @TestOrder(210)
    public void testGetHurikomiInfoGaika_B19() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");

    }

    @Test
    @TestOrder(220)
    public void testGetHurikomiInfoGaika_B20() {

        skHurikomiKouzaInfoBean.setBankCd("2401");
        skHurikomiKouzaInfoBean.setSitenCd("401");
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.EUR);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("12345678 ＳＵＭＩＴＯＭＯ ＨＡＮＡＫＯ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoGaika(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ＭＩＴＯＭＯ ＨＡＮＡＫＯ", "振込依頼人名（カナ）");

    }
}
