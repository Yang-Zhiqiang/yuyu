package yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuEnItijiSyusinOutputBean;
import yuyu.def.dsweb.bean.webservice.WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ特定取引用暗証番号認証のメイン処理{@link DwTktiTrhkyuAnsyoubangouNinsyouImpl#execPostForm(MultivaluedMap<String, String> pMap)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm extends AbstractTest {

    @Inject
    private DwTktiTrhkyuAnsyoubangouNinsyouImpl dwTktiTrhkyuAnsyoubangouNinsyouImpl;

    @Inject
    private BaseUserInfo baseUserInfo;

    private Integer lockoutKiteiKaisuu = 0;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ特定取引用暗証番号認証";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);
            }
        });
    }

    @Before
    public void testInit() {

        WebServiceAccesslogOutputMockForDirect.caller = DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class;
        DsDB2UtilMockForDirect.caller = DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class;
        baseUserInfo.getUser().setUserId("Ju01");
        lockoutKiteiKaisuu = YuyuDswebConfig.getInstance().getLockoutKiteiKaisuu();
        YuyuDswebConfig.getInstance().setLockoutKiteiKaisuu(4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567890"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567891"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567892"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567893"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567894"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567895"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567896"));
        directDomManager.delete(directDomManager.getDsKokyakuKanri("1234567897"));
    }

    @After
    public void testClear() {

        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;
        YuyuDswebConfig.getInstance().setLockoutKiteiKaisuu(lockoutKiteiKaisuu);
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'','iwsSyono':'11807111118','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567890','iwsSyono':'','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567890','iwsSyono':'11807111118','iwsTokuteitrhkansyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'１１１１１１１１１１','iwsSyono':'11807111118','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'AAAAAAAAAA','iwsSyono':'11807111118','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'123456789','iwsSyono':'11807111118','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567890','iwsSyono':'11111111111','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567890','iwsSyono':'11807111118','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014201", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567891','iwsSyono':'11807111129','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014001", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567892','iwsSyono':'11807111130','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014003", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567893','iwsSyono':'11807111141','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014203", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567894','iwsSyono':'11807111152','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014001", "（ＩＷＳ）ＤＳメッセージコード");

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = directDomManager.getDsKokyakuKanri("1234567894").getDsKokyakuKeiyakuBySyono("11807111152");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        exStringEquals(dsTorihikiServiceKanri.getDskokno(), "1234567894", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiServiceKanri.getSyono(), "11807111152", "証券番号");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn(), C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA, "ＤＳ取引サービス利用状況区分");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn(), C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT, "ＤＳ取引サービス停止理由区分");
        assertNotNull(dsTorihikiServiceKanri.getDstrhkservicemukouymd());
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinKinou(), "dwtktitrhkyuansyoubangouninsyou", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinsyaId(), "Ju01", "業務用更新者ＩＤ");
        assertNotNull(dsTorihikiServiceKanri.getGyoumuKousinTime());

        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();
        exStringEquals(dsTorihikiyouAnsyono.getDskokno(), "1234567894", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiyouAnsyono.getSyono(), "11807111152", "証券番号");
        exNumericEquals(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu(), 5, "特定取引用暗証番号エラー回数");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinKinou(), "dwtktitrhkyuansyoubangouninsyou", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinsyaId(), "Ju01", "業務用更新者ＩＤ");
        assertNotNull(dsTorihikiyouAnsyono.getGyoumuKousinTime());

    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_A13() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567895','iwsSyono':'11807111163','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014001", "（ＩＷＳ）ＤＳメッセージコード");

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = directDomManager.getDsKokyakuKanri("1234567895").getDsKokyakuKeiyakuBySyono("11807111163");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        exStringEquals(dsTorihikiServiceKanri.getDskokno(), "1234567895", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiServiceKanri.getSyono(), "11807111163", "証券番号");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn(), C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA, "ＤＳ取引サービス利用状況区分");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn(), C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT, "ＤＳ取引サービス停止理由区分");
        assertNotNull(dsTorihikiServiceKanri.getDstrhkservicemukouymd());
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinKinou(), "dwtktitrhkyuansyoubangouninsyou", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinsyaId(), "Ju01", "業務用更新者ＩＤ");
        assertNotNull(dsTorihikiServiceKanri.getGyoumuKousinTime());

        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();
        exStringEquals(dsTorihikiyouAnsyono.getDskokno(), "1234567895", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiyouAnsyono.getSyono(), "11807111163", "証券番号");
        exNumericEquals(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu(), 4, "特定取引用暗証番号エラー回数");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinKinou(), "dwtktitrhkyuansyoubangouninsyou", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinsyaId(), "Ju01", "業務用更新者ＩＤ");
        assertNotNull(dsTorihikiyouAnsyono.getGyoumuKousinTime());

    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_A14() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567896','iwsSyono':'11807111174','iwsTokuteitrhkansyono':'5555521'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014002", "（ＩＷＳ）ＤＳメッセージコード");

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = directDomManager.getDsKokyakuKanri("1234567896").getDsKokyakuKeiyakuBySyono("11807111174");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        exStringEquals(dsTorihikiServiceKanri.getDskokno(), "1234567896", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiServiceKanri.getSyono(), "11807111174", "証券番号");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn(), C_DsTrhkserviceRiyoujkKbn.RIYOU_KA, "ＤＳ取引サービス利用状況区分");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn(), C_DsTrhkserviceTeisiRiyuuKbn.OKYAKUSAMAYOUBOU, "ＤＳ取引サービス停止理由区分");
        exDateEquals(dsTorihikiServiceKanri.getDstrhkservicemukouymd(), BizDate.valueOf(20180101), "ＤＳ取引サービス無効年月日");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinTime(), null, "業務用更新時間");

        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();
        exStringEquals(dsTorihikiyouAnsyono.getDskokno(), "1234567896", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiyouAnsyono.getSyono(), "11807111174", "証券番号");
        exNumericEquals(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu(), 3, "特定取引用暗証番号エラー回数");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinKinou(), "dwtktitrhkyuansyoubangouninsyou", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinsyaId(), "Ju01", "業務用更新者ＩＤ");
        assertNotNull(dsTorihikiyouAnsyono.getGyoumuKousinTime());

    }

    @Test
    @TestOrder(150)
    public void testExecPostForm_A15() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'1234567897','iwsSyono':'11807111185','iwsTokuteitrhkansyono':'5555555'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean outputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);

        exStringEquals(outputBean.getIwsDsmsgcd(), "014000", "（ＩＷＳ）ＤＳメッセージコード");

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = directDomManager.getDsKokyakuKanri("1234567897").getDsKokyakuKeiyakuBySyono("11807111185");
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();
        exStringEquals(dsTorihikiServiceKanri.getDskokno(), "1234567897", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiServiceKanri.getSyono(), "11807111185", "証券番号");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn(), C_DsTrhkserviceRiyoujkKbn.RIYOU_KA, "ＤＳ取引サービス利用状況区分");
        exClassificationEquals(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn(), C_DsTrhkserviceTeisiRiyuuKbn.OKYAKUSAMAYOUBOU, "ＤＳ取引サービス停止理由区分");
        exDateEquals(dsTorihikiServiceKanri.getDstrhkservicemukouymd(), BizDate.valueOf(20180101), "ＤＳ取引サービス無効年月日");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(dsTorihikiServiceKanri.getGyoumuKousinTime(), null, "業務用更新時間");

        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();
        exStringEquals(dsTorihikiyouAnsyono.getDskokno(), "1234567897", "ＤＳ顧客番号");
        exStringEquals(dsTorihikiyouAnsyono.getSyono(), "11807111185", "証券番号");
        exNumericEquals(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu(), 0, "特定取引用暗証番号エラー回数");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinKinou(), "dwtktitrhkyuansyoubangouninsyou", "業務用更新機能ＩＤ");
        exStringEquals(dsTorihikiyouAnsyono.getGyoumuKousinsyaId(), "Ju01", "業務用更新者ＩＤ");
        assertNotNull(dsTorihikiyouAnsyono.getGyoumuKousinTime());

    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_B1() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'11807111118'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "014205", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(170)
    public void testExecPostForm_B2() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'11807111118'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuEnItijiSyusinOutputBean wsDwGetHozenKeiyakuEnItijiSyusinOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuEnItijiSyusinOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuEnItijiSyusinOutputBean.getIwsDsmsgcd(), "014204", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_B3() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'11807111118'}");

        String className = "";

        try {
            dwTktiTrhkyuAnsyoubangouNinsyouImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外のクラス名");

    }
}


