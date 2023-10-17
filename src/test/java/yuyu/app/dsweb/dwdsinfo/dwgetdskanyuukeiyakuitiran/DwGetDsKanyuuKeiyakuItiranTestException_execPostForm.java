package yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ加入契約一覧取得のメイン処理{@link DwGetDsKanyuuKeiyakuItiranImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwGetDsKanyuuKeiyakuItiranTestException_execPostForm {

    @Test
    @TestOrder(10)
    public void testExecPostForm_B1() throws Exception {


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsDskokno':'8600000041'}");

        DwGetDsKanyuuKeiyakuItiranImpl dwGetDsKanyuuKeiyakuItiranImpl = SWAKInjector
            .getInstance(DwGetDsKanyuuKeiyakuItiranImpl.class);

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetDsKanyuuKeiyakuItiranImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }
}
