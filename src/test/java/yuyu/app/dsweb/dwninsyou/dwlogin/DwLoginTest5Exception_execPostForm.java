package yuyu.app.dsweb.dwninsyou.dwlogin;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwLoginOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ログイン認証のメイン処理{@link DwLoginImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwLoginTest5Exception_execPostForm extends AbstractTest {

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

        DsDB2UtilMockForDirect.caller = DwLoginTest_execPostForm.class;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "{'iwsSyono':'17806000219','iwsPassword':'123456'}");

        DwLoginImpl dwLoginImpl = SWAKInjector.getInstance(DwLoginImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001203", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "{'iwsSyono':'17806000219','iwsPassword':'123456'}");

        DwLoginImpl dwLoginImpl = SWAKInjector.getInstance(DwLoginImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);

        WsDwLoginOutputBean wsDwLoginOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwLoginOutputBean.class);

        exStringEquals(wsDwLoginOutputBean.getIwsDsmsgcd(), "001202", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() throws Exception{

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "{'iwsSyono':'17806000219','iwsPassword':'123456'}");

        String className = "";

        try {
            DwLoginImpl dwLoginImpl = SWAKInjector.getInstance(DwLoginImpl.class);
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
