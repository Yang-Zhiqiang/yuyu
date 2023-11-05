package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSiharai;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 災害該当判定クラスの災害該当判定（請求書類）メソッド {@link SaigaiGaitouHantei#chkKyuusyorui(JT_SkKihon)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaigaiGaitouHanteiTest_chkKyuusyorui {

    @Inject
    private SaigaiGaitouHantei saigaiGaitouHantei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_災害該当判定";

    private final static String sheetName = "INデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaigaiGaitouHanteiTest_chkKyuusyorui.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("testkouteikanriid01"));
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetImageProps.class).to(BzGetImagePropsMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        BzGetImagePropsMockForSiharai.caller = SaigaiGaitouHanteiTest_chkKyuusyorui.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.caller = null;
        BzGetImagePropsMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(410)
    public void testChkKyuusyorui_A1() {

        boolean result = saigaiGaitouHantei.chkKyuusyorui(null);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(420)
    public void testChkKyuusyorui_A2() {

        JT_SkKihon skKihon = new JT_SkKihon();

        boolean result = saigaiGaitouHantei.chkKyuusyorui(skKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(430)
    public void testChkKyuusyorui_A3() {

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK999");
        skKihon.setSyono("80808000013");

        boolean result = saigaiGaitouHantei.chkKyuusyorui(skKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(440)
    public void testChkKyuusyorui_A4() {

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("80808000024");

        boolean result = saigaiGaitouHantei.chkKyuusyorui(skKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(450)
    public void testChkKyuusyorui_A5() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai .SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("80808000013");

        boolean result = saigaiGaitouHantei.chkKyuusyorui(skKihon);

        exBooleanEquals(result, false, "判定結果フラグ");

        BzGetImagePropsInBean bzGetImagePropsInBean =
            (BzGetImagePropsInBean) MockObjectManager.getArgument(BzGetImagePropsMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetImagePropsInBean.getJimuTetuzukiCd(), null, "事務手続コード");
        exStringEquals(bzGetImagePropsInBean.getKouteiKanriId(), "testkouteikanriid01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsInBean.getSyoruiCd(), C_SyoruiCdKbn.HK_KD_JIKOJKS, "書類コード");
        exStringEquals(bzGetImagePropsInBean.getSyoruiTtykYmdTimeFrom(), null, "書類到着日時(自)");
        exStringEquals(bzGetImagePropsInBean.getSyoruiTtykYmdTimeTo(), null, "書類到着日時(至)");
        exClassificationEquals(bzGetImagePropsInBean.getKouteiKanriStatus(), null, "工程管理状況");
    }

    @Test
    @TestOrder(460)
    public void testChkKyuusyorui_A6() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai .SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN2;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("80808000013");

        boolean result = saigaiGaitouHantei.chkKyuusyorui(skKihon);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(470)
    public void testChkKyuusyorui_A7() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai .SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN3;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("80808000013");

        boolean result = saigaiGaitouHantei.chkKyuusyorui(skKihon);

        exBooleanEquals(result, true, "判定結果フラグ");
    }
}
