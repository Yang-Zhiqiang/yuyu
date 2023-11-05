package yuyu.common.bosyuu.hbcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ権限判定 {@link HbSeihoWebHanteiKengen#execChkTanmatuKengen(WsBzWebserviceReqParamBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbSeihoWebHanteiKengenTest_execChkTanmatuKengen {

    @Inject
    private HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExecChkTanmatuKengen_A1() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("213456789012");
        wsBzWebserviceReqParamBean.setOrgCode("7380000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.TANMATUERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(20)
    public void testExecChkTanmatuKengen_A2() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("213456789012");
        wsBzWebserviceReqParamBean.setOrgCode("6628000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.TANMATUERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(30)
    public void testExecChkTanmatuKengen_A3() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("213456789012");
        wsBzWebserviceReqParamBean.setOrgCode("1239000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.TANMATUERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(40)
    public void testExecChkTanmatuKengen_A4() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("123456789032");
        wsBzWebserviceReqParamBean.setOrgCode("5439000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.SIYOUSHAERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(50)
    public void testExecChkTanmatuKengen_A5() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("123456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5438000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.TANMATUERROR, "生保Ｗｅｂ権限区分");
    }

    @Test
    @TestOrder(60)
    public void testExecChkTanmatuKengen_A6() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("213456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5438000");

        C_SeihowebkengenKbn seihowebkengenKbn = hbSeihoWebHanteiKengen.execChkTanmatuKengen(wsBzWebserviceReqParamBean);

        exClassificationEquals(seihowebkengenKbn, C_SeihowebkengenKbn.ARI, "生保Ｗｅｂ権限区分");
    }
}
