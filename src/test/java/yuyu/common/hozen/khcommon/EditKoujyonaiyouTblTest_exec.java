package yuyu.common.hozen.khcommon;

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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.GetasPRsTuukaMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 控除証明内容TBL編集クラスのメソッド {@link EditKoujyonaiyouTbl#exec(KhozenCommonParam, String, C_KjsymnytblhensyuusyoriKbn, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKoujyonaiyouTblTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static BizDate syoriYmd = BizDate.valueOf("20150801");

    private final static String syoNo101 = "10806123452";

    private final static String syoNo102 = "10806123463";

    private final static String syoNo103 = "10806123474";

    private final static String syoNo104 = "10806123485";

    private final static String syoNo105 = "24809001622";

    private final static String syoNo106 = "24809001633";

    private final static String syoNo107 = "24809001644";

    private final static String syoNo201 = "20806123455";

    private final static String syoNo202 = "20806123466";

    private final static String syoNo203 = "20806123477";

    private final static String syoNo227 = "17806000046";

    private final static String syoNo204 = "31809001725";

    private final static String syoNo207 = "20806123514";

    private final static String syoNo208 = "20806123488";

    private final static String syoNo209 = "20806123499";

    private final static String syoNo210 = "20806123503";

    private final static String syoNo211 = "31809001736";

    private final static String syoNo214 = "20806123536";

    private final static String syoNo217 = "20806123651";

    private final static String syoNo219 = "32810003146";

    private final static String syoNo220 = "30809001610";

    private final static String syoNo221 = "30809001632";

    private final static String syoNo301 = "30806123458";

    private final static String syoNo303 = "30809001458";

    private final static String syoNo305 = "30809001621";

    private final static String syoNo307 = "32810003157";

    private final static String syoNo308 = "32810003168";

    private final static String syoNo309 = "20806123525";

    private final static String syoNo310 = "32810003216";

    private final static String syoNo311 = "17806000220";

    private final static String syoNo314 = "17807000027";

    private final static String syoNo316 = "17806001427";

    private final static String syoNo318 = "17806000127";

    private final static String syoNo404 = "30806123481";

    private final static String syoNo410 = "30809001643";

    private final static String syoNo412 = "31809001747";

    private final static String syoNo413 = "30806123492";

    private final static String syoNo414 = "30806012523";

    private final static String syoNo416 = "17806000323";

    private final static String syoNo418 = "17806002222";

    private final static String syoNo420 = "17806001128";

    private final static String syoNo422 = "17806001221";

    private final static String syoNo425 = "17806666666";

    private final static String syoNo427 = "17806666769";

    private final static String syoNo429 = "17806666862";

    private final static String syoNo431 = "17806000208";

    @Inject
    private EditKoujyonaiyouTbl editKoujyonaiyouTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    ExDBEntityManager exDBEntityManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_控除証明内容TBL編集";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(JtKaisukeisan.class).to(JtKaisukeisanMockForKhansyuu.class);
                bind(KeisanZennouKoujyogaku.class).to(KeisanZennouKoujyogakuMockForKhansyuu.class);
                bind(KoujyoSyoumeiUtil.class).to(KoujyoSyoumeiUtilMockForKhansyuu.class);
                bind(GetasPRsTuuka.class).to(GetasPRsTuukaMockForKhansyuu.class);
            }
        });

        baseUserInfo.getUser().setUserId("JUnit");
    }

    @BeforeClass
    public static void testInit() {
        JtKaisukeisanMockForKhansyuu.caller = EditKoujyonaiyouTblTest_exec.class;
        KeisanZennouKoujyogakuMockForKhansyuu.caller = EditKoujyonaiyouTblTest_exec.class;
        KoujyoSyoumeiUtilMockForKhansyuu.caller = EditKoujyonaiyouTblTest_exec.class;
        GetasPRsTuukaMockForKhansyuu.caller = EditKoujyonaiyouTblTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        JtKaisukeisanMockForKhansyuu.caller = null;
        JtKaisukeisanMockForKhansyuu.SYORIPTN = null;
        KeisanZennouKoujyogakuMockForKhansyuu.caller = null;
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = null;
        KoujyoSyoumeiUtilMockForKhansyuu.caller = null;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = null;
        GetasPRsTuukaMockForKhansyuu.caller = null;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKoujyonaiyouTblTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        JtKaisukeisanMockForKhansyuu.caller = null;
        KeisanZennouKoujyogakuMockForKhansyuu.caller = null;
        KoujyoSyoumeiUtilMockForKhansyuu.caller = null;
        GetasPRsTuukaMockForKhansyuu.caller = null;
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo101,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "契約基本テーブルが取得できませんでした。 証券番号 ＝ 10806123452", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo102,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "契約商品テーブルが取得できませんでした。 証券番号 ＝ 10806123463", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("S520");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo103,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "商品属性マスタが取得できませんでした。 証券番号 ＝ 10806123474", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono(syoNo104);
        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("A001");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setHenkousikibetukey("1");
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("A001");
        syouhnZokusei.setSyouhnsdno(1);
        kykSyouhn.setSyouhnZokusei(syouhnZokusei);
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        hhknSya = null;
        kykKihon.setHhknSya(hhknSya);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo104,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "被保険者テーブルが取得できませんでした。 証券番号 ＝ 10806123485", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo105,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "案内収納基本テーブルが取得できませんでした。 証券番号 ＝ 24809001622", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono(syoNo106);
        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("A001");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setHenkousikibetukey("1");
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("A001");
        syouhnZokusei.setSyouhnsdno(1);
        kykSyouhn.setSyouhnZokusei(syouhnZokusei);
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        kykKihon.setHhknSya(hhknSya);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykSonotaTkyk = null;
        kykKihon.setKykSonotaTkyk(kykSonotaTkyk);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo106,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "契約その他特約テーブルが取得できませんでした。 証券番号 ＝  24809001633", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(70)
    public void testExec_A7() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.TK);

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono(syoNo107);
        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("A001");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setHenkousikibetukey("1");
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("A001");
        syouhnZokusei.setSyouhnsdno(1);
        kykSyouhn.setSyouhnZokusei(syouhnZokusei);
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        kykKihon.setHhknSya(hhknSya);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykKihon.setKykSonotaTkyk(kykSonotaTkyk);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo107,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "変更前契約商品テーブルが取得できませんでした。 証券番号 ＝ 24809001644", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(80)
    public void testExec_A8() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono(syoNo107);
        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("A001");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setHenkousikibetukey("1");
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("A001");
        syouhnZokusei.setSyouhnsdno(1);
        kykSyouhn.setSyouhnZokusei(syouhnZokusei);
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        kykKihon.setHhknSya(hhknSya);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykKihon.setKykSonotaTkyk(kykSonotaTkyk);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo107,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "更新前の契約商品リストが設定されていません。 証券番号 ＝ 24809001644", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(81)
    public void testExec_A9() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        kinou.setKinouId("khharaikatahenkou");
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono(syoNo107);
        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("A001");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setHenkousikibetukey("1");
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("A001");
        syouhnZokusei.setSyouhnsdno(1);
        kykSyouhn.setSyouhnZokusei(syouhnZokusei);
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        kykKihon.setHhknSya(hhknSya);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykKihon.setKykSonotaTkyk(kykSonotaTkyk);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo107,
                C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "更新前の契約商品リストが設定されていません。 証券番号 ＝ 24809001644", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(82)
    public void testExec_A10() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        kinou.setKinouId("khhukkatu");
        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono(syoNo107);
        IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
        kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn.setSyouhncd("A001");
        kykSyouhn.setSyouhnsdno(1);
        kykSyouhn.setKyksyouhnrenno(1);
        kykSyouhn.setHenkousikibetukey("1");
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("A001");
        syouhnZokusei.setSyouhnsdno(1);
        kykSyouhn.setSyouhnZokusei(syouhnZokusei);
        IT_HhknSya hhknSya = kykKihon.createHhknSya();
        kykKihon.setHhknSya(hhknSya);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.createKykSonotaTkyk();
        kykKihon.setKykSonotaTkyk(kykSonotaTkyk);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo107,
                C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。想定外の払込回数です。 証券番号 ＝ 24809001644 払込回数 ＝ null", "エラーメッセージ");
            throw e;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(100)
    public void testExec_B1() {

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo201, C_KjsymnytblhensyuusyoriKbn.BLNK, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "想定外の控除証明内容TBL編集処理区分です。  証券番号＝20806123455 控除証明内容TBL編集処理区分 ＝ 0",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_B2() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khkeiyakuinfotorikomi");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(15000));
        kykSyouhnCommonParam.setKyktuukasyu(C_Tuukasyu.JPY);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo201,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo201);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo201, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(210000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khkeiyakuinfotorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(GetasPRsTuukaMockForKhansyuu.class, "editRyousyuuTuukaSyuruiHantei", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(GetasPRsTuukaMockForKhansyuu.class, "editRyousyuuTuukaSyuruiHantei", 0, 1), C_UmuKbn.NONE, "円入金特約付加有無");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(GetasPRsTuukaMockForKhansyuu.class, "editRyousyuuTuukaSyuruiHantei", 0, 2), C_UmuKbn.ARI, "外貨入金特約付加有無");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_B3() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20150505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(15000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo202,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo202);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo202, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(210000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_B4() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201607));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201612));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20150505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(15000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo204,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo204);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo204, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201607"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(90000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201607"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(140)
    public void testExec_B5() {

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.BLNK);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo203, C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "想定外の払込回数です。 証券番号 ＝ 20806123477 払込回数 ＝ 0", "エラーメッセージ");
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_B7() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
        editKoujyonaiyouTbl.setNyknJskRenno(3);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(4);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(40000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);
        zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(BizNumber.valueOf(1));

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        editKoujyonaiyouTbl.setYoupJytStartYm(BizDateYM.valueOf(201501));

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo203,
            C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo203);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo203, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(80000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 3, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 4, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(65000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "12", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20131029), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(30000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.TUKI, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 14, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(80000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "setKjsmyouYenKawaserate", 0, 0), BizNumber.valueOf(1), "前納控除証明額計算の１次呼出の控除証明用円換算為替レート");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exStringEquals(kykSyouhnCommonParamLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(kykSyouhnCommonParamLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(kykSyouhnCommonParamLst.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exBizCalcbleEquals(kykSyouhnCommonParamLst.get(0).getHokenryou(), BizCurrency.valueOf(40000), "保険料");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_B8() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201701));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20150505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(22100));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo208,
            C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo208);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo208, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201407"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201512"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(397800), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo208, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201501"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(530400), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo208, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2017", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("201601"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("201701"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(287300), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_B9() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
        editKoujyonaiyouTbl.setNyknJskRenno(5);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(6);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo209,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo209);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo209, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(504000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 5, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 6, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_B10() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20150505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(50000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        editKoujyonaiyouTbl.setYoupJytStartYm(BizDateYM.valueOf(201505));

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo210,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo210);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo210, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(700000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_B11() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201707));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20150505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(50000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        editKoujyonaiyouTbl.setYoupJytStartYm(BizDateYM.valueOf(201805));

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo211,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo211);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo211, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2018", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201707"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201609"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(700000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201707"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_B12() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(7);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(8);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201607));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20150505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(50000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        editKoujyonaiyouTbl.setYoupJytStartYm(BizDateYM.valueOf(201501));

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo207,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo207);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo207, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201607"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201609"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(700000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201607"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 7, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 8, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }



    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_B14() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.ITIJI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(11);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(12);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201607));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo214,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo214);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo214, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201607"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201609"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(1000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201607"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 11, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 12, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_B16() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khhukkatu");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(7);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(8);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201709));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, "20806123547",
            C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806123547");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), "20806123547", "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(90000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 7, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 8, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khhukkatu", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), "20806123547", "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2017", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201601"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201709"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.NKTRKS, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(105000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 7, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 8, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khhukkatu", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_B17() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setNykkeiro(C_Nykkeiro.HKNKIN);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(4000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo217,
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo217);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), "20806123651", "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(0), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "3002", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(251)
    public void testExec_B19() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo219,
            C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo219);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo219, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo219, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201509"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), null, "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(5600), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 19, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(252)
    public void testExec_B20() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo220,
                C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。入金実績履歴テーブルが取得できませんでした。"
                    + " 証券番号 ＝ 30809001610 充当開始年月 ＝ 201512 入金取消フラグ ≠ 1", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(253)
    public void testExec_B21() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo221,
            C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo221);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(6660), "控除証明額");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(254)
    public void testExec_B22() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(14));
        editKoujyonaiyouTbl.setNykkeiro(C_Nykkeiro.CREDIT);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(4000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, "30809002002",
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("30809002002");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), "30809002002", "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(4000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(255)
    public void testExec_B23() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN2;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(14));
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(4000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, "30809002013",
                C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。保険料を通貨換算できません。 証券番号 ＝ 30809002013", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(256)
    public void testExec_B24() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(10));
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1.55, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, "30809002024",
            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("30809002024");
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");

        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), "30809002024", "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(15), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(257)
    public void testExec_B25() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setNyknJskRysKwsrate(null);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(4000, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, "30809002035",
                C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。円換算レートが設定されていません。 証券番号 ＝ 30809002035", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(258)
    public void testExec_B26() {

        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(0));
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(4000, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, "30809002046",
                C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。円換算レートが設定されていません。 証券番号 ＝ 30809002046", "エラーメッセージ");
            throw e;
        }
    }
    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(151)
    public void testExec_B27() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
        editKoujyonaiyouTbl.setNyknJskRenno(3);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(4);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(40000));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);
        zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(BizNumber.valueOf(1));

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        editKoujyonaiyouTbl.setYoupJytStartYm(BizDateYM.valueOf(201501));

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo227,
            C_KjsymnytblhensyuusyoriKbn.YOUPHANEI, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo227);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo227, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(80000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 3, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 4, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(65000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "12", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20131029), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(30000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.NEN, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 14, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 0, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(80000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "setKjsmyouYenKawaserate", 0, 0), BizNumber.valueOf(1), "前納控除証明額計算の１次呼出の控除証明用円換算為替レート");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = (List<KykSyouhnCommonParam>)
                MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
            exStringEquals(kykSyouhnCommonParamLst.get(0).getSyouhncd(), "M120", "商品コード");
            exNumericEquals(kykSyouhnCommonParamLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
            exClassificationEquals(kykSyouhnCommonParamLst.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
            exBizCalcbleEquals(kykSyouhnCommonParamLst.get(0).getHokenryou(), BizCurrency.valueOf(40000), "保険料");
    }

        //    @Test
        //    @Transactional
        //    @TestOrder(259)
        //    public void testExec_B27() {
        //
        //        MockObjectManager.initialize();
        //        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        //        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");
        //        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        //        editKoujyonaiyouTbl.setNyknJskRenno(1);
        //        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        //        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        //        editKoujyonaiyouTbl.setKihrkpSeisanRenno(2);
        //        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201507));
        //        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201509));
        //        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20160606));
        //        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        //        editKoujyonaiyouTbl.setNyknJskRysKwsrate(BizNumber.valueOf(10));
        //        editKoujyonaiyouTbl.setNykkeiro(C_Nykkeiro.HKNKIN);
        //        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        //
        //        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        //        kykSyouhnCommonParam.setSyouhncd("M120");
        //        kykSyouhnCommonParam.setSyouhnsdno(1);
        //        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        //        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100));
        //
        //        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        //        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);
        //
        //        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        //
        //        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, "30809002057",
        //            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYmd);
        //
        //        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        //        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        //        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("30809002057");
        //        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        //        exNumericEquals(koujyoSymNaiyouLst.size(), 1, "要素数");
        //
        //        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), "30809002057", "証券番号");
        //        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        //        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        //        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2016", "控除証明年度");
        //        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201507"), "証明開始年月");
        //        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201509"), "証明終了年月");
        //        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        //        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        //        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        //        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(0), "控除証明額");
        //        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201507"), "充当開始年月");
        //        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        //        exNumericEquals(koujyoSymNaiyouLst.get(0).getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        //        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        //        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), C_DispKbn.HYOUJI, "計算不可表示区分");
        //        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), "3002", "計算不可理由コード");
        //        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), "khsiharaikekkatorikomi", "更新業務用更新機能ＩＤ");
        //        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        //    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(260)
    public void testExec_C2() {

        MockObjectManager.initialize();

        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setNyknJskRenno(13);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(14);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        khozenCommonParam.setFunctionId("khcommon");

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo301,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。主契約控除証明内容テーブルが取得できませんでした。"
                    + " 証券番号 ＝ 30806123458 201508 ≦ 証明終了年月 ≦ 201507", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(270)
    public void testExec_C3() {

        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setNyknJskRenno(13);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(14);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        khozenCommonParam.setFunctionId("khcommon");

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo303,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "前納用控除証明額計算パラメータが設定されていません。 証券番号 ＝ 30809001458", "エラーメッセージ");
            throw e;
        }

    }



    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_C5() {

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo305,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo305);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo305, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo305, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(576000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 19, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(305)
    public void testExec_C7() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo307,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo307);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo307, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo307, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN,
            "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT,
            "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(12500), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,"控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "RY01", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(306)
    public void testExec_C8() {


        MockObjectManager.initialize();
        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN3;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201509));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo308,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo308);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo308, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo308, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(360000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 19, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(307)
    public void testExec_C9() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo309,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo309);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 5, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo309, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(4).getSyono(), syoNo309, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(4).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(4).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(4).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(4).getSyoumeistartym(), BizDateYM.valueOf("201512"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(4).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(4).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(4).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(4).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(4).getKoujyosyoumeigk(), BizCurrency.valueOf(12500), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(4).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(4).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(4).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(4).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(4).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(4).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(4).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        exNumericEquals((int) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 0), 0,
            "充当回数計算の１次呼出の充当年数");
        exNumericEquals((int) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 1), 12,
            "充当回数計算の１次呼出の充当月数");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 2),
            C_Hrkkaisuu.HALFY, "充当回数計算の１次呼出の払込回数");


        IT_KykKihon kykKihonParam = (IT_KykKihon)
            MockObjectManager.getArgument(KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 0);

        exStringEquals(kykKihonParam.getSyono(), syoNo309, "証券番号");

        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 1), BizDateYM.valueOf(201512), "月払前納指定期間中精算チェックの１次呼出の証明開始年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 2), BizDateYM.valueOf(201611), "月払前納指定期間中精算チェックの１次呼出の証明終了年月");


        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 0),
            BizCurrency.valueOf(18000), "月払前納消滅時精算額計算の１次呼出の控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 1),
            BizCurrency.valueOf(34000), "月払前納消滅時精算額計算の１次呼出の払込保険料");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 2),
            BizDate.valueOf(20131207), "月払前納消滅時精算額計算の１次呼出の控除証明用前納開始年月日");
        exStringEquals((String) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 3),
            "12", "月払前納消滅時精算額計算の１次呼出の控除証明用前納期間（月）");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 4),
            BizDateYM.valueOf(201512), "月払前納消滅時精算額計算の１次呼出の証明開始年月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 5),
            BizDateYM.valueOf(201611), "月払前納消滅時精算額計算の１次呼出の証明終了年月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouSymt", 0, 6),
            BizDateYM.valueOf(201512), "月払前納消滅時精算額計算の１次呼出の精算開始年月");
    }


    @Test
    @Transactional
    @TestOrder(308)
    public void testExec_C10() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo310,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo310);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exDateYMEquals(koujyoSymNaiyouLst.get(5).getSyoumeistartym(), BizDateYM.valueOf("201509"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(6).getSyoumeistartym(), BizDateYM.valueOf("201510"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(7).getSyoumeistartym(), BizDateYM.valueOf("201510"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(8).getSyoumeistartym(), BizDateYM.valueOf("201511"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(9).getSyoumeistartym(), BizDateYM.valueOf("201511"), "証明開始年月");
    }

    @Test
    @Transactional
    @TestOrder(309)
    public void testExec_C11() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(null);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo311,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo311);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo311, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo311, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(1000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_C12() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo311,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "精算時円換算レートが設定されていません。 証券番号 ＝ " + syoNo311, "エラーメッセージ");
        }
    }

    @Test
    @Transactional
    @TestOrder(311)
    public void testExec_C13() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(10,BizCurrencyTypes.DOLLAR));

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(123, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.0001));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo311,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo311);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo311, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo311, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(1240, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(312)
    public void testExec_C14() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo314,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo314);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo314, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo314, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(-1000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(313)
    public void testExec_C15() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.1111));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo314,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo314);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo314, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo314, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(-18, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(314)
    public void testExec_C16() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.1111));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo316,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo316);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo316, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo316, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(2, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(315)
    public void testExec_C17() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo316,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo316);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo316, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo316, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(1), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(316)
    public void testExec_C18() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(202012));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(1);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(9);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo318,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo318);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo318, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo318, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(100), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(317)
    public void testExec_C19() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(202012));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(1);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(9);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.1111));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo318,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo318);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo318, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo318, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_SMT, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(2, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_C20() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(null);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo311,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, syoriYmd);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "精算時円換算レートが設定されていません。 証券番号 ＝ " + syoNo311, "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(321)
    public void testExec_C21() {

        MockObjectManager.initialize();

        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setNyknJskRenno(13);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(14);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        khozenCommonParam.setFunctionId("khsiharaikekkatorikomi");

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
    }

    @Test
    @Transactional
    @TestOrder(404)
    public void testExec_D4() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN3;

        khozenCommonParam.setFunctionId("khgengaku");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(23000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131206));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("6");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(15000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140202));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo404,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo404);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo404, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf(201405), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf(201611), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo404, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf(201611), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(12500), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201512"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 19, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exNumericEquals((int) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 0), 0,
            "充当回数計算の１次呼出の充当年数");
        exNumericEquals((int) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 1), 16,
            "充当回数計算の１次呼出の充当月数");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(JtKaisukeisanMockForKhansyuu.class, "exec", 0, 2),
            null, "充当回数計算の１次呼出の払込回数");
    }

    @Test
    @Transactional
    @TestOrder(405)
    public void testExec_D5() {

        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN3;

        khozenCommonParam.setFunctionId("khgengaku");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo413,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo413);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo413, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201405"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo413, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(-310000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201512"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 19, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(410)
    public void testExec_D10() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("khkeiyakuhenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(23000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131206));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("6");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(15000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140202));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo410,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "変更前の前納用控除証明額計算パラメータが設定されていません。 証券番号 ＝ 30809001643", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(411)
    public void testExec_D11() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("khkeiyakuhenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(23000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131206));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("6");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(15000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140202));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        ZennouKoujyogakuKeisanParam HenmaeZennouKjygkKsParam = new ZennouKoujyogakuKeisanParam();
        HenmaeZennouKjygkKsParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        HenmaeZennouKjygkKsParam.setHrkp(BizCurrency.valueOf(24000));
        HenmaeZennouKjygkKsParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        HenmaeZennouKjygkKsParam.setKjsmyouzennoukikanm("12");
        HenmaeZennouKjygkKsParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(16000));
        HenmaeZennouKjygkKsParam.setZennoukaisiymd(BizDate.valueOf(20140203));
        HenmaeZennouKjygkKsParam.setZennourenno(1);

        editKoujyonaiyouTbl.setHenmaeZennouKoujyogakuKeisanParam(HenmaeZennouKjygkKsParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo410,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo410);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HYOUJI, "計算不可表示区分 ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "RY01", "計算不可理由コードk");
    }

    @Test
    @Transactional
    @TestOrder(412)
    public void testExec_D12() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khkeiyakuhenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(23000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131206));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("6");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(15000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140202));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        ZennouKoujyogakuKeisanParam HenmaeZennouKjygkKsParam = new ZennouKoujyogakuKeisanParam();
        HenmaeZennouKjygkKsParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        HenmaeZennouKjygkKsParam.setHrkp(BizCurrency.valueOf(24000));
        HenmaeZennouKjygkKsParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        HenmaeZennouKjygkKsParam.setKjsmyouzennoukikanm("12");
        HenmaeZennouKjygkKsParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(16000));
        HenmaeZennouKjygkKsParam.setZennoukaisiymd(BizDate.valueOf(20140203));
        HenmaeZennouKjygkKsParam.setZennourenno(1);

        editKoujyonaiyouTbl.setHenmaeZennouKoujyogakuKeisanParam(HenmaeZennouKjygkKsParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo412,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo412);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo412, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201405"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分 ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo412, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(12500), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201512"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 19, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK,
            "控除証明書発行済フラグ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khkeiyakuhenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 0), BizCurrency.valueOf(16000), "月払前納減額時精算額計算の１次呼出の変更前控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 1), BizCurrency.valueOf(15000), "月払前納減額時精算額計算の１次呼出の変更後控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 2), BizCurrency.valueOf(24000), "月払前納減額時精算額計算の１次呼出の変更前払込保険料");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 3), BizCurrency.valueOf(23000), "月払前納減額時精算額計算の１次呼出の変更後払込保険料");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 4), BizDate.valueOf(20131206), "月払前納減額時精算額計算の１次呼出の控除証明用前納開始年月日");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 5), "6", "月払前納減額時精算額計算の１次呼出の控除証明用前納期間（月）");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 6), BizDateYM.valueOf(201405), "月払前納減額時精算額計算の１次呼出の証明開始年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 7), BizDateYM.valueOf(201611), "月払前納減額時精算額計算の１次呼出の証明終了年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 8), BizDateYM.valueOf(201508), "月払前納減額時精算額計算の１次呼出の精算開始年月");
    }

    @Test
    @Transactional
    @TestOrder(413)
    public void testExec_D13() {

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo413,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

    }

    @Test
    @Transactional
    @TestOrder(414)
    public void testExec_D14() {

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(5800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo413,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @Transactional
    @TestOrder(415)
    public void testExec_D15() {

        JtKaisukeisanMockForKhansyuu.SYORIPTN = JtKaisukeisanMockForKhansyuu.TESTPATTERN3;

        khozenCommonParam.setFunctionId("khharaikatahenkou");
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(36000));
        kykSyouhnCommonParam.setKihons(BizCurrency.valueOf(3800));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(5000));
        henmaeKykSyouhnCommonParam.setKihons(BizCurrency.valueOf(4500));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(30000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131029));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(65000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140101));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo414,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo414);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(0), "控除証明額");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khharaikatahenkou", "更新業務用更新機能ＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(416)
    public void testExec_D16() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(null);
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo416,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "精算時円換算レートが設定されていません。 証券番号 ＝ " + syoNo416, "エラーメッセージ");
        }
    }

    @Test
    @Transactional
    @TestOrder(417)
    public void testExec_D17() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        try {
            editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo416,
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "精算時円換算レートが設定されていません。 証券番号 ＝ " + syoNo416, "エラーメッセージ");
        }
    }

    @Test
    @Transactional
    @TestOrder(419)
    public void testExec_D19() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.TUKI);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo418,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo418);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo418, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo418, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(-9000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_D20() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.00007));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo418,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo418);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo418, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo418, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(-9008, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(421)
    public void testExec_D21() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.1111));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo420,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo420);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo420, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo420, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(2, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(422)
    public void testExec_D22() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo420,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo420);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo420, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo420, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(1), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(423)
    public void testExec_D23() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(202012));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(1);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(9);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo422,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo422);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo422, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo422, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(900), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(424)
    public void testExec_D24() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(202012));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(1);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(9);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.00007));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo422,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo422);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo422, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo422, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(901, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(426)
    public void testExec_D26() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.00007));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo425,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo425);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo425, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo425, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201612"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(-13513, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(427)
    public void testExec_D27() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.1111));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo427,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo427);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo427, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo427, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201708"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(2, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(429)
    public void testExec_D29() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(202012));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(1);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(9);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(11));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.YEN));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo429,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo429);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo429, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo429, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(9000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_D30() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        editKoujyonaiyouTbl.setHenmaeHrkKaisuu(C_Hrkkaisuu.NEN);
        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.ARI);
        editKoujyonaiyouTbl.setNyknJskRenno(9);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(1);
        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(202012));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(1);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(9);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(10);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201407));
        editKoujyonaiyouTbl.setNyknJskEndYm(BizDateYM.valueOf(201609));
        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(BizDate.valueOf(20140505));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);
        editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(BizNumber.valueOf(1.00007));
        editKoujyonaiyouTbl.setMkkp(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(34000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("12");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(18000, BizCurrencyTypes.DOLLAR));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140220));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo429,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo429);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();
        exNumericEquals(koujyoSymNaiyouLst.size(), 3, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo429, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(2).getSyono(), syoNo429, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(2).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeistartym(), BizDateYM.valueOf("202101"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getSyoumeiendym(), BizDateYM.valueOf("202208"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(2).getKoujyosyoumeigk(), BizCurrency.valueOf(9010, BizCurrencyTypes.YEN), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201407"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getNyknjskrrkrenno(), 9, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouLst.get(2).getKihrkpssrrkrenno(), 10, "既払込Ｐ精算履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exClassificationEquals(koujyoSymNaiyouLst.get(2).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouLst.get(2).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinKinou(), "khgengaku", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(431)
    public void testExec_D31() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("khkeiyakuhenkou");
        editKoujyonaiyouTbl.setKihrkpSeisanJytYm(BizDateYM.valueOf(201508));
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(2);
        editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(1);
        editKoujyonaiyouTbl.setHenmaeJkipJytYm(BizDateYM.valueOf(201602));
        editKoujyonaiyouTbl.setCalcKjnYmd(BizDate.valueOf("20151101"));
        editKoujyonaiyouTbl.setNyknJskRenno(18);
        editKoujyonaiyouTbl.setKihrkpSeisanRenno(19);
        editKoujyonaiyouTbl.setNyknJskStartYm(BizDateYM.valueOf(201512));
        editKoujyonaiyouTbl.setHenmaeHenkousikibetukey("1");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        IT_KykSyouhn kykSyouhnCommonParam = new IT_KykSyouhn();
        kykSyouhnCommonParam.setSyouhncd("M120");
        kykSyouhnCommonParam.setSyouhnsdno(1);
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
        kykSyouhnCommonParamList.add(kykSyouhnCommonParam);

        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

        IT_KykSyouhn henmaeKykSyouhnCommonParam = new IT_KykSyouhn();
        henmaeKykSyouhnCommonParam.setSyouhncd("M120");
        henmaeKykSyouhnCommonParam.setSyouhnsdno(1);
        henmaeKykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        henmaeKykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(1000));

        List<KykSyouhnCommonParam> henmaeKykSyouhnCommonParamLst = new ArrayList<>();
        henmaeKykSyouhnCommonParamLst.add(henmaeKykSyouhnCommonParam);

        editKoujyonaiyouTbl.setHenmaeKykSyouhnLst(henmaeKykSyouhnCommonParamLst);

        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = new ZennouKoujyogakuKeisanParam();
        zennouKoujyogakuKeisanParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        zennouKoujyogakuKeisanParam.setHrkp(BizCurrency.valueOf(23000));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131206));
        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm("6");
        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(15000));
        zennouKoujyogakuKeisanParam.setZennoukaisiymd(BizDate.valueOf(20140202));
        zennouKoujyogakuKeisanParam.setZennourenno(1);

        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

        ZennouKoujyogakuKeisanParam HenmaeZennouKjygkKsParam = new ZennouKoujyogakuKeisanParam();
        HenmaeZennouKjygkKsParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        HenmaeZennouKjygkKsParam.setHrkp(BizCurrency.valueOf(24000));
        HenmaeZennouKjygkKsParam.setKjsmyouzennoukaisiymd(BizDate.valueOf(20131207));
        HenmaeZennouKjygkKsParam.setKjsmyouzennoukikanm("12");
        HenmaeZennouKjygkKsParam.setKjsmyouzennounyuukinkgk(BizCurrency.valueOf(16000));
        HenmaeZennouKjygkKsParam.setZennoukaisiymd(BizDate.valueOf(20140203));
        HenmaeZennouKjygkKsParam.setZennourenno(1);

        editKoujyonaiyouTbl.setHenmaeZennouKoujyogakuKeisanParam(HenmaeZennouKjygkKsParam);

        C_ErrorKbn errorKbn = editKoujyonaiyouTbl.exec(khozenCommonParam, syoNo431,
            C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU, syoriYmd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo431);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouLst.size(), 2, "要素数");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyono(), syoNo431, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(0).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeistartym(), BizDateYM.valueOf("201405"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getTekiyouseidokbn(), C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(0).getKoujyosyoumeigk(), BizCurrency.valueOf(200), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201509"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(0).getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKeisanhukahyoujikbn(), null, "計算不可表示区分 ");
        exClassificationEquals(koujyoSymNaiyouLst.get(0).getKjsmhakkouzumiflg(), null, "控除証明書発行済フラグ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getKeisanhukariyuucd(), null, "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinKinou(), null, "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(koujyoSymNaiyouLst.get(1).getSyono(), syoNo431, "証券番号");
        exStringEquals(koujyoSymNaiyouLst.get(1).getSyouhncd(), "M120", "商品コード");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeinnd(), "2012", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeistartym(), BizDateYM.valueOf("201508"), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getSyoumeiendym(), BizDateYM.valueOf("201611"), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKoujyosymnaiyoureckbn(), C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコード区分");
        exBizCalcbleEquals(koujyoSymNaiyouLst.get(1).getKoujyosyoumeigk(), BizCurrency.valueOf(0), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201512"), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouLst.get(1).getNyknjskrrkrenno(), 18, "入金実績履歴連番");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKeisanhukahyoujikbn(), C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exClassificationEquals(koujyoSymNaiyouLst.get(1).getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getKeisanhukariyuucd(), "", "計算不可理由コード");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinKinou(), "khkeiyakuhenkou", "更新業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }
}