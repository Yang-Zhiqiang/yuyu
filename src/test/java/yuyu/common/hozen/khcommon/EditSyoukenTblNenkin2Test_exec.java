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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険証券TBL編集（年金２）クラスのメソッド {@link editSyoukenTblNenkin22#editTBL(IT_HokenSyouken,IT_KykKihon,EditHokenSyoukenParam,List<IT_NyknJissekiRireki>,IT_KykSya,List<IT_KykSyouhn>,IT_KykSonotaTkyk,List<IT_KykUkt>,IT_KykUkt,int,C_UmuKbn,C_KjkhukaKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblNenkin2Test_exec {

    @Inject
    private EditSyoukenTblNenkin2 editSyoukenTblNenkin2;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（機能）_保険証券TBL編集（年金２）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanTukiIkkatuNyuukinGkMockForHozen.caller = EditSyoukenTblNenkin2Test_exec.class;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN =null;
    }

    @AfterClass
    public static void testClear() {

        KeisanTukiIkkatuNyuukinGkMockForHozen.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN =null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblNenkin2Test_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());

    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000013");
        pKykKihon.setSbuktnin(2);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));
        pKykKihon.setHrkp(BizCurrency.valueOf(1520));
        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.CREDIT);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180731));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");
        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);


        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(0));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.USD);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20170631));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(5));

        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));


        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLNK);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1200));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180701));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(500));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.12));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.22));

        pSyuKykSyouhn1.setNenkinkkn(5);

        pSyuKykSyouhn1.setHrkkkn(7);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(1.2));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();
        kykUkt1.setUktkbn(C_UktKbn.BLNK);
        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        pSibouhokenLst.add(kykUkt1);


        IT_KykUkt pSiteiDairi = null;

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), "02512", "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180701), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "05042", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "7", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "04", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09023", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09055", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09086", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "09104", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(1.35), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13079", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "10", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14017", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14057", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), "12224", "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12339", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14018", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20180201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);


        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000024");
        pKykKihon.setSbuktnin(1);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.KYK);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(1));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180201));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20140631));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(7));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));
        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(7);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(0));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();

        kykUkt1.setUktkbn(C_UktKbn.HHKN);
        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        pSibouhokenLst.add(kykUkt1);


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        pSiteiDairi.setUktkbn(C_UktKbn.KYK);


        pSiteiDairi.setUktnmkj("受取人名（漢字）");

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");



        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "7", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "08072", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09005", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09055", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13092", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14055", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180201), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), "12226", "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12337", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180131", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(99), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(1), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（第１回年金倍額型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000035");
        pKykKihon.setSbuktnin(1);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.HHKN);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HGU);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.BLNK);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20180102));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(10));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(10);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.ZENNOU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(0));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();

        kykUkt1.setUktkbn(C_UktKbn.KYK);
        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        pSibouhokenLst.add(kykUkt1);


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        pSiteiDairi.setUktkbn(C_UktKbn.KYK);

        pSiteiDairi.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

        pSiteiDairi.setUktnmkj("受取人名（漢字）");

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");
        pIT_Zennou.setZennounyuukinkgk(BizCurrency.valueOf(100000));


        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), "02512", "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), "05015", "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), "05016", "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "10", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "2", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09055", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09104", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(1.35), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13078", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13151", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(150000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14017", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14056", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14058", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12207", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), null, "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12337", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), null, "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14018", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "毎年１月・７月", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==6, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(150000), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==13, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(150000), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(50000), "定期一括払円貨払込額");

    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000046");
        pKykKihon.setSbuktnin(1);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.SOUZOKUNIN);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20200831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20090731));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(11));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(1));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(11);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();

        kykUkt1.setUktkbn(C_UktKbn.SOUZOKUNIN);
        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        pSibouhokenLst.add(kykUkt1);


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        pSiteiDairi.setUktkbn(C_UktKbn.SBUK);

        pSiteiDairi.setUktnmkj("受取人名（漢字）");

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "05042", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "10", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09025", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13085", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "10", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14063", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20200831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), "12224", "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12338", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20200830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000057");
        pKykKihon.setSbuktnin(1);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.HUKUSUU);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HGU);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(5));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20110102));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(10));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(10);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();

        kykUkt1.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        pSibouhokenLst.add(kykUkt1);


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        pSiteiDairi.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

        pSiteiDairi.setUktnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);

        pSiteiDairi.setUktnmkj("受取人名（漢字）");

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), "02512", "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "10", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09104", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(1.35), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13078", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14017", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14056", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12224", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12337", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12351", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14018", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000068");
        pKykKihon.setSbuktnin(1);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.HHKN);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HGU);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.SGKHSYSYSNNENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(0));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20200831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20100731));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(9));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(2));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(9);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(0));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();
        IT_KykUkt kykUkt2 = new IT_KykUkt();
        IT_KykUkt kykUkt3 = new IT_KykUkt();

        kykUkt1.setUktkbn(C_UktKbn.SBUK);
        kykUkt2.setUktkbn(C_UktKbn.HHKN);
        kykUkt3.setUktkbn(C_UktKbn.KYK);
        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        kykUkt2.setUktbnwari(BizNumber.valueOf(20));
        kykUkt3.setUktbnwari(BizNumber.valueOf(30));
        pSibouhokenLst.add(kykUkt1);
        pSibouhokenLst.add(kykUkt2);
        pSibouhokenLst.add(kykUkt3);


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        pSiteiDairi.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

        pSiteiDairi.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

        pSiteiDairi.setUktnmkj("受取人名（漢字）");

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "05042", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "7", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09023", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09055", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13083", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "10", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14055", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20200831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12207", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), null, "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12337", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), null, "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20200830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20180201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000079");
        pKykKihon.setSbuktnin(2);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);



        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.BLNK);

        kykUkt.setUktkbn(C_UktKbn.KYK);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HGU);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.SGKHSYSYSNNENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180201));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20100801));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(10));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(5);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();
        IT_KykUkt kykUkt2 = new IT_KykUkt();

        kykUkt1.setUktkbn(C_UktKbn.HHKN);
        kykUkt2.setUktkbn(C_UktKbn.KYK);

        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        kykUkt2.setUktbnwari(BizNumber.valueOf(20));
        pSibouhokenLst.add(kykUkt1);
        pSibouhokenLst.add(kykUkt2);


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        pSiteiDairi.setUktkbn(C_UktKbn.NASI);

        pSiteiDairi.setUktnmkj("受取人名（漢字）");

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");



        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);



        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "05042", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "5", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09023", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09055", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13084", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "10", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14057", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180201), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), null, "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), null, "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12339", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), null, "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180131", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000080");
        pKykKihon.setSbuktnin(1);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.SOUZOKUNIN);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.SGKHSYSYSNNENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(0));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20200831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20100702));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(9));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLCON1);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(5);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));
        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(0));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();
        IT_KykUkt kykUkt1 = new IT_KykUkt();
        IT_KykUkt kykUkt2 = new IT_KykUkt();
        IT_KykUkt kykUkt3 = new IT_KykUkt();
        IT_KykUkt kykUkt4 = new IT_KykUkt();
        IT_KykUkt kykUkt5 = new IT_KykUkt();

        kykUkt1.setUktbnwari(BizNumber.valueOf(10));
        kykUkt2.setUktbnwari(BizNumber.valueOf(20));
        kykUkt3.setUktbnwari(BizNumber.valueOf(30));
        kykUkt4.setUktbnwari(BizNumber.valueOf(40));
        kykUkt5.setUktbnwari(BizNumber.valueOf(50));

        kykUkt1.setUktnmkj("受取人名1");
        kykUkt2.setUktnmkj("受取人名2");
        kykUkt3.setUktnmkj("受取人名3");
        kykUkt4.setUktnmkj("受取人名4");
        kykUkt5.setUktnmkj("受取人名5");

        kykUkt1.setUktkbn(C_UktKbn.HHKN);
        kykUkt2.setUktkbn(C_UktKbn.KYK);
        kykUkt3.setUktkbn(C_UktKbn.SOUZOKUNIN);
        kykUkt4.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        kykUkt5.setUktkbn(C_UktKbn.NASI);
        pSibouhokenLst.add(kykUkt1);
        pSibouhokenLst.add(kykUkt2);
        pSibouhokenLst.add(kykUkt3);
        pSibouhokenLst.add(kykUkt4);
        pSibouhokenLst.add(kykUkt5);


        IT_KykUkt pSiteiDairi = null;

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "5", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09051", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09055", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13084", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14057", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20200831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12207", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), null, "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12339", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), null, "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20200830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }
    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000091");
        pKykKihon.setSbuktnin(4);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.BLNK);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);


        List<IT_KykUkt> iT_KykUkts = new ArrayList<>();
        IT_KykUkt kykUkt = new IT_KykUkt();
        kykUkt.setUktsyukbn(C_UktsyuKbn.NKUKT);

        kykUkt.setUktkbn(C_UktKbn.HHKN);
        iT_KykUkts.add(kykUkt);
        pKykKihon.setKykUkts(iT_KykUkts);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HGU);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(5));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20200831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(19990602));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(5));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLNK);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180101));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(10);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(10);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);



        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), "05015", "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "05042", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "10", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "2", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09025", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09051", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09055", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13086", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "10", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14064", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20200831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(10), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), "12224", "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12340", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20200830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "毎年６月・１２月", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型１０年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==6, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(50000), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000208");
        pKykKihon.setSbuktnin(5);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.BLNK);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HGU);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20130202));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(5));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLNK);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(15);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(5);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.ZENNOU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.NONE);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");
        pIT_Zennou.setZennounyuukinkgk(BizCurrency.valueOf(100000));



        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), "05015", "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), "05016", "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "5", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "1", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "00", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13078", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14055", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14058", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(15), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12224", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12337", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12351", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "毎年２月", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型１５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==12, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(150000), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==13, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(150000), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(50000), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN2;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000116");
        pKykKihon.setSbuktnin(3);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.CREDIT);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf(20180831));
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20110102));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(10));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLNK);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(20);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(5);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");


        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), "02052", "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.35), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "5", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "04", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09087", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13079", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14064", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(20), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), "12224", "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12340", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14031", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "毎月１日から末日まで", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000127");
        pKykKihon.setSbuktnin(14);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.CREDIT);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕｱ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(null);
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20180102));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(3));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLNK);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(5);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");



        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);


        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(pHokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd1(), "02512", "表示欄右メッセージコード１");
        exStringEquals(pHokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(pHokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180606), "表示欄責任開始日");
        exBizCalcbleEquals(pHokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exStringEquals(pHokenSyouken.getPmsgcd1(), "05014", "保険料メッセージコード１");
        exStringEquals(pHokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(pHokenSyouken.getPmsgcd3(), null, "保険料メッセージコード３");
        exClassificationEquals(pHokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenryou(), BizCurrency.valueOf(1520), "保険料");
        exStringEquals(pHokenSyouken.getPtuuka(), "円", "保険料通貨");
        exStringEquals(pHokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(pHokenSyouken.getHrkkknmsgkbn(), "5", "払込期間メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(pHokenSyouken.getHrkhouhoumsgkbn(), "04", "払込方法メッセージ区分");
        exStringEquals(pHokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(pHokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(pHokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(pHokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd1(), "08070", "契約内容欄下メッセージコード１");
        exStringEquals(pHokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exClassificationEquals(pHokenSyouken.getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrankjnkngk(), BizCurrency.valueOf(12000), "その他内容欄基準金額");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(1.35), "その他内容欄予定利率");
        exStringEquals(pHokenSyouken.getTnknmissmsg(), "【３４０】", "転換ミスメッセージ");
        exStringEquals(pHokenSyouken.getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue01(), "13079", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(pHokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(pHokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(pHokenSyouken.getFstpmsgcd(), "13050", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(pHokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(1520), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(pHokenSyouken.getWmsgcd1(), "14017", "解約返戻金メッセージコード１");
        exStringEquals(pHokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(pHokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd1(), "14057", "解約返戻金注意事項メッセージコード１");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd2(), "14059", "解約返戻金注意事項メッセージコード２");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exDateEquals(pHokenSyouken.getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(pHokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(5), "その他内容欄年金期間");

        exStringEquals(pHokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(pHokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(pHokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(pHokenSyouken.getNkmsgcd4(), "12224", "年金メッセージコード４");

        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd2(), "12339", "死亡給付金メッセージコード２");
        exStringEquals(pHokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(pHokenSyouken.getNkshrstartzenymd(), null, "年金支払開始日前日");
        exBizCalcbleEquals(pHokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(pHokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(pHokenSyouken.getWmsgcd21(), "14018", "解約返戻金メッセージコード２＿１");

        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(pHokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(pHokenSyouken.getPhrkktuki(), "", "保険料払込期月");


        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(130)
    public void testEditTBL_A13() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN2;
        IT_HokenSyoukenHukaInfo  pHokenSyoukenHukaInfo = SWAKInjector.getInstance(IT_HokenSyoukenHukaInfo.class);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn1(C_UmuKbn.NONE);
        pHokenSyoukenHukaInfo.setKzktirasidouhuukbn2(C_UmuKbn.NONE);

        IT_HokenSyouken pHokenSyouken = SWAKInjector.getInstance(IT_HokenSyouken.class);
        pHokenSyouken.setTyouhyouymd(BizDate.valueOf(20200201));
        pHokenSyouken.setHenkousikibetukey("1001");
        pHokenSyouken.setFstpmsgcd("13050");
        pHokenSyouken.setHosyounymsgcd("11010");
        pHokenSyouken.setHokenSyoukenHukaInfo(pHokenSyoukenHukaInfo);

        IT_KykKihon pKykKihon = SWAKInjector.getInstance(IT_KykKihon.class);
        pKykKihon.setSyono("17806000138");
        pKykKihon.setSbuktnin(14);
        pKykKihon.setFstpnyknymd(BizDate.valueOf(20170101));

        pKykKihon.setHrkp(BizCurrency.valueOf(1520));

        pKykKihon.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        pKykKihon.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);
        pKykKihon.setHrkkeiro(C_Hrkkeiro.CREDIT);
        pKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        pKykKihon.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB_SASSI);

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));


        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = new ArrayList<>();

        IT_NyknJissekiRireki nyknJissekiRireki1 = new IT_NyknJissekiRireki();

        nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(100));

        nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.USD);

        nyknJissekiRireki1.setHrkp(BizCurrency.valueOf(800));
        pNyknJissekiRirekiLst.add(nyknJissekiRireki1);

        IT_KykSya pKykSya = SWAKInjector.getInstance(IT_KykSya.class);

        pKykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        pKykSya.setKkkyktdk(C_Tdk.HONNIN);

        pKykSya.setKyknmkj("契約者名（漢字）");


        List<IT_KykSyouhn> pSyuKykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn pSyuKykSyouhn1 = new IT_KykSyouhn();
        pSyuKykSyouhn1.setSyouhncd("ﾕﾁ");
        pSyuKykSyouhn1.setSyouhnsdno(Integer.valueOf(1));
        pSyuKykSyouhn1.setRyouritusdno("J");

        pSyuKykSyouhn1.setNksyukbn(C_Nenkinsyu.KAKUTEINENKIN);

        pSyuKykSyouhn1.setKykjisisuurendourate(BizNumber.valueOf(100));

        pSyuKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
        pSyuKykSyouhn1.setHknkknmanryouymd(null);
        pSyuKykSyouhn1.setKykymd(BizDate.valueOf(20180102));
        pSyuKykSyouhn1.setHknkkn(Integer.valueOf(3));
        pSyuKykSyouhn1.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        pSyuKykSyouhn1.setHhknnen(Integer.valueOf(0));

        pSyuKykSyouhn1.setSisuukbn(C_Sisuukbn.BLNK);

        pSyuKykSyouhn1.setHokenryou(BizCurrency.valueOf(1500));
        pSyuKykSyouhn1.setSknnkaisiymd(BizDate.valueOf(20180606));
        pSyuKykSyouhn1.setKihons(BizCurrency.valueOf(800));

        pSyuKykSyouhn1.setTumitateriritu(BizNumber.valueOf(0.11));

        pSyuKykSyouhn1.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.32));

        pSyuKykSyouhn1.setNenkinkkn(5);
        pSyuKykSyouhn1.setTmttknzoukaritujygn(BizNumber.valueOf(0.03));
        pSyuKykSyouhn1.setSetteibairitu(BizNumber.valueOf(1.3));
        pSyuKykSyouhn1.setHrkkkn(5);
        pSyuKykSyouhn1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pSyuKykSyouhn1.setYoteiriritu(BizNumber.valueOf(2.3));
        pSyuKykSyouhn1.setPharaikomisougaku(BizCurrency.valueOf(12000));

        pSyuKykSyouhnLst.add(pSyuKykSyouhn1);

        IT_KykSonotaTkyk pKykSonotaTkyk = SWAKInjector.getInstance(IT_KykSonotaTkyk.class);
        pKykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
        pKykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
        pKykSonotaTkyk.setTargettkmokuhyouti(Integer.valueOf(1));
        pKykSonotaTkyk.setZeiseitkkktkykhukaumu(C_UmuKbn.ARI);


        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();


        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        try {

            editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
                pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
                pSbUktNmKjHukaKbn, pIT_Zennou);
        } catch(CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。予定利率取得が実行できませんでした。", "メッセージ内容");

            throw e;
        }
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000149");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn1(), null, "（証券）受取人見出し区分１");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn2(), null, "（証券）受取人見出し区分２");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn3(), null, "（証券）受取人見出し区分３");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn4(), null, "（証券）受取人見出し区分４");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn5(), null, "（証券）受取人見出し区分５");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn6(), null, "（証券）受取人見出し区分６");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn7(), null, "（証券）受取人見出し区分７");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn8(), null, "（証券）受取人見出し区分８");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn9(), null, "（証券）受取人見出し区分９");
        exClassificationEquals(pHokenSyouken.getSyoukenuktmidasikbn10(), null, "（証券）受取人見出し区分１０");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn1(), null, "（証券）受取人区分１");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn2(), null, "（証券）受取人区分２");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn3(), null, "（証券）受取人区分３");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn4(), null, "（証券）受取人区分４");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn5(), null, "（証券）受取人区分５");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn6(), null, "（証券）受取人区分６");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn7(), null, "（証券）受取人区分７");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn8(), null, "（証券）受取人区分８");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn9(), null, "（証券）受取人区分９");
        exClassificationEquals(pHokenSyouken.getSyoukenuktkbn10(), null, "（証券）受取人区分１０");
        exStringEquals(pHokenSyouken.getSyoukenuktnm1(), null, "（証券）受取人名１");
        exStringEquals(pHokenSyouken.getSyoukenuktnm2(), null, "（証券）受取人名２");
        exStringEquals(pHokenSyouken.getSyoukenuktnm3(), null, "（証券）受取人名３");
        exStringEquals(pHokenSyouken.getSyoukenuktnm4(), null, "（証券）受取人名４");
        exStringEquals(pHokenSyouken.getSyoukenuktnm5(), null, "（証券）受取人名５");
        exStringEquals(pHokenSyouken.getSyoukenuktnm6(), null, "（証券）受取人名６");
        exStringEquals(pHokenSyouken.getSyoukenuktnm7(), null, "（証券）受取人名７");
        exStringEquals(pHokenSyouken.getSyoukenuktnm8(), null, "（証券）受取人名８");
        exStringEquals(pHokenSyouken.getSyoukenuktnm9(), null, "（証券）受取人名９");
        exStringEquals(pHokenSyouken.getSyoukenuktnm10(), null, "（証券）受取人名１０");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari1(), null, "（証券）受取人分割割合１");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari2(), null, "（証券）受取人分割割合２");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari3(), null, "（証券）受取人分割割合３");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari4(), null, "（証券）受取人分割割合４");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari5(), null, "（証券）受取人分割割合５");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari6(), null, "（証券）受取人分割割合６");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari7(), null, "（証券）受取人分割割合７");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari8(), null, "（証券）受取人分割割合８");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari9(), null, "（証券）受取人分割割合９");
        exBizCalcbleEquals(pHokenSyouken.getSyoukenuktbnwari10(),null, "（証券）受取人分割割合１０");
        exStringEquals(pHokenSyouken.getSyoukenuktnm9(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(pHokenSyouken.getSyoukenuktnm9(), null, "しおり番号");

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getSyono(), "17806000149", "証券番号");
        exDateEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTyouhyouymd(), BizDate.valueOf("20200401"), "契約日");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");

        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn1(), C_UmuKbn.ARI, "ご家族登録チラシ１同封区分");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn2(), C_UmuKbn.NONE, "ご家族登録チラシ２同封区分");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKykdairitirasidouhuukbn(), null, "保険契約者代理人チラシ同封区分");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getSkhtirasidouhuukbn(), null, "債権法チラシ同封区分");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getYakkannewoldkbn(), null, "約款新旧区分");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg1(), null, "ご家族登録サービスメッセージコード１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg2(), null, "ご家族登録サービスメッセージコード２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg3(), null, "ご家族登録サービスメッセージコード３");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg4(), null, "ご家族登録サービスメッセージコード４");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg5(), null, "ご家族登録サービスメッセージコード５");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg6(), null, "ご家族登録サービスメッセージコード６");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg7(), null, "ご家族登録サービスメッセージコード７");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg8(), null, "ご家族登録サービスメッセージコード８");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzknmkj118(), null, "登録家族名１（１８桁）");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzksei1(), null, "登録家族性別１");
        exDateEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkseiymd1(), null, "登録家族生年月日１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkyno1(), null, "登録家族郵便番号１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr1kj1(), null, "登録家族住所１（漢字）１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr2kj1(), null, "登録家族住所２（漢字）１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr3kj1(), null, "登録家族住所３（漢字）１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno1(), null, "登録家族電話番号１");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzknmkj218(), null, "登録家族名２（１８桁）");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzksei2(), null, "登録家族性別２");
        exDateEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkseiymd2(), null, "登録家族生年月日２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkyno2(), null, "登録家族郵便番号２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr1kj2(), null, "登録家族住所１（漢字）２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr2kj2(), null, "登録家族住所２（漢字）２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr3kj2(), null, "登録家族住所３（漢字）２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno2(), null, "登録家族電話番号２");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getKykdairinm18(), null, "契約者代理人名（１８桁）");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHhkndairinm(), null, "被保険者代理人氏名");

    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000150");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }


    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000161");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000172");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09042", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A18() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000183");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A19() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000194");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A20() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000356");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_A21() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000219");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_A22() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000220");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_A23() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000231");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_A24() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000242");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(250)
    public void testEditTBL_A25() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000253");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(260)
    public void testEditTBL_A26() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000264");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 1;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09086", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "09104", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(270)
    public void testEditTBL_A27() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000297");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09087", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu() == 0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY,
            "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0),
            "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2() == 0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(),
            BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(),
            BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY,
            "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0),
            "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY,
            "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY,
            "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0),
            "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(280)

    public void testEditTBL_A28() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000301");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09087", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }


    @Test
    @TestOrder(290)
    public void testEditTBL_A29() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000312");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09087", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }
    @Test
    @TestOrder(300)
    public void testEditTBL_A30() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000323");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09048", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09087", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }

    @Test
    @TestOrder(310)
    public void testEditTBL_A31() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForHozen.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("17806000334");

        IT_HokenSyouken pHokenSyouken = pKykKihon.getHokenSyoukens().get(0);

        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekis();

        IT_KykSya pKykSya = pKykKihon.getKykSya();

        List<IT_KykSyouhn> pSyuKykSyouhnLst = pKykKihon.getKykSyouhns();

        IT_KykSonotaTkyk pKykSonotaTkyk = pKykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> pSibouhokenLst = new ArrayList<>();

        IT_KykUkt pSiteiDairi = new IT_KykUkt();

        IT_Zennou pIT_Zennou = SWAKInjector.getInstance(IT_Zennou.class);
        pIT_Zennou.setZennoukikan("12");

        int pSksyoukenskskbn = 2;
        int sinkykjyoutai = 2;

        C_UmuKbn pGengakuExistsCheck = C_UmuKbn.ARI;

        C_KjkhukaKbn pSbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        editSyoukenTblNenkin2.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya,
            pSyuKykSyouhnLst, pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, sinkykjyoutai, pGengakuExistsCheck,
            pSbUktNmKjHukaKbn, pIT_Zennou);

        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd2(), "09004", "その他内容欄メッセージコード２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd6(), "09055", "その他内容欄メッセージコード６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd8(), "09087", "その他内容欄メッセージコード８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(pHokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHenkousikibetukey(), "1001", "変更識別キー");
        exStringEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken(), "（定額年金型５年確定年金）", "年金種類名称（証券用）");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()==0, true, "定期一括払月数 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
        exBooleanEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()==0, true, "前納回数（２桁）");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin(), BizNumber.valueOf(0.03), "ご負担費用説明欄解約控除率最小");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax(), BizNumber.valueOf(0.31), "ご負担費用説明欄解約控除率最大 ");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk(), BizCurrency.valueOf(0), "初回Ｐご確認欄前納金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype(), C_Tuukasyu.JPY, "ＤＳ基準金額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk(), BizCurrency.valueOf(12000), "ＤＳ基準金額");
        exClassificationEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "定期一括払円貨払込額通貨タイプ");
        exBizCalcbleEquals(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk(), BizCurrency.valueOf(0), "定期一括払円貨払込額");
    }
}