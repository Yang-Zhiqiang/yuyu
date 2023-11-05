package yuyu.common.bosyuu.hbcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ権限判定 {@link HbSeihoWebHanteiKengen#getSeihowebUserKbn(WsBzWebserviceReqParamBean, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HbSeihoWebHanteiKengenTest_getSeihowebUserKbn {

    @Inject
    private HbSeihoWebHanteiKengen hbSeihoWebHanteiKengen;
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testGetSeihowebUserKbn_A1() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("123456789012");
        wsBzWebserviceReqParamBean.setOrgCode("7440000");

        C_SeihowebsousasyaKbn seihowebsousasyaKbn = hbSeihoWebHanteiKengen.getSeihowebUserKbn(wsBzWebserviceReqParamBean, "111111");

        exClassificationEquals(seihowebsousasyaKbn, C_SeihowebsousasyaKbn.SUPPORTDESK, "生保Ｗｅｂ操作者区分");
    }

    @Test
    @TestOrder(20)
    public void testGetSeihowebUserKbn_A2() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("223456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5660000");

        C_SeihowebsousasyaKbn seihowebsousasyaKbn = hbSeihoWebHanteiKengen.getSeihowebUserKbn(wsBzWebserviceReqParamBean, "111111");

        exClassificationEquals(seihowebsousasyaKbn, C_SeihowebsousasyaKbn.SUPPORTDESK, "生保Ｗｅｂ操作者区分");
    }

    @Test
    @TestOrder(30)
    public void testGetSeihowebUserKbn_A3() {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = new WsBzWebserviceReqParamBean();

        wsBzWebserviceReqParamBean.setOperatorId("053456789012");
        wsBzWebserviceReqParamBean.setOrgCode("5660000");

        C_SeihowebsousasyaKbn seihowebsousasyaKbn = hbSeihoWebHanteiKengen.getSeihowebUserKbn(wsBzWebserviceReqParamBean, "345678");

        exClassificationEquals(seihowebsousasyaKbn, C_SeihowebsousasyaKbn.DIRTNBSYNN, "生保Ｗｅｂ操作者区分");
    }

}
