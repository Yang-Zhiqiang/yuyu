package yuyu.app.dsweb.dwkokyakuinfo.dwgettuusinsakiinfo;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 顧客通信先情報取得のメイン処理{@link DwGetTuusinsakiInfoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwGetTuusinsakiInfoTest2_execPostForm {

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception{

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
