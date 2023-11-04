package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForDirect;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約異動状態取得のメソッド
 * {@link HozenKeiyakuIdouJyoutaiSyutoku#hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約異動状態取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class;
        BzGetProcessSummaryMockForDirect.caller = HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = null;
        BzGetProcessSummaryMockForDirect.caller = null;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = null;
        BzGetProcessSummaryMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenKeiyakuIdouJyoutaiSyutokuTest_hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);


        hozenDomManager.delete(hozenDomManager.getAllKhMeigiHenkouWk());


        hozenDomManager.delete(hozenDomManager.getAllKhJyuusyoHenkouWk());


        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A1() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;

        String pSyoNo = "31809111327";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean  idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");


        String syoNo = (String)MockObjectManager.
            getArgument(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class, "keiyakuJyoutaiYuukouseiHantei", 0, 0);

        exStringEquals(syoNo, "31809111327", "証券番号");
    }

    @Test
    @TestOrder(20)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A2() {
        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN1;

        String pSyoNo = "17806000013";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean =
            (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForDirect.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(),
            IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0],
            C_Kouteikanristatus.SYORITYUU, " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "17806000013", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean.getSubSystemId(),
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
    }

    @Test
    @TestOrder(30)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A3() {
        MockObjectManager.initialize();

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN6;

        String pSyoNo = "17806000024";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =
            (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForDirect.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],
            C_Kouteikanristatus.SYORITYUU, " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "17806000024", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean2.getSubSystemId(),
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
    }


    @Test
    @TestOrder(40)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A4() {

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN7;
        String pSyoNo = "17806000035";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN7;


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
    }

    @Test
    @TestOrder(50)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A5() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000046";


        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        idouJyoutaiSyutoku.setDetachYouhiKbn(C_YouhiKbn.HUYOU);

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }


    @Test
    @TestOrder(60)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A6() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000057";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.ERROR, "異動中区分");
    }

    @Test
    @TestOrder(70)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A7() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000068";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(80)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A8() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000079";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(90)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A9() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000080";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(100)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A10() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000091";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
    }

    @Test
    @TestOrder(110)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A11() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN1;

        String pSyoNo = "17806000105";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.ARI, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.ARI, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.ARI, "四点相違有無区分");
    }

    @Test
    @TestOrder(120)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A12() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN2;

        String pSyoNo = "17806000116";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.NONE, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.NONE, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.NONE, "四点相違有無区分");
    }

    @Test
    @TestOrder(130)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A13() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN3;

        String pSyoNo = "17806000127";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        C_UmuKbn meigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
        C_UmuKbn juushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();

        C_UmuKbn srMeigiHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

        C_UmuKbn srJuushoHenkouUmuKbn = idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();

        C_UmuKbn yotenSouiUmuKbn = idouJyoutaiSyutokuBean.getYotenSouiUmuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUNASHI, "異動中区分");
        exClassificationEquals(meigiHenkouUmuKbn, C_UmuKbn.NONE, "名義変更有無区分");
        exClassificationEquals(juushoHenkouUmuKbn, C_UmuKbn.NONE, "住所変更有無区");
        exClassificationEquals(srMeigiHenkouUmuKbn, C_UmuKbn.NONE, "処理中名義変更有無区分");
        exClassificationEquals(srJuushoHenkouUmuKbn, C_UmuKbn.NONE, "処理中住所変更有無区分");
        exClassificationEquals(yotenSouiUmuKbn, C_UmuKbn.NONE, "四点相違有無区分");
    }

    @Test
    @TestOrder(140)
    public void testHozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu_A14() {

        MockObjectManager.initialize();

        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        BzGetProcessSummaryMockForDirect.SYORIPTN = BzGetProcessSummaryMockForDirect.TESTPATTERN4;

        String pSyoNo = "17806000024";

        HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku = SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean = idouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(pSyoNo);


        C_YuukshantkekKbn yuukouKbn = idouJyoutaiSyutokuBean.getYuukouKbn();

        C_IdoutyuuHanteiKekkaKbn idoutyuuKbn = idouJyoutaiSyutokuBean.getIdoutyuuKbn();

        exClassificationEquals(yuukouKbn, C_YuukshantkekKbn.OK, "有効性区分");
        exClassificationEquals(idoutyuuKbn, C_IdoutyuuHanteiKekkaKbn.IDOUTYUU, "異動中区分");


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =
            (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummaryMockForDirect.class, "exec", 1, 0);

        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),
            IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU, "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],
            C_Kouteikanristatus.SYORITYUU, " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "17806000024", "証券番号");
        exStringEquals(bzGetProcessSummaryInBean2.getSubSystemId(),
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
    }
}