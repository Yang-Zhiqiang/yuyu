package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMockForSiharai;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutokuMockForSiharai;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 請求内容チェックメイン（死亡）クラスのメソッド {@link CheckSbSkNaiyou#exec(CheckSbSkNaiyouParam, String, C_SikinouModeIdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckSbSkNaiyouTest_exec {

    private final static String syoNo1 = "17809000023";

    private final static String syoNo2 = "17809000034";

    private final static String syoNo3 = "17809000045";

    private final static String syoNo4 = "17809000056";

    private final static String syoNo5 = "17809000067";

    private final static String syoNo6 = "17809000078";

    private final static String syoNo7 = "17809000104";

    private final static String syoNo8 = "17809000171";

    private final static String syoNo9 = "17809000126";

    private final static String syoNo10 = "17809000137";

    private final static String syoNo11 = "17809000148";

    private final static String syoNo12 = "17809000159";

    private final static String syoNo13 = "17809000160";

    private final static String syoNo14 = "17809000089";

    private final static String syoNo15 = "17809000182";

    private final static String syoNo16 = "17809000090";

    private final static String syoNo17 = "17809000115";

    private final static String syoNo18 = "17809000182";

    private final static String syoNo19 = "11807111369";

    private final static String syoNo20 = "11807111370";

    private final static String syoNo21 = "11810111381";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_請求内容チェックメイン（死亡）";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckSbSkNaiyou checkSbSkNaiyou;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeiyakuInfoSyutoku.class).to(KeiyakuInfoSyutokuMockForSiharai.class);
                bind(ChkSubSksInfo.class).to(ChkSubSksInfoMockForSiharai.class);
                bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMockForSiharai.class);
                bind(ChkSubSksyaInfo.class).to(ChkSubSksyaInfoMockForSiharai.class);
                bind(ChkSubSinkensyaInfo.class).to(ChkSubSinkensyaInfoMockForSiharai.class);
                bind(ChkSubShskInfo.class).to(ChkSubShskInfoMockForSiharai.class);
                bind(ChkSubhassoKbn.class).to(ChkSubhassoKbnMockForSiharai.class);
                bind(ChkSubHonninkakunin.class).to(ChkSubHonninkakuninMockForSiharai.class);
                bind(ChkSubKijyunYmd.class).to(ChkSubKijyunYmdMockForSiharai.class);
                bind(ChkSubGeninKbn.class).to(ChkSubGeninKbnMockForSiharai.class);
                bind(ChkSubSyoumetu.class).to(ChkSubSyoumetuMockForSiharai.class);
                bind(ChkSubDoujiSeikyuuSyori.class).to(ChkSubDoujiSeikyuuSyoriMockForSiharai.class);
                bind(ChkSubKhSyorityuu.class).to(ChkSubKhSyorityuuMockForSiharai.class);
                bind(ChkSubMRFKouzaTratki.class).to(ChkSubMRFKouzaTratkiMockForSiharai.class);
                bind(SiSKNaiyouChkkekkaSettei.class).to(SiSKNaiyouChkkekkaSetteiMockForSiharai.class);
                bind(ChkSubSknnKaisiYmd.class).to(ChkSubSknnKaisiYmdMockForSiharai.class);
                bind(ChkSubHknKkn.class).to(ChkSubHknKknMockForSiharai.class);
                bind(ChkSubTtdktyuui.class).to(ChkSubTtdktyuuiMockForSiharai.class);
                bind(ChkSubUketorinin.class).to(ChkSubUketorininMockForSiharai.class);
                bind(ChkSubSinsaTyuui.class).to(ChkSubSinsaTyuuiMockForSiharai.class);
                bind(ChkSubMeigihenkou.class).to(ChkSubMeigihenkouMockForSiharai.class);
                bind(ChkSubHusyounosi.class).to(ChkSubHusyounosiMockForSiharai.class);
                bind(ChkSubKaigaiSb.class).to(ChkSubKaigaiSbMockForSiharai.class);
                bind(ChkSubHansya.class).to(ChkSubHansyaMockForSiharai.class);
                bind(SiSateiKmkChkkekkaSettei.class).to(SiSateiKmkChkkekkaSetteiMockForSiharai.class);
                bind(ChkSubJisatuMenseki.class).to(ChkSubJisatuMensekiMockForSiharai.class);
                bind(ChkSubSknnKaisiYmdSatei.class).to(ChkSubSknnKaisiYmdSateiMockForSiharai.class);
                bind(ChkSubStknset.class).to(ChkSubStknsetMockForSiharai.class);
                bind(ChkSubHasanTousan.class).to(ChkSubHasanTousanMockForSiharai.class);
                bind(ChkSubSasiosae.class).to(ChkSubSasiosaeMockForSiharai.class);
                bind(ChkSubSousasyoukai.class).to(ChkSubSousasyoukaiMockForSiharai.class);
                bind(ChkSubSkSyorui.class).to(ChkSubSkSyoruiMockForSiharai.class);
                bind(ChkSubUketoriHouhou.class).to(ChkSubUketoriHouhouMockForSiharai.class);
                bind(ChkSubSaigaiGaitou.class).to(ChkSubSaigaiGaitouMockForSiharai.class);
                bind(ChkSubSaikenInfo.class).to(ChkSubSaikenInfoMockForSiharai.class);
                bind(ChkSubSaisatei.class).to(ChkSubSaisateiMockForSiharai.class);
                bind(ChkSubSaikenKaiykMouside.class).to(ChkSubSaikenKaiykMousideMockForSiharai.class);
                bind(ChkSubSaisateiSatei.class).to(ChkSubSaisateiSateiMockForSiharai.class);
                bind(ChkSubKeiyakusyaHnk.class).to(ChkSubKeiyakusyaHnkMockForSiharai.class);
                bind(ChkSubDsKaiykSyori.class).to(ChkSubDsKaiykSyoriMockForSiharai.class);
                bind(ChkSubKykYmd.class).to(ChkSubKykYmdMockForSiharai.class);
                bind(ChkSubEndtHenkouYmd.class).to(ChkSubEndtHenkouYmdMockForSiharai.class);
                bind(ChkSubHnrkinMbr.class).to(ChkSubHnrkinMbrMockForSiharai.class);
                bind(ChkSubSgSbJisatuMenseki.class).to(ChkSubSgSbJisatuMensekiMockForSiharai.class);
                bind(ChkSubD.class).to(ChkSubDMockForSiharai.class);
                bind(ChkSubPHrkmYuuyokkn.class).to(ChkSubPHrkmYuuyokknMockForSiharai.class);
                bind(ChkSubTmttknJyoutai.class).to(ChkSubTmttknJyoutaiMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeiyakuInfoSyutokuMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSksInfoMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        BzSakuinTsnSyoukaiMqMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSksyaInfoMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSinkensyaInfoMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubShskInfoMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubhassoKbnMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubHonninkakuninMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubKijyunYmdMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubGeninKbnMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSyoumetuMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubDoujiSeikyuuSyoriMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubKhSyorityuuMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubMRFKouzaTratkiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubHknKknMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubTtdktyuuiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubUketorininMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSinsaTyuuiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubMeigihenkouMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubHusyounosiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubKaigaiSbMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubHansyaMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        SiSateiKmkChkkekkaSetteiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubJisatuMensekiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSknnKaisiYmdSateiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubStknsetMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubHasanTousanMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSasiosaeMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSousasyoukaiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSkSyoruiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubUketoriHouhouMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSaigaiGaitouMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSaikenInfoMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSaisateiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSaikenKaiykMousideMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSaisateiSateiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubKeiyakusyaHnkMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubDsKaiykSyoriMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubKykYmdMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubEndtHenkouYmdMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubHnrkinMbrMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubSgSbJisatuMensekiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubDMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubPHrkmYuuyokknMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;
        ChkSubTmttknJyoutaiMockForSiharai.caller = CheckSbSkNaiyouTest_exec.class;;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSbSkNaiyouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
        siharaiDomManager.delete(siharaiDomManager.getAllKyuuhu());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.caller = null;
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = null;
        ChkSubSksInfoMockForSiharai.caller = null;
        ChkSubSksInfoMockForSiharai.SYORIPTN = null;
        BzSakuinTsnSyoukaiMqMockForSiharai.caller = null;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = null;
        ChkSubSksyaInfoMockForSiharai.caller = null;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = null;
        ChkSubSinkensyaInfoMockForSiharai.caller = null;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = null;
        ChkSubShskInfoMockForSiharai.caller = null;
        ChkSubShskInfoMockForSiharai.SYORIPTN = null;
        ChkSubhassoKbnMockForSiharai.caller = null;
        ChkSubhassoKbnMockForSiharai.SYORIPTN = null;
        ChkSubHonninkakuninMockForSiharai.caller = null;
        ChkSubHonninkakuninMockForSiharai.SYORIPTN = null;
        ChkSubKijyunYmdMockForSiharai.caller = null;
        ChkSubKijyunYmdMockForSiharai.SYORIPTN = null;
        ChkSubGeninKbnMockForSiharai.caller = null;
        ChkSubGeninKbnMockForSiharai.SYORIPTN = null;
        ChkSubSyoumetuMockForSiharai.caller = null;
        ChkSubSyoumetuMockForSiharai.SYORIPTN = null;
        ChkSubDoujiSeikyuuSyoriMockForSiharai.caller = null;
        ChkSubDoujiSeikyuuSyoriMockForSiharai.SYORIPTN = null;
        ChkSubKhSyorityuuMockForSiharai.caller = null;
        ChkSubKhSyorityuuMockForSiharai.SYORIPTN = null;
        ChkSubMRFKouzaTratkiMockForSiharai.caller = null;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = null;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.caller = null;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = null;
        ChkSubSknnKaisiYmdMockForSiharai.caller = null;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = null;
        ChkSubHknKknMockForSiharai.caller = null;
        ChkSubHknKknMockForSiharai.SYORIPTN = null;
        ChkSubTtdktyuuiMockForSiharai.caller = null;
        ChkSubTtdktyuuiMockForSiharai.SYORIPTN = null;
        ChkSubUketorininMockForSiharai.caller = null;
        ChkSubUketorininMockForSiharai.SYORIPTN = null;
        ChkSubSinsaTyuuiMockForSiharai.caller = null;
        ChkSubSinsaTyuuiMockForSiharai.SYORIPTN = null;
        ChkSubMeigihenkouMockForSiharai.caller = null;
        ChkSubMeigihenkouMockForSiharai.SYORIPTN = null;
        ChkSubHusyounosiMockForSiharai.caller = null;
        ChkSubHusyounosiMockForSiharai.SYORIPTN = null;
        ChkSubKaigaiSbMockForSiharai.caller = null;
        ChkSubKaigaiSbMockForSiharai.SYORIPTN = null;
        ChkSubHansyaMockForSiharai.caller = null;
        ChkSubHansyaMockForSiharai.SYORIPTN = null;
        SiSateiKmkChkkekkaSetteiMockForSiharai.caller = null;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = null;
        ChkSubJisatuMensekiMockForSiharai.caller = null;
        ChkSubJisatuMensekiMockForSiharai.SYORIPTN = null;
        ChkSubSknnKaisiYmdSateiMockForSiharai.caller = null;
        ChkSubSknnKaisiYmdSateiMockForSiharai.SYORIPTN = null;
        ChkSubStknsetMockForSiharai.caller = null;
        ChkSubStknsetMockForSiharai.SYORIPTN = null;
        ChkSubHasanTousanMockForSiharai.caller = null;
        ChkSubHasanTousanMockForSiharai.SYORIPTN = null;
        ChkSubSasiosaeMockForSiharai.caller = null;
        ChkSubSasiosaeMockForSiharai.SYORIPTN = null;
        ChkSubSousasyoukaiMockForSiharai.caller = null;
        ChkSubSousasyoukaiMockForSiharai.SYORIPTN = null;
        ChkSubSkSyoruiMockForSiharai.caller = null;
        ChkSubSkSyoruiMockForSiharai.SYORIPTN = null;
        ChkSubUketoriHouhouMockForSiharai.caller = null;
        ChkSubUketoriHouhouMockForSiharai.SYORIPTN = null;
        ChkSubSaigaiGaitouMockForSiharai.caller = null;
        ChkSubSaigaiGaitouMockForSiharai.SYORIPTN = null;
        ChkSubSaikenInfoMockForSiharai.caller = null;
        ChkSubSaikenInfoMockForSiharai.SYORIPTN = null;
        ChkSubSaisateiMockForSiharai.caller = null;
        ChkSubSaisateiMockForSiharai.SYORIPTN = null;
        ChkSubSaikenKaiykMousideMockForSiharai.caller = null;
        ChkSubSaikenKaiykMousideMockForSiharai.SYORIPTN = null;
        ChkSubSaisateiSateiMockForSiharai.caller = null;
        ChkSubSaisateiSateiMockForSiharai.SYORIPTN = null;
        ChkSubKeiyakusyaHnkMockForSiharai.caller = null;
        ChkSubKeiyakusyaHnkMockForSiharai.SYORIPTN = null;
        ChkSubDsKaiykSyoriMockForSiharai.caller = null;
        ChkSubDsKaiykSyoriMockForSiharai.SYORIPTN = null;
        ChkSubKykYmdMockForSiharai.caller = null;
        ChkSubKykYmdMockForSiharai.SYORIPTN = null;
        ChkSubEndtHenkouYmdMockForSiharai.caller = null;
        ChkSubEndtHenkouYmdMockForSiharai.SYORIPTN = null;
        ChkSubHnrkinMbrMockForSiharai.caller = null;
        ChkSubHnrkinMbrMockForSiharai.SYORIPTN = null;
        ChkSubSgSbJisatuMensekiMockForSiharai.caller = null;
        ChkSubSgSbJisatuMensekiMockForSiharai.SYORIPTN = null;
        ChkSubDMockForSiharai.caller = null;
        ChkSubDMockForSiharai.SYORIPTN = null;
        ChkSubPHrkmYuuyokknMockForSiharai.caller = null;
        ChkSubPHrkmYuuyokknMockForSiharai.SYORIPTN = null;

    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        try {
            CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = null;
            String yobidasimotoKinouId = "CheckSbSkNaiyou";
            C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

            checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pCheckSbSkNaiyouParam'", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN1;
        try {
            CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector
                .getInstance(CheckSbSkNaiyouParamImpl.class);
            checkSbSkNaiyouParamImpl.setSyono("17809000012");
            String yobidasimotoKinouId = "CheckSbSkNaiyou";
            C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

            checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "テーブル取得エラー　JT_SiKykKihon　key:syono=17809000012", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN2;
        try {
            CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector
                .getInstance(CheckSbSkNaiyouParamImpl.class);
            checkSbSkNaiyouParamImpl.setSyono(syoNo1);
            String yobidasimotoKinouId = "CheckSbSkNaiyou";
            C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

            checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "テーブル取得エラー　JM_SiSyouhnZokusei　key:syouhncd=W101,kyhgndkatakbn=1,syouhnsdno=10", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubhassoKbnMockForSiharai.SYORIPTN = ChkSubhassoKbnMockForSiharai.TESTPATTERN1;
        ChkSubHonninkakuninMockForSiharai.SYORIPTN = ChkSubHonninkakuninMockForSiharai.TESTPATTERN1;
        ChkSubKijyunYmdMockForSiharai.SYORIPTN = ChkSubKijyunYmdMockForSiharai.TESTPATTERN1;
        ChkSubGeninKbnMockForSiharai.SYORIPTN = ChkSubGeninKbnMockForSiharai.TESTPATTERN1;
        ChkSubSyoumetuMockForSiharai.SYORIPTN = ChkSubSyoumetuMockForSiharai.TESTPATTERN1;
        ChkSubDoujiSeikyuuSyoriMockForSiharai.SYORIPTN = ChkSubDoujiSeikyuuSyoriMockForSiharai.TESTPATTERN1;
        ChkSubKhSyorityuuMockForSiharai.SYORIPTN = ChkSubKhSyorityuuMockForSiharai.TESTPATTERN1;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = SiSKNaiyouChkkekkaSetteiMockForSiharai.TESTPATTERN1;


        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo3);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("セイキュウシャ");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("請求者");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(BizDate.valueOf("20150101"));
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.MALE);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.SINKENSYA);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("123456");
        checkSbSkNaiyouParamImpl.setSitencd("789");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.HUTUU);
        checkSbSkNaiyouParamImpl.setKouzano("123456789");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.DOUITU);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("メイギ");
        checkSbSkNaiyouParamImpl.setSuketorihouhoukbn(C_SUketoriHouhouKbn.BLNK);
        checkSbSkNaiyouParamImpl.setShrdtlsyooutkbn(C_KanryotuutioutKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSihonninkakninkbn(C_SiHonninKakninKekkaKbn.KOUZA);
        checkSbSkNaiyouParamImpl.setSibouymd(null);
        checkSbSkNaiyouParamImpl.setGeninkbn(C_GeninKbn.BSSS);
        List<String> byoumeiTourokuNoList = new ArrayList<>();
        checkSbSkNaiyouParamImpl.setByoumeitourokunolist(byoumeiTourokuNoList);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon.setSkno("1111");
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.ERROR,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 54, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "010201", "警告メッセージ[0]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "", "警告メッセージ[1]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "", "警告メッセージ[2]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "", "警告メッセージ[3]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "", "警告メッセージ[4]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "", "警告メッセージ[5]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(6), "010301", "警告メッセージ[6]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(7), "", "警告メッセージ[7]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(8), "", "警告メッセージ[8]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(9), "", "警告メッセージ[9]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(10), "", "警告メッセージ[10]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(11), "", "警告メッセージ[11]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(12), "010401", "警告メッセージ[12]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(13), "", "警告メッセージ[13]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(14), "", "警告メッセージ[14]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(15), "", "警告メッセージ[15]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(16), "", "警告メッセージ[16]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(17), "", "警告メッセージ[17]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(18), "010601", "警告メッセージ[18]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(19), "", "警告メッセージ[19]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(20), "", "警告メッセージ[20]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(21), "", "警告メッセージ[21]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(22), "", "警告メッセージ[22]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(23), "", "警告メッセージ[23]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(24), "010801", "警告メッセージ[24]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(25), "", "警告メッセージ[25]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(26), "", "警告メッセージ[26]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(27), "", "警告メッセージ[27]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(28), "", "警告メッセージ[28]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(29), "", "警告メッセージ[29]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(30), "010901", "警告メッセージ[30]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(31), "", "警告メッセージ[31]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(32), "", "警告メッセージ[32]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(33), "", "警告メッセージ[33]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(34), "", "警告メッセージ[34]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(35), "", "警告メッセージ[35]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(36), "020101", "警告メッセージ[36]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(37), "消滅", "警告メッセージ[37]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(38), "", "警告メッセージ[38]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(39), "", "警告メッセージ[39]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(40), "", "警告メッセージ[40]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(41), "", "警告メッセージ[41]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(42), "020201", "警告メッセージ[42]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(43), "17809000023", "警告メッセージ[43]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(44), "", "警告メッセージ[44]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(45), "", "警告メッセージ[45]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(46), "", "警告メッセージ[46]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(47), "", "警告メッセージ[47]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(48), "020301", "警告メッセージ[48]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(49), "AAAA", "警告メッセージ[49]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(50), "", "警告メッセージ[50]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(51), "", "警告メッセージ[51]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(52), "", "警告メッセージ[52]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(53), "", "警告メッセージ[53]");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().size(), 1, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "010101", "メッセージID");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[0]), "", "メッセージ引数1");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[1]), "受取人本人", "メッセージ引数2");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[2]), "", "メッセージ引数3");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[3]), "", "メッセージ引数4");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[4]), "", "メッセージ引数5");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
        MockObjectManager
        .assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 0, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 1, "123456");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 2, "789");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 3, C_YokinKbn.HUTUU);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 4, "123456789");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 5, C_Kzdou.DOUITU);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 6, "メイギ");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 7, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 8, null);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 9, C_SeikyuusyaKbn.UKTHONNIN);


        MockObjectManager.assertArgumentPassed(ChkSubSksyaInfoMockForSiharai.class, "exec", 0, C_SeikyuusyaKbn.UKTHONNIN);
        MockObjectManager.assertArgumentPassed(ChkSubSksyaInfoMockForSiharai.class, "exec", 1, "セイキュウシャ");
        MockObjectManager.assertArgumentPassed(ChkSubSksyaInfoMockForSiharai.class, "exec", 2, "請求者");
        MockObjectManager.assertArgumentPassed(ChkSubSksyaInfoMockForSiharai.class, "exec", 3, BizDate.valueOf(20150101));
        MockObjectManager.assertArgumentPassed(ChkSubSksyaInfoMockForSiharai.class, "exec", 4, C_Seibetu.MALE);
        MockObjectManager.assertArgumentPassed(ChkSubSksyaInfoMockForSiharai.class, "exec", 5, C_SeikyuuSyubetu.SB);
        JT_SiKykKihon siKykKihon1 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubSksyaInfoMockForSiharai.class, "exec", 0, 6);
        exClassificationEquals(siKykKihon1.getNstkhkumu(), C_UmuKbn.NONE, "年金支払特約付加有無");
        exClassificationEquals(siKykKihon1.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU, "有効消滅区分");
        exStringEquals(siKykKihon1.getSyono(), "17809000045", "証券番号");
        exStringEquals(siKykKihon1.getTsinyno(), "", "通信先郵便番号");

        MockObjectManager.assertArgumentPassed(ChkSubSinkensyaInfoMockForSiharai.class, "exec", 0, "");
        MockObjectManager.assertArgumentPassed(ChkSubSinkensyaInfoMockForSiharai.class, "exec", 1, "");
        MockObjectManager.assertArgumentPassed(ChkSubSinkensyaInfoMockForSiharai.class, "exec", 2, C_SkskknsyubetuKbn.SINKENSYA);

        MockObjectManager.assertArgumentPassed(ChkSubShskInfoMockForSiharai.class, "exec", 0, C_SouhusakiKbn.TDADD);
        MockObjectManager.assertArgumentPassed(ChkSubShskInfoMockForSiharai.class, "exec", 1, "1234567");
        MockObjectManager.assertArgumentPassed(ChkSubShskInfoMockForSiharai.class, "exec", 2, "御御");
        MockObjectManager.assertArgumentPassed(ChkSubShskInfoMockForSiharai.class, "exec", 3, "御御御");
        MockObjectManager.assertArgumentPassed(ChkSubShskInfoMockForSiharai.class, "exec", 4, "御御御御");
        MockObjectManager.assertArgumentPassed(ChkSubShskInfoMockForSiharai.class, "exec", 5, "13888888888");

        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 0, null);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 1, null);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 2, null);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 3, null);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 4, C_Tkhukaumu.NONE);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 5, C_KanryotuutioutKbn.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 6, null);
        MockObjectManager.assertArgumentPassed(ChkSubhassoKbnMockForSiharai.class, "exec", 7, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);

        MockObjectManager.assertArgumentPassed(ChkSubHonninkakuninMockForSiharai.class, "exec", 0, C_SiHonninKakninKekkaKbn.KOUZA);
        MockObjectManager.assertArgumentPassed(ChkSubHonninkakuninMockForSiharai.class, "exec", 1, C_SUketoriHouhouKbn.BLNK);

        MockObjectManager.assertArgumentPassed(ChkSubKijyunYmdMockForSiharai.class, "exec", 0, null);
        MockObjectManager.assertArgumentPassed(ChkSubKijyunYmdMockForSiharai.class, "exec", 1, null);
        MockObjectManager.assertArgumentPassed(ChkSubKijyunYmdMockForSiharai.class, "exec", 2, null);
        MockObjectManager.assertArgumentPassed(ChkSubKijyunYmdMockForSiharai.class, "exec", 3, null);
        MockObjectManager.assertArgumentPassed(ChkSubKijyunYmdMockForSiharai.class, "exec", 4, "17809000045");

        MockObjectManager.assertArgumentPassed(ChkSubGeninKbnMockForSiharai.class, "exec", 0, C_GeninKbn.BSSS);
        List<String> byoumeiTourokuNoLst = (List<String>) MockObjectManager.getArgument(ChkSubGeninKbnMockForSiharai.class, "exec", 0, 1);
        exNumericEquals(byoumeiTourokuNoLst.size(), 0, "病名登録番号リストの件数");

        MockObjectManager.assertArgumentPassed(ChkSubSyoumetuMockForSiharai.class, "exec", 0, null);
        JT_SiKykKihon siKykKihon2 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubSyoumetuMockForSiharai.class, "exec", 0, 1);
        exClassificationEquals(siKykKihon2.getNstkhkumu(), C_UmuKbn.NONE, "年金支払特約付加有無");
        exClassificationEquals(siKykKihon2.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU, "有効消滅区分");
        exStringEquals(siKykKihon2.getSyono(), "17809000045", "証券番号");
        exStringEquals(siKykKihon2.getTsinyno(), "", "通信先郵便番号");

        JT_SkKihon skKihon2 = (JT_SkKihon) MockObjectManager.getArgument(ChkSubDoujiSeikyuuSyoriMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(skKihon2.getSeikyuusyubetu(), C_SeikyuuSyubetu.SB, "請求種別");
        exStringEquals(skKihon2.getSkno(), "1111", "請求番号");
        JT_SiKykKihon siKykKihon3 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubDoujiSeikyuuSyoriMockForSiharai.class, "exec", 0, 1);
        exClassificationEquals(siKykKihon3.getNstkhkumu(), C_UmuKbn.NONE, "年金支払特約付加有無");
        exClassificationEquals(siKykKihon3.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU, "有効消滅区分");
        exStringEquals(siKykKihon3.getSyono(), "17809000045", "証券番号");
        exStringEquals(siKykKihon3.getTsinyno(), "", "通信先郵便番号");

        JT_SiKykKihon siKykKihon4 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubKhSyorityuuMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(siKykKihon4.getNstkhkumu(), C_UmuKbn.NONE, "年金支払特約付加有無");
        exClassificationEquals(siKykKihon4.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU, "有効消滅区分");
        exStringEquals(siKykKihon4.getSyono(), "17809000045", "証券番号");
        exStringEquals(siKykKihon4.getTsinyno(), "", "通信先郵便番号");
        MockObjectManager.assertArgumentPassed(ChkSubKhSyorityuuMockForSiharai.class, "exec", 1, "CheckSbSkNaiyou");

        MockObjectManager.assertArgumentPassed(ChkSubMRFKouzaTratkiMockForSiharai.class, "exec", 0, "");

        MockObjectManager.assertArgumentPassed(SiSKNaiyouChkkekkaSetteiMockForSiharai.class, "exec", 0, C_SeikyuuSyubetu.SB);
        MockObjectManager.assertArgumentPassed(SiSKNaiyouChkkekkaSetteiMockForSiharai.class, "exec", 1, "CheckSbSkNaiyou");
        MockObjectManager.assertArgumentPassed(SiSKNaiyouChkkekkaSetteiMockForSiharai.class, "exec", 2, C_SikinouModeIdKbn.HUBIKAITOUMATI);
        MockObjectManager.assertArgumentPassed(SiSKNaiyouChkkekkaSetteiMockForSiharai.class, "exec", 4, null);
        MockObjectManager.assertArgumentPassed(SiSKNaiyouChkkekkaSetteiMockForSiharai.class, "exec", 5, null);
        MockObjectManager.assertArgumentPassed(SiSKNaiyouChkkekkaSetteiMockForSiharai.class, "exec", 6, null);

    }

    @Test
    @TestOrder(50)
    public void testExec_B2() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN4;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = SiSKNaiyouChkkekkaSetteiMockForSiharai.TESTPATTERN2;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo4);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20150505"));
        checkSbSkNaiyouParamImpl.setSiharaituukakbn(C_SiharaiTuukaKbn.YENSIHARAI);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.ERROR,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "020401", "メッセージID");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[0]), "復活責任開始日", "メッセージ引数1");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[1]), "", "メッセージ引数2");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[2]), "", "メッセージ引数3");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[3]), "", "メッセージ引数4");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[4]), "", "メッセージ引数5");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
        MockObjectManager
        .assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 0, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 1, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 2, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 3, C_YokinKbn.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 4, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 5, C_Kzdou.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 6, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 7, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 8, "かかＡ");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 9, C_SeikyuusyaKbn.UKTHONNIN);

        MockObjectManager.assertArgumentPassed(ChkSubSknnKaisiYmdMockForSiharai.class, "exec", 0, BizDate.valueOf(20150505));
        MockObjectManager.assertArgumentPassed(ChkSubSknnKaisiYmdMockForSiharai.class, "exec", 1, BizDate.valueOf(20150506));
        JT_SiKykSyouhn siKykSyouhn = (JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubSknnKaisiYmdMockForSiharai.class, "exec", 0, 2);
        exDateEquals(siKykSyouhn.getSknnkaisiymd(), BizDate.valueOf(20150503), "責任開始日");

    }

    @Test
    @TestOrder(60)
    public void testExec_B3() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN5;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = SiSKNaiyouChkkekkaSetteiMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo14);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20150505"));
        checkSbSkNaiyouParamImpl.setSiharaituukakbn(C_SiharaiTuukaKbn.GAIKASIHARAI);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.ERROR,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 1, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0).getMessageId(),
            "020401", "メッセージID");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[0]), "責任開始日", "メッセージ引数1");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[1]), "", "メッセージ引数2");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[2]), "", "メッセージ引数3");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[3]), "", "メッセージ引数4");
        exStringEquals(String.valueOf(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().get(0)
            .getMessageArgs()[4]), "", "メッセージ引数5");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
        MockObjectManager
        .assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 0, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 1, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 2, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 3, C_YokinKbn.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 4, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 5, C_Kzdou.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 6, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 7, C_Tuukasyu.USD);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 8, "かかＡ");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 9, C_SeikyuusyaKbn.UKTHONNIN);
    }

    @Test
    @TestOrder(70)
    public void testExec_B4() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN1;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubHonninkakuninMockForSiharai.SYORIPTN = ChkSubHonninkakuninMockForSiharai.TESTPATTERN2;
        ChkSubHknKknMockForSiharai.SYORIPTN = ChkSubHknKknMockForSiharai.TESTPATTERN1;
        ChkSubTtdktyuuiMockForSiharai.SYORIPTN = ChkSubTtdktyuuiMockForSiharai.TESTPATTERN1;
        ChkSubUketorininMockForSiharai.SYORIPTN = ChkSubUketorininMockForSiharai.TESTPATTERN1;
        ChkSubSinsaTyuuiMockForSiharai.SYORIPTN = ChkSubSinsaTyuuiMockForSiharai.TESTPATTERN1;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = SiSKNaiyouChkkekkaSetteiMockForSiharai.TESTPATTERN4;
        ChkSubMeigihenkouMockForSiharai.SYORIPTN = ChkSubMeigihenkouMockForSiharai.TESTPATTERN1;
        ChkSubHusyounosiMockForSiharai.SYORIPTN = ChkSubHusyounosiMockForSiharai.TESTPATTERN1;
        ChkSubKaigaiSbMockForSiharai.SYORIPTN = ChkSubKaigaiSbMockForSiharai.TESTPATTERN1;
        ChkSubHansyaMockForSiharai.SYORIPTN = ChkSubHansyaMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo5);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTDAIHYOU);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("セイキュウシャ");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("AAA");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(BizDate.valueOf("20160301"));
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.MALE);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("御御御御御");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.SINKENSYA);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSuketorihouhoukbn(C_SUketoriHouhouKbn.ZENGAKU_NENKIN);
        checkSbSkNaiyouParamImpl.setSihonninkakninkbn(C_SiHonninKakninKekkaKbn.KOUZA);
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20151118"));
        checkSbSkNaiyouParamImpl.setSateikakmeigihnkkbn(C_YouhiKbn.YOU);
        checkSbSkNaiyouParamImpl.setSateikakhusyousikbn(C_UmuKbn.ARI);
        List<String> byoumeiTourokuNoList = new ArrayList<>();
        String byoumeiTourokuNo = "100001";
        byoumeiTourokuNoList.add(byoumeiTourokuNo);
        checkSbSkNaiyouParamImpl.setByoumeitourokunolist(byoumeiTourokuNoList);
        checkSbSkNaiyouParamImpl.setGeninkbn(C_GeninKbn.FSS);
        checkSbSkNaiyouParamImpl.setSateikakkaigaisbkbn(C_UmuKbn.ARI);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon.setSkno("SK004");
        skKihon.setSyono("11810111118");
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 36, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "010201", "警告メッセージ[0]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "", "警告メッセージ[1]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "", "警告メッセージ[2]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "", "警告メッセージ[3]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "", "警告メッセージ[4]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "", "警告メッセージ[5]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(6), "010701", "警告メッセージ[6]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(7), "", "警告メッセージ[7]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(8), "", "警告メッセージ[8]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(9), "", "警告メッセージ[9]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(10), "", "警告メッセージ[10]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(11), "", "警告メッセージ[11]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(12), "020501", "警告メッセージ[12]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(13), "", "警告メッセージ[13]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(14), "", "警告メッセージ[14]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(15), "", "警告メッセージ[15]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(16), "", "警告メッセージ[16]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(17), "", "警告メッセージ[17]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(18), "021101", "警告メッセージ[18]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(19), "", "警告メッセージ[19]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(20), "", "警告メッセージ[20]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(21), "", "警告メッセージ[21]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(22), "", "警告メッセージ[22]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(23), "", "警告メッセージ[23]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(24), "021201", "警告メッセージ[24]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(25), "", "警告メッセージ[25]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(26), "", "警告メッセージ[26]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(27), "", "警告メッセージ[27]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(28), "", "警告メッセージ[28]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(29), "", "警告メッセージ[29]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(30), "021401", "警告メッセージ[30]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(31), "", "警告メッセージ[31]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(32), "", "警告メッセージ[32]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(33), "", "警告メッセージ[33]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(34), "", "警告メッセージ[34]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(35), "", "警告メッセージ[35]");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 4, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_HUSYOU_BYOUMEI, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(2).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_KAIGAISIBOU, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(2).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(3).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_HANSYA, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(3).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(3).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "名義変更査定要,不詳の死,海外死亡,反社", "査定項目メッセージ");

        MockObjectManager.assertArgumentPassed(ChkSubHknKknMockForSiharai.class, "exec", 0, BizDate.valueOf(20151118));
        JT_SiKykSyouhn siKykSyouhn2 = (JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubHknKknMockForSiharai.class, "exec", 0, 1);
        exDateEquals(siKykSyouhn2.getHknkknmanryouymd(), BizDate.valueOf(20151117), "保険期間満了日");
        exClassificationEquals(siKykSyouhn2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");

        JT_SiKykKihon siKykKihon1 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubTtdktyuuiMockForSiharai.class, "exec", 0, 0);
        exStringEquals(siKykKihon1.getTsinyno(), "1234567", "通信先郵便番号");
        exClassificationEquals(siKykKihon1.getTtdktyuuikbn1(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分１");
        exClassificationEquals(siKykKihon1.getTtdktyuuikbn2(), C_TtdktyuuiKbn.BLNK, "手続注意区分２");
        exClassificationEquals(siKykKihon1.getTtdktyuuikbn3(), C_TtdktyuuiKbn.BLNK, "手続注意区分３");
        exClassificationEquals(siKykKihon1.getTtdktyuuikbn4(), C_TtdktyuuiKbn.BLNK, "手続注意区分４");
        exClassificationEquals(siKykKihon1.getTtdktyuuikbn5(), C_TtdktyuuiKbn.BLNK, "手続注意区分５");
        exStringEquals(siKykKihon1.getKyknmkn(), "カナ", "契約者名（カナ）");

        MockObjectManager.assertArgumentPassed(ChkSubUketorininMockForSiharai.class, "exec", 0, C_SeikyuusyaKbn.UKTDAIHYOU);
        MockObjectManager.assertArgumentPassed(ChkSubUketorininMockForSiharai.class, "exec", 1, "セイキュウシャ");
        JT_SiKykKihon siKykKihon2 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubUketorininMockForSiharai.class, "exec", 0, 2);
        exStringEquals(siKykKihon2.getTsinyno(), "1234567", "通信先郵便番号");
        exClassificationEquals(siKykKihon2.getTtdktyuuikbn1(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分１");
        exClassificationEquals(siKykKihon2.getTtdktyuuikbn2(), C_TtdktyuuiKbn.BLNK, "手続注意区分２");
        exClassificationEquals(siKykKihon2.getTtdktyuuikbn3(), C_TtdktyuuiKbn.BLNK, "手続注意区分３");
        exClassificationEquals(siKykKihon2.getTtdktyuuikbn4(), C_TtdktyuuiKbn.BLNK, "手続注意区分４");
        exClassificationEquals(siKykKihon2.getTtdktyuuikbn5(), C_TtdktyuuiKbn.BLNK, "手続注意区分５");
        exStringEquals(siKykKihon2.getKyknmkn(), "カナ", "契約者名（カナ）");

        MockObjectManager.assertArgumentPassed(ChkSubSinsaTyuuiMockForSiharai.class, "exec", 0, "17809000067");

        MockObjectManager.assertArgumentPassed(ChkSubMeigihenkouMockForSiharai.class, "exec", 0, BizDate.valueOf(20151118));
        MockObjectManager.assertArgumentPassed(ChkSubMeigihenkouMockForSiharai.class, "exec", 1, C_SeikyuuSyubetu.SB);
        MockObjectManager.assertArgumentPassed(ChkSubMeigihenkouMockForSiharai.class, "exec", 2, C_YouhiKbn.YOU);
        JT_SiKykKihon siKykKihon3 = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubMeigihenkouMockForSiharai.class, "exec", 0, 3);
        exStringEquals(siKykKihon3.getTsinyno(), "1234567", "通信先郵便番号");
        exClassificationEquals(siKykKihon3.getTtdktyuuikbn1(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "手続注意区分１");
        exClassificationEquals(siKykKihon3.getTtdktyuuikbn2(), C_TtdktyuuiKbn.BLNK, "手続注意区分２");
        exClassificationEquals(siKykKihon3.getTtdktyuuikbn3(), C_TtdktyuuiKbn.BLNK, "手続注意区分３");
        exClassificationEquals(siKykKihon3.getTtdktyuuikbn4(), C_TtdktyuuiKbn.BLNK, "手続注意区分４");
        exClassificationEquals(siKykKihon3.getTtdktyuuikbn5(), C_TtdktyuuiKbn.BLNK, "手続注意区分５");
        exStringEquals(siKykKihon3.getKyknmkn(), "カナ", "契約者名（カナ）");

        List<String> byoumeiTourokuNoLst = (List<String>) MockObjectManager.getArgument(ChkSubHusyounosiMockForSiharai.class, "exec", 0, 0);
        exStringEquals(byoumeiTourokuNoLst.get(0), "100001", "病名登録番号");
        MockObjectManager.assertArgumentPassed(ChkSubHusyounosiMockForSiharai.class, "exec", 1, C_GeninKbn.FSS);
        MockObjectManager.assertArgumentPassed(ChkSubHusyounosiMockForSiharai.class, "exec", 2, C_UmuKbn.ARI);

        MockObjectManager.assertArgumentPassed(ChkSubKaigaiSbMockForSiharai.class, "exec", 0, C_UmuKbn.ARI);

        MockObjectManager.assertArgumentPassed(ChkSubHansyaMockForSiharai.class, "exec", 0, C_SeikyuuSyubetu.SB);
        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = (BzSakuinTsnSyoukaiKekkaBean) MockObjectManager.getArgument(ChkSubHansyaMockForSiharai.class, "exec", 0, 1);
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報有無区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn(), C_PalSyoukaiJissiumuKbn.ARI, "ＰＡＬあて照会実施有無区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIOK, "新選択情報反社照会エラー区分");
        exClassificationEquals(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");

        MockObjectManager.assertArgumentPassed(SiSateiKmkChkkekkaSetteiMockForSiharai.class, "exec", 0, C_SeikyuuSyubetu.SB);
        MockObjectManager.assertArgumentPassed(SiSateiKmkChkkekkaSetteiMockForSiharai.class, "exec", 1, "CheckSbSkNaiyou");
        MockObjectManager.assertArgumentPassed(SiSateiKmkChkkekkaSetteiMockForSiharai.class, "exec", 2, C_SikinouModeIdKbn.HUBIKAITOUMATI);
        MockObjectManager.assertArgumentPassed(SiSateiKmkChkkekkaSetteiMockForSiharai.class, "exec", 4, null);

    }

    @Test
    @TestOrder(80)
    public void testExec_B5() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN6;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubJisatuMensekiMockForSiharai.SYORIPTN = ChkSubJisatuMensekiMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN2;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo6);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("アイウ");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.MALE);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20150504"));
        checkSbSkNaiyouParamImpl.setGeninkbn(C_GeninKbn.JS);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "免責期間中の自殺", "査定項目メッセージ");
        MockObjectManager
        .assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 0, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 1, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 2, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 3, C_YokinKbn.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 4, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 5, C_Kzdou.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 6, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 7, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 8, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 9, C_SeikyuusyaKbn.UKTHONNIN);

        MockObjectManager.assertArgumentPassed(ChkSubJisatuMensekiMockForSiharai.class, "exec", 0, BizDate.valueOf(20150504));
        MockObjectManager.assertArgumentPassed(ChkSubJisatuMensekiMockForSiharai.class, "exec", 1, C_GeninKbn.JS);
        MockObjectManager.assertArgumentPassed(ChkSubJisatuMensekiMockForSiharai.class, "exec", 2, null);
        JT_SiKykSyouhn siKykSyouhn = (JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubJisatuMensekiMockForSiharai.class, "exec", 0, 3);
        exDateEquals(siKykSyouhn.getSknnkaisiymd(), BizDate.valueOf(20130505), "責任開始日");
        JM_SiSyouhnZokusei siSyouhnZokusei = (JM_SiSyouhnZokusei) MockObjectManager.getArgument(ChkSubJisatuMensekiMockForSiharai.class, "exec", 0, 4);
        exNumericEquals(siSyouhnZokusei.getJisatumensekinensuu(), 2, "自殺免責年数");

    }

    @Test
    @TestOrder(90)
    public void testExec_B6() {
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN7;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubJisatuMensekiMockForSiharai.SYORIPTN = ChkSubJisatuMensekiMockForSiharai.TESTPATTERN2;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN2;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo16);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.STDR);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("アイウ");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.MALE);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20150504"));
        checkSbSkNaiyouParamImpl.setGeninkbn(C_GeninKbn.JS);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "免責期間中の自殺", "査定項目メッセージ");
    }

    @Test
    @TestOrder(100)
    public void testExec_B7() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN8;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdSateiMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdSateiMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN3;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo7);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20150505"));
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数ジ");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "早期支払請求 解除注意", "査定項目メッセージ");
        MockObjectManager
        .assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 0, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 1, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 2, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 3, C_YokinKbn.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 4, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 5, C_Kzdou.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 6, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 7, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 8, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 9, C_SeikyuusyaKbn.UKTHONNIN);

        MockObjectManager.assertArgumentPassed(ChkSubSknnKaisiYmdSateiMockForSiharai.class, "exec", 0, BizDate.valueOf(20150505));
        JT_SiKykSyouhn siKykSyouhn = (JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubSknnKaisiYmdSateiMockForSiharai.class, "exec", 0, 1);
        exDateEquals(siKykSyouhn.getSknnkaisiymd(), BizDate.valueOf(20150506), "責任開始日");
    }

    @Test
    @TestOrder(110)
    public void testExec_B8() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN8;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdSateiMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdSateiMockForSiharai.TESTPATTERN2;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN3;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo17);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("AAA");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf("20150505"));
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "早期支払請求 解除注意", "査定項目メッセージ");
        MockObjectManager
        .assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 0, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 1, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 2, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 3, C_YokinKbn.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 4, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 5, C_Kzdou.BLNK);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 6, "");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 7, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 8, "AAA");
        MockObjectManager.assertArgumentPassed(ChkSubSksInfoMockForSiharai.class, "exec", 9, C_SeikyuusyaKbn.KYKHONNIN);
    }

    @Test
    @TestOrder(120)
    public void testExec_B9() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubStknsetMockForSiharai.SYORIPTN = ChkSubStknsetMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN4;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo9);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_STKNSET_UMU, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "質権設定契約", "査定項目メッセージ");

        JT_SiKykKihon siKykKihon = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubStknsetMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(siKykKihon.getStknsetkbn(), C_StknsetKbn.ARI, "質権設定区分");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn1(), C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE, "手続注意区分１");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE, "手続注意区分２");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn3(), C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE, "手続注意区分３");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn4(), C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE, "手続注意区分４");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn5(), C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE, "手続注意区分５");
        exStringEquals(siKykKihon.getTsinyno(), "1234567", "通信先郵便番号");
    }

    @Test
    @TestOrder(130)
    public void testExec_B10() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubHasanTousanMockForSiharai.SYORIPTN = ChkSubHasanTousanMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN5;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo10);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("");
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj("");
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "破産および倒産", "査定項目メッセージ");

        JT_SiKykKihon siKykKihon = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubHasanTousanMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(siKykKihon.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分１");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI, "手続注意区分２");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn3(), C_TtdktyuuiKbn.SEIZENKYUUHUHIGAITOU, "手続注意区分３");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn4(), C_TtdktyuuiKbn.BLNK, "手続注意区分４");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn5(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分５");
        exStringEquals(siKykKihon.getTsinyno(), "1234567", "通信先郵便番号");
    }

    @Test
    @TestOrder(140)
    public void testExec_B11() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubSasiosaeMockForSiharai.SYORIPTN = ChkSubSasiosaeMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN6;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo11);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_SASIOSAE, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "差押", "査定項目メッセージ");

        JT_SiKykKihon siKykKihon = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubSasiosaeMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(siKykKihon.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE, "手続注意区分１");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn2(), C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI, "手続注意区分２");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn3(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分３");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn4(), C_TtdktyuuiKbn.DAIRININTTDKHUKA, "手続注意区分４");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn5(), C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI, "手続注意区分５");
        exStringEquals(siKykKihon.getTsinyno(), "1234567", "通信先郵便番号");
    }

    @Test
    @TestOrder(150)
    public void testExec_B12() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubSousasyoukaiMockForSiharai.SYORIPTN = ChkSubSousasyoukaiMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN7;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo12);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_SOUSASYOUKAI, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "捜査照会", "査定項目メッセージ");

        JT_SiKykKihon siKykKihon = (JT_SiKykKihon) MockObjectManager.getArgument(ChkSubSousasyoukaiMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(siKykKihon.getTtdktyuuikbn1(), C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI, "手続注意区分１");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn2(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分２");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn3(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分３");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn4(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分４");
        exClassificationEquals(siKykKihon.getTtdktyuuikbn5(), C_TtdktyuuiKbn.HASANOYOBITOUSAN, "手続注意区分５");
        exStringEquals(siKykKihon.getTsinyno(), "1234567", "通信先郵便番号");
    }

    @Test
    @TestOrder(160)
    public void testExec_B13() {
        MockObjectManager.initialize();
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubSkSyoruiMockForSiharai.SYORIPTN = ChkSubSkSyoruiMockForSiharai.TESTPATTERN1;
        SiSateiKmkChkkekkaSetteiMockForSiharai.SYORIPTN = SiSateiKmkChkkekkaSetteiMockForSiharai.TESTPATTERN8;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo13);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon.setSkno("SK001");
        skKihon.setSyono("11810111118");
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 1, "件数");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getSKNaiyouChkKbn(),
            C_SKNaiyouChkKbn.SATEICHK_SKSYORUI, "請求内容チェック区分");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), "精算金振込依頼書あり", "査定項目メッセージ");

        JT_SkKihon skKihon2 = (JT_SkKihon) MockObjectManager.getArgument(ChkSubSkSyoruiMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(skKihon2.getSeikyuusyubetu(), C_SeikyuuSyubetu.SB, "請求種別");
        exStringEquals(skKihon2.getSkno(), "SK001", "請求番号");
        exStringEquals(skKihon2.getSyono(), "11810111118", "証券番号");
    }

    @Test
    @TestOrder(170)
    public void testExec_C1() {
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN10;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo2);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(180)
    public void testExec_D1() {
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN10;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo8);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");
    }

    @Test
    @TestOrder(190)
    public void testExec_E1() {
        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN10;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo15);
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf(20170911));
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkj(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyaseiymd(null);
        checkSbSkNaiyouParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        checkSbSkNaiyouParamImpl.setSkskknnmkn("");
        checkSbSkNaiyouParamImpl.setSkskknnmkj("");
        checkSbSkNaiyouParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);
        checkSbSkNaiyouParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        checkSbSkNaiyouParamImpl.setTsinyno("1234567");
        checkSbSkNaiyouParamImpl.setTsinadr1kj("御御");
        checkSbSkNaiyouParamImpl.setTsinadr2kj("御御御");
        checkSbSkNaiyouParamImpl.setTsinadr3kj("御御御御");
        checkSbSkNaiyouParamImpl.setTsintelno("13888888888");
        checkSbSkNaiyouParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        checkSbSkNaiyouParamImpl.setBankcd("");
        checkSbSkNaiyouParamImpl.setSitencd("");
        checkSbSkNaiyouParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        checkSbSkNaiyouParamImpl.setKouzano("");
        checkSbSkNaiyouParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        checkSbSkNaiyouParamImpl.setKzmeiginmkn("");
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(200)
    public void testExec_F1() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubUketoriHouhouMockForSiharai.SYORIPTN = ChkSubUketoriHouhouMockForSiharai.TESTPATTERN1;
        ChkSubSaigaiGaitouMockForSiharai.SYORIPTN = ChkSubSaigaiGaitouMockForSiharai.TESTPATTERN1;
        ChkSubSaikenInfoMockForSiharai.SYORIPTN = ChkSubSaikenInfoMockForSiharai.TESTPATTERN1;
        ChkSubSaisateiMockForSiharai.SYORIPTN = ChkSubSaisateiMockForSiharai.TESTPATTERN1;
        ChkSubSaikenKaiykMousideMockForSiharai.SYORIPTN = ChkSubSaikenKaiykMousideMockForSiharai.TESTPATTERN1;
        ChkSubSaisateiSateiMockForSiharai.SYORIPTN = ChkSubSaisateiSateiMockForSiharai.TESTPATTERN1;
        ChkSubKeiyakusyaHnkMockForSiharai.SYORIPTN = ChkSubKeiyakusyaHnkMockForSiharai.TESTPATTERN1;
        ChkSubDsKaiykSyoriMockForSiharai.SYORIPTN = ChkSubDsKaiykSyoriMockForSiharai.TESTPATTERN1;
        ChkSubKykYmdMockForSiharai.SYORIPTN = ChkSubKykYmdMockForSiharai.TESTPATTERN1;
        ChkSubEndtHenkouYmdMockForSiharai.SYORIPTN = ChkSubEndtHenkouYmdMockForSiharai.TESTPATTERN1;
        ChkSubHnrkinMbrMockForSiharai.SYORIPTN = ChkSubHnrkinMbrMockForSiharai.TESTPATTERN1;
        ChkSubSgSbJisatuMensekiMockForSiharai.SYORIPTN = ChkSubSgSbJisatuMensekiMockForSiharai.TESTPATTERN1;
        ChkSubDMockForSiharai.SYORIPTN = ChkSubDMockForSiharai.TESTPATTERN1;
        ChkSubPHrkmYuuyokknMockForSiharai.SYORIPTN = ChkSubPHrkmYuuyokknMockForSiharai.TESTPATTERN1;
        ChkSubTmttknJyoutaiMockForSiharai.SYORIPTN = ChkSubTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo18);
        checkSbSkNaiyouParamImpl.setSuketorihouhoukbn(C_SUketoriHouhouKbn.ITIBU_NENKIN);
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf(20170911));
        List<String> tempLst = new ArrayList<String>();
        tempLst.add("111");
        checkSbSkNaiyouParamImpl.setByoumeitourokunolist(tempLst);
        checkSbSkNaiyouParamImpl.setGeninkbn(C_GeninKbn.KTJK);
        checkSbSkNaiyouParamImpl.setSateikaksaigaikanouseikbn(C_UmuKbn.ARI);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("17809000182");
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        checkSbSkNaiyouParamImpl.setSaikennmkj("AAAA");
        checkSbSkNaiyouParamImpl.setSaikennyno("1234567");
        checkSbSkNaiyouParamImpl.setSaikenadr1kj("BBBB");
        checkSbSkNaiyouParamImpl.setSaikenadr2kj("CCCC");
        checkSbSkNaiyouParamImpl.setSaikenadr3kj("DDDD");
        checkSbSkNaiyouParamImpl.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

        MockObjectManager.assertArgumentPassed(ChkSubUketoriHouhouMockForSiharai.class, "exec", 0, C_SUketoriHouhouKbn.ITIBU_NENKIN);

        exDateEquals((BizDate) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 0), BizDate.valueOf(20170911), "判定基準日");
        List<String> templist =(List<String>) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 1);
        exNumericEquals(templist.size(), 1, "病名登録番号リスト");
        exClassificationEquals((C_GeninKbn) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 2), C_GeninKbn.KTJK, "原因区分");
        exClassificationEquals((C_UmuKbn) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 3), C_UmuKbn.ARI, "査定回送要否確認（災害可能性）区分");
        BM_SyouhnZokusei syouhnZokusei =(BM_SyouhnZokusei) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 4);
        exNumericEquals(syouhnZokusei.getMvatekikkn(), 12, "商品属性MSTエンティティ．ＭＶＡ適用期間");
        exClassificationEquals(syouhnZokusei.getHknkknbunruikbn(), C_HknkknBunruiKbn.THIRD, "商品属性MSTエンティティ．ＭＶＡ適用期間");
        JT_SiKykSyouhn siKykSyouhn =(JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 5);
        exStringEquals(siKykSyouhn.getSyono(), "17809000182", "支払契約商品TBLエンティティ");
        exNumericEquals(siKykSyouhn.getDai1hknkkn(), 11, "支払契約商品TBLエンティティ．第１保険期間");
        JT_SkKihon skKihonTemp =(JT_SkKihon) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 6);
        exStringEquals(skKihonTemp.getSyono(), "17809000182", "請求基本TBLエンティティ");
        exBooleanEquals((Boolean) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 7), false, "査定項目チェックフラグ");

        MockObjectManager.assertArgumentPassed(ChkSubSaikenInfoMockForSiharai.class, "exec", 0, "AAAA");
        MockObjectManager.assertArgumentPassed(ChkSubSaikenInfoMockForSiharai.class, "exec", 1, "1234567");
        MockObjectManager.assertArgumentPassed(ChkSubSaikenInfoMockForSiharai.class, "exec", 2, "BBBB");
        MockObjectManager.assertArgumentPassed(ChkSubSaikenInfoMockForSiharai.class, "exec", 3, "CCCC");
        MockObjectManager.assertArgumentPassed(ChkSubSaikenInfoMockForSiharai.class, "exec", 4, "DDDD");
        JT_SiKykKihon siKykKihon =(JT_SiKykKihon) MockObjectManager.getArgument(ChkSubSaikenInfoMockForSiharai.class, "exec", 0, 5);
        exStringEquals(siKykKihon.getSyono(), "17809000182", "支払契約基本テーブルエンティティ");

        MockObjectManager.assertArgumentPassed(ChkSubSaisateiMockForSiharai.class, "exec", 0, C_SaisateiKbn.SAISATEI);

        JT_SiKykKihon siKykKihon2 =(JT_SiKykKihon) MockObjectManager.getArgument(ChkSubSaikenKaiykMousideMockForSiharai.class, "exec", 0, 0);
        exStringEquals(siKykKihon2.getSyono(), "17809000182", "支払契約基本テーブルエンティティ");

        exDateEquals((BizDate) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 0), BizDate.valueOf(20170911), "判定基準日");
        List<String> templist3 =(List<String>) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 1);
        exNumericEquals(templist3.size(), 1, "病名登録番号リスト");
        exClassificationEquals((C_GeninKbn) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 2), C_GeninKbn.KTJK, "原因区分");
        exClassificationEquals((C_UmuKbn) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 3), C_UmuKbn.ARI, "査定回送要否確認（災害可能性）区分");
        BM_SyouhnZokusei syouhnZokusei2 =(BM_SyouhnZokusei) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 0, 4);
        exNumericEquals(syouhnZokusei2.getMvatekikkn(), 12, "商品属性MSTエンティティ．ＭＶＡ適用期間");
        exClassificationEquals(syouhnZokusei2.getHknkknbunruikbn(), C_HknkknBunruiKbn.THIRD, "商品属性MSTエンティティ．ＭＶＡ適用期間");
        JT_SiKykSyouhn siKykSyouhn3 =(JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 5);
        exStringEquals(siKykSyouhn3.getSyono(), "17809000182", "支払契約商品TBLエンティティ");
        exNumericEquals(siKykSyouhn3.getDai1hknkkn(), 11, "支払契約商品TBLエンティティ．第１保険期間");
        JT_SkKihon skKihonTemp3 =(JT_SkKihon) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 6);
        exStringEquals(skKihonTemp3.getSyono(), "17809000182", "請求基本TBLエンティティ");
        exBooleanEquals((Boolean) MockObjectManager.getArgument(ChkSubSaigaiGaitouMockForSiharai.class, "exec", 1, 7), true, "査定項目チェックフラグ");

        MockObjectManager.assertArgumentPassed(ChkSubSaisateiSateiMockForSiharai.class, "exec", 0, C_SaisateiKbn.SAISATEI);

        MockObjectManager.assertArgumentPassed(ChkSubKeiyakusyaHnkMockForSiharai.class, "exec", 0, 2);

        MockObjectManager.assertArgumentPassed(ChkSubDsKaiykSyoriMockForSiharai.class, "exec", 0, "17809000182");

        MockObjectManager.assertArgumentPassed(ChkSubKykYmdMockForSiharai.class, "exec", 0, BizDate.valueOf(20170911));
        MockObjectManager.assertArgumentPassed(ChkSubKykYmdMockForSiharai.class, "exec", 1, BizDate.valueOf(20160506));

        MockObjectManager.assertArgumentPassed(ChkSubDMockForSiharai.class, "exec", 0, BizDate.valueOf(20170911));
        MockObjectManager.assertArgumentPassed(ChkSubDMockForSiharai.class, "exec", 1, "17809000182");

        MockObjectManager.assertArgumentPassed(ChkSubEndtHenkouYmdMockForSiharai.class, "exec", 0, BizDate.valueOf(20170911));
        MockObjectManager.assertArgumentPassed(ChkSubEndtHenkouYmdMockForSiharai.class, "exec", 1, BizDate.valueOf(20150506));

        JT_SiKykKihon siKykKihon3 =(JT_SiKykKihon) MockObjectManager.getArgument(ChkSubHnrkinMbrMockForSiharai.class, "exec", 0, 0);
        exStringEquals(siKykKihon3.getSyono(), "17809000182", "支払契約基本テーブルエンティティ");

        MockObjectManager.assertArgumentPassed(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 0, BizDate.valueOf(20170911));
        MockObjectManager.assertArgumentPassed(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 1, BizDate.valueOf(20160708));
        JT_SiKykSyouhn siKykSyouhn4 =(JT_SiKykSyouhn) MockObjectManager.getArgument(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 0, 2);
        exStringEquals(siKykSyouhn4.getSyono(), "17809000182", "支払契約商品テーブルエンティティ");
        MockObjectManager.assertArgumentPassed(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 3, C_GeninKbn.KTJK);
        List<String> templist4 =(List<String>) MockObjectManager.getArgument(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 0, 4);
        exNumericEquals(templist4.size(), 1, "病名登録番号リスト");
        MockObjectManager.assertArgumentPassed(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 5, C_UmuKbn.ARI);
        JT_SkKihon skKihon4 =(JT_SkKihon) MockObjectManager.getArgument(ChkSubSgSbJisatuMensekiMockForSiharai.class, "exec", 0, 6);
        exStringEquals(skKihon4.getSyono(), "17809000182", "請求基本TBLエンティティ");

        MockObjectManager.assertArgumentPassed(ChkSubPHrkmYuuyokknMockForSiharai.class, "exec", 0, BizDate.valueOf(20170911));
        MockObjectManager.assertArgumentPassed(ChkSubPHrkmYuuyokknMockForSiharai.class, "exec", 1, "17809000182");

        MockObjectManager.assertArgumentPassed(ChkSubTmttknJyoutaiMockForSiharai.class, "exec", 0, BizDate.valueOf(20170911));
        MockObjectManager.assertArgumentPassed(ChkSubTmttknJyoutaiMockForSiharai.class, "exec", 1, "17809000182");
        MockObjectManager.assertArgumentPassed(ChkSubTmttknJyoutaiMockForSiharai.class, "exec", 2, BizDate.valueOf(20160506));
        MockObjectManager.assertArgumentPassed(ChkSubTmttknJyoutaiMockForSiharai.class, "exec", 3, BizDate.valueOf(20190506));

    }

    @Test
    @TestOrder(201)
    public void testExec_F2() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        ChkSubMRFKouzaTratkiMockForSiharai.SYORIPTN = ChkSubMRFKouzaTratkiMockForSiharai.TESTPATTERN1;
        ChkSubUketoriHouhouMockForSiharai.SYORIPTN = ChkSubUketoriHouhouMockForSiharai.TESTPATTERN1;
        ChkSubSaigaiGaitouMockForSiharai.SYORIPTN = ChkSubSaigaiGaitouMockForSiharai.TESTPATTERN1;
        ChkSubSaikenInfoMockForSiharai.SYORIPTN = ChkSubSaikenInfoMockForSiharai.TESTPATTERN1;
        ChkSubSaisateiMockForSiharai.SYORIPTN = ChkSubSaisateiMockForSiharai.TESTPATTERN1;
        ChkSubSaikenKaiykMousideMockForSiharai.SYORIPTN = ChkSubSaikenKaiykMousideMockForSiharai.TESTPATTERN1;
        ChkSubSaisateiSateiMockForSiharai.SYORIPTN = ChkSubSaisateiSateiMockForSiharai.TESTPATTERN1;
        ChkSubKeiyakusyaHnkMockForSiharai.SYORIPTN = ChkSubKeiyakusyaHnkMockForSiharai.TESTPATTERN1;
        ChkSubDsKaiykSyoriMockForSiharai.SYORIPTN = ChkSubDsKaiykSyoriMockForSiharai.TESTPATTERN1;
        ChkSubKykYmdMockForSiharai.SYORIPTN = ChkSubKykYmdMockForSiharai.TESTPATTERN1;
        ChkSubSgSbJisatuMensekiMockForSiharai.SYORIPTN = ChkSubSgSbJisatuMensekiMockForSiharai.TESTPATTERN1;
        ChkSubDMockForSiharai.SYORIPTN = ChkSubDMockForSiharai.TESTPATTERN1;
        ChkSubPHrkmYuuyokknMockForSiharai.SYORIPTN = ChkSubPHrkmYuuyokknMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo21);
        checkSbSkNaiyouParamImpl.setSuketorihouhoukbn(C_SUketoriHouhouKbn.ITIBU_NENKIN);
        checkSbSkNaiyouParamImpl.setSibouymd(BizDate.valueOf(20170911));
        List<String> tempLst = new ArrayList<String>();
        tempLst.add("111");
        checkSbSkNaiyouParamImpl.setByoumeitourokunolist(tempLst);
        checkSbSkNaiyouParamImpl.setGeninkbn(C_GeninKbn.KTJK);
        checkSbSkNaiyouParamImpl.setSateikaksaigaikanouseikbn(C_UmuKbn.ARI);
        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSyono("11810111381");
        checkSbSkNaiyouParamImpl.setSkkihon(skKihon);
        checkSbSkNaiyouParamImpl.setSaikennmkj("AAAA");
        checkSbSkNaiyouParamImpl.setSaikennyno("1234567");
        checkSbSkNaiyouParamImpl.setSaikenadr1kj("BBBB");
        checkSbSkNaiyouParamImpl.setSaikenadr2kj("CCCC");
        checkSbSkNaiyouParamImpl.setSaikenadr3kj("DDDD");
        checkSbSkNaiyouParamImpl.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.HUYOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }


    @Test(expected = BizAppException.class)
    @TestOrder(210)
    public void testExec_G1() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;

        try {
            CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
            checkSbSkNaiyouParamImpl.setSyono(syoNo19);
            String yobidasimotoKinouId = "CheckSbSkNaiyou";
            C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

            checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "テーブル取得エラー　BM_SyouhnZokusei　key:syouhnCd=HH02,syouhnsdNo=10", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(220)
    public void testExec_H1() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN2;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.STDR);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("AAAA");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 6, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "WJA1057", "警告メッセージ[0]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "反社情報", "警告メッセージ[1]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "", "警告メッセージ[2]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "", "警告メッセージ[3]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "", "警告メッセージ[4]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "", "警告メッセージ[5]");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(230)
    public void testExec_H2() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN3;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.STDR);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("AAAA");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 6, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "WJA1058", "警告メッセージ[0]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "反社情報", "警告メッセージ[1]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "", "警告メッセージ[2]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "", "警告メッセージ[3]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "", "警告メッセージ[4]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "", "警告メッセージ[5]");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(240)
    public void testExec_H3() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN4;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.STDR);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("AAAA");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 6, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "WJA1059", "警告メッセージ[0]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "反社情報", "警告メッセージ[1]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "", "警告メッセージ[2]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "", "警告メッセージ[3]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "", "警告メッセージ[4]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "", "警告メッセージ[5]");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(250)
    public void testExec_H4() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.STDR);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("AAAA");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.HUBIKAITOUMATI;

        CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl,
            yobidasimotoKinouId,
            sikinouModeIdKbn);

        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSkNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING,
            "（死亡）請求内容チェック結果区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn(), C_YouhiKbn.YOU, "査定回送要否区分");
        exClassificationEquals(checkSbSkNaiyouKekkaBean.getKeisanKahiKbn(), C_KahiKbn.KA, "計算可否区分");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().size(), 6, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(0), "WJA1057", "警告メッセージ[0]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(1), "反社情報", "警告メッセージ[1]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(2), "", "警告メッセージ[2]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(3), "", "警告メッセージ[3]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(4), "", "警告メッセージ[4]");
        exStringEquals(checkSbSkNaiyouKekkaBean.getWarningMessageList().get(5), "", "警告メッセージ[5]");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getErrorMessageCollector().getMessages().size(), 0, "件数");
        exNumericEquals(checkSbSkNaiyouKekkaBean.getChkKekkaBeanList().size(), 0, "件数");
        exStringEquals(checkSbSkNaiyouKekkaBean.getSateiKoumokuMessage(), null, "査定項目メッセージ");

    }

    @Test
    @TestOrder(260)
    public void testExec_I1() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTDAIHYOU);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("セイキユウシヤ　カナ");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);

    }

    @Test
    @TestOrder(270)
    public void testExec_I2() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN3;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.SONOTA);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("セイキユウシヤ　カナ");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);

    }

    @Test
    @TestOrder(280)
    public void testExec_I3() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("セイキユウシヤ　カナ");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);

    }

    @Test
    @TestOrder(290)
    public void testExec_I4() {

        MockObjectManager.initialize();

        KeiyakuInfoSyutokuMockForSiharai.SYORIPTN = KeiyakuInfoSyutokuMockForSiharai.TESTPATTERN11;
        ChkSubSksyaInfoMockForSiharai.SYORIPTN = ChkSubSksyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSinkensyaInfoMockForSiharai.SYORIPTN = ChkSubSinkensyaInfoMockForSiharai.TESTPATTERN1;
        ChkSubSksInfoMockForSiharai.SYORIPTN = ChkSubSksInfoMockForSiharai.TESTPATTERN1;
        ChkSubShskInfoMockForSiharai.SYORIPTN = ChkSubShskInfoMockForSiharai.TESTPATTERN1;

        CheckSbSkNaiyouParamImpl checkSbSkNaiyouParamImpl = SWAKInjector.getInstance(CheckSbSkNaiyouParamImpl.class);
        checkSbSkNaiyouParamImpl.setSyono(syoNo20);
        checkSbSkNaiyouParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.KYKDAIRININ);
        checkSbSkNaiyouParamImpl.setSeikyuusyanmkn("セイキユウシヤ　カナ");

        String yobidasimotoKinouId = "CheckSbSkNaiyou";
        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

        checkSbSkNaiyou.exec(checkSbSkNaiyouParamImpl, yobidasimotoKinouId, sikinouModeIdKbn);

    }

}
