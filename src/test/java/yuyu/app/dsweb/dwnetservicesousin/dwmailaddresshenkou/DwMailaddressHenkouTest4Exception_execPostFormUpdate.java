package yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou.DwMailAddressHenkouImpl;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * メール変更のメイン処理{@link DwMailAddressHenkouImpl#execPostFormUpdate(MultivaluedMap<String, String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwMailaddressHenkouTest4Exception_execPostFormUpdate {

    @Test
    @TestOrder(10)
    public void test4Exception_ExecPostFormUpdate_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111001', 'iwsDsmailaddress':'www.liant@co.jp', 'iwsDssousinno':'123456789012345678901'}");


        DwMailAddressHenkouImpl dwMailAddressHenkouImpl = SWAKInjector.getInstance(DwMailAddressHenkouImpl.class);

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormUpdate(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
