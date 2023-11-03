package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.DefaultMessageManager;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSiharai;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.edittbl.SiMeigihenkouSateiParam;
import yuyu.common.siharai.edittbl.SiSateiIppanHanteiParam;
import yuyu.common.siharai.edittbl.SiSonotaSateiSbParam;
import yuyu.common.siharai.edittbl.SiToriatukaifuryouParam;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 査定結果入力チェックラスのメソッド {@link SateiKekkaNyuuryokuChk#exec(CommonViewUiBeanParam, JT_SkKihon,
            List<ChkKekkaBean>, List<Message>, C_UmuKbn, C_SyorikekkaKbn, C_SikinouModeIdKbn)}
            テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SateiKekkaNyuuryokuChkTest_exec extends AbstractTest{

    @Inject
    private SateiKekkaNyuuryokuChk sateiKekkaNyuuryokuChk;

    @Inject
    DefaultMessageManager defaultMessageManager;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_査定結果入力チェック";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzGetProcessSummaryMockForSiharai.caller = SateiKekkaNyuuryokuChkTest_exec.class;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SateiKekkaNyuuryokuChkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap,true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        baseDomManager.delete(baseDomManager.getAllSosikis());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSiharai.caller = null;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();

    }
    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = null;
        JT_SkKihon pSkKihon = null;
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = null;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                null, null, pSikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pCommonViewUiBeanParam'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        JT_SkKihon pSkKihon = null;
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = null;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                null, null, pSikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pSkKihon'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = null;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                null, null, pSikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pSikinouModeIdKbn'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_A4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn =  C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }
    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_B1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("7");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "一般判定点数合計を正しく入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_B2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("21");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(60)
    public void testExec_B3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl2();
        ((SiToriatukaifuryouParam) pCommonViewUiBeanParam).setTratkihuryouumukbn(null);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "取扱不良有無区分が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_B4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl2();
        ((SiToriatukaifuryouParam) pCommonViewUiBeanParam).setTratkihuryouumukbn(C_NoinitUmuKbn.ARI);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void testExec_B5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl3();
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setBengosikenkaiumukbn(null);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKujyouumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setJimumissumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.YOU);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "その他チェック項目が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(90)
    public void testExec_B6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl3();
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKujyouumukbn(null);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setJimumissumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.YOU);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "その他チェック項目が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(100)
    public void testExec_B7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl3();
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKujyouumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setJimumissumukbn(null);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.YOU);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "その他チェック項目が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(110)
    public void testExec_B8() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl3();
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKujyouumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setJimumissumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKyhgksitukaisouyouhikbn(null);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "その他チェック項目が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(120)
    public void testExec_B9() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl3();
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKujyouumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setJimumissumukbn(C_NoinitUmuKbn.ARI);
        ((SiSonotaSateiSbParam) pCommonViewUiBeanParam).setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.YOU);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(130)
    public void testExec_B10() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("000");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "入力された支社コードが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(140)
    public void testExec_B11() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(170)
    public void testExec_B14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(180)
    public void testExec_B15() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(190)
    public void testExec_B16() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.DOUITU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "名義変更査定が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(200)
    public void testExec_B17() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "名義変更査定が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(210)
    public void testExec_B18() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(220)
    public void testExec_B19() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd(null);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.DOUITU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(230)
    public void testExec_B20() {
        changeSystemDate(BizDate.valueOf(20160507));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(30);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(240)
    public void testExec_B21() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数は入力できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(250)
    public void testExec_B22() {
        changeSystemDate(BizDate.valueOf(20160408));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(null);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(260)
    public void testExec_B23() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(280)
    public void testExec_B25() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(290)
    public void testExec_B26() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

    }

    @Test
    @TestOrder(300)
    public void testExec_B27() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd(null);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(310)
    public void testExec_B28() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "折衝要否が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(320)
    public void testExec_B29() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyouyhkbn(C_YouhiblnkKbn.YOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_SNDJST);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(330)
    public void testExec_B30() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyouyhkbn(C_YouhiblnkKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "折衝要否が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(340)
    public void testExec_B31() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl9();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_JKT);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck1(false);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck2(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck3(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck4(true);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "重過失チェックが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(350)
    public void testExec_B32() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl9();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_JKT);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck1(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck2(false);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck3(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck4(true);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "重過失チェックが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(360)
    public void testExec_B33() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl9();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_JKT);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck1(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck2(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck3(false);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck4(true);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "重過失チェックが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(370)
    public void testExec_B34() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl9();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_JKT);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck1(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck2(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck3(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck4(false);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "重過失チェックが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(380)
    public void testExec_B35() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl9();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_JKT);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck1(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck2(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck3(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck4(true);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(390)
    public void testExec_B36() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl9();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_MMK);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck1(false);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck2(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck3(true);
        ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).setJuukasitucheck4(true);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(400)
    public void testExec_B37() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.NONE, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "災害保障がないため死亡S支払・災害非該当は選択できません", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(410)
    public void testExec_B38() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "非該当原因を正しく入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(420)
    public void testExec_B39() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(430)
    public void testExec_B40() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GH);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(440)
    public void testExec_B41() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_JJ);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(450)
    public void testExec_B42() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_SONOTA);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(460)
    public void testExec_B43() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_JKT);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(470)
    public void testExec_B44() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_SYK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(480)
    public void testExec_B45() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_MMK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(490)
    public void testExec_B46() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_SSN);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(500)
    public void testExec_B47() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_MENSEKI_SONOTA);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(510)
    public void testExec_B48() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "災害申出有無が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(520)
    public void testExec_B49() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "非該当原因を正しく入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(530)
    public void testExec_B50() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_SNDJST);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(540)
    public void testExec_B51() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_JNDJST);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(550)
    public void testExec_B52() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_TNDJST);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(560)
    public void testExec_B53() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KOI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(570)
    public void testExec_B54() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SONOTA_MS);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(580)
    public void testExec_B55() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KAIJYO_JD);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(590)
    public void testExec_B56() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KAIJYO_SONOTA);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(600)
    public void testExec_B57() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MUKOU_SG);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(610)
    public void testExec_B58() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MUKOU_HHST);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(620)
    public void testExec_B59() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.ARI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MUKOU_SONOTA);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(630)
    public void testExec_B60() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(640)
    public void testExec_B61() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("7");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "一般判定点数合計を正しく入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(650)
    public void testExec_B62() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("7");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "一般判定点数合計を正しく入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(660)
    public void testExec_B63() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl2();
        ((SiToriatukaifuryouParam) pCommonViewUiBeanParam).setTratkihuryouumukbn(null);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "取扱不良有無区分が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(670)
    public void testExec_B64() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl2();
        ((SiToriatukaifuryouParam) pCommonViewUiBeanParam).setTratkihuryouumukbn(null);

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "取扱不良有無区分が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(680)
    public void testExec_B65() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.NONE, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "災害申出有無が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(685)
    public void testExec_B66() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSaigaimousideumukbn(C_BlnktkumuKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.NONE, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = BizLogicException.class)
    @TestOrder(686)
    public void testExec_B67() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.DOUITU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "名義変更査定が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(687)
    public void testExec_B68() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "名義変更査定が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(688)
    public void testExec_B69() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "名義変更査定が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(689)
    public void testExec_B70() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd(null);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.DOUITU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(690)
    public void testExec_B71() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl6();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "名義変更査定が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(690)
    public void testExec_C1() {
        changeSystemDate(BizDate.valueOf(20160507));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(30);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(700)
    public void testExec_C2() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数は入力できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(710)
    public void testExec_C3() {
        changeSystemDate(BizDate.valueOf(20160408));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(0);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(720)
    public void testExec_C4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(730)
    public void testExec_C5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(740)
    public void testExec_C6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(750)
    public void testExec_C7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(760)
    public void testExec_C8() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(770)
    public void testExec_C9() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd(null);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(780)
    public void testExec_C10() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(790)
    public void testExec_C11() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(800)
    public void testExec_C12() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(810)
    public void testExec_C13() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(820)
    public void testExec_C14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(830)
    public void testExec_C15() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(832)
    public void testExec_C16() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "不備発信中のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(832)
    public void testExec_C17() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
    }


    @Test
    @TestOrder(833)
    public void testExec_C18() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HORYUU);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(834)
    public void testExec_C19() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(835)
    public void testExec_C20() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        try{
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);

        }catch(Exception e){
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(836)
    public void testExec_C21() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.KAKUNIN);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(837)
    public void testExec_C22() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TYUUKANKAKUNIN);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(838)
    public void testExec_C23() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TUIKAKAKUNIN);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(839)
    public void testExec_C24() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SASIMODOSI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(840)
    public void testExec_D1() {
        changeSystemDate(BizDate.valueOf(20160507));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(30);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(850)
    public void testExec_D2() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数は入力できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(860)
    public void testExec_D3() {
        changeSystemDate(BizDate.valueOf(20160408));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(0);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(870)
    public void testExec_D4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(880)
    public void testExec_D5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(890)
    public void testExec_D6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(900)
    public void testExec_D7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(910)
    public void testExec_D8() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }



    @Test
    @TestOrder(960)
    public void testExec_D13() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(970)
    public void testExec_D14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(980)
    public void testExec_D15() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(990)
    public void testExec_D16() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1000)
    public void testExec_D17() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SASIMODOSI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1010)
    public void testExec_D18() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1015)
    public void testExec_D19() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }



    @Test(expected = BizLogicException.class)
    @TestOrder(1020)
    public void testExec_E1() {
        changeSystemDate(BizDate.valueOf(20160408));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(30);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1030)
    public void testExec_E2() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数は入力できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1040)
    public void testExec_E3() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(0);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1050)
    public void testExec_E4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1060)
    public void testExec_E5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1070)
    public void testExec_E6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1080)
    public void testExec_E7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1090)
    public void testExec_E8() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1100)
    public void testExec_E9() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setTennousakisousasyacd(null);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1110)
    public void testExec_E10() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1120)
    public void testExec_E11() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "査定結果が査定１次と異なります。変更する場合は差戻しを選択してください。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1130)
    public void testExec_E12() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1140)
    public void testExec_E13() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1150)
    public void testExec_E14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SASIMODOSI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1160)
    public void testExec_E15() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = BizLogicException.class)
    @TestOrder(1165)
    public void testExec_E16() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1170)
    public void testExec_F1() {
        changeSystemDate(BizDate.valueOf(20160507));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(30);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1180)
    public void testExec_F2() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数は入力できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1190)
    public void testExec_F3() {
        changeSystemDate(BizDate.valueOf(20160408));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(0);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1200)
    public void testExec_F4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1210)
    public void testExec_F5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1220)
    public void testExec_F6() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SYOUNIN);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1230)
    public void testExec_F7() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "不備発信中のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1240)
    public void testExec_F8() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.HORYUU);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1250)
    public void testExec_F9() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1260)
    public void testExec_F10() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SYOUNIN);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "sihubisibou", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "80000000026", "証券番号");
        exNumericEquals(bzGetProcessSummaryInBean.getSkNos().length, 1, "請求番号のサイズ");
        exStringEquals(bzGetProcessSummaryInBean.getSkNos()[0], "000000000000000010", "請求番号");
        exNumericEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss().length, 1, "工程管理状況のサイズ");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getSubSystemId(), "siharai", "サブシステムID");
    }

    @Test
    @TestOrder(1270)
    public void testExec_F11() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1280)
    public void testExec_F12() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1286)
    public void testExec_F13() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.HUBIKANRI);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

    }


    @Test(expected = BizLogicException.class)
    @TestOrder(1288)
    public void testExec_F14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1289)
    public void testExec_F15() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.HUSYOUNIN);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

    }


    @Test(expected = BizLogicException.class)
    @TestOrder(1290)
    public void testExec_G1() {
        changeSystemDate(BizDate.valueOf(20160507));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(30);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数が不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1300)
    public void testExec_G2() {
        changeSystemDate(BizDate.valueOf(20160409));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(1);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "中断日数は入力できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1310)
    public void testExec_G3() {
        changeSystemDate(BizDate.valueOf(20160408));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl7();
        ((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).setDispsyoruiukeymd(BizDate.valueOf(20160408));
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setRikoukityuutuudannissuu(0);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1320)
    public void testExec_G4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1330)
    public void testExec_G5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1340)
    public void testExec_G6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SYOUNIN);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1350)
    public void testExec_G7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1360)
    public void testExec_G8() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SIHARAI);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "不備発信中のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1370)
    public void testExec_G9() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.HORYUU);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1380)
    public void testExec_G10() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1390)
    public void testExec_G11() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SYOUNIN);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSiharai.class, "exec", 0, 0);

        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "sihubisibou", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean.getSyoNo(), "80000000026", "証券番号");
        exNumericEquals(bzGetProcessSummaryInBean.getSkNos().length, 1, "請求番号のサイズ");
        exStringEquals(bzGetProcessSummaryInBean.getSkNos()[0], "000000000000000010", "請求番号");
        exNumericEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss().length, 1, "工程管理状況のサイズ");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getSubSystemId(), "siharai", "サブシステムID");
    }

    @Test
    @TestOrder(1400)
    public void testExec_G12() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1410)
    public void testExec_G13() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "エラーを解消してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1415)
    public void testExec_G14() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.HUBIKANRI);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

    }


    @Test(expected = BizLogicException.class)
    @TestOrder(1416)
    public void testExec_G15() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "T000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1417)
    public void testExec_G16() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.SATEI_SIJI);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd(null);

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");
        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSkno("000000000000000010");

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1420)
    public void testExec_H1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1430)
    public void testExec_H2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1440)
    public void testExec_H3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1450)
    public void testExec_H4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1455)
    public void testExec_H5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1460)
    public void testExec_I1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1470)
    public void testExec_I2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1480)
    public void testExec_I3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1490)
    public void testExec_I4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1495)
    public void testExec_I5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1500)
    public void testExec_J1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1510)
    public void testExec_J2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1520)
    public void testExec_J3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1530)
    public void testExec_J4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1510)
    public void testExec_J5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU1;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1540)
    public void testExec_K1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1550)
    public void testExec_K2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU_TENKEN_1);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "転送先の入力は不要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1560)
    public void testExec_K3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1570)
    public void testExec_K4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU2;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1550)
    public void testExec_K5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateitennousakisousasyacd("test");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU2;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1580)
    public void testExec_L1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(null);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "解決日が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1590)
    public void testExec_L2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1600)
    public void testExec_L3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1610)
    public void testExec_L4() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_SNDJST);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1620)
    public void testExec_L5() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_JNDJST);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1630)
    public void testExec_L6() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_TNDJST);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1640)
    public void testExec_L7() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KOI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1650)
    public void testExec_L8() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SONOTA_MS);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1660)
    public void testExec_L9() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KAIJYO_JD);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1670)
    public void testExec_L10() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("99806001010");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KAIJYO_SONOTA);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "契約取消後に解決入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1680)
    public void testExec_L11() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("99806001021");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MUKOU_SONOTA);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm = (KeiyakuPrm) MockObjectManager.getArgument(KeiyakuInfoSyutoku.class, "getInfos", 0, 0);

        exStringEquals(keiyakuPrm.getSyono(), "99806001021", "証券番号");
        exBooleanEquals(keiyakuPrm.isNayose(), false, "名寄せ要否");
    }

    @Test
    @TestOrder(1690)
    public void testExec_L12() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SONOTAHG);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

    }

    @TestOrder(1700)
    @Test(expected = BizLogicException.class)
    public void testExec_L13() {
        changeSystemDate(BizDate.valueOf(20161230));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20161231));
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "解決日が先日付のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1705)
    public void testExec_L14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20161231));
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1710)
    public void testExec_M1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(null);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "解決日が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1720)
    public void testExec_M2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test
    @TestOrder(1730)
    public void testExec_M3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl8();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1740)
    public void testExec_M4() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_SNDJST);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1750)
    public void testExec_M5() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_JNDJST);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1760)
    public void testExec_M6() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MENSEKI_TNDJST);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1770)
    public void testExec_M7() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KOI);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1780)
    public void testExec_M8() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SONOTA_MS);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1790)
    public void testExec_M9() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KAIJYO_JD);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "処理可能な契約が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1800)
    public void testExec_M10() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("99806001010");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.KAIJYO_SONOTA);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "契約取消後に解決入力してください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1810)
    public void testExec_M11() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("99806001021");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.MUKOU_SONOTA);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm = (KeiyakuPrm) MockObjectManager.getArgument(KeiyakuInfoSyutoku.class, "getInfos", 0, 0);

        exStringEquals(keiyakuPrm.getSyono(), "99806001021", "証券番号");
        exBooleanEquals(keiyakuPrm.isNayose(), false, "名寄せ要否");
    }

    @Test
    @TestOrder(1820)
    public void testExec_M12() {
        MockObjectManager.initialize();

        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl11();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20160101));

        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).setSyono("80000000026");

        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SONOTAHG);

        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(1830)
    public void testExec_M13() {
        changeSystemDate(BizDate.valueOf(20161230));
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.KANRYOU);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20161231));
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "解決日が先日付のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = BizLogicException.class)
    @TestOrder(1835)
    public void testExec_M14() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).setKaiketuymd(BizDate.valueOf(20161231));
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }
    @Test
    @TestOrder(1840)
    public void testExec_N1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.KAKUNINIRAITYUU;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }
    @Test(expected = BizLogicException.class)
    @TestOrder(1845)
    public void testExec_N2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl5();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKANRITYUU;

        try {
            sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
                C_UmuKbn.ARI, null, pSikinouModeIdKbn);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "結果が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(1850)
    public void testExec_O1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("21");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)), "確認登録が必要です。",
            "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1860)
    public void testExec_O2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("21");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)), "確認登録が必要です。",
            "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1870)
    public void testExec_O3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("21");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)), "確認登録が必要です。",
            "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1880)
    public void testExec_O4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("3");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("21");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)), "確認登録が必要です。",
            "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1890)
    public void testExec_O5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("7");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");
    }

    @Test
    @TestOrder(1900)
    public void testExec_O6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("4");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("10");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");
    }

    @Test
    @TestOrder(1910)
    public void testExec_O7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("5");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("11");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)), "確認登録が必要です。",
            "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1920)
    public void testExec_O8() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("12");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

    }

    @Test
    @TestOrder(1921)
    public void testExec_O9() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("2");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("1");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("6");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("12");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");

    }

    @Test
    @TestOrder(1930)
    public void testExec_P1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setKakninumukbn(C_UmuKbn.ARI);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "確認登録経緯あり。延伸区分を確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1940)
    public void testExec_P2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setKakninumukbn(C_UmuKbn.ARI);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "確認登録経緯あり。延伸区分を確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1950)
    public void testExec_P3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setKakninumukbn(C_UmuKbn.ARI);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "確認登録経緯あり。延伸区分を確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1960)
    public void testExec_P4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setKakninumukbn(C_UmuKbn.ARI);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "確認登録経緯あり。延伸区分を確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1970)
    public void testExec_P5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setKakninumukbn(C_UmuKbn.NONE);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");
    }

    @Test
    @TestOrder(1971)
    public void testExec_P6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setKakninumukbn(C_UmuKbn.ARI);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SYOUNIN_SATEIYOU;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");

    }

    @Test
    @TestOrder(1980)
    public void testExec_Q1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(1990)
    public void testExec_Q2() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2000)
    public void testExec_Q3() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2010)
    public void testExec_Q4() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIHARAI);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIHARAI, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2020)
    public void testExec_Q5() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.HUSIHARAI);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.HUSIHARAI, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");
    }

    @Test
    @TestOrder(2021)
    public void testExec_Q6() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl4();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2022)
    public void testExec_Q7() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI2;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2023)
    public void testExec_Q8() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI3;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2024)
    public void testExec_Q9() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI4;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 1, "一覧用ワーニングメッセージリストサーズ");

        exStringEquals(String.valueOf(defaultMessageManager.getConversationMessages().get(0)),
            "免責期間内の自殺ですが支払いで問題ないか確認してください。", "一覧用ワーニングメッセージ");
    }

    @Test
    @TestOrder(2025)
    public void testExec_Q10() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl10();
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSyorikekkakbn(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU);
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setSessyousisyacd("111");
        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).setHushrgeninkbn(C_HushrGeninKbn.SAI_GR);
        JT_SkKihon pSkKihon = new JT_SkKihon();
        pSkKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        List<ChkKekkaBean> pSkNaiyouChkKbnList = new ArrayList<>();
        ChkKekkaBean pChkKekkaBean = new ChkKekkaBean();
        pChkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
        pSkNaiyouChkKbnList.add(pChkKekkaBean);
        List<Message> pMessageList = new ArrayList<>();
        pMessageList.add(new Message(0, "", "0000001", 0, null, null));
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SESSYOU1;

        defaultMessageManager.clear();

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU, pSikinouModeIdKbn);

        exNumericEquals(defaultMessageManager.getConversationMessages().size(), 0, "一覧用ワーニングメッセージリストサーズ");

    }

    @Test
    @TestOrder(2030)
    public void testExec_R1() {
        CommonViewUiBeanParam pCommonViewUiBeanParam = new CommonViewUiBeanParamImpl1();
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu1("");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu2("");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu3("");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu4("");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu5("");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuu6("");
        ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).setIppanhanteitensuugoukei("");
        JT_SkKihon pSkKihon = new JT_SkKihon();
        List<ChkKekkaBean> pSkNaiyouChkKbnList = null;
        List<Message> pMessageList = null;
        C_SikinouModeIdKbn pSikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        sateiKekkaNyuuryokuChk.exec(pCommonViewUiBeanParam, pSkKihon, pSkNaiyouChkKbnList, pMessageList,
            C_UmuKbn.ARI, null, pSikinouModeIdKbn);
    }
}
