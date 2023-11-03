package yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousai;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiMockForDirect;
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
public class DwGetHozenKeiyakuSyousaiTest4Exception_execPostForm extends AbstractTest {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DsGetKeiyakuSyousai.class).to(DsGetKeiyakuSyousaiMockForDirect.class);
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        DsGetKeiyakuSyousaiMockForDirect.caller = DwGetHozenKeiyakuSyousaiTest4Exception_execPostForm.class;
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKeiyakuSyousaiTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        DsGetKeiyakuSyousaiMockForDirect.caller = null;
        DsGetKeiyakuSyousaiMockForDirect.SYORIPTN = null;
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_D1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'100000000001'}");

        String className = "";

        try {
            DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(
                DwGetHozenKeiyakuSyousaiImpl.class);
            dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
