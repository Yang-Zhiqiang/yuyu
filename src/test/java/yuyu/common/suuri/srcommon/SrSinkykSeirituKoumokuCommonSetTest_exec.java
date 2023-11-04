package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
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
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約成立項目共通設定のメソッド {@link SrSinkykSeirituKoumokuCommonSet#exec(SrSinkykSeirituCommonParam,
 * SinkeiyakuSeirituInfoParam, HT_MosSyouhn, List<HT_MosDairiten>, IT_KykUkt, HT_Nyuukin, HT_Nyuukin, BM_SyouhnZokusei,
 * BM_SjkkkTyouseiyouRiritu, List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean>,
 * List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean>, List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean>,
 * SinkeiyakuSeiritu1Param, SinkeiyakuSeiritu2Param, SinkeiyakuSeiritu3Param,
 * SinkeiyakuSeiritu4Param, SinkeiyakuSeiritu5Param, SinkeiyakuSeiritu6Param)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SrSinkykSeirituKoumokuCommonSetTest_exec {

    @Inject
    private SrSinkykSeirituKoumokuCommonSet srSinkykSeirituKoumokuCommonSet;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約成立項目共通設定";

    private final static String sheetName = "INデータ";

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SrSuuriKbnHenkanSet.class).to(SrSuuriKbnHenkanSetMockForSuuri.class);
                bind(SetHokenNenrei.class).to(SetHokenNenreiMockForSuuri.class);
                bind(GetKawaseRate.class).to(GetKawaseRateMockForSuuri.class);
                bind(KeisanSisuuRendouNkTmttknOverNnd.class).to(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class);
                bind(KeisanWKijunYM.class).to(KeisanWKijunYMMockForSuuri.class);
                bind(SrSuuriGouseiRateKeisan.class).to(SrSuuriGouseiRateKeisanMockForSuuri.class);
                bind(GetSjkkktyouseiyouriritu.class).to(GetSjkkktyouseiyourirituMockForSuuri.class);
                bind(SetManryoubi.class).to(SetManryoubiMockForSuuri.class);
                bind(KeisanVHeijyun.class).to(KeisanVHeijyunMockForSuuri.class);
                bind(GetSisuu.class).to(GetSisuuMockForSuuri.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkykSeirituKoumokuCommonSetTest_exec.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        suuriDomManager.delete(suuriDomManager.getAllSuuriyouErrJyouhou());
        bizDomManager.delete(bizDomManager.getAllDenpyoData());
        bizDomManager.delete(bizDomManager.getAllSyouhnbetuSegment());
    }

    @BeforeClass
    public static void testInit() {

        SrSuuriKbnHenkanSetMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        SetHokenNenreiMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        GetKawaseRateMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        KeisanWKijunYMMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        SrSuuriGouseiRateKeisanMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        GetSjkkktyouseiyourirituMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        SetManryoubiMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        KeisanVHeijyunMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;
        GetSisuuMockForSuuri.caller = SrSinkykSeirituKoumokuCommonSetTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        SrSuuriKbnHenkanSetMockForSuuri.caller = null;
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = null;
        SetHokenNenreiMockForSuuri.caller = null;
        SetHokenNenreiMockForSuuri.SYORIPTN = null;
        GetKawaseRateMockForSuuri.caller = null;
        GetKawaseRateMockForSuuri.SYORIPTN = null;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.caller = null;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = null;
        KeisanWKijunYMMockForSuuri.caller = null;
        KeisanWKijunYMMockForSuuri.SYORIPTN = null;
        SrSuuriGouseiRateKeisanMockForSuuri.caller = null;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = null;
        GetSjkkktyouseiyourirituMockForSuuri.caller = null;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = null;
        SetManryoubiMockForSuuri.caller = null;
        SetManryoubiMockForSuuri.SYORIPTN = null;
        KeisanVHeijyunMockForSuuri.caller = null;
        KeisanVHeijyunMockForSuuri.SYORIPTN = null;
        GetSisuuMockForSuuri.caller = null;
        GetSisuuMockForSuuri.SYORIPTN = null;

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000010");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000016");
        sinkeiyakuSeirituInfoParamImpl.setMosnrkymd(BizDate.valueOf(20160201));
        sinkeiyakuSeirituInfoParamImpl.setSrsyoriymd(BizDate.valueOf(20160202));
        sinkeiyakuSeirituInfoParamImpl.setMosymd(BizDate.valueOf(20160203));
        sinkeiyakuSeirituInfoParamImpl.setMossakuseiymd(BizDate.valueOf(20170817));
        sinkeiyakuSeirituInfoParamImpl.setMosym(BizDateYM.valueOf(201602));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160205));
        sinkeiyakuSeirituInfoParamImpl.setSkykymd(BizDate.valueOf(20160206));
        sinkeiyakuSeirituInfoParamImpl.setSknnkaisiymd(BizDate.valueOf(20160207));

        sinkeiyakuSeirituInfoParamImpl.setSeisekiym(BizDateYM.valueOf(201611));
        sinkeiyakuSeirituInfoParamImpl.setKykseiymd(BizDate.valueOf(20160208));
        sinkeiyakuSeirituInfoParamImpl.setKktymd(BizDate.valueOf(20160209));

        sinkeiyakuSeirituInfoParamImpl.setSpgndtknkbn(C_SpgndtknKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setTargettkhkumu(C_UmuKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1000));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(2000));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(1);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU10);
        sinkeiyakuSeirituInfoParamImpl.setKykdrtkykhukakbn(C_Tkhukaumu.HUKA);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000010");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000016");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyktgysyrymd(), "20160101", "（中継用）結合用処理日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyktgysyono(), "17810000016", "（中継用）結合用証券番号");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyktgyfilerenno(), "1", "（中継用）結合用ファイル連番");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysyono(), "17810000016", "（中継用）証券番号");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisyasisyacd(), "111", "（中継用）Ａ扱者支社コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtymosno(), "990000010", "（中継用）申込番号");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhknsyukigou(), "ｱ1", "（中継用）保険種類記号");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykykymd(), "20160205", "（中継用）契約年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhknkkn(), "10", "（中継用）保険期間");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysaimnkkykhyj(), "1", "（中継用）才満期契約表示");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 100L, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 200L, "（中継用）死亡Ｓ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytksyuannaikykkbn(), "0", "（中継用）特殊案内契約区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysdpdkbn(), "0", "（中継用）Ｓ建Ｐ建区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyduketorihouhoukbn(), "0", "（中継用）Ｄ受取方法区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyhhknsydouituhyouji(), "1", "（中継用）契約者被保険者同一表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtynenkinzeiseitokuyakukbn(), "0", "（中継用）年金税制特約区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysyusseimaekanyuukykkbn(), "0", "（中継用）出生前加入契約区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykazokukeiyakuhyouji(), "0", "（中継用）家族契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyjikokykhyj(), "0", "（中継用）自己契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytuusyoumeisiyouhyouji(), "0", "（中継用）通称名使用表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysethokenkbn(), "0", "（中継用）セット保険区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyteikeisyouhinkbn(), "0", "（中継用）提携商品区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysykgycd(), "123", "（中継用）職業コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyseisekiym(), "201611", "（中継用）成績計上年月");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisisyatodouhukencd(), "456", "（中継用）Ａ扱支社都道府県コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisosikicd(), "1111117", "（中継用）Ａ扱者組織コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaikojincd(), "111116", "（中継用）Ａ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtybatukaisosikicd(), "", "（中継用）Ｂ扱者組織コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtybatukaisyakojincd(), "", "（中継用）Ｂ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysekininkaisiymd(), "20160207", "（中継用）責任開始年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykigetusmkrgkykhyj(), "1", "（中継用）期月締切後契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhensyuusyoriymd(), "20160101", "（中継用）編集処理年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykeiyakubisiteihyouji(), "1", "（中継用）契約日指定表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykeiyakusyasyokugyoucd(), "999", "（中継用）契約者職業コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyseikeikeirokbn(), "90", "（中継用）成契経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhhknmei(), "被保険者名（カナ）", "（中継用）被保険者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyknjhhknmei(), "被保険者名（漢字）", "（中継用）漢字被保険者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhhknseiymd(), "20000101", "（中継用）被保険者生年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhhknseikbn(), "0", "（中継用）被保険者性別区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhihokensyaagev2(), "20", "（中継用）被保険者年令Ｖ２");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhensyuukeiyakusyamei(), "被保険者名（カナ）", "（中継用）編集契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhnsyuknjkyksynm(), "被保険者名（漢字）", "（中継用）編集漢字契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseiymd(), "20000101", "（中継用）契約者生年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseikbn(), "0", "（中継用）契約者性別区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyanen(), "20", "（中継用）契約者年令");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhknsyuruikigousedaikbn(), "1", "（中継用）保険種類記号世代区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytsnsknewyno(), "0101234", "（中継用）通信先新郵便番号");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtymossyumtkktymd(), "20160202", "（中継用）申込消滅確定年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytuusinsakijyuusyokbn(), "0", "（中継用）通信先住所区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykeiyakukakuninsyuruikbn(), "01", "（中継用）契約確認種類区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysuuriyousyoriym(), "201601", "（中継用）数理用処理年月");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyphrkkikn(), "20", "（中継用）Ｐ払込期間");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 1000L, "（中継用）初回払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyukeiyakup(), 200L, "（中継用）主契約Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "0", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyiktkaisuu(), "10", "（中継用）一括回数");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyznnkai(), "2", "（中継用）前納回数");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1000L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 0L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyanniskcd(), "", "（中継用）案内先コード");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtyktgysyrymd(), "20160101", "（中継用）結合用処理日");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtyktgysyono(), "17810000016", "（中継用）結合用証券番号");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtyktgyfilerenno(), "2", "（中継用）結合用ファイル連番");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysiteidairininkbn(), "2", "（中継用）指定代理人区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtystdairiseikyuutkykarihyj(), "1", "（中継用）指定代理請求特約有表示");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtymosjihonninkknnkbn(), null, "（中継用）申込時本人確認区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtyalmyoukijyunym(), "201601", "（中継用）ＡＬＭ用基準年月");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtyhaitousiharaikbn(), "1", "（中継用）配当支払区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyokaipryosyuymd(), "20160103", "（中継用）初回Ｐ領収年月日");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtykbnkeiriyousegcd(), "2801", "（中継用）区分経理用ＳＥＧコード");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "1", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "10", "（中継用）統計用診査区分");
        exNumericEquals(sinkeiyakuseiritu2paramImpl.getZtykokutituusantaisyous(), 100L, "（中継用）告知通算対象Ｓ");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "0", "（中継用）数理用主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtykykdrtkykarihyj(), "1", "（中継用）契約者代理特約有表示");

        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyktgysyrymd(), "20160101", "（中継用）結合用処理日");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyktgysyono(), "17810000016", "（中継用）結合用証券番号");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyktgyfilerenno(), "3", "（中継用）結合用ファイル連番");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybosyuudairitengyousyukbn(), "02", "（中継用）募集代理店業種区分");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtycifcd(), "111111111111115", "（中継用）ＣＩＦコード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtytokusyujimutoriatukaikbn(), "1", "（中継用）特殊事務取扱区分");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtykanyujisyono(), "17810000016", "（中継用）加入時証券番号");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtykanyujikykymd(), "20160205", "（中継用）加入時契約年月日");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtykanyuujihihokensyaage(), "20", "（中継用）加入時被保険者年令");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyaatukaisyadirtnbsynnhyj(), "1", "（中継用）Ａ扱者代理店募集人表示");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybatkisyadirtnbosyuninhyj(), "", "（中継用）Ｂ扱者代理店募集人表示");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtydirtnaatukaisyakojincd(), "111116", "（中継用）代理店Ａ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtydirtnbatukaisyakojincd(), "", "（中継用）代理店Ｂ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyhokensyuruikigouyobi1x1(), "9", "（中継用）保険種類記号予備１＿１");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyhokensyuruikigouyobi1x2(), "1", "（中継用）保険種類記号予備１＿２");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyhokensyuruikigouyobi1x3(), "1", "（中継用）保険種類記号予備１＿３");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyhokensyuruikigouyobi1x4(), "1", "（中継用）保険種類記号予備１＿４");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyhokensyuruikigouyobi3x1(), "2", "（中継用）保険種類記号予備３＿１");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyhokensyuruikigouyobi3x2(), "9", "（中継用）保険種類記号予備３＿２");

        exStringEquals(sinkeiyakuseiritu4paramImpl.getZtyktgysyrymd(), "20160101", "（中継用）結合用処理日");
        exStringEquals(sinkeiyakuseiritu4paramImpl.getZtyktgysyono(), "17810000016", "（中継用）結合用証券番号");
        exStringEquals(sinkeiyakuseiritu4paramImpl.getZtyktgyfilerenno(), "4", "（中継用）結合用ファイル連番");

        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyktgysyrymd(), "20160101", "（中継用）結合用処理日");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyktgysyono(), "17810000016", "（中継用）結合用証券番号");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyktgyfilerenno(), "5", "（中継用）結合用ファイル連番");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyaatukaisyabosyuudirtncd(), "1111127", "（中継用）Ａ扱者募集代理店コード");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtybatukaisyabosyuudirtncd(), "", "（中継用）Ｂ扱者募集代理店コード");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtybosyuukeitaikbn(), "22", "（中継用）募集形態区分");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtykessankeijyouym(), "201601", "（中継用）決算計上年月");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtymusymd(), "20160203", "（中継用）申込年月日");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtymosnyuuryokuymd(), "20160201", "（中継用）申込入力年月日");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtymossyosakuseiymd(), "20170817", "（中継用）申込書作成年月日");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtykokutiymd(), "20160209", "（中継用）告知年月日");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyjyuuryousyouryakukbn(), "21", "（中継用）充領省略区分");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyhhknnentysihyj(), "1", "（中継用）被保険者年令調整表示");
        exBizCalcbleEquals(sinkeiyakuseiritu5paramImpl.getZtysinkeiyakujiyoteiriritu(), BizNumber.valueOf(1),
            "（中継用）新契約時予定利率");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyktgysyrymd(), "20160101", "（中継用）結合用処理日");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyktgysyono(), "17810000016", "（中継用）結合用証券番号");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyktgyfilerenno(), "6", "（中継用）結合用ファイル連番");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyraysystemhyj(), "1", "（中継用）ＲＡＹシステム表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtygaikakbn(), "0", "（中継用）外貨区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(1), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "20160104", "（中継用）契約時為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykeiyakujiyoteiriritu(), BizNumber.valueOf(1),
            "（中継用）契約時予定利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(1),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 400L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykaigomaebaraitkykarihyj(), "1", "（中継用）介護前払特約あり表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysibouhyoukbn(), "47", "（中継用）死亡表区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtymvatyouseikou(), BizNumber.valueOf(1), "（中継用）ＭＶＡ調整項");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtynyuukintuukakbn(), "1", "（中継用）入金通貨区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "0", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 0, "（中継用）円建ターゲット基準金額");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysyuptumitatekin(), 0L, "（中継用）主契約保険料積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatenkgns(), 0L, "（中継用）外貨建年金原資");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytumitatekin(), 0L, "（中継用）積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtykiharaikomip(), 0L, "（中継用）既払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatesyukeiyakup(), 0L, "（中継用）外貨建主契約Ｐ");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();
        srsinkykseiritucommonparam.setIbKakutyoujobcd("RGHEM002");
        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000028");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000027");
        sinkeiyakuSeirituInfoParamImpl.setMosym(BizDateYM.valueOf(201610));
        sinkeiyakuSeirituInfoParamImpl.setSrsyoriymd(BizDate.valueOf(20161001));
        sinkeiyakuSeirituInfoParamImpl.setSkykymd(null);
        sinkeiyakuSeirituInfoParamImpl.setNenkkntknkbn(C_NenkkntknKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setKykkaksyrui(null);
        sinkeiyakuSeirituInfoParamImpl.setKykkbn(C_KykKbn.KEIHI_BETU);
        sinkeiyakuSeirituInfoParamImpl.setKyknen(100);
        sinkeiyakuSeirituInfoParamImpl.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        sinkeiyakuSeirituInfoParamImpl.setSntkhoukbn(C_SntkhouKbn.HJY);
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(16);
        sinkeiyakuSeirituInfoParamImpl.setMosnrkymd(null);
        sinkeiyakuSeirituInfoParamImpl.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setMosymd(BizDate.valueOf(20180101));
        sinkeiyakuSeirituInfoParamImpl.setKktymd(null);
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1000));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(2000));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.HURIKAE);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(0);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setKykdrtkykhukakbn(C_Tkhukaumu.NONE);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000028");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ2");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000027");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ2", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = new ArrayList<>();

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000027");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000027");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        exNumericEquals(suuriyouErrJyouhouLst.size(), 0, "件数");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykigetusmkrgkykhyj(), "0", "（中継用）期月締切後契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykeiyakubisiteihyouji(), "0", "（中継用）契約日指定表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykeiyakukakuninsyuruikbn(), "", "（中継用）契約確認種類区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhensyuukeiyakusyamei(), "契約者名（カナ）", "（中継用）編集契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhnsyuknjkyksynm(), "契約者名（漢字）", "（中継用）編集漢字契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseiymd(), "20160101", "（中継用）契約者生年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseikbn(), "2", "（中継用）契約者性別区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyanen(), "0", "（中継用）契約者年令");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtysaimnkkykhyj(), "0", "（中継用）才満期契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "0", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyznnkai(), "0", "（中継用）前納回数");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyanniskcd(), "", "（中継用）案内先コード");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysiteidairininkbn(), "", "（中継用）指定代理人区分");
        exNumericEquals(sinkeiyakuseiritu2paramImpl.getZtykokutituusantaisyous(), 0L, "（中継用）告知通算対象Ｓ");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtykykdrtkykarihyj(), "0", "（中継用）契約者代理特約有表示");

        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtymosnyuuryokuymd(), "", "（中継用）申込入力年月日");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyhhknnentysihyj(), "0", "（中継用）被保険者年令調整表示");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtykokutiymd(), "20180101", "（中継用）告知年月日");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(1), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "20160104", "（中継用）契約時為替レート適用年月日");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 0L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykaigomaebaraitkykarihyj(), "0", "（中継用）介護前払特約あり表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN2;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN2;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000036");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000038");
        sinkeiyakuSeirituInfoParamImpl.setMosym(BizDateYM.valueOf(201611));
        sinkeiyakuSeirituInfoParamImpl.setSrsyoriymd(BizDate.valueOf(20161130));
        sinkeiyakuSeirituInfoParamImpl.setMossakuseiymd(null);

        sinkeiyakuSeirituInfoParamImpl.setTsngndtknkbn(C_TsngndtknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setKykkbn(C_KykKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setKyknen(99);

        sinkeiyakuSeirituInfoParamImpl.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setHaitoukbn(C_HaitouKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.EUR);

        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.EUR);
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(300.02, BizCurrencyTypes.EURO));

        sinkeiyakuSeirituInfoParamImpl.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(400.02, BizCurrencyTypes.EURO));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(2000));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.CREDIT);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(0);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setKykdrtkykhukakbn(C_Tkhukaumu.BLNK);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000036");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ3");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000038");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ3", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = new ArrayList<>();

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000038");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000038");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });

        exNumericEquals(suuriyouErrJyouhouLst.size(), 12, "件数");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(0).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSuuritoukeiyouerrnaiyou(), "募集代理店業種区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：111136", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(1).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(1).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(1).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(1).getSuuritoukeiyouerrnaiyou(), "募集形態区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：111136", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(2).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(2).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(2).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(2).getSuuritoukeiyouerrnaiyou(),
            "契約確認種類区分区分変換エラー　証券番号：17810000038　変換前区分値：1", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(3).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(3).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(3).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(3).getSuuritoukeiyouerrnaiyou(), "契約者被保険者同一表示区分変換エラー"
            + "　証券番号：17810000038　変換前区分値：0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(4).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(4).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(4).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(4).getSuuritoukeiyouerrnaiyou(),
            "払込回数区分区分変換エラー　証券番号：17810000038　変換前区分値：0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(5).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(5).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(5).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(5).getSuuritoukeiyouerrnaiyou(),
            "払込経路区分区分変換エラー　証券番号：17810000038　変換前区分値：6", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(6).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(6).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(6).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(6).getSuuritoukeiyouerrnaiyou(), "指定代理人区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：3", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(7).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(7).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(7).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(7).getSuuritoukeiyouerrnaiyou(), "数理用入出金通貨区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：EUR", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(8).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(8).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(8).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(8).getSuuritoukeiyouerrnaiyou(), "数理用契約建通貨区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：EUR", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(9).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(9).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(9).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(9).getSuuritoukeiyouerrnaiyou(), "数理用配当区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(10).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(10).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(10).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(10).getSuuritoukeiyouerrnaiyou(), "死亡表区分区分変換エラー　"
            + "証券番号：17810000038　変換前区分値：1", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(11).getSyono(), "17810000038", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(11).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(11).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(11).getSuuritoukeiyouerrnaiyou(),
            "為替レート取得に失敗しました。　20160102,3,EUR,JPY,TTM,1,1,0", "数理統計用エラー内容");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykigetusmkrgkykhyj(), "0", "（中継用）期月締切後契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyhhknsydouituhyouji(), "", "（中継用）契約者被保険者同一表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhensyuukeiyakusyamei(), "契約者名（カナ）", "（中継用）編集契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhnsyuknjkyksynm(), "契約者名（漢字）", "（中継用）編集漢字契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseiymd(), "20160101", "（中継用）契約者生年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseikbn(), "2", "（中継用）契約者性別区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyanen(), "99", "（中継用）契約者年令");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykeiyakukakuninsyuruikbn(), "", "（中継用）契約確認種類区分");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 10002L, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 20002L, "（中継用）死亡Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 30002L, "（中継用）初回払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyukeiyakup(), 20002L, "（中継用）主契約Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 30002L, "（中継用）初年度初回Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "5", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyanniskcd(), "00500000", "（中継用）案内先コード");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysiteidairininkbn(), "", "（中継用）指定代理人区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtymosjihonninkknnkbn(), null, "（中継用）申込時本人確認区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtyhaitousiharaikbn(), "", "（中継用）配当支払区分");
        exNumericEquals(sinkeiyakuseiritu2paramImpl.getZtykokutituusantaisyous(), 10002L, "（中継用）告知通算対象Ｓ");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtykykdrtkykarihyj(), "0", "（中継用）契約者代理特約有表示");

        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybosyuudairitengyousyukbn(), "", "（中継用）募集代理店業種区分");

        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtybosyuukeitaikbn(), "", "（中継用）募集形態区分");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtymossyosakuseiymd(), "", "（中継用）申込書作成年月日");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtygaikakbn(), "", "（中継用）外貨区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(0), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "", "（中継用）契約時為替レート適用年月日");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtynyuukintuukakbn(), "", "（中継用）入金通貨区分");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 40002L, "（中継用）円貨建死亡時最低保証金額");

        suuriDomManager.delete(suuriDomManager.getAllSuuriyouErrJyouhou());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000044");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000049");
        sinkeiyakuSeirituInfoParamImpl.setMosym(BizDateYM.valueOf(201611));
        sinkeiyakuSeirituInfoParamImpl.setSrsyoriymd(BizDate.valueOf(20170101));

        sinkeiyakuSeirituInfoParamImpl.setSentakuinfotknkbn(C_SentakuinfotknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setKykkbn(C_KykKbn.KEIHI_BETU);
        sinkeiyakuSeirituInfoParamImpl.setKyknen(98);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000044");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ4");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000049");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ4", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000049");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000049");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykigetusmkrgkykhyj(), "1", "（中継用）期月締切後契約表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhensyuukeiyakusyamei(), "契約者名（カナ）", "（中継用）編集契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhnsyuknjkyksynm(), "契約者名（漢字）", "（中継用）編集漢字契約者名");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseiymd(), "20160101", "（中継用）契約者生年月日");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyaseikbn(), "2", "（中継用）契約者性別区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtykyksyanen(), "98", "（中継用）契約者年令");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "", "（中継用）料率区分");

        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "50", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000051");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000050");

        sinkeiyakuSeirituInfoParamImpl.setSignalkaihikbn(C_SignalkaihiKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000051");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ5");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000050");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ5", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000050");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = new ArrayList<>();

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000050");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");

        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "50", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000069");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000061");

        sinkeiyakuSeirituInfoParamImpl.setSonotatknkbn(C_SonotaTokuninKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000069");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ6");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000061");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ6", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000061");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000061");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");

        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500L, "（中継用）円建ターゲット基準金額");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000077");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000072");

        sinkeiyakuSeirituInfoParamImpl.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000077");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ7");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000072");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ7", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000072");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000072");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = new ArrayList<>();

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");

        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500L, "（中継用）円建ターゲット基準金額");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000085");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000083");

        sinkeiyakuSeirituInfoParamImpl.setSaiteiptknkbn(C_SaiteiptknKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000085");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ8");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000083");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ8", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000083");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000083");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000083");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");

        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000093");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000094");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000093");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ9");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000094");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ9", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000094");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000094");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000094");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "", "（中継用）特認表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisosikicd(), "", "（中継用）Ａ扱者組織コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaikojincd(), "", "（中継用）Ａ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtybatukaisosikicd(), "", "（中継用）Ｂ扱者組織コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtybatukaisyakojincd(), "", "（中継用）Ｂ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisyasisyacd(), "", "（中継用）Ａ扱者支社コード");

        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtycifcd(), "", "（中継用）ＣＩＦコード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyaatukaisyadirtnbsynnhyj(), "", "（中継用）Ａ扱者代理店募集人表示");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybatkisyadirtnbosyuninhyj(), "", "（中継用）Ｂ扱者代理店募集人表示");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtydirtnaatukaisyakojincd(), "", "（中継用）代理店Ａ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtydirtnbatukaisyakojincd(), "", "（中継用）代理店Ｂ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybosyuudairitengyousyukbn(), "", "（中継用）募集代理店業種区分");

        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyaatukaisyabosyuudirtncd(), "", "（中継用）Ａ扱者募集代理店コード");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtybatukaisyabosyuudirtncd(), "", "（中継用）Ｂ扱者募集代理店コード");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("990000101");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17810000108");

        sinkeiyakuSeirituInfoParamImpl.setSpgndtknkbn(C_SpgndtknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setNenkkntknkbn(C_NenkkntknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setTsngndtknkbn(C_TsngndtknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setSentakuinfotknkbn(C_SentakuinfotknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setSaiteiptknkbn(C_SaiteiptknKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setSignalkaihikbn(C_SignalkaihiKbn.ARI);

        sinkeiyakuSeirituInfoParamImpl.setSonotatknkbn(C_SonotaTokuninKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(2000));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.CREDIT);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(0);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000101");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ10");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17810000108");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ10", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17810000108");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17810000108");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17810000108");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtytokuninhyouji(), "1", "（中継用）特認表示");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisosikicd(), "1111117", "（中継用）Ａ扱者組織コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaikojincd(), "111116", "（中継用）Ａ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtybatukaisosikicd(), "1111127", "（中継用）Ｂ扱者組織コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtybatukaisyakojincd(), "111126", "（中継用）Ｂ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyaatukaisyasisyacd(), "111", "（中継用）Ａ扱者支社コード");

        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtycifcd(), "111111111111115", "（中継用）ＣＩＦコード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtyaatukaisyadirtnbsynnhyj(), "1", "（中継用）Ａ扱者代理店募集人表示");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybatkisyadirtnbosyuninhyj(), "1", "（中継用）Ｂ扱者代理店募集人表示");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtydirtnaatukaisyakojincd(), "111116", "（中継用）代理店Ａ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtydirtnbatukaisyakojincd(), "111126", "（中継用）代理店Ｂ扱者個人コード");
        exStringEquals(sinkeiyakuseiritu3paramImpl.getZtybosyuudairitengyousyukbn(), "02", "（中継用）募集代理店業種区分");

        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtyaatukaisyabosyuudirtncd(), "1111127", "（中継用）Ａ扱者募集代理店コード");
        exStringEquals(sinkeiyakuseiritu5paramImpl.getZtybatukaisyabosyuudirtncd(), "1111227", "（中継用）Ｂ扱者募集代理店コード");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 0, 0),
            C_SrKbnHenkanKbn.DAIRITENGYOUSYU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 0, 1), "1111127",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 1, 0),
            C_SrKbnHenkanKbn.BOSYU_KEITAI, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 1, 1), "1111127",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 2, 0),
            C_SrKbnHenkanKbn.HRK_KAISUU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 2, 1), "0",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 3, 0),
            C_SrKbnHenkanKbn.HRK_KEIRO, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 3, 1), "6",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 4, 0),
            C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 4, 1), "2",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 5, 0),
            C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 5, 1), "1",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 6, 0),
            C_SrKbnHenkanKbn.SHITEI_DAIRININ, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 6, 1), "1",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 7, 0),
            C_SrKbnHenkanKbn.SUURI_HAITOU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 7, 1), "2",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 8, 0),
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 8, 1), "USD",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 9, 0),
            C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 9, 1), "JPY",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 10, 0),
            C_SrKbnHenkanKbn.TUUKA_SYU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 10, 1), "USD",
            "変換前区分値");

        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 11, 0),
            C_SrKbnHenkanKbn.SUURI_SIBOUHYOU, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 11, 1), "1",
            "変換前区分値");


        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNenreiMockForSuuri.class, "exec", 0, 0),
            BizDate.valueOf(20160101), "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNenreiMockForSuuri.class, "exec", 0, 1),
            BizDate.valueOf(20000101), "生年月日");


        exDateEquals((BizDate) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 0),
            BizDate.valueOf(20160102), "為替レート基準日");
        exClassificationEquals(
            (C_KawaserateSyuruiKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 1),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, "為替レート種類区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 2),
            C_Tuukasyu.USD, "元通貨");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 3),
            C_Tuukasyu.JPY, "換算通貨");
        exClassificationEquals(
            (C_KawasetekiyoKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 4),
            C_KawasetekiyoKbn.TTM, "為替適用区分");
        exClassificationEquals((C_KawasetsryKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 5),
            C_KawasetsryKbn.NYUKINRATE, "為替手数料区分");
        exClassificationEquals(
            (C_EigyoubiHoseiKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 6),
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI, "営業日補正区分");
        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 7),
            C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000017");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000013");


        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201803));
        sinkeiyakuSeirituInfoParamImpl.setSknnkaisiymd(BizDate.valueOf(20160102));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160101));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕｹ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17806000013");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17806000013");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17806000013");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 105;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "9", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "14", "（中継用）統計用診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "0", "（中継用）数理用主契約Ｐ割引区分");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyraysystemhyj(), "1", "（中継用）ＲＡＹシステム表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtygaikakbn(), "0", "（中継用）外貨区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykawaserate(), BizNumber.valueOf(1.0), "（中継用）為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykawaseratetekiyouymd(), "20160104", "（中継用）為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(0.0), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "20160104", "（中継用）契約時為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykeiyakujiyoteiriritu(), BizNumber.valueOf(1.0),
            "（中継用）契約時予定利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(3.0), "（中継用）積立利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(1.0),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykaigomaebaraitkykarihyj(), "1", "（中継用）介護前払特約あり表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysibouhyoukbn(), "47", "（中継用）死亡表区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtymvatyouseikou(), BizNumber.valueOf(1.0), "（中継用）ＭＶＡ調整項");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtynyuukintuukakbn(), "1", "（中継用）入金通貨区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurendourate(), "", "（中継用）指数連動部分割合");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuukbn(), "01", "（中継用）指数区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytmttknzoukaritujygn(), BizNumber.valueOf(6.0),
            "（中継用）積立金増加率上限");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysetteibairitu(), BizNumber.valueOf(2.0), "（中継用）設定倍率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykymdsisuu(), BizNumber.valueOf(3.1), "（中継用）契約日指数");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurentumitatekin(), 200L, "（中継用）指数連動部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytirttmtttumitatekin(), 100L, "（中継用）定率積立部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynksjitirttmttkn(), 5L, "（中継用）年金開始時定率積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynendomatutirttumitatekin(), 5L, "（中継用）年度末定率部分積立金");
        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = (GetSjkkktyouseiyourirituBean) MockObjectManager
            .getArgument(GetSjkkktyouseiyourirituMockForSuuri.class, "exec", 0, 0);
        exStringEquals(getSjkkktyouseiyourirituBean.getSyouhncd(), "ﾕｹ", "商品コード");
        exDateEquals(getSjkkktyouseiyourirituBean.getKijyunymd(), BizDate.valueOf("20160102"), "基準日");
        exNumericEquals(getSjkkktyouseiyourirituBean.getHknkkn(), 10, "保険期間");
        exClassificationEquals(getSjkkktyouseiyourirituBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(getSjkkktyouseiyourirituBean.getHhknnen(), 20, "被保険者年齢");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN2;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN2;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN2;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN2;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN2;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN2;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000025");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000024");

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.USD);

        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);

        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201804));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(15000));
        sinkeiyakuSeirituInfoParamImpl.setTeikishrtkykhukaumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕｹ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("860000025");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("860000025");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("860000025");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 105;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });

        exNumericEquals(suuriyouErrJyouhouLst.size(), 17, "件数");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(0).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSuuritoukeiyouerrnaiyou(), "契約確認種類区分区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：1", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(1).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(1).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(1).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(1).getSuuritoukeiyouerrnaiyou(), "契約者被保険者同一表示区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：2", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(2).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(2).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(2).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(2).getSuuritoukeiyouerrnaiyou(),
            "市場価格調整用利率計算エラー　証券番号：17806000024", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(3).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(3).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(3).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(3).getSuuritoukeiyouerrnaiyou(),
            "年度末定率部分積立金計算エラー　証券番号：17806000024", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(4).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(4).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(4).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(4).getSuuritoukeiyouerrnaiyou(),
            "年金開始時定率積立金計算エラー　証券番号：17806000024", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(5).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(5).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(5).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(5).getSuuritoukeiyouerrnaiyou(),
            "払込回数区分区分変換エラー　証券番号：17806000024　変換前区分値：0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(6).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(6).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(6).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(6).getSuuritoukeiyouerrnaiyou(),
            "払込経路区分区分変換エラー　証券番号：17806000024　変換前区分値：0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(7).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(7).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(7).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(7).getSuuritoukeiyouerrnaiyou(), "指定代理人区分区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：1", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(8).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(8).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(8).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(8).getSuuritoukeiyouerrnaiyou(),
            "指数取得：契約日指数計算エラー　証券番号：17806000024", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(9).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(9).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(9).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(9).getSuuritoukeiyouerrnaiyou(), "数理用入出金通貨区分区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：USD", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(10).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(10).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(10).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(10).getSuuritoukeiyouerrnaiyou(), "数理用契約建通貨区分区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：AUD", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(11).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(11).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(11).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(11).getSuuritoukeiyouerrnaiyou(), "数理用指数区分区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(12).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(12).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(12).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(12).getSuuritoukeiyouerrnaiyou(),
            "数理用配当区分区分変換エラー　証券番号：17806000024　変換前区分値：2", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(13).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(13).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(13).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(13).getSuuritoukeiyouerrnaiyou(), "死亡表区分区分変換エラー　"
            + "証券番号：17806000024　変換前区分値：1", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(14).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(14).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(14).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(14).getSuuritoukeiyouerrnaiyou(), "為替レート取得に失敗しました。　"
            + "20160102,1,AUD,USD,TTM,2,1,0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(15).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(15).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(15).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(15).getSuuritoukeiyouerrnaiyou(), "為替レート取得に失敗しました。　"
            + "20160102,3,AUD,JPY,TTM,1,1,0", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(16).getSyono(), "17806000024", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(16).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(16).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(16).getSuuritoukeiyouerrnaiyou(), "為替レート取得に失敗しました。　"
            + "20160102,3,USD,JPY,TTM,1,1,0：合成レート", "数理統計用エラー内容");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyraysystemhyj(), "1", "（中継用）ＲＡＹシステム表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtygaikakbn(), "", "（中継用）外貨区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykawaserate(), BizNumber.valueOf(0.0), "（中継用）為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykawaseratetekiyouymd(), "", "（中継用）為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(0.0), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "", "（中継用）契約時為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykeiyakujiyoteiriritu(), BizNumber.valueOf(1.0),
            "（中継用）契約時予定利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(3.0), "（中継用）積立利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(0.0),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 400L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykaigomaebaraitkykarihyj(), "1", "（中継用）介護前払特約あり表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysibouhyoukbn(), "", "（中継用）死亡表区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtymvatyouseikou(), BizNumber.valueOf(1.0), "（中継用）ＭＶＡ調整項");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtynyuukintuukakbn(), "", "（中継用）入金通貨区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "50", "（中継用）円建Ｗターゲット目標率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurendourate(), "010", "（中継用）指数連動部分割合");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuukbn(), "0", "（中継用）指数区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytmttknzoukaritujygn(), BizNumber.valueOf(6.0),
            "（中継用）積立金増加率上限");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysetteibairitu(), BizNumber.valueOf(2.0), "（中継用）設定倍率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykymdsisuu(), BizNumber.valueOf(0), "（中継用）契約日指数");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500L, "（中継用）円建ターゲット基準金額");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurentumitatekin(), 200L, "（中継用）指数連動部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytirttmtttumitatekin(), 100L, "（中継用）定率積立部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynksjitirttmttkn(), 0L, "（中継用）年金開始時定率積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynendomatutirttumitatekin(), 0L, "（中継用）年度末定率部分積立金");


        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 0), BizDate.valueOf(20160101), "契約日");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 1), 10, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 2), C_UmuKbn.ARI, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 3), C_Tuukasyu.AUD, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 4), BizDate.valueOf(20060101), "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 5), BizDateYM.valueOf(200601), "計算基準年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 6), BizDateYM.valueOf(201803), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 7), BizNumber.valueOf(3), "積立利率");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 8), BizCurrency.valueOf(100), "定率積立金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 9), BizCurrency.valueOf(200), "指数連動積立金額");


        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWKijunYMMockForSuuri.class, "exec", 0, 0),
            BizDate.valueOf(20160101), "契約年月日");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWKijunYMMockForSuuri.class, "exec", 0, 1),
            BizDate.valueOf(20190331), "計算基準日");


        exDateEquals((BizDate) MockObjectManager.getArgument(SrSuuriGouseiRateKeisanMockForSuuri.class, "exec", 0, 0),
            BizDate.valueOf(20160102), "為替レート基準日");
        exClassificationEquals(
            (C_Tuukasyu) MockObjectManager.getArgument(SrSuuriGouseiRateKeisanMockForSuuri.class, "exec", 0, 1),
            C_Tuukasyu.USD, "払込通貨種類");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(SrSuuriGouseiRateKeisanMockForSuuri.class, "exec", 0, 2),
            BizNumber.valueOf(0), "クロスレート");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000033");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000035");

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(30000));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕｹ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17806000035");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17806000035");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17806000035");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 105;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyraysystemhyj(), "1", "（中継用）ＲＡＹシステム表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtygaikakbn(), "0", "（中継用）外貨区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykawaserate(), BizNumber.valueOf(1.0), "（中継用）為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykawaseratetekiyouymd(), "20160104", "（中継用）為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(1.0), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "20160104", "（中継用）契約時為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykeiyakujiyoteiriritu(), BizNumber.valueOf(1.0),
            "（中継用）契約時予定利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(3.0), "（中継用）積立利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(1.0),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykaigomaebaraitkykarihyj(), "1", "（中継用）介護前払特約あり表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysibouhyoukbn(), "47", "（中継用）死亡表区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtymvatyouseikou(), BizNumber.valueOf(1.0), "（中継用）ＭＶＡ調整項");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtynyuukintuukakbn(), "1", "（中継用）入金通貨区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurendourate(), "", "（中継用）指数連動部分割合");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuukbn(), "01", "（中継用）指数区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytmttknzoukaritujygn(), BizNumber.valueOf(6.0),
            "（中継用）積立金増加率上限");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysetteibairitu(), BizNumber.valueOf(2.0), "（中継用）設定倍率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykymdsisuu(), BizNumber.valueOf(3.1), "（中継用）契約日指数");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurentumitatekin(), 200L, "（中継用）指数連動部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytirttmtttumitatekin(), 100L, "（中継用）定率積立部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynksjitirttmttkn(), 5L, "（中継用）年金開始時定率積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynendomatutirttumitatekin(), 5L, "（中継用）年度末定率部分積立金");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000041");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000046");

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.JPY);

        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setSknnkaisiymd(BizDate.valueOf(20160102));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160101));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕｱ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17806000046");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17806000046");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17806000046");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 104;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyraysystemhyj(), "1", "（中継用）ＲＡＹシステム表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtygaikakbn(), "0", "（中継用）外貨区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykawaserate(), BizNumber.valueOf(1.0), "（中継用）為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykawaseratetekiyouymd(), "20160104", "（中継用）為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(1.0), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "20160104", "（中継用）契約時為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykeiyakujiyoteiriritu(), BizNumber.valueOf(1.0),
            "（中継用）契約時予定利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(0.0), "（中継用）積立利率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(1.0),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyenkdtsbujsitihsyukngk(), 809070L, "（中継用）円貨建死亡時最低保証金額");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykaigomaebaraitkykarihyj(), "1", "（中継用）介護前払特約あり表示");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysibouhyoukbn(), "47", "（中継用）死亡表区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtymvatyouseikou(), BizNumber.valueOf(1.0), "（中継用）ＭＶＡ調整項");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtynyuukintuukakbn(), "1", "（中継用）入金通貨区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtywyendttargetmokuhyouritu(), "35", "（中継用）円建Ｗターゲット目標率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurendourate(), "", "（中継用）指数連動部分割合");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuukbn(), "", "（中継用）指数区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytmttknzoukaritujygn(), BizNumber.valueOf(0.0),
            "（中継用）積立金増加率上限");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysetteibairitu(), BizNumber.valueOf(0.0), "（中継用）設定倍率");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykymdsisuu(), BizNumber.valueOf(0.0), "（中継用）契約日指数");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtyyendttargetkijyunkingaku(), 500600L, "（中継用）円建ターゲット基準金額");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurentumitatekin(), 0L, "（中継用）指数連動部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytirttmtttumitatekin(), 0L, "（中継用）定率積立部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynksjitirttmttkn(), 0L, "（中継用）年金開始時定率積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtynendomatutirttumitatekin(), 0L, "（中継用）年度末定率部分積立金");

        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = (GetSjkkktyouseiyourirituBean) MockObjectManager
            .getArgument(GetSjkkktyouseiyourirituMockForSuuri.class, "exec", 0, 0);
        exStringEquals(getSjkkktyouseiyourirituBean.getSyouhncd(), "ﾕｱ", "商品コード");
        exDateEquals(getSjkkktyouseiyourirituBean.getKijyunymd(), BizDate.valueOf("20160101"), "基準日");
        exNumericEquals(getSjkkktyouseiyourirituBean.getHknkkn(), 10, "保険期間");
        exClassificationEquals(getSjkkktyouseiyourirituBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(getSjkkktyouseiyourirituBean.getHhknnen(), 20, "被保険者年齢");
    }

    private SrSinkykSeirituCommonParam getSrSinkykSeirituCommonParam() {

        SrSinkykSeirituCommonParam srSinkykSeirituCommonParam = new SrSinkykSeirituCommonParam();

        srSinkykSeirituCommonParam.setSyoriYmd(BizDate.valueOf(20160101));

        srSinkykSeirituCommonParam.setTyuusyututaisyouym(BizDateYM.valueOf(201601));

        srSinkykSeirituCommonParam.setIbKakutyoujobcd("RGHEM001");
        srSinkykSeirituCommonParam.setErrorsyorikensuu(0);

        return srSinkykSeirituCommonParam;
    }

    private SinkeiyakuSeirituInfoParamImpl getSinkeiyakuSeirituInfoParamImpl() {

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = new SinkeiyakuSeirituInfoParamImpl();

        sinkeiyakuSeirituInfoParamImpl.setMosnrkymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setSrsyoriymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setMosymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setMossakuseiymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setMosym(BizDateYM.valueOf(201601));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setSkykymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setSknnkaisiymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setSeisekiym(BizDateYM.valueOf(201610));
        sinkeiyakuSeirituInfoParamImpl.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        sinkeiyakuSeirituInfoParamImpl.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        sinkeiyakuSeirituInfoParamImpl.setSdpdkbn(C_Sdpd.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSntkhoukbn(C_SntkhouKbn.KKT);
        sinkeiyakuSeirituInfoParamImpl.setHaitoukbn(C_HaitouKbn.RISAHAI);
        sinkeiyakuSeirituInfoParamImpl.setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.USD);
        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.JPY);
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(300));
        sinkeiyakuSeirituInfoParamImpl.setHhknnmkn("被保険者名（カナ）");
        sinkeiyakuSeirituInfoParamImpl.setHhknnmkj("被保険者名（漢字）");
        sinkeiyakuSeirituInfoParamImpl.setHhknseiymd(BizDate.valueOf(20000101));
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(20);
        sinkeiyakuSeirituInfoParamImpl.setHhknsei(C_Hhknsei.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHhknsykgycd("123");
        sinkeiyakuSeirituInfoParamImpl.setKyknmkn("契約者名（カナ）");
        sinkeiyakuSeirituInfoParamImpl.setKyknmkj("契約者名（漢字）");
        sinkeiyakuSeirituInfoParamImpl.setKykseiymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setKyknen(20);
        sinkeiyakuSeirituInfoParamImpl.setKyksei(C_Kyksei.FEMALE);
        sinkeiyakuSeirituInfoParamImpl.setTsinyno("0101234");
        sinkeiyakuSeirituInfoParamImpl.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.BOSIKENKOU);
        sinkeiyakuSeirituInfoParamImpl.setKktymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setKykkaksyrui(C_Kykkaksyrui.KETMAE);
        sinkeiyakuSeirituInfoParamImpl.setSpgndtknkbn(C_SpgndtknKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setNenkkntknkbn(C_NenkkntknKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setTsngndtknkbn(C_TsngndtknKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setSentakuinfotknkbn(C_SentakuinfotknKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setKakoymdkyytknkbn(C_KakoymdkyytknKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setSaiteiptknkbn(C_SaiteiptknKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setSignalkaihikbn(C_SignalkaihiKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setSonotatknkbn(C_SonotaTokuninKbn.NONE);
        sinkeiyakuSeirituInfoParamImpl.setDrtenkanritodoufukencd("456");
        sinkeiyakuSeirituInfoParamImpl.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(400));
        sinkeiyakuSeirituInfoParamImpl.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setTargettkhkumu(C_UmuKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setTargettkykkykhenkoymd(BizDate.valueOf(20170801));
        sinkeiyakuSeirituInfoParamImpl.setTargettkmokuhyouti(50);
        sinkeiyakuSeirituInfoParamImpl.setTargettkykkijyungk(BizCurrency.valueOf(500));
        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201803));
        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(0);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(0));
        sinkeiyakuSeirituInfoParamImpl.setNyknkwsrate(BizNumber.valueOf(0));

        return sinkeiyakuSeirituInfoParamImpl;
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000033");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000035");

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI000);

        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(31000));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕｹ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("17806000035");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("17806000035");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("17806000035");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 105;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "3", "（中継用）料率区分");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 0, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 0, "（中継用）死亡Ｓ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "0", "（中継用）数理用主契約Ｐ割引区分");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuukbn(), "01", "（中継用）指数区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykymdsisuu(), BizNumber.valueOf(0), "（中継用）契約日指数");
    }


    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000015");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000016");
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160205));
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1000));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(14999));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(1);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.JPY);
        sinkeiyakuSeirituInfoParamImpl.setHhknsei(C_Hhknsei.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(12);

        sinkeiyakuSeirituInfoParamImpl.setNyknkwsrate(BizNumber.valueOf(100));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000015");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000016");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000016", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 0L, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 0L, "（中継用）死亡Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 14999L, "（中継用）初回払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyukeiyakup(), 300L, "（中継用）主契約Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "0", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyznnkai(), "2", "（中継用）前納回数");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1000L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 0L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "9", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "14", "（中継用）統計用診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "0", "（中継用）数理用主契約Ｐ割引区分");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(0),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysyuptumitatekin(), 1000L, "（中継用）主契約保険料積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatenkgns(), 1100L, "（中継用）外貨建年金原資");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytumitatekin(), 1000L, "（中継用）積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtykiharaikomip(), 1000L, "（中継用）既払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatesyukeiyakup(), 1000L, "（中継用）外貨建主契約Ｐ");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(-59), "（中継用）積立利率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysrdai1hknkkn(), "12", "（中継用）数理用第１保険期間");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtytuukasyukbn(), "1", "（中継用）通貨種類区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyyobiv9x2(), null, "（中継用）予備項目Ｖ９＿２");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykawaserate(), BizNumber.valueOf(0), "（中継用）為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykawaseratetekiyouymd(), "", "（中継用）為替レート適用年月日");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaserate(), BizNumber.valueOf(0), "（中継用）契約時為替レート");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtykykjikawaseratetkyuymd(), "", "（中継用）契約時為替レート適用年月日");


        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 11, 0),
            C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 11, 1), "1",
            "変換前区分値");


        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateYMEquals(keisanVHeijyunBean.getCalckijyunYm(), BizDateYM.valueOf(201901), "計算基準年月");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160205), "契約日");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(14999), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 12, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 10, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 20, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exClassificationEquals(keisanVHeijyunBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exDateEquals(keisanVHeijyunBean.getFstpryosyu(), BizDate.valueOf(20160104), "初回保険料領収日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(1), "最低保証利率");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.SISAN, "（試算用）試算種類");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), BizDate.valueOf(20160205), "（試算用）処理日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), BizNumber.valueOf(1), "（試算用）予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), BizNumber.valueOf(100), "（試算用）為替レート");

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN2;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN2;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000023");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000027");
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160205));
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1000));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(15000));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(1);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.JPY);
        sinkeiyakuSeirituInfoParamImpl.setHhknsei(C_Hhknsei.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(12);

        sinkeiyakuSeirituInfoParamImpl.setNyknkwsrate(BizNumber.valueOf(100));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000023");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000027");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000027", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });

        exNumericEquals(suuriyouErrJyouhouLst.size(), 19, "件数");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSyono(), "17807000027", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(0).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSuuritoukeiyouerrnaiyou(),
            "外貨建主契約Ｐ計算エラー　証券番号：17807000027", "数理統計用エラー内容");

        exStringEquals(suuriyouErrJyouhouLst.get(18).getSyono(), "17807000027", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(18).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(18).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(18).getSuuritoukeiyouerrnaiyou(),
            "積立利率計算エラー　証券番号：17807000027", "数理統計用エラー内容");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 0L, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 0L, "（中継用）死亡Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 15000L, "（中継用）初回払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyukeiyakup(), 300, "（中継用）主契約Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "0", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyznnkai(), "2", "（中継用）前納回数");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1100L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 0L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "9", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "14", "（中継用）統計用診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "1", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "1", "（中継用）数理用主契約Ｐ割引区分");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(0),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysyuptumitatekin(), 1000L, "（中継用）主契約保険料積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatenkgns(), 0L, "（中継用）外貨建年金原資");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytumitatekin(), 1000L, "（中継用）積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtykiharaikomip(), 1000L, "（中継用）既払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatesyukeiyakup(), 1000L, "（中継用）外貨建主契約Ｐ");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), null, "（中継用）積立利率");


        KeisanVHeijyunBean keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(
            KeisanVHeijyunMockForSuuri.class, "exec", 0, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateYMEquals(keisanVHeijyunBean.getCalckijyunYm(), null, "計算基準年月");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160205), "契約日 ");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(15000), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 12, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 10, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 20, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exClassificationEquals(keisanVHeijyunBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exDateEquals(keisanVHeijyunBean.getFstpryosyu(), BizDate.valueOf(20160104), "初回保険料領収日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(1), "最低保証利率");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.SISAN, "（試算用）試算種類");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), BizDate.valueOf(20160205), "（試算用）処理日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), BizNumber.valueOf(1), "（試算用）予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), BizNumber.valueOf(100), "（試算用）為替レート");

        keisanVHeijyunBean = (KeisanVHeijyunBean) MockObjectManager.getArgument(KeisanVHeijyunMockForSuuri.class, "exec", 1, 0);
        exStringEquals(keisanVHeijyunBean.getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(keisanVHeijyunBean.getRyouritusdno(), "1", "料率世代番号");
        exDateYMEquals(keisanVHeijyunBean.getCalckijyunYm(), BizDateYM.valueOf(201603), "計算基準年月");
        exDateEquals(keisanVHeijyunBean.getKykymd(), BizDate.valueOf(20160205), "契約日 ");
        exBizCalcbleEquals(keisanVHeijyunBean.getHokenryou(), BizCurrency.valueOf(15000), "保険料");
        exClassificationEquals(keisanVHeijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanVHeijyunBean.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exNumericEquals(keisanVHeijyunBean.getHhknnen(), 12, "被保険者年齢");
        exNumericEquals(keisanVHeijyunBean.getHknkkn(), 10, "保険期間");
        exClassificationEquals(keisanVHeijyunBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanVHeijyunBean.getHrkkkn(), 20, "払込期間");
        exClassificationEquals(keisanVHeijyunBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exClassificationEquals(keisanVHeijyunBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exDateEquals(keisanVHeijyunBean.getFstpryosyu(), BizDate.valueOf(20160104), "初回保険料領収日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSitihsyuriritu(), BizNumber.valueOf(1), "最低保証利率");

        exDateYMEquals(keisanVHeijyunBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitenv(), null, "計算開始年月時点Ｖ");
        exBizCalcbleEquals(keisanVHeijyunBean.getCalckaisiYmjitensump(), null, "計算開始年月時点累計Ｐ");
        exClassificationEquals(keisanVHeijyunBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.SISAN, "試算種類区分");
        exDateEquals(keisanVHeijyunBean.getSisansyoriYmd(), BizDate.valueOf(20160205), "予測計算開始日");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisanyoteiriritu(), BizNumber.valueOf(1), "予測計算予定利率");
        exBizCalcbleEquals(keisanVHeijyunBean.getSisankawaserate(), BizNumber.valueOf(100), "予測計算為替レート");

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN2;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000031");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000038");
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(29999));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000031");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000038");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000038", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1200L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 2000L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 29999L, "（中継用）初回払込Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "1", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "1", "（中継用）数理用主契約Ｐ割引区分");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_A19() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN2;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000049");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000049");
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1234));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(30000));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000049");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000049");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000049", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1234L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 0L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 30000L, "（中継用）初回払込Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "2", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "2", "（中継用）数理用主契約Ｐ割引区分");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_A20() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN2;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000056");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000050");
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1234));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(30001));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000056");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000050");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000050", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1234L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 2100L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 30001L, "（中継用）初回払込Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "2", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "2", "（中継用）数理用主契約Ｐ割引区分");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_A21() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN2;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000064");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000061");
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1234));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000064");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000061");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000061", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1234L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 2200L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN2;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN2;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("870000072");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17807000072");
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1234));
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(12);
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20151230));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("870000072");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ｱ1");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17807000072");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ｱ1", 2);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 106;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17807000072", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });

        exStringEquals(suuriyouErrJyouhouLst.get(25).getSyono(), "17807000072", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(25).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(25).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(25).getSuuritoukeiyouerrnaiyou(),
            "死亡表区分２区分変換エラー　証券番号：17807000072　変換前区分値：1", "数理統計用エラー内容");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 3000L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 3100L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 3200L, "（中継用）次年度以降Ｐ");


        exDateEquals((BizDate) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 0),
            BizDate.valueOf(20160212), "為替レート基準日");
        exClassificationEquals(
            (C_KawaserateSyuruiKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 1),
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, "為替レート種類区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 2),
            C_Tuukasyu.USD, "元通貨");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 3),
            C_Tuukasyu.JPY, "換算通貨");
        exClassificationEquals(
            (C_KawasetekiyoKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 4),
            C_KawasetekiyoKbn.TTM, "為替適用区分");
        exClassificationEquals((C_KawasetsryKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 5),
            C_KawasetsryKbn.NYUKINRATE, "為替手数料区分");
        exClassificationEquals(
            (C_EigyoubiHoseiKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 6),
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI, "営業日補正区分");
        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(GetKawaseRateMockForSuuri.class, "exec", 0, 7),
            C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");


        exClassificationEquals(
            (C_SrKbnHenkanKbn) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 11, 0),
            C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2, "数理区分変換区分");
        exStringEquals((String) MockObjectManager.getArgument(SrSuuriKbnHenkanSetMockForSuuri.class, "exec", 11, 1), "1",
            "変換前区分値");


        exDateEquals((BizDate) MockObjectManager.getArgument(SetManryoubiMockForSuuri.class, "exec", 0, 0),
            BizDate.valueOf(20151230), "契約日");
        exNumericEquals((int) MockObjectManager.getArgument(SetManryoubiMockForSuuri.class, "exec", 0, 1), 12, "被保険者年齢");
        exNumericEquals((int) MockObjectManager.getArgument(SetManryoubiMockForSuuri.class, "exec", 0, 2), 10, "期間");
        exClassificationEquals((C_KknsmnKbn) MockObjectManager.getArgument(SetManryoubiMockForSuuri.class, "exec", 0, 3),
            C_KknsmnKbn.SAI, "期間歳満期区分");

    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_A23() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN2;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN2;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN2;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN2;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN2;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000173");
        sinkeiyakuSeirituInfoParamImpl.setSyono("11807111624");

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);

        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.USD);

        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);

        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201804));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(15000));
        sinkeiyakuSeirituInfoParamImpl.setZennoumousideumu(C_UmuKbn.NONE);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾉ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111624");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕﾉ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("860000025");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("860000025");

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("860000025");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 107;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(3.0), "（中継用）積立利率");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_A24() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000058");
        sinkeiyakuSeirituInfoParamImpl.setSyono("11807111118");
        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI000);
        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(31000));
        sinkeiyakuSeirituInfoParamImpl.setTeikishrtkykhukaumu(C_UmuKbn.ARI);
        sinkeiyakuSeirituInfoParamImpl.setSknnkaisiymd(BizDate.valueOf(20160101));
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160102));

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾍ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 1);

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111118");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("11807111118");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("11807111118");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 108;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);


        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 0, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 0, "（中継用）死亡Ｓ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "9", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "14", "（中継用）統計用診査区分");

        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurendourate(), "000", "（中継用）指数連動部分割合");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysisuukbn(), "01", "（中継用）指数区分");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtykykymdsisuu(), BizNumber.valueOf(1.0), "（中継用）契約日指数");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtyrendouritu(), BizNumber.valueOf(0), "（中継用）連動率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysisuurentumitatekin(), 200L, "（中継用）指数連動部分積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytirttmtttumitatekin(), 100L, "（中継用）定率積立部分積立金");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(3.0), "（中継用）積立利率");

        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = (GetSjkkktyouseiyourirituBean) MockObjectManager
            .getArgument(GetSjkkktyouseiyourirituMockForSuuri.class, "exec", 0, 0);
        exStringEquals(getSjkkktyouseiyourirituBean.getSyouhncd(), "ﾕﾍ", "商品コード");
        exDateEquals(getSjkkktyouseiyourirituBean.getKijyunymd(), BizDate.valueOf("20160101"), "基準日");
        exNumericEquals(getSjkkktyouseiyourirituBean.getHknkkn(), 10, "保険期間");
        exClassificationEquals(getSjkkktyouseiyourirituBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(getSjkkktyouseiyourirituBean.getHhknnen(), 20, "被保険者年齢");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 0), BizDate.valueOf(20160102), "契約日");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 1), 10, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 2), C_UmuKbn.ARI, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 3), C_Tuukasyu.AUD, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 4), BizDate.valueOf(20190101), "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 5), BizDateYM.valueOf(201901), "計算基準年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 6), BizDateYM.valueOf(200601), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 7), BizNumber.valueOf(3), "積立利率");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 8), BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 0, 9), BizCurrency.valueOf(2, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 0), BizDate.valueOf(20160102), "契約日");
        exNumericEquals((int)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 1), 10, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 2), C_UmuKbn.ARI, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 3), C_Tuukasyu.AUD, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 4), BizDate.valueOf(20190331), "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 5), BizDateYM.valueOf(201803), "計算基準年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 6), BizDateYM.valueOf(200601), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 7), BizNumber.valueOf(3), "積立利率");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 8), BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknOverNndMockForSuuri.class, "exec", 1, 9), BizCurrency.valueOf(2, BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");

    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_A25() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000066");
        sinkeiyakuSeirituInfoParamImpl.setSyono("11807111129");
        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(31000));
        sinkeiyakuSeirituInfoParamImpl.setTeikishrtkykhukaumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾎ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕﾎ", 1);

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111129");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("11807111129");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("11807111129");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 108;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);

        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtyrendouritu(), BizNumber.valueOf(0.1234), "（中継用）連動率");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_A26() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000074");
        sinkeiyakuSeirituInfoParamImpl.setSyono("11807111130");
        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(31000));
        sinkeiyakuSeirituInfoParamImpl.setTeikishrtkykhukaumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕｺ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕｺ", 1);

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111130");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("11807111130");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("11807111130");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 105;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);

        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtyrendouritu(), BizNumber.valueOf(0), "（中継用）連動率");

    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_A27() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknOverNndMockForSuuri.SYORIPTN = KeisanSisuuRendouNkTmttknOverNndMockForSuuri.TESTPATTERN1;
        KeisanWKijunYMMockForSuuri.SYORIPTN = KeisanWKijunYMMockForSuuri.TESTPATTERN1;
        SrSuuriGouseiRateKeisanMockForSuuri.SYORIPTN = SrSuuriGouseiRateKeisanMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        GetSisuuMockForSuuri.SYORIPTN = GetSisuuMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000082");
        sinkeiyakuSeirituInfoParamImpl.setSyono("11807111141");
        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setHrktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSisuukbn(C_Sisuukbn.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setSkeikeijyouym(BizDateYM.valueOf(201805));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(31000));
        sinkeiyakuSeirituInfoParamImpl.setTeikishrtkykhukaumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾕﾏ");
        List<HT_MosDairiten> mosdairitenLst = new ArrayList<>();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾕﾏ", 1);

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = hozenDomManager
            .getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111141");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftMokuhyoutiAscList("11807111141");
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = hozenDomManager
            .getTargetTokuyakuBefaAftKijyungkAscList("11807111141");

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 108;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = kykKihon.getKhSisuurendoTmttkns().get(0);

        List<BT_DenpyoData> pDenpyoDataList = null;

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, false, "項目編集エラーフラグ");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtyrendouritu(), BizNumber.valueOf(0), "（中継用）連動率");

    }



    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_A28() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN1;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000280");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000286");
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160205));
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1000));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(14999));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(1);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.EUR);
        sinkeiyakuSeirituInfoParamImpl.setHhknsei(C_Hhknsei.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(12);
        sinkeiyakuSeirituInfoParamImpl.setNyknkwsrate(BizNumber.valueOf(100));
        sinkeiyakuSeirituInfoParamImpl.setZennoumousideumu(C_UmuKbn.NONE);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾆｱ");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000286");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 109;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17806000286", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 100L, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 200L, "（中継用）死亡Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 14999L, "（中継用）初回払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyukeiyakup(), 300L, "（中継用）主契約Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "0", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyznnkai(), "2", "（中継用）前納回数");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1000L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 1000L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "9", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "14", "（中継用）統計用診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "0", "（中継用）数理用主契約Ｐ割引区分");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(1),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysyuptumitatekin(), 0L, "（中継用）主契約保険料積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatenkgns(), 0L, "（中継用）外貨建年金原資");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytumitatekin(), 0L, "（中継用）積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtykiharaikomip(), 0L, "（中継用）既払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatesyukeiyakup(), 0L, "（中継用）外貨建主契約Ｐ");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(0), "（中継用）積立利率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysrdai1hknkkn(), "12", "（中継用）数理用第１保険期間");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtytuukasyukbn(), "1", "（中継用）通貨種類区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyyobiv9x2(), null, "（中継用）予備項目Ｖ９＿２");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });

        exNumericEquals(suuriyouErrJyouhouLst.size(), 44, "件数");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSyono(), "17806000286", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(0).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(0).getSuuritoukeiyouerrnaiyou(), "セグメントコード取得エラー　"
            + "証券番号：17806000286　商品コード：ﾆｱ　通貨種類：EUR", "数理統計用エラー内容");

    }


    @Test
    @TestOrder(290)
    @Transactional
    public void testExec_A29() {

        MockObjectManager.initialize();
        SrSuuriKbnHenkanSetMockForSuuri.SYORIPTN = SrSuuriKbnHenkanSetMockForSuuri.TESTPATTERN3;
        SetHokenNenreiMockForSuuri.SYORIPTN = SetHokenNenreiMockForSuuri.TESTPATTERN1;
        GetKawaseRateMockForSuuri.SYORIPTN = GetKawaseRateMockForSuuri.TESTPATTERN1;
        GetSjkkktyouseiyourirituMockForSuuri.SYORIPTN = GetSjkkktyouseiyourirituMockForSuuri.TESTPATTERN1;
        SetManryoubiMockForSuuri.SYORIPTN = SetManryoubiMockForSuuri.TESTPATTERN1;
        KeisanVHeijyunMockForSuuri.SYORIPTN = KeisanVHeijyunMockForSuuri.TESTPATTERN1;

        SrSinkykSeirituCommonParam srsinkykseiritucommonparam = getSrSinkykSeirituCommonParam();

        SinkeiyakuSeirituInfoParamImpl sinkeiyakuSeirituInfoParamImpl = getSinkeiyakuSeirituInfoParamImpl();
        sinkeiyakuSeirituInfoParamImpl.setMosno("860000298");
        sinkeiyakuSeirituInfoParamImpl.setSyono("17806000297");
        sinkeiyakuSeirituInfoParamImpl.setKykymd(BizDate.valueOf(20160205));
        sinkeiyakuSeirituInfoParamImpl.setHyouteip(BizCurrency.valueOf(1000));
        sinkeiyakuSeirituInfoParamImpl.setHeijyunp(BizCurrency.valueOf(14999));
        sinkeiyakuSeirituInfoParamImpl.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        sinkeiyakuSeirituInfoParamImpl.setZnnkai(1);
        sinkeiyakuSeirituInfoParamImpl.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        sinkeiyakuSeirituInfoParamImpl.setKyktuukasyu(C_Tuukasyu.AUD);
        sinkeiyakuSeirituInfoParamImpl.setHhknsei(C_Hhknsei.BLNK);
        sinkeiyakuSeirituInfoParamImpl.setHhknnen(12);
        sinkeiyakuSeirituInfoParamImpl.setNyknkwsrate(BizNumber.valueOf(100));
        sinkeiyakuSeirituInfoParamImpl.setZennoumousideumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000280");
        HT_MosSyouhn mossyouhn = syoriCTL.getMosSyouhnBySyouhncd("ﾆｱ");
        List<HT_MosDairiten> mosdairitenLst = syoriCTL.getMosDairitens();
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        HT_Nyuukin nyuukinMax = nyuukinLst.get(0);
        HT_Nyuukin nyuukinMin = nyuukinLst.get(1);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000297");
        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);

        BM_SyouhnZokusei syouhnzokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 1);


        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList = null;

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList = null;

        SinkeiyakuSeiritu1ParamImpl sinkeiyakuseiritu1ParamImpl = new SinkeiyakuSeiritu1ParamImpl();
        SinkeiyakuSeiritu2ParamImpl sinkeiyakuseiritu2paramImpl = new SinkeiyakuSeiritu2ParamImpl();
        SinkeiyakuSeiritu3ParamImpl sinkeiyakuseiritu3paramImpl = new SinkeiyakuSeiritu3ParamImpl();
        SinkeiyakuSeiritu4ParamImpl sinkeiyakuseiritu4paramImpl = new SinkeiyakuSeiritu4ParamImpl();
        SinkeiyakuSeiritu5ParamImpl sinkeiyakuseiritu5paramImpl = new SinkeiyakuSeiritu5ParamImpl();
        SinkeiyakuSeiritu6ParamImpl sinkeiyakuseiritu6paramImpl = new SinkeiyakuSeiritu6ParamImpl();
        int syohinHanteiKbn = 109;
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;


        List<BT_DenpyoData> pDenpyoDataList = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "17806000297", C_DensyoriKbn.BLNK);

        boolean errorFlag = srSinkykSeirituKoumokuCommonSet.exec(srsinkykseiritucommonparam,
            sinkeiyakuSeirituInfoParamImpl, mossyouhn, mosdairitenLst, kykUkt, nyuukinMax, nyuukinMin, syouhnzokusei,
            khHenkouRirekiBeanList, targetTokuyakuMokuhyoutiHistoryBeanList,
            targetTokuyakuKijyunKingakuHistoryBeanList, sinkeiyakuseiritu1ParamImpl, sinkeiyakuseiritu2paramImpl,
            sinkeiyakuseiritu3paramImpl, sinkeiyakuseiritu4paramImpl, sinkeiyakuseiritu5paramImpl,
            sinkeiyakuseiritu6paramImpl, syohinHanteiKbn, khSisuurendoTmttkn, pDenpyoDataList);

        exBooleanEquals(errorFlag, true, "項目編集エラーフラグ");

        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtykihons(), 100L, "（中継用）基本Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysibous(), 200L, "（中継用）死亡Ｓ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyokaiharaikomip(), 14999L, "（中継用）初回払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyukeiyakup(), 300L, "（中継用）主契約Ｐ");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkaisuukbn(), "0", "（中継用）払込回数区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyhrkkeirokbn(), "0", "（中継用）払込経路区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyryouritukbn(), "0", "（中継用）料率区分");
        exStringEquals(sinkeiyakuseiritu1ParamImpl.getZtyznnkai(), "2", "（中継用）前納回数");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendosyokaip(), 1000L, "（中継用）初年度初回Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtysyonendo2kaimeikoup(), 0L, "（中継用）初年度２回目以降Ｐ");
        exNumericEquals(sinkeiyakuseiritu1ParamImpl.getZtyjinendoikoup(), 0L, "（中継用）次年度以降Ｐ");

        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysinsakbn(), "9", "（中継用）診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtytoukeiyousinsakbn(), "14", "（中継用）統計用診査区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysyukeiyakupwaribikikbn(), "0", "（中継用）主契約Ｐ割引区分");
        exStringEquals(sinkeiyakuseiritu2paramImpl.getZtysuryusykykpwrbkkbn(), "0", "（中継用）数理用主契約Ｐ割引区分");

        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtysrkyksjkkktyouseiriritu(), BizNumber.valueOf(1),
            "（中継用）数理用契約時市場価格調整用利率");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtysyuptumitatekin(), 0L, "（中継用）主契約保険料積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatenkgns(), 0L, "（中継用）外貨建年金原資");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtytumitatekin(), 0L, "（中継用）積立金");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtykiharaikomip(), 0L, "（中継用）既払込Ｐ");
        exNumericEquals(sinkeiyakuseiritu6paramImpl.getZtygaikadatesyukeiyakup(), 0L, "（中継用）外貨建主契約Ｐ");
        exBizCalcbleEquals(sinkeiyakuseiritu6paramImpl.getZtytumitateriritu(), BizNumber.valueOf(0), "（中継用）積立利率");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtysrdai1hknkkn(), "12", "（中継用）数理用第１保険期間");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtytuukasyukbn(), "", "（中継用）通貨種類区分");
        exStringEquals(sinkeiyakuseiritu6paramImpl.getZtyyobiv9x2(), null, "（中継用）予備項目Ｖ９＿２");

        List<ST_SuuriyouErrJyouhou> suuriyouErrJyouhouLst = suuriDomManager.getAllSuuriyouErrJyouhou();

        Collections.sort(suuriyouErrJyouhouLst, new Comparator<ST_SuuriyouErrJyouhou>() {
            @Override
            public int compare(ST_SuuriyouErrJyouhou group1, ST_SuuriyouErrJyouhou group2) {
                return group1.getSuuritoukeiyouerrnaiyou().compareTo(
                    group2.getSuuritoukeiyouerrnaiyou());
            }
        });

        exNumericEquals(suuriyouErrJyouhouLst.size(), 45, "件数");
        exStringEquals(suuriyouErrJyouhouLst.get(44).getSyono(), "17806000297", "証券番号");
        exDateEquals(suuriyouErrJyouhouLst.get(44).getSyoriYmd(), BizDate.valueOf(20160101), "処理年月日");
        exStringEquals(suuriyouErrJyouhouLst.get(44).getKakutyoujobcd(), "RGHEM001", "拡張ジョブコード");
        exStringEquals(suuriyouErrJyouhouLst.get(44).getSuuritoukeiyouerrnaiyou(), "通貨種類区分区分変換エラー　"
            + "証券番号：17806000297　変換前区分値：AUD", "数理統計用エラー内容");

    }
}
