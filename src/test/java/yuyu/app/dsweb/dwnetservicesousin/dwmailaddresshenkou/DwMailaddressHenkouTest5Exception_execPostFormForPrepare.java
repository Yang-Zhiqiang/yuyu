package yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import net.arnx.jsonic.JSON;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2UtilMock;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuSyousaiOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * メール変更のメイン処理（事前準備）{@link DwMailAddressHenkouImpl#execPostFormForPrepare(MultivaluedMap<String, String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwMailaddressHenkouTest5Exception_execPostFormForPrepare {

    @Inject
    private DwMailAddressHenkouImpl dwMailAddressHenkouImpl;

    @BeforeClass
    public static void testInit() {

        DsDB2UtilMock.caller = DwMailaddressHenkou_execPostFormForPrepare.class;
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormForPrepare_A1() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'',  'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);

        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "009203", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testExecPostFormForPrepare_A2() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'',  'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);

        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "009202", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostFormForPrepare_A3() throws Exception{

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN3;

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'',  'iwsDssousinno':'123456789012345678901'}");

        String className = "";

        try {
            WsBzWebserviceResParamBean  wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }
}
