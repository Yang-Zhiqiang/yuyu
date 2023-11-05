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
import jp.co.slcs.swak.date.BizDate;

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
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 災害死亡自殺免責チェックのメソッド{@link ChkSubSgSbJisatuMenseki#exec(BizDate, BizDate, JT_SiKykSyouhn, JM_SiSyouhnZokusei, C_GeninKbn,
 *      List<String>, C_UmuKbn, JT_SkKihon, List<ChkKekkaBean>)} テスト用クラスです。
 * <br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubSgSbJisatuMensekiTest_exec {

    @Inject
    private ChkSubSgSbJisatuMenseki chkSubSgSbJisatuMenseki;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_災害死亡自殺免責チェック";

    private final static String sheetName = "INデータ";

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
            testDataAndTblMap = testDataMaker.getInData(ChkSubSgSbJisatuMensekiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
    }

    @BeforeClass
    public static void testInit() {
        BzGetImagePropsMockForSiharai.caller = ChkSubSgSbJisatuMensekiTest_exec.class;
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

        BizDate hanteiKijyunYmd = null;
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = null;

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100001");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100001");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.ARI;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_KSYOUHI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11807111118");
        skKihon.setSkno("1000001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_SKSYORUI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

        BzGetImagePropsInBean bzGetImagePropsInBean =
            (BzGetImagePropsInBean) MockObjectManager.getArgument(BzGetImagePropsMockForSiharai.class, "exec", 0, 0);
        exStringEquals(bzGetImagePropsInBean.getJimuTetuzukiCd(), null, "事務手続コード");
        exStringEquals(bzGetImagePropsInBean.getKouteiKanriId(), "1001", "工程管理ID");
        exClassificationEquals(bzGetImagePropsInBean.getSyoruiCd(), C_SyoruiCdKbn.HK_KD_JIKOJKS, "書類コード");
        exStringEquals(bzGetImagePropsInBean.getSyoruiTtykYmdTimeFrom(), null, "書類到着日時(自)");
        exStringEquals(bzGetImagePropsInBean.getSyoruiTtykYmdTimeTo(), null, "書類到着日時(至)");
        exClassificationEquals(bzGetImagePropsInBean.getKouteiKanriStatus(), null, "工程管理状況");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11807111119");
        skKihon.setSkno("1000001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = BizDate.valueOf(20150526);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150524));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = BizDate.valueOf(20150526);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150524));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11807111119");
        skKihon.setSkno("1000001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = BizDate.valueOf(20150524);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100001");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = BizDate.valueOf(20150524);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150526));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11807111119");
        skKihon.setSkno("1000001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150525));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.ARI;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = BizDate.valueOf(20150525);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150524));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11807111118");
        skKihon.setSkno("1000001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;

        BizDate hanteiKijyunYmd = BizDate.valueOf(20180525);
        BizDate hksknnkaisiymd = BizDate.valueOf(20150524);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20150525));

        C_GeninKbn geninKbn = C_GeninKbn.SP;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11807111118");
        skKihon.setSkno("1000001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(150)
    public void testExec_B1() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20190228);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160229));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(160)
    public void testExec_B2() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20190301);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160229));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(170)
    public void testExec_B3() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20190228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20160229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160228));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(180)
    public void testExec_B4() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20190301);
        BizDate hksknnkaisiymd = BizDate.valueOf(20160229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160228));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(190)
    public void testExec_B5() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200227);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20170228));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(200)
    public void testExec_B6() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200228);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20170228));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(210)
    public void testExec_B7() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200229);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20170228));

        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        JT_SkKihon skKihon = new JT_SkKihon();

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSgSbJisatuMenseki.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn, geninKbn, byoumeiTourokuNoLst,
            sateiKakSaigaiKanouseiKbn, skKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

}
