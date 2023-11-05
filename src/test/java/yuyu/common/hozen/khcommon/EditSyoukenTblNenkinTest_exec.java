package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 保険証券TBL編集（年金）クラスのメソッド {@link EditSyoukenTblNenkin#editTBL(IT_HokenSyouken, IT_KykKihon,
 * EditHokenSyoukenParam, List<IT_NyknJissekiRireki>, IT_KykSya, List<IT_KykSyouhn>, IT_KykSonotaTkyk,
 * List<IT_KykUkt>, IT_KykUkt, int, C_UmuKbn, C_KjkhukaKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblNenkinTest_exec {

    @Inject
    private EditSyoukenTblNenkin editSyoukenTblNenkin;

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（機能）_保険証券TBL編集（年金）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanKijyungk.class).to(KeisanKijyungkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanKijyungkMockForHozen.caller = EditSyoukenTblNenkinTest_exec.class;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {

        KeisanKijyungkMockForHozen.caller = null;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblNenkinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180731));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn1(), null, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn2(), null, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn3(), null, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn4(), null, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn5(), null, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn6(), null, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn7(), null, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn8(), null, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn9(), null, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn10(), null, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn1(), null, "（証券）受取人区分１");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn2(), null, "（証券）受取人区分２");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn3(), null, "（証券）受取人区分３");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn4(), null, "（証券）受取人区分４");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn5(), null, "（証券）受取人区分５");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn6(), null, "（証券）受取人区分６");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn7(), null, "（証券）受取人区分７");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn8(), null, "（証券）受取人区分８");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn9(), null, "（証券）受取人区分９");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn10(), null, "（証券）受取人区分１０");
        exStringEquals(hokenSyouken.getSyoukenuktnm1(), null, "（証券）受取人名１");
        exStringEquals(hokenSyouken.getSyoukenuktnm2(), null, "（証券）受取人名２");
        exStringEquals(hokenSyouken.getSyoukenuktnm3(), null, "（証券）受取人名３");
        exStringEquals(hokenSyouken.getSyoukenuktnm4(), null, "（証券）受取人名４");
        exStringEquals(hokenSyouken.getSyoukenuktnm5(), null, "（証券）受取人名５");
        exStringEquals(hokenSyouken.getSyoukenuktnm6(), null, "（証券）受取人名６");
        exStringEquals(hokenSyouken.getSyoukenuktnm7(), null, "（証券）受取人名７");
        exStringEquals(hokenSyouken.getSyoukenuktnm8(), null, "（証券）受取人名８");
        exStringEquals(hokenSyouken.getSyoukenuktnm9(), null, "（証券）受取人名９");
        exStringEquals(hokenSyouken.getSyoukenuktnm10(), null, "（証券）受取人名１０");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari1(), null, "（証券）受取人分割割合１");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari2(), null, "（証券）受取人分割割合２");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari3(), null, "（証券）受取人分割割合３");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari4(), null, "（証券）受取人分割割合４");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari5(), null, "（証券）受取人分割割合５");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari6(), null, "（証券）受取人分割割合６");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari7(), null, "（証券）受取人分割割合７");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari8(), null, "（証券）受取人分割割合８");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari9(), null, "（証券）受取人分割割合９");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari10(), null, "（証券）受取人分割割合１０");
        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1200), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05021", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(500), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09021", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09043", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09041", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09042", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09051", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09035", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09083", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09110", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09102", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14053", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14062", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1200), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.12), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1200), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12213", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), "【１０３】", "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02072", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09044", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09045", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09046", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09041", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09060", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09037", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09085", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13126", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14040", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14076", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), null, "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20001), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10001), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), null, "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12353", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), null, "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(99), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), "【４０５】", "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02040", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09042", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09045", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09046", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09036", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09084", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09110", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09102", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13126", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14054", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14072", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15043", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), null, "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12207", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12219", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12220", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05022", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09026", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09024", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09030", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09031", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09034", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09042", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09045", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09046", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09048", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09060", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14024", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14051", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14054", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10003), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12214", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14017", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14018", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09044", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09045", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09046", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09051", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09060", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09110", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09102", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13126", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14025", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), null, "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1425), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(75), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12229", "年金メッセージコード３");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12355", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02072", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09043", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09033", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09085", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14044", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14056", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14076", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), null, "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20005), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12221", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12353", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sinkykjyoutai, sksyoukenskskbn, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05040", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09033", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09083", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14026", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14038", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14054", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14074", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), null, "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10006), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12209", "年金メッセージコード３");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12355", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14025", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14027", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02072", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09043", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09051", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09037", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09085", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13077", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13126", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14046", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14056", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14054", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14076", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), null, "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20007), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12223", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12353", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }
    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02072", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05022", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09026", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09024", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09030", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09031", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09034", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09044", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09045", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09046", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09051", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09060", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "09035", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "09083", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13074", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14043", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14052", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14053", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14074", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20008), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10008), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12332", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14025", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14027", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09034", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09051", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09037", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09083", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13091", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14040", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14074", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10009), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12211", "年金メッセージコード３");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12351", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05022", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09031", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09042", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09045", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09046", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09051", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09060", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09036", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09083", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14054", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14074", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10000), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12210", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12332", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000127");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02040", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09042", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09045", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09046", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09050", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09036", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09083", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09110", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09102", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15043", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12211", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000138");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02040", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05021", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09021", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09051", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09035", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09083", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09110", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09102", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12209", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02040", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09035", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09084", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09110", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09102", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14072", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12217", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12349", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09034", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09051", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14024", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12219", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14017", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14018", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000161");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09042", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09045", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09046", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09051", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09060", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09033", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09085", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14024", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14038", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14076", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12217", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12349", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14017", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14018", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000172");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09043", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09050", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09036", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09083", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09110", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09102", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14053", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14062", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15043", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12215", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A18() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000183");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09043", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09050", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09060", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09035", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09083", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09110", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09102", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14054", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14062", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12213", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A19() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000194");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02072", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09034", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09043", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09051", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09060", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09037", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09083", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13091", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14046", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14056", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14074", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12215", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A20() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000208");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02072", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09043", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09051", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09033", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09083", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13076", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14044", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14056", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14053", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14074", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12213", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_A21() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000219");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05022", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09031", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09043", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09051", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09036", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09083", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13091", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14056", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14074", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12212", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12332", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_A22() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000220");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09043", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09050", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09110", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09102", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12223", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_A23() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000231");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02040", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09035", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09084", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09110", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09102", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14072", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12217", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_A24() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000242");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09034", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09043", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09051", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09060", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14046", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14056", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12223", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(250)
    public void testEditTBL_A25() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000253");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02070", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09042", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09045", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09046", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09051", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09060", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09033", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09085", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14038", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14076", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10000), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12217", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12349", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(260)
    public void testEditTBL_A26() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000264");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02072", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05022", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09031", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09043", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09051", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09036", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09085", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14056", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14076", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12229", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12214", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12349", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(270)
    public void testEditTBL_A27() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000275");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09044", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09045", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09046", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09050", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09036", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09083", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09110", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09102", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14025", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15043", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1425), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(75), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12227", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(280)
    public void testEditTBL_A28() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000286");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09044", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09035", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09083", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09110", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09102", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14025", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1425), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(75), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12225", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(290)
    public void testEditTBL_A29() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000297");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02072", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");

        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09034", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09044", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09051", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09037", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09083", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14041", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14074", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1425), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(75), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12227", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14017", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14018", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(300)
    public void testEditTBL_A30() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000301");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02072", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09044", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09045", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09046", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09051", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09060", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09033", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09083", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14038", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14074", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10000), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12225", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(310)
    public void testEditTBL_A31() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000014");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09044", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09110", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09102", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13210", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14025", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1425), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(75), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12228", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(320)
    public void testEditTBL_A32() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000025");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 3;
        int sinkykjyoutai = 0;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02072", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09044", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09045", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09046", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09041", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09051", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09060", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "09033", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "09085", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14038", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14076", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(800), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10000), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), null, "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), null, "年金メッセージコード５");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12349", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(330)
    public void testEditTBL_A33() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000036");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 5;
        int sinkykjyoutai = 0;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02031", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "02072", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "02062", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(0.32), "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05022", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09031", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09044", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09045", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09046", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09051", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09060", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "09", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13130", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(20000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(10000), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12214", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(340)
    public void testEditTBL_A34() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000047");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09043", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09041", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09050", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09110", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09102", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13210", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1500), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12221", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(350)
    public void testEditTBL_A35() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000069");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02031", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02074", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05011", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "10", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09088", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09001", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09002", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09006", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13093", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "14081", "解約返戻金メッセージコード表下１");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), BizDate.valueOf(20190611), "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12230", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12334", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
    }

    @Test
    @TestOrder(360)
    public void testEditTBL_A36() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000070");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02031", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02074", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05011", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "10", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09089", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09001", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09002", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09006", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09051", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13093", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "14081", "解約返戻金メッセージコード表下１");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), null, "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), null, "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), BizDate.valueOf(20190611), "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), null, "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), null, "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12230", "年金メッセージコード４");

        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12334", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(0), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(100), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");


        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
    }

    @Test
    @TestOrder(370)
    public void testEditTBL_A37() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000081");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02027", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02029", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02490", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180101), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");

        exStringEquals(hokenSyouken.getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(1500), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(800), "主契約特約保険金額１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09020", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09044", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09045", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09046", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09050", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09035", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09084", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09110", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "09102", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13073", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13091", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "08", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13128", "ご負担費用説明欄メッセージコード表下２");

        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(100), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13192", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14025", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14072", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1500), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(100), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        exDateEquals(hokenSyouken.getSonotanyrannkshrstartymd(), BizDate.valueOf(20180831), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrannenkinkkn(), BizNumber.valueOf(2), "その他内容欄年金期間");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.11), "その他内容欄積立利率 ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.03), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransetteibairitu(), BizNumber.valueOf(1.3), "その他内容欄設定倍率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "JPY", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1425), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyouken.getSonotanyransisuutmttkngk(), BizCurrency.valueOf(75), "その他内容欄指数積立金額 ");
        exStringEquals(hokenSyouken.getSonotanyransisuunm(), "", "その他内容欄指数名");

        exStringEquals(hokenSyouken.getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyouken.getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyouken.getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyouken.getNkmsgcd4(), "12228", "年金メッセージコード４");
        exStringEquals(hokenSyouken.getNkmsgcd5(), "12220", "年金メッセージコード５");


        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyouken.getSiboukyuuhukinmsgcd4(), "12349", "死亡給付金メッセージコード４");

        exStringEquals(hokenSyouken.getNkshrstartzenymd(), "20180830", "年金支払開始日前日");
        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(95), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(5), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1.0), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyouken.getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");
        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
    }

    @Test
    @TestOrder(390)
    public void testEditTBL_A38() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806019974");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05041", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09021", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09033", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09083", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
    }

    @Test
    @TestOrder(400)
    public void testEditTBL_A39() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806019985");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180801));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        int sksyoukenskskbn = 2;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
            syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
            sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05041", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09021", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09042", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09045", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09046", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09033", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09083", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(380)
    public void testEditTBL_B1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN1;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("18806000058");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukens().get(0);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180802));

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();

        IT_KykSya kykSya = kykKihon.getKykSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        int sksyoukenskskbn = 1;
        int sinkykjyoutai = 2;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.KJKHUKA;
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        try{

            editSyoukenTblNenkin.editTBL(hokenSyouken, kykKihon, editHokenSyoukenParam, nyknJissekiRirekiLst, kykSya,
                syuKykSyouhnLst, kykSonotaTkyk, sibouhokenLst, siteiDairi, sksyoukenskskbn, sinkykjyoutai, gengakuExistsCheck,
                sbUktNmKjHukaKbn, yendthnkSyoriKbn);

        } catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。基準金額が取得できませんでした。", "メッセージ内容");
            exDateEquals((BizDate) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 0),
                BizDate.valueOf(20170101), "初回保険料入金日");
            exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 1),
                BizCurrency.valueOf(100), "領収金額");
            exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 2),
                BizCurrency.valueOf(1520), "領収金額");
            exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 3),
                C_Tuukasyu.USD, "契約通貨種類");
            exClassificationEquals((C_Tkhukaumu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 4),
                C_Tkhukaumu.HUKA, "円入金特約付加区分");

            throw e;
        }
    }
}