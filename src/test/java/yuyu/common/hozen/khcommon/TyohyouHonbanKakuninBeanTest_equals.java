package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 帳票本番確認Beanクラスのメソッド {@link TyohyouHonbanKakuninBean#equals(Object)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TyohyouHonbanKakuninBeanTest_equals {

    @Test
    @TestOrder(2010)
    public void testEquals_A1() {

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(null);
        exBooleanEquals(hannteiKekka, false, "判定結果");
    }
    @Test
    @TestOrder(2020)
    public void testEquals_A2() {

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        Object object = new Object();
        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(object);
        exBooleanEquals(hannteiKekka, false, "判定結果");
    }
    @Test
    @TestOrder(2030)
    public void testEquals_A3() {

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(null);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");

    }
    @Test
    @TestOrder(2040)
    public void testEquals_A4() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(null);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }
    @Test
    @TestOrder(2050)
    public void testEquals_A5() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1(null);
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }
    @Test
    @TestOrder(2060)
    public void testEquals_A6() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1(null);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }
    @Test
    @TestOrder(2070)
    public void testEquals_A7() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2(null);
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }
    @Test
    @TestOrder(2080)
    public void testEquals_A8() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2(null);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }
    @Test
    @TestOrder(2090)
    public void testEquals_A9() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3(null);
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2100)
    public void testEquals_A10() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3(null);
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2110)
    public void testEquals_A11() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(null);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2120)
    public void testEquals_A12() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(null);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2130)
    public void testEquals_A13() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(null);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2140)
    public void testEquals_A14() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(null);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2150)
    public void testEquals_A15() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.KOKYAKUTUUTI);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2160)
    public void testEquals_A16() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2170)
    public void testEquals_A17() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("012");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2180)
    public void testEquals_A18() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("010");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2190)
    public void testEquals_A19() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.BZ_JIGYOUHIKANJYOUKAKUSYOULIST_1);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2200)
    public void testEquals_A20() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.KAKUNINZUMI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, false, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), false, "ハッシュコード");
    }

    @Test
    @TestOrder(2210)
    public void testEquals_A21() {


        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean1 = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean1.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean1.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean1.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean1.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean1.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean1);
        exBooleanEquals(hannteiKekka, true, "判定結果");
        exBooleanEquals(tyohyouHonbanKakuninBean.hashCode() == tyohyouHonbanKakuninBean1.hashCode(), true, "ハッシュコード");
    }

    @Test
    @TestOrder(2220)
    public void testEquals_A22() {

        TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean = SWAKInjector.getInstance(TyohyouHonbanKakuninBean.class);
        tyohyouHonbanKakuninBean.setTyouhyoubunrui(C_TyouhyouBunruiKbn.SYOUKEN);
        tyohyouHonbanKakuninBean.setJyoukenbunrui1("010");
        tyohyouHonbanKakuninBean.setJyoukenbunrui2("011");
        tyohyouHonbanKakuninBean.setJyoukenbunrui3("012");
        tyohyouHonbanKakuninBean.setSyoruiCd(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR);
        tyohyouHonbanKakuninBean.setKakuninjyoutaikbn(C_KakuninjyoutaiKbn.MISYORI);

        boolean hannteiKekka = tyohyouHonbanKakuninBean.equals(tyohyouHonbanKakuninBean);
        exBooleanEquals(hannteiKekka, true, "判定結果");
    }
}