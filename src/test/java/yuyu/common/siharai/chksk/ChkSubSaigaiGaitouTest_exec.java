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
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsMockForSiharai;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 災害該当可能性チェックのメソッド{@link ChkSubSaigaiGaitou#exec(BizDate, List<String>, C_GeninKbn, C_UmuKbn, Integer,
 *      Integer, JT_SiKykSyouhn, JT_SkKihon, Boolean, List<ChkKekkaBean>)} テスト用クラスです。
 * <br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubSaigaiGaitouTest_exec {

    @Inject
    private ChkSubSaigaiGaitou chkSubSaigaiGaitou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_災害該当可能性チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    public static void testInit(){
        BzGetImagePropsMockForSiharai.caller =ChkSubSaigaiGaitouTest_exec.class;
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

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.caller =null;
        BzGetImagePropsMockForSiharai.SYORIPTN =null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(ChkSubSaigaiGaitouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllByoumei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160701));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("80808000013");
        Boolean sateiChkFlg = true;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SAIGAI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.TENTOU;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160702));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK002");
        skKihon.setSyono("80808000024");
        Boolean sateiChkFlg = false;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100001");
        C_GeninKbn geninKbn = C_GeninKbn.SP;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160709));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK009");
        skKihon.setSyono("80808000091");
        Boolean sateiChkFlg = true;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI,
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

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        byoumeiTourokuNoLst.add("100003");
        byoumeiTourokuNoLst.add("100004");
        C_GeninKbn geninKbn = C_GeninKbn.SP;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160710));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK010");
        skKihon.setSyono("80808000105");
        Boolean sateiChkFlg = false;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK,
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

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.SP;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.ARI;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160711));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK011");
        skKihon.setSyono("80808000116");
        Boolean sateiChkFlg = true;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SAIGAI_KSYOUHI,
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

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.SP;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.ARI;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160712));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK012");
        skKihon.setSyono("80808000127");
        Boolean sateiChkFlg = false;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;
        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.SP;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160713));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("80808000138");
        skKihon.setSyono("11807111185");
        Boolean sateiChkFlg = true;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SAIGAI_SKSYORUI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        BzGetImagePropsMockForSiharai.SYORIPTN = BzGetImagePropsMockForSiharai.TESTPATTERN1;
        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.SP;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160714));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("80808000149");
        skKihon.setSyono("11807111277");
        Boolean sateiChkFlg = false;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAIGAI_GAITOU_CHK,
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

        BizDate hanteiKijyunYmd = BizDate.valueOf(20300302);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        byoumeiTourokuNoLst.add("100002");
        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.ARI;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.SECOND);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20160716));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK016");
        skKihon.setSyono("80808000161");
        Boolean sateiChkFlg = false;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20200202);
        List<String> byoumeiTourokuNoLst = new ArrayList<>();
        C_GeninKbn geninKbn = C_GeninKbn.KTJK;
        C_UmuKbn sateiKakSaigaiKanouseiKbn = C_UmuKbn.NONE;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekikkn(15);
        syouhnZokusei.setHknkknbunruikbn(C_HknkknBunruiKbn.THIRD);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setKykymd(BizDate.valueOf(20200701));
        siKykSyouhn.setDai1hknkkn(10);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SK001");
        skKihon.setSyono("80808000013");
        Boolean sateiChkFlg = true;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubSaigaiGaitou.exec(hanteiKijyunYmd, byoumeiTourokuNoLst, geninKbn, sateiKakSaigaiKanouseiKbn,
            syouhnZokusei, siKykSyouhn, skKihon, sateiChkFlg, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SAIGAI_GENINKBN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

    }
}
