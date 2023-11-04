package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HrkmirninEditPtnKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SkHurikomiKouzaInfoクラスのメソッド {@link SkHurikomiKouzaInfo#getHurikomiInfoYen(SkHurikomiKouzaInfoBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkHurikomiKouzaInfoTest_getHurikomiInfoYen {

    private final static String kouzano1 = "693395000081";

    private final static String kouzano2 = "693395000022";

    private final static String kouzano3 = "693395000082";

    private final static String hrkmirnincd1 = "3283721361";

    private final static String hrkmirnincd2 = "2283721322";

    private final static String hrkmirnincd4 = "3283721363";

    private final static String hrkmirnincd6 = "5566721363";

    @Inject
    private SkHurikomiKouzaInfo skHurikomiKouzaInfo;

    @Inject
    private SkHurikomiKouzaInfoBean skHurikomiKouzaInfoBean;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HM_HurikomiKouza hurikomiKouza1 = new HM_HurikomiKouza("7501","501","693395000081",C_Tuukasyu.JPY,"3283721361");
        hurikomiKouza1.setYokinkbn(C_YokinKbn.HUTUU);
        hurikomiKouza1.setOyadrtencd("1135131");
        hurikomiKouza1.setNyuukinoyadrtennm("入金用親代理店名一");
        hurikomiKouza1.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza1.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza1.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HYOUJYUN);
        hurikomiKouza1.setSiteituuka(C_Tuukasyu.JPY);
        hurikomiKouza1.setHonkouzacd("123");
        hurikomiKouza1.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);

        sinkeiyakuDomManager.insert(hurikomiKouza1);

        HM_HurikomiKouza hurikomiKouza2 = new HM_HurikomiKouza("7502","522","693395000022",C_Tuukasyu.JPY,"2283721322");
        hurikomiKouza2.setYokinkbn(C_YokinKbn.TOUZA);
        hurikomiKouza2.setOyadrtencd("1135122");
        hurikomiKouza2.setNyuukinoyadrtennm("入金用親代理店名");
        hurikomiKouza2.setOyadrtensyoritarget(C_TaisyouKbn.TAISYOU);
        hurikomiKouza2.setJidonykntargethyouji(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza2.setHrkmirnineditptnkbn(null);
        hurikomiKouza2.setSiteituuka(C_Tuukasyu.JPY);
        hurikomiKouza2.setHonkouzacd("124");
        hurikomiKouza2.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);

        sinkeiyakuDomManager.insert(hurikomiKouza2);

        HM_HurikomiKouza hurikomiKouza3 = new HM_HurikomiKouza("8502","502","693395000082",C_Tuukasyu.JPY,"3283721362");
        hurikomiKouza3.setYokinkbn(C_YokinKbn.TOUZA);
        hurikomiKouza3.setOyadrtencd("1135132");
        hurikomiKouza3.setNyuukinoyadrtennm("入金用親代理店名二");
        hurikomiKouza3.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza3.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza3.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HYOUJYUN);
        hurikomiKouza3.setSiteituuka(C_Tuukasyu.USD);
        hurikomiKouza3.setHonkouzacd("125");
        hurikomiKouza3.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);

        sinkeiyakuDomManager.insert(hurikomiKouza3);

        HM_HurikomiKouza hurikomiKouza4 = new HM_HurikomiKouza("8502","502","693395000082",C_Tuukasyu.JPY,"3283721363");
        hurikomiKouza4.setYokinkbn(C_YokinKbn.TOUZA);
        hurikomiKouza4.setOyadrtencd("1135133");
        hurikomiKouza4.setNyuukinoyadrtennm("入金用親代理店名三");
        hurikomiKouza4.setOyadrtensyoritarget(C_TaisyouKbn.TAISYOU);
        hurikomiKouza4.setJidonykntargethyouji(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza4.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HRKMIRNINKETUGOU);
        hurikomiKouza4.setSiteituuka(C_Tuukasyu.USD);
        hurikomiKouza4.setHonkouzacd("126");
        hurikomiKouza4.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);

        sinkeiyakuDomManager.insert(hurikomiKouza4);

        HM_HurikomiKouza hurikomiKouza5 = new HM_HurikomiKouza("8502","502","693395000082",C_Tuukasyu.JPY,"3283721364");
        hurikomiKouza5.setYokinkbn(C_YokinKbn.TOUZA);
        hurikomiKouza5.setOyadrtencd("1135134");
        hurikomiKouza5.setNyuukinoyadrtennm("入金用親代理店名四");
        hurikomiKouza5.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza5.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza5.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HYOUJYUN);
        hurikomiKouza5.setSiteituuka(C_Tuukasyu.USD);
        hurikomiKouza5.setHonkouzacd("127");
        hurikomiKouza5.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);

        sinkeiyakuDomManager.insert(hurikomiKouza5);

        HM_HurikomiKouza hurikomiKouza6 = new HM_HurikomiKouza("7503","501","693395000081",C_Tuukasyu.JPY,"3283721361");
        hurikomiKouza6.setYokinkbn(C_YokinKbn.HUTUU);
        hurikomiKouza6.setOyadrtencd("1135131");
        hurikomiKouza6.setNyuukinoyadrtennm("入金用親代理店名一");
        hurikomiKouza6.setOyadrtensyoritarget(C_TaisyouKbn.HITAISYOU);
        hurikomiKouza6.setJidonykntargethyouji(C_TaisyouKbn.TAISYOU);
        hurikomiKouza6.setHrkmirnineditptnkbn(C_HrkmirninEditPtnKbn.HRKMIRNINKETUGOU);
        hurikomiKouza6.setSiteituuka(C_Tuukasyu.JPY);
        hurikomiKouza6.setHonkouzacd("123");
        hurikomiKouza6.setNyktyhyoutkbn(C_NyktyhyoutKbn.GAIKADATE);

        sinkeiyakuDomManager.insert(hurikomiKouza6);

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
    public void testGetHurikomiInfoYen_A1() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd1);
        skHurikomiKouzaInfoBean.setHrkmirninNm("2115LBa0328 Cak131 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "21", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "1135131", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "入金用親代理店名一", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.TAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.HITAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.JPY, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "123", "本口座コード");
        exClassificationEquals(resultBean.getNyktyhyoutKbn(), C_NyktyhyoutKbn.GAIKADATE, "入金帳票出力先区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHurikomiInfoYen_A2() {

        skHurikomiKouzaInfoBean.setBankCd("7502");
        skHurikomiKouzaInfoBean.setSitenCd("522");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.TOUZA);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano2);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd2);
        skHurikomiKouzaInfoBean.setHrkmirninNm(" 2115LBa0328 Cak130 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "2115LBa0328 Cak130", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "1135122", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "入金用親代理店名", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.HITAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.TAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.JPY, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "124", "本口座コード");
        exClassificationEquals(resultBean.getNyktyhyoutKbn(), C_NyktyhyoutKbn.GAIKADATE, "入金帳票出力先区分");
    }

    @Test
    @TestOrder(30)
    public void testGetHurikomiInfoYen_A3() {

        skHurikomiKouzaInfoBean.setBankCd("8502");
        skHurikomiKouzaInfoBean.setSitenCd("502");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.TOUZA);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano3);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd4);
        skHurikomiKouzaInfoBean.setHrkmirninNm("2 225LBa0328 Cak132 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "837213632", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "32", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "1135133", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "入金用親代理店名三", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.HITAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.TAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.USD, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "126", "本口座コード");
        exClassificationEquals(resultBean.getNyktyhyoutKbn(), C_NyktyhyoutKbn.GAIKADATE, "入金帳票出力先区分");
    }

    @Test
    @TestOrder(40)
    public void testGetHurikomiInfoYen_A4() {

        skHurikomiKouzaInfoBean.setBankCd("8502");
        skHurikomiKouzaInfoBean.setSitenCd("502");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.TOUZA);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano3);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd6);
        skHurikomiKouzaInfoBean.setHrkmirninNm(" 2 225LBa0328 Cak132 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "2 225LBa0328 Cak132", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.TAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.HITAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.BLNK, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "", "本口座コード");
        exClassificationEquals(resultBean.getNyktyhyoutKbn(), C_NyktyhyoutKbn.NONE, "入金帳票出力先区分");
    }

    @Test
    @TestOrder(50)
    public void testGetHurikomiInfoYen_A5() {

        skHurikomiKouzaInfoBean.setBankCd("4401");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd1);
        skHurikomiKouzaInfoBean.setHrkmirninNm(" 2115LBa0328 Cak131 ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getSyouhnNo(), "", "商品番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "2115LBa0328 Cak131", "振込依頼人名（カナ）");
        exStringEquals(resultBean.getOyadrtenCd(), "", "親代理店コード");
        exStringEquals(resultBean.getNyuukinOyadrtenNm(), "", "入金用親代理店名");
        exClassificationEquals(resultBean.getJidonyknTargetHyouji(), C_TaisyouKbn.TAISYOU, "自動入金対象表示");
        exClassificationEquals(resultBean.getOyadrtenSyoriTarget(), C_TaisyouKbn.HITAISYOU, "親代理店処理対象");
        exClassificationEquals(resultBean.getSiteiTuuka(), C_Tuukasyu.BLNK, "指定通貨");
        exStringEquals(resultBean.getHonkouzaCd(), "", "本口座コード");
        exClassificationEquals(resultBean.getNyktyhyoutKbn(), C_NyktyhyoutKbn.NONE, "入金帳票出力先区分");
    }


    @Test
    @TestOrder(60)
    public void testGetHurikomiInfoYen_B1() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(70)
    public void testGetHurikomiInfoYen_B2() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("9ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(80)
    public void testGetHurikomiInfoYen_B3() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("41234567");
        skHurikomiKouzaInfoBean.setHrkmirninNm("9ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(90)
    public void testGetHurikomiInfoYen_B4() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(100)
    public void testGetHurikomiInfoYen_B5() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("12345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(110)
    public void testGetHurikomiInfoYen_B6() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(120)
    public void testGetHurikomiInfoYen_B7() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(130)
    public void testGetHurikomiInfoYen_B8() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(140)
    public void testGetHurikomiInfoYen_B9() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(150)
    public void testGetHurikomiInfoYen_B10() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("4112345678 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(160)
    public void testGetHurikomiInfoYen_B11() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("411234567890ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(170)
    public void testGetHurikomiInfoYen_B12() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(180)
    public void testGetHurikomiInfoYen_B13() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(160)
    public void testGetHurikomiInfoYen_B14() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("SMBCﾆﾂｺｳｼﾖｳｹﾝ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "SMBCﾆﾂｺｳｼﾖｳｹﾝ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(170)
    public void testGetHurikomiInfoYen_B15() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }

    @Test
    @TestOrder(173)
    public void testGetHurikomiInfoYen_B31() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ1ｱｲｳ2ﾌﾘｺﾐﾆﾝ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ﾌﾘｺﾐﾆﾝ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(177)
    public void testGetHurikomiInfoYen_B32() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789 ");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｱ123456789 ｽﾐﾄﾓ ﾊﾅｺ ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(350)
    public void testGetHurikomiInfoYen_B35() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd1);
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(360)
    public void testGetHurikomiInfoYen_B36() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd1);
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(390)
    public void testGetHurikomiInfoYen_B39() {

        skHurikomiKouzaInfoBean.setBankCd("7501");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd(hrkmirnincd1);
        skHurikomiKouzaInfoBean.setHrkmirninNm("12345678 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(180)
    public void testGetHurikomiInfoYen_B16() {
        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(190)
    public void testGetHurikomiInfoYen_B17() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("9ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(200)
    public void testGetHurikomiInfoYen_B18() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("41234567");
        skHurikomiKouzaInfoBean.setHrkmirninNm("9ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(210)
    public void testGetHurikomiInfoYen_B19() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(220)
    public void testGetHurikomiInfoYen_B20() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("12345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(230)
    public void testGetHurikomiInfoYen_B21() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(240)
    public void testGetHurikomiInfoYen_B22() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(250)
    public void testGetHurikomiInfoYen_B23() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(260)
    public void testGetHurikomiInfoYen_B24() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }



    @Test
    @TestOrder(270)
    public void testGetHurikomiInfoYen_B25() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("4112345678 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(280)
    public void testGetHurikomiInfoYen_B26() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("411234567890ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(290)
    public void testGetHurikomiInfoYen_B27() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(300)
    public void testGetHurikomiInfoYen_B28() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(310)
    public void testGetHurikomiInfoYen_B29() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("SMBCﾆﾂｺｳｼﾖｳｹﾝ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "SMBCﾆﾂｺｳｼﾖｳｹﾝ", "振込依頼人名（カナ）");

    }


    @Test
    @TestOrder(320)
    public void testGetHurikomiInfoYen_B30() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("4112345678");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");

    }

    @Test
    @TestOrder(330)
    public void testGetHurikomiInfoYen_B33() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789 ");
        skHurikomiKouzaInfoBean.setHrkmirninNm("41123456789ｽﾐﾄﾓ ﾊﾅｺ1ｱｲｳ2ﾌﾘｺﾐﾆﾝ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ﾌﾘｺﾐﾆﾝ", "振込依頼人名（カナ）");
    }


    @Test
    @TestOrder(340)
    public void testGetHurikomiInfoYen_B34() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo("693395000081");
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("123456789 ");
        skHurikomiKouzaInfoBean.setHrkmirninNm("ｱ123456789 ｽﾐﾄﾓ ﾊﾅｺ ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(370)
    public void testGetHurikomiInfoYen_B37() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(380)
    public void testGetHurikomiInfoYen_B38() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("123456789");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "123456789", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "", "振込依頼人名（カナ）");
    }

    @Test
    @TestOrder(400)
    public void testGetHurikomiInfoYen_B40() {

        skHurikomiKouzaInfoBean.setBankCd("7503");
        skHurikomiKouzaInfoBean.setSitenCd("501");
        skHurikomiKouzaInfoBean.setYokinKbn(C_YokinKbn.HUTUU);
        skHurikomiKouzaInfoBean.setKouzaNo(kouzano1);
        skHurikomiKouzaInfoBean.setTuukasyu(C_Tuukasyu.JPY);
        skHurikomiKouzaInfoBean.setHrkmirninCd("");
        skHurikomiKouzaInfoBean.setHrkmirninNm("12345678 ｽﾐﾄﾓ ﾊﾅｺ");

        SkHurikomiKouzaInfoBean resultBean  = skHurikomiKouzaInfo.getHurikomiInfoYen(skHurikomiKouzaInfoBean);

        exStringEquals(resultBean.getMosno(), "", "申込番号");
        exStringEquals(resultBean.getHrkmirninNmKana(), "ｽﾐﾄﾓ ﾊﾅｺ", "振込依頼人名（カナ）");
    }

}
