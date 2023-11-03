package yuyu.app.dsweb.dwninsyou.dwhonninkakunin;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2UtilMock;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwHonninKakuninOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 本人確認処理のメイン処理{@link DwHonninKakuninImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwHonninKakuninTest5Exception_execPostForm {

    @BeforeClass
    public static void testInit() {

        DsDB2UtilMock.caller = DwHonninKakuninTest_execPostForm.class;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10000000001', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        DwHonninKakuninImpl dwHonninKakuninImpl = SWAKInjector.getInstance(DwHonninKakuninImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        WsDwHonninKakuninOutputBean wsDwHonninKakuninOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwHonninKakuninOutputBean.class);

        exStringEquals(wsDwHonninKakuninOutputBean.getIwsDsmsgcd(), "002206", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10000000001', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        DwHonninKakuninImpl dwHonninKakuninImpl = SWAKInjector.getInstance(DwHonninKakuninImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        WsDwHonninKakuninOutputBean wsDwHonninKakuninOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwHonninKakuninOutputBean.class);

        exStringEquals(wsDwHonninKakuninOutputBean.getIwsDsmsgcd(), "002205", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        DsDB2UtilMock.SYORIPTN = DsDB2UtilMock.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10000000001', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");

        DwHonninKakuninImpl dwHonninKakuninImpl = SWAKInjector.getInstance(DwHonninKakuninImpl.class);
        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }

}
