package yuyu.common.bosyuu.hbcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ権限判定 {@link HbSeihoWebHanteiKengen#convDairiten(WsBzWebserviceReqParamBean, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbSeihoWebHanteiKengenTest_convDairiten {

    @Inject
    private HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testConvDairiten_A1() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("011055559012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convDairiten(wsBzWebserviceReqParamBean, "1234567");

        exStringEquals(pConvDrtencd, "5200024", "変換後代理店コード");
    }

    @Test
    @TestOrder(20)
    public void testConvDairiten_A2() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("011055549012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convDairiten(wsBzWebserviceReqParamBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }

    @Test
    @TestOrder(30)
    public void testConvDairiten_A3() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("021055559012");
        wsBzWebserviceReqParamBean.setOrgCode("5670000");

        String pConvDrtencd = hbSeihoWebHanteiKengen.convDairiten(wsBzWebserviceReqParamBean, "1234567");

        exStringEquals(pConvDrtencd, "1234567", "変換後代理店コード");
    }
}
