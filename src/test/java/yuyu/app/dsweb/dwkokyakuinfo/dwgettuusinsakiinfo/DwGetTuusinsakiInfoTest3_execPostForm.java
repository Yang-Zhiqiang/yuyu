package yuyu.app.dsweb.dwkokyakuinfo.dwgettuusinsakiinfo;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2UtilMock;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetTuusinsakiInfoOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 顧客通信先情報取得のメイン処理{@link DwGetTuusinsakiInfoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwGetTuusinsakiInfoTest3_execPostForm {

    @BeforeClass
    public static void testInit() {
        DsDB2UtilMock.caller = DwGetTuusinsakiInfoTest_execPostForm.class;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean ｗsDwGetTuusinsakiInfoOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(ｗsDwGetTuusinsakiInfoOutputBean.getIwsDsmsgcd(), "006205", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean ｗsDwGetTuusinsakiInfoOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(ｗsDwGetTuusinsakiInfoOutputBean.getIwsDsmsgcd(), "006204", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception{

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN3;

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        String className = "";

        try {
            WsBzWebserviceResParamBean  wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");


    }
}
