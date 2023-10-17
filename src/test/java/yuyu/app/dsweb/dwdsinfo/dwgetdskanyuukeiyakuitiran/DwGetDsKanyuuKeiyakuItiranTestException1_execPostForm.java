package yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import net.arnx.jsonic.JSON;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetDsKanyuuKeiyakuItiranOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;

/**
 * ＤＳ加入契約一覧取得のメイン処理{@link DwGetDsKanyuuKeiyakuItiranImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwGetDsKanyuuKeiyakuItiranTestException1_execPostForm extends AbstractTest {

    @Inject
    private DwGetDsKanyuuKeiyakuItiranImpl dwGetDsKanyuuKeiyakuItiranImpl;

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

        DsDB2UtilMockForDirect.caller = DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'8600000025'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean wsDwGetDsKanyuuKeiyakuItiranOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);

        exStringEquals(wsDwGetDsKanyuuKeiyakuItiranOutputBean.getIwsDsmsgcd(), "004202", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'8600000041'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        WsDwGetDsKanyuuKeiyakuItiranOutputBean wsDwGetDsKanyuuKeiyakuItiranOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwGetDsKanyuuKeiyakuItiranOutputBean.class);

        exStringEquals(wsDwGetDsKanyuuKeiyakuItiranOutputBean.getIwsDsmsgcd(), "004201", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception{

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDskokno':'8600000041'}");

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
