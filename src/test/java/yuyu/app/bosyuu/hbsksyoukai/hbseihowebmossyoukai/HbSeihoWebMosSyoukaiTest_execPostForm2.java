package yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai;

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
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutoku;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuMockForSinkeiyaku;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebMosSyoukaiOutputBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ申込状況照会のメイン処理{@link HbSeihoWebMosSyoukaiImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebMosSyoukaiTest_execPostForm2 extends AbstractTest {

    @Inject
    private HbSeihoWebMosSyoukaiImpl hbSeihoWebMosSyoukaiImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ申込状況照会";

    private final static String sheetName = "INデータ_20181224";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebMosSyoukaiTest_execPostForm2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
        bizDomManager.delete(bizDomManager.getAllKouin());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllAccessLogs());
    }

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DairitenTesuuryouInfoSyutoku.class).to(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class);
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = HbSeihoWebMosSyoukaiTest_execPostForm.class;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebMosSyoukaiTest_execPostForm2.class;
        MqApiCallerStubForSinkeiyaku.caller = HbSeihoWebMosSyoukaiTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = null;
        MqApiCallerStubForSinkeiyaku.caller = null;
        MqApiCallerStubForSinkeiyaku.SYORIPTN = null;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = null;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10010)
    @Transactional
    public void testExecPostForm_AA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000504");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000504", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), "（目標到達時円建終身保険変更特約）",
            "（ＩＷＳ）（表示用）ターゲット特約名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(10020)
    @Transactional
    public void testExecPostForm_AA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000512");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000512", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "設定なし", "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), "（目標到達時円建年金保険変更特約）",
            "（ＩＷＳ）（表示用）ターゲット特約名");
    }

    @Test
    @TestOrder(10030)
    @Transactional
    public void testExecPostForm_AA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000520");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000520", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "１３０％", "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null,
            "（ＩＷＳ）（表示用）ターゲット特約名");
    }

    @Test
    @TestOrder(10040)
    @Transactional
    public void testExecPostForm_AA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000538");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000538", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし", "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null,
            "（ＩＷＳ）（表示用）ターゲット特約名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }



    @Test
    @TestOrder(10050)
    @Transactional
    public void testExecPostForm_BB1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000520");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000520", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),"     1,000,000", "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),"     1,300,000", "（ＩＷＳ）（表示用）目標額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }


    @Test
    @TestOrder(10060)
    @Transactional
    public void testExecPostForm_BB2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000504");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000504", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),null, "（ＩＷＳ）（表示用）基準金額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }


    @Test
    @TestOrder(10070)
    @Transactional
    public void testExecPostForm_BB3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000512");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000512", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),null, "（ＩＷＳ）（表示用）基準金額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }



    @Test
    @TestOrder(10080)
    @Transactional
    public void testExecPostForm_BB4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000538");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000538", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),null, "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }


    @Test
    @TestOrder(10090)
    @Transactional
    public void testExecPostForm_BB5() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000611");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000611", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),"     1,000,000", "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(10100)
    @Transactional
    public void testExecPostForm_BB6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000603");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000603", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),"     1,000,000", "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }


    @Test
    @TestOrder(10110)
    @Transactional
    public void testExecPostForm_BB7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000637");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000637", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),null, "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(10120)
    @Transactional
    public void testExecPostForm_BB9() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000645");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000645", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),"10,000,000,000", "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),"13,000,000,000", "（ＩＷＳ）（表示用）目標額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }
    @Test
    @TestOrder(10130)
    @Transactional
    public void testExecPostForm_BB10() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000652");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000652", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnkngk(),null, "（ＩＷＳ）（表示用）基準金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhgk(),null, "（ＩＷＳ）（表示用）目標額 ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(11010)
    @Transactional
    public void testExecPostForm_AAA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000959");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "行員コード", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "0987654321", "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
    }

    @Test
    @TestOrder(11020)
    @Transactional
    public void testExecPostForm_AAA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000942");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "行員コード", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "0987654321", "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
    }

    @Test
    @TestOrder(11030)
    @Transactional
    public void testExecPostForm_AAA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000934");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1234567890", "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
    }


    @Test
    @TestOrder(11040)
    @Transactional
    public void testExecPostForm_AAA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000926");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), null, "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), null, "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
    }

    @Test
    @TestOrder(11050)
    @Transactional
    public void testExecPostForm_BBB1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000926");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "ＣＩＦコード", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "123456789012345", "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
    }


    @Test
    @TestOrder(11060)
    @Transactional
    public void testExecPostForm_BBB2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000918");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "ＣＩＦコード", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "123456789012345", "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
    }


    @Test
    @TestOrder(11070)
    @Transactional
    public void testExecPostForm_BBB3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000900");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "11111111111", "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
    }


    @Test
    @TestOrder(11080)
    @Transactional
    public void testExecPostForm_BBB4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000892");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), null, "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), null, "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
    }



    @Test
    @TestOrder(11090)
    @Transactional
    public void testExecPostForm_CCC1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000014");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
    }




    @Test
    @TestOrder(11110)
    @Transactional
    public void testExecPostForm_CCC2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000022");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), "12,345,678,900", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), "1", "（ＩＷＳ）（表示用）保険金額通貨単位区分");
    }




    @Test
    @TestOrder(11120)
    @Transactional
    public void testExecPostForm_CCC3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000030");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
    }




    @Test
    @TestOrder(11130)
    @Transactional
    public void testExecPostForm_DDD1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000926");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }




    @Test
    @TestOrder(11140)
    @Transactional
    public void testExecPostForm_DDD2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000918");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), "12,345,678,900", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), "1", "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }




    @Test
    @TestOrder(11150)
    @Transactional
    public void testExecPostForm_DDD3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000900");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }



    @Test
    @TestOrder(11160)
    @Transactional
    public void testExecPostForm_EEE1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000014");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "入金勧奨", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11170)
    @Transactional
    public void testExecPostForm_EEE2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000022");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11180)
    @Transactional
    public void testExecPostForm_EEE3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000030");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "入金勧奨", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11190)
    @Transactional
    public void testExecPostForm_EEE4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000048");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11200)
    @Transactional
    public void testExecPostForm_EEE5() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000055");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "入金勧奨", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11210)
    @Transactional
    public void testExecPostForm_EEE6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000063");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "入金勧奨", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11220)
    @Transactional
    public void testExecPostForm_EEE7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000071");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11230)
    @Transactional
    public void testExecPostForm_EEE8() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000089");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11240)
    @Transactional
    public void testExecPostForm_EEE9() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000097");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11250)
    @Transactional
    public void testExecPostForm_EEE10() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000105");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11260)
    @Transactional
    public void testExecPostForm_EEE11() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000113");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11270)
    @Transactional
    public void testExecPostForm_EEE12() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000121");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
    }


    @Test
    @TestOrder(11280)
    @Transactional
    public void testExecPostForm_EEE13() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000139");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "成立", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11290)
    @Transactional
    public void testExecPostForm_EEE14() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "970000147");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "不成立", "（ＩＷＳ）（表示用）申込状況");
    }

    @Test
    @TestOrder(11510)
    @Transactional
    public void testExecPostForm_FFF1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000010");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　「ふるはーとＪロードグローバル（第１保険期間１年）」", "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　５歳", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngkmds(), "保険金額", "（ＩＷＳ）（表示用）保険金額見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkknmds(), "年金支払開始", "（ＩＷＳ）（表示用）保険期間見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsueokikkn(), "　５年", "（ＩＷＳ）（表示用）据置期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（豪ドル）", "（ＩＷＳ）（表示用）指数名");
    }

    @Test
    @TestOrder(11520)
    @Transactional
    public void testExecPostForm_FFF2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000028");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　５年確定年金「ふるはーとＪロードグローバル」", "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), null, "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngkmds(), "基準金額", "（ＩＷＳ）（表示用）保険金額見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsueokikkn(), null, "（ＩＷＳ）（表示用）据置期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsisuunm(), null, "（ＩＷＳ）（表示用）指数名");
    }

    @Test
    @TestOrder(11530)
    @Transactional
    public void testExecPostForm_FFF3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000036");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), null, "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　終身", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkknmds(), "保険期間", "（ＩＷＳ）（表示用）保険期間見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsisuunm(), null, "（ＩＷＳ）（表示用）指数名");
    }

    @Test
    @TestOrder(11540)
    @Transactional
    public void testExecPostForm_FFF4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000044");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "９８歳", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsisuunm(), null, "（ＩＷＳ）（表示用）指数名");
    }

    @Test
    @TestOrder(11550)
    @Transactional
    public void testExecPostForm_FFF5() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000051");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsueokikkn(), null, "（ＩＷＳ）（表示用）据置期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsisuunm(), null, "（ＩＷＳ）（表示用）指数名");
    }

    @Test
    @TestOrder(11710)
    @Transactional
    public void testExecPostForm_GGG1() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000256");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeiyakuymd(), "20180403", "（ＩＷＳ）（表示用）契約年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), null, "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "指数連動プラン（保険料の指数連動部分への充当割合１００％）", "（ＩＷＳ）（表示用）積立金タイプ名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispSyksbyensitihsyutkyk(), "あり", "（ＩＷＳ）（表示用）初期死亡時円換算最低保証特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispJyudkaigomehrtkyk(), null, "（ＩＷＳ）（表示用）重度介護前払特約");
    }

    @Test
    @TestOrder(11711)
    @Transactional
    public void testExecPostForm_GGG2() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000264");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), "201603", "（ＩＷＳ）（表示用）計上年月（文字列）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "定率増加プラン（保険料の定率積立部分への充当割合１００％）", "（ＩＷＳ）（表示用）積立金タイプ名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispSyksbyensitihsyutkyk(), null, "（ＩＷＳ）（表示用）初期死亡時円換算最低保証特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispJyudkaigomehrtkyk(), "あり", "（ＩＷＳ）（表示用）重度介護前払特約");
    }

    @Test
    @TestOrder(11712)
    @Transactional
    public void testExecPostForm_GGG3() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000272");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeiyakuymd(), null, "（ＩＷＳ）（表示用）契約年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡給付金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkijyunkingakumds(), null, "（ＩＷＳ）（表示用）基準金額見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), null, "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11713)
    @Transactional
    public void testExecPostForm_GGG4() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000280");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), null, "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "保険料の指数連動部分への充当割合１００％", "（ＩＷＳ）（表示用）積立金タイプ名");
    }
    @Test
    @TestOrder(11714)
    @Transactional
    public void testExecPostForm_GGG5() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000298");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnenkinsyu(), null, "（ＩＷＳ）（表示用）年金種類");
    }

    @Test
    @TestOrder(11715)
    @Transactional
    public void testExecPostForm_GGG6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000010");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkijyunkingakumds(), "基準金額", "（ＩＷＳ）（表示用）基準金額見出し");
    }

    @Test
    @TestOrder(11716)
    @Transactional
    public void testExecPostForm_GGG7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000028");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkijyunkingakumds(), "円建基準金額", "（ＩＷＳ）（表示用）基準金額見出し");
    }

    @Test
    @TestOrder(11717)
    @Transactional
    public void testExecPostForm_GGG8() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001114");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "保険料の指数連動部分への充当割合１００％", "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11718)
    @Transactional
    public void testExecPostForm_GGG9() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001122");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "指数連動プラン（保険料の指数連動部分への充当割合１００％）", "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11719)
    @Transactional
    public void testExecPostForm_GGG10() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001130");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "保険料の指数連動部分への充当割合１００％", "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11720)
    @Transactional
    public void testExecPostForm_GGG11() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001148");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "保険料の指数連動部分への充当割合１００％", "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11721)
    @Transactional
    public void testExecPostForm_GGG12() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001155");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "定率増加プラン（保険料の定率積立部分への充当割合１００％）", "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11722)
    @Transactional
    public void testExecPostForm_GGG13() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001163");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), "定期支払プラン（保険料の定率積立部分への充当割合１００％）", "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11723)
    @Transactional
    public void testExecPostForm_GGG14() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001171");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptumitatekintypenm(), null, "（ＩＷＳ）（表示用）積立金タイプ名");
    }

    @Test
    @TestOrder(11760)
    @Transactional
    public void testExecPostForm_HHH1() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000015");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "0", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), null, "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), null, "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), null, "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), null, "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), null, "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11770)
    @Transactional
    public void testExecPostForm_HHH2() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000023");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "1", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "契約者と同じ", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), null, "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), null, "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), null, "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11780)
    @Transactional
    public void testExecPostForm_HHH3() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000031");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "1", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "被保険者と同じ", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), null, "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), null, "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), null, "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11790)
    @Transactional
    public void testExecPostForm_HHH4() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000049");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "2", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "契約者名４", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "契約者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "23", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "契約者名４", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "契約者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "24", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), null, "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), null, "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11800)
    @Transactional
    public void testExecPostForm_HHH5() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000056");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "3", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "被保険者名５", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "被保険者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "25", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "被保険者名５", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(),"被保険者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "26", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "契約者名５", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "契約者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "27", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), null, "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), null, "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), null, "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11810)
    @Transactional
    public void testExecPostForm_HHH6() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000064");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名８", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "配偶者", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "28", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名９", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(),"配偶者", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "29", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "被保険者名６", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "被保険者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "30", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "契約者名６", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "契約者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "31", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11820)
    @Transactional
    public void testExecPostForm_HHH7() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000072");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名１２", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "子", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "32", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名１３", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "子", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "33", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名１４", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "配偶者", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "34", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "被保険者名７", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "被保険者と同じ", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "35", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11830)
    @Transactional
    public void testExecPostForm_HHH8() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000080");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名１６", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "親", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "36", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名１７", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "親", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "37", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名１８", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "子", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "38", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名１９", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "配偶者", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "39", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11840)
    @Transactional
    public void testExecPostForm_HHH9() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000098");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名２０", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "孫", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "40", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名２１", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "孫", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "41", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名２２", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "親", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "42", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名２３", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "子", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "43", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11850)
    @Transactional
    public void testExecPostForm_HHH10() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000106");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名２４", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "祖父母", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "44", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名２５", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "祖父母", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "45", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名２６", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "孫", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "46", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名２７", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "親", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "47", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11860)
    @Transactional
    public void testExecPostForm_HHH11() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000114");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名２８", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "兄弟姉妹", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "48", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名２９", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "兄弟姉妹", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "49", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名３０", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "祖父母", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "50", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名３１", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "孫", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "51", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11870)
    @Transactional
    public void testExecPostForm_HHH12() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000122");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名３２", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "その他", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "52", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名３３", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "その他", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "53", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名３４", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "兄弟姉妹", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "54", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名３５", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "祖父母", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "55", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11880)
    @Transactional
    public void testExecPostForm_HHH13() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000130");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名３６", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "56", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名３７", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "57", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名３８", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "その他", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "58", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名３９", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "兄弟姉妹", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "59", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11890)
    @Transactional
    public void testExecPostForm_HHH14() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000148");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "4", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), null, "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名４０", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "60", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名４１", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "61", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名４２", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "62", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名４３", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "その他", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "63", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11900)
    @Transactional
    public void testExecPostForm_HHH15() throws Exception {

        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000155");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktdtlsuu(), "0", "（ＩＷＳ）（表示用）満期受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktmds(), "年金受取人", "（ＩＷＳ）（表示用）満期受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnin(), "5", "（ＩＷＳ）（表示用）満期受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm01(), "満期受取人名４４", "（ＩＷＳ）（表示用）満期受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk01(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari01(), "64", "（ＩＷＳ）（表示用）満期受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm02(), "満期受取人名４５", "（ＩＷＳ）（表示用）満期受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk02(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari02(), "65", "（ＩＷＳ）（表示用）満期受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm03(), "満期受取人名４６", "（ＩＷＳ）（表示用）満期受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk03(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari03(), "66", "（ＩＷＳ）（表示用）満期受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktnm04(), "満期受取人名４７", "（ＩＷＳ）（表示用）満期受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkukttdk04(), "未設定", "（ＩＷＳ）（表示用）満期受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmnkuktbnwari04(), "67", "（ＩＷＳ）（表示用）満期受取人分割割合＿０４");
    }

    @Test
    @TestOrder(11552)
    @Transactional
    public void testExecPostForm_FFF7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　第１回年金倍額型５年確定年金「ふるはーとＪロードグローバル」",
            "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngkmds(),
            "基準金額", "（ＩＷＳ）（表示用）保険金額見出し");
    }


    @Test
    @TestOrder(11910)
    @Transactional
    public void testExecPostForm_BAA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 2,000,000,000",
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), " 2,000,000,000",
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), " 2,000,000,000",
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11920)
    @Transactional
    public void testExecPostForm_BAA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000215");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "保険料",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), "20,000,000,000",
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), "20,000,000,000",
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), "20,000,000,000",
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11930)
    @Transactional
    public void testExecPostForm_BAA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null,
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11940)
    @Transactional
    public void testExecPostForm_BAA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000047");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11950)
    @Transactional
    public void testExecPostForm_BAA5() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000054");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11960)
    @Transactional
    public void testExecPostForm_BAA6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000173");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null,
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11970)
    @Transactional
    public void testExecPostForm_BAA7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000181");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null,
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11980)
    @Transactional
    public void testExecPostForm_BAA8() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000199");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), null,
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "保険料",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,000,000,000",
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11990)
    @Transactional
    public void testExecPostForm_BAA9() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000096");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null,
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11991)
    @Transactional
    public void testExecPostForm_BAA10() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000108");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), " 4,000,000,000",
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(11992)
    @Transactional
    public void testExecPostForm_BAA11() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000207");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjnnkpzeitekitk(), "あり",
            "（ＩＷＳ）（表示用）個人年金保険料税制適格特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisppmds(), "円貨払込額",
            "（ＩＷＳ）（表示用）保険料見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null,
            "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）定期一括払円貨払込額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznntikiktbriyenhrkgk(), null,
            "（ＩＷＳ）（表示用）前納定期一括払円貨払込額");
    }
    @Test
    @TestOrder(12000)
    @Transactional
    public void testExecPostForm_BBA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnenkinsyu(), "　第１回年金倍額型５年確定年金",
            "（ＩＷＳ）（表示用）年金種類");
    }

    @Test
    @TestOrder(12010)
    @Transactional
    public void testExecPostForm_BBA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000021");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnenkinsyu(), "　　　　定額年金型５年確定年金",
            "（ＩＷＳ）（表示用）年金種類");
    }

    @Test
    @TestOrder(12020)
    @Transactional
    public void testExecPostForm_BBA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000028");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnenkinsyu(), "　　　　　　　　　５年確定年金",
            "（ＩＷＳ）（表示用）年金種類");
    }

    @Test
    @TestOrder(12021)
    @Transactional
    public void testExecPostForm_BBA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000280");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnenkinsyu(), null,
            "（ＩＷＳ）（表示用）年金種類");
    }

    @Test
    @TestOrder(12030)
    @Transactional
    public void testExecPostForm_BCA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料円貨払込特約（円貨払込額指定型））", "（ＩＷＳ）（表示用）払込特約名");
    }

    @Test
    @TestOrder(12040)
    @Transactional
    public void testExecPostForm_BCA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000088");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料円貨払込特約）", "（ＩＷＳ）（表示用）払込特約名");
    }

    @Test
    @TestOrder(12050)
    @Transactional
    public void testExecPostForm_BCA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000021");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料指定外通貨払込特約）", "（ＩＷＳ）（表示用）払込特約名");
    }

    @Test
    @TestOrder(12060)
    @Transactional
    public void testExecPostForm_BCA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            null, "（ＩＷＳ）（表示用）払込特約名");
    }

    @Test
    @TestOrder(12070)
    @Transactional
    public void testExecPostForm_BDA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(),
            "　一時払", "（ＩＷＳ）（表示用）払込期間");
    }

    @Test
    @TestOrder(12080)
    @Transactional
    public void testExecPostForm_BDA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000021");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(),
            "　９９歳", "（ＩＷＳ）（表示用）払込期間");
    }

    @Test
    @TestOrder(12090)
    @Transactional
    public void testExecPostForm_BDA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(),
            "　２０年", "（ＩＷＳ）（表示用）払込期間");
    }

    @Test
    @TestOrder(12100)
    @Transactional
    public void testExecPostForm_BEA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(),
            " 1,000,000,000", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(),
            "1", "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(),
            " 1,000,000,000", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(),
            "1", "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12110)
    @Transactional
    public void testExecPostForm_BEA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000021");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(),
            "20,000,000,000", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(),
            "1", "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(),
            "20,000,000,000", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(),
            "1", "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12120)
    @Transactional
    public void testExecPostForm_BEA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000088");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12130)
    @Transactional
    public void testExecPostForm_BEA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12140)
    @Transactional
    public void testExecPostForm_BEA5() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000047");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12141)
    @Transactional
    public void testExecPostForm_BEA6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000116");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(),
            null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(),
            null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(),
            null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(),
            null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12142)
    @Transactional
    public void testExecPostForm_BEA7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000124");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(),
            "     10,000.00", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(),
            "4", "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(),
            "     10,000.00", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(),
            "4", "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12143)
    @Transactional
    public void testExecPostForm_BEA8() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000025");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), "       300,000", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), "1", "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), "       400,000", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), "1", "（ＩＷＳ）（表示用）保険料通貨単位区分");
    }

    @Test
    @TestOrder(12150)
    @Transactional
    public void testExecPostForm_BFA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000013");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkeiro(),
            "口座振替（ＣＳＳ）", "（ＩＷＳ）（表示用）払込経路");
    }

    @Test
    @TestOrder(12170)
    @Transactional
    public void testExecPostForm_BFA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkeiro(),
            "口座振替", "（ＩＷＳ）（表示用）払込経路");
    }

    @Test
    @TestOrder(12180)
    @Transactional
    public void testExecPostForm_BFA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000047");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkeiro(), "団体", "（ＩＷＳ）（表示用）払込経路");
    }
    @Test
    @TestOrder(12191)
    @Transactional
    public void testExecPostForm_BFA6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000120");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkeiro(),
            null, "（ＩＷＳ）（表示用）払込経路");
    }

    @Test
    @TestOrder(12200)
    @Transactional
    public void testExecPostForm_BGA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(),
            "前納定期一括払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispiktkaisuu(),
            "12", "（ＩＷＳ）（表示用）一括回数");
    }

    @Test
    @TestOrder(12210)
    @Transactional
    public void testExecPostForm_BGA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000047");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(),
            "１２か月定期一括払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispiktkaisuu(),
            "12", "（ＩＷＳ）（表示用）一括回数");
    }

    @Test
    @TestOrder(12220)
    @Transactional
    public void testExecPostForm_BGA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000054");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(),
            "２か月定期一括払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispiktkaisuu(),
            "2", "（ＩＷＳ）（表示用）一括回数");
    }

    @Test
    @TestOrder(12230)
    @Transactional
    public void testExecPostForm_BGA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000062");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), "月払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispiktkaisuu(), null, "（ＩＷＳ）（表示用）一括回数");
    }

    @Test
    @TestOrder(12240)
    @Transactional
    public void testExecPostForm_BHA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000021");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), "99", "（ＩＷＳ）（表示用）前納回数");
    }

    @Test
    @TestOrder(12250)
    @Transactional
    public void testExecPostForm_BHA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000039");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), "99", "（ＩＷＳ）（表示用）前納回数");
    }

    @Test
    @TestOrder(12260)
    @Transactional
    public void testExecPostForm_BHA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000047");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), "98", "（ＩＷＳ）（表示用）前納回数");
    }

    @Test
    @TestOrder(12270)
    @Transactional
    public void testExecPostForm_BHA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000054");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
    }

    @Test
    @TestOrder(12280)
    @Transactional
    public void testExecPostForm_BIA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000512");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(),
            "設定なし", "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
    }

    @Test
    @TestOrder(12290)
    @Transactional
    public void testExecPostForm_BIA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000520");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(),
            "１３０％", "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
    }

    @Test
    @TestOrder(12300)
    @Transactional
    public void testExecPostForm_BIA3() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000538");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(),
            "申込なし", "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
    }

    @Test
    @TestOrder(12310)
    @Transactional
    public void testExecPostForm_BIA4() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "870000031");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(),
            null, "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
    }

    @Test
    @TestOrder(11553)
    @Transactional
    public void testExecPostForm_FFF8() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000140");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１Ⅱ型", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　「ふるはーとＪロードグローバル（第１保険期間１年）」",
            "（ＩＷＳ）（表示用）保険名称＿０２");

    }

    @Test
    @TestOrder(11554)
    @Transactional
    public void testExecPostForm_FFF9() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20180508));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000077");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１Ⅰ型", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　「ふるはーとＪロードグローバル（第１保険期間１年）」",
            "（ＩＷＳ）（表示用）保険名称＿０２");

    }

    @Test
    @TestOrder(11555)
    @Transactional
    public void testExecPostForm_FFF10() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000085");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), "顧客用保険種類名１", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　「ふるはーとＪロードグローバル」", "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngkmds(), "基準金額", "（ＩＷＳ）（表示用）保険金額見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokensyuruino(), "326", "（ＩＷＳ）（表示用）保険種類番号");
    }

    @Test
    @TestOrder(11556)
    @Transactional
    public void testExecPostForm_FFF11() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000093");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokensyuruino(), "444", "（ＩＷＳ）（表示用）保険種類番号");
    }

    @Test
    @TestOrder(11557)
    @Transactional
    public void testExecPostForm_FFF12() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "990000101");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokensyuruino(), "444", "（ＩＷＳ）（表示用）保険種類番号");
    }

    @Test
    @TestOrder(11558)
    @Transactional
    public void testExecPostForm_FFF13() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000017");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), "　「ふるはーとＪロードグローバル」", "（ＩＷＳ）（表示用）保険名称＿０２");
    }

    @Test
    @TestOrder(12061)
    @Transactional
    public void testExecPostForm_BCA5() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000132");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料円貨払込特約（一時払い））", "（ＩＷＳ）（表示用）払込特約名");
    }

    @Test
    @TestOrder(12062)
    @Transactional
    public void testExecPostForm_BCA6() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000104");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料円貨払込特約（一時払い））", "（ＩＷＳ）（表示用）払込特約名");
    }

    @Test
    @TestOrder(12063)
    @Transactional
    public void testExecPostForm_BCA7() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "880000112");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料円貨払込特約（一時払い））", "（ＩＷＳ）（表示用）払込特約名");
    }
    @Test
    @TestOrder(12064)
    @Transactional
    public void testExecPostForm_BCA8() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000033");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktkyknm(),
            "（保険料円貨払込特約（円貨払込額変動型））", "（ＩＷＳ）（表示用）払込特約名");
    }
    @Test
    @TestOrder(12071)
    @Transactional
    public void testExecPostForm_BJA1() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000017");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbnmidasi(),
            "選択通貨", "（ＩＷＳ）（表示用）契約通貨単位区分見出し");
    }
    @Test
    @TestOrder(12072)
    @Transactional
    public void testExecPostForm_BJA2() throws Exception {

        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000025");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbnmidasi(),
            "指定通貨", "（ＩＷＳ）（表示用）契約通貨単位区分見出し");
    }
}
