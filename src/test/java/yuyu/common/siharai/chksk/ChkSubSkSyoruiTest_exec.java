package yuyu.common.siharai.chksk;

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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSiharai;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 請求書類チェックのメソッド{@link ChkSubSkSyorui#exec(JT_SkKihon, List<ChkKekkaBean>)} テスト用クラスです。
 * <br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubSkSyoruiTest_exec {

    @Inject
    private ChkSubSkSyorui chkSubSkSyorui;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_請求書類チェック";
    private final static String sheetName = "テストデータ";

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
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(ChkSubSkSyoruiTest_exec.class,fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("null2d0sek8kyd95dds"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("null2d0sf0vk96e2bcw"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("null2d0sf234yfu3t34"));
    }

    @BeforeClass
    public static void testInit() {
        BzGetImagePropsMockForSiharai.caller = ChkSubSkSyoruiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.caller = null;
        BzGetImagePropsMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("31809111110");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubSkSyorui.exec(skKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SKSYORUI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

        BzGetImagePropsInBean bzGetImagePropsInBean =
            (BzGetImagePropsInBean) MockObjectManager.getArgument(BzGetImagePropsMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetImagePropsInBean.getJimuTetuzukiCd(), null, "事務手続コード");
        exStringEquals(bzGetImagePropsInBean.getKouteiKanriId(), "null2d0sek8kyd95dds", "工程管理ID");
        exClassificationEquals(bzGetImagePropsInBean.getSyoruiCd(), C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS, "書類コード");
        exStringEquals(bzGetImagePropsInBean.getSyoruiTtykYmdTimeFrom(), null, "書類到着日時(自)");
        exStringEquals(bzGetImagePropsInBean.getSyoruiTtykYmdTimeTo(), null, "書類到着日時(至)");
        exClassificationEquals(bzGetImagePropsInBean.getKouteiKanriStatus(), null, "工程管理状況");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN2;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK002");
        skKihon.setSyono("31809111121");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubSkSyorui.exec(skKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN3;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK003");
        skKihon.setSyono("31809111132");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSkSyorui.exec(skKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }
}
