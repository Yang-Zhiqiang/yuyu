package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.common.hozen.haitou.NaiteiKakuteiRateHantei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 内定確定レート判定クラスのメソッド {@link NaiteiKakuteiRateHantei#exec(BizDate , BizDateY , C_UmuKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class NaiteiKakuteiRateHanteiTest_exec {

    private C_ErrorKbn errorKbn;

    private C_NaiteiKakuteiKbn naiteiKakuteiKbn;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = null;
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, null, "内定確定区分");


    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171107");
        BizDateY pDratenendo = null;
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        List<HaitouErrorInfo> HaitouErrorInfoLst = naiteiKakuteiRateHantei.getErrorInfo();

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, null, "内定確定区分");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), naiteiKakuteiRateHantei.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171107");
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1111");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1112");

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        List<HaitouErrorInfo> HaitouErrorInfoLst = naiteiKakuteiRateHantei.getErrorInfo();
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, null, "内定確定区分");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), naiteiKakuteiRateHantei.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "Ｄレートなし", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), null, "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171107");
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.ARI;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1107");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1111");

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171110");
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1107");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1111");

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171107");
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1107");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1108");

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171107");
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1106");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1107");

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        NaiteiKakuteiRateHantei naiteiKakuteiRateHantei = SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class);
        BizDate pSyoriYmd = BizDate.valueOf("20171107");
        BizDateY pDratenendo = BizDateY.valueOf("2017");
        C_UmuKbn pKessanSiyouUmu = C_UmuKbn.NONE;
        YuyuHozenConfig.getInstance().setDrateRendouMd("1106");
        YuyuHozenConfig.getInstance().setDrateKakuteiMd("1106");

        errorKbn = naiteiKakuteiRateHantei.exec(pSyoriYmd, pDratenendo, pKessanSiyouUmu);
        naiteiKakuteiKbn = naiteiKakuteiRateHantei.getNaiteiKakuteiKbn();

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals( naiteiKakuteiKbn, C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");

    }

}
