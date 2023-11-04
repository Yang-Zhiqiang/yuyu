package yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2MockForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebZennouKeisanOutputBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ前納保険料計算のメイン処理{@link HbSeihoWebZennouKeisanImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebZennouKeisanTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebZennouKeisanImpl hbSeihoWebZennouKeisanImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ前納保険料計算";

    private final static String requestSheetName = "業務データ";

    private static Map<String, String> gyoumuInfoMap;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanZennouNyuukinGk2.class).to(KeisanZennouNyuukinGk2MockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = HbSeihoWebZennouKeisanTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = null;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = null;
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebZennouKeisanTest_execPostForm.class, fileName, requestSheetName);
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        MockObjectManager.initialize();
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A1"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);

        WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebZennouKeisanOutputBean.class);

        exStringEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpnotinc(), BizNumber.valueOf(2234567890l), "（ＩＷＳ）円貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpinclude(), BizNumber.valueOf(3234567890l), "（ＩＷＳ）円貨前納保険料（初回含む）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含む）");


        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 0), BizDate.valueOf("20161215"), "基準日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 1), BizCurrency.valueOf(1234567890), "前納時払込保険料");
        exNumericEquals((Integer)MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 2), 13, "前納期間");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 3), null, "領収通貨種類");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 4), null, "領収為替レート");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanZennouNyuukinGk2MockForSinkeiyaku.class,
            "execKeisanSinkeiyakuDoujiZennouNyuukinGk", 0, 5), null, "円換算適用為替レート");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        MockObjectManager.initialize();
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN2;

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);

        WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebZennouKeisanOutputBean.class);

        exStringEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含む）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpnotinc(), BizNumber.valueOf(4234567890123l), "（ＩＷＳ）外貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpinclude(), BizNumber.valueOf(5234567890123l), "（ＩＷＳ）外貨前納保険料（初回含む）");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        MockObjectManager.initialize();
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN3;

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);

        WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebZennouKeisanOutputBean.class);

        exStringEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含む）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含む）");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        MockObjectManager.initialize();
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);

        WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebZennouKeisanOutputBean.class);

        exStringEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含む）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含む）");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        MockObjectManager.initialize();
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A5"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);

        WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebZennouKeisanOutputBean.class);

        exStringEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含む）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含む）");

    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        MockObjectManager.initialize();
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN4;

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A6"));
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebzennoukeisan.HbSeihoWebZennouKeisan");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebZennouKeisanImpl.execPostForm(pMap);

        WsHbSeihoWebZennouKeisanOutputBean wsHbSeihoWebZennouKeisanOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebZennouKeisanOutputBean.class);

        exStringEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsYenznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）円貨前納保険料（初回含む）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpnotinc(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含まない）");
        exBizCalcbleEquals(wsHbSeihoWebZennouKeisanOutputBean.getIwsGaikaznnpinclude(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納保険料（初回含む）");

    }
}
