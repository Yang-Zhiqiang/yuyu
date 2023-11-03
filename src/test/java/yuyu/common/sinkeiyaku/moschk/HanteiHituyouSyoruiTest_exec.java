package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.koutei.SkHituyousyoruiHantei;
import yuyu.common.sinkeiyaku.koutei.SkHituyousyoruiHanteiMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 必要書類判定クラスのメソッド {@link HanteiHituyouSyorui#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class HanteiHituyouSyoruiTest_exec {

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "861110013";

    private final static String mosNo3 = "861110021";

    private final static String mosNo4 = "860083641";

    private final static String mosNo5 = "860083674";

    private final static String mosNo6 = "860083658";


    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_必要書類判定";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SkHituyousyoruiHantei.class).to(SkHituyousyoruiHanteiMockForSinkeiyaku.class);
                bind(BzGetImageProps.class).to(BzGetImagePropsMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit() {

        SkHituyousyoruiHanteiMockForSinkeiyaku.caller = HanteiHituyouSyoruiTest_exec.class;
        BzGetImagePropsMockForSinkeiyaku.caller = HanteiHituyouSyoruiTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.caller = HanteiHituyouSyoruiTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        SkHituyousyoruiHanteiMockForSinkeiyaku.caller = null;
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = null;
        BzGetImagePropsMockForSinkeiyaku.caller = null;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = null;
        SetHubiMsgMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiHituyouSyoruiTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = SkHituyousyoruiHanteiMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = bizDomManager.getGyoumuKouteiInfo("1100000001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        HanteiHituyouSyorui hanteiHituyouSyorui = SWAKInjector.getInstance(HanteiHituyouSyorui.class);
        hanteiHituyouSyorui.exec(mosnaiCheckParam);

        MosnaiCheckParam mosnaiCheckParam1 = (MosnaiCheckParam)MockObjectManager.getArgument(SkHituyousyoruiHanteiMockForSinkeiyaku.class, "exec", 0, 0);
        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam1.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), mosNo1, "申込番号");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = mosnaiCheckParam1.getGyoumuKouteiInfo();
        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), "1100000001", "工程管理ＩＤ");
        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();
        exNumericEquals(hituyouSyoruiKanriList.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam1.getSysKbn(), C_SysKbn.SKEI, "システム区分");

        BzGetImagePropsInBean bzGetImagePropsInBean = (BzGetImagePropsInBean)MockObjectManager.getArgument(BzGetImagePropsMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetImagePropsInBean.getJimuTetuzukiCd(), "101", "事務手続コード");
        exStringEquals(bzGetImagePropsInBean.getKouteiKanriId(), "1100000001", "工程管理ＩＤ");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = SkHituyousyoruiHanteiMockForSinkeiyaku.TESTPATTERN1;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = bizDomManager.getGyoumuKouteiInfo("1100000002");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        HanteiHituyouSyorui hanteiHituyouSyorui = SWAKInjector.getInstance(HanteiHituyouSyorui.class);
        hanteiHituyouSyorui.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = SkHituyousyoruiHanteiMockForSinkeiyaku.TESTPATTERN2;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN3;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = bizDomManager.getGyoumuKouteiInfo("1100000003");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160217133124350");

        HanteiHituyouSyorui hanteiHituyouSyorui = SWAKInjector.getInstance(HanteiHituyouSyorui.class);
        hanteiHituyouSyorui.exec(mosnaiCheckParam);

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.SRHORYU_HUBI);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 2,
            "EHA0530 ペーパーレス申込書兼意向確認書が到着していません。");
        MosnaiCheckParam mosnaiCheckParam1 = (MosnaiCheckParam)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam1.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), mosNo3, "申込番号");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = mosnaiCheckParam1.getGyoumuKouteiInfo();
        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), "1100000003", "工程管理ＩＤ");
        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();
        exNumericEquals(hituyouSyoruiKanriList.size(), 1, "件数");
        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1100000003", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO, "書類コード");
        exClassificationEquals(mosnaiCheckParam1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParam1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParam1.getKosTime(), "20160217133124350", "更新時間");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, C_TknKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, C_MsgKbn.ERROR);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), mosNo3, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ペーパーレス申込書兼意向確認書が到着していません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHituyousyoruicd(), C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO, "必要書類コード");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20160217133124350", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = SkHituyousyoruiHanteiMockForSinkeiyaku.TESTPATTERN3;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN3;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = bizDomManager.getGyoumuKouteiInfo("1100000004");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160217133124350");

        HanteiHituyouSyorui hanteiHituyouSyorui = SWAKInjector.getInstance(HanteiHituyouSyorui.class);
        hanteiHituyouSyorui.exec(mosnaiCheckParam);

        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, C_KetsrhkosKbn.WARNING);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 2,
            "WHC0069 受取人事前照会票が到着していません。");
        MosnaiCheckParam mosnaiCheckParam1 = (MosnaiCheckParam)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam1.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), mosNo4, "申込番号");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = mosnaiCheckParam1.getGyoumuKouteiInfo();
        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), "1100000004", "工程管理ＩＤ");
        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();
        exNumericEquals(hituyouSyoruiKanriList.size(), 1, "件数");
        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1100000004", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "書類コード");
        exClassificationEquals(mosnaiCheckParam1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParam1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParam1.getKosTime(), "20160217133124350", "更新時間");
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 4, C_TknKbn.NONE);
        MockObjectManager.assertArgumentPassed(SetHubiMsgMockForSinkeiyaku.class, "exec", 5, C_MsgKbn.WARNING);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), mosNo4, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ペーパーレス取扱報告書が到着していません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHituyousyoruicd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "必要書類コード");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20160217133124350", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = SkHituyousyoruiHanteiMockForSinkeiyaku.TESTPATTERN4;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = bizDomManager.getGyoumuKouteiInfo("1100000005");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160217133124350");

        HanteiHituyouSyorui hanteiHituyouSyorui = SWAKInjector.getInstance(HanteiHituyouSyorui.class);
        hanteiHituyouSyorui.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        SkHituyousyoruiHanteiMockForSinkeiyaku.SYORIPTN = SkHituyousyoruiHanteiMockForSinkeiyaku.TESTPATTERN3;
        BzGetImagePropsMockForSinkeiyaku.SYORIPTN = BzGetImagePropsMockForSinkeiyaku.TESTPATTERN4;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setListHubiMsg(new ArrayList<HT_HubiMsg>());
        BT_GyoumuKouteiInfo gyoumuKouteiInfo1 = bizDomManager.getGyoumuKouteiInfo("1100000006");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo1);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20160217133124350");

        HanteiHituyouSyorui hanteiHituyouSyorui = SWAKInjector.getInstance(HanteiHituyouSyorui.class);
        hanteiHituyouSyorui.exec(mosnaiCheckParam);

        exClassificationEquals((C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0),
            C_KetsrhkosKbn.SRHORYU_HUBI, "決定・成立保留更新区分");
        exClassificationEquals((C_SpKeisanKahiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1),
            C_SpKeisanKahiKbn.MISETTEI, "決定保留時ＳＰ計算可否区分");
        exClassificationEquals((C_HubisyubetusyousaiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2),
            C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exClassificationEquals((C_SyoruiCdKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3),
            C_SyoruiCdKbn.BLNK, "必要書類コード区分");
        exStringEquals((String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4),
            "EHC1133 払込経路がクレジットカード扱いの場合、生命保険料支払申込書（クレジットカード情報）の取込は厳禁です。イメージ削除してください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParam1 = (MosnaiCheckParam)MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 5);
        HT_SyoriCTL syoriCTL1 = mosnaiCheckParam1.getDataSyoriControl();
        exStringEquals(syoriCTL1.getMosno(), mosNo6, "申込番号");
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = mosnaiCheckParam1.getGyoumuKouteiInfo();
        exStringEquals(gyoumuKouteiInfo.getKouteikanriid(), "1100000006", "工程管理ＩＤ");
        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = gyoumuKouteiInfo.getHituyouSyoruiKanris();
        exNumericEquals(hituyouSyoruiKanriList.size(), 1, "件数");
        exStringEquals(hituyouSyoruiKanriList.get(0).getKouteikanriid(), "1100000006", "工程管理ＩＤ");
        exClassificationEquals(hituyouSyoruiKanriList.get(0).getSyoruiCd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "書類コード");
        exClassificationEquals(mosnaiCheckParam1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParam1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParam1.getKosTime(), "20160217133124350", "更新時間");
        exClassificationEquals((C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 6),
            C_TknKbn.NONE, "特認区分");
        exClassificationEquals((C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 7),
            C_MsgKbn.ERROR, "メッセージ区分");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");

        exStringEquals(hubiMsg.get(0).getMosno(), mosNo6, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ペーパーレス取扱報告書が到着していません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHituyousyoruicd(), C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI, "必要書類コード");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20160217133124350", "業務用更新時間");
    }


}
