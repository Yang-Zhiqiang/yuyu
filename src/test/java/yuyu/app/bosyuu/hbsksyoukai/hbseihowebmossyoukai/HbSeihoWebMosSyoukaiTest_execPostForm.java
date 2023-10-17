package yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai;

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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutoku;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.DairitenTsrSyutokuYokenBean;
import yuyu.common.biz.bzdairiten.KeijouYmSyutokuYokenBean;
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
public class HbSeihoWebMosSyoukaiTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebMosSyoukaiImpl hbSeihoWebMosSyoukaiImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ申込状況照会";

    private final static String sheetName = "INデータ";

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
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebMosSyoukaiTest_execPostForm.class, fileName,
                sheetName);
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

    @BeforeClass
    public static void testInit() {
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = HbSeihoWebMosSyoukaiTest_execPostForm.class;
        MqApiCallerStubForSinkeiyaku.caller = HbSeihoWebMosSyoukaiTest_execPostForm.class;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebMosSyoukaiTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = null;
        MqApiCallerStubForSinkeiyaku.caller = null;
        MqApiCallerStubForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(1020)
    public void testExecPostForm_A2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "86A000017");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(),
            "誤った申込番号が入力されています。正しい申込番号を確認のうえ、再度照会願います。",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(2010)
    @Transactional
    public void testExecPostForm_B1() throws Exception {

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000017", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "03", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "該当契約がありません。住友生命あて照会願います。",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(2020)
    @Transactional
    public void testExecPostForm_B2() throws Exception {

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000025", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "05", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "該当契約がありません。住友生命あて照会願います。",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(2030)
    @Transactional
    public void testExecPostForm_B3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000025");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "7380000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000025", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "01", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "参照権限がありません。住友生命あて照会願います。",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(2040)
    @Transactional
    public void testExecPostForm_B4() throws Exception {

        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860002005");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860002005", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "04", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "選択されたお申込みは、窓販契約ではありませんので、ご照会できません。",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(3010)
    @Transactional
    public void testExecPostForm_C1() throws Exception {

        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000033", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), "作成中", "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), "20160624", "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), "20160628",
            "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "完了", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), "あり", "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), null, "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), null, "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), null, "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), null, "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3020)
    @Transactional
    public void testExecPostForm_C2() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000041");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000041", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), "作成済", "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), "20160623", "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), "20160627",
            "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "契約者と同じ", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), "あり", "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), null, "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), null, "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), null, "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), null, "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3030)
    @Transactional
    public void testExecPostForm_C3() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000058");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000058", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), "作成済", "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), "20160622", "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), "20160624",
            "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), "1780600000013",
            "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "指定意思なし", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), "あり", "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), "登録家族２人目と同じ", "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "配偶者", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "女性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "親", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3040)
    @Transactional
    public void testExecPostForm_C4() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000066");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000066", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "行員コード", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "12345671780600000057",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), "1780600000013",
            "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "死亡保険金受取人と同じ", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), "あり", "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), "登録家族１人目と同じ", "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆｷ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "女性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "子", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆｸ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "配偶者", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3050)
    @Transactional
    public void testExecPostForm_C5() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000074");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000074", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), "1780600000013",
            "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "被保険者の配偶者", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ｶﾞｽﾞﾊﾞｼﾞﾊﾟｶﾞｽﾞﾊﾞｼﾞ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), null, "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "孫", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ｶﾞｽﾞﾊﾞｼﾞﾊﾟｶﾞｽﾞﾊﾞﾊﾞ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), null, "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "子", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3060)
    @Transactional
    public void testExecPostForm_C6() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000082");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000082", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "３親等の親族", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳﾒｽﾞｽﾞｽﾞ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "175-0082", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "通信先住所１０６通信先住所２０６", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "通信先住所３０６", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "兄弟姉妹", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳﾒﾊﾞﾊﾞﾊﾞ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "孫", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3070)
    @Transactional
    public void testExecPostForm_C7() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000090");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000090", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "配偶者", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "175-0082", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "通信先住所１０７通信先住所２０７", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "通信先住所３０７", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "３親等の親族", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "175-0082", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "通信先住所１０７通信先住所２０７", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "通信先住所３０７", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "兄弟姉妹", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3080)
    @Transactional
    public void testExecPostForm_C8() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000108", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "子", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "祖父母", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "175-0082", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "通信先住所１０８通信先住所２０８", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "通信先住所３０８", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "３親等の親族", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3090)
    @Transactional
    public void testExecPostForm_C9() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000116", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "親", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "その他", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "祖父母", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3100)
    @Transactional
    public void testExecPostForm_C10() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000124", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "孫", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "親", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "その他", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3110)
    @Transactional
    public void testExecPostForm_C11() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000132", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "祖父母", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3120)
    @Transactional
    public void testExecPostForm_C12() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000140", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "兄弟姉妹", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), "20200115", "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), "あり", "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), null, "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), null, "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), null, "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), null, "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), null, "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsioriyakkansearchcd(), "1234567", "（ＩＷＳ）（表示用）しおり約款検索コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyakkanjyuryouhou(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳ）（表示用）約款受領方法");
    }

    @Test
    @TestOrder(3130)
    @Transactional
    public void testExecPostForm_C13() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000157");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000157", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "その他", "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3140)
    @Transactional
    public void testExecPostForm_C14() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000165");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000165", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3150)
    @Transactional
    public void testExecPostForm_C15() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000173", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3160)
    @Transactional
    public void testExecPostForm_C16() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000181", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "未査定", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3170)
    @Transactional
    public void testExecPostForm_C17() throws Exception {

        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000991");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000991", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "01", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "参照権限がありません。住友生命あて照会願います。",
            "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(3180)
    @Transactional
    public void testExecPostForm_C18() throws Exception {

        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000033", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), "作成中", "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), "20160624", "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), "20160628",
            "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "完了", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3190)
    @Transactional
    public void testExecPostForm_C19() throws Exception {

        changeSystemDate(BizDate.valueOf(20160627));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000983");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000983", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), "作成済", "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), "20160622", "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), "20160624",
            "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "横浜代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), null, "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), null, "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), null, "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "指定意思なし", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3200)
    @Transactional
    public void testExecPostForm_C20() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000967");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000967", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "横浜代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "行員コード", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "12345671780600000057",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), "大手庁代理店", "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), "1780600000013",
            "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "死亡保険金受取人と同じ", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3210)
    @Transactional
    public void testExecPostForm_C21() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000975");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000975", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "東京代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), "東京代理店", "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), "1780600000013",
            "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "被保険者の配偶者", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
    }

    @Test
    @TestOrder(3220)
    @Transactional
    public void testExecPostForm_C22() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001007");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860001007", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "死亡給付金受取人と同じ", "（ＩＷＳ）（表示用）指定代理請求人名");
    }

    @Test
    @TestOrder(3230)
    @Transactional
    public void testExecPostForm_C23() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001015");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860001015", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
    }

    @Test
    @TestOrder(3240)
    @Transactional
    public void testExecPostForm_C24() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001023");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860001023", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "被保険者代理特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), null, "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), null, "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "配偶者", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
    }

    @Test
    @TestOrder(3250)
    @Transactional
    public void testExecPostForm_C25() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001031");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860001031", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "配偶者", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), null, "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), null, "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０２");
    }

    @Test
    @TestOrder(3260)
    @Transactional
    public void testExecPostForm_C26() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001049");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860001049", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "登録家族１人目と同じ", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "被保険者代理特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), "１人目", "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), "ユ受名　三二き", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), "20200101", "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), "100-1000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), "住所１１住所１１住所１２住所１２", "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), "住所１３住所１３", "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), "011-1111-1111", "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), "配偶者", "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), null, "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), null, "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０２");
    }

    @Test
    @TestOrder(3270)
    @Transactional
    public void testExecPostForm_C27() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001056");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860001056", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "登録家族２人目と同じ", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkymds(), "指定代理請求特約", "（ＩＷＳ）（表示用）指定代理請求特約見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrskseiymd(), null, "（ＩＷＳ）（表示用）指定代理請求人生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtky(), null, "（ＩＷＳ）（表示用）保険契約者代理特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykdrtkynm(), null, "（ＩＷＳ）（表示用）保険契約者代理人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkzktrkservice(), "申し込みあり", "（ＩＷＳ）（表示用）ご家族登録サービス");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk01(), null, "（ＩＷＳ）（表示用）登録家族＿０１）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm01(), null, "（ＩＷＳ）（表示用）登録家族カナ氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm01(), null, "（ＩＷＳ）（表示用）登録家族漢字氏名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd01(), null, "（ＩＷＳ）（表示用）登録家族生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei01(), null, "（ＩＷＳ）（表示用）登録家族性別＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno01(), null, "（ＩＷＳ）（表示用）登録家族郵便番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x01(), null, "（ＩＷＳ）（表示用）登録家族住所１＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x01(), null, "（ＩＷＳ）（表示用）登録家族住所２＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno01(), null, "（ＩＷＳ）（表示用）登録家族電話番号＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk01(), null, "（ＩＷＳ）（表示用）登録家族続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzk02(), "２人目", "（ＩＷＳ）（表示用）登録家族＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkknnm02(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳ）（表示用）登録家族カナ氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkkjnm02(), "ユ受名　三二く", "（ＩＷＳ）（表示用）登録家族漢字氏名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkseiymd02(), "20200202", "（ＩＷＳ）（表示用）登録家族生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzksei02(), "男性", "（ＩＷＳ）（表示用）登録家族性別＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkyno02(), "200-2000", "（ＩＷＳ）（表示用）登録家族郵便番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr1x02(), "住所２１住所２１住所２２住所２２", "（ＩＷＳ）（表示用）登録家族住所１＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzkadr2x02(), "住所２３住所２３", "（ＩＷＳ）（表示用）登録家族住所２＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktelno02(), "022-2222-2222", "（ＩＷＳ）（表示用）登録家族電話番号＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptrkkzktdk02(), "配偶者", "（ＩＷＳ）（表示用）登録家族続柄＿０２");
    }

    @Test
    @TestOrder(4010)
    @Transactional
    public void testExecPostForm_D1() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160910));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000199", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｶﾅﾒｲ1", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "被保険者名１　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), "19160101", "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), "99", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ1", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名１　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), "19160101", "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), "99", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "　９月１０日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exStringEquals(keijouYmSyutokuYokenBean.getTratkiagCd(), "2101001", "取扱代理店コード");
        exStringEquals(keijouYmSyutokuYokenBean.getSyouhnCd(), "ｱ2", "商品コード");
        exDateEquals(keijouYmSyutokuYokenBean.getKokutiymd(), BizDate.valueOf("20160701"), "告知年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd(), BizDate.valueOf("20160702"), "初回Ｐ領収年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getMosYmd(), BizDate.valueOf("20160703"), "申込年月日");
        exStringEquals(keijouYmSyutokuYokenBean.getMosSyoumetuKbn(), "1", "申込消滅区分");
        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), BizDate.valueOf("20160630"), "申込消滅確定年月日");
        exDateYMEquals(keijouYmSyutokuYokenBean.getBosyuuYm(), BizDateYM.valueOf("201607"), "募集年月");
    }

    @Test
    @TestOrder(4020)
    @Transactional
    public void testExecPostForm_D2() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20161011));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN2;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000207", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｹﾔｸｶﾅ2", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "契約者名２　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), "19170202", "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), "99", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ2", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名２　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), "20070202", "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), " 9", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "１０月１１日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exStringEquals(keijouYmSyutokuYokenBean.getTratkiagCd(), "2101002", "取扱代理店コード");
        exStringEquals(keijouYmSyutokuYokenBean.getSyouhnCd(), "ｱ2", "商品コード");
        exDateEquals(keijouYmSyutokuYokenBean.getKokutiymd(), BizDate.valueOf("20160701"), "告知年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd(), BizDate.valueOf("20160702"), "初回Ｐ領収年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getMosYmd(), BizDate.valueOf("20160703"), "申込年月日");
        exStringEquals(keijouYmSyutokuYokenBean.getMosSyoumetuKbn(), "2", "申込消滅区分");
        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), BizDate.valueOf("20160630"), "申込消滅確定年月日");
        exDateYMEquals(keijouYmSyutokuYokenBean.getBosyuuYm(), BizDateYM.valueOf("201607"), "募集年月");
    }

    @Test
    @TestOrder(4030)
    @Transactional
    public void testExecPostForm_D3() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20161109));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000215", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｹﾔｸｶﾅ3", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "契約者名３　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), "20080303", "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), " 8", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ3", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名３　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), "19180303", "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), "98", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "１１月　９日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exStringEquals(keijouYmSyutokuYokenBean.getTratkiagCd(), "2101003", "取扱代理店コード");
        exStringEquals(keijouYmSyutokuYokenBean.getSyouhnCd(), "ｱ2", "商品コード");
        exDateEquals(keijouYmSyutokuYokenBean.getKokutiymd(), null, "告知年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd(), BizDate.valueOf("20160702"), "初回Ｐ領収年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getMosYmd(), BizDate.valueOf("20160703"), "申込年月日");
        exStringEquals(keijouYmSyutokuYokenBean.getMosSyoumetuKbn(), "3", "申込消滅区分");
        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), BizDate.valueOf("20160630"), "申込消滅確定年月日");
        exDateYMEquals(keijouYmSyutokuYokenBean.getBosyuuYm(), BizDateYM.valueOf("201607"), "募集年月");
    }

    @Test
    @TestOrder(4040)
    @Transactional
    public void testExecPostForm_D4() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20160102));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000223");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000223", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｹﾔｸｶﾅ4", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "契約者名４　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), "19180404", "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), "98", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ4", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名４　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), "19170404", "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), "99", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "　１月　２日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exStringEquals(keijouYmSyutokuYokenBean.getTratkiagCd(), "2101004", "取扱代理店コード");
        exStringEquals(keijouYmSyutokuYokenBean.getSyouhnCd(), "ｱ2", "商品コード");
        exDateEquals(keijouYmSyutokuYokenBean.getKokutiymd(), BizDate.valueOf("20160703"), "告知年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd(), BizDate.valueOf("20160702"), "初回Ｐ領収年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getMosYmd(), BizDate.valueOf("20160703"), "申込年月日");
        exStringEquals(keijouYmSyutokuYokenBean.getMosSyoumetuKbn(), "4", "申込消滅区分");
        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), BizDate.valueOf("20160630"), "申込消滅確定年月日");
        exDateYMEquals(keijouYmSyutokuYokenBean.getBosyuuYm(), BizDateYM.valueOf("201607"), "募集年月");
    }

    @Test
    @TestOrder(4050)
    @Transactional
    public void testExecPostForm_D5() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20161010));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000231");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000231", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｹﾔｸｶﾅ5", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "契約者名５　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), "20150505", "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), " 1", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ5", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名５　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), "20060505", "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), "10", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkshrtkyk(), null, "（ＩＷＳ）（表示用）年金支払特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "１０月１０日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exStringEquals(keijouYmSyutokuYokenBean.getTratkiagCd(), "2101005", "取扱代理店コード");
        exStringEquals(keijouYmSyutokuYokenBean.getSyouhnCd(), "ｲ1", "商品コード");
        exDateEquals(keijouYmSyutokuYokenBean.getKokutiymd(), BizDate.valueOf("20160701"), "告知年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd(), BizDate.valueOf("20160702"), "初回Ｐ領収年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getMosYmd(), BizDate.valueOf("20160703"), "申込年月日");
        exStringEquals(keijouYmSyutokuYokenBean.getMosSyoumetuKbn(), "5", "申込消滅区分");
        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), BizDate.valueOf("20160630"), "申込消滅確定年月日");
        exDateYMEquals(keijouYmSyutokuYokenBean.getBosyuuYm(), BizDateYM.valueOf("201607"), "募集年月");
    }

    @Test
    @TestOrder(4060)
    @Transactional
    public void testExecPostForm_D6() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20161231));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000249");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000249", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｹﾔｸｶﾅ6", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "契約者名６　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), null, "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), "11", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ6", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名６　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), null, "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), " 2", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkshrtkyk(), null, "（ＩＷＳ）（表示用）年金支払特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "１２月３１日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exStringEquals(keijouYmSyutokuYokenBean.getTratkiagCd(), "2101006", "取扱代理店コード");
        exStringEquals(keijouYmSyutokuYokenBean.getSyouhnCd(), "ｱ1", "商品コード");
        exDateEquals(keijouYmSyutokuYokenBean.getKokutiymd(), null, "告知年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getSyokaiPRyosyuuYmd(), BizDate.valueOf("20160702"), "初回Ｐ領収年月日");
        exDateEquals(keijouYmSyutokuYokenBean.getMosYmd(), BizDate.valueOf("20160703"), "申込年月日");
        exStringEquals(keijouYmSyutokuYokenBean.getMosSyoumetuKbn(), "0", "申込消滅区分");
        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), null, "申込消滅確定年月日");
        exDateYMEquals(keijouYmSyutokuYokenBean.getBosyuuYm(), BizDateYM.valueOf("201607"), "募集年月");
    }

    @Test
    @TestOrder(4070)
    @Transactional
    public void testExecPostForm_D7() throws Exception {
        MockObjectManager.initialize();
        changeSystemDate(BizDate.valueOf(20161231));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "861110005");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "861110005", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｹﾔｸｶﾅ6", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "契約者名６　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), null, "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), "11", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲ6", "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名６　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), null, "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), " 2", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkshrtkyk(), null, "（ＩＷＳ）（表示用）年金支払特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "１２月３１日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 0);
        assertNull(dairitenTsrSyutokuYokenBean);

        KeijouYmSyutokuYokenBean keijouYmSyutokuYokenBean = (KeijouYmSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutoku.class, "exec", 0, 1);

        exDateEquals(keijouYmSyutokuYokenBean.getMosSyumtKktYmd(), null, "申込消滅確定年月日");

    }

    @Test
    @TestOrder(5010)
    @Transactional
    public void testExecPostForm_E1() throws Exception {

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000256", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "17806000253",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "男性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "被保険者本人", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "成立", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), "20160702", "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), "告知書扱", "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), "20160601", "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "未入金", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "0", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), null, "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), "一時払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), "あり", "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), "加入（新規）",
            "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　終身", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　一時払", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "１１０％",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), "1",
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), "定期受取金支払通貨",
            "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "4", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null, "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "1", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), "（目標到達時円建終身保険変更特約）",
            "（ＩＷＳ）（表示用）ターゲット特約名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "0", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5020)
    @Transactional
    public void testExecPostForm_E2() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000264", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "ＣＩＦコード", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "178080002591001",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "女性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "被保険者本人", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "女性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "不成立", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), "告知書扱", "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "1", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), "20160401", "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "1", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), "             9", "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "1", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "契約者と同じ", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), "月払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), null, "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), "加入（新規）",
            "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "９８歳", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "１２０％",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "0", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), "4",
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), "定期受取金支払通貨",
            "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "3", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), "11,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "4", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), "（目標到達時円建年金保険変更特約）",
            "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "0", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5030)
    @Transactional
    public void testExecPostForm_E3() throws Exception {

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000272", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), null, "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), null, "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "被保険者本人", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), null, "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "入金勧奨", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), null, "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金額が過剰です", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "2", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), "123,456,780.02", "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), "20160402", "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), "20160403", "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "2", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), "            10", "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), "             8", "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "2", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名２", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19860202", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "子", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "21", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名３", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19860303", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "配偶者", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "22", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), "年２回払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), null, "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "１３０％",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "2",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), "0", "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "1", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "1", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5040)
    @Transactional
    public void testExecPostForm_E4() throws Exception {

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000280", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), null, "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), null, "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "男性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "配偶者", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), null, "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), "無告知", "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金額が不足です", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "3", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), " 12,345,670.03", "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), "20160404", "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), "223,456,780.02", "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), "20160405", "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), "20160406", "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "3", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), "        100.00", "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), "            11", "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), "             7", "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "3", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名４", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19860404", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "親", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "23", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名５", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19860505", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "子", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "24", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名６", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19860606", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "配偶者", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "25", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), "年１回払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 12,023,034.04", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "3",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), "2",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "2", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), "0", "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "2", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "2", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5050)
    @Transactional
    public void testExecPostForm_E5() throws Exception {

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000298", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "ＣＩＦコード", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "178080002591002",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "女性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "親", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "一括入金が必要です", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "4", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), "  1,234,560.04", "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), "20160407", "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), " 22,345,670.03", "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), "20160408", "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), "323,456,780.02", "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), "20160409", "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), "20160410", "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "4", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), " 10,010,020.03", "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), " 20,010,020.03", "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), " 3,001,002,003", "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), " 4,001,002,003", "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名７", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19860707", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "孫", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "26", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名８", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19860808", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "親", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "27", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名９", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19860909", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "子", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "28", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名１０", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19861010", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "配偶者", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "29", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "4",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), "3",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), "2",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "3", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), "2", "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), "0", "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "1", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "3", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "0", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5060)
    @Transactional
    public void testExecPostForm_E6() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000306");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000306", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), null, "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), null, "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "子", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "4", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), "             1", "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), "20160411", "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), "          2.00", "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), "20160412", "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), " 32,345,670.03", "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), "20160413", "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), "423,456,780.02", "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), "20160414", "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "4", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), "101,002,003.00", "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), "201,002,003.00", "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), "301,002,003.00", "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), "40,100,200,300", "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), "未精算", "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "0", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), "5", "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名１１", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19861111", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "祖父母", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "30", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名１２", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19861212", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "孫", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "31", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名１３", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19870101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "親", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "32", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名１４", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19870202", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "子", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "33", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "0",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), "4",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), "3",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), "2",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "4", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), "3", "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), "2", "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5070)
    @Transactional
    public void testExecPostForm_E7() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000314");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000314", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), null, "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), null, "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "祖父母", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "一括入金が必要です", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "4", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), "           101", "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), "         2,101", "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), "     30,101.00", "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), " 42,345,670.03", "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "4", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名１６", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19870404", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "35", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名１７", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19870505", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "祖父母", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "36", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名１８", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19870606", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "孫", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "37", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名１９", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19870707", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "親", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "38", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), "0",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), "4",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), "3",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "2", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), "4", "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), "3", "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), "2", "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5080)
    @Transactional
    public void testExecPostForm_E8() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000322");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000322", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "17806000264",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "男性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "兄弟姉妹", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名２０", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19870808", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "その他", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "39", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名２１", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19870909", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "40", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名２２", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19871010", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "祖父母", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "41", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名２３", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19871111", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "孫", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "42", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5090)
    @Transactional
    public void testExecPostForm_E9() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000330");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000330", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "17806000275",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "女性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "孫", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名２４", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19871212", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "43", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名２５", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19880101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "その他", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "44", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名２６", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19880202", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "45", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名２７", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19880303", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "祖父母", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "46", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5100)
    @Transactional
    public void testExecPostForm_E10() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000348");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000348", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "17806000286",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "その他", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名２８", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19880404", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "47", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名２９", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19880505", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "48", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名３０", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19880606", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "その他", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "49", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名３１", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19880707", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "50", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5110)
    @Transactional
    public void testExecPostForm_E11() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000355");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000355", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "17806000297",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "未設定", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名３２", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19880808", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "51", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名３３", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19880909", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "52", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名３４", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19881010", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "53", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名３５", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19881111", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "その他", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "54", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5120)
    @Transactional
    public void testExecPostForm_E12() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000363");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000363", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "受付管理ＩＤ", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "17806000301",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "未設定", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "入金あり", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "契約者名１８", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "20150101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "契約者と同じ", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "55", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "契約者名１８", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "20150101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "契約者と同じ", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "56", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "契約者名１８", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "20150101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "契約者と同じ", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "57", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "契約者名１８", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "20150101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "契約者と同じ", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "58", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), " 1,202,303,404", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　１年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), " 1,220,330,440", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), " 1,220,330,440", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "1", "（ＩＷＳ）（表示用）入金済表示");
    }

    @Test
    @TestOrder(5130)
    @Transactional
    public void testExecPostForm_E13() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

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

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "990000010", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "4", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名３６", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "配偶者", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "55", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名３７", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "その他", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "56", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名３８", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "57", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名３９", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "未設定", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "58", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
    }

    @Test
    @TestOrder(6010)
    @Transactional
    public void testExecPostForm_F1() throws Exception {

        changeSystemDate(BizDate.valueOf(20160628));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000371");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000371", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "　６月２８日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosjksyoukaimosno(), "860000371", "（ＩＷＳ）申込状況照会申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsSksyono(), "17806000013", "（ＩＷＳ）（新契約）証券番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店",
            "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名５漢字募集人名５漢", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "行員コード", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "12345671780600000057",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店",
            "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), "漢字募集人名５漢字募集人名５漢",
            "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), "1780600000013",
            "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), "ＣＩＦコード", "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), "178080002591007",
            "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsekno(), "17806000301", "（ＩＷＳ）（表示用）設計書番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispykkigenymd(), "20160704", "（ＩＷＳ）（表示用）有効期限日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(),
            "商業保険商業保険商業保険商業保険商業保険商業保険商業保険商業保険商業保険商業保険", "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), null, "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), "ｶﾅﾒｲｷﾞ2ｶﾅﾒｲｷﾞ2ｶﾅﾒｲ", "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "被保険者名被保険者名被保険者名　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), "18900704", "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), "99", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), "男性", "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "被保険者本人", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktelno(), "010-1234-5678", "（ＩＷＳ）（表示用）契約者電話番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykyno(), "138-0001", "（ＩＷＳ）（表示用）契約者郵便番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykadr01(),
            "通信先住所１通信先住所１通信先住所１通信先住所１通信先住所１通信先住所２通信先住所２通信先住所２通信先住所２通信先住所２", "（ＩＷＳ）（表示用）契約者住所＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykadr02(), "通信先住所３通信先住所３通信先住所３通信先住所３通信先住所３",
            "（ＩＷＳ）（表示用）契約者住所＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), "ｶﾅﾒｲｷﾞ2ｶﾅﾒｲｷﾞ2ｶﾅﾒｲ",
            "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "被保険者名被保険者名被保険者名　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), "18900704", "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), "99", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), "男性", "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknyno(), "126-0002", "（ＩＷＳ）（表示用）被保険者郵便番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknadr01(),
            "被保険者住所１被保険者住所１被保険者住所１被保険者住所１被保被保険者住所２被保険者住所２被保険者住所２被保険者住所２被保", "（ＩＷＳ）（表示用）被保険者住所＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknadr02(), "被保険者住所３被保険者住所３被保険者住所３被保険者住所３被保",
            "（ＩＷＳ）（表示用）被保険者住所＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "成立", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), "不備解消手続き中", "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosymd(), "20160703", "（ＩＷＳ）（表示用）申込年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), "20160714", "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), "告知書扱", "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeiyakuymd(), "20160531", "（ＩＷＳ）（表示用）契約年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), "20160624", "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), "201603", "（ＩＷＳ）（表示用）計上年月（文字列）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), "作成済", "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), "20160624", "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), "20160628",
            "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), "一括入金が必要です", "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "4", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), "10,201,301,401", "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), "20160420", "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), "20,201,301,401", "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), "20160421", "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), "30,201,301,401", "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), "20160422", "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), "40,201,301,401", "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), "20160423", "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "4", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), "10,012,001,301", "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), "20,012,001,301", "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), "30,012,001,301", "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), "40,012,001,301", "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), "精算済", "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispiktkaisuu(), "0", "（ＩＷＳ）（表示用）一括回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "査定中", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsatehaiinfokbn(), null, "（ＩＷＳ）（表示用）診査手配情報区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakuukeno(), null, "（ＩＷＳ）（表示用）予約受付番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakutehaijk(), null, "（ＩＷＳ）（表示用）予約手配状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakusinsahouhou(), null, "（ＩＷＳ）（表示用）予約診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakusindenzu(), null, "（ＩＷＳ）（表示用）予約心電図");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakuketuekikensa(), null, "（ＩＷＳ）（表示用）予約血液検査");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kiboumd(), null, "（ＩＷＳ）（表示用）予約第１希望月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kiboutime(), null, "（ＩＷＳ）（表示用）予約第１希望時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kiboubasyo(), null, "（ＩＷＳ）（表示用）予約第１希望場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kibouadr(), null, "（ＩＷＳ）（表示用）予約第１希望住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kiboumd(), null, "（ＩＷＳ）（表示用）予約第２希望月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kiboutime(), null, "（ＩＷＳ）（表示用）予約第２希望時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kiboubasyo(), null, "（ＩＷＳ）（表示用）予約第２希望場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kibouadr(), null, "（ＩＷＳ）（表示用）予約第２希望住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kiboumd(), null, "（ＩＷＳ）（表示用）予約第３希望月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kiboutime(), null, "（ＩＷＳ）（表示用）予約第３希望時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kiboubasyo(), null, "（ＩＷＳ）（表示用）予約第３希望場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kibouadr(), null, "（ＩＷＳ）（表示用）予約第３希望住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakuokyksmrenraku(), null, "（ＩＷＳ）（表示用）予約お客様連絡先");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakubosyuutntrnrk(), null, "（ＩＷＳ）（表示用）予約募集担当者連絡先");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudoukoukibouyh(), null, "（ＩＷＳ）（表示用）予約同行希望要否");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiukeno(), null, "（ＩＷＳ）（表示用）手配受付番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaijk(), null, "（ＩＷＳ）（表示用）手配状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaikekka(), null, "（ＩＷＳ）（表示用）手配結果");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisinsahouhou(), null, "（ＩＷＳ）（表示用）手配診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisindenzu(), null, "（ＩＷＳ）（表示用）手配心電図");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiketuekikensa(), null, "（ＩＷＳ）（表示用）手配血液検査");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyadtlsuu(), null, "（ＩＷＳ）（表示用）手配診査者明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyacd01(), null, "（ＩＷＳ）（表示用）手配診査者コード＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyanm01(), null, "（ＩＷＳ）（表示用）手配診査者名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyacd02(), null, "（ＩＷＳ）（表示用）手配診査者コード＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyanm02(), null, "（ＩＷＳ）（表示用）手配診査者名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyacd03(), null, "（ＩＷＳ）（表示用）手配診査者コード＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyanm03(), null, "（ＩＷＳ）（表示用）手配診査者名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteimd(), null, "（ＩＷＳ）（表示用）手配予定月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteitime(), null, "（ＩＷＳ）（表示用）手配予定時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteibasyo(), null, "（ＩＷＳ）（表示用）手配予定場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteipostalcd(), null, "（ＩＷＳ）（表示用）手配予定郵便番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteiadr(), null, "（ＩＷＳ）（表示用）手配予定住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaidksyatehaikekka(), null, "（ＩＷＳ）（表示用）手配同行者手配結果");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaidksyakjsosikinm(), null, "（ＩＷＳ）（表示用）手配同行者漢字組織名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaidksyakjnm(), null, "（ＩＷＳ）（表示用）手配同行者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "0", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), "死亡保険金受取人", "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), "5", "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), "死亡受取人名４死亡受取人名４０", "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), "19881212", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), "100", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), "死亡受取人名４死亡受取人名４１", "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), "19890101", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), "110", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), "死亡受取人名４死亡受取人名４２", "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), "19890202", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), "120", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), "死亡受取人名４死亡受取人名４３", "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), "19890303", "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), "兄弟姉妹", "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), "130", "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
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
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptoksiphokenkinuktnm(), null, "（ＩＷＳ）（表示用）特定疾病保険金受取人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispjdmnsihokenkinuktnm(), null,
            "（ＩＷＳ）（表示用）重度慢性疾患保険金受取人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), "佐藤美雪１佐藤美雪１佐藤美雪１", "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), "兄弟姉妹", "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstkeisyouninmds(), null, "（ＩＷＳ）（表示用）指定承継人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstkeisyouninnm(), null, "（ＩＷＳ）（表示用）指定承継人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstkeisyounintdk(), null, "（ＩＷＳ）（表示用）指定承継人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsetaitemosno(), "790000012", "（ＩＷＳ）（表示用）セット相手申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispknhjnnm(), "ﾎｳｼﾞﾝｶﾅﾎｳｼﾞﾝｶﾅﾎｳｼﾞﾝｶﾅﾎｳｼﾞﾝｶﾅﾎｳｼﾞﾝｶﾅ",
            "（ＩＷＳ）（表示用）カナ法人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjhjnnm(), "法人代表者名法人代表者名法人代表者名法人代表者名法人代表者名",
            "（ＩＷＳ）（表示用）漢字法人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), "一時払", "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkeiro(), null, "（ＩＷＳ）（表示用）払込経路");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), "あり", "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), "あり", "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), "加入（新規）",
            "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcardmosnai(), null, "（ＩＷＳ）（表示用）カード申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngkmds(), "保険金額", "（ＩＷＳ）（表示用）保険金額見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkknmds(), "保険期間", "（ＩＷＳ）（表示用）保険期間見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), "12,345,678,901", "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "１０歳", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), "11,002,200,330", "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkbtknjdtllinecnt(), "00", "（ＩＷＳ）（表示用）特別勘定明細行数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari01(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari01(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi01(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi01(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari02(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari02(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi02(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi02(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari03(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari03(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi03(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi03(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari04(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari04(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi04(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi04(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari05(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari05(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi05(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi05(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari06(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari06(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi06(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi06(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari07(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari07(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi07(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi07(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari08(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari08(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi08(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi08(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari09(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari09(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi09(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi09(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari10(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari10(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi10(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi10(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkknmds(), "払込期間", "（ＩＷＳ）（表示用）払込期間見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　一時払", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "１４０％",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispteikaiyakuhrkkn(), null, "（ＩＷＳ）（表示用）低解約返戻金期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), "1",
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), "1", "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), "1",
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), "定期受取金支払通貨",
            "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "1", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), "11,002,200,330", "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "1", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkwsratetekiymd(), "20160705", "（ＩＷＳ）（表示用）為替レート適用日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkwsratemdstuktnikbn(), "1",
            "（ＩＷＳ）（表示用）為替レート見出し通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkwsrate(), "123.45", "（ＩＷＳ）（表示用）為替レート");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), "1", "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), "1", "（ＩＷＳ）（表示用）保険料通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), "（目標到達時円建終身保険変更特約）",
            "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokensyuruino(), "444", "（ＩＷＳ）（表示用）保険種類番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "1", "（ＩＷＳ）（表示用）入金済表示");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(6020)
    @Transactional
    public void testExecPostForm_F2() throws Exception {

        changeSystemDate(BizDate.valueOf(20160630));

        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860000389");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosno(), "860000389", "（ＩＷＳ）申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmd(), "　６月３０日", "（ＩＷＳ）表示月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMosjksyoukaimosno(), "860000389", "（ＩＷＳ）申込状況照会申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsSksyono(), null, "（ＩＷＳ）（新契約）証券番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuudrtennm(), "巣鴨代理店巣鴨代理店巣鴨代理店巣鴨代理店", "（ＩＷＳ）（表示用）募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuunm(), "漢字募集人名", "（ＩＷＳ）（表示用）募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuuninmds(), "募集人登録番号", "（ＩＷＳ）（表示用）募集人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispbosyuutrknokouincd(), "1780600000013",
            "（ＩＷＳ）（表示用）募集人登録番号／行員コード");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkidrtennm(), null, "（ＩＷＳ）（表示用）共同扱募集代理店名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuunm(), null, "（ＩＷＳ）（表示用）共同扱募集人氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkydatkibosyuutrkno(), null, "（ＩＷＳ）（表示用）共同扱募集人登録番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsonotainfomds(), null, "（ＩＷＳ）（表示用）その他情報見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcifcduktkid(), null, "（ＩＷＳ）（表示用）ＣＩＦコード／受付管理ＩＤ");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsekno(), null, "（ＩＷＳ）（表示用）設計書番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispykkigenymd(), null, "（ＩＷＳ）（表示用）有効期限日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm01(), null, "（ＩＷＳ）（表示用）保険名称＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknnm02(), null, "（ＩＷＳ）（表示用）保険名称＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykknnm(), null, "（ＩＷＳ）（表示用）契約者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykkjnm(), "　様", "（ＩＷＳ）（表示用）契約者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykseiymd(), null, "（ＩＷＳ）（表示用）契約者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksyanen2keta(), " 0", "（ＩＷＳ）（表示用）契約者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyksei(), null, "（ＩＷＳ）（表示用）契約者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktdk(), "子", "（ＩＷＳ）（表示用）契約者続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktelno(), null, "（ＩＷＳ）（表示用）契約者電話番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykyno(), null, "（ＩＷＳ）（表示用）契約者郵便番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykadr01(), null, "（ＩＷＳ）（表示用）契約者住所＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkykadr02(), null, "（ＩＷＳ）（表示用）契約者住所＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknknnm(), null, "（ＩＷＳ）（表示用）被保険者カナ氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknkjnm(), "　様", "（ＩＷＳ）（表示用）被保険者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknseiymd(), null, "（ＩＷＳ）（表示用）被保険者生年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknnen2keta(), " 0", "（ＩＷＳ）（表示用）被保険者年令（２桁）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknsei(), null, "（ＩＷＳ）（表示用）被保険者性別");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknyno(), null, "（ＩＷＳ）（表示用）被保険者郵便番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknadr01(), "契約者と同一", "（ＩＷＳ）（表示用）被保険者住所＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphhknadr02(), null, "（ＩＷＳ）（表示用）被保険者住所＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosjk(), "未確定", "（ＩＷＳ）（表示用）申込状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphubijk(), null, "（ＩＷＳ）（表示用）不備状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmosymd(), "20160703", "（ＩＷＳ）（表示用）申込年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkokutiymd(), null, "（ＩＷＳ）（表示用）告知年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsahouhou(), null, "（ＩＷＳ）（表示用）診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeiyakuymd(), null, "（ＩＷＳ）（表示用）契約年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispseirituymd(), null, "（ＩＷＳ）（表示用）成立年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkeijyouymstr(), null, "（ＩＷＳ）（表示用）計上年月（文字列）");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenjk(), null, "（ＩＷＳ）（表示用）証券状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukensakuseiymd(), null, "（ＩＷＳ）（表示用）証券作成年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsyoukenhakkouytiymd(), null, "（ＩＷＳ）（表示用）証券発行予定年月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkjk(), null, "（ＩＷＳ）（表示用）入金状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkrirekidtlsuu(), "0", "（ＩＷＳ）（表示用）入金履歴明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku01(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd01(), null, "（ＩＷＳ）（表示用）領収年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku02(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd02(), null, "（ＩＷＳ）（表示用）領収年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku03(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd03(), null, "（ＩＷＳ）（表示用）領収年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprsgaku04(), null, "（ＩＷＳ）（表示用）保険料領収金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispryousyuuymd04(), null, "（ＩＷＳ）（表示用）領収年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnktyouseiniyudtlsuu(), "0", "（ＩＷＳ）（表示用）入金調整内容明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk01(), null, "（ＩＷＳ）（表示用）返金額＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou01(), null, "（ＩＷＳ）（表示用）精算内容＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk02(), null, "（ＩＷＳ）（表示用）返金額＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou02(), null, "（ＩＷＳ）（表示用）精算内容＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk03(), null, "（ＩＷＳ）（表示用）返金額＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou03(), null, "（ＩＷＳ）（表示用）精算内容＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngk04(), null, "（ＩＷＳ）（表示用）返金額＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispssnaiyou04(), null, "（ＩＷＳ）（表示用）精算内容＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispiktkaisuu(), "0", "（ＩＷＳ）（表示用）一括回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispznnkai(), null, "（ＩＷＳ）（表示用）前納回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispketteijk(), "完了", "（ＩＷＳ）（表示用）決定状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsinsatehaiinfokbn(), null, "（ＩＷＳ）（表示用）診査手配情報区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakuukeno(), null, "（ＩＷＳ）（表示用）予約受付番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakutehaijk(), null, "（ＩＷＳ）（表示用）予約手配状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakusinsahouhou(), null, "（ＩＷＳ）（表示用）予約診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakusindenzu(), null, "（ＩＷＳ）（表示用）予約心電図");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakuketuekikensa(), null, "（ＩＷＳ）（表示用）予約血液検査");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kiboumd(), null, "（ＩＷＳ）（表示用）予約第１希望月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kiboutime(), null, "（ＩＷＳ）（表示用）予約第１希望時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kiboubasyo(), null, "（ＩＷＳ）（表示用）予約第１希望場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai1kibouadr(), null, "（ＩＷＳ）（表示用）予約第１希望住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kiboumd(), null, "（ＩＷＳ）（表示用）予約第２希望月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kiboutime(), null, "（ＩＷＳ）（表示用）予約第２希望時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kiboubasyo(), null, "（ＩＷＳ）（表示用）予約第２希望場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai2kibouadr(), null, "（ＩＷＳ）（表示用）予約第２希望住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kiboumd(), null, "（ＩＷＳ）（表示用）予約第３希望月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kiboutime(), null, "（ＩＷＳ）（表示用）予約第３希望時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kiboubasyo(), null, "（ＩＷＳ）（表示用）予約第３希望場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudai3kibouadr(), null, "（ＩＷＳ）（表示用）予約第３希望住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakuokyksmrenraku(), null, "（ＩＷＳ）（表示用）予約お客様連絡先");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakubosyuutntrnrk(), null, "（ＩＷＳ）（表示用）予約募集担当者連絡先");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispyoyakudoukoukibouyh(), null, "（ＩＷＳ）（表示用）予約同行希望要否");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiukeno(), null, "（ＩＷＳ）（表示用）手配受付番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaijk(), null, "（ＩＷＳ）（表示用）手配状況");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaikekka(), null, "（ＩＷＳ）（表示用）手配結果");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisinsahouhou(), null, "（ＩＷＳ）（表示用）手配診査方法");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisindenzu(), null, "（ＩＷＳ）（表示用）手配心電図");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiketuekikensa(), null, "（ＩＷＳ）（表示用）手配血液検査");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyadtlsuu(), null, "（ＩＷＳ）（表示用）手配診査者明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyacd01(), null, "（ＩＷＳ）（表示用）手配診査者コード＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyanm01(), null, "（ＩＷＳ）（表示用）手配診査者名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyacd02(), null, "（ＩＷＳ）（表示用）手配診査者コード＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyanm02(), null, "（ＩＷＳ）（表示用）手配診査者名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyacd03(), null, "（ＩＷＳ）（表示用）手配診査者コード＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaisnssyanm03(), null, "（ＩＷＳ）（表示用）手配診査者名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteimd(), null, "（ＩＷＳ）（表示用）手配予定月日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteitime(), null, "（ＩＷＳ）（表示用）手配予定時間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteibasyo(), null, "（ＩＷＳ）（表示用）手配予定場所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteipostalcd(), null, "（ＩＷＳ）（表示用）手配予定郵便番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaiyoteiadr(), null, "（ＩＷＳ）（表示用）手配予定住所");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaidksyatehaikekka(), null, "（ＩＷＳ）（表示用）手配同行者手配結果");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaidksyakjsosikinm(), null, "（ＩＷＳ）（表示用）手配同行者漢字組織名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptehaidksyakjnm(), null, "（ＩＷＳ）（表示用）手配同行者漢字氏名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktdtlsuu(), "0", "（ＩＷＳ）（表示用）死亡受取人明細数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktmds(), null, "（ＩＷＳ）（表示用）死亡受取人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnin(), null, "（ＩＷＳ）（表示用）死亡受取人人数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm01(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd01(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk01(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari01(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm02(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd02(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk02(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari02(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm03(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd03(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk03(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari03(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktnm04(), null, "（ＩＷＳ）（表示用）死亡受取人名＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktseiymd04(), null, "（ＩＷＳ）（表示用）死亡受取人生年月日＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbukttdk04(), null, "（ＩＷＳ）（表示用）死亡受取人続柄＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsbuktbnwari04(), null, "（ＩＷＳ）（表示用）死亡受取人分割割合＿０４");
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
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptoksiphokenkinuktnm(), null, "（ＩＷＳ）（表示用）特定疾病保険金受取人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispjdmnsihokenkinuktnm(), null,
            "（ＩＷＳ）（表示用）重度慢性疾患保険金受取人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsknm(), null, "（ＩＷＳ）（表示用）指定代理請求人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktdk(), null, "（ＩＷＳ）（表示用）指定代理請求人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstkeisyouninmds(), null, "（ＩＷＳ）（表示用）指定承継人見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstkeisyouninnm(), null, "（ＩＷＳ）（表示用）指定承継人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstkeisyounintdk(), null, "（ＩＷＳ）（表示用）指定承継人続柄");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispsetaitemosno(), null, "（ＩＷＳ）（表示用）セット相手申込番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispknhjnnm(), null, "（ＩＷＳ）（表示用）カナ法人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkjhjnnm(), null, "（ＩＷＳ）（表示用）漢字法人名");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkaisuu(), null, "（ＩＷＳ）（表示用）払込回数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkeiro(), null, "（ＩＷＳ）（表示用）払込経路");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisplivingneedstkyk(), null, "（ＩＷＳ）（表示用）リビングニーズ特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstdrsktkyk(), null, "（ＩＷＳ）（表示用）指定代理請求特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnkshrtkyk(), null, "（ＩＷＳ）（表示用）年金支払特約");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispdrctservicemosnai(), null, "（ＩＷＳ）（表示用）ダイレクトサービス申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispcardmosnai(), null, "（ＩＷＳ）（表示用）カード申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngkmds(), "保険金額", "（ＩＷＳ）（表示用）保険金額見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkknmds(), "保険期間", "（ＩＷＳ）（表示用）保険期間見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngk(), null, "（ＩＷＳ）（表示用）保険金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphknkkn(), "　０年", "（ＩＷＳ）（表示用）保険期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenryou(), null, "（ＩＷＳ）（表示用）保険料");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkbtknjdtllinecnt(), "00", "（ＩＷＳ）（表示用）特別勘定明細行数");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari01(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari01(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi01(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi01(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari02(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari02(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi02(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi02(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari03(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari03(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi03(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi03(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari04(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari04(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi04(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi04(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari05(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari05(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi05(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi05(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０５");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari06(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari06(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi06(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi06(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０６");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari07(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari07(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi07(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi07(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０７");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari08(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari08(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi08(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi08(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０８");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari09(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari09(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi09(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi09(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿０９");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmhidari10(), null, "（ＩＷＳ）（表示用）ファンド名（左）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarihidari10(), null, "（ＩＷＳ）（表示用）ファンド割合（左）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundnmmigi10(), null, "（ＩＷＳ）（表示用）ファンド名（右）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispfundwarimigi10(), null, "（ＩＷＳ）（表示用）ファンド割合（右）＿１０");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkknmds(), "払込期間", "（ＩＷＳ）（表示用）払込期間見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkkkn(), "　　０年", "（ＩＷＳ）（表示用）払込期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispmkhyoututtosrsmosnai(), "申込なし",
            "（ＩＷＳ）（表示用）目標到達お知らせ申込内容");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispteikaiyakuhrkkn(), null, "（ＩＷＳ）（表示用）低解約返戻金期間");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn01(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn02(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn03(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispprskngkutuktnikbn04(), null,
            "（ＩＷＳ）（表示用）保険料領収金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn01(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿１");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn02(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿２");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn03(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿３");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphnkngktuktnikbn04(), null, "（ＩＷＳ）（表示用）返金額通貨単位区分＿４");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtuktnikbn(), null,
            "（ＩＷＳ）（表示用）定期受取金支払通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptkuktrknshrtukmds(), null, "（ＩＷＳ）（表示用）定期受取金支払通貨見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrktuktnikbn(), "0", "（ＩＷＳ）（表示用）払込通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphrkgk(), null, "（ＩＷＳ）（表示用）払込金額");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkyktuktnikbn(), "0", "（ＩＷＳ）（表示用）契約通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkwsratetekiymd(), null, "（ＩＷＳ）（表示用）為替レート適用日");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkwsratemdstuktnikbn(), "0",
            "（ＩＷＳ）（表示用）為替レート見出し通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispkwsrate(), "     0", "（ＩＷＳ）（表示用）為替レート");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokenkngktuktnikbn(), null, "（ＩＷＳ）（表示用）保険金額通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispptuktnikbn(), null, "（ＩＷＳ）（表示用）保険料通貨単位区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisptargettkyknm(), null, "（ＩＷＳ）（表示用）目標値見出し");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDisphokensyuruino(), "441", "（ＩＷＳ）（表示用）保険種類番号");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispstitukhrktukditkbn(), "1", "（ＩＷＳ）（表示用）指定通貨払込通貨同一区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsDispnyknzumihyouji(), "0", "（ＩＷＳ）（表示用）入金済表示");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "00", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "処理ＯＫ", "（ＩＷＳ）エラーメッセージV４０");
    }

    @Test
    @TestOrder(7010)
    public void testExecPostForm_G1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", " ");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(7020)
    public void testExecPostForm_G2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001973");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(7030)
    public void testExecPostForm_G3() throws Exception {

        MockObjectManager.initialize();
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = null;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001940");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(7040)
    public void testExecPostForm_G4() throws Exception {

        MockObjectManager.initialize();
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001932");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージV４０");

    }

    @Test
    @TestOrder(7040)
    public void testExecPostForm_G5() throws Exception {

        MockObjectManager.initialize();
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "860001924");
        pMap.add("operatorId", "012345678911234567890123456789");
        pMap.add("orgCode", "75000");
        pMap.add("methodName", "bosyuu\\.hbsksyoukai\\.HbSeihoWebMosSyoukai\\.HbSeihoWebMosSyoukaiTest_execPostForm");
        pMap.add("coopClass", "coopClass");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebMosSyoukaiImpl.execPostForm(pMap);

        WsHbSeihoWebMosSyoukaiOutputBean wsHbSeihoWebMosSyoukaiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebMosSyoukaiOutputBean.class);

        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsMossyoukaierrkbn(), "02", "（ＩＷＳ）申込状況照会エラー区分");
        exStringEquals(wsHbSeihoWebMosSyoukaiOutputBean.getIwsErrormsgv40(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）エラーメッセージV４０");

    }
}
