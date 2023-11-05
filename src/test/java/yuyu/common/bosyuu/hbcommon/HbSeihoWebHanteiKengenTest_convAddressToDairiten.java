package yuyu.common.bosyuu.hbcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosInputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ権限判定 {@link HbSeihoWebHanteiKengen#convAddressToDairiten(WsHbSeihoWebSekMosInputBean, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbSeihoWebHanteiKengenTest_convAddressToDairiten {

    @Inject
    private HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen;

    @Test
    @TestOrder(10)
    public void testconvAddressToDairiten_A1() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("住所（５１００００１）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(20)
    public void testconvAddressToDairiten_A2() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所５１００００１");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(30)
    public void testconvAddressToDairiten_A3() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１００００１");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(40)
    public void testconvAddressToDairiten_A4() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所５１００００１）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(50)
    public void testconvAddressToDairiten_A5() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(60)
    public void testconvAddressToDairiten_A6() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(70)
    public void testconvAddressToDairiten_A7() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(80)
    public void testconvAddressToDairiten_A8() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１０）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(90)
    public void testconvAddressToDairiten_A9() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１００）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(100)
    public void testconvAddressToDairiten_A10() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１０００）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(110)
    public void testconvAddressToDairiten_A11() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１００００）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(120)
    public void testconvAddressToDairiten_A12() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("　　　手数料確認用住所（５１００００１）　　　　　");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "5100001", "変換後代理店コード");
    }


    @Test
    @TestOrder(130)
    public void testconvAddressToDairiten_A13() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("手数料確認用住所（５１００００１）");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "1234567");

        exStringEquals(pConvDrtencd, "5100001", "変換後代理店コード");
    }


    @Test
    @TestOrder(140)
    public void testconvAddressToDairiten_A14() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr("");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "5100001");

        exStringEquals(pConvDrtencd, "5100001", "変換後代理店コード");
    }

    @Test
    @TestOrder(150)
    public void testconvAddressToDairiten_A15() {

        WsHbSeihoWebSekMosInputBean wsHbSeihoWebSekMosInputBean = new WsHbSeihoWebSekMosInputBean();

        wsHbSeihoWebSekMosInputBean.setIwsKanjitsinkaiadr(null);

        String pConvDrtencd = hbSeihoWebHanteiKengen.convAddressToDairiten(wsHbSeihoWebSekMosInputBean, "5100001");

        exStringEquals(pConvDrtencd, "5100001", "変換後代理店コード");
    }

}
