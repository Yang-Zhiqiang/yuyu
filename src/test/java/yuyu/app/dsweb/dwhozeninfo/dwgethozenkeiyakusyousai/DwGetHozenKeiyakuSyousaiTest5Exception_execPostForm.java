package yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuSyousaiOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約詳細取得のメイン処理{@link DwGetHozenKeiyakuSyousaiImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwGetHozenKeiyakuSyousaiTest5Exception_execPostForm extends AbstractTest {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        DsDB2UtilMockForDirect.caller = DwGetHozenKeiyakuSyousaiTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
    }
    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);

        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005202", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);

        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005201", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception{

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("orgCode", "{'iwsSyono':'17806000013'}");

        String className = "";

        try {
            DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
            WsBzWebserviceResParamBean  wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
