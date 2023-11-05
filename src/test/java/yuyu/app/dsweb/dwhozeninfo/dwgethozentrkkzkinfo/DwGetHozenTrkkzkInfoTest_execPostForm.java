package yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsDB2UtilMockForDirect;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommon;
import yuyu.common.direct.dscommon.DsGetKeiyakuCommonMockForDirect;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenTrkkzkInfoOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全登録家族情報取得サービスのメイン処理{@link DwGetHozenTrkkzkInfoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwGetHozenTrkkzkInfoTest_execPostForm extends AbstractTest {

    @Inject
    private DwGetHozenTrkkzkInfoImpl dwGetHozenTrkkzkInfoImpl;


    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全登録家族情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DwGetHozenTrkkzkInfoTest_execPostForm.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {

        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenTrkkzkInfoTest_execPostForm.class;

        DsDB2UtilMockForDirect.caller = DwGetHozenTrkkzkInfoTest_execPostForm.class;

        GetKhKykdrInfoMockForDirect.caller = DwGetHozenTrkkzkInfoTest_execPostForm.class;

        DsGetKeiyakuCommonMockForDirect.caller = DwGetHozenTrkkzkInfoTest_execPostForm.class;

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    public static void testClear() {

        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;

        DsDB2UtilMockForDirect.caller = null;
        DsDB2UtilMockForDirect.SYORIPTN = null;

        GetKhKykdrInfoMockForDirect.caller = null;
        GetKhKykdrInfoMockForDirect.SYORIPTN = null;

        DsGetKeiyakuCommonMockForDirect.caller = null;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = null;

    }

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);

                bind(DsDB2Util.class).to(DsDB2UtilMockForDirect.class);

                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoMockForDirect.class);

                bind(DsGetKeiyakuCommon.class).to(DsGetKeiyakuCommonMockForDirect.class);

            }
        });
    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenTrkkzkInfoOutputBean.class);

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsDsmsgcd(), "020100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsSyono(), null, "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdairinmkn(), null, "（ＩＷＳ）契約者代理人名（カナ）");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdrtkhkumu(), null, "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKzktrkkykdrkahikbn(), null, "（ＩＷＳ）家族登録・契約者代理特約変更可否区分");

        testNull(wsDwGetHozenTrkkzkInfoOutputBean);

        MockObjectManager.assertArgumentPassed(WebServiceAccesslogOutputMockForDirect.class, "exec", 0,
            C_AccessLogSyubetuKbn.ACTION_BEGIN);

    }


    @Test
    @TestOrder(2010)
    public void testExecPostForm_A2() throws Exception {

        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'100000000001'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenTrkkzkInfoOutputBean.class);

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsDsmsgcd(), "020100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsSyono(), null, "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdairinmkn(), null, "（ＩＷＳ）契約者代理人名（カナ）");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdrtkhkumu(), null, "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKzktrkkykdrkahikbn(), null, "（ＩＷＳ）家族登録・契約者代理特約変更可否区分");

        testNull(wsDwGetHozenTrkkzkInfoOutputBean);

    }


    @Test
    @TestOrder(3010)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        GetKhKykdrInfoMockForDirect.SYORIPTN = GetKhKykdrInfoMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenTrkkzkInfoOutputBean.class);

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsDsmsgcd(), "020000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsSyono(), "99806001010", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdairinmkn(), "ユウケメイ　イチア", "（ＩＷＳ）契約者代理人名（カナ）");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdrtkhkumu(), "1", "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKzktrkkykdrkahikbn(), "1", "（ＩＷＳ）家族登録・契約者代理特約変更可否区分");


        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkkbn1(), "1", "（ＩＷＳ）登録家族区分１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkumu1(), "0", "（ＩＷＳ）登録家族情報有無１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkn1(), "カナ１", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkj1(), "漢字１", "（ＩＷＳ）登録家族名（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseiymd1(), "20200206", "（ＩＷＳ）登録家族生年月日１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzksei1(), "1", "（ＩＷＳ）登録家族性別１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseikj1(), "男性", "（ＩＷＳ）登録家族性別１（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdk1(), "12", "（ＩＷＳ）登録家族続柄１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdkkj1(), "義理の子", "（ＩＷＳ）登録家族続柄１（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinkokyno1(), "1234567", "（ＩＷＳ）登録家族通信先顧客郵便番号１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr1kj1(), "住所１漢字１", "（ＩＷＳ）登録家族通信先住所１（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr2kj1(), "住所２漢字１", "（ＩＷＳ）登録家族通信先住所２（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr3kj1(), "住所３漢字１", "（ＩＷＳ）登録家族通信先住所３（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsintelno1(), "0123-2345-5678", "（ＩＷＳ）登録家族通信先電話番号１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsGyoumukousintime1(), "20200205173204123", "（ＩＷＳ）業務用更新時間１");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkkbn2(), "2", "（ＩＷＳ）登録家族区分２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkumu2(), "1", "（ＩＷＳ）登録家族情報有無２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkn2(), "カナ２", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkj2(), "漢字２", "（ＩＷＳ）登録家族名（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseiymd2(), "20200208", "（ＩＷＳ）登録家族生年月日２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzksei2(), "2", "（ＩＷＳ）登録家族性別２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseikj2(), "女性", "（ＩＷＳ）登録家族性別２（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdk2(), "6", "（ＩＷＳ）登録家族続柄２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdkkj2(), "兄弟姉妹", "（ＩＷＳ）登録家族続柄２（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinkokyno2(), "2345678", "（ＩＷＳ）登録家族通信先顧客郵便番号２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr1kj2(), "住所１漢字２", "（ＩＷＳ）登録家族通信先住所１（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr2kj2(), "住所２漢字２", "（ＩＷＳ）登録家族通信先住所２（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr3kj2(), "住所３漢字２", "（ＩＷＳ）登録家族通信先住所３（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsintelno2(), "1234-2345-6789", "（ＩＷＳ）登録家族通信先電話番号２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsGyoumukousintime2(), "20200206173204999", "（ＩＷＳ）業務用更新時間２");

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getTrkKazoku", 0, "99806001010");

    }


    @Test
    @TestOrder(3020)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        GetKhKykdrInfoMockForDirect.SYORIPTN = GetKhKykdrInfoMockForDirect.TESTPATTERN1;
        DsGetKeiyakuCommonMockForDirect.SYORIPTN = DsGetKeiyakuCommonMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'99806001021'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenTrkkzkInfoOutputBean.class);

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsDsmsgcd(), "020000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsSyono(), "99806001021", "（ＩＷＳ）証券番号");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdairinmkn(), "", "（ＩＷＳ）契約者代理人名（カナ）");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKykdrtkhkumu(), "0", "（ＩＷＳ）保険契約者代理特約付加有無");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsKzktrkkykdrkahikbn(), "1", "（ＩＷＳ）家族登録・契約者代理特約変更可否区分");


        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkkbn1(), "1", "（ＩＷＳ）登録家族区分１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkumu1(), "0", "（ＩＷＳ）登録家族情報有無１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkn1(), "カナ１", "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkj1(), "漢字１", "（ＩＷＳ）登録家族名（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseiymd1(), null, "（ＩＷＳ）登録家族生年月日１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzksei1(), "1", "（ＩＷＳ）登録家族性別１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseikj1(), "男性", "（ＩＷＳ）登録家族性別１（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdk1(), "2", "（ＩＷＳ）登録家族続柄１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdkkj1(), "配偶者", "（ＩＷＳ）登録家族続柄１（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinkokyno1(), "1234567", "（ＩＷＳ）登録家族通信先顧客郵便番号１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr1kj1(), "住所１漢字１", "（ＩＷＳ）登録家族通信先住所１（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr2kj1(), "住所２漢字１", "（ＩＷＳ）登録家族通信先住所２（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr3kj1(), "住所３漢字１", "（ＩＷＳ）登録家族通信先住所３（漢字）１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsintelno1(), "0123-2345-5678", "（ＩＷＳ）登録家族通信先電話番号１");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsGyoumukousintime1(), "20200205173204123", "（ＩＷＳ）業務用更新時間１");

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkkbn2(), "2", "（ＩＷＳ）登録家族区分２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkumu2(), "1", "（ＩＷＳ）登録家族情報有無２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkn2(), "カナ２", "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzknmkj2(), "漢字２", "（ＩＷＳ）登録家族名（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseiymd2(), null, "（ＩＷＳ）登録家族生年月日２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzksei2(), "2", "（ＩＷＳ）登録家族性別２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzkseikj2(), "女性", "（ＩＷＳ）登録家族性別２（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdk2(), "7", "（ＩＷＳ）登録家族続柄２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktdkkj2(), "孫", "（ＩＷＳ）登録家族続柄２（区分名称）");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinkokyno2(), "2345678", "（ＩＷＳ）登録家族通信先顧客郵便番号２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr1kj2(), "住所１漢字２", "（ＩＷＳ）登録家族通信先住所１（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr2kj2(), "住所２漢字２", "（ＩＷＳ）登録家族通信先住所２（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsinadr3kj2(), "住所３漢字２", "（ＩＷＳ）登録家族通信先住所３（漢字）２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsTrkkzktsintelno2(), "1234-2345-6789", "（ＩＷＳ）登録家族通信先電話番号２");
        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsGyoumukousintime2(), "20200206173204999", "（ＩＷＳ）業務用更新時間２");

        MockObjectManager.assertArgumentPassed(DsGetKeiyakuCommonMockForDirect.class, "getTrkKazoku", 0, "99806001021");

    }


    @Test
    @TestOrder(4010)
    public void testExecPostForm_A5() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenTrkkzkInfoOutputBean.class);

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsDsmsgcd(), "020201", "（ＩＷＳ）ＤＳメッセージコード");

    }


    @Test
    @TestOrder(4020)
    public void testExecPostForm_A6() throws Exception {

        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'99806001010'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        WsDwGetHozenTrkkzkInfoOutputBean wsDwGetHozenTrkkzkInfoOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenTrkkzkInfoOutputBean.class);

        exStringEquals(wsDwGetHozenTrkkzkInfoOutputBean.getIwsDsmsgcd(), "020200", "（ＩＷＳ）ＤＳメッセージコード");

    }


    @Test
    @TestOrder(4030)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        DsDB2UtilMockForDirect.SYORIPTN = DsDB2UtilMockForDirect.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'99806001010'}");

        String className = "";

        try {
            dwGetHozenTrkkzkInfoImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }


    private void testNull(WsDwGetHozenTrkkzkInfoOutputBean pBean) {

        exStringEquals(pBean.getIwsTrkkzkkbn1(), null, "（ＩＷＳ）登録家族区分１");
        exStringEquals(pBean.getIwsTrkkzkumu1(), null, "（ＩＷＳ）登録家族情報有無１");
        exStringEquals(pBean.getIwsTrkkzknmkn1(), null, "（ＩＷＳ）登録家族名（カナ）１");
        exStringEquals(pBean.getIwsTrkkzknmkj1(), null, "（ＩＷＳ）登録家族名（漢字）１");
        exStringEquals(pBean.getIwsTrkkzkseiymd1(), null, "（ＩＷＳ）登録家族生年月日１");
        exStringEquals(pBean.getIwsTrkkzksei1(), null, "（ＩＷＳ）登録家族性別１");
        exStringEquals(pBean.getIwsTrkkzkseikj1(), null, "（ＩＷＳ）登録家族性別１（区分名称）");
        exStringEquals(pBean.getIwsTrkkzktdk1(), null, "（ＩＷＳ）登録家族続柄１");
        exStringEquals(pBean.getIwsTrkkzktdkkj1(), null, "（ＩＷＳ）登録家族続柄１（区分名称）");
        exStringEquals(pBean.getIwsTrkkzktsinkokyno1(), null, "（ＩＷＳ）登録家族通信先顧客郵便番号１");
        exStringEquals(pBean.getIwsTrkkzktsinadr1kj1(), null, "（ＩＷＳ）登録家族通信先住所１（漢字）１");
        exStringEquals(pBean.getIwsTrkkzktsinadr2kj1(), null, "（ＩＷＳ）登録家族通信先住所２（漢字）１");
        exStringEquals(pBean.getIwsTrkkzktsinadr3kj1(), null, "（ＩＷＳ）登録家族通信先住所３（漢字）１");
        exStringEquals(pBean.getIwsTrkkzktsintelno1(), null, "（ＩＷＳ）登録家族通信先電話番号１");
        exStringEquals(pBean.getIwsGyoumukousintime1(), null, "（ＩＷＳ）業務用更新時間１");

        exStringEquals(pBean.getIwsTrkkzkkbn2(), null, "（ＩＷＳ）登録家族区分２");
        exStringEquals(pBean.getIwsTrkkzkumu2(), null, "（ＩＷＳ）登録家族情報有無２");
        exStringEquals(pBean.getIwsTrkkzknmkn2(), null, "（ＩＷＳ）登録家族名（カナ）２");
        exStringEquals(pBean.getIwsTrkkzknmkj2(), null, "（ＩＷＳ）登録家族名（漢字）２");
        exStringEquals(pBean.getIwsTrkkzkseiymd2(), null, "（ＩＷＳ）登録家族生年月日２");
        exStringEquals(pBean.getIwsTrkkzksei2(), null, "（ＩＷＳ）登録家族性別２");
        exStringEquals(pBean.getIwsTrkkzkseikj2(), null, "（ＩＷＳ）登録家族性別２（区分名称）");
        exStringEquals(pBean.getIwsTrkkzktdk2(), null, "（ＩＷＳ）登録家族続柄２");
        exStringEquals(pBean.getIwsTrkkzktdkkj2(), null, "（ＩＷＳ）登録家族続柄２（区分名称）");
        exStringEquals(pBean.getIwsTrkkzktsinkokyno2(), null, "（ＩＷＳ）登録家族通信先顧客郵便番号２");
        exStringEquals(pBean.getIwsTrkkzktsinadr1kj2(), null, "（ＩＷＳ）登録家族通信先住所１（漢字）２");
        exStringEquals(pBean.getIwsTrkkzktsinadr2kj2(), null, "（ＩＷＳ）登録家族通信先住所２（漢字）２");
        exStringEquals(pBean.getIwsTrkkzktsinadr3kj2(), null, "（ＩＷＳ）登録家族通信先住所３（漢字）２");
        exStringEquals(pBean.getIwsTrkkzktsintelno2(), null, "（ＩＷＳ）登録家族通信先電話番号２");
        exStringEquals(pBean.getIwsGyoumukousintime2(), null, "（ＩＷＳ）業務用更新時間２");

    }

}
