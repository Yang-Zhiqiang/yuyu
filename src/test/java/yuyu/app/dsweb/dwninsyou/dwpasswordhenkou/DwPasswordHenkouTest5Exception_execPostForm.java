package yuyu.app.dsweb.dwninsyou.dwpasswordhenkou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import net.arnx.jsonic.JSON;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2UtilMock;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwPasswordHenkouOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * パスワード変更のメイン処理{@link DwPasswordHenkouImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwPasswordHenkouTest5Exception_execPostForm extends AbstractTest {

    @Inject
    private DwPasswordHenkouImpl dwPasswordHenkouImpl;

    @BeforeClass
    public static void testInit() {

        DsDB2UtilMock.caller = DwPasswordHenkouTest_execPostForm.class;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'0000001','iwsSclakatopassword':'123456'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        WsDwPasswordHenkouOutputBean wsDwPasswordHenkouOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwPasswordHenkouOutputBean.class);

        exStringEquals(wsDwPasswordHenkouOutputBean.getIwsDsmsgcd(), "003203", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'0000001','iwsSclakatopassword':'123456'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        WsDwPasswordHenkouOutputBean wsDwPasswordHenkouOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwPasswordHenkouOutputBean.class);

        exStringEquals(wsDwPasswordHenkouOutputBean.getIwsDsmsgcd(), "003202", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception{

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'0000001','iwsSclakatopassword':'123456'}");

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
