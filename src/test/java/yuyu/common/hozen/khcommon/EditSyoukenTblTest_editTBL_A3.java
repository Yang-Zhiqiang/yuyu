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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.GetKawaseRateMock;
import yuyu.common.biz.bzcommon.HanteiHokenKikanMock;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMock;
import yuyu.common.biz.bzdairiten.BzGetAgInfoMock;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMock;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険証券TBL編集クラスのメソッド {@link EditSyoukenTbl#editTBL(KhozenCommonParam,IT_KykKihon,List,IT_KykSonotaTkyk,List,IT_SyouhnTokujou,IT_KykSya,IT_HhknSya,IT_KykUkt,IT_KykUkt,List,IT_KhTtdkTyuui,List,List,EditHokenSyoukenParam,BizDate,C_SinsaihkKbn,C_TetudukisyuKbn,C_HassouKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblTest_editTBL_A3 {

    private final static String syoNo1 = "20806000019";

    private final static String syoNo2 = "20806000020";

    private final static String syoNo3 = "20806000031";

    private final static String syoNo4 = "20806000042";

    private final static String syoNo5 = "20806000053";

    private final static String syoNo6 = "20806000064";

    private final static String syoNo7 = "20806000075";

    private final static String syoNo8 = "20806000086";

    private final static String syoNo9 = "20806000097";

    private final static String syoNo10 = "20806000101";

    private final static String syoNo11 = "20806000112";

    private final static String syoNo12 = "20806000123";

    private final static String syoNo13 = "20806000134";

    private final static String syoNo14 = "20806000145";

    private final static String syoNo15 = "20806000156";

    private final static String syoNo16 = "20806000167";

    private final static String syoNo17 = "20806000178";

    private final static String syoNo18 = "20806000189";

    private final static String syoNo19 = "20806000190";

    private final static String syoNo20 = "20806000204";

    private final static String syoNo21 = "20806000215";

    private final static String syoNo22 = "20806000226";

    private final static String syoNo23 = "20806000237";

    private final static String syoNo24 = "20806000248";

    private final static String syoNo25 = "20806000259";

    private final static String syoNo26 = "20806000260";

    private final static String syoNo27 = "20806000271";

    private final static String syoNo28 = "20806000282";

    private final static String syoNo29 = "20806000293";

    private final static String syoNo30 = "20806000307";

    private final static String syoNo31 = "20806000318";

    private final static String syoNo32 = "20806000329";

    private final static String syoNo33 = "20806000330";

    private final static String syoNo34 = "20806000341";

    private final static String syoNo35 = "20806000352";

    private final static String syoNo36 = "20806000363";

    private final static String syoNo37 = "20806000374";

    private final static String syoNo38 = "20806000385";

    private final static String kbnKey1 = "01";

    private final static String kbnKey2 = "02";

    private final static String kbnKey3 = "03";

    private final static String kbnKey4 = "04";

    private final static String kbnKey5 = "05";

    private final static String kbnKey6 = "06";

    private final static String kbnKey7 = "07";

    private final static String kbnKey8 = "08";

    private final static String kbnKey9 = "09";

    private final static String kbnKey10 = "00";

    @Inject
    private EditSyoukenTbl editSyoukenTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditHokenSyoukenParam editHokenSyoukenParam;

    private final static String fileName = "UT-SP_単体テスト仕様書_保険証券TBL編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    public static void testInit() {
        HanteiHokenKikanMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        KeisanKijyungkMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        BzGetAgInfoMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        SetOutoubiMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        GetKawaseRateMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        CalcHkShrKngkMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        KeisanGaikakanzanMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        CalcJdkghkKngkMock.caller = EditSyoukenTblTest_editTBL_A3.class;
        EditSuiihyouTblMock.caller = EditSyoukenTblTest_editTBL_A3.class;
    }

    @AfterClass
    public static void testClear() {
        HanteiHokenKikanMock.caller = null;
        KeisanKijyungkMock.caller = null;
        BzGetAgInfoMock.caller = null;
        SetOutoubiMock.caller = null;
        GetKawaseRateMock.caller = null;
        CalcHkShrKngkMock.caller = null;
        KeisanGaikakanzanMock.caller = null;
        CalcJdkghkKngkMock.caller = null;
        EditSuiihyouTblMock.caller = null;

        HanteiHokenKikanMock.SYORIPTN = null;
        KeisanKijyungkMock.SYORIPTN = null;
        BzGetAgInfoMock.SYORIPTN = null;
        SetOutoubiMock.SYORIPTN = null;
        GetKawaseRateMock.SYORIPTN = null;
        CalcHkShrKngkMock.SYORIPTN = null;
        KeisanGaikakanzanMock.SYORIPTN = null;
        CalcJdkghkKngkMock.SYORIPTN = null;
        EditSuiihyouTblMock.SYORIPTN = null;

        MockObjectManager.initialize();
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblTest_editTBL_A3.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllTantouCd());
        bizDomManager.delete(bizDomManager.getAllSisuuKihon());
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_D1() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000010");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = new ArrayList<>();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo1, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "円", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.USD, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "米ドル", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(30), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "1234567", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字１", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "10010", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000019", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "10020", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "10030", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "10040", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 10, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 10, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(0), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(0), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(0), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(200), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(0), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.BLNK, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(0), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.BLNK, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(0), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(0), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(0), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_D2() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000020");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = new ArrayList<>();

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo2, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.USD, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "米ドル", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(30), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(11000), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字２", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "10010", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000020", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "10020", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "10030", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "10040", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字２", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12030", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "12020", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 20, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(150), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(120), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(130), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(140), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(120), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(130), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(140), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "12209", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_D3() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000030");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo3, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(60), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(11000), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(50), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(11000), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字３", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "10010", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000031", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.SHOP, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "漢字法人商号１２３４５６７８９０１２３", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "10020", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "10030", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "10040", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字３", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12040", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "12020", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 1, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 19, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 1, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(100), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "12211", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12349", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_D4() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000040");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo4, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(60), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "10010", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000042", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.MIZUHO, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "漢字法人商号１２３４５６７８９０１２３４", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "10020", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "10030", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "10040", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "12074", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "12100", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "12140", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 1, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(100), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 19, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(100), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12217", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12351", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_D5() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000050");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo5, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(110), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(60), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(110), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000053", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(110), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(110), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), BizDate.valueOf(20200101), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), BizDate.valueOf(20210701), "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(110), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12210", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_D6() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000060");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo6, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(60), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(60), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(160), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(160), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000064", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "12018", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), null, "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), null, "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(160), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(0), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(150), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(160), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(170), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12210", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12332", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12355", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }
    @Test
    @TestOrder(70)
    public void testEditTBL_D7() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000070");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo7, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(60), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(11000), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000075", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "12054", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "12074", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "12078", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "12090", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12114", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "12130", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(150), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(150), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(150), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), BizDate.valueOf(20200101), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(150), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(150), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(160), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(170), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(150), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(160), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(170), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12209", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12333", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12355", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_D8() {

        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000080");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo8, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(60), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(60), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000086", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "12012", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), BizDate.valueOf(20200101), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(100), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12220", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12345", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_D9() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000090");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo9, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(60), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(60), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000097", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), BizDate.valueOf(20200101), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(100), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(150), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(150), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12212", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12332", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_D10() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000100");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo10, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(11000), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(50), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(11000), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000101", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(160), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12211", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12335", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12355", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_D11() {

        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000110");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo11, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(60), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000112", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "12014", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(150), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12217", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12341", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_D12() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000120");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo12);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo12, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(11000), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(50), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000123", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "12016", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12114", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(0), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(150), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(100), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(100), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12219", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_D13() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000130");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo13);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo13, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(11000), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(50), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "10010", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000134", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "10020", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "10030", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "10040", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "12100", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "12140", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 2, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 8, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(160), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(160), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 1, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 2, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(160), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(160), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(150), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(160), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(170), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(150), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(160), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(170), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12219", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "12220", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12343", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "12345", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "12351", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_D14() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000140");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo14);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo14, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.EUR, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(20000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "ユーロ", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(60), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(60), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(11000), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000145", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "12050", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "12076", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "12080", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "12090", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "12120", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "12130", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(170), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(170), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), BizDate.valueOf(20200101), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(170), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(170), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(150), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(160), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(170), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(150), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(160), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(170), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12205", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12207", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12353", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_D15() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000150");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo15);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo15, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(11000), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(50), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getTsinyno(), "2345678", "通信先郵便番号");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr2kj(), "通信先住所２漢字２", "通信先住所２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTsinadr3kj(), "通信先住所３漢字２", "通信先住所３（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名漢字４", "送付先名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getTnknmissmsg(), "", "転換ミスメッセージ");
        exStringEquals(hokenSyoukenLst.get(0).getErrormsgcd(), "", "エラーメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSisyacd(), "111", "支社コード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrntousaadrmsgcd(), "10010", "同封通信欄当社住所メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000156", "同封通信欄証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getChannelcd(), C_Channelcd.BLNK, "チャネルコード");
        exStringEquals(hokenSyoukenLst.get(0).getDairitenmidasikbn(), "01", "代理店見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm1kj(), "", "代理店名１（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getDrtennm2kj(), "", "代理店名２（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getAisatumsgcd(), "10020", "挨拶メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getCcmsgcd(), "10030", "コールセンターメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHskmsgcd(), "10040", "補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounymsgcd(), "11010", "保障内容メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名漢字４", "保障内容被保険者名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd1(), "", "死亡保障第３保険期間メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboudai3hknkknmsgcd2(), "", "死亡保障第３保険期間メッセージコード２");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 1, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), BizDate.valueOf(20170831), "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(0), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 9, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), BizDate.valueOf(20220831), "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(180), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(180), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(50), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(60), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(70), "第１死亡保険金額為替レート（円安）");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu01(), 1, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyoukenLst.get(0).getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyoukenLst.get(0).getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s02(), BizCurrency.valueOf(0), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s03(), BizCurrency.valueOf(0), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s04(), BizCurrency.valueOf(0), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s05(), BizCurrency.valueOf(0), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s06(), BizCurrency.valueOf(0), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s07(), BizCurrency.valueOf(0), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s08(), BizCurrency.valueOf(0), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s09(), BizCurrency.valueOf(0), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1s10(), BizCurrency.valueOf(0), "第１死亡保険金額１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype02(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype03(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype04(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype05(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype06(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype07(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype08(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype09(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktype10(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka01(), BizCurrency.valueOf(180), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendaka10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円高）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun01(), BizCurrency.valueOf(180), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyun10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（中央値）１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu01(), BizCurrency.valueOf(180), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu02(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu03(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu04(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu05(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu06(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu07(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu08(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu09(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasu10(), BizCurrency.valueOf(0), "第１死亡保険金額（円貨）（円安）１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1shuryo(), BizCurrency.valueOf(1000), "第１死亡保険金額（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyendakahuryo(), BizCurrency.valueOf(180), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(180), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1syenyenyasuhuryo(), BizCurrency.valueOf(180), "第１死亡保険金額（円貨）（円安）（不慮）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(180), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(1000), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(150), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(160), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(170), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(150), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(160), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(170), "第３死亡保険金額（円貨）（円安）");
        exStringEquals(hokenSyoukenLst.get(0).getSibouinjiptnkbn(), "", "死亡保障印字パターン");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12203", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd1(), "12331", "死亡給付金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd2(), "12351", "死亡給付金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd3(), "", "死亡給付金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd4(), "", "死亡給付金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd5(), "", "死亡給付金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd6(), "", "死亡給付金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd7(), "", "死亡給付金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd8(), "", "死亡給付金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd9(), "", "死亡給付金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getSiboukyuuhukinmsgcd10(), "", "死亡給付金メッセージコード１０");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_D16() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000160");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo16);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo16, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12213", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_D17() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000170");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo17);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo17, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12215", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_D18() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000180");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo18);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo18, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12213", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_D19() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000190");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo19);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo19, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12215", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_D20() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000200");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo20);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo20, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12221", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_D21() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000210");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo21);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo21, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12223", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_D22() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000220");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo22);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo22, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12220", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_D23() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000230");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo23);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo23, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12221", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(240)
    public void testEditTBL_D24() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000240");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo24);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo24, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12223", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(250)
    public void testEditTBL_D25() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000250");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo25);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo25, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(260)
    public void testEditTBL_D26() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000260");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo26);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo26, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(270)
    public void testEditTBL_D27() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000270");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo27);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo27, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12225", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(280)
    public void testEditTBL_D28() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000280");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo28);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo28, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12227", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(290)
    public void testEditTBL_D29() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000290");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo29);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo29, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12214", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(300)
    public void testEditTBL_D30() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000300");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo30);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo30, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12225", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(310)
    public void testEditTBL_D31() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000310");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo31);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo31, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12227", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(320)
    public void testEditTBL_D32() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000320");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo32);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo32, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12228", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(330)
    public void testEditTBL_D33() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000330");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo33);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo33, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12229", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(340)
    public void testEditTBL_D34() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000340");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo34);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo34, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12220", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(350)
    public void testEditTBL_D35() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000350");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo35);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo35, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12228", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(360)
    public void testEditTBL_D36() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000360");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo36);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo36, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "12229", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "12220", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
    @Test
    @TestOrder(370)
    public void testEditTBL_D37() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000370");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo37);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo37, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }

    @Test
    @TestOrder(380)
    public void testEditTBL_D38() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000000000380");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo38);

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo38, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd1(), "12201", "年金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd2(), "", "年金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd3(), "", "年金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd4(), "", "年金メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd5(), "", "年金メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd6(), "", "年金メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd7(), "", "年金メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd8(), "", "年金メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd9(), "", "年金メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getNkmsgcd10(), "", "年金メッセージコード１０");
    }
}